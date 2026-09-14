package w0;

import F0.AbstractC0008a;
import R.U;
import java.math.BigInteger;
import kotlin.jvm.internal.j;
import s2.C0682g;

/* renamed from: w0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0752h implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public static final C0752h f6698f;

    /* renamed from: a, reason: collision with root package name */
    public final int f6699a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6700b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6701c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6702d;

    /* renamed from: e, reason: collision with root package name */
    public final C0682g f6703e = T.b.A(new U(this, 11));

    static {
        new C0752h(0, 0, 0, "");
        f6698f = new C0752h(0, 1, 0, "");
        new C0752h(1, 0, 0, "");
    }

    public C0752h(int i, int i3, int i4, String str) {
        this.f6699a = i;
        this.f6700b = i3;
        this.f6701c = i4;
        this.f6702d = str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0752h other = (C0752h) obj;
        j.e(other, "other");
        Object a2 = this.f6703e.a();
        j.d(a2, "<get-bigInteger>(...)");
        Object a4 = other.f6703e.a();
        j.d(a4, "<get-bigInteger>(...)");
        return ((BigInteger) a2).compareTo((BigInteger) a4);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0752h)) {
            return false;
        }
        C0752h c0752h = (C0752h) obj;
        if (this.f6699a != c0752h.f6699a || this.f6700b != c0752h.f6700b || this.f6701c != c0752h.f6701c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((((527 + this.f6699a) * 31) + this.f6700b) * 31) + this.f6701c;
    }

    public final String toString() {
        String str;
        String str2 = this.f6702d;
        if (!N2.f.U(str2)) {
            str = e0.a.d("-", str2);
        } else {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6699a);
        sb.append('.');
        sb.append(this.f6700b);
        sb.append('.');
        return AbstractC0008a.r(sb, this.f6701c, str);
    }
}
