package com.business.promotion.entity;

import org.springframework.data.repository.CrudRepository;

public interface PromotionRepository extends CrudRepository<Promotion, Long>{
	Promotion findByCode(String code);
}
