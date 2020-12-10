/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: o7HykaIEg6MYbomNk9MrDmJoW9+BSnLX
 */
package net.bdsc.dao;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.Business;
import net.bdsc.entity.BusinessCash;

/**
 * Dao - 商家提现
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface BusinessCashDao extends BaseDao<BusinessCash, Long> {

	/**
	 * 查找商家提现记录分页
	 * 
	 * @param status
	 *            状态
	 * @param bank
	 *            收款银行
	 * @param account
	 *            收款账号
	 * @param business
	 *            商家
	 * @param pageable
	 *            分页信息
	 * @return 商家提现记录分页
	 */
	Page<BusinessCash> findPage(BusinessCash.Status status, String bank, String account, Business business, Pageable pageable);

	/**
	 * 查找商家提现数量
	 * 
	 * @param status
	 *            状态
	 * @param bank
	 *            收款银行
	 * @param account
	 *            收款账号
	 * @param business
	 *            商家
	 * @return 商家提现数量
	 */
	Long count(BusinessCash.Status status, String bank, String account, Business business);

}