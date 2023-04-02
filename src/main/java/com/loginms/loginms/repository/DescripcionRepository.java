package com.loginms.loginms.repository;

import com.loginms.loginms.entity.DescripcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescripcionRepository extends JpaRepository<DescripcionEntity, Long> {
}
