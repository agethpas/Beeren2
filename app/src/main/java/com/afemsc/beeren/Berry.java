package com.afemsc.beeren;



/**
 * Created by Pascal on 04.10.2016.
 */

public class Berry {

    private String name, latname, c1,c2,c3, features,poisonous, poisonous_extra, pic, pic_s;
    private int id;



    public Berry(int id,String name, String latname, String c1, String c2, String c3, String
            features,String poisonous, String poisonous_extra, String pic, String pic_s){
        this.id = id;
        this.name = name;
        this.latname = latname;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.features = features;
        this.poisonous = poisonous;
        this.poisonous_extra = poisonous_extra;
        this.pic = pic;
        this.pic_s = pic_s;
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

    public String getPoisonous_extra() {
        return poisonous_extra;
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

    @Override
    public String toString() {
        return this.name;
    }












}
