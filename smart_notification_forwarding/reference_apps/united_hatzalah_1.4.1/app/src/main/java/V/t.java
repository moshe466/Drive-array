package V;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f2431a;

    /* renamed from: b, reason: collision with root package name */
    public p f2432b;

    public t(int i) {
        this.f2431a = new SparseArray(i);
    }

    public final void a(p pVar, int i, int i3) {
        t tVar;
        int a2 = pVar.a(i);
        SparseArray sparseArray = this.f2431a;
        if (sparseArray == null) {
            tVar = null;
        } else {
            tVar = (t) sparseArray.get(a2);
        }
        if (tVar == null) {
            tVar = new t(1);
            sparseArray.put(pVar.a(i), tVar);
        }
        if (i3 > i) {
            tVar.a(pVar, i + 1, i3);
        } else {
            tVar.f2432b = pVar;
        }
    }
}
