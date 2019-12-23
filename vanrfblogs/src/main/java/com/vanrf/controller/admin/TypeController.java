package com.vanrf.controller.admin;

import com.vanrf.bean.Type;
import com.vanrf.mapper.TypeDao;
import com.vanrf.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://127.0.0.1:8848")
@RequestMapping("/type")
@RestController
public class TypeController {
    @Autowired
    private TypeDao typeDao;

    /**
     * 分页查询
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/selectAllByPage")
    public Map<Object, Object> selectAllByPage(int page, int limit, @RequestParam(required = false,defaultValue = "",value = "typeName") String typeName) {
        System.out.println(typeName);
        HashMap<Object, Object> map = new HashMap<>();
        long offset = (page - 1) * limit;
        List<Type> list = typeDao.selectByLimit(offset, limit,"%" + typeName + "%");
        long count = typeDao.typeCount();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    /**
     * 添加
     */
    @RequestMapping("/addType")
    public String addType(Type type, String typeName) {
        System.out.println(typeName);
        type.setTypeName(typeName);
        Integer i = typeDao.addType(type);
        if (i >= 0) {
            System.out.println("添加成功");
            return i + "";
        }
        return "";
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteTypeById")
    public String addType(Integer typeId) {
        System.out.println(typeId);
        Integer i = typeDao.deleteTypeById(typeId);
        if (i >= 0) {
            System.out.println("删除成功");
            return i + "";
        }
        return "";
    }

    /**
     * 更改
     */
    @RequestMapping("/updateTypeById")
    public String updateTypeById(Integer typeId,String typeName) {
        Integer i = typeDao.updateTypeById(typeId,typeName);
        if (i >= 0) {
            System.out.println("更改成功");
            return i + "";
        }
        return "";
    }
    /**
     * 查找全部
     */
    @RequestMapping("/findTypeName")
        public Msg findTypeName() {
        List<Type> type = typeDao.findTypeName();
        return Msg.success().add("data", type);
        }
}
