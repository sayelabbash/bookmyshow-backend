package com.sayel.bookmyshow_backend.repository;

import com.sayel.bookmyshow_backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
