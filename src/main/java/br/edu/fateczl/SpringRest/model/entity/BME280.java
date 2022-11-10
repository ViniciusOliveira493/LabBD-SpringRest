package br.edu.fateczl.SpringRest.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="BME280")

public class BME280 {
	@Id
	@Column(name = "dateAndTime", nullable = false)
	private LocalDateTime dateAndtime;
	
	@Column(name = "pressure", nullable = false)
	private Double pressure;
	
	@Column(name = "humidity", nullable = false)
	private Double humidity;
	
	@Column(name = "temperature",nullable = false)
	private Double temperature;
	
}
