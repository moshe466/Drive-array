package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
public class ServiceStarter {
    static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    static final int ERROR_ILLEGAL_STATE_EXCEPTION = 402;
    static final int ERROR_ILLEGAL_STATE_EXCEPTION_FALLBACK_TO_BIND = 403;
    static final int ERROR_NOT_FOUND = 404;
    static final int ERROR_SECURITY_EXCEPTION = 401;
    public static final int ERROR_UNKNOWN = 500;
    private static final String EXTRA_WRAPPED_INTENT = "wrapped_intent";
    private static final String PERMISSIONS_MISSING_HINT = "this should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    public static final int SUCCESS = -1;
    private static ServiceStarter instance;
    private String firebaseMessagingServiceClassName = null;
    private Boolean hasWakeLockPermission = null;
    private Boolean hasAccessNetworkStatePermission = null;
    private final Queue<Intent> messagingEvents = new ArrayDeque();

    private ServiceStarter() {
    }

    private int doStartService(Context context, Intent intent) {
        ComponentName startService;
        String resolveServiceClassName = resolveServiceClassName(context, intent);
        if (resolveServiceClassName != null) {
            Log.isLoggable(Constants.TAG, 3);
            intent.setClassName(context.getPackageName(), resolveServiceClassName);
        }
        try {
            if (hasWakeLockPermission(context)) {
                startService = WakeLockHolder.startWakefulService(context, intent);
            } else {
                startService = context.startService(intent);
            }
            if (startService == null) {
                Log.e(Constants.TAG, "Error while delivering the message: ServiceIntent not found.");
                return ERROR_NOT_FOUND;
            }
            return -1;
        } catch (IllegalStateException e4) {
            Log.e(Constants.TAG, "Failed to start service while in background: " + e4);
            return ERROR_ILLEGAL_STATE_EXCEPTION;
        } catch (SecurityException e5) {
            Log.e(Constants.TAG, "Error while delivering the message to the serviceIntent", e5);
            return ERROR_SECURITY_EXCEPTION;
        }
    }

    public static synchronized ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            try {
                if (instance == null) {
                    instance = new ServiceStarter();
                }
                serviceStarter = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceStarter;
    }

    private synchronized String resolveServiceClassName(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        try {
            String str2 = this.firebaseMessagingServiceClassName;
            if (str2 != null) {
                return str2;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
                if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                    if (str.startsWith(".")) {
                        this.firebaseMessagingServiceClassName = context.getPackageName() + serviceInfo.name;
                    } else {
                        this.firebaseMessagingServiceClassName = serviceInfo.name;
                    }
                    return this.firebaseMessagingServiceClassName;
                }
                Log.e(Constants.TAG, "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + RemoteSettings.FORWARD_SLASH_STRING + serviceInfo.name);
                return null;
            }
            Log.e(Constants.TAG, "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void setForTesting(ServiceStarter serviceStarter) {
        instance = serviceStarter;
    }

    public Intent getMessagingEvent() {
        return this.messagingEvents.poll();
    }

    public boolean hasAccessNetworkStatePermission(Context context) {
        boolean z3;
        if (this.hasAccessNetworkStatePermission == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.hasAccessNetworkStatePermission = Boolean.valueOf(z3);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    public boolean hasWakeLockPermission(Context context) {
        boolean z3;
        if (this.hasWakeLockPermission == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.hasWakeLockPermission = Boolean.valueOf(z3);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.hasWakeLockPermission.booleanValue();
    }

    public int startMessagingService(Context context, Intent intent) {
        Log.isLoggable(Constants.TAG, 3);
        this.messagingEvents.offer(intent);
        Intent intent2 = new Intent(ACTION_MESSAGING_EVENT);
        intent2.setPackage(context.getPackageName());
        return doStartService(context, intent2);
    }
}
