package org.openapitools.server.notification;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;


@Database(entities = NotificationClass.class, version = 1)
public abstract class NotificationDatabase extends RoomDatabase {

    public abstract NotificationDAO notificationDAO();



    protected NotificationDatabase(){}
    private static NotificationDatabase INSTANCE;



    public static NotificationDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), NotificationDatabase.class, "notifications").build();
        }
        return INSTANCE;
    }

}
