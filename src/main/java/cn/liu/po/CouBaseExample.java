package cn.liu.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CouBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouBaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNull() {
            addCriterion("course_code is null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNotNull() {
            addCriterion("course_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeEqualTo(Integer value) {
            addCriterion("course_code =", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotEqualTo(Integer value) {
            addCriterion("course_code <>", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThan(Integer value) {
            addCriterion("course_code >", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_code >=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThan(Integer value) {
            addCriterion("course_code <", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThanOrEqualTo(Integer value) {
            addCriterion("course_code <=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIn(List<Integer> values) {
            addCriterion("course_code in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotIn(List<Integer> values) {
            addCriterion("course_code not in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeBetween(Integer value1, Integer value2) {
            addCriterion("course_code between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("course_code not between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(String value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(String value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(String value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(String value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLike(String value) {
            addCriterion("teacher_id like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotLike(String value) {
            addCriterion("teacher_id not like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<String> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<String> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(String value1, String value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(String value1, String value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andLeastNumberIsNull() {
            addCriterion("least_number is null");
            return (Criteria) this;
        }

        public Criteria andLeastNumberIsNotNull() {
            addCriterion("least_number is not null");
            return (Criteria) this;
        }

        public Criteria andLeastNumberEqualTo(Short value) {
            addCriterion("least_number =", value, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andLeastNumberNotEqualTo(Short value) {
            addCriterion("least_number <>", value, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andLeastNumberGreaterThan(Short value) {
            addCriterion("least_number >", value, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andLeastNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("least_number >=", value, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andLeastNumberLessThan(Short value) {
            addCriterion("least_number <", value, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andLeastNumberLessThanOrEqualTo(Short value) {
            addCriterion("least_number <=", value, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andLeastNumberIn(List<Short> values) {
            addCriterion("least_number in", values, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andLeastNumberNotIn(List<Short> values) {
            addCriterion("least_number not in", values, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andLeastNumberBetween(Short value1, Short value2) {
            addCriterion("least_number between", value1, value2, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andLeastNumberNotBetween(Short value1, Short value2) {
            addCriterion("least_number not between", value1, value2, "leastNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberIsNull() {
            addCriterion("most_number is null");
            return (Criteria) this;
        }

        public Criteria andMostNumberIsNotNull() {
            addCriterion("most_number is not null");
            return (Criteria) this;
        }

        public Criteria andMostNumberEqualTo(Short value) {
            addCriterion("most_number =", value, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberNotEqualTo(Short value) {
            addCriterion("most_number <>", value, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberGreaterThan(Short value) {
            addCriterion("most_number >", value, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("most_number >=", value, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberLessThan(Short value) {
            addCriterion("most_number <", value, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberLessThanOrEqualTo(Short value) {
            addCriterion("most_number <=", value, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberIn(List<Short> values) {
            addCriterion("most_number in", values, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberNotIn(List<Short> values) {
            addCriterion("most_number not in", values, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberBetween(Short value1, Short value2) {
            addCriterion("most_number between", value1, value2, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andMostNumberNotBetween(Short value1, Short value2) {
            addCriterion("most_number not between", value1, value2, "mostNumber");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineIsNull() {
            addCriterion("course_deadline is null");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineIsNotNull() {
            addCriterion("course_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineEqualTo(Date value) {
            addCriterionForJDBCDate("course_deadline =", value, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineNotEqualTo(Date value) {
            addCriterionForJDBCDate("course_deadline <>", value, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineGreaterThan(Date value) {
            addCriterionForJDBCDate("course_deadline >", value, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("course_deadline >=", value, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineLessThan(Date value) {
            addCriterionForJDBCDate("course_deadline <", value, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("course_deadline <=", value, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineIn(List<Date> values) {
            addCriterionForJDBCDate("course_deadline in", values, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineNotIn(List<Date> values) {
            addCriterionForJDBCDate("course_deadline not in", values, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("course_deadline between", value1, value2, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseDeadlineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("course_deadline not between", value1, value2, "courseDeadline");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagIsNull() {
            addCriterion("course_end_flag is null");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagIsNotNull() {
            addCriterion("course_end_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagEqualTo(Integer value) {
            addCriterion("course_end_flag =", value, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagNotEqualTo(Integer value) {
            addCriterion("course_end_flag <>", value, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagGreaterThan(Integer value) {
            addCriterion("course_end_flag >", value, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_end_flag >=", value, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagLessThan(Integer value) {
            addCriterion("course_end_flag <", value, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagLessThanOrEqualTo(Integer value) {
            addCriterion("course_end_flag <=", value, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagIn(List<Integer> values) {
            addCriterion("course_end_flag in", values, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagNotIn(List<Integer> values) {
            addCriterion("course_end_flag not in", values, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagBetween(Integer value1, Integer value2) {
            addCriterion("course_end_flag between", value1, value2, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCourseEndFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("course_end_flag not between", value1, value2, "courseEndFlag");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceIsNull() {
            addCriterion("course_place is null");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceIsNotNull() {
            addCriterion("course_place is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceEqualTo(String value) {
            addCriterion("course_place =", value, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceNotEqualTo(String value) {
            addCriterion("course_place <>", value, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceGreaterThan(String value) {
            addCriterion("course_place >", value, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("course_place >=", value, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceLessThan(String value) {
            addCriterion("course_place <", value, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceLessThanOrEqualTo(String value) {
            addCriterion("course_place <=", value, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceLike(String value) {
            addCriterion("course_place like", value, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceNotLike(String value) {
            addCriterion("course_place not like", value, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceIn(List<String> values) {
            addCriterion("course_place in", values, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceNotIn(List<String> values) {
            addCriterion("course_place not in", values, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceBetween(String value1, String value2) {
            addCriterion("course_place between", value1, value2, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCoursePlaceNotBetween(String value1, String value2) {
            addCriterion("course_place not between", value1, value2, "coursePlace");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeIsNull() {
            addCriterion("course_describe is null");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeIsNotNull() {
            addCriterion("course_describe is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeEqualTo(String value) {
            addCriterion("course_describe =", value, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeNotEqualTo(String value) {
            addCriterion("course_describe <>", value, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeGreaterThan(String value) {
            addCriterion("course_describe >", value, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("course_describe >=", value, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeLessThan(String value) {
            addCriterion("course_describe <", value, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeLessThanOrEqualTo(String value) {
            addCriterion("course_describe <=", value, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeLike(String value) {
            addCriterion("course_describe like", value, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeNotLike(String value) {
            addCriterion("course_describe not like", value, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeIn(List<String> values) {
            addCriterion("course_describe in", values, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeNotIn(List<String> values) {
            addCriterion("course_describe not in", values, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeBetween(String value1, String value2) {
            addCriterion("course_describe between", value1, value2, "courseDescribe");
            return (Criteria) this;
        }

        public Criteria andCourseDescribeNotBetween(String value1, String value2) {
            addCriterion("course_describe not between", value1, value2, "courseDescribe");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}