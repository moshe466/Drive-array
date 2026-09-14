package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class j8 extends h8 {

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?> f5411c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private j8() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> e(Object obj, long j10, int i10) {
        List<L> b10;
        f8 f8Var;
        List<L> f10 = f(obj, j10);
        if (!f10.isEmpty()) {
            if (f5411c.isAssignableFrom(f10.getClass())) {
                ArrayList arrayList = new ArrayList(f10.size() + i10);
                arrayList.addAll(f10);
                f8Var = arrayList;
            } else if (f10 instanceof ia) {
                f8 f8Var2 = new f8(f10.size() + i10);
                f8Var2.addAll((ia) f10);
                f8Var = f8Var2;
            } else {
                if (!(f10 instanceof j9) || !(f10 instanceof u7)) {
                    return f10;
                }
                u7 u7Var = (u7) f10;
                if (u7Var.zza()) {
                    return f10;
                }
                b10 = u7Var.b(f10.size() + i10);
            }
            na.j(obj, j10, f8Var);
            return f8Var;
        }
        b10 = f10 instanceof e8 ? new f8(i10) : ((f10 instanceof j9) && (f10 instanceof u7)) ? ((u7) f10).b(i10) : new ArrayList<>(i10);
        na.j(obj, j10, b10);
        return b10;
    }

    private static <E> List<E> f(Object obj, long j10) {
        return (List) na.F(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h8
    public final <E> void b(Object obj, Object obj2, long j10) {
        List f10 = f(obj2, j10);
        List e10 = e(obj, j10, f10.size());
        int size = e10.size();
        int size2 = f10.size();
        if (size > 0 && size2 > 0) {
            e10.addAll(f10);
        }
        if (size > 0) {
            f10 = e10;
        }
        na.j(obj, j10, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h8
    public final void d(Object obj, long j10) {
        Object unmodifiableList;
        List list = (List) na.F(obj, j10);
        if (list instanceof e8) {
            unmodifiableList = ((e8) list).h();
        } else {
            if (f5411c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof j9) && (list instanceof u7)) {
                u7 u7Var = (u7) list;
                if (u7Var.zza()) {
                    u7Var.n();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        na.j(obj, j10, unmodifiableList);
    }
}
