package com.vanrf.mapper;

import com.vanrf.bean.Diary;
import com.vanrf.bean.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DiaryDao {
    @Select("select * from  t_diary")
    List<Diary> findDiary();
    @Select("select * from t_diary WHERE content LIKE #{content} limit ${offset}, ${limit}")
    List<Type>  selectByLimit(@Param("offset")Long offset, @Param("limit")Integer limit, @Param("content")String conetHTML);
    @Select("select count(*) from t_diary")
    long  diaryCount();
    @Insert("insert into t_diary values(null,#{content},#{imgs},#{createTime})")
    Integer addDiary(Diary diary);
   /*
    @Delete("delete from t_diary where typeId=#{typeId}")
    Integer deleteDiaryById(Integer diaryId);
    @Update("UPDATE t_diary SET typeName = #{typeName} WHERE diaryId = #{diaryId}")
    Integer updateDiaryById(Integer diaryId,String typeName);*/

}
