package P2;

import F0.G1;

/* loaded from: classes.dex */
public abstract class W implements Runnable, Comparable, Q {
    private volatile Object _heap;

    /* renamed from: a, reason: collision with root package name */
    public long f1631a;

    /* renamed from: b, reason: collision with root package name */
    public int f1632b = -1;

    public W(long j2) {
        this.f1631a = j2;
    }

    public final int a(long j2, X x3, Y y) {
        W w3;
        boolean z3;
        synchronized (this) {
            if (this._heap == G.f1605b) {
                return 2;
            }
            synchronized (x3) {
                try {
                    W[] wArr = x3.f2384a;
                    if (wArr != null) {
                        w3 = wArr[0];
                    } else {
                        w3 = null;
                    }
                    if (Y.f1636l.get(y) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        return 1;
                    }
                    if (w3 == null) {
                        x3.f1633c = j2;
                    } else {
                        long j3 = w3.f1631a;
                        if (j3 - j2 < 0) {
                            j2 = j3;
                        }
                        if (j2 - x3.f1633c > 0) {
                            x3.f1633c = j2;
                        }
                    }
                    long j4 = this.f1631a;
                    long j5 = x3.f1633c;
                    if (j4 - j5 < 0) {
                        this.f1631a = j5;
                    }
                    x3.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void c(X x3) {
        if (this._heap != G.f1605b) {
            this._heap = x3;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j2 = this.f1631a - ((W) obj).f1631a;
        if (j2 > 0) {
            return 1;
        }
        if (j2 < 0) {
            return -1;
        }
        return 0;
    }

    @Override // P2.Q
    public final void dispose() {
        X x3;
        synchronized (this) {
            try {
                Object obj = this._heap;
                G1 g12 = G.f1605b;
                if (obj == g12) {
                    return;
                }
                U2.w wVar = null;
                if (obj instanceof X) {
                    x3 = (X) obj;
                } else {
                    x3 = null;
                }
                if (x3 != null) {
                    synchronized (x3) {
                        Object obj2 = this._heap;
                        if (obj2 instanceof U2.w) {
                            wVar = (U2.w) obj2;
                        }
                        if (wVar != null) {
                            x3.b(this.f1632b);
                        }
                    }
                }
                this._heap = g12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.f1631a + ']';
    }
}
