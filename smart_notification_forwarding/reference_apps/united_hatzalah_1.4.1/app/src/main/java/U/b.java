package U;

import F0.C0047j2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import s2.C0679d;
import t2.AbstractC0707i;
import t2.AbstractC0709k;
import t2.u;

/* loaded from: classes.dex */
public final class b extends h {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2308a;

    /* renamed from: b, reason: collision with root package name */
    public final C0047j2 f2309b;

    public b(LinkedHashMap linkedHashMap, boolean z3) {
        this.f2308a = linkedHashMap;
        this.f2309b = new C0047j2(z3);
    }

    @Override // U.h
    public final Map a() {
        C0679d c0679d;
        Set<Map.Entry> entrySet = this.f2308a.entrySet();
        int F3 = u.F(AbstractC0709k.Y(entrySet, 10));
        if (F3 < 16) {
            F3 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(F3);
        for (Map.Entry entry : entrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                kotlin.jvm.internal.j.d(copyOf, "copyOf(this, size)");
                c0679d = new C0679d(key, copyOf);
            } else {
                c0679d = new C0679d(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(c0679d.f6332a, c0679d.f6333b);
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.j.d(unmodifiableMap, "unmodifiableMap(map)");
        return unmodifiableMap;
    }

    @Override // U.h
    public final Object b(f key) {
        kotlin.jvm.internal.j.e(key, "key");
        Object obj = this.f2308a.get(key);
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            kotlin.jvm.internal.j.d(copyOf, "copyOf(this, size)");
            return copyOf;
        }
        return obj;
    }

    public final void c() {
        if (!((AtomicBoolean) this.f2309b.f546b).get()) {
        } else {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void d(f key, Object obj) {
        kotlin.jvm.internal.j.e(key, "key");
        e(key, obj);
    }

    public final void e(f key, Object obj) {
        kotlin.jvm.internal.j.e(key, "key");
        c();
        LinkedHashMap linkedHashMap = this.f2308a;
        if (obj == null) {
            c();
            linkedHashMap.remove(key);
            return;
        }
        if (obj instanceof Set) {
            Set unmodifiableSet = Collections.unmodifiableSet(AbstractC0707i.u0((Set) obj));
            kotlin.jvm.internal.j.d(unmodifiableSet, "unmodifiableSet(set.toSet())");
            linkedHashMap.put(key, unmodifiableSet);
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                kotlin.jvm.internal.j.d(copyOf, "copyOf(this, size)");
                linkedHashMap.put(key, copyOf);
                return;
            }
            linkedHashMap.put(key, obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:0: B:10:0x002c->B:24:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof U.b
            r1 = 0
            if (r0 != 0) goto L6
            goto L62
        L6:
            U.b r7 = (U.b) r7
            java.util.LinkedHashMap r0 = r7.f2308a
            java.util.LinkedHashMap r2 = r6.f2308a
            r3 = 1
            if (r0 != r2) goto L10
            goto L63
        L10:
            int r0 = r0.size()
            int r4 = r2.size()
            if (r0 == r4) goto L1b
            goto L62
        L1b:
            java.util.LinkedHashMap r7 = r7.f2308a
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L24
            goto L63
        L24:
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L2c:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L63
            java.lang.Object r0 = r7.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r4 = r2.get(r4)
            if (r4 == 0) goto L5f
            java.lang.Object r0 = r0.getValue()
            boolean r5 = r0 instanceof byte[]
            if (r5 == 0) goto L5a
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L5f
            byte[] r0 = (byte[]) r0
            byte[] r4 = (byte[]) r4
            boolean r0 = java.util.Arrays.equals(r0, r4)
            if (r0 == 0) goto L5f
            r0 = r3
            goto L60
        L5a:
            boolean r0 = kotlin.jvm.internal.j.a(r0, r4)
            goto L60
        L5f:
            r0 = r1
        L60:
            if (r0 != 0) goto L2c
        L62:
            return r1
        L63:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: U.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode;
        Iterator it = this.f2308a.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof byte[]) {
                hashCode = Arrays.hashCode((byte[]) value);
            } else {
                hashCode = value.hashCode();
            }
            i += hashCode;
        }
        return i;
    }

    public final String toString() {
        return AbstractC0707i.h0(this.f2308a.entrySet(), ",\n", "{\n", "\n}", a.f2307a, 24);
    }

    public /* synthetic */ b(boolean z3) {
        this(new LinkedHashMap(), z3);
    }
}
