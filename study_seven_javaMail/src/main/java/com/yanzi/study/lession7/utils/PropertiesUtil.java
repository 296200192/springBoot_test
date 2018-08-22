package com.yanzi.study.lession7.utils;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
*读取properties的工具类
*@author yanzi
*@Date 15:59 2018/8/22
**/
public class PropertiesUtil {

    private final ResourceBundle resource;
    private final String fileName;

    /**
     * 构造函数实例化部分对象，获取文件资源对象
     * @param fileName
     */
    public PropertiesUtil(String fileName) {
        this.fileName = fileName;
        Locale locale = new Locale("zh","CN");
        this.resource = ResourceBundle.getBundle(this.fileName,locale);
    }

    /**
     * 根据传入的key获取对象的值
     * @param key properties文件对于的key
     * @return
     */
    public String getValue(String key){
        String message = this.resource.getString(key);
        return message;
    }

    /**
     * 获取properties文件内的所以key值
     * @return
     */
    public Enumeration<String> getKey(){
        return resource.getKeys();
    }
}
