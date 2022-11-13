package br.edu.fateczl.SpringRest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.edu.fateczl.SpringRest.controller.interfaces.ISensorController;
import br.edu.fateczl.SpringRest.model.dto.BME280DTO;
import br.edu.fateczl.SpringRest.model.entity.BME280;
import br.edu.fateczl.SpringRest.repository.BME280Repository;

@RestController
@RequestMapping("/api")
public class SensorController implements ISensorController{
	@Autowired
	private BME280Repository rep;
	
	@Override
	@GetMapping("/sensor")
	public List<BME280DTO> findAll(){
		List<BME280> list = rep.findAll();
		for(BME280 s:list) {
			System.out.println(s);
		}
		return BME280DTO.parseToBME280DTO(list);
	}

	@Override
	@GetMapping("/sensor/{dt}")
	public ResponseEntity<BME280DTO> find(@PathVariable(value = "dt") String dt) throws ResourceNotFoundException{
		BME280DTO s = BME280DTO.parseToBME280DTO(rep.findById(BME280.parseDate(dt)).orElseThrow(
				() -> new ResourceNotFoundException("Não existe um registro com essa data")
				));
		return ResponseEntity.ok().body(s);
	}
	
	@Override
	@PostMapping("/sensor")
	public ResponseEntity<String> insert(@Valid @RequestBody BME280 sensor){
		System.out.println(sensor.toString());
		rep.save(sensor);
		String saida = "Dados cadastrados com sucesso";
		return ResponseEntity.ok().body(saida);
	}
	
	@Override
	@PutMapping("/sensor")
	public ResponseEntity<String> update(@Valid @RequestBody BME280 sensor){
		rep.save(sensor);
		String saida = "Dados atualizados com sucesso";
		return ResponseEntity.ok().body(saida);
	}
	
	@Override
	@DeleteMapping("/sensor")
	public ResponseEntity<String> delete(@Valid @RequestBody BME280 sensor){
		rep.delete(sensor);
		String saida = "Dados excluidos com sucesso";
		return ResponseEntity.ok().body(saida);
	}
}
