package org.openapitools.server;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.openapitools.server.notification.NotificationClass;
import org.openapitools.server.notification.NotificationDatabase;
import android.widget.Toast;
import java.util.ArrayList;

import org.openapitools.server.service.MQTTService;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private TextView mqttState;
    private ListView listView;
    private ArrayList<NotificationClass> arrayNotifications = new ArrayList<>();
    private ArrayAdapter<NotificationClass> adapter;

    private Intent mServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mqttState = (TextView) findViewById(R.id.mqttState);
        listView = (ListView) findViewById(R.id.list_notification);
        adapter = new ArrayAdapter<NotificationClass>(this, android.R.layout.simple_list_item_1, arrayNotifications);

        if(arrayNotifications.isEmpty()){
           new AsyncLoadNotification().execute(0);
        }

        listView.setAdapter(adapter);

        startServiceMQTT();

    }

    private void startServiceMQTT() {
        MQTTService service = new MQTTService();
        mServiceIntent = new Intent(this, service.getClass());


        boolean run = isMyServiceRunning(service.getClass());
          Log.d(TAG, " - Run1: " + run);
          if (!isMyServiceRunning(service.getClass())) {
            startService(mServiceIntent);

          }
          Log.d(TAG, " - Run1: " + run);

    }


    @Override
    protected void onResume() {
        super.onResume();
        //TODO Clear all notification
        NotificationManager not = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        not.cancelAll();
        LocalBroadcastManager.getInstance(MainActivity.this).registerReceiver(broadcastReceiver, new IntentFilter("NOW"));
        LocalBroadcastManager.getInstance(MainActivity.this).registerReceiver(broadcastReceiverState, new IntentFilter("STATE"));


    }


    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(MainActivity.this).registerReceiver(broadcastReceiver, new IntentFilter("NOW"));
        LocalBroadcastManager.getInstance(MainActivity.this).registerReceiver(broadcastReceiverState, new IntentFilter("STATE"));
    }




    private BroadcastReceiver broadcastReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            new AsyncLoadNotification().execute(0);
        }
    };

    private BroadcastReceiver broadcastReceiverState= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean state= intent.getBooleanExtra("state",false);
            if(state)
                mqttState.setText("Connected");
            else
                mqttState.setText("Not Connected");
        }
    };


    class AsyncLoadNotification extends AsyncTask<Integer,Void,Void>{

        @Override
        protected Void doInBackground(Integer... notifications) {
            NotificationDatabase db= NotificationDatabase.getInstance(getApplicationContext());
            arrayNotifications.clear();
            arrayNotifications.addAll(db.notificationDAO().getAll());



            runOnUiThread(new Runnable() {
                public void run() {
                    adapter.notifyDataSetChanged();
                }
            });
            return null;
        }
    }


    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i("Service status", "Running");
                return true;
            }
        }
        Log.i("Service status", "Not running");
        return false;
    }
    
}