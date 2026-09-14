package s1;

/* loaded from: classes.dex */
public final class s extends AbstractC0654E {

    /* renamed from: a, reason: collision with root package name */
    public final r f6310a;

    public s(r rVar) {
        this.f6310a = rVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0654E) {
            return this.f6310a.equals(((s) ((AbstractC0654E) obj)).f6310a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6310a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f6310a + "}";
    }
}
