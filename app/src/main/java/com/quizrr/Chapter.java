package com.quizrr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Chapter {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("topics")
    @Expose
    private List<String> topics = null;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("subjectId")
    @Expose
    private String subjectId;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("quizes")
    @Expose
    private Integer quizes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getQuizes() {
        return quizes;
    }

    public void setQuizes(Integer quizes) {
        this.quizes = quizes;
    }

}