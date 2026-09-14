package t;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import u.C0718b;
import u.C0719c;

/* renamed from: t.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0693i {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final C0718b lock;
    private final C0719c map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    /* JADX WARN: Type inference failed for: r2v3, types: [u.b, java.lang.Object] */
    public C0693i(int i) {
        this.maxSize = i;
        if (i > 0) {
            this.map = new C0719c();
            this.lock = new Object();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final int a(Object obj, Object obj2) {
        int sizeOf = sizeOf(obj, obj2);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    public Object create(Object key) {
        kotlin.jvm.internal.j.e(key, "key");
        return null;
    }

    public final int createCount() {
        int i;
        synchronized (this.lock) {
            i = this.createCount;
        }
        return i;
    }

    public void entryRemoved(boolean z3, Object key, Object oldValue, Object obj) {
        kotlin.jvm.internal.j.e(key, "key");
        kotlin.jvm.internal.j.e(oldValue, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i;
        synchronized (this.lock) {
            i = this.evictionCount;
        }
        return i;
    }

    public final Object get(Object key) {
        Object put;
        kotlin.jvm.internal.j.e(key, "key");
        synchronized (this.lock) {
            C0719c c0719c = this.map;
            c0719c.getClass();
            Object obj = c0719c.f6501a.get(key);
            if (obj != null) {
                this.hitCount++;
                return obj;
            }
            this.missCount++;
            Object create = create(key);
            if (create == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    this.createCount++;
                    put = this.map.f6501a.put(key, create);
                    if (put != null) {
                        this.map.f6501a.put(key, put);
                    } else {
                        this.size += a(key, create);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (put != null) {
                entryRemoved(false, key, create, put);
                return put;
            }
            trimToSize(this.maxSize);
            return create;
        }
    }

    public final int hitCount() {
        int i;
        synchronized (this.lock) {
            i = this.hitCount;
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this.lock) {
            i = this.maxSize;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this.lock) {
            i = this.missCount;
        }
        return i;
    }

    public final Object put(Object key, Object value) {
        Object put;
        kotlin.jvm.internal.j.e(key, "key");
        kotlin.jvm.internal.j.e(value, "value");
        synchronized (this.lock) {
            this.putCount++;
            this.size += a(key, value);
            put = this.map.f6501a.put(key, value);
            if (put != null) {
                this.size -= a(key, put);
            }
        }
        if (put != null) {
            entryRemoved(false, key, put, value);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final int putCount() {
        int i;
        synchronized (this.lock) {
            i = this.putCount;
        }
        return i;
    }

    public final Object remove(Object key) {
        Object remove;
        kotlin.jvm.internal.j.e(key, "key");
        synchronized (this.lock) {
            C0719c c0719c = this.map;
            c0719c.getClass();
            remove = c0719c.f6501a.remove(key);
            if (remove != null) {
                this.size -= a(key, remove);
            }
        }
        if (remove != null) {
            entryRemoved(false, key, remove, null);
        }
        return remove;
    }

    public void resize(int i) {
        if (i > 0) {
            synchronized (this.lock) {
                this.maxSize = i;
            }
            trimToSize(i);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final int size() {
        int i;
        synchronized (this.lock) {
            i = this.size;
        }
        return i;
    }

    public int sizeOf(Object key, Object value) {
        kotlin.jvm.internal.j.e(key, "key");
        kotlin.jvm.internal.j.e(value, "value");
        return 1;
    }

    public final Map<Object, Object> snapshot() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.lock) {
            Set<Map.Entry> entrySet = this.map.f6501a.entrySet();
            kotlin.jvm.internal.j.d(entrySet, "map.entries");
            for (Map.Entry entry : entrySet) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        int i;
        String str;
        synchronized (this.lock) {
            try {
                int i3 = this.hitCount;
                int i4 = this.missCount + i3;
                if (i4 != 0) {
                    i = (i3 * 100) / i4;
                } else {
                    i = 0;
                }
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + i + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0073, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void trimToSize(int r6) {
        /*
            r5 = this;
        L0:
            u.b r0 = r5.lock
            monitor-enter(r0)
            int r1 = r5.size     // Catch: java.lang.Throwable -> L16
            if (r1 < 0) goto L6c
            u.c r1 = r5.map     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r1 = r1.f6501a     // Catch: java.lang.Throwable -> L16
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L18
            int r1 = r5.size     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L6c
            goto L18
        L16:
            r6 = move-exception
            goto L74
        L18:
            int r1 = r5.size     // Catch: java.lang.Throwable -> L16
            if (r1 <= r6) goto L6a
            u.c r1 = r5.map     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r1 = r1.f6501a     // Catch: java.lang.Throwable -> L16
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L27
            goto L6a
        L27:
            u.c r1 = r5.map     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r1 = r1.f6501a     // Catch: java.lang.Throwable -> L16
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = "map.entries"
            kotlin.jvm.internal.j.d(r1, r2)     // Catch: java.lang.Throwable -> L16
            java.lang.Object r1 = t2.AbstractC0707i.f0(r1)     // Catch: java.lang.Throwable -> L16
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L3e
            monitor-exit(r0)
            return
        L3e:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L16
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L16
            u.c r3 = r5.map     // Catch: java.lang.Throwable -> L16
            r3.getClass()     // Catch: java.lang.Throwable -> L16
            java.lang.String r4 = "key"
            kotlin.jvm.internal.j.e(r2, r4)     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r3 = r3.f6501a     // Catch: java.lang.Throwable -> L16
            r3.remove(r2)     // Catch: java.lang.Throwable -> L16
            int r3 = r5.size     // Catch: java.lang.Throwable -> L16
            int r4 = r5.a(r2, r1)     // Catch: java.lang.Throwable -> L16
            int r3 = r3 - r4
            r5.size = r3     // Catch: java.lang.Throwable -> L16
            int r3 = r5.evictionCount     // Catch: java.lang.Throwable -> L16
            r4 = 1
            int r3 = r3 + r4
            r5.evictionCount = r3     // Catch: java.lang.Throwable -> L16
            monitor-exit(r0)
            r0 = 0
            r5.entryRemoved(r4, r2, r1, r0)
            goto L0
        L6a:
            monitor-exit(r0)
            return
        L6c:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L16
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L16
            throw r1     // Catch: java.lang.Throwable -> L16
        L74:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t.C0693i.trimToSize(int):void");
    }
}
