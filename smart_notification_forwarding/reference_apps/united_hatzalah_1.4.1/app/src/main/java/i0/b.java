package I0;

import F0.G1;
import H0.j;
import io.flutter.plugin.common.EventChannel;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import t2.AbstractC0707i;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f891a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f892b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f893c;

    /* renamed from: d, reason: collision with root package name */
    public static EventChannel.EventSink f894d;

    /* renamed from: e, reason: collision with root package name */
    public static G1 f895e;

    public static void a(j threat) {
        EventChannel.EventSink eventSink;
        kotlin.jvm.internal.j.e(threat, "threat");
        if (f893c && (eventSink = f894d) != null) {
            eventSink.success(Integer.valueOf(threat.f879a));
            return;
        }
        LinkedHashSet linkedHashSet = f891a;
        synchronized (linkedHashSet) {
            linkedHashSet.add(threat);
        }
    }

    public static void b() {
        ArrayList s02;
        G1 g12;
        ArrayList arrayList = f892b;
        synchronized (arrayList) {
            s02 = AbstractC0707i.s0(arrayList);
            arrayList.clear();
        }
        if (!s02.isEmpty() && (g12 = f895e) != null) {
            g12.m(s02);
        }
    }

    public static void c() {
        Set<j> u02;
        LinkedHashSet linkedHashSet = f891a;
        synchronized (linkedHashSet) {
            u02 = AbstractC0707i.u0(linkedHashSet);
            linkedHashSet.clear();
        }
        for (j jVar : u02) {
            EventChannel.EventSink eventSink = f894d;
            if (eventSink != null) {
                eventSink.success(Integer.valueOf(jVar.f879a));
            }
        }
    }
}
