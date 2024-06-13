package com.uep.wap.repository;

import com.uep.wap.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    //List<Booking> findByUserIdAndAccommodationId(Long userId, Long accommodationId);
}
