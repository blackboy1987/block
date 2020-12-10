/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: sw/ND8IMf1McSDVGAxbp9yhfhsS1FrL8
 */
package net.bdsc.dao;

import net.bdsc.entity.Cart;

/**
 * Dao - 购物车
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface CartDao extends BaseDao<Cart, Long> {

	/**
	 * 删除过期购物车
	 */
	void deleteExpired();

}