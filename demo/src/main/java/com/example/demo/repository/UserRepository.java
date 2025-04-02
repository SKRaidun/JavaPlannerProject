package com.example.demo.repository;

import com.example.demo.model.UserTable;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<UserTable, Long>, CrudRepository<UserTable, Long> {
    Optional<UserTable> findByLogin(String login);
}

