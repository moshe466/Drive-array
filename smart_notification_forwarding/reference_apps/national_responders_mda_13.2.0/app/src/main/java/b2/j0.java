package b2;

import a2.a;
import android.content.Context;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    private final SparseIntArray f4020a = new SparseIntArray();

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.gms.common.c f4021b;

    public j0(com.google.android.gms.common.c cVar) {
        p.k(cVar);
        this.f4021b = cVar;
    }

    public final int a(Context context, int i10) {
        return this.f4020a.get(i10, -1);
    }

    public final int b(Context context, a.f fVar) {
        p.k(context);
        p.k(fVar);
        int i10 = 0;
        if (!fVar.g()) {
            return 0;
        }
        int h10 = fVar.h();
        int a10 = a(context, h10);
        if (a10 == -1) {
            int i11 = 0;
            while (true) {
                if (i11 >= this.f4020a.size()) {
                    i10 = -1;
                    break;
                }
                int keyAt = this.f4020a.keyAt(i11);
                if (keyAt > h10 && this.f4020a.get(keyAt) == 0) {
                    break;
                }
                i11++;
            }
            a10 = i10 == -1 ? this.f4021b.j(context, h10) : i10;
            this.f4020a.put(h10, a10);
        }
        return a10;
    }

    public final void c() {
        this.f4020a.clear();
    }
}
