package cn.liu.po;

import java.util.Date;

public class CouBase {
    private Integer id;

    private Integer courseCode;

    private String className;

    private String teacherId;

    private Date startTime;

    private Date endTime;

    private Short leastNumber;

    private Short mostNumber;

    private Date courseDeadline;

    private Integer courseEndFlag;

    private String coursePlace;

    private String courseDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getLeastNumber() {
        return leastNumber;
    }

    public void setLeastNumber(Short leastNumber) {
        this.leastNumber = leastNumber;
    }

    public Short getMostNumber() {
        return mostNumber;
    }

    public void setMostNumber(Short mostNumber) {
        this.mostNumber = mostNumber;
    }

    public Date getCourseDeadline() {
        return courseDeadline;
    }

    public void setCourseDeadline(Date courseDeadline) {
        this.courseDeadline = courseDeadline;
    }

    public Integer getCourseEndFlag() {
        return courseEndFlag;
    }

    public void setCourseEndFlag(Integer courseEndFlag) {
        this.courseEndFlag = courseEndFlag;
    }

    public String getCoursePlace() {
        return coursePlace;
    }

    public void setCoursePlace(String coursePlace) {
        this.coursePlace = coursePlace == null ? null : coursePlace.trim();
    }

    public String getCourseDescribe() {
        return courseDescribe;
    }

    public void setCourseDescribe(String courseDescribe) {
        this.courseDescribe = courseDescribe == null ? null : courseDescribe.trim();
    }
}