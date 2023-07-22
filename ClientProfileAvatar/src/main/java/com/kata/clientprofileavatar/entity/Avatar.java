package com.kata.clientprofileavatar.entity;


import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Avatar")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "генерируется при сохранении в БД", example = "123")
    private Integer id;
    @Column(name = "uuid")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "генерируется при сохранении", example = "e6ef2629-86c7-4193-8aa7-809250a109ef")
    private String  uuid;
    @Column(name = "name")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "оригинальное название файла берется из мельтифайла с помошью метода getOriginalNameFile", example = "dto.jpg")
    private String name;
    @Column(name = "mp5")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "основан на названии с помошью генерации", example = "8c7dd922ad47494fc02c388e12c00eac")
    private String md5;
    @Column(name = "file_size")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "генерируется при сохранении в БД", example = "123")
    private int fileSize;
    @Column(name = "profileIdentification")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "идентификатор пользователя к которомуц привязан аватар", example = "456")
    private String profileIdentification;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "идентификатор активности аватара", example = "true")
    @Column(name = "active")
    private boolean active;
    @Lob
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "байтовое представление", example = "/9j/4AAQSkZJRgABAQEASABIAAD/2wBDAAEBAQEBAQEBAQEBAQECAgMCAgICAgQDAwIDBQQFBQUEBAQFBgcGBQUHBgQEBg...")
    private byte[] byteSize;

}
