package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* loaded from: classes.dex */
public final class V implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f3139a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3140b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ U f3141c;

    public V(U u3, Comparable comparable, Object obj) {
        this.f3141c = u3;
        this.f3139a = comparable;
        this.f3140b = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f3139a.compareTo(((V) obj).f3139a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean equals;
        boolean equals2;
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f3139a;
                if (comparable == null) {
                    if (key == null) {
                        equals = true;
                    } else {
                        equals = false;
                    }
                } else {
                    equals = comparable.equals(key);
                }
                if (equals) {
                    Object obj2 = this.f3140b;
                    Object value = entry.getValue();
                    if (obj2 == null) {
                        if (value == null) {
                            equals2 = true;
                        } else {
                            equals2 = false;
                        }
                    } else {
                        equals2 = obj2.equals(value);
                    }
                    if (equals2) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3139a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f3140b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        int i = 0;
        Comparable comparable = this.f3139a;
        if (comparable == null) {
            hashCode = 0;
        } else {
            hashCode = comparable.hashCode();
        }
        Object obj = this.f3140b;
        if (obj != null) {
            i = obj.hashCode();
        }
        return i ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f3141c.b();
        Object obj2 = this.f3140b;
        this.f3140b = obj;
        return obj2;
    }

    public final String toString() {
        return this.f3139a + "=" + this.f3140b;
    }
}
