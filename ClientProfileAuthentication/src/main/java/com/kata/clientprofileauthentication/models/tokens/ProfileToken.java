package com.kata.clientprofileauthentication.models.tokens;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("tokenKey")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProfileToken {
    @Id
    @Indexed
    private String bearerToken;
    @Indexed
    private String jwtBearerToken;
    @Indexed
    private String refreshToken;

    @Override
    public String toString() {
        return "ProfileToken{" +
                ", jwtBearerToken='" + bearerToken + '\'' +
                ", refreshToken='" + jwtBearerToken + '\'' +
                ", bearerToken='" + refreshToken + '\'' +
                '}';
    }

}
