package com.quizrr;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("chapters")
    @Expose
    private List<Chapter> chapters = null;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("field")
    @Expose
    private List<String> field = null;
    @SerializedName("chapterCount")
    @Expose
    private Integer chapterCount;
    @SerializedName("topicCount")
    @Expose
    private Integer topicCount;
    @SerializedName("inCompleteQuiz")
    @Expose
    private Object inCompleteQuiz;
    @SerializedName("accuracy")
    @Expose
    private Integer accuracy;
    @SerializedName("quizTaken")
    @Expose
    private Integer quizTaken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
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

    public Integer getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }

    public Integer getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(Integer topicCount) {
        this.topicCount = topicCount;
    }

    public Object getInCompleteQuiz() {
        return inCompleteQuiz;
    }

    public void setInCompleteQuiz(Object inCompleteQuiz) {
        this.inCompleteQuiz = inCompleteQuiz;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getQuizTaken() {
        return quizTaken;
    }

    public void setQuizTaken(Integer quizTaken) {
        this.quizTaken = quizTaken;
    }

}