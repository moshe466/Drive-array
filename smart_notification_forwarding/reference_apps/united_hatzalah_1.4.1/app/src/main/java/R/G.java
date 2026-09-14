package R;

import java.io.Serializable;
import s2.C0684i;
import w2.InterfaceC0763d;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class G extends AbstractC0793i implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public Serializable f1768a;

    /* renamed from: b, reason: collision with root package name */
    public int f1769b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.r f1770c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f1771d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.q f1772e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(kotlin.jvm.internal.r rVar, P p, kotlin.jvm.internal.q qVar, InterfaceC0763d interfaceC0763d) {
        super(1, interfaceC0763d);
        this.f1770c = rVar;
        this.f1771d = p;
        this.f1772e = qVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(InterfaceC0763d interfaceC0763d) {
        return new G(this.f1770c, this.f1771d, this.f1772e, interfaceC0763d);
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        return ((G) create((InterfaceC0763d) obj)).invokeSuspend(C0684i.f6340a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        if (r9 != r0) goto L30;
     */
    @Override // y2.AbstractC0785a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            x2.a r0 = x2.EnumC0779a.f6740a
            int r1 = r8.f1769b
            kotlin.jvm.internal.q r2 = r8.f1772e
            kotlin.jvm.internal.r r3 = r8.f1770c
            r4 = 3
            r5 = 2
            R.P r6 = r8.f1771d
            r7 = 1
            if (r1 == 0) goto L36
            if (r1 == r7) goto L2e
            if (r1 == r5) goto L26
            if (r1 != r4) goto L1e
            java.io.Serializable r0 = r8.f1768a
            r2 = r0
            kotlin.jvm.internal.q r2 = (kotlin.jvm.internal.q) r2
            a.AbstractC0228a.C(r9)
            goto L6d
        L1e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L26:
            java.io.Serializable r1 = r8.f1768a
            kotlin.jvm.internal.q r1 = (kotlin.jvm.internal.q) r1
            a.AbstractC0228a.C(r9)     // Catch: androidx.datastore.core.CorruptionException -> L60
            goto L57
        L2e:
            java.io.Serializable r1 = r8.f1768a
            kotlin.jvm.internal.r r1 = (kotlin.jvm.internal.r) r1
            a.AbstractC0228a.C(r9)     // Catch: androidx.datastore.core.CorruptionException -> L60
            goto L45
        L36:
            a.AbstractC0228a.C(r9)
            r8.f1768a = r3     // Catch: androidx.datastore.core.CorruptionException -> L60
            r8.f1769b = r7     // Catch: androidx.datastore.core.CorruptionException -> L60
            java.lang.Object r9 = r6.i(r8)     // Catch: androidx.datastore.core.CorruptionException -> L60
            if (r9 != r0) goto L44
            goto L6c
        L44:
            r1 = r3
        L45:
            r1.f5312a = r9     // Catch: androidx.datastore.core.CorruptionException -> L60
            R.j0 r9 = r6.g()     // Catch: androidx.datastore.core.CorruptionException -> L60
            r8.f1768a = r2     // Catch: androidx.datastore.core.CorruptionException -> L60
            r8.f1769b = r5     // Catch: androidx.datastore.core.CorruptionException -> L60
            java.lang.Integer r9 = r9.a()     // Catch: androidx.datastore.core.CorruptionException -> L60
            if (r9 != r0) goto L56
            goto L6c
        L56:
            r1 = r2
        L57:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch: androidx.datastore.core.CorruptionException -> L60
            int r9 = r9.intValue()     // Catch: androidx.datastore.core.CorruptionException -> L60
            r1.f5311a = r9     // Catch: androidx.datastore.core.CorruptionException -> L60
            goto L75
        L60:
            java.lang.Object r9 = r3.f5312a
            r8.f1768a = r2
            r8.f1769b = r4
            java.lang.Object r9 = r6.j(r9, r7, r8)
            if (r9 != r0) goto L6d
        L6c:
            return r0
        L6d:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r2.f5311a = r9
        L75:
            s2.i r9 = s2.C0684i.f6340a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: R.G.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
