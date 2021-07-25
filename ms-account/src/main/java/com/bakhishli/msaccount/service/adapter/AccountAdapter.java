package com.bakhishli.msaccount.service.adapter;

import com.bakhishli.msaccount.domain.Account;
import com.bakhishli.msaccount.service.dto.AccountRequestDto;
import com.bakhishli.msaccount.service.dto.AccountResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountAdapter {

    @Mapping(target = "fullName", source = "accountRequestDto.fullName")
    @Mapping(target = "email", source = "accountRequestDto.email")
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    Account map(AccountRequestDto accountRequestDto);

    AccountResponseDto map(Account account);

    List<AccountResponseDto> map(List<Account> accounts);
}
