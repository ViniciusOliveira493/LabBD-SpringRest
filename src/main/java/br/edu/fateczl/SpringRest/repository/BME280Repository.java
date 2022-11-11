package br.edu.fateczl.SpringRest.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.SpringRest.model.entity.BME280;

public interface BME280Repository extends JpaRepository<BME280, LocalDateTime>{
	
}
