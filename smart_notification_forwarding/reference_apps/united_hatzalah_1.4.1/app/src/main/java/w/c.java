package w;

import F0.RunnableC0091v;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public Object f6622a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f6623b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6624c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6625d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6626e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6627f = false;

    public c(Activity activity) {
        this.f6623b = activity;
        this.f6624c = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f6623b == activity) {
            this.f6623b = null;
            this.f6626e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.f6626e && !this.f6627f && !this.f6625d) {
            Object obj = this.f6622a;
            try {
                Object obj2 = d.f6630c.get(activity);
                if (obj2 == obj && activity.hashCode() == this.f6624c) {
                    d.f6634g.postAtFrontOfQueue(new RunnableC0091v(9, d.f6629b.get(activity), obj2));
                    this.f6627f = true;
                    this.f6622a = null;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while fetching field values", th);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f6623b == activity) {
            this.f6625d = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
