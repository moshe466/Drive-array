package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5065a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f5066b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5067c;

    public /* synthetic */ b(Map map, TaskCompletionSource taskCompletionSource, int i) {
        this.f5065a = i;
        this.f5066b = map;
        this.f5067c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5065a) {
            case 0:
                FlutterFirebaseCrashlyticsPlugin.lambda$log$5(this.f5066b, this.f5067c);
                return;
            case 1:
                FlutterFirebaseCrashlyticsPlugin.lambda$setUserIdentifier$8(this.f5066b, this.f5067c);
                return;
            default:
                FlutterFirebaseCrashlyticsPlugin.lambda$setCustomKey$9(this.f5066b, this.f5067c);
                return;
        }
    }
}
