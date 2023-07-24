package com.kata.clientprofileavatar.kafkaGetMesseg.seviceKafcka;



import com.kata.clientprofileavatar.entity.entityKafcka.IspStatysOrderKafkaDto;
import com.kata.clientprofileavatar.entity.entityKafcka.IspStatysOrderKafkaOrderOne;
import com.kata.clientprofileavatar.repository.MessegAvatarStatysRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AvatarStatysOrderChekService {

    private final MessegAvatarStatysRepository messegAvatarStatysRepository;
    private final ModelMapper modelMapper;
    public void persistFoodOrder(IspStatysOrderKafkaDto ispStatysOrderKafkaDto) {
        IspStatysOrderKafkaOrderOne ispStatysOrderKafkaOrderOne = modelMapper.map(ispStatysOrderKafkaDto, IspStatysOrderKafkaOrderOne.class);
        IspStatysOrderKafkaOrderOne persistedFoodOrder = messegAvatarStatysRepository.save(ispStatysOrderKafkaOrderOne);

        log.info("данные получен перелданы на сохранение {}", persistedFoodOrder);
    }

}
