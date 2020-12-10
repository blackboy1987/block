/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: m6BFs1/KSRzftprnftaHMtJlle+wDTBi
 */
package net.bdsc.dao;

import net.bdsc.entity.Store;
import net.bdsc.entity.StorePluginStatus;

/**
 * Dao - 店铺插件状态
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface StorePluginStatusDao extends BaseDao<StorePluginStatus, Long> {

	/**
	 * 查找店铺插件状态
	 * 
	 * @param store
	 *            店铺
	 * @param pluginId
	 *            插件ID
	 * @return 店铺插件状态，若不存在则返回null
	 */
	StorePluginStatus find(Store store, String pluginId);
}