package i2;

import F0.Q2;
import F0.RunnableC0064o;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class i implements MethodChannel.Result {

    /* renamed from: a, reason: collision with root package name */
    public final MethodChannel.Result f5005a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f5006b = new Handler(Looper.getMainLooper());

    public i(MethodChannel.Result result) {
        this.f5005a = result;
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public final void error(String errorCode, String str, Object obj) {
        j.e(errorCode, "errorCode");
        this.f5006b.post(new com.google.firebase.crashlytics.internal.metadata.a(this, errorCode, str, obj, 5));
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public final void notImplemented() {
        this.f5006b.post(new Q2(this, 9));
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public final void success(Object obj) {
        this.f5006b.post(new RunnableC0064o(12, this, obj));
    }
}
