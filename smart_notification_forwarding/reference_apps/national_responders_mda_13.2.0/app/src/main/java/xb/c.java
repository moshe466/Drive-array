package xb;

import okhttp3.q;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final bc.f f15673d = bc.f.t(":");

    /* renamed from: e, reason: collision with root package name */
    public static final bc.f f15674e = bc.f.t(":status");

    /* renamed from: f, reason: collision with root package name */
    public static final bc.f f15675f = bc.f.t(":method");

    /* renamed from: g, reason: collision with root package name */
    public static final bc.f f15676g = bc.f.t(":path");

    /* renamed from: h, reason: collision with root package name */
    public static final bc.f f15677h = bc.f.t(":scheme");

    /* renamed from: i, reason: collision with root package name */
    public static final bc.f f15678i = bc.f.t(":authority");

    /* renamed from: a, reason: collision with root package name */
    public final bc.f f15679a;

    /* renamed from: b, reason: collision with root package name */
    public final bc.f f15680b;

    /* renamed from: c, reason: collision with root package name */
    final int f15681c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(q qVar);
    }

    public c(bc.f fVar, bc.f fVar2) {
        this.f15679a = fVar;
        this.f15680b = fVar2;
        this.f15681c = fVar.B() + 32 + fVar2.B();
    }

    public c(bc.f fVar, String str) {
        this(fVar, bc.f.t(str));
    }

    public c(String str, String str2) {
        this(bc.f.t(str), bc.f.t(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f15679a.equals(cVar.f15679a) && this.f15680b.equals(cVar.f15680b);
    }

    public int hashCode() {
        return ((527 + this.f15679a.hashCode()) * 31) + this.f15680b.hashCode();
    }

    public String toString() {
        return sb.c.r("%s: %s", this.f15679a.G(), this.f15680b.G());
    }
}
