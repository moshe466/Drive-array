package I0;

import H0.c;
import io.flutter.plugin.common.EventChannel;
import java.util.LinkedHashSet;
import java.util.Set;
import t2.AbstractC0707i;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f888a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f889b;

    /* renamed from: c, reason: collision with root package name */
    public static EventChannel.EventSink f890c;

    public static void a() {
        Set<c> u02;
        LinkedHashSet linkedHashSet = f888a;
        synchronized (linkedHashSet) {
            u02 = AbstractC0707i.u0(linkedHashSet);
            linkedHashSet.clear();
        }
        for (c cVar : u02) {
            EventChannel.EventSink eventSink = f890c;
            if (eventSink != null) {
                cVar.getClass();
                eventSink.success(187429);
            }
        }
    }
}
