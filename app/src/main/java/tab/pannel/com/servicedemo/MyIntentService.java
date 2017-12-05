package tab.pannel.com.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "tab.pannel.com.servicedemo.action.FOO";
    private static final String ACTION_BAZ = "tab.pannel.com.servicedemo.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "tab.pannel.com.servicedemo.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "tab.pannel.com.servicedemo.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
        LogUtils.logInfo(getClass().getSimpleName()+"MyIntentService()");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.logInfo(getClass().getSimpleName()+"onCreate()");
        LogUtils.logInfo(getClass().getSimpleName()+" -->>"+Thread.currentThread().getName() +"  thread ID"+Thread.currentThread().getId());
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        LogUtils.logInfo(getClass().getSimpleName()+"onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.logInfo(getClass().getSimpleName()+"onBind()");
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.logInfo(getClass().getSimpleName()+"onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        LogUtils.logInfo(getClass().getSimpleName()+"onStart()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.logInfo(getClass().getSimpleName()+"onDestroy()");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        LogUtils.logInfo(getClass().getSimpleName()+"onHandleIntent()");
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
