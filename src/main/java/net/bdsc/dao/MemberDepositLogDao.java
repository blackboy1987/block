/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: nk/UGIfOpe6OS4oKaGgqArzsp888knVk
 */
package net.bdsc.dao;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.Member;
import net.bdsc.entity.MemberDepositLog;

/**
 * Dao - 会员预存款记录
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface MemberDepositLogDao extends BaseDao<MemberDepositLog, Long> {

	/**
	 * 查找会员预存款记录分页
	 * 
	 * @param member
	 *            会员
	 * @param pageable
	 *            分页信息
	 * @return 会员预存款记录分页
	 */
	Page<MemberDepositLog> findPage(Member member, Pageable pageable);

}