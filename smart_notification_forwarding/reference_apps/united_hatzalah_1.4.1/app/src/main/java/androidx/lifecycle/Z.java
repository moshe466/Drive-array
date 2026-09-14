package androidx.lifecycle;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class Z {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3594a = new LinkedHashMap();

    public final void a() {
        LinkedHashMap linkedHashMap = this.f3594a;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((V) it.next()).a();
        }
        linkedHashMap.clear();
    }
}
