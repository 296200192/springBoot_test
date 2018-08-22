package com.yanzi.study.lession7.enums;

/**
*邮件格式枚举
*@author yanzi
*@Date 15:19 2018/8/22
**/
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"), //html格式
    TEXT("text")
    ;
    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
