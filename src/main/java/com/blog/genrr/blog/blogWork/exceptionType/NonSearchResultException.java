package com.blog.genrr.blog.blogWork.exceptionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

/**
 * @author nsplnpbjy
 */
@AllArgsConstructor
@Getter
@Setter
public class NonSearchResultException extends Exception {
    private String msg;
    private int code;
}
