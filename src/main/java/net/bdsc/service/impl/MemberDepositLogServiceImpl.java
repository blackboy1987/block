/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: z+ocyB02o9j0axKZ4rorfJr9rwzm1ORc
 */
package net.bdsc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.MemberDepositLogDao;
import net.bdsc.entity.Member;
import net.bdsc.entity.MemberDepositLog;
import net.bdsc.service.MemberDepositLogService;

/**
 * Service - 会员预存款记录
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class MemberDepositLogServiceImpl extends BaseServiceImpl<MemberDepositLog, Long> implements MemberDepositLogService {

	@Inject
	private MemberDepositLogDao memberDepositLogDao;

	@Override
	@Transactional(readOnly = true)
	public Page<MemberDepositLog> findPage(Member member, Pageable pageable) {
		return memberDepositLogDao.findPage(member, pageable);
	}

}