package com.sayel.bookmyshow_backend.repository;

import com.sayel.bookmyshow_backend.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Long> {
}
