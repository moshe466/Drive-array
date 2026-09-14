package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5052a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCorePlugin f5053b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5054c;

    public /* synthetic */ b(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, TaskCompletionSource taskCompletionSource, int i) {
        this.f5052a = i;
        this.f5053b = flutterFirebaseCorePlugin;
        this.f5054c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5052a) {
            case 0:
                FlutterFirebaseCorePlugin.l(this.f5053b, this.f5054c);
                return;
            default:
                FlutterFirebaseCorePlugin.j(this.f5053b, this.f5054c);
                return;
        }
    }
}
