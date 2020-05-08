package com.fehead.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @program: conference
 * @description: ${description}
 * @author: smile丶
 * @create: 2019-02-22 08:05
 **/
public class StringUtils {

    /*
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }



    /**
     * 修改文件名
     * @param fileName
     * @return
     */
    public static String reName(String fileName) {

        String suffix = fileName.substring(fileName.lastIndexOf("."));
        if (fileName.isEmpty() || fileName == null || suffix.isEmpty()) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String date_string = sdf.format(date);
        String toNumber = date_string.replaceAll("[[\\s-:punct:]]","");

        String name = toNumber + suffix;

        return name;
    }

}
