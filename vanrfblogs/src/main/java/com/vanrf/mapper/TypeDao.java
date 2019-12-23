package com.vanrf.mapper;

import com.vanrf.bean.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TypeDao  {
    @Select("select * from t_type WHERE typeName LIKE #{typeName} limit ${offset}, ${limit}")
    List<Type>  selectByLimit(@Param("offset")Long offset, @Param("limit")Integer limit, @Param("typeName")String typeName);
    @Select("select count(*) from t_type")
    long  typeCount();
    @Insert("insert into t_type values(null,#{typeName})")
    Integer addType(Type type);
    @Delete("delete from t_type where typeId=#{typeId}")
    Integer deleteTypeById(Integer typeId);
    @Update("UPDATE t_type SET typeName = #{typeName} WHERE typeId = #{typeId}")
    Integer updateTypeById(Integer typeId,String typeName);
    @Select("select * from  t_type")
    List<Type> findTypeName();
}
