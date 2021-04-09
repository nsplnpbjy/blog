package com.blog.genrr.blog.blogWork.controller;


import com.blog.genrr.blog.blogWork.service.IPapersService;
import com.blog.genrr.blog.blogWork.utils.ResponseData;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Genrr
 * @since 2021-04-05
 */
@CrossOrigin
@RestController
@RequestMapping("/blogWork/papers")
public class PapersController {

    @Resource
    IPapersService iPapersService;

    @GetMapping("/get")
    public ResponseData getPaper(@RequestParam("current") long current, @RequestParam("offset")int offset){
        return ResponseData.good(iPapersService.getPapers(current,offset));
    }

    @GetMapping("/search")
    public ResponseData searchPaper(@RequestParam("searchVal")String searchVal){
        return ResponseData.good(iPapersService.searchPapers(searchVal));
    }

}
