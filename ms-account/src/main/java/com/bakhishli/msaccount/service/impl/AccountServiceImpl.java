package com.bakhishli.msaccount.service.impl;

import com.bakhishli.msaccount.domain.Account;
import com.bakhishli.msaccount.exception.AccountNotFoundException;
import com.bakhishli.msaccount.repository.AccountRepository;
import com.bakhishli.msaccount.service.AccountService;
import com.bakhishli.msaccount.service.adapter.AccountAdapter;
import com.bakhishli.msaccount.service.dto.AccountRequestDto;
import com.bakhishli.msaccount.service.dto.AccountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountAdapter adapter;

    @Override
    public AccountResponseDto getByUuid(String uuid) {
        return adapter.map(accountRepository
                .findByUuid(uuid).orElseThrow(IllegalStateException::new));
    }

    @Override
    public AccountResponseDto create(AccountRequestDto accountRequestDto) {
        Account account = adapter.map(accountRequestDto);
        account.setIsActive(false);
        return adapter.map(accountRepository.save(account));
    }

    @Override
    public AccountResponseDto update(String uuid, AccountRequestDto accountRequestDto) {
        return accountRepository.findByUuid(uuid)
                .map(account -> {
                    Account acc = adapter.map(accountRequestDto);
                    acc.setUuid(account.getUuid());
                    return adapter.map(accountRepository.save(acc));
                }).orElseThrow(()-> new AccountNotFoundException(uuid));
    }

    @Override
    public void delete(String uuid) {
        Account account = accountRepository.findByUuid(uuid)
                .orElseThrow(() -> new AccountNotFoundException(uuid));
        accountRepository.delete(account);
    }

//    @Override
//    public List<AccountResponseDto> findAll() {
//        List<Account> accounts = accountRepository.findAll();
//        return adapter.map(accounts);
//    }

//    @Override
//    public Account pagination() {
//        return null;
//    }
}
