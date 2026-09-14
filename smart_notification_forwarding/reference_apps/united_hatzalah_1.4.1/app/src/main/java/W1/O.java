package W1;

import com.google.crypto.tink.shaded.protobuf.InterfaceC0353z;

/* loaded from: classes.dex */
public enum O implements InterfaceC0353z {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f2481a;

    O(int i) {
        this.f2481a = i;
    }

    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f2481a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
