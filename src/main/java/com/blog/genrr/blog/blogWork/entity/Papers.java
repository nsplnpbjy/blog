package com.blog.genrr.blog.blogWork.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Genrr
 * @since 2021-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Papers implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String name;

    private String inside;

    public Papers(String name,String inside){
        this.setName(name);
        this.setInside(inside);
    }

}
