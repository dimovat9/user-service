package com.mhealth.userservice.repository;
import com.mhealth.userservice.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}