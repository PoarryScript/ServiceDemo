package tab.pannel.com.servicedemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;

public class DownloadService extends Service {
    public DownloadService() {
        LogUtils.logInfo(getClass().getSimpleName() + "DownloadService()");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.logInfo(getClass().getSimpleName() + "onCreate()");
        LogUtils.logInfo(getClass().getSimpleName() + " -->>" + Thread.currentThread().getName() + "  thread ID   " + Thread.currentThread().getId());

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        LogUtils.logInfo(getClass().getSimpleName() + "onStart()");
    }

    @Override
    public ComponentName startService(Intent service) {
        LogUtils.logInfo(getClass().getSimpleName() + "startService()");
        return super.startService(service);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.logInfo(getClass().getSimpleName() + "onDestroy()");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.logInfo(getClass().getSimpleName() + "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.logInfo(getClass().getSimpleName() + "onStartCommand()");
        Notification notification = new Notification(R.mipmap.ic_launcher_round, "通知",
                System.currentTimeMillis());

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
//        notification.setLatestEventInfo(this, "通知栏消息",
//                "notification_message", pendingIntent);
        startForeground(03, notification);
        return START_STICKY;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        LogUtils.logInfo(getClass().getSimpleName() + "onRebind()");

    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.logInfo(getClass().getSimpleName() + "onBind()");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
