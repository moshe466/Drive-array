package R1;

import F0.C0084t0;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f1990b = new g();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f1991a = new AtomicReference(new m(new C0084t0()));

    public final Class a(Class cls) {
        HashMap hashMap = ((m) this.f1991a.get()).f2001b;
        if (hashMap.containsKey(cls)) {
            return ((K1.n) hashMap.get(cls)).a();
        }
        throw new GeneralSecurityException("No input primitive class for " + cls + " available");
    }

    public final synchronized void b(k kVar) {
        C0084t0 c0084t0 = new C0084t0((m) this.f1991a.get());
        c0084t0.l(kVar);
        this.f1991a.set(new m(c0084t0));
    }
}
