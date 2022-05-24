package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.Plague;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlagueRepository extends JpaRepository<Plague, Long> {
}
