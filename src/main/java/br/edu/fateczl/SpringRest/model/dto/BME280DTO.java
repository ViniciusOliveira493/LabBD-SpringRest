package br.edu.fateczl.SpringRest.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.SpringRest.model.entity.BME280;
import lombok.Getter;
import lombok.Setter;

public class BME280DTO {	
	private LocalDateTime dateAndtime;
	private Double pressure;
	private Double humidity;
	private Double temperature;

	
	public LocalDateTime getDateAndtime() {
		return dateAndtime;
	}

	public void setDateAndtime(LocalDateTime dateAndtime) {
		this.dateAndtime = dateAndtime;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return dateAndtime + " | " + pressure + " | " + humidity  + " | " + temperature;
	}
	
	public static BME280DTO parseToBME280DTO(BME280 bme) {
		BME280DTO dto = new BME280DTO();
		dto.setDateAndtime(bme.getDateAndtime());
		dto.setHumidity(bme.getHumidity());
		dto.setPressure(bme.getPressure());
		dto.setTemperature(bme.getTemperature());
		return dto;
	}
	
	public static List<BME280DTO> parseToBME280DTO(List<BME280> bmes) {
		List<BME280DTO> dtos = new ArrayList<>();
		for(BME280 bme:bmes) {
			BME280DTO dto = new BME280DTO();
			dto.setDateAndtime(bme.getDateAndtime());
			dto.setHumidity(bme.getHumidity());
			dto.setPressure(bme.getPressure());
			dto.setTemperature(bme.getTemperature());
			dtos.add(dto);
		}		
		return dtos;
	}
}
