package com.kata.clientprofileavatar.service;

import com.kata.clientprofileavatar.entity.Avatar;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AvatarService {
    Avatar getAvatarById(Integer id);

    List<Avatar> getListOfAvatars();
    Avatar getByAvatarUUID(String username);
    @Transactional
    void deleteAvatarById(Integer id);
    @Transactional
    void updateAvatar(MultipartFile file, Integer id);
    //2

    List<Avatar> getListAvatarsByProfileIdentification(String profileIdentification);
    void addAvatarActive(MultipartFile file,String profileIdentification,boolean active);
    @Transactional
    void updateAvatarActive(MultipartFile file, Integer id, boolean active);
    Avatar getAvatarByIdAndActive(String profileIdentification);
    @Transactional
    void deleteAvatarByProfileIdentification(String profileIdentification);
    @Transactional
    void updateActive(Integer id, boolean active);
    @Transactional
    public List<Avatar> getDuplicateAvatars(MultipartFile file);
    int сheckPercentDuplicateAvatars(MultipartFile file, String profileIdentification);
}
