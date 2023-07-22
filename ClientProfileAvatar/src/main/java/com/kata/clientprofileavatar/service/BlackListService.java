package com.kata.clientprofileavatar.service;

import com.kata.clientprofileavatar.entity.BlackList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BlackListService {
    void addBlackList(MultipartFile file, String typeBlackList);

    List<BlackList> getListOfAllBlackList();

    BlackList getOneBlackListId(Integer id);
    void deleteOneBlackList(Integer id);
}
