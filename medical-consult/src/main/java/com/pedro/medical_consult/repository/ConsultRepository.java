package com.pedro.medical_consult.repository;

import com.pedro.medical_consult.domain.Consult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultRepository extends JpaRepository<Consult, Long> {
}
