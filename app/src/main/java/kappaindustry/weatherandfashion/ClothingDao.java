package kappaindustry.weatherandfashion;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

/**
 * Created by james on 12/3/17.
 */

@Dao()
public interface ClothingDao {
    @Query("SELECT * FROM CLOTHING WHERE ")
    public Clothing getClothing(int age, int gender);
}
