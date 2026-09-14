package w0;

import F2.l;
import kotlin.jvm.internal.j;

/* renamed from: w0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0751g extends p3.h {

    /* renamed from: c, reason: collision with root package name */
    public final Object f6695c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6696d;

    /* renamed from: e, reason: collision with root package name */
    public final C0745a f6697e;

    public C0751g(Object value, int i, C0745a c0745a) {
        j.e(value, "value");
        e0.a.j(i, "verificationMode");
        this.f6695c = value;
        this.f6696d = i;
        this.f6697e = c0745a;
    }

    @Override // p3.h
    public final p3.h A(String str, l lVar) {
        Object obj = this.f6695c;
        if (((Boolean) lVar.invoke(obj)).booleanValue()) {
            return this;
        }
        return new C0750f(obj, str, this.f6697e, this.f6696d);
    }

    @Override // p3.h
    public final Object i() {
        return this.f6695c;
    }
}
