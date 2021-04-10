package com.blog.genrr.blog.blogWork.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.genrr.blog.blogWork.entity.Papers;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.invoke.empty.Empty;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author nsplnpbjy
 */
@Slf4j
public class PaperGetterUtil {

    static Set<String> oneUrlSet = new HashSet<String>();
    static Set<String> twoUrlSet = new HashSet<String>();

    public static void saver(BaseMapper baseMapper,String paperName,String html){
        Papers papers = new Papers(paperName,html);
        if (baseMapper.selectOne(new LambdaQueryWrapper<Papers>().eq(Papers::getName,paperName))==null){
            baseMapper.insert(papers);
        }
        else {
            log.info("已避免重复下载: "+paperName);
        }
    }

    public static void marxEngels(BaseMapper baseMapper){
        Document document = null;
        try{
            document = Jsoup.connect("https://www.marxists.org/chinese/marx-engels/index.htm").get();
        } catch (Exception e) {
            log.warn("主站连接失败");
            return;
        }
        Element div = document.select("div").first();
        Element innerDiv = div.select("div").first();
        Element table = innerDiv.selectFirst("table");
        Elements as = table.select("a[href]");
        for (Element a :
                as) {
                String nextHref = "https://www.marxists.org/chinese/marx-engels/"+a.attr("href");
                Document innerDocument = null;
                try{
                    innerDocument = Jsoup.connect(nextHref).get();
                } catch (Exception e) {
                    log.warn("连接失败: "+nextHref);
                    break;
                }
                Elements paperAs = innerDocument.select("a[href]");
                Elements temPaperAs = new Elements();
                for (int i = 0;i<4;i++){
                    temPaperAs.add(paperAs.get(i));
                }
                paperAs.removeAll(temPaperAs);
            for (Element paper :
                    paperAs) {
                Document paperDoc = null;
                String paperName = paper.text();
                paperName = paperName.replace("…","");
                String nextNextHref = nextHref.replace("index.htm","")+paper.attr("href");
                try{
                    paperDoc = Jsoup.connect(nextNextHref).get();
                } catch (Exception e) {
                    log.warn("连接失败: "+nextNextHref);
                    break;
                }
                String imgMainUrl = nextNextHref.substring(0,nextNextHref.lastIndexOf("/")+1);
                Elements imgs = paperDoc.select("img[src]");
                for (Element img :
                        imgs) {
                    img.attr("src",imgMainUrl+img.attr("src"));
                    log.info("图片地址已修改为: "+img.attr("src"));
                }
                log.info("正在下载:"+paperName);
                PaperGetterUtil.saver(baseMapper,paperName, paperDoc.html());
            }

        }

    }

}
