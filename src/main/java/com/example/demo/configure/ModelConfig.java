package com.example.demo.configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ModelConfig {

	@Bean
	public ModelMapper modelmMapper() {
		return new ModelMapper();
	}
	
}
