package com.klu.dto;

import lombok.Data;

@Data
public class StudentResponseDTO {
	
	private Long id;
	private String name;
	private String email;
	private String course;
	private String branch;
	private Double fees;

}
