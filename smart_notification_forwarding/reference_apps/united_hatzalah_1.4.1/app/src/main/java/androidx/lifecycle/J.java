package androidx.lifecycle;

import F0.C0047j2;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public class J extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3558b = 0;

    /* renamed from: a, reason: collision with root package name */
    public C0047j2 f3559a;

    /* loaded from: classes.dex */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final I Companion = new Object();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            kotlin.jvm.internal.j.e(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f3558b;
            H.a(activity, EnumC0303m.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f3558b;
            H.a(activity, EnumC0303m.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f3558b;
            H.a(activity, EnumC0303m.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f3558b;
            H.a(activity, EnumC0303m.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f3558b;
            H.a(activity, EnumC0303m.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f3558b;
            H.a(activity, EnumC0303m.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.j.e(activity, "activity");
            kotlin.jvm.internal.j.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }
    }

    public final void a(EnumC0303m enumC0303m) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            kotlin.jvm.internal.j.d(activity, "activity");
            H.a(activity, enumC0303m);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(EnumC0303m.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(EnumC0303m.ON_DESTROY);
        this.f3559a = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(EnumC0303m.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        C0047j2 c0047j2 = this.f3559a;
        if (c0047j2 != null) {
            ((G) c0047j2.f546b).a();
        }
        a(EnumC0303m.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        C0047j2 c0047j2 = this.f3559a;
        if (c0047j2 != null) {
            G g3 = (G) c0047j2.f546b;
            int i = g3.f3550a + 1;
            g3.f3550a = i;
            if (i == 1 && g3.f3553d) {
                g3.f3555f.e(EnumC0303m.ON_START);
                g3.f3553d = false;
            }
        }
        a(EnumC0303m.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(EnumC0303m.ON_STOP);
    }
}
