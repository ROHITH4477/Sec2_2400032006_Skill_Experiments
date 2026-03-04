package com.klu.beans;

public class Course {

    // course id should be String (alphanumeric)
    private String cid;
    private String cname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void displayCourseDetails() {
        System.out.println("Course ID:" + cid);
        System.out.println("Course Name:" + cname);
    }
}
