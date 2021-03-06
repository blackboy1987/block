/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: fkZ7kcYEzE7P2XlMVx2c/zcCkr0yhtWt
 */
package net.bdsc.service;

import java.util.List;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.Member;
import net.bdsc.entity.Receiver;

/**
 * Service - 收货地址
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface ReceiverService extends BaseService<Receiver, Long> {

	/**
	 * 查找默认收货地址
	 * 
	 * @param member
	 *            会员
	 * @return 默认收货地址，若不存在则返回最新收货地址
	 */
	Receiver findDefault(Member member);

	/**
	 * 查找收货地址列表
	 * 
	 * @param member
	 *            会员
	 * @return 收货地址
	 */
	List<Receiver> findList(Member member);

	/**
	 * 查找收货地址分页
	 * 
	 * @param member
	 *            会员
	 * @param pageable
	 *            分页信息
	 * @return 收货地址分页
	 */
	Page<Receiver> findPage(Member member, Pageable pageable);

}