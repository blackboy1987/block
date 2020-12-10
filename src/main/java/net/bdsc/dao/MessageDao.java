/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: u+/MbUZVd/h1WMDI0QNYRVLtodVgZPNy
 */
package net.bdsc.dao;

import java.util.List;

import net.bdsc.entity.Message;
import net.bdsc.entity.MessageGroup;
import net.bdsc.entity.User;

/**
 * Dao - 消息
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface MessageDao extends BaseDao<Message, Long> {

	/**
	 * 查找
	 * 
	 * @param messageGroup
	 *            消息组
	 * @param user
	 *            用户
	 * @return 消息
	 */
	List<Message> findList(MessageGroup messageGroup, User user);

	/**
	 * 未读消息数量
	 * 
	 * @param messageGroup
	 *            消息组
	 * @param user
	 *            用户
	 * @return 未读消息数量
	 */
	Long unreadMessageCount(MessageGroup messageGroup, User user);

}