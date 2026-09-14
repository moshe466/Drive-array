package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.h;
import java.util.Map;

/* loaded from: classes.dex */
class FragmentManager$6 implements androidx.lifecycle.j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2885a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f2886b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ androidx.lifecycle.h f2887c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ w f2888d;

    @Override // androidx.lifecycle.j
    public void d(androidx.lifecycle.l lVar, h.b bVar) {
        Map map;
        Map map2;
        if (bVar == h.b.ON_START) {
            map2 = this.f2888d.f3109k;
            Bundle bundle = (Bundle) map2.get(this.f2885a);
            if (bundle != null) {
                this.f2886b.a(this.f2885a, bundle);
                this.f2888d.t(this.f2885a);
            }
        }
        if (bVar == h.b.ON_DESTROY) {
            this.f2887c.c(this);
            map = this.f2888d.f3110l;
            map.remove(this.f2885a);
        }
    }
}
