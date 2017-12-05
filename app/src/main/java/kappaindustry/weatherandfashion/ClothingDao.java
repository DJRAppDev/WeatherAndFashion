package kappaindustry.weatherandfashion;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

@Dao
public interface ClothingDao {
    @Query("SELECT * FROM clothing WHERE temperature IS :temperature AND gender IS :gender AND style IS :style")
    Clothing getClothing(String temperature,String gender,String style);
}
