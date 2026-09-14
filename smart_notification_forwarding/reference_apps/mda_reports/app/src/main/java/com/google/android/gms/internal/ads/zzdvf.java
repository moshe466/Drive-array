package com.google.android.gms.internal.ads;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzhsn' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public class zzdvf {
    public static final zzdvf zzhsf = new zzdvf("DOUBLE", 0, zzdvm.DOUBLE, 1);
    public static final zzdvf zzhsg = new zzdvf("FLOAT", 1, zzdvm.FLOAT, 5);
    public static final zzdvf zzhsh = new zzdvf("INT64", 2, zzdvm.LONG, 0);
    public static final zzdvf zzhsi = new zzdvf("UINT64", 3, zzdvm.LONG, 0);
    public static final zzdvf zzhsj = new zzdvf("INT32", 4, zzdvm.INT, 0);
    public static final zzdvf zzhsk = new zzdvf("FIXED64", 5, zzdvm.LONG, 1);
    public static final zzdvf zzhsl = new zzdvf("FIXED32", 6, zzdvm.INT, 5);
    public static final zzdvf zzhsm = new zzdvf("BOOL", 7, zzdvm.BOOLEAN, 0);
    public static final zzdvf zzhsn;
    public static final zzdvf zzhso;
    public static final zzdvf zzhsp;
    public static final zzdvf zzhsq;
    public static final zzdvf zzhsr;
    public static final zzdvf zzhss;
    public static final zzdvf zzhst;
    public static final zzdvf zzhsu;
    public static final zzdvf zzhsv;
    public static final zzdvf zzhsw;
    private static final /* synthetic */ zzdvf[] zzhsz;
    private final zzdvm zzhsx;
    private final int zzhsy;

    static {
        final int i = 2;
        final int i2 = 3;
        final zzdvm zzdvmVar = zzdvm.STRING;
        final int i3 = 8;
        final String str = "STRING";
        zzhsn = new zzdvf(str, i3, zzdvmVar, i) { // from class: com.google.android.gms.internal.ads.zzdvi
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i4 = 8;
                int i5 = 2;
                zzdvg zzdvgVar = null;
            }
        };
        final zzdvm zzdvmVar2 = zzdvm.MESSAGE;
        final int i4 = 9;
        final String str2 = "GROUP";
        zzhso = new zzdvf(str2, i4, zzdvmVar2, i2) { // from class: com.google.android.gms.internal.ads.zzdvh
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i5 = 9;
                int i6 = 3;
                zzdvg zzdvgVar = null;
            }
        };
        final zzdvm zzdvmVar3 = zzdvm.MESSAGE;
        final int i5 = 10;
        final String str3 = "MESSAGE";
        zzhsp = new zzdvf(str3, i5, zzdvmVar3, i) { // from class: com.google.android.gms.internal.ads.zzdvk
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = 10;
                int i7 = 2;
                zzdvg zzdvgVar = null;
            }
        };
        final zzdvm zzdvmVar4 = zzdvm.BYTE_STRING;
        final int i6 = 11;
        final String str4 = "BYTES";
        zzhsq = new zzdvf(str4, i6, zzdvmVar4, i) { // from class: com.google.android.gms.internal.ads.zzdvj
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i7 = 11;
                int i8 = 2;
                zzdvg zzdvgVar = null;
            }
        };
        zzhsr = new zzdvf("UINT32", 12, zzdvm.INT, 0);
        zzhss = new zzdvf("ENUM", 13, zzdvm.ENUM, 0);
        zzhst = new zzdvf("SFIXED32", 14, zzdvm.INT, 5);
        zzhsu = new zzdvf("SFIXED64", 15, zzdvm.LONG, 1);
        zzhsv = new zzdvf("SINT32", 16, zzdvm.INT, 0);
        zzhsw = new zzdvf("SINT64", 17, zzdvm.LONG, 0);
        zzhsz = new zzdvf[]{zzhsf, zzhsg, zzhsh, zzhsi, zzhsj, zzhsk, zzhsl, zzhsm, zzhsn, zzhso, zzhsp, zzhsq, zzhsr, zzhss, zzhst, zzhsu, zzhsv, zzhsw};
    }

    private zzdvf(String str, int i, zzdvm zzdvmVar, int i2) {
        this.zzhsx = zzdvmVar;
        this.zzhsy = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdvf(String str, int i, zzdvm zzdvmVar, int i2, zzdvg zzdvgVar) {
        this(str, i, zzdvmVar, i2);
    }

    public static zzdvf[] values() {
        return (zzdvf[]) zzhsz.clone();
    }

    public final zzdvm zzbcp() {
        return this.zzhsx;
    }

    public final int zzbcq() {
        return this.zzhsy;
    }
}
