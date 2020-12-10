/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: faEE49Kns4CIvHjlieARDJpHgT1uyj2F
 */
package net.bdsc.dao;

import java.util.List;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.InstantMessage;
import net.bdsc.entity.InstantMessage.Type;
import net.bdsc.entity.Store;

/**
 * Dao - 即时通讯
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface InstantMessageDao extends BaseDao<InstantMessage, Long> {

	/**
	 * 查找即时通讯
	 *
	 * @param type
	 *            类型
	 * @param store
	 *            店铺
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 即时通讯
	 */
	List<InstantMessage> findList(Type type, Store store, Integer count, List<Filter> filters, List<Order> orders);

	/**
	 * 查找即时通讯分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页
	 * @return 即时通讯分页
	 */
	Page<InstantMessage> findPage(Store store, Pageable pageable);

}