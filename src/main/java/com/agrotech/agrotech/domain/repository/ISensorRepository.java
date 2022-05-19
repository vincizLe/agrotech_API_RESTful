package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISensorRepository extends JpaRepository<Sensor,Long> {
}
