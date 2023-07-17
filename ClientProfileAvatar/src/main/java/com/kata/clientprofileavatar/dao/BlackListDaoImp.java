package com.kata.clientprofileavatar.dao;

import com.kata.clientprofileavatar.entity.BlackList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class BlackListDaoImp implements BlackListDao{
    @PersistenceContext
    private final EntityManager entityManager;


    //методы сохранения
    @SneakyThrows
    @Override
    @Transactional
    public void addBlackList(MultipartFile file, String typeBlackList) {
        checkOfNullEndLimitedID(typeBlackList,typeBlackList);
        BlackList blackList= BlackList.builder().byteSize(file.getBytes()).typeBlackList(typeBlackList).build();
        entityManager.merge(blackList);

    }

    //гет методы
    @Override
    public List<BlackList> getListOfAllBlackList() {
        log.info("получение лблек листа");
        List<BlackList>blackList=entityManager.createQuery("select blackList from BlackList blackList", BlackList.class).getResultList();
        if (blackList!=null){
            return blackList;
        } else {
            throw new NoResultException("BlackList ненайден");
        }
    }

    @Override
    @Transactional
    public BlackList getOneBlackListId(Integer id) {
        log.info("id переданно для поиска по БД");
        checkOfNullEndLimitedID(id,id);
        BlackList blackList=entityManager.find(BlackList.class,id);
        if (blackList!=null){
            return blackList;
        } else {
            throw new NoResultException("BlackList c id = "+id+"ненайден");
        }
    }
    //методы очистки блеклиста

    @Override
    @Transactional
    public void deleteOneBlackList(Integer id){
        checkOfNullEndLimitedID(id,"ID");
        log.info("удалениеизоброжения из блек листа");
        try {
            entityManager.remove(getOneBlackListId(id));
        } catch (RuntimeException e) {
            throw new RuntimeException("удаление прошло неудачно"+e);
        }

    }
    //спец методы проверки
    public  <T, String> T checkOfNullEndLimitedID(T t, String nameT){
        if (t != null && !(t instanceof Integer)) {
            return t;
        } else if ((t instanceof Integer)&&(int) t > 0) {
                return t;
        } else {
            throw new NoResultException("Переданно недопустимое значение " + nameT + " = " + t);
        }
    }
}
