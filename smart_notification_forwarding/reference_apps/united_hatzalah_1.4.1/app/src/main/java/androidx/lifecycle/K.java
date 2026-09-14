package androidx.lifecycle;

import android.os.Bundle;
import l0.InterfaceC0513c;

/* loaded from: classes.dex */
public final /* synthetic */ class K implements InterfaceC0513c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3560a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3561b;

    public /* synthetic */ K(Object obj, int i) {
        this.f3560a = i;
        this.f3561b = obj;
    }

    @Override // l0.InterfaceC0513c
    public final Bundle a() {
        switch (this.f3560a) {
            case 0:
                return L.a((L) this.f3561b);
            default:
                return c.m.a((androidx.fragment.app.L) this.f3561b);
        }
    }
}
