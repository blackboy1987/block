/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: xu7Q4BqF/TJdolNMwR1mJffABPejIuW4
 */
package net.bdsc.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import net.bdsc.entity.ParameterValue;
import net.bdsc.service.ParameterValueService;

/**
 * Service - 参数值
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Service
public class ParameterValueServiceImpl implements ParameterValueService {

	@Override
	public void filter(List<ParameterValue> parameterValues) {
		CollectionUtils.filter(parameterValues, new Predicate() {
			public boolean evaluate(Object object) {
				ParameterValue parameterValue = (ParameterValue) object;
				if (parameterValue == null || StringUtils.isEmpty(parameterValue.getGroup())) {
					return false;
				}
				CollectionUtils.filter(parameterValue.getEntries(), new Predicate() {
					private Set<String> set = new HashSet<>();

					public boolean evaluate(Object object) {
						ParameterValue.Entry entry = (ParameterValue.Entry) object;
						return entry != null && StringUtils.isNotEmpty(entry.getName()) && StringUtils.isNotEmpty(entry.getValue()) && set.add(entry.getName());
					}
				});
				return CollectionUtils.isNotEmpty(parameterValue.getEntries());
			}
		});
	}

}