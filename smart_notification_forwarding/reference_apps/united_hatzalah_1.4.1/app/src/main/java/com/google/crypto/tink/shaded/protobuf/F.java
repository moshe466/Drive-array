package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class F extends H {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f4044c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(Object obj, int i, long j2) {
        List arrayList;
        List list = (List) n0.f4138c.i(j2, obj);
        if (list.isEmpty()) {
            if (list instanceof E) {
                arrayList = new D(i);
            } else if ((list instanceof X) && (list instanceof A)) {
                arrayList = ((A) list).a(i);
            } else {
                arrayList = new ArrayList(i);
            }
            n0.p(obj, j2, arrayList);
            return arrayList;
        }
        if (f4044c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList2 = new ArrayList(list.size() + i);
            arrayList2.addAll(list);
            n0.p(obj, j2, arrayList2);
            return arrayList2;
        }
        if (list instanceof i0) {
            D d2 = new D(list.size() + i);
            d2.addAll((i0) list);
            n0.p(obj, j2, d2);
            return d2;
        }
        if ((list instanceof X) && (list instanceof A)) {
            A a2 = (A) list;
            if (!((AbstractC0330b) a2).f4085a) {
                A a4 = a2.a(list.size() + i);
                n0.p(obj, j2, a4);
                return a4;
            }
        }
        return list;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.H
    public final void a(long j2, Object obj) {
        Object unmodifiableList;
        List list = (List) n0.f4138c.i(j2, obj);
        if (list instanceof E) {
            unmodifiableList = ((E) list).e();
        } else if (!f4044c.isAssignableFrom(list.getClass())) {
            if ((list instanceof X) && (list instanceof A)) {
                AbstractC0330b abstractC0330b = (AbstractC0330b) ((A) list);
                if (abstractC0330b.f4085a) {
                    abstractC0330b.f4085a = false;
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        } else {
            return;
        }
        n0.p(obj, j2, unmodifiableList);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.H
    public final void b(Object obj, long j2, Object obj2) {
        List list = (List) n0.f4138c.i(j2, obj2);
        List d2 = d(obj, list.size(), j2);
        int size = d2.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            d2.addAll(list);
        }
        if (size > 0) {
            list = d2;
        }
        n0.p(obj, j2, list);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.H
    public final List c(long j2, Object obj) {
        return d(obj, 10, j2);
    }
}
