package com.kata.clientprofileavatar.dao;

import com.kata.clientprofileavatar.entity.Avatar;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AvatarDao {
    Avatar getAvatarById(Integer id);

    void addAvatar(MultipartFile file) throws IOException;
    List<Avatar> getListOfAvatars();
    public Avatar getUserByAvatarUUID(String username);
}
