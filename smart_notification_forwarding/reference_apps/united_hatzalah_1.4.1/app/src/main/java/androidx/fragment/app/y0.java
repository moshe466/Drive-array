package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class y0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3533a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3534b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3535c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3536d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3537e;

    public y0(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f3533a = i;
        this.f3534b = arrayList;
        this.f3535c = arrayList2;
        this.f3536d = arrayList3;
        this.f3537e = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i = 0; i < this.f3533a; i++) {
            View view = (View) this.f3534b.get(i);
            String str = (String) this.f3535c.get(i);
            WeakHashMap weakHashMap = J.S.f954a;
            J.J.k(view, str);
            J.J.k((View) this.f3536d.get(i), (String) this.f3537e.get(i));
        }
    }
}
