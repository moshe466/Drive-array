package K1;

import F0.AbstractC0008a;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f1083b = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f1084a;

    public e(e eVar) {
        this.f1084a = new ConcurrentHashMap(eVar.f1084a);
    }

    public final synchronized d a(String str) {
        if (this.f1084a.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return (d) this.f1084a.get(str);
    }

    public final synchronized void b(R1.d dVar) {
        boolean b4;
        int a2 = dVar.a();
        if (a2 != 1) {
            b4 = AbstractC0008a.c(a2);
        } else {
            b4 = AbstractC0008a.b(a2);
        }
        if (b4) {
            c(new d(dVar));
        } else {
            throw new GeneralSecurityException("failed to register key manager " + dVar.getClass() + " as it is not FIPS compatible.");
        }
    }

    public final synchronized void c(d dVar) {
        try {
            R1.d dVar2 = dVar.f1082a;
            Class cls = dVar2.f1986c;
            if (!dVar2.f1985b.keySet().contains(cls) && !Void.class.equals(cls)) {
                throw new IllegalArgumentException("Given internalKeyMananger " + dVar2.toString() + " does not support primitive class " + cls.getName());
            }
            String b4 = dVar2.b();
            d dVar3 = (d) this.f1084a.get(b4);
            if (dVar3 != null && !dVar3.f1082a.getClass().equals(dVar.f1082a.getClass())) {
                f1083b.warning("Attempted overwrite of a registered key manager for key type ".concat(b4));
                throw new GeneralSecurityException("typeUrl (" + b4 + ") is already registered with " + dVar3.f1082a.getClass().getName() + ", cannot be re-registered with " + dVar.f1082a.getClass().getName());
            }
            this.f1084a.putIfAbsent(b4, dVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public e() {
        this.f1084a = new ConcurrentHashMap();
    }
}
