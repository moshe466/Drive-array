package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5068a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f5069b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5070c;

    public /* synthetic */ c(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, TaskCompletionSource taskCompletionSource, int i) {
        this.f5068a = i;
        this.f5069b = flutterFirebaseCrashlyticsPlugin;
        this.f5070c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5068a) {
            case 0:
                this.f5069b.lambda$checkForUnsentReports$0(this.f5070c);
                return;
            default:
                this.f5069b.lambda$didCrashOnPreviousExecution$3(this.f5070c);
                return;
        }
    }
}
