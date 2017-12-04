package kappaindustry.weatherandfashion;

import android.arch.persistence.room.Entity;

/**
 * Created by james on 12/3/17.
 */

@Entity(tableName = "clothing")
public class Clothing {
    public int getAgeID() {
        return ageID;
    }

    public void setAgeID(int ageID) {
        this.ageID = ageID;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getHat() {
        return hat;
    }

    public void setHat(String hat) {
        this.hat = hat;
    }

    public String getOuterwear() {
        return outerwear;
    }

    public void setOuterwear(String outerwear) {
        this.outerwear = outerwear;
    }

    public String getPants() {
        return pants;
    }

    public void setPants(String pants) {
        this.pants = pants;
    }

    private int ageID;
    private int gender;
    private String hat;
    private String outerwear;
    private String pants;

}
