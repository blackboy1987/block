/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: vEz0+6mxs5QZGkzCFxj95+vAGdkbZO9l
 */
package net.bdsc.dao.impl;

import org.springframework.stereotype.Repository;

import net.bdsc.dao.AuditLogDao;
import net.bdsc.entity.AuditLog;

/**
 * Dao - 审计日志
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Repository
public class AuditLogDaoImpl extends BaseDaoImpl<AuditLog, Long> implements AuditLogDao {

	@Override
	public void removeAll() {
		String jpql = "delete from AuditLog auditLog";
		entityManager.createQuery(jpql).executeUpdate();
	}

}