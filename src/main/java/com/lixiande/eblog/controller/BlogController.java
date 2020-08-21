package com.lixiande.eblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lixiande.eblog.common.Result;
import com.lixiande.eblog.entity.Blog;
import com.lixiande.eblog.service.BlogService;
import com.lixiande.eblog.utils.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lixiande
 * @since 2020-07-03
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage,10);
        IPage pageData = blogService.page( page,new QueryWrapper<Blog>().orderByDesc("created"));
        return Result.succ(page,"success","200");
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable(name ="id") Long id){
        Blog blog = blogService.getById(id);
        Assert.notNull(blog,"---------未找到对应的博客------------");
        return Result.succ(blog,"Sucess Find blog ","200");
    }

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog){
        Blog temp = null;
        if(blog.getId() != null){
            temp = blogService.getById(blog.getId());
            System.out.println("文章属于：" + ShiroUtil.getProfile().getId());
            Assert.isTrue(temp.getUserId() == ShiroUtil.getProfile().getId().longValue(), "您不是博客主人，无权");
        }else {
            temp = new Blog();
            temp.setUserId((ShiroUtil.getProfile().getId()));
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtils.copyProperties(blog,temp,"id","userId", "created","status");
        blogService.saveOrUpdate(blog);
        return Result.succ(null,"成功","201");
    }

}
