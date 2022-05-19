package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlotRepository extends JpaRepository<Plot,Long> {
}
