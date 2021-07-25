package com.bakhishli.msaccount.domain;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"uuid"})
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String uuid = UUID.randomUUID().toString();

    @Column(value="full_name")
    private String fullName;

    private String email;

    private String password;

    @Column(value = "crated_date")
    private LocalDate createdDate;

    @Column(value="is_active")
    private Boolean isActive;
}
