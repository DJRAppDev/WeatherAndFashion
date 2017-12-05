package kappaindustry.weatherandfashion;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by james on 12/4/17.
 */

@Database(entities = {Clothing.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ClothingDao clothingDao();
}
