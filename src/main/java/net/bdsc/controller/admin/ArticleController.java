/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: D5oWd4GV+f+TVVKSMnqqgZFMu8AUqmw4
 */
package net.bdsc.controller.admin;

import java.util.HashSet;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bdsc.Pageable;
import net.bdsc.Results;
import net.bdsc.entity.Article;
import net.bdsc.service.ArticleCategoryService;
import net.bdsc.service.ArticleService;
import net.bdsc.service.ArticleTagService;

/**
 * Controller - 文章
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("adminArticleController")
@RequestMapping("/admin/article")
public class ArticleController extends BaseController {

	@Inject
	private ArticleService articleService;
	@Inject
	private ArticleCategoryService articleCategoryService;
	@Inject
	private ArticleTagService articleTagService;

	/**
	 * 添加
	 */
	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("articleCategoryTree", articleCategoryService.findTree());
		model.addAttribute("articleTags", articleTagService.findAll());
		return "admin/article/add";
	}

	/**
	 * 保存
	 */
	@PostMapping("/save")
	public ResponseEntity<?> save(Article article, Long articleCategoryId, Long[] articleTagIds) {
		article.setArticleCategory(articleCategoryService.find(articleCategoryId));
		article.setArticleTags(new HashSet<>(articleTagService.findList(articleTagIds)));
		if (!isValid(article)) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		article.setHits(0L);
		articleService.save(article);
		return Results.OK;
	}

	/**
	 * 编辑
	 */
	@GetMapping("/edit")
	public String edit(Long id, ModelMap model) {
		model.addAttribute("articleCategoryTree", articleCategoryService.findTree());
		model.addAttribute("articleTags", articleTagService.findAll());
		model.addAttribute("article", articleService.find(id));
		return "admin/article/edit";
	}

	/**
	 * 更新
	 */
	@PostMapping("/update")
	public ResponseEntity<?> update(Article article, Long articleCategoryId, Long[] articleTagIds) {
		article.setArticleCategory(articleCategoryService.find(articleCategoryId));
		article.setArticleTags(new HashSet<>(articleTagService.findList(articleTagIds)));
		if (!isValid(article)) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		articleService.update(article, "hits");
		return Results.OK;
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public String list(Pageable pageable, ModelMap model) {
		model.addAttribute("page", articleService.findPage(pageable));
		return "admin/article/list";
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	public ResponseEntity<?> delete(Long[] ids) {
		articleService.delete(ids);
		return Results.OK;
	}

}