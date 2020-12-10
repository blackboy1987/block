/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: p1pMjtmTvN7C5qf1chGECxHPklNykOLb
 */
package net.bdsc.controller.shop;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bdsc.entity.Promotion;
import net.bdsc.exception.ResourceNotFoundException;
import net.bdsc.service.PromotionService;

/**
 * Controller - 促销
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("shopPromotionController")
@RequestMapping("/promotion")
public class PromotionController extends BaseController {

	@Inject
	private PromotionService promotionService;

	/**
	 * 详情
	 */
	@GetMapping("/detail/{promotionId}")
	public String detail(@PathVariable Long promotionId, ModelMap model) {
		Promotion promotion = promotionService.find(promotionId);
		if (promotion == null) {
			throw new ResourceNotFoundException();
		}
		model.addAttribute("promotion", promotion);
		return "shop/promotion/detail";
	}

}