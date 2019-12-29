package com.xiahe.entity;

import java.util.List;

public class Page extends Entity {
    //分页
    private int index;
    private int count;
    private int size;

    //条件查询
    private String condition;
    private String content;

    //批量操作
    private List<Integer> ids;

    public Page() {
        size = 7;//默认每页条数
        condition = "id";//默认查询条件
        content = "";//默认查询内容
    }

    public Page(int index, int count, int size) {
        this.index = index;
        this.count = count;
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

}
