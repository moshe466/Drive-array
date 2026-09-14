package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzmx;
import com.google.android.recaptcha.internal.zznd;

/* loaded from: classes.dex */
public class zzmx<MessageType extends zznd<MessageType, BuilderType>, BuilderType extends zzmx<MessageType, BuilderType>> extends zzkn<MessageType, BuilderType> {
    protected zznd zza;
    private final zznd zzb;

    public zzmx(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzL()) {
            this.zza = messagetype.zzv();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zze(Object obj, Object obj2) {
        zzos.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.recaptcha.internal.zzkn
    public final /* synthetic */ zzkn zzb(zzko zzkoVar) {
        zzh((zznd) zzkoVar);
        return this;
    }

    @Override // com.google.android.recaptcha.internal.zzkn
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzmx zza() {
        zzmx zzmxVar = (zzmx) this.zzb.zzh(5, null, null);
        zzmxVar.zza = zzl();
        return zzmxVar;
    }

    public final zzmx zzh(zznd zzndVar) {
        if (!this.zzb.equals(zzndVar)) {
            if (!this.zza.zzL()) {
                zzo();
            }
            zze(this.zza, zzndVar);
        }
        return this;
    }

    @Override // com.google.android.recaptcha.internal.zzoh
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final MessageType zzk() {
        MessageType zzl = zzl();
        if (zznd.zzK(zzl, true)) {
            return zzl;
        }
        throw new zzpk(zzl);
    }

    @Override // com.google.android.recaptcha.internal.zzoh
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public MessageType zzl() {
        if (!this.zza.zzL()) {
            return (MessageType) this.zza;
        }
        this.zza.zzG();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.recaptcha.internal.zzoj
    public final /* synthetic */ zzoi zzm() {
        return this.zzb;
    }

    public final void zzn() {
        if (!this.zza.zzL()) {
            zzo();
        }
    }

    public void zzo() {
        zznd zzv = this.zzb.zzv();
        zze(zzv, this.zza);
        this.zza = zzv;
    }

    @Override // com.google.android.recaptcha.internal.zzoj
    public final boolean zzp() {
        return zznd.zzK(this.zza, false);
    }
}
