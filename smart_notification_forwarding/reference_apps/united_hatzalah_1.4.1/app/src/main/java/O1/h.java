package o1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* loaded from: classes.dex */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f5929a;

    public h(j jVar) {
        this.f5929a = jVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity act, Bundle bundle) {
        kotlin.jvm.internal.j.e(act, "act");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity act) {
        kotlin.jvm.internal.j.e(act, "act");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity act) {
        Window window;
        View decorView;
        kotlin.jvm.internal.j.e(act, "act");
        j jVar = this.f5929a;
        if (act.equals(jVar.f5933c) && jVar.f5940m) {
            Window window2 = act.getWindow();
            if (window2 != null) {
                window2.clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
            }
            j.b(jVar, act);
            return;
        }
        if (act.equals(jVar.f5933c) && jVar.f5941n) {
            Window window3 = act.getWindow();
            if (window3 != null) {
                window3.clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
            }
            j.a(jVar, act);
            return;
        }
        if (act.equals(jVar.f5933c) && jVar.f5942o) {
            Window window4 = act.getWindow();
            if (window4 != null) {
                window4.clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
            }
            if (jVar.f5944r == null && (window = act.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                act.runOnUiThread(new e(act, decorView, jVar));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity act) {
        kotlin.jvm.internal.j.e(act, "act");
        j jVar = this.f5929a;
        if (act.equals(jVar.f5933c) && jVar.f5940m) {
            jVar.g();
            Window window = act.getWindow();
            if (window != null) {
                window.addFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
                return;
            }
            return;
        }
        if (act.equals(jVar.f5933c) && jVar.f5941n) {
            jVar.e();
            Window window2 = act.getWindow();
            if (window2 != null) {
                window2.addFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
                return;
            }
            return;
        }
        if (act.equals(jVar.f5933c) && jVar.f5942o) {
            jVar.f();
            Window window3 = act.getWindow();
            if (window3 != null) {
                window3.addFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity act, Bundle outState) {
        Window window;
        View decorView;
        kotlin.jvm.internal.j.e(act, "act");
        kotlin.jvm.internal.j.e(outState, "outState");
        j jVar = this.f5929a;
        if (act.equals(jVar.f5933c) && jVar.f5940m) {
            j.b(jVar, act);
            return;
        }
        if (act.equals(jVar.f5933c) && jVar.f5941n) {
            j.a(jVar, act);
            return;
        }
        if (act.equals(jVar.f5933c) && jVar.f5942o && jVar.f5944r == null && (window = act.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            act.runOnUiThread(new e(act, decorView, jVar));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity act) {
        kotlin.jvm.internal.j.e(act, "act");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity act) {
        kotlin.jvm.internal.j.e(act, "act");
    }
}
