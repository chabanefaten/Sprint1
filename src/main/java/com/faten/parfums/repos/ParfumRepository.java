package com.faten.parfums.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faten.parfums.entities.Parfum;

public interface ParfumRepository extends JpaRepository<Parfum, Long> {

}
