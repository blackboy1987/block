/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 0v4Jk93rxDGjCB+4WsjxS2R4YUSfVL2C
 */
package net.bdsc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bdsc.dao.SnDao;
import net.bdsc.entity.Sn;
import net.bdsc.service.SnService;

/**
 * Service - 序列号
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class SnServiceImpl implements SnService {

	@Inject
	private SnDao snDao;

	@Override
	@Transactional
	public String generate(Sn.Type type) {
		return snDao.generate(type);
	}

}