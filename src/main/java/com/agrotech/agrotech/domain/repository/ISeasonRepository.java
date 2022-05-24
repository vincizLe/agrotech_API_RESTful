package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeasonRepository extends JpaRepository<Season, Long> {
}
