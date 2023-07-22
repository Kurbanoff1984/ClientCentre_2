package com.kata.clientprofilefacade.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Meta {

    @JsonProperty("last_updated_at")
    private String lastUpdateAt;
}
