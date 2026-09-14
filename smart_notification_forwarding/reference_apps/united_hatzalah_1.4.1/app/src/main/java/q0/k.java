package q0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k extends r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f6089a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f6090b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6091c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f6092d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m f6093e;

    public k(m mVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f6093e = mVar;
        this.f6089a = obj;
        this.f6090b = arrayList;
        this.f6091c = obj2;
        this.f6092d = arrayList2;
    }

    @Override // q0.r, q0.p
    public final void a(q qVar) {
        m mVar = this.f6093e;
        Object obj = this.f6089a;
        if (obj != null) {
            mVar.t(obj, this.f6090b, null);
        }
        Object obj2 = this.f6091c;
        if (obj2 != null) {
            mVar.t(obj2, this.f6092d, null);
        }
    }

    @Override // q0.p
    public final void e(q qVar) {
        qVar.w(this);
    }
}
