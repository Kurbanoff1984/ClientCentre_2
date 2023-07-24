package com.kata.clientprofileupdate.Controller;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.kata.entity.individual.Avatar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/update")
@Tag(name = "Контроллеры", description = "Все методы для работы саватаром")
@AllArgsConstructor
public class AvatarController {


    @PostMapping("/changeStatus/")
    @Operation(summary = "изменение статуса")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(defaultValue = "статус изменен")) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public void getAvatarIdd(@RequestParam("ICP") String isp, @RequestParam("status") boolean status) {
        //Добавить сохранение статуса
    }
}
