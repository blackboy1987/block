/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: g5KClzz9m8lv8WSfik9QbghTOHV+DNRs
 */
package net.bdsc.service;

import java.util.List;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.entity.Brand;
import net.bdsc.entity.ProductCategory;

/**
 * Service - 品牌
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface BrandService extends BaseService<Brand, Long> {

	/**
	 * 查找品牌
	 * 
	 * @param productCategory
	 *            商品分类
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 品牌
	 */
	List<Brand> findList(ProductCategory productCategory, Integer count, List<Filter> filters, List<Order> orders);

	/**
	 * 查找品牌
	 * 
	 * @param productCategoryId
	 *            商品分类ID
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @param useCache
	 *            是否使用缓存
	 * @return 品牌
	 */
	List<Brand> findList(Long productCategoryId, Integer count, List<Filter> filters, List<Order> orders, boolean useCache);

}