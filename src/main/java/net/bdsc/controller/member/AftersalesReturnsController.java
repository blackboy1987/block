/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: /XSp9JRudHEoiri5TNW6aRPtirY75b4j
 */
package net.bdsc.controller.member;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bdsc.Results;
import net.bdsc.entity.Aftersales;
import net.bdsc.entity.AftersalesReturns;
import net.bdsc.entity.Member;
import net.bdsc.entity.Order;
import net.bdsc.exception.UnauthorizedException;
import net.bdsc.security.CurrentUser;
import net.bdsc.service.AftersalesReturnsService;
import net.bdsc.service.AftersalesService;
import net.bdsc.service.OrderService;

/**
 * Controller - 退货
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("memberAftersalesReturnsController")
@RequestMapping("/member/aftersales_returns")
public class AftersalesReturnsController extends BaseController {

	@Inject
	private AftersalesReturnsService aftersalesReturnsService;
	@Inject
	private OrderService orderService;
	@Inject
	private AftersalesService aftersalesService;

	/**
	 * 添加属性
	 */
	@ModelAttribute
	public void populateModel(Long aftersalesReturnsId, Long orderId, @CurrentUser Member currentUser, ModelMap model) {
		AftersalesReturns aftersalesReturns = aftersalesReturnsService.find(aftersalesReturnsId);
		if (aftersalesReturns != null && !currentUser.equals(aftersalesReturns.getMember())) {
			throw new UnauthorizedException();
		}
		Order order = orderService.find(orderId);
		if (order != null && !currentUser.equals(order.getMember())) {
			throw new UnauthorizedException();
		}
		model.addAttribute("aftersalesReturns", aftersalesReturns);
		model.addAttribute("order", order);
	}

	/**
	 * 退货
	 */
	@PostMapping("/returns")
	public ResponseEntity<?> returns(@ModelAttribute("aftersalesReturnsForm") AftersalesReturns aftersalesReturnsForm, @ModelAttribute(binding = false) Order order) {
		if (order == null) {
			return Results.UNPROCESSABLE_ENTITY;
		}

		aftersalesService.filterNotActiveAftersalesItem(aftersalesReturnsForm);
		if (aftersalesService.existsIllegalAftersalesItems(aftersalesReturnsForm.getAftersalesItems())) {
			return Results.UNPROCESSABLE_ENTITY;
		}

		aftersalesReturnsForm.setStatus(Aftersales.Status.PENDING);
		aftersalesReturnsForm.setMember(order.getMember());
		aftersalesReturnsForm.setStore(order.getStore());

		if (!isValid(aftersalesReturnsForm)) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		aftersalesReturnsService.save(aftersalesReturnsForm);
		return Results.OK;
	}

}