package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzads extends zzaex<Void, zzl> {
    private final String zzaa;
    private final String zzab;
    private final String zzac;
    private final boolean zzad;
    private final String zzu;
    private final String zzv;
    private final String zzw;
    private final long zzx;
    private final boolean zzy;
    private final boolean zzz;

    public zzads(zzam zzamVar, String str, String str2, long j2, boolean z3, boolean z4, String str3, String str4, String str5, boolean z5) {
        super(8);
        Preconditions.checkNotNull(zzamVar);
        Preconditions.checkNotEmpty(str);
        this.zzu = Preconditions.checkNotEmpty(zzamVar.zzb());
        this.zzv = str;
        this.zzw = str2;
        this.zzx = j2;
        this.zzy = z3;
        this.zzz = z4;
        this.zzaa = str3;
        this.zzab = str4;
        this.zzac = str5;
        this.zzad = z5;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final String zza() {
        return "startMfaEnrollment";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    public final void zza(TaskCompletionSource taskCompletionSource, zzaef zzaefVar) {
        this.zzg = new zzafh(this, taskCompletionSource);
        zzaefVar.zza(this.zzu, this.zzv, this.zzw, this.zzx, this.zzy, this.zzz, this.zzaa, this.zzab, this.zzac, this.zzad, this.zzb);
    }
}
