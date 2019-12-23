package com.vanrf.controller.admin;

import com.vanrf.bean.Diary;
import com.vanrf.bean.Type;
import com.vanrf.mapper.DiaryDao;
import com.vanrf.mapper.TypeDao;
import com.vanrf.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://127.0.0.1:8848")
@RequestMapping("/diary")
@RestController
public class DiaryController {
    @Autowired
    private DiaryDao diaryDao;

    /**
     * 分页查询
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/selectAllByPage")
    public Map<Object, Object> selectAllByPage(int page, int limit, @RequestParam(required = false,defaultValue = "",value = "content") String content) {
        HashMap<Object, Object> map = new HashMap<>();
        long offset = (page - 1) * limit;
        List<Type> list = diaryDao.selectByLimit(offset, limit,"%" + content + "%");
        long count = diaryDao.diaryCount();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);
        return map;
    }
    /**
     * 添加
     */
    @RequestMapping("/addDiary")
    public String addType(Diary diary, String content, String imgs) {
        System.out.println(content);
        System.out.println(imgs);
        return "";
    }

}
