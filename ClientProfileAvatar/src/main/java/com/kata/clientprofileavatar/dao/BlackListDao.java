package com.kata.clientprofileavatar.dao;

import com.kata.clientprofileavatar.entity.BlackList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BlackListDao {
    void addBlackList(MultipartFile file, String typeBlackList);

    List<BlackList> getListOfAllBlackList();

    BlackList getOneBlackListId(Integer id);
    void deleteOneBlackList(Integer id);
    <T, String> T checkOfNullEndLimitedID(T t, String nameT);
}
