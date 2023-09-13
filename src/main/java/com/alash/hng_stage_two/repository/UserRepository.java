package com.HngTaskTwo.HngTaskTwo.repository;

import com.HngTaskTwo.HngTaskTwo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
