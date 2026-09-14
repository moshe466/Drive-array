package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import P2.G;
import a.AbstractC0228a;
import kotlinx.coroutines.TimeoutCancellationException;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdg extends AbstractC0793i implements p {
    Object zza;
    int zzb;
    final /* synthetic */ zzdt zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzsp zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdg(zzdt zzdtVar, String str, long j2, zzsp zzspVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzc = zzdtVar;
        this.zzd = str;
        this.zze = j2;
        this.zzf = zzspVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zzdg(this.zzc, this.zzd, this.zze, this.zzf, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdg) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        zzek zzu;
        zzen zzenVar;
        Exception e4;
        TimeoutCancellationException e5;
        zzbd e6;
        zzbd zzs;
        zzbd zzs2;
        zzbd zzs3;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (this.zzb != 0) {
            zzenVar = (zzen) this.zza;
            try {
                AbstractC0228a.C(obj);
            } catch (zzbd e7) {
                e6 = e7;
                zzs3 = this.zzc.zzs(e6, e6);
                zzenVar.zzb(zzs3);
                throw zzs3;
            } catch (TimeoutCancellationException e8) {
                e5 = e8;
                zzs2 = this.zzc.zzs(e5, new zzbd(zzbb.zzc, zzba.zzb, e5.getMessage()));
                zzenVar.zzb(zzs2);
                throw zzs2;
            } catch (Exception e9) {
                e4 = e9;
                zzs = this.zzc.zzs(e4, new zzbd(zzbb.zzc, zzba.zzZ, e4.getMessage()));
                zzenVar.zzb(zzs);
                throw zzs;
            }
        } else {
            AbstractC0228a.C(obj);
            zzu = this.zzc.zzu(this.zzd);
            zzen zzf = zzu.zzf(28);
            try {
                long j2 = this.zze;
                zzdf zzdfVar = new zzdf(this.zzc, this.zzf, zzf, null);
                this.zza = zzf;
                this.zzb = 1;
                Object A3 = G.A(j2, zzdfVar, this);
                if (A3 != enumC0779a) {
                    zzenVar = zzf;
                    obj = A3;
                } else {
                    return enumC0779a;
                }
            } catch (zzbd e10) {
                zzenVar = zzf;
                e6 = e10;
                zzs3 = this.zzc.zzs(e6, e6);
                zzenVar.zzb(zzs3);
                throw zzs3;
            } catch (TimeoutCancellationException e11) {
                zzenVar = zzf;
                e5 = e11;
                zzs2 = this.zzc.zzs(e5, new zzbd(zzbb.zzc, zzba.zzb, e5.getMessage()));
                zzenVar.zzb(zzs2);
                throw zzs2;
            } catch (Exception e12) {
                zzenVar = zzf;
                e4 = e12;
                zzs = this.zzc.zzs(e4, new zzbd(zzbb.zzc, zzba.zzZ, e4.getMessage()));
                zzenVar.zzb(zzs);
                throw zzs;
            }
        }
        return (zzsr) obj;
    }
}
