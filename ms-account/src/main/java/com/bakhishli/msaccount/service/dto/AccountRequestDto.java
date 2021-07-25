package com.bakhishli.msaccount.service.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDto {

    private String fullName;
    private String email;

}
