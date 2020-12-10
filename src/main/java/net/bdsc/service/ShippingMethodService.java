/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: YGyD53TOcXNDwJk2DKPBbFEKcoxmWeJK
 */
package net.bdsc.service;

import java.math.BigDecimal;

import net.bdsc.entity.Area;
import net.bdsc.entity.Receiver;
import net.bdsc.entity.ShippingMethod;
import net.bdsc.entity.Store;

/**
 * Service - 配送方式
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface ShippingMethodService extends BaseService<ShippingMethod, Long> {

	/**
	 * 计算运费
	 * 
	 * @param shippingMethod
	 *            配送方式
	 * @param store
	 *            店铺
	 * @param area
	 *            地区
	 * @param weight
	 *            重量
	 * @return 运费
	 */
	BigDecimal calculateFreight(ShippingMethod shippingMethod, Store store, Area area, Integer weight);

	/**
	 * 计算运费
	 * 
	 * @param shippingMethod
	 *            配送方式
	 * @param store
	 *            店铺
	 * @param receiver
	 *            收货地址
	 * @param weight
	 *            重量
	 * @return 运费
	 */
	BigDecimal calculateFreight(ShippingMethod shippingMethod, Store store, Receiver receiver, Integer weight);
}