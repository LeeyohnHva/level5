package com.example.leey_.level5;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Bucket.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BucketDao bucketDao();

    private final static String NAME_DATABASE = "bucketlist_db";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context, AppDatabase.class, NAME_DATABASE).build();
        }

        return sInstance;
    }
}
