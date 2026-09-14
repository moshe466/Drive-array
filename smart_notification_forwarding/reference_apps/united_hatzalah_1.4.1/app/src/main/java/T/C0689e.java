package t;

import androidx.datastore.preferences.protobuf.X;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import t2.AbstractC0705g;

/* renamed from: t.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0689e extends C0694j implements Map {

    /* renamed from: d, reason: collision with root package name */
    public X f6352d;

    /* renamed from: e, reason: collision with root package name */
    public C0686b f6353e;

    /* renamed from: f, reason: collision with root package name */
    public C0688d f6354f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0689e(C0694j c0694j) {
        super(0);
        int i = c0694j.f6366c;
        b(this.f6366c + i);
        if (this.f6366c == 0) {
            if (i > 0) {
                AbstractC0705g.D(0, 0, c0694j.f6364a, this.f6364a, i);
                AbstractC0705g.E(c0694j.f6365b, 0, this.f6365b, 0, i << 1);
                this.f6366c = i;
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            put(c0694j.f(i3), c0694j.i(i3));
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        X x3 = this.f6352d;
        if (x3 == null) {
            X x4 = new X(1, this);
            this.f6352d = x4;
            return x4;
        }
        return x3;
    }

    public final boolean j(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(Collection collection) {
        int i = this.f6366c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        if (i != this.f6366c) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final Set keySet() {
        C0686b c0686b = this.f6353e;
        if (c0686b == null) {
            C0686b c0686b2 = new C0686b(this);
            this.f6353e = c0686b2;
            return c0686b2;
        }
        return c0686b;
    }

    public final boolean l(Collection collection) {
        int i = this.f6366c;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            if (!collection.contains(f(i3))) {
                g(i3);
            }
        }
        if (i != this.f6366c) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f6366c);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        C0688d c0688d = this.f6354f;
        if (c0688d == null) {
            C0688d c0688d2 = new C0688d(this);
            this.f6354f = c0688d2;
            return c0688d2;
        }
        return c0688d;
    }
}
