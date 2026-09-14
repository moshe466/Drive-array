package e2;

import F0.Q;
import a.AbstractC0228a;
import androidx.lifecycle.N;
import java.util.Comparator;

/* renamed from: e2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0364a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q f4453a;

    public C0364a(Q q3) {
        this.f4453a = q3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        N n4 = (N) this.f4453a.f362c;
        n4.getClass();
        Long valueOf = Long.valueOf(N.e((long[]) obj));
        n4.getClass();
        return AbstractC0228a.d(valueOf, Long.valueOf(N.e((long[]) obj2)));
    }
}
