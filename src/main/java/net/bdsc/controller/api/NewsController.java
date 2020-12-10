package net.bdsc.controller.api;

import com.fasterxml.jackson.annotation.JsonView;
import net.bdsc.common.Result;
import net.bdsc.entity.Article;
import net.bdsc.entity.BaseEntity;
import net.bdsc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/user/v2/new")
public class NewsController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/detail")
    @JsonView(BaseEntity.ViewView.class)
    public Result detail(Integer type,Long userId1){

        return Result.success(articleService.findLastest());
    }
}
