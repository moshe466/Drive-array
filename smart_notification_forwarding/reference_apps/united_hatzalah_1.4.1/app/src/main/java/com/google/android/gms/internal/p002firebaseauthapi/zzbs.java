package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import com.google.android.gms.internal.p002firebaseauthapi.zzxc;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzbs {
    private final List<zzbr> zza = new ArrayList();
    private zzoj zzb = zzoj.zza;
    private boolean zzc = false;

    public final void zzb() {
        Iterator<zzbr> it = this.zza.iterator();
        while (it.hasNext()) {
            it.next().zza = false;
        }
    }

    public final zzbs zza(zzbr zzbrVar) {
        zzbs zzbsVar;
        boolean z3;
        zzbsVar = zzbrVar.zze;
        if (zzbsVar == null) {
            z3 = zzbrVar.zza;
            if (z3) {
                zzb();
            }
            zzbrVar.zze = this;
            this.zza.add(zzbrVar);
            return this;
        }
        throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
    }

    public final zzbq zza() {
        zzbo zzboVar;
        zzbu zzbuVar;
        zzbu zzbuVar2;
        zzbu zzbuVar3;
        zzbu zzbuVar4;
        int zza;
        zzce zzceVar;
        zzce zzceVar2;
        zzbo zzboVar2;
        boolean z3;
        zzbo zzboVar3;
        zzxc.zza zzb;
        boolean z4;
        zzbo zzboVar4;
        zzbu zzbuVar5;
        zzbu zzbuVar6;
        zzbu zzbuVar7;
        zzbu zzbuVar8;
        if (!this.zzc) {
            this.zzc = true;
            zzxc.zzb zzc = zzxc.zzc();
            ArrayList arrayList = new ArrayList(this.zza.size());
            List<zzbr> list = this.zza;
            for (int i = 0; i < list.size() - 1; i++) {
                zzbuVar5 = list.get(i).zzd;
                zzbuVar6 = zzbu.zza;
                if (zzbuVar5 == zzbuVar6) {
                    zzbuVar7 = list.get(i + 1).zzd;
                    zzbuVar8 = zzbu.zza;
                    if (zzbuVar7 != zzbuVar8) {
                        throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                    }
                }
            }
            HashSet hashSet = new HashSet();
            Integer num = null;
            for (zzbr zzbrVar : this.zza) {
                zzboVar = zzbrVar.zzb;
                if (zzboVar != null) {
                    zzbuVar = zzbrVar.zzd;
                    if (zzbuVar != null) {
                        zzbuVar2 = zzbrVar.zzd;
                        zzbuVar3 = zzbu.zza;
                        if (zzbuVar2 == zzbuVar3) {
                            zza = 0;
                            while (true) {
                                if (zza != 0 && !hashSet.contains(Integer.valueOf(zza))) {
                                    break;
                                }
                                zza = zzqq.zza();
                            }
                        } else {
                            zzbuVar4 = zzbrVar.zzd;
                            zza = zzbu.zza(zzbuVar4);
                        }
                        int i3 = zza;
                        if (!hashSet.contains(Integer.valueOf(i3))) {
                            hashSet.add(Integer.valueOf(i3));
                            zzceVar = zzbrVar.zzc;
                            Integer valueOf = zzceVar.zza() ? Integer.valueOf(i3) : null;
                            zzos zza2 = zzos.zza();
                            zzceVar2 = zzbrVar.zzc;
                            zzbm zza3 = zza2.zza(zzceVar2, valueOf);
                            zzboVar2 = zzbrVar.zzb;
                            z3 = zzbrVar.zza;
                            zzbt zzbtVar = new zzbt(zza3, zzboVar2, i3, z3);
                            zzboVar3 = zzbrVar.zzb;
                            zzb = zzbq.zzb(zza3, zzboVar3, i3);
                            zzc.zza(zzb);
                            z4 = zzbrVar.zza;
                            if (z4) {
                                if (num == null) {
                                    num = Integer.valueOf(i3);
                                    zzboVar4 = zzbrVar.zzb;
                                    if (zzboVar4 != zzbo.zza) {
                                        throw new GeneralSecurityException("Primary key is not enabled");
                                    }
                                } else {
                                    throw new GeneralSecurityException("Two primaries were set");
                                }
                            }
                            arrayList.add(zzbtVar);
                        } else {
                            throw new GeneralSecurityException(AbstractC0008a.j(i3, "Id ", " is used twice in the keyset"));
                        }
                    } else {
                        throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
                    }
                } else {
                    throw new GeneralSecurityException("Key Status not set.");
                }
            }
            if (num != null) {
                zzc.zza(num.intValue());
                zzxc zzxcVar = (zzxc) ((zzaky) zzc.zze());
                zzbq.zzd(zzxcVar);
                return new zzbq(zzxcVar, arrayList, this.zzb);
            }
            throw new GeneralSecurityException("No primary was set");
        }
        throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
    }
}
