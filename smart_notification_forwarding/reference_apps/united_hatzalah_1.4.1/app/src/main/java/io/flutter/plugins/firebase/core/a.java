package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5048a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5049b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Boolean f5050c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5051d;

    public /* synthetic */ a(String str, Boolean bool, TaskCompletionSource taskCompletionSource, int i) {
        this.f5048a = i;
        this.f5049b = str;
        this.f5050c = bool;
        this.f5051d = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5048a) {
            case 0:
                FlutterFirebaseCorePlugin.g(this.f5049b, this.f5050c, this.f5051d);
                return;
            default:
                FlutterFirebaseCorePlugin.i(this.f5049b, this.f5050c, this.f5051d);
                return;
        }
    }
}
