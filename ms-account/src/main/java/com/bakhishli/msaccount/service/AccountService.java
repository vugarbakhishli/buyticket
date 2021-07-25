package com.bakhishli.msaccount.service;

import com.bakhishli.msaccount.service.dto.AccountRequestDto;
import com.bakhishli.msaccount.service.dto.AccountResponseDto;


public interface AccountService {
    AccountResponseDto getByUuid(String uuid);
    AccountResponseDto create(AccountRequestDto accountRequestDto);
    AccountResponseDto update(String uuid, AccountRequestDto accountRequestDto);
    void delete(String uuid);

    //List<AccountResponseDto> findAll();


//    Account pagination();
}
