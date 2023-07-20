package com.kata.clientprofileavatar.dao;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.kata.clientprofileavatar.entity.Avatar;
import com.kata.clientprofileavatar.entity.BlackList;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class AvatarDaoImp implements AvatarDao {
    @PersistenceContext
    private final EntityManager entityManager;
    private final BlackListDao blackListDao;
    private List<String> profileIdentificationBlackList;

    //методы сохранения аватара
    @Transactional
    public void addAvatarActive(MultipartFile file, String profileIdentification, boolean active) {
        blackListDao.checkOfNullEndLimitedID(profileIdentification,"ProfileIdentification");
            creatAvatarAdd(checkBlackList(file,profileIdentification), new Avatar(), active, profileIdentification);
    }

    //методы изменения аватара
    @Override
    public void updateAvatar(MultipartFile file, Integer id) {
        blackListDao.checkOfNullEndLimitedID(id,"ID");
            Avatar avatar=getAvatarById(id);
            log.info("Аватар из базы получен");
            creatAvatarAdd(checkBlackList(file, avatar.getProfileIdentification()),avatar, avatar.isActive(),null);
    }
    public void updateAvatarActive(MultipartFile file, Integer id, boolean active) {
        blackListDao.checkOfNullEndLimitedID(id,"ID");
            log.info("Аватар из базы получен");
            Avatar avatar=getAvatarById(id);
            creatAvatarAdd(checkBlackList(file, avatar.getProfileIdentification()), avatar, active,null);
    }


    public void updateActive(Integer id, boolean active) {
        blackListDao.checkOfNullEndLimitedID(id,"ID");
            Avatar avatar = getAvatarById(id);
            log.info("Аватар из базы получен");
            avatar.setActive(active);
            creatAvatarAdd(null, avatar, active,null);
    }

    // методы получения аватара
    @Override
    @Transactional
    public Avatar getAvatarById(Integer id) {
            log.info("id переданно для поиска по БД");
            Avatar avatar=id!=null?entityManager.find(Avatar.class, id):new Avatar();
            return avatar;

    }

    @Override
    public List<Avatar> getListOfAvatars() {
        return entityManager.createQuery("select avatar from Avatar avatar", Avatar.class).getResultList();
    }

    @Override
    @Transactional
    public Avatar getByAvatarUUID(String uuid) {
        blackListDao.checkOfNullEndLimitedID(uuid,"uuid");
        log.info("uuid переданно для поиска по БД");
        Query query = entityManager.createQuery("select avatar from Avatar avatar where avatar.uuid = :uuid", Avatar.class);
        query.setParameter("uuid", uuid);
        log.info("Аватар из базы получен");
        return (Avatar) query.getSingleResult();
    }

    @Override
    public List<Avatar> getListAvatarsByProfileIdentification(String profileIdentification) {
        blackListDao.checkOfNullEndLimitedID(profileIdentification,"ProfileIdentification");
        log.info("Производится поиск совподений в БД по идентификатору " + profileIdentification);
        List<Avatar> resultAvatar = entityManager.createQuery("select avatar from Avatar avatar where avatar.profileIdentification = :profileIdentification", Avatar.class)
                .setParameter("profileIdentification", profileIdentification).getResultList();
        if (resultAvatar.size() != 0) {
            log.info("Изображение с идентификатором " + profileIdentification + " получено");
        } else {
            log.info("Совподения не найдены");
            throw new NoResultException("Поиск по идентификатору: " + profileIdentification + " невозможен");
        }
        return resultAvatar;
    }

    public List<Avatar> getAvatarByActiveAndProfileIdentification(String profileIdentification, boolean active) {
        blackListDao.checkOfNullEndLimitedID(profileIdentification,"ProfileIdentification");
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            log.info("Формирование запроса  для поиска");
            CriteriaQuery<Avatar> query = builder.createQuery(Avatar.class);
            Root<Avatar> root = query.from(Avatar.class);
            log.info("Поиск Аватара по статусу и идентификатору пользователя");
            query.select(root).where(builder.equal(root.get("active"), active), builder.equal(root.get("profileIdentification"), profileIdentification));
            TypedQuery<Avatar> typedQuery = entityManager.createQuery(query);
            log.info("Данные получены");
            return typedQuery.getResultList();


    }
    @Override
    public Avatar getAvatarByProfileIdentificationAndActive(String profileIdentification) {
        blackListDao.checkOfNullEndLimitedID(profileIdentification,"ProfileIdentification");
            log.info("Формирование запроса  для поиска");
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Avatar> query = builder.createQuery(Avatar.class);
            Root<Avatar> root = query.from(Avatar.class);
            query.select(root).where(builder.equal(root.get("active"), true), builder.equal(root.get("profileIdentification"), profileIdentification));
            log.info("Поиск Аватара по статусу Тру");
            try {
                log.info("Данные получены");
                TypedQuery<Avatar> typedQuery = entityManager.createQuery(query);
                return typedQuery.getSingleResult();
            } catch (NoResultException e) {
                throw new NoResultException("Активные аватары отсутствуют");
            }
    }

    //Методы удаления аватара
    @Override
    public void deleteAvatarById(Integer id) {
        blackListDao.checkOfNullEndLimitedID(id,"ID");
            log.info("аватар направлен на удаление");
            Avatar avatar = getAvatarById(id);
            log.info("аватар удален");
            entityManager.remove(avatar);
            refactorOfDeleteActivity(avatar);
    }
    @Override
    public void deleteAvatarByProfileIdentification(String profileIdentification) {
        blackListDao.checkOfNullEndLimitedID(profileIdentification,"ProfileIdentification");
            log.info("аватар направлен на удаление");
            Avatar avatar = getAvatarByProfileIdentificationAndActive(profileIdentification);
            entityManager.remove(avatar);
            log.info("аватар удален");
            refactorOfDeleteActivity(avatar);
    }
    @Override
    public void deleteAvatarListOfProfileBannet(String profileIdentification) {
        List<Avatar>avatarList=getListAvatarsByProfileIdentification(profileIdentification);
        log.info("Иницировано удаление аватаров профиля");
        if (avatarList.size()!=0) {
            for (Avatar avatar : avatarList) {
                entityManager.remove(avatar);
            }
        } else {
            log.info("Вбазе данных отсутствуют аватары с привязкой к этому профилю");
        }
    }

    //Метод поиска аналагичных аватаров
    @Override
    public List<Avatar> getDuplicateAvatars(MultipartFile file) {
        try {
           String md5 = String.valueOf(Hashing.md5().hashString(Arrays.toString(file.getBytes()), Charsets.UTF_8));
            log.info("Производится поиск совподений в БД по Аватару ");
            List<Avatar> resultAvatar = entityManager.createQuery("select avatar from Avatar avatar where avatar.md5 = :md5", Avatar.class)
                    .setParameter("md5", md5).getResultList();
            if (resultAvatar.size() != 0) {
                log.info("Анологичные изображения получены");
            } else {
                log.info("Совподения не найдены");
            }
            return resultAvatar;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Integer сheckPercentDuplicateAvatars(MultipartFile file, String profileIdentification) {
        try {
            byte[] imageOriginal = getAvatarByProfileIdentificationAndActive(profileIdentification).getByteSize();
            log.info("Изображение из бд получено");
            byte[] imageDuplicate = file.getBytes();
            log.info("мультифаил приобразован");
            double multiPixel = 0.0;
            double originalPixel = 0.0;
            double duplicatePixel = 0.0;
            for (int i = 0; i < imageOriginal.length; i++) {
                int pixelOriginal = imageOriginal[i] & 0xff;
                int pixelDuplicate = imageDuplicate[i] & 0xff;
                multiPixel += pixelOriginal * pixelDuplicate;
                originalPixel += pixelOriginal * pixelOriginal;
                duplicatePixel += pixelDuplicate * pixelDuplicate;
            }
            Integer result = (int) (multiPixel / (Math.sqrt(originalPixel) * Math.sqrt(duplicatePixel)) * 100);
            log.info("процент определен");
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public MultipartFile checkBlackList(MultipartFile file,String profileIdentification){
        blackListDao.checkOfNullEndLimitedID(profileIdentification,profileIdentification);
        if (true!= filterBlockUserBlackList(profileIdentification)){
            throw new NoResultException("пользователь был забанен");
        }
        log.info("Фильтрация запущена");
        byte[] imageDuplicate = file.getBytes();
        for (BlackList blackList:blackListDao.getListOfAllBlackList()){
            log.info("Из базы получен объект с id = "+blackList.getId());
            byte[] imageOriginal = blackList.getByteSize();
            double multiPixel = 0.0;
            double originalPixel = 0.0;
            double duplicatePixel = 0.0;
            for (int i = 0; i < imageOriginal.length; i++) {
                int pixelOriginal = imageOriginal[i] & 0xff;
                int pixelDuplicate = imageDuplicate[i] & 0xff;
                multiPixel += pixelOriginal * pixelDuplicate;
                originalPixel += pixelOriginal * pixelOriginal;
                duplicatePixel += pixelDuplicate * pixelDuplicate;
            }
            Integer result = (int) (multiPixel / (Math.sqrt(originalPixel) * Math.sqrt(duplicatePixel)) * 100);
            log.info("Проверка совподений в % = "+result);
            if (result>70&&blackList.getTypeBlackList().equals("List1")) {
                log.info("fewfwf");
                throw new NoResultException("данный материал не корректный повторите загрузку");
            } else if (result>70&&blackList.getTypeBlackList().equals("List2")){
                deleteAvatarListOfProfileBannet(profileIdentification);
                banetUser(profileIdentification);
                log.info("Проверка совподений в % = "+result);
                break;
            }

        }

            return file;
    }
    private void banetUser(String profileIdentification){
        // когла будет сделана ручка заменим на ее вызов
        profileIdentificationBlackList.add(profileIdentification);
        log.error("Пользователь забанен");
    }
    //Внутриние мотоды обработки
    private void refactorOfDeleteActivity(Avatar avatar) {
        if (avatar.isActive() == true && getListAvatarsByProfileIdentification(avatar.getProfileIdentification()).size() != 0) {
            getListAvatarsByProfileIdentification(avatar.getProfileIdentification()).get(0).setActive(true);
            log.info("активный аватар заменен");
        }
    }

    private void refactorActivity(Avatar avatar) {
        List<Avatar> avatarList = getAvatarByActiveAndProfileIdentification(avatar.getProfileIdentification(), avatar.isActive());
        if (avatarList.size() != 0 && avatar.isActive() == true) {
            for (Avatar avatar1 : avatarList) {
                avatar1.setActive(false);
                entityManager.merge(avatar1);
            }
            log.info("активный аватар заменен");
        }
    }

    private void creatAvatarAdd(MultipartFile file, Avatar avatar, boolean active, String profileIdentification) {
        if (filterBlockUserBlackList(avatar.getProfileIdentification()!=null?avatar.getProfileIdentification():profileIdentification)) {
            log.info("Данные для формирования аватара получены");
            try {
                Avatar avatarUpdate = Avatar.builder()
                        .uuid(avatar == null ? avatar.getUuid() : UUID.randomUUID().toString())
                        .name(file == null ? avatar.getName() : file.getOriginalFilename())
                        .fileSize(file == null ? avatar.getFileSize() : (int) file.getSize())
                        .byteSize(file == null ? avatar.getByteSize() : file.getBytes())
                        .profileIdentification(profileIdentification == null ? avatar.getProfileIdentification() : profileIdentification)
                        .active(active)
                        .md5(file == null ? avatar.getMd5() : String.valueOf(Hashing.md5().hashString(Arrays.toString(file.getBytes()), Charsets.UTF_8)))
                        .id(avatar.getId())
                        .build();
                log.info("преобразования мультифайла прошло успешно");
                refactorActivity(avatarUpdate);
                entityManager.merge(avatarUpdate);
                log.info("Данные по Аватару сохранены в БД");
            } catch (IOException e) {
                throw new RuntimeException("Сохранение аватара прошло неудачно");
            }
        } else {
            log.error("пользователь забанен");
        }
    }
    //Методы проверки блек листа
    public boolean filterBlockUserBlackList(String profileIdentification){
        log.info("Проверка пользователя на бан");
        for (String checkFilter:profileIdentificationBlackList){
            if (checkFilter.equals(profileIdentification)){
                return false;
            }
        }
        log.info("Проверка пользователя на бан пройдена");
        return true;
    }
    @Override
    public void clearBlackListUser(){
        log.info("очистка списка забаненых");
        profileIdentificationBlackList.clear();

    }
}
