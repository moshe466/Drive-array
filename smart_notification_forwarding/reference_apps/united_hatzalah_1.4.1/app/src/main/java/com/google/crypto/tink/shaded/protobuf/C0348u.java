package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0348u implements O {

    /* renamed from: b, reason: collision with root package name */
    public static final C0348u f4155b = new C0348u(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4156a;

    public /* synthetic */ C0348u(int i) {
        this.f4156a = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O
    public final a0 a(Class cls) {
        switch (this.f4156a) {
            case 0:
                if (AbstractC0351x.class.isAssignableFrom(cls)) {
                    try {
                        return (a0) AbstractC0351x.j(cls.asSubclass(AbstractC0351x.class)).i(3);
                    } catch (Exception e4) {
                        throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e4);
                    }
                }
                throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.O
    public final boolean b(Class cls) {
        switch (this.f4156a) {
            case 0:
                return AbstractC0351x.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
