## Reference Documentation

модуль ClientProfileCommon - модуль который содержит в себе сущности для использования во всех микросервисах для достижения
консистентности при маштабировании и взаимодействии

### Изменения в МКС ClientProfileCommon
* [14.05.2022]
  add documentation, добавлен интерфейс IndividualService который реализует работу для использования в IndividualController
 метод которого создает пользователя и назначет ему поля имя и фамилию, и при вызове метода 
GET http://localhost:8080/individual/getClient в ответ получаем 
{
  "name": "Ilia",
  "surname": "Test"
  }
* [15.06.2023]
  В рамках задачи 9 была добавлена реализация REST API RestTemplateService для общения ProfileService и ProfileLoader
  (GET, POST, PUT, DELETE). В модуль ProfileCommon был добавлен обработчик ошибок ExceptionRestController, возникающих при обработке запросов 
  ко всем микросервисам. 
* [23.06.2023]
  В рамках задачи 18 была построена логика по заполнению БД тестовыми данными. Логика реализована посредством REST API TestDataInitializer
  и end-point'а /testData/get, метод которого принимает количество создаваемых тестовых объектов count, а возвращает сообщение об успешном создании
  n-ого количества объектов с последующей отправкой в топик TestUsers.
  Вызов GET http://localhost:8080/service-app/api/testData/get?count=10 вернет 
  {"Successful creation of test data, count objects: 10"}
* [30.06.2023]
  В рамках задачи 21 был реализован механизм валидации входных данных отправляемых в БД согласно ТЗ.
  Механизм состоит из набора кастомных аннотаций из пакета org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation, 
  главного валидирующего интерфейса ParamValidator и набора классов - валидаторов реализющих интерфейс FieldValidator для каждой аннотации.
  Механизм внедряется в контроллеры посредством класса аспекта MethodParamValidationAspect, для метода которого, тригером является аннотация @ValidParams.
  (конкретные моменты реализации см. java doc)
* [14.07.2023]
  В рамках задачи 28 была продумана логика по верификации статуса пользователя, реализованная с помощью end-point'а /status из контроллера StatusController.
  В контроллере осуществляется предварительная проверка на необходимость смены статуса (см. java-doc) StatusVerificationServiceImpl. 
  Если пользователь с icp 13 существует то 
  GET http://localhost:8080/service-app/api/status/getStatus?icp=13 вернет список недостающих документов до статуса CLIENT.  
  Если пользователь с icp 13 не существует то
  GET http://localhost:8080/service-app/api/status/getStatus?icp=13 вернет:
  { 
    "text": "Пользователя с таким icp = 0 не существует", 
    "date": "2023-07-17 13:19:04", 
    "httpStatus": "BAD_REQUEST", 
    "code": 400 
  }
  
  