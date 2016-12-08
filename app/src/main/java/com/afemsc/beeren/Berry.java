package com.afemsc.beeren;



/**
 * Created by Pascal on 04.10.2016.
 */

public class Berry {

    private String name, latname, c1,c2,c3, features,poisonous, vegetation, pic, pic_s;
    private int id, form, spring, summer, autumn, winter;
    private double size_min, size_max;



    public Berry(int id, String name, String latname, String c1, String c2, String c3, String
            features, String poisonous, int form,  String pic, String pic_s, double size_min , double size_max, String vegetation, int spring, int summer, int autumn, int winter){
        this.id = id;
        this.name = name;
        this.latname = latname;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.features = features;
        this.poisonous = poisonous;
        this.form = form;
        this.pic = pic;
        this.pic_s = pic_s;
        this.size_min = size_min;
        this.size_max = size_max;
        this.vegetation = vegetation;
        this.spring = spring;
        this.summer = summer;
        this.autumn = autumn;
        this.winter = winter;
    }


    public String getName() {
        return name;
    }

    public String getLatname() {
        return latname;
    }

    public String getC1() {
        return c1;
    }

    public String getC2() {
        return c2;
    }

    public String getC3() {
        return c3;
    }

    public String getFeatures() {
        return features;
    }

    public String getPoisonous() {
        return poisonous;
    }

    public String getVegetation() {
        return vegetation;
    }

    public int getId() {
        return id;
    }

    public String getPic() {
        return pic;
    }

    public String getPic_s() {
        return pic_s;
    }

    public int getForm() {
        return form;
    }

    public int getSpring() {
        return spring;
    }

    public int getSummer() {
        return summer;
    }

    public int getAutumn() {
        return autumn;
    }

    public int getWinter() {
        return winter;
    }

    public double getSize_min() {
        return size_min;
    }

    public double getSize_max() {
        return size_max;
    }

    @Override
    public String toString() {
        return this.name;
    }












}
