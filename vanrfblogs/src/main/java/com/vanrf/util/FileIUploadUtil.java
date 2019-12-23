package com.vanrf.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>IO文件持久层</p>
 * @author J19090104
 *
 */
public class FileIUploadUtil {

    public  static String fileupload(MultipartFile file, HttpServletRequest request){
        String fileName = file.getOriginalFilename();
        System.out.println("初始文件上传位置:"+fileName);
        if (fileName.indexOf("\\") !=-1) {
            fileName = fileName.substring(fileName.lastIndexOf("\\"));

        }
        // 获取文件存放地址
        String filePath = "E:\\fan_works\\HBuilder\\EastTest\\vanrfBlogs\\img\\blogImg\\";
        String path="/img/";
        File f = new File(filePath);
        if (!f.exists()) {
            f.mkdirs();// 不存在路径则进行创建
        }
        FileOutputStream out = null;
        try {
            // 重新自定义文件的名称
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String d = sdf.format(date);// 时间
            filePath = filePath + d + fileName;
            path=path.concat(d).concat(fileName); // /img/201911251443filename
            out = new FileOutputStream(filePath);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            try {
                out.close();
            } catch (IOException ex) {
                System.out.println("dont");
            }
            return "error";
        }
        return path;
    }
}
