package com.bakhishli.msaccount.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {
    private String uuid;
    private String fullName;
    private String email;
    private LocalDate createdDate;
    private Boolean isActive;
}
