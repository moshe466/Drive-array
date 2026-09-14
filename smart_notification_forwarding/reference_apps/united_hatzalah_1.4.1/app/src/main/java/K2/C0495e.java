package k2;

import android.app.Activity;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import kotlin.jvm.internal.j;

/* renamed from: k2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0495e implements InterfaceC0491a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPluginBinding f5292a;

    public C0495e(ActivityPluginBinding activityPluginBinding) {
        this.f5292a = activityPluginBinding;
    }

    @Override // k2.InterfaceC0491a
    public final Activity a() {
        Activity activity = this.f5292a.getActivity();
        j.d(activity, "getActivity(...)");
        return activity;
    }

    @Override // k2.InterfaceC0491a
    public final void b(C0496f c0496f) {
        this.f5292a.addActivityResultListener(c0496f);
    }
}
