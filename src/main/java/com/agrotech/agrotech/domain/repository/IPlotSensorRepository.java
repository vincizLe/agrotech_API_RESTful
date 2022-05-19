package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.PlotSensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlotSensorRepository extends JpaRepository<PlotSensor,Long> {
}
