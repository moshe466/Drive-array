package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5055a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5056b;

    public /* synthetic */ c(int i, TaskCompletionSource taskCompletionSource) {
        this.f5055a = i;
        this.f5056b = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5055a) {
            case 0:
                FlutterFirebasePluginRegistry.a(this.f5056b);
                return;
            case 1:
                FlutterFirebaseCrashlyticsPlugin.lambda$deleteUnsentReports$2(this.f5056b);
                return;
            case 2:
                FlutterFirebaseCrashlyticsPlugin.lambda$sendUnsentReports$6(this.f5056b);
                return;
            default:
                FlutterFirebaseCrashlyticsPlugin.lambda$didReinitializeFirebaseCore$12(this.f5056b);
                return;
        }
    }
}
