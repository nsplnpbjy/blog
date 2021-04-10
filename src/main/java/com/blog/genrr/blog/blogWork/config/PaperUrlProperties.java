package com.blog.genrr.blog.blogWork.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author nsplnpbjy
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "paper")
public class PaperUrlProperties {
    private String marxUrl;
    private String leninUrl;
}
