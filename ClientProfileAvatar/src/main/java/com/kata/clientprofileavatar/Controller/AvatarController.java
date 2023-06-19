package com.kata.clientprofileavatar.Controller;


import com.kata.clientprofileavatar.entity.Avatar;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.kata.clientprofileavatar.service.AvatarService;
import java.io.IOException;

@RestController
@RequestMapping("/avatars")
@AllArgsConstructor
public class AvatarController {
    private final AvatarService service;

    @PostMapping("/add")
    public void saveAvatar(@RequestParam("file") MultipartFile avatar) throws IOException {
        if (avatar.getSize() != 0) {
            service.addAvatar(avatar);
        } else {
            throw new IOException("изображение для сохранения отсутствует");
        }
    }

    @GetMapping("/get/")
    public ResponseEntity<?> getAvatar(@RequestParam Integer id) {
        try {
            Avatar avatar = service.getAvatarById(id);
            return new ResponseEntity<>(avatar, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Изображение с " + id + " не найден");
        }
    }

    @GetMapping("/get/UUID/")
    public ResponseEntity<?> productInfo(@RequestParam String uuid) {
        try {
            Avatar avatar = service.getUserByAvatarUUID(uuid);
            return new ResponseEntity<>(avatar, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Изображение с " + uuid + " не найден");
        }
    }
}
