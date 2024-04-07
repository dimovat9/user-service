package com.mhealth.userservice.repository;
import com.mhealth.userservice.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}