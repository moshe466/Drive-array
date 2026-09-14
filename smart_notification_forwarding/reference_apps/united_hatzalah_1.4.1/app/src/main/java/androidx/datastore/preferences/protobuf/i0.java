package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final E1.b f3191a;

    static {
        g0 g0Var;
        if (f0.f3170e && f0.f3169d && !AbstractC0236c.a()) {
            g0Var = new g0(1);
        } else {
            g0Var = new g0(0);
        }
        f3191a = g0Var;
    }

    public static int a(String str) {
        int length = str.length();
        int i = 0;
        int i3 = 0;
        while (i3 < length && str.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = str.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = str.length();
                while (i3 < length2) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i3) >= 65536) {
                                i3++;
                            } else {
                                throw new h0(i3, length2);
                            }
                        }
                    }
                    i3++;
                }
                i4 += i;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i4 + 4294967296L));
    }
}
