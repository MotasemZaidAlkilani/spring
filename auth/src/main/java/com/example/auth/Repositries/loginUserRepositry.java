package com.example.auth.Repositries;

import com.example.auth.modals.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loginUserRepositry extends JpaRepository<LoginUser,Long> {
    LoginUser findByUsername(String username);
}
