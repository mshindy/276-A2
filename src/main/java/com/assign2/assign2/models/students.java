package com.assign2.assign2.models;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String name;
    private String hair;
    private int height;
    private int weight;
    private double gpa;
    
    public students(){}
    
    public students( String name, String hair, int height, int weight, double gpa){
        this.name = name;
        this.hair = hair;
        this.height = height;
        this.weight = weight;
        this.gpa = gpa;
    }
    
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHair() {
        return hair;
    }
    public void setHair(String hair) {
        this.hair = hair;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
