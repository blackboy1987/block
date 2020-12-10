/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: SK85ntWMAr375cJWUi5BOOUoJSEKnWsB
 */
package net.bdsc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import net.bdsc.dao.AftersalesSettingDao;
import net.bdsc.entity.AftersalesSetting;
import net.bdsc.entity.Store;
import net.bdsc.service.AftersalesSettingService;

/**
 * Service - 售后设置
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class AftersalesSettingServiceImpl extends BaseServiceImpl<AftersalesSetting, Long> implements AftersalesSettingService {

	@Inject
	private AftersalesSettingDao aftersalesSettingDao;

	@Override
	@Transactional(readOnly = true)
	public AftersalesSetting findByStore(Store store) {
		Assert.notNull(store, "[Assertion failed] - store is required; it must not be null");

		return aftersalesSettingDao.find("store", store);
	}

}