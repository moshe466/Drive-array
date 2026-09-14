package f0;

import androidx.fragment.app.j0;
import androidx.lifecycle.V;
import t.C0695k;

/* renamed from: f0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0376e extends V {

    /* renamed from: d, reason: collision with root package name */
    public static final j0 f4485d = new j0(1);

    /* renamed from: b, reason: collision with root package name */
    public final C0695k f4486b = new C0695k();

    /* renamed from: c, reason: collision with root package name */
    public boolean f4487c = false;

    @Override // androidx.lifecycle.V
    public final void b() {
        C0695k c0695k = this.f4486b;
        int i = c0695k.f6369c;
        for (int i3 = 0; i3 < i; i3++) {
            C0374c c0374c = (C0374c) c0695k.f6368b[i3];
            androidx.loader.content.e eVar = c0374c.f4479l;
            eVar.cancelLoad();
            eVar.abandon();
            C0375d c0375d = c0374c.f4481n;
            if (c0375d != null) {
                c0374c.g(c0375d);
                if (c0375d.f4484c) {
                    c0375d.f4483b.onLoaderReset(c0375d.f4482a);
                }
            }
            eVar.unregisterListener(c0374c);
            if (c0375d != null) {
                boolean z3 = c0375d.f4484c;
            }
            eVar.reset();
        }
        int i4 = c0695k.f6369c;
        Object[] objArr = c0695k.f6368b;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        c0695k.f6369c = 0;
    }
}
