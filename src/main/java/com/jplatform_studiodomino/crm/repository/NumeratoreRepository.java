package com.jplatform_studiodomino.crm.repository;

import com.jplatform_studiodomino.crm.entity.Numeratore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumeratoreRepository extends JpaRepository<Numeratore, Long> {
}