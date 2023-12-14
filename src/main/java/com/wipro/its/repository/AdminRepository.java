package com.wipro.its.repository;

import com.wipro.its.entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,Integer> {
    Admin findByEmail(String email);

    Admin findByEmailAndPassword(String email, String password);
}
