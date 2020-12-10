/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: MVWZwuVNguv45bZ83/hXW1wFmIUhD+u9
 */
package net.bdsc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.bdsc.entity.ProductImage;

/**
 * Service - 商品图片
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface ProductImageService {

	/**
	 * 商品图片过滤
	 * 
	 * @param productImages
	 *            商品图片
	 */
	void filter(List<ProductImage> productImages);

	/**
	 * 生成商品图片
	 * 
	 * @param multipartFile
	 *            文件
	 * @return 商品图片
	 */
	ProductImage generate(MultipartFile multipartFile);

}