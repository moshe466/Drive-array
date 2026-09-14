package q0;

import java.util.ArrayList;
import t.C0689e;

/* loaded from: classes.dex */
public final class s extends r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0689e f6122a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f6123b;

    public s(t tVar, C0689e c0689e) {
        this.f6123b = tVar;
        this.f6122a = c0689e;
    }

    @Override // q0.p
    public final void e(q qVar) {
        ((ArrayList) this.f6122a.get(this.f6123b.f6125b)).remove(qVar);
        qVar.w(this);
    }
}
