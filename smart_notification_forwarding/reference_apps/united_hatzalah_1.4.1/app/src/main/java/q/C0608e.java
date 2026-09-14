package q;

import java.util.Arrays;

/* renamed from: q.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0608e {

    /* renamed from: a, reason: collision with root package name */
    public final int f6019a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f6020b;

    public C0608e(int i, CharSequence charSequence) {
        this.f6019a = i;
        this.f6020b = charSequence;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj instanceof C0608e) {
            C0608e c0608e = (C0608e) obj;
            if (this.f6019a == c0608e.f6019a) {
                CharSequence charSequence = c0608e.f6020b;
                String str2 = null;
                CharSequence charSequence2 = this.f6020b;
                if (charSequence2 != null) {
                    str = charSequence2.toString();
                } else {
                    str = null;
                }
                if (charSequence != null) {
                    str2 = charSequence.toString();
                }
                if (str != null || str2 != null) {
                    if (str != null && str.equals(str2)) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str;
        Integer valueOf = Integer.valueOf(this.f6019a);
        CharSequence charSequence = this.f6020b;
        if (charSequence != null) {
            str = charSequence.toString();
        } else {
            str = null;
        }
        return Arrays.hashCode(new Object[]{valueOf, str});
    }
}
