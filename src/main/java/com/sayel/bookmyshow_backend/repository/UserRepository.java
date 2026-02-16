package com.sayel.bookmyshow_backend.repository;

import com.sayel.bookmyshow_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
