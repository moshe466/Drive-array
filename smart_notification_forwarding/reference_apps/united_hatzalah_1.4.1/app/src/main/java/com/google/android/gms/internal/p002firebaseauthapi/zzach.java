package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzab;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzah;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzau;
import com.google.firebase.auth.internal.zzav;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzcf;
import com.google.firebase.auth.internal.zzl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzach extends zzafg {
    public zzach(FirebaseApp firebaseApp, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzaef(firebaseApp, scheduledExecutorService);
        this.zzb = executor;
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzack) new zzack(str, str2).zza(firebaseApp));
    }

    public final Task<ActionCodeResult> zzb(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzacj) new zzacj(str, str2).zza(firebaseApp));
    }

    public final Task<SignInMethodQueryResult> zzc(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzacn) new zzacn(str, str2).zza(firebaseApp));
    }

    public final Task<Void> zzd(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcf zzcfVar) {
        return zza((zzadx) new zzadx(str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2, String str3) {
        return zza((zzacm) new zzacm(str, str2, str3).zza(firebaseApp));
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzcf zzcfVar) {
        return zza((zzacx) new zzacx(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<AuthResult> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzcf zzcfVar) {
        return zza((zzada) new zzada(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzl zzlVar) {
        return zza((zzacl) new zzacl(str, str2, str3, str4).zza(firebaseApp).zza((zzaex<AuthResult, zzl>) zzlVar));
    }

    public final Task<String> zzd(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzaeb) new zzaeb(str, str2).zza(firebaseApp));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzcf zzcfVar) {
        return zza((zzadc) new zzadc(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcf zzcfVar) {
        return zza((zzady) new zzady(str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, zzav zzavVar) {
        return zza((zzaco) new zzaco().zza(firebaseUser).zza((zzaex<Void, zzav>) zzavVar).zza((zzau) zzavVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, String str, zzl zzlVar) {
        zzaft.zza();
        zzacq zzacqVar = new zzacq(phoneMultiFactorAssertion, firebaseUser.zze(), str, null);
        zzacqVar.zza(firebaseApp).zza((zzaex<Void, zzl>) zzlVar);
        return zza(zzacqVar);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzcf zzcfVar) {
        return zza((zzade) new zzade(str, str2, str3, str4).zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, TotpMultiFactorAssertion totpMultiFactorAssertion, FirebaseUser firebaseUser, String str, String str2, zzl zzlVar) {
        zzacq zzacqVar = new zzacq(totpMultiFactorAssertion, firebaseUser.zze(), str, str2);
        zzacqVar.zza(firebaseApp).zza((zzaex<Void, zzl>) zzlVar);
        return zza(zzacqVar);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzcf zzcfVar) {
        zzaft.zza();
        return zza((zzadg) new zzadg(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzl zzlVar) {
        zzaft.zza();
        zzacp zzacpVar = new zzacp(phoneMultiFactorAssertion, str, null);
        zzacpVar.zza(firebaseApp).zza((zzaex<AuthResult, zzl>) zzlVar);
        if (firebaseUser != null) {
            zzacpVar.zza(firebaseUser);
        }
        return zza(zzacpVar);
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zza(6);
        return zza((zzadk) new zzadk(str, actionCodeSettings, str2, str3, "sendSignInLinkToEmail").zza(firebaseApp));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, TotpMultiFactorAssertion totpMultiFactorAssertion, String str, String str2, zzl zzlVar) {
        zzacp zzacpVar = new zzacp(totpMultiFactorAssertion, str, str2);
        zzacpVar.zza(firebaseApp).zza((zzaex<AuthResult, zzl>) zzlVar);
        if (firebaseUser != null) {
            zzacpVar.zza(firebaseUser);
        }
        return zza(zzacpVar);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzl zzlVar) {
        return zza((zzadn) new zzadn(str, str2, str3, str4).zza(firebaseApp).zza((zzaex<AuthResult, zzl>) zzlVar));
    }

    public final Task<GetTokenResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcf zzcfVar) {
        return zza((zzacs) new zzacs(str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<GetTokenResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcf zzcfVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzcfVar);
        List<String> zzg = firebaseUser.zzg();
        if ((zzg != null && !zzg.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzaei.zza(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        str.getClass();
        if (!str.equals("password")) {
            return zza((zzadv) new zzadv(str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
        }
        return zza((zzadw) new zzadw().zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<zzahj> zza() {
        return zza(new zzacr());
    }

    public final Task<zzahk> zza(String str, String str2) {
        return zza(new zzacu(str, str2));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzcf zzcfVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzcfVar);
        List<String> zzg = firebaseUser.zzg();
        if (zzg != null && zzg.contains(authCredential.getProvider())) {
            return Tasks.forException(zzaei.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzf()) {
                return zza((zzact) new zzact(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
            }
            return zza((zzacy) new zzacy(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
        }
        if (authCredential instanceof PhoneAuthCredential) {
            zzaft.zza();
            return zza((zzacv) new zzacv((PhoneAuthCredential) authCredential).zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
        }
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzcfVar);
        return zza((zzacw) new zzacw(authCredential).zza(firebaseApp).zza(firebaseUser).zza((zzaex<AuthResult, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzcf zzcfVar) {
        return zza((zzacz) new zzacz(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzcf zzcfVar) {
        return zza((zzadb) new zzadb(str, str2, str3, str4).zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzcf zzcfVar) {
        zzaft.zza();
        return zza((zzadd) new zzadd(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzcf zzcfVar) {
        return zza((zzadf) new zzadf().zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(String str, String str2, String str3, String str4) {
        return zza(new zzadi(str, str2, str3, str4));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        return zza((zzadh) new zzadh(str, actionCodeSettings).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zza(1);
        return zza((zzadk) new zzadk(str, actionCodeSettings, str2, str3, "sendPasswordResetEmail").zza(firebaseApp));
    }

    public final Task<Void> zza(String str) {
        return zza(new zzadj(str));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, zzl zzlVar, String str) {
        return zza((zzadm) new zzadm(str).zza(firebaseApp).zza((zzaex<AuthResult, zzl>) zzlVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zzl zzlVar) {
        return zza((zzadl) new zzadl(authCredential, str).zza(firebaseApp).zza((zzaex<AuthResult, zzl>) zzlVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, zzl zzlVar) {
        return zza((zzado) new zzado(str, str2).zza(firebaseApp).zza((zzaex<AuthResult, zzl>) zzlVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, String str, zzl zzlVar) {
        return zza((zzadq) new zzadq(emailAuthCredential, str).zza(firebaseApp).zza((zzaex<AuthResult, zzl>) zzlVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zzl zzlVar) {
        zzaft.zza();
        return zza((zzadp) new zzadp(phoneAuthCredential, str).zza(firebaseApp).zza((zzaex<AuthResult, zzl>) zzlVar));
    }

    public final Task<Void> zza(zzam zzamVar, String str, String str2, long j2, boolean z3, boolean z4, String str3, String str4, String str5, boolean z5, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzads zzadsVar = new zzads(zzamVar, str, str2, j2, z3, z4, str3, str4, str5, z5);
        zzadsVar.zza(onVerificationStateChangedCallbacks, activity, executor, str);
        return zza(zzadsVar);
    }

    public final Task<zzaij> zza(zzam zzamVar, String str) {
        return zza(new zzadr(zzamVar, str));
    }

    public final Task<Void> zza(zzam zzamVar, PhoneMultiFactorInfo phoneMultiFactorInfo, String str, long j2, boolean z3, boolean z4, String str2, String str3, String str4, boolean z5, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzadu zzaduVar = new zzadu(phoneMultiFactorInfo, Preconditions.checkNotEmpty(zzamVar.zzc()), str, j2, z3, z4, str2, str3, str4, z5);
        zzaduVar.zza(onVerificationStateChangedCallbacks, activity, executor, phoneMultiFactorInfo.getUid());
        return zza(zzaduVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, zzcf zzcfVar) {
        return zza((zzadt) new zzadt(firebaseUser.zze(), str, str2).zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzcf zzcfVar) {
        zzaft.zza();
        return zza((zzaea) new zzaea(phoneAuthCredential).zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzcf zzcfVar) {
        return zza((zzadz) new zzadz(userProfileChangeRequest).zza(firebaseApp).zza(firebaseUser).zza((zzaex<Void, zzl>) zzcfVar).zza((zzau) zzcfVar));
    }

    public final Task<Void> zza(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zza(7);
        return zza(new zzaec(str, str2, actionCodeSettings));
    }

    public static zzaf zza(FirebaseApp firebaseApp, zzahc zzahcVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzahcVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzab(zzahcVar, "firebase"));
        List<zzaht> zzl = zzahcVar.zzl();
        if (zzl != null && !zzl.isEmpty()) {
            for (int i = 0; i < zzl.size(); i++) {
                arrayList.add(new zzab(zzl.get(i)));
            }
        }
        zzaf zzafVar = new zzaf(firebaseApp, arrayList);
        zzafVar.zza(new zzah(zzahcVar.zzb(), zzahcVar.zza()));
        zzafVar.zza(zzahcVar.zzn());
        zzafVar.zza(zzahcVar.zze());
        zzafVar.zzc(zzbk.zza(zzahcVar.zzk()));
        zzafVar.zzb(zzahcVar.zzd());
        return zzafVar;
    }

    public final void zza(FirebaseApp firebaseApp, zzaib zzaibVar, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zza((zzaee) new zzaee(zzaibVar).zza(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor, zzaibVar.zzd()));
    }
}
