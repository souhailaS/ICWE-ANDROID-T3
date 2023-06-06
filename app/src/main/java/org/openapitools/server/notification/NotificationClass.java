package org.openapitools.server.notification;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notifications")
public class NotificationClass {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "resource")
    public String resource;

    @ColumnInfo(name = "method")
    public String method;

    public NotificationClass(String resource,String method){
        this.resource=resource;
        this.method=method;
    }


    @Override
    public String toString() {
        return "Resource Execution: "+ resource + " | Method: "+ method;
    }
}
