package F0;

import android.content.Context;
import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class C extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public int f174a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ G f175b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f176c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ G0.l f177d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(G g3, Context context, G0.l lVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.f175b = g3;
        this.f176c = context;
        this.f177d = lVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new C(this.f175b, this.f176c, this.f177d, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C) create((P2.E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v1 java.lang.String, still in use, count: 1, list:
          (r5v1 java.lang.String) from 0x0099: MOVE (r26v0 java.lang.String) = (r5v1 java.lang.String) (LINE:154)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:56)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:447)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // y2.AbstractC0785a
    public final java.lang.Object invokeSuspend(java.lang.Object r48) {
        /*
            Method dump skipped, instructions count: 1760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
