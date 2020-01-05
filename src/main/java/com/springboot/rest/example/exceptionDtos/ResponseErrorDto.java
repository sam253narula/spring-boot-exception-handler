package com.springboot.rest.example.exceptionDtos;

import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "ResponseError")
public class ResponseErrorDto {

	private Integer code;
	private List<String> errorMessages;
}
