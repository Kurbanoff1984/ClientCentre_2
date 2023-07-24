package com.kata.clientprofilefacade.controller;

import com.kata.clientprofilefacade.service.ProfileAvatarService;
import com.kata.clientprofilefacade.util.AvatarUrls;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.kata.clientprofileavatar.entity.Avatar;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * This controller class refers to the microservice ClientProfileAvatar
 */
@RestController
@RequestMapping("/api/avatars")
@AllArgsConstructor
@Builder
public class AvatarController {

    private final ProfileAvatarService profileAvatarService;


    /**
     * This method refers to the ClientProfileAvatar microservice to create an avatar
     */
    @PostMapping(path = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Сохранение в БД аватара")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Изображение для сохранения отсутствует")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> save(@RequestParam("file") MultipartFile file,
                                      @RequestParam("profileIdentification") String profileIdentification,
                                      @RequestParam("active") boolean active,
                                      HttpServletRequest request) throws IOException {
        return profileAvatarService.performAvatarOperation(file,null, profileIdentification,null,active, AvatarUrls.SAVE, HttpMethod.POST,(Class<T>)void.class, request, "Avatar_Save");
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to update an avatar
     */
    @PatchMapping(path = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Замена изображения в БД")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Обновления изображения с id прошло неудачно")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> updateAvatar(@RequestParam("file") MultipartFile file,
                                              @RequestParam("id") Integer id,
                                              HttpServletRequest request) throws IOException {
        return  profileAvatarService.performAvatarOperation(file,id,null,null,null,AvatarUrls.UPDATE, HttpMethod.PATCH,(Class<T>)HttpStatus.class, request, "Avatar_Update");
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to update and active avatar
     */
    @PatchMapping(path = "/updateAvatarAndActive", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Замена изображения в БД и присвоение активности")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Обновления изображения с id прошло неудачно")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> updateAvatarActive(@RequestParam("file") MultipartFile file,
                                                    @RequestParam("id") Integer id,
                                                    @RequestParam("active") boolean active,
                                                    HttpServletRequest request) throws IOException {
        return profileAvatarService.performAvatarOperation(file,id,null,null,active,AvatarUrls.UPDATE_AVATAR_AND_ACTIVE,HttpMethod.PATCH, (Class<T>) HttpStatus.class, request, "Avatar_UpdateAvatarAndActive");
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to update active avatar
     */
    @PatchMapping("/updateActive")
    @Operation(summary = "Изменение активности аватара")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Обновления изображения с id прошло неудачно")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> updateActive(@RequestParam("id") Integer id,
                                              @RequestParam("active") boolean active,
                                              HttpServletRequest request) throws IOException {
        return profileAvatarService.performAvatarOperation(null,id,null,null,active,AvatarUrls.UPDATE_ACTIVE,HttpMethod.PATCH, (Class<T>) HttpStatus.class, request, "Avatar_UpdateActive");
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to get avatar by id
     */
    @GetMapping("/getAvatarById")
    @Operation(summary = "Получить аватар по его id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Изображение с таким id не найден")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> getAvatarById(@RequestParam("id") Integer id,
                                               HttpServletRequest request) throws IOException {
        return profileAvatarService.performAvatarOperation(null,id,null,null,null,AvatarUrls.GET_AVATAR_BY_ID,HttpMethod.GET,(Class<T>) String.class, request, "Avatar_GetAvatarById");
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to get avatar by uuid
     */
    @GetMapping("/getAvatarByUuid")
    @Operation(summary = "Получить аватар по его uuid")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Изображение с таким uuid не найден")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> getAvatarByUuid(@RequestParam("uuid") String uuid,
                                                 HttpServletRequest request) throws IOException {
        return profileAvatarService.performAvatarOperation(null,null,null,uuid, null,AvatarUrls.GET_AVATAR_BY_UUID,HttpMethod.GET,(Class<T>) String.class, request, "Avatar_GetAvatarByUuid");
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to get active avatar by PI
     */
    @GetMapping("/getActiveAvatarByProfileIdentification")
    @Operation(summary = "Получить активный аватар по его profileIdentification")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Изображение с таким id не найден")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> getActiveAvatarByProfileIdentification(@RequestParam("profileIdentification") String profileIdentification,
                                                                        HttpServletRequest request) throws IOException {
        return profileAvatarService.performAvatarOperation(null,null,profileIdentification,null,null,AvatarUrls.GET_ACTIVE_AVATARS_BY_PI,HttpMethod.GET,(Class<T>) String.class, request, "Avatar_GetActiveAvatarByPI");
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to get avatars by PI
     */
    @GetMapping("/getAvatarsByProfileIdentification")
    @Operation(summary = "Получить лист аватаров по profileIdentification")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Получение изображения по идентификатору + profileIdentification прошло неудачно")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> getAvatarsByProfileIdentification(@RequestParam("profileIdentification") String profileIdentification,
                                                                   HttpServletRequest request) throws IOException {
        return profileAvatarService.performAvatarOperation(null,null,profileIdentification,null,null,AvatarUrls.GET_AVATARS_BY_PI,HttpMethod.GET,(Class<T>) List.class, request, "Avatar_GetAvatarsByPI");
    }

    /**
     * This method accesses the ClientProfileAvatar microservice to remove the avatar by id
     */
    @DeleteMapping("/deleteAvatarById")
    @Operation(summary = "Удалить аватар по его id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Удаление изображения с id прошло неудачно")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> deleteAvatarById(@RequestParam("id") Integer id,
                                                  HttpServletRequest request) throws IOException {
        return profileAvatarService.performAvatarOperation(null,id,null,null,null,AvatarUrls.DELETE_AVATAR_BY_ID,HttpMethod.DELETE,(Class<T>) HttpStatus.class, request, "Avatar_DeleteAvatarById");
    }

    /**
     * This method accesses the ClientProfileAvatar microservice to remove the active avatar by PI
     */
    @DeleteMapping("/deleteActiveAvatarByProfileIdentification")
    @Operation(summary = "Удалить активный аватар по его PI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Avatar.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Удаление изображения прошло неудачно")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public <T> ResponseEntity<T> deleteActiveAvatarByProfileIdentification(@RequestParam("profileIdentification") String profileIdentification,
                                                                           HttpServletRequest request) throws IOException {
        return profileAvatarService.performAvatarOperation(null,null,profileIdentification,null,null,AvatarUrls.DELETE_ACTIVE_AVATAR_BY_PI, HttpMethod.DELETE,(Class<T>) HttpStatus.class, request, "Avatar_DeleteActiveAvatarByPI");
    }

}
