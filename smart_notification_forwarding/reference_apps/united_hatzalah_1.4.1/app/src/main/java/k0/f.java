package K0;

import io.flutter.plugin.common.EventChannel;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class f implements EventChannel.StreamHandler {

    /* renamed from: a, reason: collision with root package name */
    public EventChannel f1079a;

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onCancel(Object obj) {
        LinkedHashSet linkedHashSet = I0.b.f891a;
        I0.b.f894d = null;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onListen(Object obj, EventChannel.EventSink eventSink) {
        if (eventSink != null) {
            I0.b.f894d = eventSink;
            I0.b.f893c = true;
            I0.b.c();
        }
    }
}
