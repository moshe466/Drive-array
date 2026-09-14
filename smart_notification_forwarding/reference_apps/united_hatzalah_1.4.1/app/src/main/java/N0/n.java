package N0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n extends c {

    /* renamed from: f, reason: collision with root package name */
    public L0.n f1478f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f1479g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f1480h;
    public final ArrayList i;

    public n(int i) {
        super(i);
        this.f1478f = null;
        this.f1479g = new ArrayList();
        this.f1480h = new ArrayList();
        this.i = new ArrayList();
    }

    @Override // N0.c
    public final boolean a() {
        if (this.i.isEmpty()) {
            ArrayList arrayList = this.f1479g;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (((m) obj).b()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // N0.c
    public final boolean b() {
        if (this.f1480h.isEmpty()) {
            ArrayList arrayList = this.f1479g;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (((m) obj).c()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void d(L0.e eVar, Object... objArr) {
        this.i.add(new L0.f(eVar, objArr));
    }
}
