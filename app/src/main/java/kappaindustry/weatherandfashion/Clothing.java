package kappaindustry.weatherandfashion;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by james on 12/3/17.
 */

@Entity(tableName = "clothing")
public class Clothing {
    @PrimaryKey
    @NonNull
    private int id;
    private String temperature;
    private String gender;
    private String style;
    private String hat,outerwear,pants;

    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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
}
