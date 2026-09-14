package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public class va {
    public static final va zza;
    public static final va zzb;
    public static final va zzc;
    public static final va zzd;
    public static final va zze;
    public static final va zzf;
    public static final va zzg;
    public static final va zzh;
    public static final va zzi;
    public static final va zzj;
    public static final va zzk;
    public static final va zzl;
    public static final va zzm;
    public static final va zzn;
    public static final va zzo;
    public static final va zzp;
    public static final va zzq;
    public static final va zzr;
    private static final /* synthetic */ va[] zzu;
    private final cb zzs;
    private final int zzt;

    static {
        va vaVar = new va("DOUBLE", 0, cb.DOUBLE, 1);
        zza = vaVar;
        va vaVar2 = new va("FLOAT", 1, cb.FLOAT, 5);
        zzb = vaVar2;
        cb cbVar = cb.LONG;
        final int i10 = 2;
        va vaVar3 = new va("INT64", 2, cbVar, 0);
        zzc = vaVar3;
        final int i11 = 3;
        va vaVar4 = new va("UINT64", 3, cbVar, 0);
        zzd = vaVar4;
        cb cbVar2 = cb.INT;
        va vaVar5 = new va("INT32", 4, cbVar2, 0);
        zze = vaVar5;
        va vaVar6 = new va("FIXED64", 5, cbVar, 1);
        zzf = vaVar6;
        va vaVar7 = new va("FIXED32", 6, cbVar2, 5);
        zzg = vaVar7;
        va vaVar8 = new va("BOOL", 7, cb.BOOLEAN, 0);
        zzh = vaVar8;
        final cb cbVar3 = cb.STRING;
        final String str = "STRING";
        final int i12 = 8;
        va vaVar9 = new va(str, i12, cbVar3, i10) { // from class: com.google.android.gms.internal.measurement.ya
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i13 = 8;
                int i14 = 2;
            }
        };
        zzi = vaVar9;
        final cb cbVar4 = cb.MESSAGE;
        final String str2 = "GROUP";
        final int i13 = 9;
        va vaVar10 = new va(str2, i13, cbVar4, i11) { // from class: com.google.android.gms.internal.measurement.xa
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i14 = 9;
                int i15 = 3;
            }
        };
        zzj = vaVar10;
        final String str3 = "MESSAGE";
        final int i14 = 10;
        final int i15 = 2;
        va vaVar11 = new va(str3, i14, cbVar4, i15) { // from class: com.google.android.gms.internal.measurement.ab
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i16 = 10;
                int i17 = 2;
            }
        };
        zzk = vaVar11;
        final cb cbVar5 = cb.BYTE_STRING;
        final String str4 = "BYTES";
        final int i16 = 11;
        va vaVar12 = new va(str4, i16, cbVar5, i15) { // from class: com.google.android.gms.internal.measurement.za
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i17 = 11;
                int i18 = 2;
            }
        };
        zzl = vaVar12;
        va vaVar13 = new va("UINT32", 12, cbVar2, 0);
        zzm = vaVar13;
        va vaVar14 = new va("ENUM", 13, cb.ENUM, 0);
        zzn = vaVar14;
        va vaVar15 = new va("SFIXED32", 14, cbVar2, 5);
        zzo = vaVar15;
        va vaVar16 = new va("SFIXED64", 15, cbVar, 1);
        zzp = vaVar16;
        va vaVar17 = new va("SINT32", 16, cbVar2, 0);
        zzq = vaVar17;
        va vaVar18 = new va("SINT64", 17, cbVar, 0);
        zzr = vaVar18;
        zzu = new va[]{vaVar, vaVar2, vaVar3, vaVar4, vaVar5, vaVar6, vaVar7, vaVar8, vaVar9, vaVar10, vaVar11, vaVar12, vaVar13, vaVar14, vaVar15, vaVar16, vaVar17, vaVar18};
    }

    private va(String str, int i10, cb cbVar, int i11) {
        this.zzs = cbVar;
        this.zzt = i11;
    }

    public static va[] values() {
        return (va[]) zzu.clone();
    }

    public final cb zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
