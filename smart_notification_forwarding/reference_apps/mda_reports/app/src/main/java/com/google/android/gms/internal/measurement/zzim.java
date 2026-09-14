package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzi' uses external variables
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
public class zzim {
    public static final zzim zza = new zzim("DOUBLE", 0, zzip.DOUBLE, 1);
    public static final zzim zzb = new zzim("FLOAT", 1, zzip.FLOAT, 5);
    public static final zzim zzc = new zzim("INT64", 2, zzip.LONG, 0);
    public static final zzim zzd = new zzim("UINT64", 3, zzip.LONG, 0);
    public static final zzim zze = new zzim("INT32", 4, zzip.INT, 0);
    public static final zzim zzf = new zzim("FIXED64", 5, zzip.LONG, 1);
    public static final zzim zzg = new zzim("FIXED32", 6, zzip.INT, 5);
    public static final zzim zzh = new zzim("BOOL", 7, zzip.BOOLEAN, 0);
    public static final zzim zzi;
    public static final zzim zzj;
    public static final zzim zzk;
    public static final zzim zzl;
    public static final zzim zzm;
    public static final zzim zzn;
    public static final zzim zzo;
    public static final zzim zzp;
    public static final zzim zzq;
    public static final zzim zzr;
    private static final /* synthetic */ zzim[] zzu;
    private final zzip zzs;
    private final int zzt;

    static {
        final int i = 2;
        final int i2 = 3;
        final zzip zzipVar = zzip.STRING;
        final int i3 = 8;
        final String str = "STRING";
        zzi = new zzim(str, i3, zzipVar, i) { // from class: com.google.android.gms.internal.measurement.zzil
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i4 = 8;
                int i5 = 2;
                zzij zzijVar = null;
            }
        };
        final zzip zzipVar2 = zzip.MESSAGE;
        final int i4 = 9;
        final String str2 = "GROUP";
        zzj = new zzim(str2, i4, zzipVar2, i2) { // from class: com.google.android.gms.internal.measurement.zzio
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i5 = 9;
                int i6 = 3;
                zzij zzijVar = null;
            }
        };
        final zzip zzipVar3 = zzip.MESSAGE;
        final int i5 = 10;
        final String str3 = "MESSAGE";
        zzk = new zzim(str3, i5, zzipVar3, i) { // from class: com.google.android.gms.internal.measurement.zzin
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = 10;
                int i7 = 2;
                zzij zzijVar = null;
            }
        };
        final zzip zzipVar4 = zzip.BYTE_STRING;
        final int i6 = 11;
        final String str4 = "BYTES";
        zzl = new zzim(str4, i6, zzipVar4, i) { // from class: com.google.android.gms.internal.measurement.zziq
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i7 = 11;
                int i8 = 2;
                zzij zzijVar = null;
            }
        };
        zzm = new zzim("UINT32", 12, zzip.INT, 0);
        zzn = new zzim("ENUM", 13, zzip.ENUM, 0);
        zzo = new zzim("SFIXED32", 14, zzip.INT, 5);
        zzp = new zzim("SFIXED64", 15, zzip.LONG, 1);
        zzq = new zzim("SINT32", 16, zzip.INT, 0);
        zzr = new zzim("SINT64", 17, zzip.LONG, 0);
        zzu = new zzim[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr};
    }

    private zzim(String str, int i, zzip zzipVar, int i2) {
        this.zzs = zzipVar;
        this.zzt = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzim(String str, int i, zzip zzipVar, int i2, zzij zzijVar) {
        this(str, i, zzipVar, i2);
    }

    public static zzim[] values() {
        return (zzim[]) zzu.clone();
    }

    public final zzip zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
