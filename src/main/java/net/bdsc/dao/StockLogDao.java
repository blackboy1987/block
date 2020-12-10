/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: eNBNNT6MuboXGWjOtXUPlSAdfvOk1IYo
 */
package net.bdsc.dao;

import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.entity.StockLog;
import net.bdsc.entity.Store;

/**
 * Dao - 库存记录
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface StockLogDao extends BaseDao<StockLog, Long> {

	/**
	 * 查找库存记录分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页
	 * @return 库存记录分页
	 */
	Page<StockLog> findPage(Store store, Pageable pageable);

}