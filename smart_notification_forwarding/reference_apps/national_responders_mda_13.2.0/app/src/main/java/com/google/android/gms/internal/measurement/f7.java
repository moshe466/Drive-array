package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

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
public final class f7 {
    public static final f7 zza;
    private static final f7 zzaa;
    private static final f7 zzab;
    private static final f7 zzac;
    private static final f7 zzad;
    private static final f7 zzae;
    private static final f7 zzaf;
    private static final f7 zzag;
    private static final f7 zzah;
    private static final f7 zzai;
    private static final f7 zzaj;
    private static final f7 zzak;
    private static final f7 zzal;
    private static final f7 zzam;
    private static final f7 zzan;
    private static final f7 zzao;
    private static final f7 zzap;
    private static final f7 zzaq;
    private static final f7 zzar;
    private static final f7 zzas;
    private static final f7 zzat;
    private static final f7 zzau;
    private static final f7 zzav;
    private static final f7 zzaw;
    private static final f7 zzax;
    private static final f7 zzay;
    public static final f7 zzb;
    private static final f7[] zzbe;
    private static final Type[] zzbf;
    private static final /* synthetic */ f7[] zzbg;
    private static final f7 zzc;
    private static final f7 zzd;
    private static final f7 zze;
    private static final f7 zzf;
    private static final f7 zzg;
    private static final f7 zzh;
    private static final f7 zzi;
    private static final f7 zzj;
    private static final f7 zzk;
    private static final f7 zzl;
    private static final f7 zzm;
    private static final f7 zzn;
    private static final f7 zzo;
    private static final f7 zzp;
    private static final f7 zzq;
    private static final f7 zzr;
    private static final f7 zzs;
    private static final f7 zzt;
    private static final f7 zzu;
    private static final f7 zzv;
    private static final f7 zzw;
    private static final f7 zzx;
    private static final f7 zzy;
    private static final f7 zzz;
    private final z7 zzaz;
    private final int zzba;
    private final h7 zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    static {
        h7 h7Var = h7.SCALAR;
        z7 z7Var = z7.zze;
        f7 f7Var = new f7("DOUBLE", 0, 0, h7Var, z7Var);
        zzc = f7Var;
        z7 z7Var2 = z7.zzd;
        f7 f7Var2 = new f7("FLOAT", 1, 1, h7Var, z7Var2);
        zzd = f7Var2;
        z7 z7Var3 = z7.zzc;
        f7 f7Var3 = new f7("INT64", 2, 2, h7Var, z7Var3);
        zze = f7Var3;
        f7 f7Var4 = new f7("UINT64", 3, 3, h7Var, z7Var3);
        zzf = f7Var4;
        z7 z7Var4 = z7.zzb;
        f7 f7Var5 = new f7("INT32", 4, 4, h7Var, z7Var4);
        zzg = f7Var5;
        f7 f7Var6 = new f7("FIXED64", 5, 5, h7Var, z7Var3);
        zzh = f7Var6;
        f7 f7Var7 = new f7("FIXED32", 6, 6, h7Var, z7Var4);
        zzi = f7Var7;
        z7 z7Var5 = z7.zzf;
        f7 f7Var8 = new f7("BOOL", 7, 7, h7Var, z7Var5);
        zzj = f7Var8;
        z7 z7Var6 = z7.zzg;
        f7 f7Var9 = new f7("STRING", 8, 8, h7Var, z7Var6);
        zzk = f7Var9;
        z7 z7Var7 = z7.zzj;
        f7 f7Var10 = new f7("MESSAGE", 9, 9, h7Var, z7Var7);
        zzl = f7Var10;
        z7 z7Var8 = z7.zzh;
        f7 f7Var11 = new f7("BYTES", 10, 10, h7Var, z7Var8);
        zzm = f7Var11;
        f7 f7Var12 = new f7("UINT32", 11, 11, h7Var, z7Var4);
        zzn = f7Var12;
        z7 z7Var9 = z7.zzi;
        f7 f7Var13 = new f7("ENUM", 12, 12, h7Var, z7Var9);
        zzo = f7Var13;
        f7 f7Var14 = new f7("SFIXED32", 13, 13, h7Var, z7Var4);
        zzp = f7Var14;
        f7 f7Var15 = new f7("SFIXED64", 14, 14, h7Var, z7Var3);
        zzq = f7Var15;
        f7 f7Var16 = new f7("SINT32", 15, 15, h7Var, z7Var4);
        zzr = f7Var16;
        f7 f7Var17 = new f7("SINT64", 16, 16, h7Var, z7Var3);
        zzs = f7Var17;
        f7 f7Var18 = new f7("GROUP", 17, 17, h7Var, z7Var7);
        zzt = f7Var18;
        h7 h7Var2 = h7.VECTOR;
        f7 f7Var19 = new f7("DOUBLE_LIST", 18, 18, h7Var2, z7Var);
        zzu = f7Var19;
        f7 f7Var20 = new f7("FLOAT_LIST", 19, 19, h7Var2, z7Var2);
        zzv = f7Var20;
        f7 f7Var21 = new f7("INT64_LIST", 20, 20, h7Var2, z7Var3);
        zzw = f7Var21;
        f7 f7Var22 = new f7("UINT64_LIST", 21, 21, h7Var2, z7Var3);
        zzx = f7Var22;
        f7 f7Var23 = new f7("INT32_LIST", 22, 22, h7Var2, z7Var4);
        zzy = f7Var23;
        f7 f7Var24 = new f7("FIXED64_LIST", 23, 23, h7Var2, z7Var3);
        zzz = f7Var24;
        f7 f7Var25 = new f7("FIXED32_LIST", 24, 24, h7Var2, z7Var4);
        zzaa = f7Var25;
        f7 f7Var26 = new f7("BOOL_LIST", 25, 25, h7Var2, z7Var5);
        zzab = f7Var26;
        f7 f7Var27 = new f7("STRING_LIST", 26, 26, h7Var2, z7Var6);
        zzac = f7Var27;
        f7 f7Var28 = new f7("MESSAGE_LIST", 27, 27, h7Var2, z7Var7);
        zzad = f7Var28;
        f7 f7Var29 = new f7("BYTES_LIST", 28, 28, h7Var2, z7Var8);
        zzae = f7Var29;
        f7 f7Var30 = new f7("UINT32_LIST", 29, 29, h7Var2, z7Var4);
        zzaf = f7Var30;
        f7 f7Var31 = new f7("ENUM_LIST", 30, 30, h7Var2, z7Var9);
        zzag = f7Var31;
        f7 f7Var32 = new f7("SFIXED32_LIST", 31, 31, h7Var2, z7Var4);
        zzah = f7Var32;
        f7 f7Var33 = new f7("SFIXED64_LIST", 32, 32, h7Var2, z7Var3);
        zzai = f7Var33;
        f7 f7Var34 = new f7("SINT32_LIST", 33, 33, h7Var2, z7Var4);
        zzaj = f7Var34;
        f7 f7Var35 = new f7("SINT64_LIST", 34, 34, h7Var2, z7Var3);
        zzak = f7Var35;
        h7 h7Var3 = h7.PACKED_VECTOR;
        f7 f7Var36 = new f7("DOUBLE_LIST_PACKED", 35, 35, h7Var3, z7Var);
        zza = f7Var36;
        f7 f7Var37 = new f7("FLOAT_LIST_PACKED", 36, 36, h7Var3, z7Var2);
        zzal = f7Var37;
        f7 f7Var38 = new f7("INT64_LIST_PACKED", 37, 37, h7Var3, z7Var3);
        zzam = f7Var38;
        f7 f7Var39 = new f7("UINT64_LIST_PACKED", 38, 38, h7Var3, z7Var3);
        zzan = f7Var39;
        f7 f7Var40 = new f7("INT32_LIST_PACKED", 39, 39, h7Var3, z7Var4);
        zzao = f7Var40;
        f7 f7Var41 = new f7("FIXED64_LIST_PACKED", 40, 40, h7Var3, z7Var3);
        zzap = f7Var41;
        f7 f7Var42 = new f7("FIXED32_LIST_PACKED", 41, 41, h7Var3, z7Var4);
        zzaq = f7Var42;
        f7 f7Var43 = new f7("BOOL_LIST_PACKED", 42, 42, h7Var3, z7Var5);
        zzar = f7Var43;
        f7 f7Var44 = new f7("UINT32_LIST_PACKED", 43, 43, h7Var3, z7Var4);
        zzas = f7Var44;
        f7 f7Var45 = new f7("ENUM_LIST_PACKED", 44, 44, h7Var3, z7Var9);
        zzat = f7Var45;
        f7 f7Var46 = new f7("SFIXED32_LIST_PACKED", 45, 45, h7Var3, z7Var4);
        zzau = f7Var46;
        f7 f7Var47 = new f7("SFIXED64_LIST_PACKED", 46, 46, h7Var3, z7Var3);
        zzav = f7Var47;
        f7 f7Var48 = new f7("SINT32_LIST_PACKED", 47, 47, h7Var3, z7Var4);
        zzaw = f7Var48;
        f7 f7Var49 = new f7("SINT64_LIST_PACKED", 48, 48, h7Var3, z7Var3);
        zzb = f7Var49;
        f7 f7Var50 = new f7("GROUP_LIST", 49, 49, h7Var2, z7Var7);
        zzax = f7Var50;
        f7 f7Var51 = new f7("MAP", 50, 50, h7.MAP, z7.zza);
        zzay = f7Var51;
        zzbg = new f7[]{f7Var, f7Var2, f7Var3, f7Var4, f7Var5, f7Var6, f7Var7, f7Var8, f7Var9, f7Var10, f7Var11, f7Var12, f7Var13, f7Var14, f7Var15, f7Var16, f7Var17, f7Var18, f7Var19, f7Var20, f7Var21, f7Var22, f7Var23, f7Var24, f7Var25, f7Var26, f7Var27, f7Var28, f7Var29, f7Var30, f7Var31, f7Var32, f7Var33, f7Var34, f7Var35, f7Var36, f7Var37, f7Var38, f7Var39, f7Var40, f7Var41, f7Var42, f7Var43, f7Var44, f7Var45, f7Var46, f7Var47, f7Var48, f7Var49, f7Var50, f7Var51};
        zzbf = new Type[0];
        f7[] values = values();
        zzbe = new f7[values.length];
        for (f7 f7Var52 : values) {
            zzbe[f7Var52.zzba] = f7Var52;
        }
    }

    private f7(String str, int i10, int i11, h7 h7Var, z7 z7Var) {
        int i12;
        this.zzba = i11;
        this.zzbb = h7Var;
        this.zzaz = z7Var;
        int i13 = i7.f5386a[h7Var.ordinal()];
        this.zzbc = (i13 == 1 || i13 == 2) ? z7Var.zza() : null;
        this.zzbd = (h7Var != h7.SCALAR || (i12 = i7.f5387b[z7Var.ordinal()]) == 1 || i12 == 2 || i12 == 3) ? false : true;
    }

    public static f7[] values() {
        return (f7[]) zzbg.clone();
    }

    public final int zza() {
        return this.zzba;
    }
}
