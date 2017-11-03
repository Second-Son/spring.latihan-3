package com.tabel.data.bootcamp.repository;

import com.tabel.data.bootcamp.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

    User findByUsername(String username);
}
