package P2;

/* renamed from: P2.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0170u {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1700a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0160k f1701b;

    /* renamed from: c, reason: collision with root package name */
    public final F2.l f1702c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1703d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f1704e;

    public C0170u(Object obj, InterfaceC0160k interfaceC0160k, F2.l lVar, Object obj2, Throwable th) {
        this.f1700a = obj;
        this.f1701b = interfaceC0160k;
        this.f1702c = lVar;
        this.f1703d = obj2;
        this.f1704e = th;
    }

    public static C0170u a(C0170u c0170u, InterfaceC0160k interfaceC0160k, Throwable th, int i) {
        Object obj = c0170u.f1700a;
        if ((i & 2) != 0) {
            interfaceC0160k = c0170u.f1701b;
        }
        InterfaceC0160k interfaceC0160k2 = interfaceC0160k;
        F2.l lVar = c0170u.f1702c;
        Object obj2 = c0170u.f1703d;
        if ((i & 16) != 0) {
            th = c0170u.f1704e;
        }
        c0170u.getClass();
        return new C0170u(obj, interfaceC0160k2, lVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0170u)) {
            return false;
        }
        C0170u c0170u = (C0170u) obj;
        if (kotlin.jvm.internal.j.a(this.f1700a, c0170u.f1700a) && kotlin.jvm.internal.j.a(this.f1701b, c0170u.f1701b) && kotlin.jvm.internal.j.a(this.f1702c, c0170u.f1702c) && kotlin.jvm.internal.j.a(this.f1703d, c0170u.f1703d) && kotlin.jvm.internal.j.a(this.f1704e, c0170u.f1704e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i = 0;
        Object obj = this.f1700a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i3 = hashCode * 31;
        InterfaceC0160k interfaceC0160k = this.f1701b;
        if (interfaceC0160k == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = interfaceC0160k.hashCode();
        }
        int i4 = (i3 + hashCode2) * 31;
        F2.l lVar = this.f1702c;
        if (lVar == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = lVar.hashCode();
        }
        int i5 = (i4 + hashCode3) * 31;
        Object obj2 = this.f1703d;
        if (obj2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = obj2.hashCode();
        }
        int i6 = (i5 + hashCode4) * 31;
        Throwable th = this.f1704e;
        if (th != null) {
            i = th.hashCode();
        }
        return i6 + i;
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f1700a + ", cancelHandler=" + this.f1701b + ", onCancellation=" + this.f1702c + ", idempotentResume=" + this.f1703d + ", cancelCause=" + this.f1704e + ')';
    }

    public /* synthetic */ C0170u(Object obj, InterfaceC0160k interfaceC0160k, F2.l lVar, Throwable th, int i) {
        this(obj, (i & 2) != 0 ? null : interfaceC0160k, (i & 4) != 0 ? null : lVar, (Object) null, (i & 16) != 0 ? null : th);
    }
}
