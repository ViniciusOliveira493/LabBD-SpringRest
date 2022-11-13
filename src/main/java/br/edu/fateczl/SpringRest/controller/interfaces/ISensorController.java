package br.edu.fateczl.SpringRest.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.edu.fateczl.SpringRest.model.dto.BME280DTO;
import br.edu.fateczl.SpringRest.model.entity.BME280;

public interface ISensorController {
	public List<BME280DTO> findAll();
	public ResponseEntity<BME280DTO> find(String dt);
	public ResponseEntity<String> insert(BME280 sensor);
	public ResponseEntity<String> update(BME280 sensor);
	public ResponseEntity<String> delete(BME280 sensor);	
}
