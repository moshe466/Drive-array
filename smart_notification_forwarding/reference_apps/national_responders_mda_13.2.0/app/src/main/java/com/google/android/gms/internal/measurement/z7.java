package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class z7 {
    public static final z7 zza;
    public static final z7 zzb;
    public static final z7 zzc;
    public static final z7 zzd;
    public static final z7 zze;
    public static final z7 zzf;
    public static final z7 zzg;
    public static final z7 zzh;
    public static final z7 zzi;
    public static final z7 zzj;
    private static final /* synthetic */ z7[] zzn;
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    static {
        z7 z7Var = new z7("VOID", 0, Void.class, Void.class, null);
        zza = z7Var;
        Class cls = Integer.TYPE;
        z7 z7Var2 = new z7("INT", 1, cls, Integer.class, 0);
        zzb = z7Var2;
        z7 z7Var3 = new z7("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = z7Var3;
        z7 z7Var4 = new z7("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = z7Var4;
        z7 z7Var5 = new z7("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = z7Var5;
        z7 z7Var6 = new z7("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = z7Var6;
        z7 z7Var7 = new z7("STRING", 6, String.class, String.class, "");
        zzg = z7Var7;
        z7 z7Var8 = new z7("BYTE_STRING", 7, d6.class, d6.class, d6.f5256g);
        zzh = z7Var8;
        z7 z7Var9 = new z7("ENUM", 8, cls, Integer.class, null);
        zzi = z7Var9;
        z7 z7Var10 = new z7("MESSAGE", 9, Object.class, Object.class, null);
        zzj = z7Var10;
        zzn = new z7[]{z7Var, z7Var2, z7Var3, z7Var4, z7Var5, z7Var6, z7Var7, z7Var8, z7Var9, z7Var10};
    }

    private z7(String str, int i10, Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public static z7[] values() {
        return (z7[]) zzn.clone();
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
