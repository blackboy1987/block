/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: SHnEO3L2fWGN2r8f31DR8gUbIhOEti1x
 */
package net.bdsc.entity;

import javax.persistence.Entity;

/**
 * Entity - 促销插件服务
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Entity
public class PromotionPluginSvc extends Svc {

	private static final long serialVersionUID = 7240764880070217374L;

	/**
	 * 促销插件Id
	 */
	private String promotionPluginId;

	/**
	 * 获取促销插件Id
	 * 
	 * @return 促销插件Id
	 */
	public String getPromotionPluginId() {
		return promotionPluginId;
	}

	/**
	 * 设置促销插件Id
	 * 
	 * @param promotionPluginId
	 *            促销插件Id
	 */
	public void setPromotionPluginId(String promotionPluginId) {
		this.promotionPluginId = promotionPluginId;
	}

}