/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: UJeTuB/k2kCETHtet722/t8Gj91hrFSG
 */
package net.bdsc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.StockLogDao;
import net.bdsc.entity.StockLog;
import net.bdsc.entity.Store;
import net.bdsc.service.StockLogService;

/**
 * Service - 库存记录
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class StockLogServiceImpl extends BaseServiceImpl<StockLog, Long> implements StockLogService {

	@Inject
	private StockLogDao stockLogDao;

	@Override
	@Transactional(readOnly = true)
	public Page<StockLog> findPage(Store store, Pageable pageable) {
		return stockLogDao.findPage(store, pageable);
	}

}