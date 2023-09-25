package com.example.ticketbioskop.repository;

import com.example.ticketbioskop.entity.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser getAppUserById(Long userId);
    AppUser deleteAppUserById(Long userId);
    boolean existsById(Long userId);
}
