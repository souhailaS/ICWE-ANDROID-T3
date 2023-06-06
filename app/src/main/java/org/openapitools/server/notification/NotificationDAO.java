package org.openapitools.server.notification;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;



@Dao
public interface NotificationDAO {

    @Query("SELECT * FROM notifications")
    List<NotificationClass> getAll();


    @Insert
    void insertNotification(NotificationClass notification);
}
