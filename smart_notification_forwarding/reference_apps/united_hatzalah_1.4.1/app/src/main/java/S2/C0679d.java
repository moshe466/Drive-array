package s2;

import java.io.Serializable;
import kotlin.jvm.internal.j;

/* renamed from: s2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0679d implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6332a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6333b;

    public C0679d(Object obj, Object obj2) {
        this.f6332a = obj;
        this.f6333b = obj2;
    }

    public final Object a() {
        return this.f6332a;
    }

    public final Object b() {
        return this.f6333b;
    }

    public final Object c() {
        return this.f6332a;
    }

    public final Object e() {
        return this.f6333b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0679d)) {
            return false;
        }
        C0679d c0679d = (C0679d) obj;
        if (j.a(this.f6332a, c0679d.f6332a) && j.a(this.f6333b, c0679d.f6333b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        Object obj = this.f6332a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i3 = hashCode * 31;
        Object obj2 = this.f6333b;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return i3 + i;
    }

    public final String toString() {
        return "(" + this.f6332a + ", " + this.f6333b + ')';
    }
}
