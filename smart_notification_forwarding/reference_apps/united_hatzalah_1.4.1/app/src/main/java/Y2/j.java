package Y2;

import U2.s;
import java.util.concurrent.atomic.AtomicReferenceArray;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class j extends s {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f2727e;

    public j(long j2, j jVar, int i) {
        super(j2, jVar, i);
        this.f2727e = new AtomicReferenceArray(i.f2726f);
    }

    @Override // U2.s
    public final int g() {
        return i.f2726f;
    }

    @Override // U2.s
    public final void h(int i, InterfaceC0768i interfaceC0768i) {
        this.f2727e.set(i, i.f2725e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f2376c + ", hashCode=" + hashCode() + ']';
    }
}
