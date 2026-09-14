package N0;

import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ t[] f1493j;

    /* renamed from: a, reason: collision with root package name */
    public final int f1494a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1495b;

    /* renamed from: c, reason: collision with root package name */
    public final s f1496c;

    /* renamed from: d, reason: collision with root package name */
    public final W0.g f1497d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1498e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1499f;

    /* JADX INFO: Fake field, exist only in values array */
    t EF0;

    static {
        W0.g gVar = new W0.g("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
        s sVar = s.CHUNKED_SHA256;
        t tVar = new t("RSA_PSS_WITH_SHA256", 0, 257, sVar, "RSA", gVar, 24, 23);
        W0.g gVar2 = new W0.g("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
        s sVar2 = s.CHUNKED_SHA512;
        t tVar2 = new t("RSA_PSS_WITH_SHA512", 1, 258, sVar2, "RSA", gVar2, 24, 23);
        t tVar3 = new t("RSA_PKCS1_V1_5_WITH_SHA256", 2, 259, sVar, "RSA", new W0.g("SHA256withRSA", null), 24, 1);
        t tVar4 = new t("RSA_PKCS1_V1_5_WITH_SHA512", 3, 260, sVar2, "RSA", new W0.g("SHA512withRSA", null), 24, 1);
        t tVar5 = new t("ECDSA_WITH_SHA256", 4, 513, sVar, "EC", new W0.g("SHA256withECDSA", null), 24, 11);
        t tVar6 = new t("ECDSA_WITH_SHA512", 5, 514, sVar2, "EC", new W0.g("SHA512withECDSA", null), 24, 11);
        t tVar7 = new t("DSA_WITH_SHA256", 6, 769, sVar, "DSA", new W0.g("SHA256withDSA", null), 24, 1);
        t tVar8 = new t("DETDSA_WITH_SHA256", 7, 769, sVar, "DSA", new W0.g("SHA256withDetDSA", null), 24, 1);
        W0.g gVar3 = new W0.g("SHA256withRSA", null);
        s sVar3 = s.VERITY_CHUNKED_SHA256;
        f1493j = new t[]{tVar, tVar2, tVar3, tVar4, tVar5, tVar6, tVar7, tVar8, new t("VERITY_RSA_PKCS1_V1_5_WITH_SHA256", 8, 1057, sVar3, "RSA", gVar3, 28, 1), new t("VERITY_ECDSA_WITH_SHA256", 9, 1059, sVar3, "EC", new W0.g("SHA256withECDSA", null), 28, 11), new t("VERITY_DSA_WITH_SHA256", 10, 1061, sVar3, "DSA", new W0.g("SHA256withDSA", null), 28, 1)};
    }

    public t(String str, int i, int i3, s sVar, String str2, W0.g gVar, int i4, int i5) {
        this.f1494a = i3;
        this.f1496c = sVar;
        this.f1495b = str2;
        this.f1497d = gVar;
        this.f1498e = i4;
        this.f1499f = i5;
    }

    public static t a(int i) {
        for (t tVar : values()) {
            if (tVar.f1494a == i) {
                return tVar;
            }
        }
        return null;
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f1493j.clone();
    }
}
