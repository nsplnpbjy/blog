package com.blog.genrr.blog.blogWork.service.impl;

import com.blog.genrr.blog.blogWork.entity.User;
import com.blog.genrr.blog.blogWork.mapper.UserMapper;
import com.blog.genrr.blog.blogWork.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Genrr
 * @since 2021-04-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
