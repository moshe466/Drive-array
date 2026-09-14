package g1;

import io.flutter.plugins.firebase.crashlytics.Constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f4687b;

    /* renamed from: c, reason: collision with root package name */
    public static final g f4688c;

    /* renamed from: d, reason: collision with root package name */
    public static final g f4689d;

    /* renamed from: e, reason: collision with root package name */
    public static final g f4690e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ g[] f4691f;

    /* renamed from: a, reason: collision with root package name */
    public final String f4692a;

    static {
        g gVar = new g("NOT_SUPPORTED", 0, "not_supported");
        f4687b = gVar;
        g gVar2 = new g("SUPPORTED", 1, "supported");
        f4688c = gVar2;
        g gVar3 = new g("ENABLED", 2, Constants.ENABLED);
        f4689d = gVar3;
        g gVar4 = new g("UNKNOWN", 3, "unknown");
        f4690e = gVar4;
        g[] gVarArr = {gVar, gVar2, gVar3, gVar4};
        f4691f = gVarArr;
        p3.h.p(gVarArr);
    }

    public g(String str, int i, String str2) {
        this.f4692a = str2;
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f4691f.clone();
    }
}
