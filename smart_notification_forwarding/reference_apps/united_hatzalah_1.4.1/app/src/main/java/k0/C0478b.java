package k0;

import F0.AbstractC0008a;
import java.util.ArrayList;

/* renamed from: k0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0478b extends s {

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f5203e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f5204f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f5205g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f5206h;
    public ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f5207j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f5208k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f5209l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f5210m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f5211n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f5212o;

    public static void c(ArrayList arrayList) {
        int size = arrayList.size() - 1;
        if (size < 0) {
        } else {
            throw e0.a.b(size, arrayList);
        }
    }

    @Override // k0.s
    public final void a() {
        ArrayList arrayList = this.i;
        ArrayList arrayList2 = this.f5207j;
        ArrayList arrayList3 = this.f5204f;
        ArrayList arrayList4 = this.f5208k;
        ArrayList arrayList5 = this.f5206h;
        ArrayList arrayList6 = this.f5203e;
        ArrayList arrayList7 = this.f5205g;
        int size = arrayList7.size() - 1;
        if (size < 0) {
            for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
                if (arrayList6.get(size2) == null) {
                    if (this.f5264a == null) {
                        arrayList6.remove(size2);
                    } else {
                        throw null;
                    }
                } else {
                    throw new ClassCastException();
                }
            }
            int size3 = arrayList3.size() - 1;
            if (size3 < 0) {
                int size4 = arrayList5.size() - 1;
                if (size4 < 0) {
                    arrayList5.clear();
                    if (!b()) {
                        return;
                    }
                    for (int size5 = arrayList2.size() - 1; size5 >= 0; size5--) {
                        ArrayList arrayList8 = (ArrayList) arrayList2.get(size5);
                        int size6 = arrayList8.size() - 1;
                        if (size6 >= 0) {
                            AbstractC0008a.z(arrayList8.get(size6));
                            throw null;
                        }
                    }
                    for (int size7 = arrayList.size() - 1; size7 >= 0; size7--) {
                        ArrayList arrayList9 = (ArrayList) arrayList.get(size7);
                        int size8 = arrayList9.size() - 1;
                        if (size8 >= 0) {
                            throw e0.a.b(size8, arrayList9);
                        }
                    }
                    for (int size9 = arrayList4.size() - 1; size9 >= 0; size9--) {
                        ArrayList arrayList10 = (ArrayList) arrayList4.get(size9);
                        int size10 = arrayList10.size() - 1;
                        if (size10 >= 0) {
                            AbstractC0008a.z(arrayList10.get(size10));
                            throw null;
                        }
                    }
                    c(this.f5211n);
                    c(this.f5210m);
                    c(this.f5209l);
                    c(this.f5212o);
                    ArrayList arrayList11 = this.f5265b;
                    if (arrayList11.size() <= 0) {
                        arrayList11.clear();
                        return;
                    }
                    throw e0.a.b(0, arrayList11);
                }
                AbstractC0008a.z(arrayList5.get(size4));
                throw null;
            }
            throw e0.a.b(size3, arrayList3);
        }
        AbstractC0008a.z(arrayList7.get(size));
        throw null;
    }

    @Override // k0.s
    public final boolean b() {
        if (this.f5204f.isEmpty() && this.f5206h.isEmpty() && this.f5205g.isEmpty() && this.f5203e.isEmpty() && this.f5210m.isEmpty() && this.f5211n.isEmpty() && this.f5209l.isEmpty() && this.f5212o.isEmpty() && this.f5207j.isEmpty() && this.i.isEmpty() && this.f5208k.isEmpty()) {
            return false;
        }
        return true;
    }
}
