package com.attacomsian.exportcsv.data;

import com.opencsv.bean.CsvBindByPosition;

public class User {

//    Enable columns positions if you want to
//    have your customs order.

//    @CsvBindByPosition(position = 0)
    private long id;
//    @CsvBindByPosition(position = 1)
    private String name;
//    @CsvBindByPosition(position = 2)
    private String email;
//    @CsvBindByPosition(position = 3)
    private String country;
//    @CsvBindByPosition(position = 4)
    private int age;

    public User(long id, String name, String email, String country, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                '}';
    }
}
