/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: CZn4jgI1KwZElUBQSMldiHJaaVzbv3qb
 */
package net.bdsc.event;

import net.bdsc.entity.User;

/**
 * Event - 用户注册
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public class UserRegisteredEvent extends UserEvent {

	private static final long serialVersionUID = 3930447081075693577L;

	/**
	 * 构造方法
	 * 
	 * @param source
	 *            事件源
	 * @param user
	 *            用户
	 */
	public UserRegisteredEvent(Object source, User user) {
		super(source, user);
	}

}