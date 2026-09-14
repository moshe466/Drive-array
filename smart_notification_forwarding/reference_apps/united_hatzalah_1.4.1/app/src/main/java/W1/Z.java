package W1;

import com.google.crypto.tink.shaded.protobuf.InterfaceC0353z;

/* loaded from: classes.dex */
public enum Z implements InterfaceC0353z {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f2496a;

    Z(int i) {
        this.f2496a = i;
    }

    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f2496a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
