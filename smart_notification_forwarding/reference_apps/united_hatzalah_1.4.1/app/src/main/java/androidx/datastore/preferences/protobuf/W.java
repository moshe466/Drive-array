package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class W implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f3142a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3143b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f3144c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ U f3145d;

    public W(U u3) {
        this.f3145d = u3;
    }

    public final Iterator a() {
        if (this.f3144c == null) {
            this.f3144c = this.f3145d.f3135b.entrySet().iterator();
        }
        return this.f3144c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f3142a + 1;
        U u3 = this.f3145d;
        if (i < u3.f3134a.size() || (!u3.f3135b.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.f3143b = true;
        int i = this.f3142a + 1;
        this.f3142a = i;
        U u3 = this.f3145d;
        if (i < u3.f3134a.size()) {
            return (Map.Entry) u3.f3134a.get(this.f3142a);
        }
        return (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f3143b) {
            this.f3143b = false;
            int i = U.f3133f;
            U u3 = this.f3145d;
            u3.b();
            if (this.f3142a < u3.f3134a.size()) {
                int i3 = this.f3142a;
                this.f3142a = i3 - 1;
                u3.h(i3);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
