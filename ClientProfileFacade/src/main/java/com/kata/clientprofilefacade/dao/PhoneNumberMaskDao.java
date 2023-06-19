package com.kata.clientprofilefacade.dao;

//import com.kata.clientprofilefacade.dto.PhoneNumberDTO;
import com.kata.clientprofilefacade.dto.PhoneNumberDTO;
import org.kata.entity.contactmedium.PhoneNumber;

public interface PhoneNumberMaskDao {
    PhoneNumberDTO maskPhoneNumber(PhoneNumberDTO phoneNumber);
}
