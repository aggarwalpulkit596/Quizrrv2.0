package com.quizrr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Learn {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("chapters")
    @Expose
    private List<String> chapters = null;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("field")
    @Expose
    private List<String> field = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public List<String> getField() {
        return field;
    }

    public void setField(List<String> field) {
        this.field = field;
    }

}
