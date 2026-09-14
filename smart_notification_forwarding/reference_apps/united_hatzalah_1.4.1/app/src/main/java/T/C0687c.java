package t;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: t.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0687c implements Iterator, Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public int f6347a;

    /* renamed from: b, reason: collision with root package name */
    public int f6348b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6349c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0689e f6350d;

    public C0687c(C0689e c0689e) {
        this.f6350d = c0689e;
        this.f6347a = c0689e.f6366c - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this.f6349c) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                int i = this.f6348b;
                C0689e c0689e = this.f6350d;
                if (kotlin.jvm.internal.j.a(key, c0689e.f(i)) && kotlin.jvm.internal.j.a(entry.getValue(), c0689e.i(this.f6348b))) {
                    return true;
                }
                return false;
            }
            return false;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f6349c) {
            return this.f6350d.f(this.f6348b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f6349c) {
            return this.f6350d.i(this.f6348b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6348b < this.f6347a) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        if (this.f6349c) {
            int i = this.f6348b;
            C0689e c0689e = this.f6350d;
            Object f4 = c0689e.f(i);
            Object i3 = c0689e.i(this.f6348b);
            int i4 = 0;
            if (f4 == null) {
                hashCode = 0;
            } else {
                hashCode = f4.hashCode();
            }
            if (i3 != null) {
                i4 = i3.hashCode();
            }
            return hashCode ^ i4;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f6348b++;
            this.f6349c = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f6349c) {
            this.f6350d.g(this.f6348b);
            this.f6348b--;
            this.f6347a--;
            this.f6349c = false;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f6349c) {
            return this.f6350d.h(this.f6348b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
