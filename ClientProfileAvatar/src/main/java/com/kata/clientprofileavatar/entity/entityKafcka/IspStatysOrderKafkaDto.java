package com.kata.clientprofileavatar.entity.entityKafcka;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class IspStatysOrderKafkaDto {
    String isp;
    boolean statys;
}
