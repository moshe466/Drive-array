package z1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6847a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f6848b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f6849c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ d[] f6850d;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, z1.d] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, z1.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, z1.d] */
    static {
        ?? r02 = new Enum("NETWORK_UNMETERED", 0);
        f6847a = r02;
        ?? r12 = new Enum("DEVICE_IDLE", 1);
        f6848b = r12;
        ?? r22 = new Enum("DEVICE_CHARGING", 2);
        f6849c = r22;
        f6850d = new d[]{r02, r12, r22};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f6850d.clone();
    }
}
