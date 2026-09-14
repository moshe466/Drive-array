package na;

/* loaded from: classes.dex */
public interface e {

    /* loaded from: classes.dex */
    public enum a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    /* loaded from: classes.dex */
    public enum b {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN
    }

    b a(n9.a aVar, n9.a aVar2, n9.e eVar);

    a b();
}
