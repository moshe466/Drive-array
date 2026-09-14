package androidx.activity.result;

import androidx.activity.result.d;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.l;

/* loaded from: classes.dex */
class ActivityResultRegistry$1 implements j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f496a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f497b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d.a f498c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f499d;

    @Override // androidx.lifecycle.j
    public void d(l lVar, h.b bVar) {
        if (!h.b.ON_START.equals(bVar)) {
            if (h.b.ON_STOP.equals(bVar)) {
                this.f499d.f507f.remove(this.f496a);
                return;
            } else {
                if (h.b.ON_DESTROY.equals(bVar)) {
                    this.f499d.k(this.f496a);
                    return;
                }
                return;
            }
        }
        this.f499d.f507f.put(this.f496a, new d.b<>(this.f497b, this.f498c));
        if (this.f499d.f508g.containsKey(this.f496a)) {
            Object obj = this.f499d.f508g.get(this.f496a);
            this.f499d.f508g.remove(this.f496a);
            this.f497b.a(obj);
        }
        a aVar = (a) this.f499d.f509h.getParcelable(this.f496a);
        if (aVar != null) {
            this.f499d.f509h.remove(this.f496a);
            this.f497b.a(this.f498c.c(aVar.b(), aVar.a()));
        }
    }
}
