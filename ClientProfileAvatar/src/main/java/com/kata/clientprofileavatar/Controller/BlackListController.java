package com.kata.clientprofileavatar.Controller;

import com.kata.clientprofileavatar.entity.BlackList;
import com.kata.clientprofileavatar.service.AvatarService;
import com.kata.clientprofileavatar.service.BlackListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/BlackList")
@Tag(name = "Контроллеры BlackList", description = "методы для работы с BlackList")
@AllArgsConstructor
public class BlackListController {
    private final BlackListService blackListService;
    private final AvatarService avatarService;
    @PostMapping(path = "/addBlackList1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "сохранение изображения в BlackList")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BlackList.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "изображение для сохранения отсутствует")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public void saveBlackList1(@RequestParam("file") MultipartFile file) {
        blackListService.addBlackList(file, "List1");
    }
    @PostMapping(path = "/addBlackList2", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "сохранение изображения в BlackList")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BlackList.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "изображение для сохранения отсутствует")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public void saveBlackList2(@RequestParam("file") MultipartFile file) {
        blackListService.addBlackList(file,"List2");
    }
    @PostMapping(path = "/duplicate",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Проверка изображения на совподение с BlackList")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BlackList.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Сравнение прошло неудачно")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public void checkBlackList(@RequestParam("file") MultipartFile file,@RequestParam("profileIdentification") String profileIdentification) {
        avatarService.checkBlackList(file, profileIdentification);
    }
    @GetMapping("/get/id")
    @Operation(summary = "Получить BlackList по его id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Integer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Изображение с таким id не найден")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<?> getBlackListId(@RequestParam Integer id) {
        return new ResponseEntity<>(blackListService.getOneBlackListId(id), HttpStatus.OK);
    }
    @DeleteMapping("/clearBlackList")
    @Operation(summary = "очистить BlackList юзеров")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Очистка списка забаненых прошла неудачно")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<HttpStatus> clearBlackListUser() {
        avatarService.clearBlackListUser();
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/id")
    @Operation(summary = "Удалить BlackList по его id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Integer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "Удаление изображения с id прошло неудачно")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<HttpStatus> deleteOneBlackList(@RequestParam("id") Integer id) {
        blackListService.deleteOneBlackList(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
