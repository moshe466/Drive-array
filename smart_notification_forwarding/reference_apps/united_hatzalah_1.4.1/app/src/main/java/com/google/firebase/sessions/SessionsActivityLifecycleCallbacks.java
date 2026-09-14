package com.google.firebase.sessions;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.j;
import s2.C0684i;

/* loaded from: classes.dex */
public final class SessionsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public static final SessionsActivityLifecycleCallbacks INSTANCE = new SessionsActivityLifecycleCallbacks();
    private static boolean hasPendingForeground;
    private static SessionLifecycleClient lifecycleClient;

    private SessionsActivityLifecycleCallbacks() {
    }

    public static /* synthetic */ void getHasPendingForeground$com_google_firebase_firebase_sessions$annotations() {
    }

    public final boolean getHasPendingForeground$com_google_firebase_firebase_sessions() {
        return hasPendingForeground;
    }

    public final SessionLifecycleClient getLifecycleClient() {
        return lifecycleClient;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        j.e(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = lifecycleClient;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.backgrounded();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        C0684i c0684i;
        j.e(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = lifecycleClient;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.foregrounded();
            c0684i = C0684i.f6340a;
        } else {
            c0684i = null;
        }
        if (c0684i == null) {
            hasPendingForeground = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        j.e(activity, "activity");
        j.e(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        j.e(activity, "activity");
    }

    public final void setHasPendingForeground$com_google_firebase_firebase_sessions(boolean z3) {
        hasPendingForeground = z3;
    }

    public final void setLifecycleClient(SessionLifecycleClient sessionLifecycleClient) {
        lifecycleClient = sessionLifecycleClient;
        if (sessionLifecycleClient != null && hasPendingForeground) {
            hasPendingForeground = false;
            sessionLifecycleClient.foregrounded();
        }
    }
}
