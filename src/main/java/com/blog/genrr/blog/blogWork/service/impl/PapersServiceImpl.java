package com.blog.genrr.blog.blogWork.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.genrr.blog.blogWork.entity.Papers;
import com.blog.genrr.blog.blogWork.mapper.PapersMapper;
import com.blog.genrr.blog.blogWork.service.IPapersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Genrr
 * @since 2021-04-08
 */
@Service
public class PapersServiceImpl extends ServiceImpl<PapersMapper, Papers> implements IPapersService {

    @Resource
    PaginationInnerInterceptor paginationInnerInterceptor;

    @Resource
    PapersMapper papersMapper;

    @Override
    public IPage getPapers(long current,int offset) {
        return papersMapper.selectPage(new Page<>(current,offset),new LambdaQueryWrapper<>());
    }

    @Override
    public IPage searchPapers(String searchVal) {
        IPage iPage = papersMapper.selectPage(new Page<>(0,200),new LambdaQueryWrapper<Papers>().like(Papers::getName,searchVal));
        return iPage;
    }
}
