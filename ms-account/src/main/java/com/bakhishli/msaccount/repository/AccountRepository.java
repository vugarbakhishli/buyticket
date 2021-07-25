package com.bakhishli.msaccount.repository;

import com.bakhishli.msaccount.domain.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {
    Optional<Account> findByUuid(String uuid);
}
