package com.vanrf.controller.admin;

import com.vanrf.bean.Blog;
import com.vanrf.bean.Type;
import com.vanrf.mapper.BlogDao;
import com.vanrf.util.CopyFile;
import com.vanrf.util.FileIUploadUtil;
import com.vanrf.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://127.0.0.1:8848")
@RequestMapping("/blog")
@RestController
public class BlogController {
    @Autowired
    private BlogDao blogDao;
    private String fileName = null;

    /**
     * 分页查询
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/selectAllByPage")
    public Map<Object, Object> selectAllByPage(int page, int limit, @RequestParam(required = false, defaultValue = "", value = "title") String title) {
        HashMap<Object, Object> map = new HashMap<>();
        long offset = (page - 1) * limit;
        List<Blog> list = blogDao.selectByLimit(offset, limit, "%" + title + "%");
        long count = blogDao.BlogCount();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);
        return map;
    }


    /**
     * 删除
     */
    @RequestMapping("/deleteBlogById")
    public String deleteBlog(Integer blogId) {
        Integer i = blogDao.deleteBlogById(blogId);
        if (i >= 0) {
            System.out.println("删除成功");
            return i + "";
        }
        return "";
    }

    @RequestMapping("/selectOneById")
    public Msg selectOneById(Integer blogId) {
        Blog blog = blogDao.selectOneById(blogId);
        return Msg.success().add("data", blog);
    }


    /**
     * 上传图片
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/addImg")
    public String addImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(file);
        if (file.isEmpty()) {
            System.out.println("文件未上传!");
        } else {
            // 得到上传的文件名
            fileName = file.getOriginalFilename();
            System.out.println("图片的名称" + fileName);
            String filePath = "E:\\fan_works\\HBuilder\\EastTest\\vanrfBlogs\\img\\blogImg\\";
            // 把文件上传至path的路径
            File localFile = new File(filePath, fileName);
            if (!localFile.exists()) {
                localFile.mkdirs();
            }
            file.transferTo(localFile);
            return 1 + "";
        }
        return "";
    }

    /**
     * 添加
     *
     * @param blog
     * @param title
     * @param contentMd
     * @param contentHTML
     * @param blogType
     * @param typeName
     * @param intro       这五个数据是从前端传过来的
     * @return
     * @throws Exception
     */
    @RequestMapping("/addBlog")
    public String addBlog(Blog blog, String title, String contentMd, String contentHTML, String blogType, String typeName, String intro) throws Exception {
        System.out.println("aaa" + this.fileName);
        String imgs = "img/blogImg/" + this.fileName;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String time = sdf.format(date);// 时间
        blog.setTitle(title);
        blog.setAuthor("vanrf");  //作者为默认
        blog.setIntro(intro);
        blog.setContentMd(contentMd);
        blog.setContentHTML(contentHTML);
        blog.setTypeName(typeName);
        blog.setBlogType(blogType);
        blog.setCreateTime(time);
        blog.setUpdateTime(null);
        blog.setImgs(imgs);
        blog.setViews(1);
        blog.setState(1);  //默认状态显示
        blog.setPublish(1); //默认是发布的
        Integer i = blogDao.addBlog(blog);
        if (i >= 1) {
            System.out.println("添加成功");
            return i + "";
        }
        System.out.println("添加失败");
        return "";
    }

    /**
     * 更改
     */
    @RequestMapping("/updateTypeById")
    public String updateTypeById(Integer blogId, String title, String contentMd, String contentHTML, String blogType, String typeName, String intro) {
        System.out.println(blogId);
        System.out.println(title);
        System.out.println(contentMd);
        System.out.println(contentHTML);
        System.out.println(blogType);
        System.out.println(typeName);
        System.out.println(intro);
        System.out.println("aaa" + this.fileName);
        String imgs = "img/blogImg/" + this.fileName;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String updateTime = sdf.format(date);// 时间
        Integer i = blogDao.updateBlogById(title, contentMd, contentHTML, typeName, blogType, intro, updateTime, blogId);
        if (i >= 1) {
            System.out.println("修改成功");
            return i + "";
        }
        System.out.println("修改失败");
        return "";
    }

    /**
     * 更改
     */
    @RequestMapping("/selectBlogByViews")
    public Msg selectBlogByViews(Integer limit) {
        List<Blog> blogs = blogDao.selectBlogByViews(3);
        return Msg.success().add("data", blogs);
    }

    /**
     * 更改
     */
    @RequestMapping("/selectAll")
    public Msg selectAll() {
        List<Blog> blogs = blogDao.selectAll();
        return Msg.success().add("data", blogs);
    }
}
