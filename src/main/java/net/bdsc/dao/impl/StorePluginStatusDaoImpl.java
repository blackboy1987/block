/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: q/tgB5wA549KwzV0X0IObGPOeGSqNqef
 */
package net.bdsc.dao.impl;

import javax.persistence.NoResultException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import net.bdsc.dao.StorePluginStatusDao;
import net.bdsc.entity.Store;
import net.bdsc.entity.StorePluginStatus;

/**
 * Dao - 店铺插件状态
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Repository
public class StorePluginStatusDaoImpl extends BaseDaoImpl<StorePluginStatus, Long> implements StorePluginStatusDao {

	public StorePluginStatus find(Store store, String pluginId) {
		if (store == null || StringUtils.isEmpty(pluginId)) {
			return null;
		}
		try {
			String jpql = "select storePluginStatus from StorePluginStatus storePluginStatus where storePluginStatus.store = :store and storePluginStatus.pluginId = :pluginId";
			return entityManager.createQuery(jpql, StorePluginStatus.class).setParameter("store", store).setParameter("pluginId", pluginId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}