package com.business.promotion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.business.promotion.entity.Promotion;
import com.business.promotion.entity.PromotionRepository;

@SpringBootApplication
public class PromotionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initialUserData(PromotionRepository repository) {
		return (args)->{
			Promotion promotion1 = new Promotion("FREE100",100.00);
			Promotion promotion2 = new Promotion("FREE200",200.00);
			Promotion promotion3 = new Promotion("FREE150",150.00);
			repository.save(promotion1);
			repository.save(promotion2);
			repository.save(promotion3);
		};
	}
}
