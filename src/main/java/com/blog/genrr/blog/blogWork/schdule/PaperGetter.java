package com.blog.genrr.blog.blogWork.schdule;

import com.blog.genrr.blog.blogWork.mapper.PapersMapper;
import com.blog.genrr.blog.blogWork.utils.PaperGetterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author nsplnpbjy
 */
@Slf4j
@Component
public class PaperGetter {

    @Resource
    PapersMapper papersMapper;

    @Scheduled(initialDelay = 1000,fixedRate = 2678400000L)
    public void getPaper(){
        PaperGetterUtil.marxEngels(papersMapper);

    }
}
