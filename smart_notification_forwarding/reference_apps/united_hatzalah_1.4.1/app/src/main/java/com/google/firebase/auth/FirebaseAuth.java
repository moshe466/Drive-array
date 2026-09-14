package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.internal.p002firebaseauthapi.zzael;
import com.google.android.gms.internal.p002firebaseauthapi.zzaev;
import com.google.android.gms.internal.p002firebaseauthapi.zzaft;
import com.google.android.gms.internal.p002firebaseauthapi.zzagd;
import com.google.android.gms.internal.p002firebaseauthapi.zzahj;
import com.google.android.gms.internal.p002firebaseauthapi.zzahk;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import com.google.android.gms.internal.p002firebaseauthapi.zzaib;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzbl;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzca;
import com.google.firebase.auth.internal.zzcb;
import com.google.firebase.auth.internal.zzcf;
import com.google.firebase.auth.internal.zzcg;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public class FirebaseAuth implements InternalAuthProvider {
    private final FirebaseApp zza;
    private final Executor zzaa;
    private String zzab;
    private final List<IdTokenListener> zzb;
    private final List<com.google.firebase.auth.internal.IdTokenListener> zzc;
    private final List<AuthStateListener> zzd;
    private final zzach zze;
    private FirebaseUser zzf;
    private final com.google.firebase.auth.internal.zzac zzg;
    private final Object zzh;
    private String zzi;
    private final Object zzj;
    private String zzk;
    private zzbx zzl;
    private final RecaptchaAction zzm;
    private final RecaptchaAction zzn;
    private final RecaptchaAction zzo;
    private final RecaptchaAction zzp;
    private final RecaptchaAction zzq;
    private final RecaptchaAction zzr;
    private final zzcb zzs;
    private final zzcg zzt;
    private final com.google.firebase.auth.internal.zzb zzu;
    private final Provider<InteropAppCheckTokenProvider> zzv;
    private final Provider<HeartBeatController> zzw;
    private zzca zzx;
    private final Executor zzy;
    private final Executor zzz;

    /* loaded from: classes.dex */
    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    /* loaded from: classes.dex */
    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    /* loaded from: classes.dex */
    public class zzb implements com.google.firebase.auth.internal.zzl {
        public zzb() {
        }

        @Override // com.google.firebase.auth.internal.zzl
        public final void zza(zzahn zzahnVar, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzahnVar);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzahnVar);
            FirebaseAuth.this.zza(firebaseUser, zzahnVar, true);
        }
    }

    /* loaded from: classes.dex */
    public class zzc extends zzb implements com.google.firebase.auth.internal.zzau, com.google.firebase.auth.internal.zzl {
        public zzc(FirebaseAuth firebaseAuth) {
            super();
        }

        @Override // com.google.firebase.auth.internal.zzau
        public final void zza(Status status) {
        }
    }

    public FirebaseAuth(FirebaseApp firebaseApp, Provider<InteropAppCheckTokenProvider> provider, Provider<HeartBeatController> provider2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        this(firebaseApp, new zzach(firebaseApp, executor2, scheduledExecutorService), new zzcb(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey()), zzcg.zzc(), com.google.firebase.auth.internal.zzb.zza(), provider, provider2, executor, executor2, executor3, executor4);
    }

    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    private final synchronized zzca zzj() {
        return zzj(this);
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.add(authStateListener);
        this.zzaa.execute(new zzs(this, authStateListener));
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.add(idTokenListener);
        this.zzaa.execute(new zzj(this, idTokenListener));
    }

    public Task<Void> applyActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zza(this.zza, str, this.zzk);
    }

    public Task<ActionCodeResult> checkActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzb(this.zza, str, this.zzk);
    }

    public Task<Void> confirmPasswordReset(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zza(this.zza, str, str2, this.zzk);
    }

    public Task<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return new zzp(this, str, str2).zza(this, this.zzk, this.zzo, "EMAIL_PASSWORD_PROVIDER");
    }

    @Deprecated
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzc(this.zza, str, this.zzk);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public Task<GetTokenResult> getAccessToken(boolean z3) {
        return zza(this.zzf, z3);
    }

    public FirebaseApp getApp() {
        return this.zza;
    }

    public FirebaseUser getCurrentUser() {
        return this.zzf;
    }

    public String getCustomAuthDomain() {
        return this.zzab;
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzg;
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzh) {
            str = this.zzi;
        }
        return str;
    }

    public Task<AuthResult> getPendingAuthResult() {
        return this.zzt.zza();
    }

    public String getTenantId() {
        String str;
        synchronized (this.zzj) {
            str = this.zzk;
        }
        return str;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public String getUid() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public Task<Void> initializeRecaptchaConfig() {
        if (this.zzl == null) {
            this.zzl = new zzbx(this.zza, this);
        }
        return this.zzl.zza(this.zzk, Boolean.FALSE).continueWithTask(new zzy(this));
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.zza(str);
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.remove(authStateListener);
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.remove(idTokenListener);
    }

    public Task<Void> revokeAccessToken(String str) {
        Preconditions.checkNotEmpty(str);
        FirebaseUser currentUser = getCurrentUser();
        Preconditions.checkNotNull(currentUser);
        return currentUser.getIdToken(false).continueWithTask(new zzu(this, str));
    }

    public Task<Void> sendPasswordResetEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, null);
    }

    public Task<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.zzi;
            if (str2 != null) {
                actionCodeSettings.zza(str2);
            }
            return new zzr(this, str, actionCodeSettings).zza(this, this.zzk, this.zzm, "EMAIL_PASSWORD_PROVIDER");
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    public void setCustomAuthDomain(String str) {
        String concat;
        Preconditions.checkNotEmpty(str);
        if (str.startsWith("chrome-extension://")) {
            this.zzab = str;
            return;
        }
        if (str.contains("://")) {
            concat = str;
        } else {
            concat = "http://".concat(str);
        }
        try {
            this.zzab = (String) Preconditions.checkNotNull(new URI(concat).getHost());
        } catch (URISyntaxException e4) {
            if (Log.isLoggable("FirebaseAuth", 4)) {
                e4.getMessage();
            }
            this.zzab = str;
        }
    }

    public Task<Void> setFirebaseUIVersion(String str) {
        return this.zze.zza(str);
    }

    public void setLanguageCode(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzh) {
            this.zzi = str;
        }
    }

    public void setTenantId(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzj) {
            this.zzk = str;
        }
    }

    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser != null && firebaseUser.isAnonymous()) {
            com.google.firebase.auth.internal.zzaf zzafVar = (com.google.firebase.auth.internal.zzaf) this.zzf;
            zzafVar.zza(false);
            return Tasks.forResult(new com.google.firebase.auth.internal.zzz(zzafVar));
        }
        return this.zze.zza(this.zza, new zzb(), this.zzk);
    }

    public Task<AuthResult> signInWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if (!emailAuthCredential.zzf()) {
                return zza(emailAuthCredential.zzc(), (String) Preconditions.checkNotNull(emailAuthCredential.zzd()), this.zzk, (FirebaseUser) null, false);
            }
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzaei.zza(new Status(17072)));
            }
            return zza(emailAuthCredential, (FirebaseUser) null, false);
        }
        if (zza2 instanceof PhoneAuthCredential) {
            return this.zze.zza(this.zza, (PhoneAuthCredential) zza2, this.zzk, (com.google.firebase.auth.internal.zzl) new zzb());
        }
        return this.zze.zza(this.zza, zza2, this.zzk, new zzb());
    }

    public Task<AuthResult> signInWithCustomToken(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zza(this.zza, str, this.zzk, new zzb());
    }

    public Task<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return zza(str, str2, this.zzk, (FirebaseUser) null, false);
    }

    public Task<AuthResult> signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzh();
        zzca zzcaVar = this.zzx;
        if (zzcaVar != null) {
            zzcaVar.zza();
        }
    }

    public Task<AuthResult> startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzt.zza(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzaei.zza(new Status(17057)));
        }
        zzbl.zza(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzc] */
    public Task<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String tenantId = firebaseUser.getTenantId();
            if ((tenantId != null && !tenantId.equals(this.zzk)) || ((str = this.zzk) != null && !str.equals(tenantId))) {
                return Tasks.forException(zzaei.zza(new Status(17072)));
            }
            String apiKey = firebaseUser.zza().getOptions().getApiKey();
            String apiKey2 = this.zza.getOptions().getApiKey();
            if (firebaseUser.zzc().zzg() && apiKey2.equals(apiKey)) {
                zza(com.google.firebase.auth.internal.zzaf.zza(this.zza, firebaseUser), firebaseUser.zzc(), true);
                return Tasks.forResult(null);
            }
            return zza(firebaseUser, (zzcf) new zzc(this));
        }
        throw new IllegalArgumentException("Cannot update current user with null user!");
    }

    public void useAppLanguage() {
        synchronized (this.zzh) {
            this.zzi = zzaev.zza();
        }
    }

    public void useEmulator(String str, int i) {
        boolean z3;
        Preconditions.checkNotEmpty(str);
        if (i >= 0 && i <= 65535) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Port number must be in the range 0-65535");
        zzagd.zza(this.zza, str, i);
    }

    public Task<String> verifyPasswordResetCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzd(this.zza, str, this.zzk);
    }

    private static zzca zzj(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.zzx == null) {
            firebaseAuth.zzx = new zzca((FirebaseApp) Preconditions.checkNotNull(firebaseAuth.zza));
        }
        return firebaseAuth.zzx;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzj().zza(this.zzc.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zzb(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zza(firebaseUser, emailAuthCredential, false);
            }
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzaei.zza(new Status(17072)));
            }
            return zza(firebaseUser, emailAuthCredential, true);
        }
        if (zza2 instanceof PhoneAuthCredential) {
            return this.zze.zza(this.zza, firebaseUser, (PhoneAuthCredential) zza2, this.zzk, (zzcf) new zza());
        }
        return this.zze.zzb(this.zza, firebaseUser, zza2, firebaseUser.getTenantId(), (zzcf) new zza());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<AuthResult> zzc(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zza(emailAuthCredential.zzc(), Preconditions.checkNotEmpty(emailAuthCredential.zzd()), firebaseUser.getTenantId(), firebaseUser, true);
            }
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzaei.zza(new Status(17072)));
            }
            return zza(emailAuthCredential, firebaseUser, true);
        }
        if (zza2 instanceof PhoneAuthCredential) {
            return this.zze.zzb(this.zza, firebaseUser, (PhoneAuthCredential) zza2, this.zzk, (zzcf) new zza());
        }
        return this.zze.zzc(this.zza, firebaseUser, zza2, firebaseUser.getTenantId(), new zza());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zzd(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzd(this.zza, firebaseUser, str, new zza());
    }

    public final Executor zze() {
        return this.zzy;
    }

    public final Executor zzf() {
        return this.zzz;
    }

    public final Executor zzg() {
        return this.zzaa;
    }

    public final void zzh() {
        Preconditions.checkNotNull(this.zzs);
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser != null) {
            this.zzs.zzb(firebaseUser);
            this.zzf = null;
        }
        this.zzs.zzb();
        zzb(this, (FirebaseUser) null);
        zza(this, (FirebaseUser) null);
    }

    public final boolean zzi() {
        return zzael.zza(getApp().getApplicationContext());
    }

    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.add(idTokenListener);
        zzj().zza(this.zzc.size());
    }

    public Task<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zza(str2);
        }
        actionCodeSettings.zza(1);
        return new zzo(this, str, actionCodeSettings).zza(this, this.zzk, this.zzm, "EMAIL_PASSWORD_PROVIDER");
    }

    public final Task<Void> zza(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zza(firebaseUser, new zzt(this, firebaseUser));
    }

    /* loaded from: classes.dex */
    public class zza implements com.google.firebase.auth.internal.zzau, com.google.firebase.auth.internal.zzl {
        public zza() {
        }

        @Override // com.google.firebase.auth.internal.zzl
        public final void zza(zzahn zzahnVar, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzahnVar);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzahnVar);
            FirebaseAuth.this.zza(firebaseUser, zzahnVar, true, true);
        }

        @Override // com.google.firebase.auth.internal.zzau
        public final void zza(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
                FirebaseAuth.this.signOut();
            }
        }
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, MultiFactorAssertion multiFactorAssertion, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(multiFactorAssertion);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zze.zza(this.zza, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, new zzb());
        }
        if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.zze.zza(this.zza, (TotpMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, this.zzk, new zzb());
        }
        return Tasks.forException(zzaei.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
    }

    public final Provider<HeartBeatController> zzd() {
        return this.zzw;
    }

    private FirebaseAuth(FirebaseApp firebaseApp, zzach zzachVar, zzcb zzcbVar, zzcg zzcgVar, com.google.firebase.auth.internal.zzb zzbVar, Provider<InteropAppCheckTokenProvider> provider, Provider<HeartBeatController> provider2, Executor executor, Executor executor2, Executor executor3, Executor executor4) {
        zzahn zza2;
        this.zzb = new CopyOnWriteArrayList();
        this.zzc = new CopyOnWriteArrayList();
        this.zzd = new CopyOnWriteArrayList();
        this.zzh = new Object();
        this.zzj = new Object();
        this.zzm = RecaptchaAction.custom("getOobCode");
        this.zzn = RecaptchaAction.custom("signInWithPassword");
        this.zzo = RecaptchaAction.custom("signUpPassword");
        this.zzp = RecaptchaAction.custom("sendVerificationCode");
        this.zzq = RecaptchaAction.custom("mfaSmsEnrollment");
        this.zzr = RecaptchaAction.custom("mfaSmsSignIn");
        this.zza = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zze = (zzach) Preconditions.checkNotNull(zzachVar);
        zzcb zzcbVar2 = (zzcb) Preconditions.checkNotNull(zzcbVar);
        this.zzs = zzcbVar2;
        this.zzg = new com.google.firebase.auth.internal.zzac();
        zzcg zzcgVar2 = (zzcg) Preconditions.checkNotNull(zzcgVar);
        this.zzt = zzcgVar2;
        this.zzu = (com.google.firebase.auth.internal.zzb) Preconditions.checkNotNull(zzbVar);
        this.zzv = provider;
        this.zzw = provider2;
        this.zzy = executor2;
        this.zzz = executor3;
        this.zzaa = executor4;
        FirebaseUser zza3 = zzcbVar2.zza();
        this.zzf = zza3;
        if (zza3 != null && (zza2 = zzcbVar2.zza(zza3)) != null) {
            zza(this, this.zzf, zza2, false, false);
        }
        zzcgVar2.zza(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.zzz, com.google.firebase.auth.internal.zzcf] */
    public final Task<GetTokenResult> zza(FirebaseUser firebaseUser, boolean z3) {
        if (firebaseUser == null) {
            return Tasks.forException(zzaei.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzahn zzc2 = firebaseUser.zzc();
        if (zzc2.zzg() && !z3) {
            return Tasks.forResult(zzbi.zza(zzc2.zzc()));
        }
        return this.zze.zza(this.zza, firebaseUser, zzc2.zzd(), (zzcf) new zzz(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zzb(FirebaseUser firebaseUser) {
        return zza(firebaseUser, (zzcf) new zza());
    }

    public final Task<AuthResult> zzb(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzt.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaei.zza(new Status(17057)));
        }
        zzbl.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zzc(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzc(this.zza, firebaseUser, str, new zza());
    }

    public final Task<zzahj> zza() {
        return this.zze.zza();
    }

    public final Task<zzahk> zza(String str) {
        return this.zze.zza(this.zzk, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<AuthResult> zza(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        if (authCredential instanceof EmailAuthCredential) {
            return new zzm(this, firebaseUser, (EmailAuthCredential) authCredential.zza()).zza(this, firebaseUser.getTenantId(), this.zzo, "EMAIL_PASSWORD_PROVIDER");
        }
        return this.zze.zza(this.zza, firebaseUser, authCredential.zza(), (String) null, (zzcf) new zza());
    }

    public final Provider<InteropAppCheckTokenProvider> zzc() {
        return this.zzv;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<AuthResult> zzb(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzb(this.zza, firebaseUser, str, new zza());
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, zzcf zzcfVar) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zza(this.zza, firebaseUser, zzcfVar);
    }

    public final synchronized zzbx zzb() {
        return this.zzl;
    }

    private static void zzb(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            firebaseUser.getUid();
        }
        firebaseAuth.zzaa.execute(new zzx(firebaseAuth, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzd() : null)));
    }

    public final Task<AuthResult> zza(MultiFactorAssertion multiFactorAssertion, com.google.firebase.auth.internal.zzam zzamVar, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzamVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zze.zza(this.zza, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzamVar.zzc()), new zzb());
        }
        if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.zze.zza(this.zza, firebaseUser, (TotpMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzamVar.zzc()), this.zzk, new zzb());
        }
        throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
    }

    private final boolean zzb(String str) {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(str);
        return (parseLink == null || TextUtils.equals(this.zzk, parseLink.zza())) ? false : true;
    }

    public final Task<Void> zza(ActionCodeSettings actionCodeSettings, String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzi != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zza(this.zzi);
        }
        return this.zze.zza(this.zza, actionCodeSettings, str);
    }

    public final Task<AuthResult> zza(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzt.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaei.zza(new Status(17057)));
        }
        zzbl.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<TotpSecret> zza(com.google.firebase.auth.internal.zzam zzamVar) {
        Preconditions.checkNotNull(zzamVar);
        return this.zze.zza(zzamVar, this.zzk).continueWithTask(new zzv(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zza(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zza(this.zza, firebaseUser, str, this.zzk, (zzcf) new zza()).continueWithTask(new zzq(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zza(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zze.zza(this.zza, firebaseUser, (PhoneAuthCredential) phoneAuthCredential.zza(), (zzcf) new zza());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<Void> zza(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zze.zza(this.zza, firebaseUser, userProfileChangeRequest, (zzcf) new zza());
    }

    public final Task<Void> zza(String str, String str2, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.zzi;
        if (str3 != null) {
            actionCodeSettings.zza(str3);
        }
        return this.zze.zza(str, str2, actionCodeSettings);
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, boolean z3) {
        return new zzac(this, z3, firebaseUser, emailAuthCredential).zza(this, this.zzk, z3 ? this.zzm : this.zzn, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task<AuthResult> zza(String str, String str2, String str3, FirebaseUser firebaseUser, boolean z3) {
        return new zzab(this, str, z3, firebaseUser, str2, str3).zza(this, str3, this.zzn, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task<AuthResult> zza(EmailAuthCredential emailAuthCredential, FirebaseUser firebaseUser, boolean z3) {
        return new zzaa(this, z3, firebaseUser, emailAuthCredential).zza(this, this.zzk, this.zzm, "EMAIL_PASSWORD_PROVIDER");
    }

    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, com.google.firebase.auth.internal.zzj zzjVar) {
        return phoneAuthOptions.zzj() ? onVerificationStateChangedCallbacks : new zzn(this, phoneAuthOptions, zzjVar, onVerificationStateChangedCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return (this.zzg.zzd() && str != null && str.equals(this.zzg.zza())) ? new zzk(this, onVerificationStateChangedCallbacks) : onVerificationStateChangedCallbacks;
    }

    public static void zza(final FirebaseException firebaseException, PhoneAuthOptions phoneAuthOptions, String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback for phone number/uid - " + str);
        final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = zzaft.zza(str, phoneAuthOptions.zze(), null);
        phoneAuthOptions.zzi().execute(new Runnable() { // from class: com.google.firebase.auth.zzh
            @Override // java.lang.Runnable
            public final void run() {
                PhoneAuthProvider.OnVerificationStateChangedCallbacks.this.onVerificationFailed(firebaseException);
            }
        });
    }

    public final synchronized void zza(zzbx zzbxVar) {
        this.zzl = zzbxVar;
    }

    public final void zza(FirebaseUser firebaseUser, zzahn zzahnVar, boolean z3) {
        zza(firebaseUser, zzahnVar, true, false);
    }

    public final void zza(FirebaseUser firebaseUser, zzahn zzahnVar, boolean z3, boolean z4) {
        zza(this, firebaseUser, zzahnVar, true, z4);
    }

    private static void zza(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            firebaseUser.getUid();
        }
        firebaseAuth.zzaa.execute(new zzw(firebaseAuth));
    }

    private static void zza(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzahn zzahnVar, boolean z3, boolean z4) {
        boolean z5;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzahnVar);
        boolean z6 = true;
        boolean z7 = firebaseAuth.zzf != null && firebaseUser.getUid().equals(firebaseAuth.zzf.getUid());
        if (z7 || !z4) {
            FirebaseUser firebaseUser2 = firebaseAuth.zzf;
            if (firebaseUser2 == null) {
                z5 = true;
            } else {
                boolean z8 = (z7 && firebaseUser2.zzc().zzc().equals(zzahnVar.zzc())) ? false : true;
                z5 = z7 ? false : true;
                z6 = z8;
            }
            Preconditions.checkNotNull(firebaseUser);
            if (firebaseAuth.zzf != null && firebaseUser.getUid().equals(firebaseAuth.getUid())) {
                firebaseAuth.zzf.zza(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    firebaseAuth.zzf.zzb();
                }
                List<MultiFactorInfo> enrolledFactors = firebaseUser.getMultiFactor().getEnrolledFactors();
                List<zzal> zzf = firebaseUser.zzf();
                firebaseAuth.zzf.zzc(enrolledFactors);
                firebaseAuth.zzf.zzb(zzf);
            } else {
                firebaseAuth.zzf = firebaseUser;
            }
            if (z3) {
                firebaseAuth.zzs.zzc(firebaseAuth.zzf);
            }
            if (z6) {
                FirebaseUser firebaseUser3 = firebaseAuth.zzf;
                if (firebaseUser3 != null) {
                    firebaseUser3.zza(zzahnVar);
                }
                zzb(firebaseAuth, firebaseAuth.zzf);
            }
            if (z5) {
                zza(firebaseAuth, firebaseAuth.zzf);
            }
            if (z3) {
                firebaseAuth.zzs.zza(firebaseUser, zzahnVar);
            }
            FirebaseUser firebaseUser4 = firebaseAuth.zzf;
            if (firebaseUser4 != null) {
                zzj(firebaseAuth).zza(firebaseUser4.zzc());
            }
        }
    }

    public static void zza(PhoneAuthOptions phoneAuthOptions) {
        String checkNotEmpty;
        String phoneNumber;
        if (phoneAuthOptions.zzm()) {
            FirebaseAuth zzb2 = phoneAuthOptions.zzb();
            com.google.firebase.auth.internal.zzam zzamVar = (com.google.firebase.auth.internal.zzam) Preconditions.checkNotNull(phoneAuthOptions.zzc());
            if (zzamVar.zzd()) {
                phoneNumber = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
                checkNotEmpty = phoneNumber;
            } else {
                PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(phoneAuthOptions.zzf());
                checkNotEmpty = Preconditions.checkNotEmpty(phoneMultiFactorInfo.getUid());
                phoneNumber = phoneMultiFactorInfo.getPhoneNumber();
            }
            if (phoneAuthOptions.zzd() == null || !zzaft.zza(checkNotEmpty, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
                zzb2.zzu.zza(zzb2, phoneNumber, phoneAuthOptions.zza(), zzb2.zzi(), phoneAuthOptions.zzj(), phoneAuthOptions.zzl(), zzamVar.zzd() ? zzb2.zzq : zzb2.zzr).addOnCompleteListener(new zzl(zzb2, phoneAuthOptions, checkNotEmpty));
                return;
            }
            return;
        }
        FirebaseAuth zzb3 = phoneAuthOptions.zzb();
        String checkNotEmpty2 = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        if (phoneAuthOptions.zzd() == null && zzaft.zza(checkNotEmpty2, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
            return;
        }
        zzb3.zzu.zza(zzb3, checkNotEmpty2, phoneAuthOptions.zza(), zzb3.zzi(), phoneAuthOptions.zzj(), phoneAuthOptions.zzl(), zzb3.zzp).addOnCompleteListener(new zzi(zzb3, phoneAuthOptions, checkNotEmpty2));
    }

    public final void zza(PhoneAuthOptions phoneAuthOptions, com.google.firebase.auth.internal.zzj zzjVar) {
        PhoneAuthOptions phoneAuthOptions2;
        long longValue = phoneAuthOptions.zzg().longValue();
        if (longValue >= 0 && longValue <= 120) {
            String checkNotEmpty = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
            String zzc2 = zzjVar.zzc();
            String zzb2 = zzjVar.zzb();
            String zzd = zzjVar.zzd();
            if (com.google.android.gms.internal.p002firebaseauthapi.zzae.zzc(zzc2) && zzb() != null && zzb().zza("PHONE_PROVIDER")) {
                zzc2 = "NO_RECAPTCHA";
            }
            String str = zzc2;
            zzaib zzaibVar = new zzaib(checkNotEmpty, longValue, phoneAuthOptions.zzd() != null, this.zzi, this.zzk, zzd, zzb2, str, zzi());
            PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = zza(checkNotEmpty, phoneAuthOptions.zze());
            if (TextUtils.isEmpty(zzjVar.zzd())) {
                phoneAuthOptions2 = phoneAuthOptions;
                zza2 = zza(phoneAuthOptions2, zza2, com.google.firebase.auth.internal.zzj.zza().zzc(zzd).zzb(str).zza(zzb2).zza());
            } else {
                phoneAuthOptions2 = phoneAuthOptions;
            }
            this.zze.zza(this.zza, zzaibVar, zza2, phoneAuthOptions2.zza(), phoneAuthOptions2.zzi());
            return;
        }
        throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
    }
}
