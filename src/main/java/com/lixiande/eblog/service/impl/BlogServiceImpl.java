package com.lixiande.eblog.service.impl;

import com.lixiande.eblog.entity.Blog;
import com.lixiande.eblog.mapper.BlogMapper;
import com.lixiande.eblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lixiande
 * @since 2020-07-03
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
