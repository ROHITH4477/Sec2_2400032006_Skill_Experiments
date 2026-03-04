package com.klu.beans;

public class Student {

    // dependencies of type primitive
    private int sid;
    private String sname;

    // object dependencies
    private Course course;
    private Address address;

    // setters and getters
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // additional method to get student details
    public void getStudentDetails() {
        System.out.println("Student ID:" + sid);
        System.out.println("Student Name:" + sname);
        course.displayCourseDetails();
        address.displayAddressDetails();
    }
}
