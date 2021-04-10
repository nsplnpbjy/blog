package com.blog.genrr.blog.blogWork.schdule;

import com.blog.genrr.blog.blogWork.config.PaperUrlProperties;
import com.blog.genrr.blog.blogWork.mapper.PapersMapper;
import com.blog.genrr.blog.blogWork.utils.PaperGetterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author nsplnpbjy
 */
@Slf4j
@EnableConfigurationProperties(PaperUrlProperties.class)
@Component
@EnableAsync
public class PaperGetter {

    @Resource
    PapersMapper papersMapper;

    @Resource
    PaperUrlProperties paperUrlProperties;

    @Async
    @Scheduled(initialDelay = 1000,fixedRate = 2678400000L)
    public void getPaperOne(){
        PaperGetterUtil.paperGetter(papersMapper,paperUrlProperties.getMarxUrl());
    }

    @Async
    @Scheduled(initialDelay = 1000,fixedRate = 2678400000L)
    public void getPaperTwo(){
        PaperGetterUtil.paperGetter(papersMapper,paperUrlProperties.getLeninUrl());
    }
}
