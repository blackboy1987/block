/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 3a+8qHTssjmfM+mwyZGgQ8aykz61xuaP
 */
package net.bdsc.dao;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.Member;
import net.bdsc.entity.PointLog;

/**
 * Dao - 积分记录
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface PointLogDao extends BaseDao<PointLog, Long> {

	/**
	 * 查找积分记录分页
	 * 
	 * @param member
	 *            会员
	 * @param pageable
	 *            分页信息
	 * @return 积分记录分页
	 */
	Page<PointLog> findPage(Member member, Pageable pageable);

}