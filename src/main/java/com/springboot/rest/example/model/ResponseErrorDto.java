package com.springboot.rest.example.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseErrorDto {
	Integer code;
	List<String> errorMessage;

}
