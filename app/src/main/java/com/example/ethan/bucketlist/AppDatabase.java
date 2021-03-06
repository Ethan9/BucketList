package com.example.ethan.bucketlist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Bucket.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract BucketDao bucketDao();

    private final static String NAME_DATABASE = "bucket_db";
    private static AppDatabase sInstance; //Static instance

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context, AppDatabase.class, NAME_DATABASE).build();
        }

        return sInstance;
    }
}
