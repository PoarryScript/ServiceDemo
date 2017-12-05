package tab.pannel.com.servicedemo;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private Messenger messenger;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.logInfo(getClass().getSimpleName()+" -->>"+Thread.currentThread().getName() +"  thread ID"+Thread.currentThread().getId());
        findViewById(R.id.start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DownloadService.class);
                startService(intent);
            }
        });

        final ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                messenger = new Messenger(iBinder);

                LogUtils.logInfo("onServiceConnected   componentName==>" + componentName + ">>>>>>" + iBinder.pingBinder());
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                messenger  =null;
                LogUtils.logInfo("onServiceDisconnected  componentName==>" + componentName);
            }
        };

        findViewById(R.id.bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MessageService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.intent_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
               startService(intent);
            }
        });
    }

}
