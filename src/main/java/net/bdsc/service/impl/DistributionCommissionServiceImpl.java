/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: s1ppJSM+L35I/VHH846AwVpUHlHcVO02
 */
package net.bdsc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.DistributionCommissionDao;
import net.bdsc.entity.DistributionCommission;
import net.bdsc.entity.Distributor;
import net.bdsc.service.DistributionCommissionService;

/**
 * Service - 分销佣金
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class DistributionCommissionServiceImpl extends BaseServiceImpl<DistributionCommission, Long> implements DistributionCommissionService {

	@Inject
	private DistributionCommissionDao distributionCommissionDao;

	@Override
	@Transactional(readOnly = true)
	public Page<DistributionCommission> findPage(Distributor distributor, Pageable pageable) {
		return distributionCommissionDao.findPage(distributor, pageable);
	}

}