package com.attacomsian.xml.models;

import java.util.Date;
import java.util.List;

public class Course {

    private int id;
    private String title;
    private double price;
    private Date created;
    private List<Student> students;

    public Course(int id, String title, double price, Date created) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", created=" + created +
                ", students=" + students +
                '}';
    }
}
