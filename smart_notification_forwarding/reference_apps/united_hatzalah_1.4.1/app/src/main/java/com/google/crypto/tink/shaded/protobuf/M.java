package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class M {
    public static void a(Object obj, Object obj2) {
        L l3 = (L) obj;
        if (obj2 == null) {
            if (!l3.isEmpty()) {
                Iterator it = l3.entrySet().iterator();
                if (!it.hasNext()) {
                    return;
                }
                Map.Entry entry = (Map.Entry) it.next();
                entry.getKey();
                entry.getValue();
                throw null;
            }
            return;
        }
        throw new ClassCastException();
    }

    public static L b(Object obj, Object obj2) {
        L l3 = (L) obj;
        L l4 = (L) obj2;
        if (!l4.isEmpty()) {
            if (!l3.f4052a) {
                l3 = l3.c();
            }
            l3.b();
            if (!l4.isEmpty()) {
                l3.putAll(l4);
            }
        }
        return l3;
    }
}
