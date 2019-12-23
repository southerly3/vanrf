package com.vanrf.mapper;

import com.vanrf.bean.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogDao {
    @Select("select * from t_blog WHERE typeName LIKE #{title} limit ${offset}, ${limit}")
    List<Blog>  selectByLimit(@Param("offset") Long offset, @Param("limit") Integer limit, @Param("title") String title);
    @Select("select count(*) from t_blog")
    long  BlogCount();
    @Insert("insert into t_blog(blogId,title,author,contentMd,contentHTML,views,createTime,updateTime,state,publish,blogType,imgs,typeName,intro) values(null,#{title},#{author},#{contentMd},#{contentHTML},#{views},#{createTime},#{updateTime},#{state},#{publish},#{blogType},#{imgs},#{typeName},#{intro})")
    Integer addBlog(Blog blog);
    @Delete("delete from t_blog where blogId=#{blogId}")
    Integer deleteBlogById(Integer blogId);
    @Update("UPDATE t_blog SET title = #{title},contentMd = #{contentMd},contentHTML = #{contentHTML},typeName = #{typeName},blogType = #{blogType},intro = #{intro},updateTime = #{updateTime} WHERE blogId = #{blogId}")
    Integer updateBlogById(String title, String contentMd, String contentHTML, String typeName, String blogType, String intro, String updateTime, Integer blogId);
    @Select("SELECT * FROM t_blog where blogId=#{blogId}")
    Blog selectOneById(Integer blogId);
    @Select("SELECT * FROM t_blog ORDER BY views desc limit #{limit}")
    List<Blog> selectBlogByViews(Integer limit);
    @Select("SELECT * FROM t_blog ")
    List<Blog> selectAll();
}
