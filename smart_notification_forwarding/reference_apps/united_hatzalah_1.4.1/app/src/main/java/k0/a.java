package K0;

import io.flutter.plugin.common.EventChannel;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class a implements EventChannel.StreamHandler {

    /* renamed from: a, reason: collision with root package name */
    public EventChannel f1064a;

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onCancel(Object obj) {
        LinkedHashSet linkedHashSet = I0.a.f888a;
        I0.a.f890c = null;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onListen(Object obj, EventChannel.EventSink eventSink) {
        if (eventSink != null) {
            I0.a.f890c = eventSink;
            I0.a.f889b = true;
            I0.a.a();
        }
    }
}
