package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service")
public class Service {

    // define fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="pinakida")
    private String pinakida;

    @Column(name="xml1")
    private String xml1;

    @Column(name="xlm2")
    private String xlm2;

    @Column(name="sxolia")
    private String sxolia;


// define constructors

    public Service() {

    }

    public Service( String pinakida, String xml1, String xlm2, String sxolia) {
        this.pinakida = pinakida;
        this.xml1 = xml1;
        this.xlm2 = xlm2;
        this.sxolia = sxolia;
    }

    // define getter/setter

    public String getPinakida() {
        return pinakida;
    }

    public void setPinakida(String pinakida) {
        this.pinakida = pinakida;
    }

    public String getXml1() {
        return xml1;
    }

    public void setXml1(String xml1) {
        this.xml1 = xml1;
    }

    public String getXlm2() {
        return xlm2;
    }

    public void setXlm2(String xlm2) {
        this.xlm2 = xlm2;
    }

    public String getSxolia() {
        return sxolia;
    }

    public void setSxolia(String sxolia) {
        this.sxolia = sxolia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // define tostring

    @Override
    public String toString() {
        return ", pinakida=" + pinakida  ;
    }

}











