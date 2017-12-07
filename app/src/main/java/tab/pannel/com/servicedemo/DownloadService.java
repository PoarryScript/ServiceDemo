package tab.pannel.com.servicedemo;

import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

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
        //获取NotificationManager实例
        NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //实例化NotificationCompat.Builde并设置相关属性
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                //设置小图标
                .setSmallIcon(R.mipmap.ic_launcher_round)
                //设置通知标题
                .setContentTitle("最简单的Notification")
                //设置通知内容
                .setContentText("只有小图标、标题、内容");
        //设置通知时间，默认为系统发出通知的时间，通常不用设置
        //.setWhen(System.currentTimeMillis());
        //通过builder.build()方法生成Notification对象,并发送通知,id=1
        notifyManager.notify(1, builder.build());

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
