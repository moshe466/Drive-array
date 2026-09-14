package v7;

/* loaded from: classes.dex */
public enum k {
    NONE(0),
    CONFIRMED(1);

    private int m_type;

    k(int i10) {
        this.m_type = i10;
    }

    public static k valueOf(int i10) {
        k kVar = NONE;
        for (k kVar2 : values()) {
            if (i10 == kVar2.getCode()) {
                kVar = kVar2;
            }
        }
        return kVar;
    }

    public int getCode() {
        return this.m_type;
    }
}
