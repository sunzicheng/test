package com.itheima.ssm.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    /**
     * 实现转换逻辑的方法
     */
    @Override
    public Date convert(String source) {
        // 1.日期格式化对象(2018-07-15 17:22:30)
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // 转换成功，直接返回
            return format.parse(source);
        } catch (ParseException e) {
            // 转换异常，再按照yyyy-MM-dd HH:mm格式转换
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                // 转换成功，直接返回
                return format.parse(source);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }

        // 转换失败，返回null
        return null;

    }
}
