package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5061a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin f5062b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f5063c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5064d;

    public /* synthetic */ a(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, Map map, TaskCompletionSource taskCompletionSource, int i) {
        this.f5061a = i;
        this.f5062b = flutterFirebaseCrashlyticsPlugin;
        this.f5063c = map;
        this.f5064d = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5061a) {
            case 0:
                this.f5062b.lambda$recordError$4(this.f5063c, this.f5064d);
                return;
            default:
                this.f5062b.lambda$setCrashlyticsCollectionEnabled$7(this.f5063c, this.f5064d);
                return;
        }
    }
}
