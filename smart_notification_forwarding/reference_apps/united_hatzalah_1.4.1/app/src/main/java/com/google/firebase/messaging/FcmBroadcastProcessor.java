package com.google.firebase.messaging;

import J.C0119g;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class FcmBroadcastProcessor {
    private static final String EXTRA_BINARY_DATA = "rawData";
    private static final String EXTRA_BINARY_DATA_BASE_64 = "gcm.rawData64";
    private static WithinAppServiceConnection fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor;

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.concurrent.Executor, java.lang.Object] */
    public FcmBroadcastProcessor(Context context) {
        this.context = context;
        this.executor = new Object();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.concurrent.Executor, java.lang.Object] */
    private static Task<Integer> bindToMessagingService(Context context, Intent intent, boolean z3) {
        Log.isLoggable(Constants.TAG, 3);
        WithinAppServiceConnection serviceConnection = getServiceConnection(context, "com.google.firebase.MESSAGING_EVENT");
        if (z3) {
            if (ServiceStarter.getInstance().hasWakeLockPermission(context)) {
                WakeLockHolder.sendWakefulServiceIntent(context, serviceConnection, intent);
            } else {
                serviceConnection.sendIntent(intent);
            }
            return Tasks.forResult(-1);
        }
        return serviceConnection.sendIntent(intent).continueWith(new Object(), new C0119g(23));
    }

    public static /* synthetic */ Integer c(Task task) {
        return lambda$bindToMessagingService$3(task);
    }

    public static /* synthetic */ Integer d(Task task) {
        return lambda$startMessagingService$1(task);
    }

    private static WithinAppServiceConnection getServiceConnection(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            try {
                if (fcmServiceConn == null) {
                    fcmServiceConn = new WithinAppServiceConnection(context, str);
                }
                withinAppServiceConnection = fcmServiceConn;
            } catch (Throwable th) {
                throw th;
            }
        }
        return withinAppServiceConnection;
    }

    public static /* synthetic */ Integer lambda$bindToMessagingService$3(Task task) {
        return -1;
    }

    public static /* synthetic */ Integer lambda$startMessagingService$0(Context context, Intent intent) {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(context, intent));
    }

    public static /* synthetic */ Integer lambda$startMessagingService$1(Task task) {
        return 403;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.concurrent.Executor, java.lang.Object] */
    public static /* synthetic */ Task lambda$startMessagingService$2(Context context, Intent intent, boolean z3, Task task) {
        if (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) {
            return bindToMessagingService(context, intent, z3).continueWith(new Object(), new C0119g(22));
        }
        return task;
    }

    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }

    public static void setServiceConnection(WithinAppServiceConnection withinAppServiceConnection) {
        synchronized (lock) {
            fcmServiceConn = withinAppServiceConnection;
        }
    }

    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_BINARY_DATA_BASE_64);
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra(EXTRA_BINARY_DATA_BASE_64);
        }
        return startMessagingService(this.context, intent);
    }

    public Task<Integer> startMessagingService(final Context context, final Intent intent) {
        boolean z3;
        final boolean z4 = false;
        if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((intent.getFlags() & 268435456) != 0) {
            z4 = true;
        }
        if (z3 && !z4) {
            return bindToMessagingService(context, intent, z4);
        }
        return Tasks.call(this.executor, new Callable() { // from class: com.google.firebase.messaging.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer lambda$startMessagingService$0;
                lambda$startMessagingService$0 = FcmBroadcastProcessor.lambda$startMessagingService$0(context, intent);
                return lambda$startMessagingService$0;
            }
        }).continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.messaging.c
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task lambda$startMessagingService$2;
                lambda$startMessagingService$2 = FcmBroadcastProcessor.lambda$startMessagingService$2(context, intent, z4, task);
                return lambda$startMessagingService$2;
            }
        });
    }

    public FcmBroadcastProcessor(Context context, ExecutorService executorService) {
        this.context = context;
        this.executor = executorService;
    }
}
