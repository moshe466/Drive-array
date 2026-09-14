package o;

import java.util.Map;

/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5899a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5900b;

    /* renamed from: c, reason: collision with root package name */
    public c f5901c;

    /* renamed from: d, reason: collision with root package name */
    public c f5902d;

    public c(Object obj, Object obj2) {
        this.f5899a = obj;
        this.f5900b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f5899a.equals(cVar.f5899a) && this.f5900b.equals(cVar.f5900b)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5899a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f5900b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f5899a.hashCode() ^ this.f5900b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f5899a + "=" + this.f5900b;
    }
}
