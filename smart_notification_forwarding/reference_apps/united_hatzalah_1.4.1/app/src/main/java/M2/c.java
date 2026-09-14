package M2;

import F0.A0;
import F0.T1;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final T1 f1411a;

    /* renamed from: b, reason: collision with root package name */
    public final A0 f1412b;

    public c(T1 t12, A0 a02) {
        this.f1411a = t12;
        this.f1412b = a02;
    }

    @Override // M2.d
    public final Iterator iterator() {
        return new b(this);
    }
}
