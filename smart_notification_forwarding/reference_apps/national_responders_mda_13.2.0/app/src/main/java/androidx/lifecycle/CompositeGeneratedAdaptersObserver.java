package androidx.lifecycle;

import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements j {

    /* renamed from: a, reason: collision with root package name */
    private final f[] f3155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.f3155a = fVarArr;
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, h.b bVar) {
        p pVar = new p();
        for (f fVar : this.f3155a) {
            fVar.a(lVar, bVar, false, pVar);
        }
        for (f fVar2 : this.f3155a) {
            fVar2.a(lVar, bVar, true, pVar);
        }
    }
}
