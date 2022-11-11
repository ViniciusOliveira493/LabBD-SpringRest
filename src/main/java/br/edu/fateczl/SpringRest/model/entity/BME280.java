package br.edu.fateczl.SpringRest.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="BME280")

public class BME280 {
	@Id
	@Column(name = "dateAndTime", nullable = false)
	private LocalDateTime dateAndtime;
	
	@Column(name = "pressure", nullable = true)
	private Double pressure;
	
	@Column(name = "humidity", nullable = true)
	private Double humidity;
	
	@Column(name = "temperature",nullable = true)
	private Double temperature;
	
	@Override
	public String toString() {
		return dateAndtime + " | " + pressure + " | " + humidity  + " | " + temperature;
	}
}
