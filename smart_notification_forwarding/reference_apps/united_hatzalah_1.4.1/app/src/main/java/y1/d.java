package y1;

import A.n;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import z1.C0795a;

/* loaded from: classes.dex */
public final class d implements v1.b {
    @Override // r2.InterfaceC0645a
    public final Object get() {
        n nVar = new n(2);
        HashMap hashMap = new HashMap();
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            hashMap.put(q1.d.f6150a, new z1.b(30000L, 86400000L, set));
            if (set != null) {
                hashMap.put(q1.d.f6152c, new z1.b(1000L, 86400000L, set));
                if (set != null) {
                    Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(z1.d.f6848b)));
                    if (unmodifiableSet != null) {
                        hashMap.put(q1.d.f6151b, new z1.b(86400000L, 86400000L, unmodifiableSet));
                        if (hashMap.keySet().size() >= q1.d.values().length) {
                            new HashMap();
                            return new C0795a(nVar, hashMap);
                        }
                        throw new IllegalStateException("Not all priorities have been configured");
                    }
                    throw new NullPointerException("Null flags");
                }
                throw new NullPointerException("Null flags");
            }
            throw new NullPointerException("Null flags");
        }
        throw new NullPointerException("Null flags");
    }
}
