package androidx.fragment.app;

import java.util.ArrayList;

/* renamed from: androidx.fragment.app.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0268e0 implements InterfaceC0266d0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f3362a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0272g0 f3363b;

    public C0268e0(AbstractC0272g0 abstractC0272g0, int i) {
        this.f3363b = abstractC0272g0;
        this.f3362a = i;
    }

    @Override // androidx.fragment.app.InterfaceC0266d0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        AbstractC0272g0 abstractC0272g0 = this.f3363b;
        G g3 = abstractC0272g0.f3411z;
        int i = this.f3362a;
        if (g3 != null && i < 0 && g3.getChildFragmentManager().R(-1, 0)) {
            return false;
        }
        return abstractC0272g0.S(arrayList, arrayList2, i, 1);
    }
}
