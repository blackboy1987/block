/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: DfQI0hxjwuSjURY98/5qffB85TYRtUdK
 */
package net.bdsc.dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import net.bdsc.dao.SeoDao;
import net.bdsc.entity.Seo;

/**
 * Dao - SEO设置
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Repository
public class SeoDaoImpl extends BaseDaoImpl<Seo, Long> implements SeoDao {

	@Override
	public Seo find(Seo.Type type) {
		if (type == null) {
			return null;
		}
		try {
			String jpql = "select seo from Seo seo where seo.type = :type";
			return entityManager.createQuery(jpql, Seo.class).setParameter("type", type).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}