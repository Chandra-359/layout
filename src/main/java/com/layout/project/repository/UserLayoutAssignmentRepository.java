package com.layout.project.repository;

import com.layout.project.model.User;
import com.layout.project.model.UserLayoutAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLayoutAssignmentRepository extends JpaRepository<UserLayoutAssignment, Long> {
    Optional<UserLayoutAssignment> findByUser(User user);
}
