/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: CtqHmKWPiEiQioBvXPCndlk5h51Za0FL
 */
package net.bdsc.service;

import java.awt.image.BufferedImage;

/**
 * Service - 验证码
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface CaptchaService {

	/**
	 * 创建验证码图片
	 * 
	 * @param captchaId
	 *            验证码ID
	 * @return 验证码图片
	 */
	BufferedImage createImage(String captchaId);

	/**
	 * 验证码验证
	 * 
	 * @param captchaId
	 *            验证码ID
	 * @param captcha
	 *            验证码(忽略大小写)
	 * @return 验证码验证是否通过
	 */
	boolean isValid(String captchaId, String captcha);

}