package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.EnumC0303m;
import l0.InterfaceC0513c;

/* loaded from: classes.dex */
public final /* synthetic */ class H implements InterfaceC0513c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3302a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3303b;

    public /* synthetic */ H(Object obj, int i) {
        this.f3302a = i;
        this.f3303b = obj;
    }

    @Override // l0.InterfaceC0513c
    public final Bundle a() {
        switch (this.f3302a) {
            case 0:
                L l3 = (L) this.f3303b;
                l3.markFragmentsCreated();
                l3.mFragmentLifecycleRegistry.e(EnumC0303m.ON_STOP);
                return new Bundle();
            default:
                return ((AbstractC0272g0) this.f3303b).W();
        }
    }
}
