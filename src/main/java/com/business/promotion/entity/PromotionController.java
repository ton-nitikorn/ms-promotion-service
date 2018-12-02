package com.business.promotion.entity;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotion")
public class PromotionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PromotionController.class);
	
	@Autowired
	PromotionRepository promotionRepository;
	
	@GetMapping("/{promotionCode}")
	public Map<String, String> getPromotionByCode(@PathVariable String promotionCode){
		Map<String, String> result = new HashMap<String, String>();
		Promotion promotion = promotionRepository.findByCode(promotionCode);
		if(promotion != null) {
			LOGGER.info("Retrived Data From Database");
			result.put("valid", "true");
			result.put("discount", promotion.getDiscount().toString());
		}else {
			LOGGER.info("Data Not Found in Database");
			result.put("valid", "false");
		}
		return result;
	}

}
