package com.llw.easylibrary.bean;

/**
 * @author llw
 * @description Function 功能实体
 * @date 2021/7/22 19:55
 */
public class Function {

    private int drawable;
    private String name;

    public Function(int drawable, String name) {
        this.drawable = drawable;
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getName() {
        return name;
    }
}
