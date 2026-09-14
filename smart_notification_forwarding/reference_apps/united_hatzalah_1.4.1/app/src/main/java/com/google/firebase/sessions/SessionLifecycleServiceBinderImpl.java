package com.google.firebase.sessions;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import s2.C0684i;

/* loaded from: classes.dex */
public final class SessionLifecycleServiceBinderImpl implements SessionLifecycleServiceBinder {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "LifecycleServiceBinder";
    private final Context appContext;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public SessionLifecycleServiceBinderImpl(Context appContext) {
        j.e(appContext, "appContext");
        this.appContext = appContext;
    }

    private final Object unbindServiceSafely(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return C0684i.f6340a;
        } catch (IllegalArgumentException e4) {
            return Integer.valueOf(Log.w(TAG, "Session lifecycle service binding failed.", e4));
        }
    }

    @Override // com.google.firebase.sessions.SessionLifecycleServiceBinder
    public void bindToService(Messenger callback, ServiceConnection serviceConnection) {
        boolean z3;
        j.e(callback, "callback");
        j.e(serviceConnection, "serviceConnection");
        Intent intent = new Intent(this.appContext, (Class<?>) SessionLifecycleService.class);
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra(SessionLifecycleService.CLIENT_CALLBACK_MESSENGER, callback);
        intent.setPackage(this.appContext.getPackageName());
        try {
            z3 = this.appContext.bindService(intent, serviceConnection, 65);
        } catch (SecurityException unused) {
            z3 = false;
        }
        if (!z3) {
            unbindServiceSafely(this.appContext, serviceConnection);
        }
    }
}
