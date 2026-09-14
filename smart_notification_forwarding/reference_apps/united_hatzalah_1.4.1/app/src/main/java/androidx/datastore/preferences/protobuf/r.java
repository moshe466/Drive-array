package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class r implements H {

    /* renamed from: b, reason: collision with root package name */
    public static final r f3232b = new r(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3233a;

    public /* synthetic */ r(int i) {
        this.f3233a = i;
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public final Q a(Class cls) {
        switch (this.f3233a) {
            case 0:
                if (AbstractC0253u.class.isAssignableFrom(cls)) {
                    try {
                        return (Q) AbstractC0253u.d(cls.asSubclass(AbstractC0253u.class)).c(3);
                    } catch (Exception e4) {
                        throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e4);
                    }
                }
                throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.H
    public final boolean b(Class cls) {
        switch (this.f3233a) {
            case 0:
                return AbstractC0253u.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
