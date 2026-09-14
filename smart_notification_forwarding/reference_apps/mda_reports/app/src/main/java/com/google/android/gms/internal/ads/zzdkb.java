package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* loaded from: classes.dex */
final class zzdkb extends zzdik<zzdib, zzdmk> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdkb(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzdik
    public final /* synthetic */ zzdib zzak(zzdmk zzdmkVar) {
        zzdmk zzdmkVar2 = zzdmkVar;
        zzdmj zzauf = zzdmkVar2.zzaum().zzauf();
        zzdmo zzauh = zzauf.zzauh();
        zzdox zza = zzdkk.zza(zzauh.zzauu());
        byte[] byteArray = zzdmkVar2.zzass().toByteArray();
        return new zzdoo((ECPrivateKey) zzdoy.zzhgm.zzhd("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzdov.zza(zza))), zzauh.zzauw().toByteArray(), zzdkk.zza(zzauh.zzauv()), zzdkk.zza(zzauf.zzauj()), new zzdkm(zzauf.zzaui().zzauc()));
    }
}
