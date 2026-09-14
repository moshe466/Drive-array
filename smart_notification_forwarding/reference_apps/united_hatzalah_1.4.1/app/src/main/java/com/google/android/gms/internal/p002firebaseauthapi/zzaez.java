package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.internal.zzau;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaez implements zzaed {
    final /* synthetic */ zzaex zza;

    public zzaez(zzaex zzaexVar) {
        this.zza = zzaexVar;
    }

    private final void zza(zzafe zzafeVar) {
        this.zza.zzi.execute(new zzaff(this, zzafeVar));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzb(String str) {
        int i = this.zza.zza;
        Preconditions.checkState(i == 8, "Unexpected response type " + i);
        zza(new zzafb(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzc(String str) {
        int i = this.zza.zza;
        Preconditions.checkState(i == 7, "Unexpected response type " + i);
        zzaex.zza(this.zza);
    }

    private final void zza(Status status, AuthCredential authCredential, String str, String str2) {
        zzaex.zza(this.zza, status);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzn = authCredential;
        zzaexVar.zzo = str;
        zzaexVar.zzp = str2;
        zzau zzauVar = zzaexVar.zzf;
        if (zzauVar != null) {
            zzauVar.zza(status);
        }
        this.zza.zza(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzb() {
        int i = this.zza.zza;
        Preconditions.checkState(i == 6, "Unexpected response type " + i);
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzc() {
        int i = this.zza.zza;
        Preconditions.checkState(i == 9, "Unexpected response type " + i);
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(String str) {
        int i = this.zza.zza;
        Preconditions.checkState(i == 8, "Unexpected response type " + i);
        this.zza.zzu = true;
        zza(new zzafd(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzagn zzagnVar) {
        int i = this.zza.zza;
        Preconditions.checkState(i == 3, "Unexpected response type " + i);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzl = zzagnVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza() {
        int i = this.zza.zza;
        Preconditions.checkState(i == 5, "Unexpected response type " + i);
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzaak zzaakVar) {
        zza(zzaakVar.zza(), zzaakVar.zzb(), zzaakVar.zzc(), zzaakVar.zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzaaj zzaajVar) {
        zzaex zzaexVar = this.zza;
        zzaexVar.zzq = zzaajVar;
        zzaexVar.zza(zzao.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) {
        int i = this.zza.zza;
        Preconditions.checkState(i == 2, "Unexpected response type " + i);
        zza(status, phoneAuthCredential, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(Status status) {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzaex zzaexVar = this.zza;
        if (zzaexVar.zza == 8) {
            zzaexVar.zzu = true;
            zza(new zzafc(this, status));
        } else {
            zzaex.zza(zzaexVar, status);
            this.zza.zza(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahj zzahjVar) {
        zzaex zzaexVar = this.zza;
        zzaexVar.zzs = zzahjVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahk zzahkVar) {
        zzaex zzaexVar = this.zza;
        zzaexVar.zzr = zzahkVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahn zzahnVar, zzahc zzahcVar) {
        int i = this.zza.zza;
        Preconditions.checkState(i == 2, "Unexpected response type: " + i);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzj = zzahnVar;
        zzaexVar.zzk = zzahcVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahx zzahxVar) {
        int i = this.zza.zza;
        Preconditions.checkState(i == 4, "Unexpected response type " + i);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzm = zzahxVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahy zzahyVar) {
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzaij zzaijVar) {
        zzaex zzaexVar = this.zza;
        zzaexVar.zzt = zzaijVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahn zzahnVar) {
        int i = this.zza.zza;
        Preconditions.checkState(i == 1, "Unexpected response type: " + i);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzj = zzahnVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(PhoneAuthCredential phoneAuthCredential) {
        int i = this.zza.zza;
        Preconditions.checkState(i == 8, "Unexpected response type " + i);
        this.zza.zzu = true;
        zza(new zzafa(this, phoneAuthCredential));
    }
}
