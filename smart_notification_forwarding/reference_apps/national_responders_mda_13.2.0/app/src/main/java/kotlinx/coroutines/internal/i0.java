package kotlinx.coroutines.internal;

import kotlinx.coroutines.ThreadContextElement;
import nb.n1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final p8.f f11629a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f11630b;

    /* renamed from: c, reason: collision with root package name */
    private final ThreadContextElement<Object>[] f11631c;

    /* renamed from: d, reason: collision with root package name */
    private int f11632d;

    public i0(p8.f fVar, int i10) {
        this.f11629a = fVar;
        this.f11630b = new Object[i10];
        this.f11631c = new n1[i10];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(n1<?> n1Var, Object obj) {
        Object[] objArr = this.f11630b;
        int i10 = this.f11632d;
        objArr[i10] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.f11631c;
        this.f11632d = i10 + 1;
        threadContextElementArr[i10] = n1Var;
    }

    public final void b(p8.f fVar) {
        int length = this.f11631c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            n1 n1Var = this.f11631c[length];
            y8.k.b(n1Var);
            n1Var.f(fVar, this.f11630b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
