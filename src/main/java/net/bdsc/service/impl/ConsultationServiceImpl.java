/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 3YDBVD38CW15uNuP9Jujk6wrkJSIFhww
 */
package net.bdsc.service.impl;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bdsc.Filter;
import net.bdsc.Order;
import net.bdsc.Page;
import net.bdsc.Pageable;
import net.bdsc.dao.ConsultationDao;
import net.bdsc.dao.MemberDao;
import net.bdsc.dao.ProductDao;
import net.bdsc.entity.Consultation;
import net.bdsc.entity.Member;
import net.bdsc.entity.Product;
import net.bdsc.entity.Store;
import net.bdsc.service.ConsultationService;

/**
 * Service - 咨询
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class ConsultationServiceImpl extends BaseServiceImpl<Consultation, Long> implements ConsultationService {

	@Inject
	private ConsultationDao consultationDao;
	@Inject
	private MemberDao memberDao;
	@Inject
	private ProductDao productDao;

	@Override
	@Transactional(readOnly = true)
	public List<Consultation> findList(Member member, Product product, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders) {
		return consultationDao.findList(member, product, isShow, count, filters, orders);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "consultation", condition = "#useCache")
	public List<Consultation> findList(Long memberId, Long productId, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders, boolean useCache) {
		Member member = memberDao.find(memberId);
		if (memberId != null && member == null) {
			return Collections.emptyList();
		}
		Product product = productDao.find(productId);
		if (productId != null && product == null) {
			return Collections.emptyList();
		}
		return consultationDao.findList(member, product, isShow, count, filters, orders);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Consultation> findPage(Member member, Product product, Store store, Boolean isShow, Pageable pageable) {
		return consultationDao.findPage(member, product, store, isShow, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count(Member member, Product product, Boolean isShow) {
		return consultationDao.count(member, product, isShow);
	}

	@Override
	@CacheEvict(value = { "product", "consultation" }, allEntries = true)
	public void reply(Consultation consultation, Consultation replyConsultation) {
		if (consultation == null || replyConsultation == null) {
			return;
		}
		consultation.setIsShow(true);

		replyConsultation.setIsShow(true);
		replyConsultation.setProduct(consultation.getProduct());
		replyConsultation.setForConsultation(consultation);
		replyConsultation.setStore(consultation.getStore());
		consultationDao.persist(replyConsultation);
	}

	@Override
	@Transactional
	@CacheEvict(value = { "product", "consultation" }, allEntries = true)
	public Consultation save(Consultation consultation) {
		return super.save(consultation);
	}

	@Override
	@Transactional
	@CacheEvict(value = { "product", "consultation" }, allEntries = true)
	public Consultation update(Consultation consultation) {
		return super.update(consultation);
	}

	@Override
	@Transactional
	@CacheEvict(value = { "product", "consultation" }, allEntries = true)
	public Consultation update(Consultation consultation, String... ignoreProperties) {
		return super.update(consultation, ignoreProperties);
	}

	@Override
	@Transactional
	@CacheEvict(value = { "product", "consultation" }, allEntries = true)
	public void delete(Long id) {
		super.delete(id);
	}

	@Override
	@Transactional
	@CacheEvict(value = { "product", "consultation" }, allEntries = true)
	public void delete(Long... ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	@CacheEvict(value = { "product", "consultation" }, allEntries = true)
	public void delete(Consultation consultation) {
		super.delete(consultation);
	}

}