package tab.pannel.com.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

import java.lang.ref.WeakReference;

public class MessageService extends Service {
    private final Messenger mMessenger = new Messenger(new InnerHandler(this));
    private static final int MESSAGE_HANDLER_FLAG = 0x01;

    public MessageService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.logInfo(getClass().getSimpleName() + "onCreate()");
        LogUtils.logInfo(getClass().getSimpleName()+" -->>"+Thread.currentThread().getName() +"  thread ID   "+Thread.currentThread().getId());

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
        return super.onStartCommand(intent, flags, startId);
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
        return mMessenger.getBinder();
    }

    private static class InnerHandler extends Handler {
        private final WeakReference<MessageService> weakReference;

        public InnerHandler(MessageService service) {
            this.weakReference = new WeakReference<>(service);
        }

        @Override
        public void handleMessage(Message msg) {
            MessageService service = weakReference.get();
            switch (msg.what) {
                case MESSAGE_HANDLER_FLAG:
                    if (null != weakReference.get()) {
                        service.stopSelf();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
}
