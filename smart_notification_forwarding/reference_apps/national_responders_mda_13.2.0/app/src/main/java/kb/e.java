package kb;

import java.io.Serializable;

/* loaded from: classes.dex */
final class e<K, V> implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final K f11339f;

    /* renamed from: g, reason: collision with root package name */
    public final V f11340g;

    public e(K k10, V v10) {
        this.f11339f = k10;
        this.f11340g = v10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        K k10 = this.f11339f;
        if (k10 == null) {
            if (eVar.f11339f != null) {
                return false;
            }
        } else if (!k10.equals(eVar.f11339f)) {
            return false;
        }
        V v10 = this.f11340g;
        V v11 = eVar.f11340g;
        if (v10 == null) {
            if (v11 != null) {
                return false;
            }
        } else if (!v10.equals(v11)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        K k10 = this.f11339f;
        int hashCode = k10 == null ? 0 : k10.hashCode();
        V v10 = this.f11340g;
        return hashCode ^ (v10 != null ? v10.hashCode() : 0);
    }

    public String toString() {
        return this.f11339f + "=" + this.f11340g;
    }
}
