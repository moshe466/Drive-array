package W1;

import com.google.crypto.tink.shaded.protobuf.InterfaceC0353z;

/* loaded from: classes.dex */
public enum r0 implements InterfaceC0353z {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f2504a;

    r0(int i) {
        this.f2504a = i;
    }

    public static r0 a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return CRUNCHY;
                    }
                    return RAW;
                }
                return LEGACY;
            }
            return TINK;
        }
        return UNKNOWN_PREFIX;
    }

    public final int b() {
        if (this != UNRECOGNIZED) {
            return this.f2504a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
