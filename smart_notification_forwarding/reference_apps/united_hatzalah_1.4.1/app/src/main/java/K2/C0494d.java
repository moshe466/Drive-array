package k2;

import android.app.Activity;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import kotlin.jvm.internal.j;

/* renamed from: k2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0494d implements InterfaceC0491a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPluginBinding f5291a;

    public C0494d(ActivityPluginBinding activityPluginBinding) {
        this.f5291a = activityPluginBinding;
    }

    @Override // k2.InterfaceC0491a
    public final Activity a() {
        Activity activity = this.f5291a.getActivity();
        j.d(activity, "getActivity(...)");
        return activity;
    }

    @Override // k2.InterfaceC0491a
    public final void b(C0496f c0496f) {
        this.f5291a.addActivityResultListener(c0496f);
    }
}
