package q;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class y extends AbstractC0607d {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f6049a;

    public y(C0601A c0601a) {
        this.f6049a = new WeakReference(c0601a);
    }

    @Override // q.AbstractC0607d
    public final void a(int i, CharSequence charSequence) {
        WeakReference weakReference = this.f6049a;
        if (weakReference.get() != null && !((C0601A) weakReference.get()).f6000m && ((C0601A) weakReference.get()).f5999l) {
            ((C0601A) weakReference.get()).d(new C0608e(i, charSequence));
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    @Override // q.AbstractC0607d
    public final void b(u uVar) {
        WeakReference weakReference = this.f6049a;
        if (weakReference.get() != null && ((C0601A) weakReference.get()).f5999l) {
            int i = -1;
            if (uVar.f6041b == -1) {
                K1.m mVar = uVar.f6040a;
                int c4 = ((C0601A) weakReference.get()).c();
                if ((c4 & 32767) != 0 && !m3.b.A(c4)) {
                    i = 2;
                }
                uVar = new u(mVar, i);
            }
            C0601A c0601a = (C0601A) weakReference.get();
            if (c0601a.p == null) {
                c0601a.p = new androidx.lifecycle.A();
            }
            C0601A.h(c0601a.p, uVar);
        }
    }
}
