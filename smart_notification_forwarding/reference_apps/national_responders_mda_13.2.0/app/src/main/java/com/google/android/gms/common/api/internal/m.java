package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final Set f4912a = Collections.newSetFromMap(new WeakHashMap());

    public static <L> l<L> a(L l10, Looper looper, String str) {
        b2.p.l(l10, "Listener must not be null");
        b2.p.l(looper, "Looper must not be null");
        b2.p.l(str, "Listener type must not be null");
        return new l<>(looper, l10, str);
    }

    public static <L> l<L> b(L l10, Executor executor, String str) {
        b2.p.l(l10, "Listener must not be null");
        b2.p.l(executor, "Executor must not be null");
        b2.p.l(str, "Listener type must not be null");
        return new l<>(executor, l10, str);
    }

    public static <L> l.a<L> c(L l10, String str) {
        b2.p.l(l10, "Listener must not be null");
        b2.p.l(str, "Listener type must not be null");
        b2.p.h(str, "Listener type must not be empty");
        return new l.a<>(l10, str);
    }

    public final void d() {
        Iterator it = this.f4912a.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a();
        }
        this.f4912a.clear();
    }
}
