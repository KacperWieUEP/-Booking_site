package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student{
    @Id
    @Column(name ="id")
    private long id;
    @Column(name ="name")
    private String name;
    @Column(name ="points")
    private Integer points;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Student(String name, Integer points){

    }
}


