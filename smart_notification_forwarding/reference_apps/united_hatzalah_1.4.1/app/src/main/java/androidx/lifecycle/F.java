package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* loaded from: classes.dex */
public final class F extends AbstractC0297g {
    final /* synthetic */ G this$0;

    /* loaded from: classes.dex */
    public static final class a extends AbstractC0297g {
        final /* synthetic */ G this$0;

        public a(G g3) {
            this.this$0 = g3;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            G g3 = this.this$0;
            int i = g3.f3550a + 1;
            g3.f3550a = i;
            if (i == 1 && g3.f3553d) {
                g3.f3555f.e(EnumC0303m.ON_START);
                g3.f3553d = false;
            }
        }
    }

    public F(G g3) {
        this.this$0 = g3;
    }

    @Override // androidx.lifecycle.AbstractC0297g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.j.e(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i = J.f3558b;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            kotlin.jvm.internal.j.c(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((J) findFragmentByTag).f3559a = this.this$0.f3557k;
        }
    }

    @Override // androidx.lifecycle.AbstractC0297g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.j.e(activity, "activity");
        G g3 = this.this$0;
        int i = g3.f3551b - 1;
        g3.f3551b = i;
        if (i == 0) {
            Handler handler = g3.f3554e;
            kotlin.jvm.internal.j.b(handler);
            handler.postDelayed(g3.f3556j, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.j.e(activity, "activity");
        E.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.AbstractC0297g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.j.e(activity, "activity");
        G g3 = this.this$0;
        int i = g3.f3550a - 1;
        g3.f3550a = i;
        if (i == 0 && g3.f3552c) {
            g3.f3555f.e(EnumC0303m.ON_STOP);
            g3.f3553d = true;
        }
    }
}
