package com.kata.clientprofileavatar.service;

import com.kata.clientprofileavatar.dao.AvatarDao;
import com.kata.clientprofileavatar.dao.BlackListDao;
import com.kata.clientprofileavatar.entity.BlackList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class BlackListServiceImp implements BlackListService {
    private final BlackListDao blackListDao;

    @Override
    @Transactional
    public void addBlackList(MultipartFile file, String typeBlackList) {
        blackListDao.addBlackList(file, typeBlackList);
    }


    @Override
    @Transactional
    public List<BlackList> getListOfAllBlackList() {
        return blackListDao.getListOfAllBlackList();

    }


    @Override
    public BlackList getOneBlackListId(Integer id) {
        return blackListDao.getOneBlackListId(id);
    }

    @Override
    public void deleteOneBlackList(Integer id) {
        blackListDao.deleteOneBlackList(id);
    }
}
