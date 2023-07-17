package com.kata.clientprofileavatar.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "BlackList")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "генерируется при сохранении в БД", example = "123")
    private Integer id;
    @Column(name = "typeBlackList")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "тип листа к  которому относить", example = "List1")
    private String typeBlackList;
    @Lob
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "байтовое представление", example = "/9j/4AAQSkZJRgABAQEASABIAAD/2wBDAAEBAQEBAQEBAQEBAQECAgMCAgICAgQDAwIDBQQFBQUEBAQFBgcGBQUHBgQEBg...")
    private byte[] byteSize;
}
