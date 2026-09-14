package P2;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public final class T implements InterfaceC0147d0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1627a;

    public T(boolean z3) {
        this.f1627a = z3;
    }

    @Override // P2.InterfaceC0147d0
    public final y0 c() {
        return null;
    }

    @Override // P2.InterfaceC0147d0
    public final boolean isActive() {
        return this.f1627a;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Empty{");
        if (this.f1627a) {
            str = "Active";
        } else {
            str = "New";
        }
        return AbstractC0008a.s(sb, str, '}');
    }
}
