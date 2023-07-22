package com.kata.clientprofileavatar.service;

import com.kata.clientprofileavatar.dao.AvatarDao;
import com.kata.clientprofileavatar.entity.Avatar;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class AvatarServiceImpl implements AvatarService {
    private final AvatarDao avatarDao;

    @Override
    @Transactional
    public Avatar getAvatarById(Integer id) {
        return avatarDao.getAvatarById(id);
    }

    @Override
    public List<Avatar> getListOfAvatars() {
        return avatarDao.getListOfAvatars();
    }

    @Override
    @Transactional
    public Avatar getByAvatarUUID(String uuid) {
        return avatarDao.getByAvatarUUID(uuid);
    }

    @Override
    @Transactional
    public void deleteAvatarById(Integer id) {
        avatarDao.deleteAvatarById(id);
    }

    @Override
    @Transactional
    public void updateAvatar(MultipartFile file, Integer id) {
        avatarDao.updateAvatar(file,id);
    }

    //2

    @Override
    public List<Avatar> getListAvatarsByProfileIdentification(String profileIdentification) {
        return avatarDao.getListAvatarsByProfileIdentification(profileIdentification);
    }

    @Override
    public void addAvatarActive(MultipartFile file, String profileIdentification, boolean active) {
        avatarDao.addAvatarActive(file,profileIdentification,active);
    }

    @Override
    public void updateAvatarActive(MultipartFile file, Integer id, boolean active) {
        avatarDao.updateAvatarActive(file, id, active);
    }

    @Override
    public Avatar getAvatarByIdAndActive(String profileIdentification) {
        return avatarDao.getAvatarByProfileIdentificationAndActive(profileIdentification);
    }

    @Override
    public void deleteAvatarByProfileIdentification(String profileIdentification) {
        avatarDao.deleteAvatarByProfileIdentification(profileIdentification);
    }

    @Override
    public void updateActive(Integer id, boolean active) {
        avatarDao.updateActive(id,active);
    }
    @Override
    public List<Avatar> getDuplicateAvatars(MultipartFile file){
       return avatarDao.getDuplicateAvatars(file);
    }

    @Override
    public int сheckPercentDuplicateAvatars(MultipartFile file, String profileIdentification) {
        return avatarDao.сheckPercentDuplicateAvatars(file,profileIdentification);
    }
    @Override
    @Transactional
    public MultipartFile checkBlackList(MultipartFile file,String profileIdentification) {
        return avatarDao.checkBlackList(file,profileIdentification);
    }
    @Override
    @Transactional
    public void clearBlackListUser(){
        avatarDao.clearBlackListUser();
    }

}
