package l2;

import F0.G1;
import F0.RunnableC0064o;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.EventChannel;

/* renamed from: l2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0519b extends BroadcastReceiver implements EventChannel.StreamHandler {

    /* renamed from: a, reason: collision with root package name */
    public final G1 f5485a;

    /* renamed from: b, reason: collision with root package name */
    public EventChannel.EventSink f5486b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f5487c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    public C0518a f5488d;

    public C0519b(Context context, G1 g12) {
        this.f5485a = g12;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onCancel(Object obj) {
        C0518a c0518a = this.f5488d;
        if (c0518a != null) {
            ((ConnectivityManager) this.f5485a.f218b).unregisterNetworkCallback(c0518a);
            this.f5488d = null;
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.f5486b = eventSink;
        C0518a c0518a = new C0518a(this);
        this.f5488d = c0518a;
        G1 g12 = this.f5485a;
        ((ConnectivityManager) g12.f218b).registerDefaultNetworkCallback(c0518a);
        ConnectivityManager connectivityManager = (ConnectivityManager) g12.f218b;
        this.f5487c.post(new RunnableC0064o(15, this, G1.j(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()))));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        EventChannel.EventSink eventSink = this.f5486b;
        if (eventSink != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f5485a.f218b;
            eventSink.success(G1.j(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())));
        }
    }
}
