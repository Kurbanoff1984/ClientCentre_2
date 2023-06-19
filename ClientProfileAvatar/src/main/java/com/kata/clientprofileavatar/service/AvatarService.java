package com.kata.clientprofileavatar.service;

import com.kata.clientprofileavatar.entity.Avatar;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public interface AvatarService {
    Avatar getAvatarById(Integer id);

    void addAvatar(MultipartFile file) throws IOException;
    List<Avatar> getListOfAvatars();
    public Avatar getUserByAvatarUUID(String username);
}
