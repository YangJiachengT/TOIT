package cn.liu.po;

import java.util.Date;

public class CouExam {
    private Integer id;

    private String stuId;

    private Integer courseId;

    private Date startTime;

    private Integer durationTime;

    private Integer examDurTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Integer durationTime) {
        this.durationTime = durationTime;
    }

    public Integer getExamDurTime() {
        return examDurTime;
    }

    public void setExamDurTime(Integer examDurTime) {
        this.examDurTime = examDurTime;
    }
}