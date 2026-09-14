package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes.dex */
public class zzaeg {
    private final zzaed zza;
    private final Logger zzb;

    public zzaeg(zzaeg zzaegVar) {
        this(zzaegVar.zza, zzaegVar.zzb);
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending auto retrieval timeout response.", e4, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending send verification code response.", e4, new Object[0]);
        }
    }

    public final void zzc(String str) {
        try {
            this.zza.zzc(str);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending set account info response.", e4, new Object[0]);
        }
    }

    public final void zza(zzagn zzagnVar) {
        try {
            this.zza.zza(zzagnVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending create auth uri response.", e4, new Object[0]);
        }
    }

    public final void zzb() {
        try {
            this.zza.zzb();
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending email verification response.", e4, new Object[0]);
        }
    }

    public final void zzc() {
        try {
            this.zza.zzc();
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when setting FirebaseUI Version", e4, new Object[0]);
        }
    }

    public zzaeg(zzaed zzaedVar, Logger logger) {
        this.zza = (zzaed) Preconditions.checkNotNull(zzaedVar);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void zza() {
        try {
            this.zza.zza();
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending delete account response.", e4, new Object[0]);
        }
    }

    public final void zza(zzaak zzaakVar) {
        try {
            this.zza.zza(zzaakVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending failure result with credential", e4, new Object[0]);
        }
    }

    public final void zza(zzaaj zzaajVar) {
        try {
            this.zza.zza(zzaajVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending failure result for mfa", e4, new Object[0]);
        }
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zza(status, phoneAuthCredential);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending failure result.", e4, new Object[0]);
        }
    }

    public void zza(Status status) {
        try {
            this.zza.zza(status);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending failure result.", e4, new Object[0]);
        }
    }

    public final void zza(zzahj zzahjVar) {
        try {
            this.zza.zza(zzahjVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending Play Integrity Producer project response.", e4, new Object[0]);
        }
    }

    public final void zza(zzahk zzahkVar) {
        try {
            this.zza.zza(zzahkVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending get recaptcha config response.", e4, new Object[0]);
        }
    }

    public final void zza(zzahn zzahnVar, zzahc zzahcVar) {
        try {
            this.zza.zza(zzahnVar, zzahcVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending get token and account info user response", e4, new Object[0]);
        }
    }

    public final void zza(zzahx zzahxVar) {
        try {
            this.zza.zza(zzahxVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending password reset response.", e4, new Object[0]);
        }
    }

    public final void zza(zzahy zzahyVar) {
        try {
            this.zza.zza(zzahyVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending revoke token response.", e4, new Object[0]);
        }
    }

    public final void zza(zzaij zzaijVar) {
        try {
            this.zza.zza(zzaijVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending start mfa enrollment response.", e4, new Object[0]);
        }
    }

    public final void zza(zzahn zzahnVar) {
        try {
            this.zza.zza(zzahnVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending token result.", e4, new Object[0]);
        }
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zza(phoneAuthCredential);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending verification completed response.", e4, new Object[0]);
        }
    }
}
