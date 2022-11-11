package br.edu.fateczl.SpringRest.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.SpringRest.model.entity.BME280;
import br.edu.fateczl.SpringRest.repository.BME280Repository;

@RestController
@RequestMapping("/api")
public class SensorController {
	@Autowired
	private BME280Repository rep;
	
	@GetMapping("/")
	public List<BME280> findAll(){
		return rep.findAll();
	}
	
	@GetMapping("/{dt}")
	public ResponseEntity<BME280> find(@PathVariable(value = "dt") LocalDateTime dt) throws ResourceNotFoundException{
		BME280 s = rep.findById(dt).orElseThrow(
				() -> new ResourceNotFoundException("Não existe um registro com essa data")
				);
		return ResponseEntity.ok().body(s);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> insert(@Valid @RequestBody BME280 sensor){
		System.out.println(sensor.toString());
		rep.save(sensor);
		String saida = "Dados cadastrados com sucesso";
		return ResponseEntity.ok().body(saida);
	}
	
	@PutMapping("/")
	public ResponseEntity<String> update(@Valid @RequestBody BME280 sensor){
		rep.save(sensor);
		String saida = "Dados atualizados com sucesso";
		return ResponseEntity.ok().body(saida);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<String> delete(@Valid @RequestBody BME280 sensor){
		rep.delete(sensor);
		String saida = "Dados excluidos com sucesso";
		return ResponseEntity.ok().body(saida);
	}
}
