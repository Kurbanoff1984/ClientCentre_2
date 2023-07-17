package com.kata.clientprofilefacade1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
@RedisHash("blackTokenKey")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BlackListOfProfileTokens {
    /**
     * токены хранятся в redis под ключем blackTokenKey неупорядочно
     */
    @Id
    @Indexed
    private String bRefreshOrJwtOrBearer;
}
