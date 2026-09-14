package l;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes.dex */
public class e<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f11733a;

    /* renamed from: b, reason: collision with root package name */
    private int f11734b;

    /* renamed from: c, reason: collision with root package name */
    private int f11735c;

    /* renamed from: d, reason: collision with root package name */
    private int f11736d;

    /* renamed from: e, reason: collision with root package name */
    private int f11737e;

    /* renamed from: f, reason: collision with root package name */
    private int f11738f;

    /* renamed from: g, reason: collision with root package name */
    private int f11739g;

    /* renamed from: h, reason: collision with root package name */
    private int f11740h;

    public e(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f11735c = i10;
        this.f11733a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int e(K k10, V v10) {
        int f10 = f(k10, v10);
        if (f10 >= 0) {
            return f10;
        }
        throw new IllegalStateException("Negative size: " + k10 + "=" + v10);
    }

    protected V a(K k10) {
        return null;
    }

    protected void b(boolean z10, K k10, V v10, V v11) {
    }

    public final V c(K k10) {
        V v10;
        Objects.requireNonNull(k10, "key == null");
        synchronized (this) {
            V v11 = this.f11733a.get(k10);
            if (v11 != null) {
                this.f11739g++;
                return v11;
            }
            this.f11740h++;
            V a10 = a(k10);
            if (a10 == null) {
                return null;
            }
            synchronized (this) {
                this.f11737e++;
                v10 = (V) this.f11733a.put(k10, a10);
                if (v10 != null) {
                    this.f11733a.put(k10, v10);
                } else {
                    this.f11734b += e(k10, a10);
                }
            }
            if (v10 != null) {
                b(false, k10, a10, v10);
                return v10;
            }
            g(this.f11735c);
            return a10;
        }
    }

    public final V d(K k10, V v10) {
        V put;
        if (k10 == null || v10 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f11736d++;
            this.f11734b += e(k10, v10);
            put = this.f11733a.put(k10, v10);
            if (put != null) {
                this.f11734b -= e(k10, put);
            }
        }
        if (put != null) {
            b(false, k10, put, v10);
        }
        g(this.f11735c);
        return put;
    }

    protected int f(K k10, V v10) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f11734b     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.f11733a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.f11734b     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.f11734b     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.f11733a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f11733a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.f11733a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f11734b     // Catch: java.lang.Throwable -> L71
            int r3 = r4.e(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.f11734b = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f11738f     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.f11738f = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.b(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: l.e.g(int):void");
    }

    public final synchronized String toString() {
        int i10;
        int i11;
        i10 = this.f11739g;
        i11 = this.f11740h + i10;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f11735c), Integer.valueOf(this.f11739g), Integer.valueOf(this.f11740h), Integer.valueOf(i11 != 0 ? (i10 * 100) / i11 : 0));
    }
}
