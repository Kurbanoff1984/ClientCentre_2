package org.kata.clientprofileloader.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileloader.service.AvatarService;
import org.kata.entity.individual.Address;
import org.kata.entity.individual.Avatar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "Аватар клиента", description = "Методы для работы с аватаром клиента")
@RequestMapping("/api/client/avatar")
public class AvatarController {
    private final AvatarService avatarService;

    @Operation(summary = "Получение аватара клиента", description = "Получает аватар клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Аватар успешно получен", response = Address.class),
            @ApiResponse(code = 404, message = "Аватар не найден")})
    @GetMapping("/getAvatar/{icp}")
    public ResponseEntity<Avatar> getClientAvatar(@PathVariable String icp) {
        log.info("Получение аватара для клиента с icp: {}", icp);
        Optional<Avatar> avatar = avatarService.getClientAvatar(icp);
        if (avatar.isPresent()) {
            log.info("Аватар найден для клиента с UUID: {}", icp);
            return new ResponseEntity<>(avatar.get(), HttpStatus.OK);
        } else {
            log.info("Аватар не найден для клиента с UUID: {}", icp);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Добавить аватара клиента", description = "Добавляет новый аватар")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Аватар успешно добавлен", response = Address.class),
            @ApiResponse(code = 404, message = "Аватар не добавлен")})
    @PostMapping("/postAvatar/{icp}")
    public ResponseEntity<Avatar> addClientAvatar(@PathVariable String icp, @RequestBody Avatar avatar) {
        log.info("Аватар успешно добавлен для клиента с icp: {}", icp);
        return new ResponseEntity<>(avatarService.addClientAvatar(icp, avatar), HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление аватара клиента", description = "Обновление аватар клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Аватар успешно обнволен", response = Address.class),
            @ApiResponse(code = 404, message = "Аватар не обновлен")})
    @PutMapping("/putAvatar/{icp}")
    public ResponseEntity<Avatar> updateClientAvatar(@PathVariable String icp, @RequestBody Avatar updatedAvatar) {
        log.info("Обновление аватара для клиента с icp: {}", icp);
        log.info("Аватар успешно обновлен для клиента с icp: {}", icp);
        return new ResponseEntity<>(avatarService.updateClientAvatar(updatedAvatar), HttpStatus.OK);
    }

    @Operation(summary = "Удаление аватара клиента", description = "Удаляет аватар клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Аватар успешно удален", response = Address.class),
            @ApiResponse(code = 404, message = "Аватар не удален")})
    @DeleteMapping("/deleteAvatar/{icp}")
    public ResponseEntity<Void> deleteClientAvatar(@PathVariable String icp) {
        log.info("Удаление аватара для клиента с icp: {}", icp);
        if (avatarService.deleteClientAvatar(icp)) {
            log.info("Аватар успешно удален для клиента с icp: {}", icp);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.info("Аватар не найден для клиента с icp: {}", icp);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

