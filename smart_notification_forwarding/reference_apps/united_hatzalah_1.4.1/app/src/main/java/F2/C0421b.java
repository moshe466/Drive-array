package f2;

import F0.Q2;
import F0.RunnableC0064o;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.MethodChannel;
import java.util.Objects;

/* renamed from: f2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0421b implements MethodChannel.Result {

    /* renamed from: a, reason: collision with root package name */
    public final MethodChannel.Result f4604a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f4605b = new Handler(Looper.getMainLooper());

    public C0421b(MethodChannel.Result result) {
        this.f4604a = result;
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public final void error(String str, String str2, Object obj) {
        this.f4605b.post(new com.google.firebase.crashlytics.internal.metadata.a(this, str, str2, obj, 4));
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public final void notImplemented() {
        MethodChannel.Result result = this.f4604a;
        Objects.requireNonNull(result);
        this.f4605b.post(new Q2(result, 8));
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public final void success(Object obj) {
        this.f4605b.post(new RunnableC0064o(9, this, obj));
    }
}
