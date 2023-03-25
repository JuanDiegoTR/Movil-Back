package com.loginms.loginms.repository;

import com.loginms.loginms.entity.ContabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContabilidadRepository extends JpaRepository<ContabilidadEntity, Long> {
}
