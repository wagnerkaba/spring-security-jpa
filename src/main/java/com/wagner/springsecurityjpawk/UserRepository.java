package com.wagner.springsecurityjpawk;

import com.wagner.springsecurityjpawk.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Integer> {


    Optional<MyUser> findByUsername (String username);
}
