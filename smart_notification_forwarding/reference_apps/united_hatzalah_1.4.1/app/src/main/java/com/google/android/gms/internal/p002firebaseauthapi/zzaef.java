package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzaef {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzaam zzb;
    private final zzafu zzc;

    public zzaef(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = new zzaam(new zzaet(firebaseApp, zzaeu.zza()));
        this.zzc = new zzafu(applicationContext, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(String str, String str2, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzb(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzc(String str, String str2, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzc(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzd(String str, String str2, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzd(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zze(String str, String str2, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        this.zzb.zze(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzf(String str, String str2, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzf(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zze(String str, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzf(str, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahu zzahuVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzahuVar);
        Preconditions.checkNotEmpty(zzahuVar.zzb());
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(zzahuVar, new zzaeg(zzaedVar, zza));
    }

    public final void zzd(String str, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zze(str, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(String str, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzb(str, new zzaeg(zzaedVar, zza));
    }

    public final void zzc(String str, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzc(str, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(str, str2, str3, str4, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(zzahe zzaheVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaheVar);
        Preconditions.checkNotEmpty(zzaheVar.zzc());
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzb(zzaheVar, new zzaeg(zzaedVar, zza));
    }

    public final void zzc(zzahe zzaheVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaheVar);
        this.zzb.zzc(zzaheVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(str, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaedVar);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzb(str, str2, str3, str4, new zzaeg(zzaedVar, zza));
    }

    public final void zza(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3, zzaed zzaedVar) {
        zzagr zza2;
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotNull(zzaedVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza3 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            zza2 = zzagv.zza(str, (String) Preconditions.checkNotNull(zza3.zzc()), (String) Preconditions.checkNotNull(zza3.getSmsCode()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zza2 = zzagx.zza(str, Preconditions.checkNotEmpty(str2), Preconditions.checkNotEmpty(((TotpSecret) Preconditions.checkNotNull(totpMultiFactorAssertion.zza())).getSessionInfo()), Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zza2, str, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, MultiFactorAssertion multiFactorAssertion, String str2, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzaedVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zza(zzagu.zza(str, (String) Preconditions.checkNotNull(zza2.zzc()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2), new zzaeg(zzaedVar, zza));
        } else {
            if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
                TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
                this.zzb.zza(zzagw.zza(str, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str2, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzb())), new zzaeg(zzaedVar, zza));
                return;
            }
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zza(zzahg zzahgVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzahgVar);
        this.zzb.zza(zzahgVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahl zzahlVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzahlVar);
        this.zzb.zza(zzahlVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(str, str2, str3, str4, str5, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, zzait zzaitVar, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaitVar);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(str, zzaitVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahr zzahrVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaedVar);
        Preconditions.checkNotNull(zzahrVar);
        this.zzb.zza(Preconditions.checkNotEmpty(zzahrVar.zzb()), zzahrVar.zza(), new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahw zzahwVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzahwVar);
        this.zzb.zza(zzahwVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahe zzaheVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaheVar);
        Preconditions.checkNotEmpty(zzaheVar.zzd());
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(zzaheVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzaib zzaibVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaedVar);
        Preconditions.checkNotNull(zzaibVar);
        String zzd = zzaibVar.zzd();
        zzaeg zzaegVar = new zzaeg(zzaedVar, zza);
        if (this.zzc.zzc(zzd)) {
            if (zzaibVar.zze()) {
                this.zzc.zzb(zzd);
            } else {
                this.zzc.zzb(zzaegVar, zzd);
                return;
            }
        }
        long zzb = zzaibVar.zzb();
        boolean zzf = zzaibVar.zzf();
        if (zza(zzb, zzf)) {
            zzaibVar.zza(new zzage(this.zzc.zzb()));
        }
        this.zzc.zza(zzd, zzaegVar, zzb, zzf);
        this.zzb.zza(zzaibVar, this.zzc.zza(zzaegVar, zzd));
    }

    public final void zza(zzaif zzaifVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaifVar);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zzd(zzaifVar.zza(), new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzait zzaitVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaitVar);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(zzaitVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzaiu zzaiuVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaiuVar);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(zzaiuVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzagp zzagpVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaedVar);
        Preconditions.checkNotNull(zzagpVar.zzb());
        this.zzb.zza(zzagpVar.zzb(), zzagpVar.zzc(), new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzaai zzaaiVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaedVar);
        Preconditions.checkNotNull(zzaaiVar);
        this.zzb.zza(zzafo.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzaaiVar.zza())), new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, String str2, String str3, long j2, boolean z3, boolean z4, String str4, String str5, String str6, boolean z5, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str, "idToken should not be empty.");
        Preconditions.checkNotNull(zzaedVar);
        zzaeg zzaegVar = new zzaeg(zzaedVar, zza);
        if (this.zzc.zzc(str2)) {
            if (z3) {
                this.zzc.zzb(str2);
            } else {
                this.zzc.zzb(zzaegVar, str2);
                return;
            }
        }
        zzaik zza2 = zzaik.zza(str, str2, str3, str4, str5, str6, null);
        if (zza(j2, z5)) {
            zza2.zza(new zzage(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzaegVar, j2, z5);
        this.zzb.zza(zza2, this.zzc.zza(zzaegVar, str2));
    }

    public final void zza(zzaah zzaahVar, zzaed zzaedVar) {
        Preconditions.checkNotNull(zzaahVar);
        Preconditions.checkNotNull(zzaedVar);
        String phoneNumber = zzaahVar.zzb().getPhoneNumber();
        zzaeg zzaegVar = new zzaeg(zzaedVar, zza);
        if (this.zzc.zzc(phoneNumber)) {
            if (zzaahVar.zzh()) {
                this.zzc.zzb(phoneNumber);
            } else {
                this.zzc.zzb(zzaegVar, phoneNumber);
                return;
            }
        }
        long zza2 = zzaahVar.zza();
        boolean zzi = zzaahVar.zzi();
        zzaii zza3 = zzaii.zza(zzaahVar.zze(), zzaahVar.zzb().getUid(), zzaahVar.zzb().getPhoneNumber(), zzaahVar.zzd(), zzaahVar.zzg(), zzaahVar.zzf(), zzaahVar.zzc());
        if (zza(zza2, zzi)) {
            zza3.zza(new zzage(this.zzc.zzb()));
        }
        this.zzc.zza(phoneNumber, zzaegVar, zza2, zzi);
        this.zzb.zza(zza3, this.zzc.zza(zzaegVar, phoneNumber));
    }

    public final void zza(zzaim zzaimVar, zzaed zzaedVar) {
        this.zzb.zza(zzaimVar, new zzaeg((zzaed) Preconditions.checkNotNull(zzaedVar), zza));
    }

    public final void zza(String str, String str2, String str3, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotEmpty(str2, "uid should not be empty.");
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(str, str2, str3, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzaed zzaedVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaedVar);
        this.zzb.zza(str, userProfileChangeRequest, new zzaeg(zzaedVar, zza));
    }

    private static boolean zza(long j2, boolean z3) {
        if (j2 > 0 && z3) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
