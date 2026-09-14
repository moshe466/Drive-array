package q2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class m0 extends c2.a {
    public static final Parcelable.Creator<m0> CREATOR = new l1();

    /* renamed from: f, reason: collision with root package name */
    private final int f13508f;

    /* renamed from: g, reason: collision with root package name */
    private final int f13509g;

    /* renamed from: h, reason: collision with root package name */
    private final String f13510h;

    /* renamed from: i, reason: collision with root package name */
    private final String f13511i;

    /* renamed from: j, reason: collision with root package name */
    private final int f13512j;

    /* renamed from: k, reason: collision with root package name */
    private final String f13513k;

    /* renamed from: l, reason: collision with root package name */
    private final m0 f13514l;

    /* renamed from: m, reason: collision with root package name */
    private final List f13515m;

    static {
        Process.myUid();
        Process.myPid();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(int i10, int i11, String str, String str2, String str3, int i12, List list, m0 m0Var) {
        this.f13508f = i10;
        this.f13509g = i11;
        this.f13510h = str;
        this.f13511i = str2;
        this.f13513k = str3;
        this.f13512j = i12;
        this.f13515m = f1.w(list);
        this.f13514l = m0Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            if (this.f13508f == m0Var.f13508f && this.f13509g == m0Var.f13509g && this.f13512j == m0Var.f13512j && this.f13510h.equals(m0Var.f13510h) && y0.a(this.f13511i, m0Var.f13511i) && y0.a(this.f13513k, m0Var.f13513k) && y0.a(this.f13514l, m0Var.f13514l) && this.f13515m.equals(m0Var.f13515m)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f13508f), this.f13510h, this.f13511i, this.f13513k});
    }

    public final String toString() {
        int length = this.f13510h.length() + 18;
        String str = this.f13511i;
        if (str != null) {
            length += str.length();
        }
        StringBuilder sb2 = new StringBuilder(length);
        sb2.append(this.f13508f);
        sb2.append("/");
        sb2.append(this.f13510h);
        if (this.f13511i != null) {
            sb2.append("[");
            if (this.f13511i.startsWith(this.f13510h)) {
                sb2.append((CharSequence) this.f13511i, this.f13510h.length(), this.f13511i.length());
            } else {
                sb2.append(this.f13511i);
            }
            sb2.append("]");
        }
        if (this.f13513k != null) {
            sb2.append("/");
            sb2.append(Integer.toHexString(this.f13513k.hashCode()));
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f13508f);
        c2.c.k(parcel, 2, this.f13509g);
        c2.c.q(parcel, 3, this.f13510h, false);
        c2.c.q(parcel, 4, this.f13511i, false);
        c2.c.k(parcel, 5, this.f13512j);
        c2.c.q(parcel, 6, this.f13513k, false);
        c2.c.o(parcel, 7, this.f13514l, i10, false);
        c2.c.t(parcel, 8, this.f13515m, false);
        c2.c.b(parcel, a10);
    }
}
