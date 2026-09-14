package com.google.android.recaptcha.internal;

import N2.n;
import P2.G;
import T.b;
import s2.C0682g;
import s2.InterfaceC0678c;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class zzff {
    private final InterfaceC0678c zza;
    private final InterfaceC0678c zzb;
    private final InterfaceC0678c zzc;

    public zzff() {
        int i = zzav.zza;
        this.zza = b.A(zzfc.zza);
        this.zzb = b.A(zzfd.zza);
        this.zzc = b.A(zzfe.zza);
    }

    public static final /* synthetic */ zzfk zzb(zzff zzffVar) {
        return (zzfk) ((C0682g) zzffVar.zza).a();
    }

    public static /* synthetic */ Object zze(zzff zzffVar, zzsc zzscVar, zzek zzekVar, InterfaceC0763d interfaceC0763d) {
        try {
            String zzl = zzscVar.zzl();
            String zzM = zzscVar.zzM();
            zzaq zzf = zzffVar.zzf();
            String str = null;
            if (zzf != null && zzf.zzd(zzM)) {
                zzen zzf2 = zzekVar.zzf(25);
                try {
                    String zza = zzffVar.zzf().zza(zzM);
                    if (zza != null) {
                        zzf2.zza();
                        str = zza;
                    }
                } catch (Exception e4) {
                    zzf2.zzb(new zzbd(zzbb.zzk, zzba.zzR, e4.getMessage()));
                }
                zzf2.zzb(new zzbd(zzbb.zzk, zzba.zzS, null));
            }
            if (str == null) {
                zzaq zzf3 = zzffVar.zzf();
                if (zzf3 != null) {
                    zzf3.zzb();
                }
                zzen zzf4 = zzekVar.zzf(23);
                try {
                    str = zzffVar.zzg().zzb(zzl);
                    zzf4.zza();
                    zzen zzf5 = zzekVar.zzf(24);
                    try {
                        zzaq zzf6 = zzffVar.zzf();
                        if (zzf6 != null) {
                            zzf6.zzc(zzM, str);
                        }
                        zzf5.zza();
                    } catch (Exception e5) {
                        zzf5.zzb(new zzbd(zzbb.zzk, zzba.zzT, e5.getMessage()));
                    }
                } catch (zzbd e6) {
                    zzf4.zzb(e6);
                    throw e6;
                }
            }
            return n.L(zzscVar.zzk(), "JAVASCRIPT_TAG", str);
        } catch (Exception e7) {
            if (e7 instanceof zzbd) {
                throw e7;
            }
            throw new zzbd(zzbb.zzb, zzba.zzL, e7.getMessage());
        }
    }

    private final zzaq zzf() {
        return (zzaq) ((C0682g) this.zzb).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzey zzg() {
        return (zzey) ((C0682g) this.zzc).a();
    }

    public final Object zzc(String str, zzto zztoVar, InterfaceC0763d interfaceC0763d) {
        return G.g(new zzfb(this, str, zztoVar, null), interfaceC0763d);
    }

    public final Object zzd(zzsc zzscVar, zzek zzekVar, InterfaceC0763d interfaceC0763d) {
        return zze(this, zzscVar, zzekVar, interfaceC0763d);
    }
}
