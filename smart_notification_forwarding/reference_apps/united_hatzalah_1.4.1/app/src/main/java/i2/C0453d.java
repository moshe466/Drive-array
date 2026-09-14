package i2;

import io.flutter.plugin.common.EventChannel;

/* renamed from: i2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0453d implements EventChannel.StreamHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0451b f4989a;

    public C0453d(C0451b c0451b) {
        this.f4989a = c0451b;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onCancel(Object obj) {
        this.f4989a.f4986k = null;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.f4989a.f4986k = eventSink;
    }
}
