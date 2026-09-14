package q;

/* renamed from: q.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0613j implements androidx.lifecycle.C {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6031a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f6032b;

    public /* synthetic */ C0613j(p pVar, int i) {
        this.f6031a = i;
        this.f6032b = pVar;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    @Override // androidx.lifecycle.C
    public final void g(Object obj) {
        switch (this.f6031a) {
            case 0:
                CharSequence charSequence = (CharSequence) obj;
                if (charSequence != null) {
                    p pVar = this.f6032b;
                    if (pVar.i()) {
                        pVar.m(charSequence);
                    }
                    pVar.f6036b.d(null);
                    return;
                }
                return;
            default:
                if (((Boolean) obj).booleanValue()) {
                    p pVar2 = this.f6032b;
                    pVar2.f(1);
                    pVar2.dismiss();
                    C0601A c0601a = pVar2.f6036b;
                    if (c0601a.f6008v == null) {
                        c0601a.f6008v = new androidx.lifecycle.A();
                    }
                    C0601A.h(c0601a.f6008v, Boolean.FALSE);
                    return;
                }
                return;
        }
    }
}
