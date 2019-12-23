package com.vanrf.util;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CopyFile {
    public static void copy(String url1, String url2, String newfileName) throws Exception {
        File file = new File(url1);
        File copyFile = null;

        if (file.exists()) {		//当第一个文件存在的时候
            copyFile = new File(url2);
            if (!copyFile.exists()) {	//如果copyfile不存在的话，就新建文件夹
                copyFile.mkdirs();
            }

            //将备份的文件名改成yyyyMMdd格式
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
            String format = sdf.format(date);
            newfileName=format+".csv";

            //文件io
            FileInputStream in = new FileInputStream(new File(url1));
            FileOutputStream out = new FileOutputStream(new File(url2 + "\\" + newfileName));
            byte[] buff = new byte[512];
            int n = 0;
            System.out.println("复制文件：\n源路径：" + url1 + "\n" + "目标路径：" + url2 + "\\" + newfileName);
            while ((n = in.read(buff)) != -1) {
                out.write(buff, 0, n);
            }
            out.flush();
            in.close();
            out.close();
            System.out.println("复制完成");
        } else {
            System.out.println("源文件不存在");
        }

    }

 /*   @Test
    public void test() throws Exception{
        CopyFile cp=new CopyFile();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String d = sdf.format(date);// 时间
        String fileName="blogImg"+d+".jpg";
        System.out.println(fileName);
        String filePath = "E:\\fan_works\\HBuilder\\EastTest\\vanrfBlogs\\img\\blogImg\\";
        cp.copy("C:\\fakepath\\2.jpg", filePath, fileName);
    }*/
}
