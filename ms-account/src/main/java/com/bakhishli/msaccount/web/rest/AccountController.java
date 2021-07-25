package com.bakhishli.msaccount.web.rest;

import com.bakhishli.msaccount.service.AccountService;
import com.bakhishli.msaccount.service.dto.AccountRequestDto;
import com.bakhishli.msaccount.service.dto.AccountResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;


@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

//    @GetMapping
//    public ResponseEntity<List<AccountResponseDto>> getAll(){
//        return ResponseEntity.ok(accountService.findAll());
//    }

    @GetMapping("/{uuid}")
    public ResponseEntity<AccountResponseDto> getByUuid(@PathVariable String uuid){
        log.info("Getting branch by id: {}", uuid);
        return ResponseEntity.ok(accountService.getByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<AccountResponseDto> create(@RequestBody @Validated AccountRequestDto accountRequestDto){
        log.info("Creating branch: {}", accountRequestDto);
        return ResponseEntity.status(CREATED).body(accountService.create(accountRequestDto));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<AccountResponseDto> update(@PathVariable("uuid") String uuid,
                                                     @RequestBody AccountRequestDto accountRequestDto){
        log.info("Updating branch: {}", accountRequestDto);
        return ResponseEntity.ok(accountService.update(uuid, accountRequestDto));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(String uuid){
        accountService.delete(uuid);
        return ResponseEntity.noContent().build();
    }


//    public ResponseEntity<Account> pagination(){
//        return null;
//    }
}
