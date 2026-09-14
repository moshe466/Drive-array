package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public class FirebaseInstanceId {
    private static final long zza = TimeUnit.HOURS.toSeconds(8);
    private static zzat zzb;

    @VisibleForTesting
    @GuardedBy("FirebaseInstanceId.class")
    private static ScheduledExecutorService zzc;

    @VisibleForTesting
    private final Executor zzd;
    private final FirebaseApp zze;
    private final zzai zzf;
    private final zzl zzg;
    private final zzan zzh;
    private final zzax zzi;

    @GuardedBy("this")
    private boolean zzj;
    private final zza zzk;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class zza {
        private boolean zzb;
        private final Subscriber zzc;

        @GuardedBy("this")
        private boolean zzd;

        @Nullable
        @GuardedBy("this")
        private EventHandler<DataCollectionDefaultChange> zze;

        @Nullable
        @GuardedBy("this")
        private Boolean zzf;

        zza(Subscriber subscriber) {
            this.zzc = subscriber;
        }

        private final synchronized void zzb() {
            if (this.zzd) {
                return;
            }
            this.zzb = zzd();
            this.zzf = zzc();
            if (this.zzf == null && this.zzb) {
                this.zze = new EventHandler(this) { // from class: com.google.firebase.iid.zzk
                    private final FirebaseInstanceId.zza zza;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = this;
                    }

                    @Override // com.google.firebase.events.EventHandler
                    public final void handle(Event event) {
                        FirebaseInstanceId.zza zzaVar = this.zza;
                        synchronized (zzaVar) {
                            if (zzaVar.a()) {
                                FirebaseInstanceId.this.zzj();
                            }
                        }
                    }
                };
                this.zzc.subscribe(DataCollectionDefaultChange.class, this.zze);
            }
            this.zzd = true;
        }

        @Nullable
        private final Boolean zzc() {
            ApplicationInfo applicationInfo;
            Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private final boolean zzd() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context applicationContext = FirebaseInstanceId.this.zze.getApplicationContext();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(applicationContext.getPackageName());
                ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
                return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
            }
        }

        final synchronized void a(boolean z) {
            zzb();
            if (this.zze != null) {
                this.zzc.unsubscribe(DataCollectionDefaultChange.class, this.zze);
                this.zze = null;
            }
            SharedPreferences.Editor edit = FirebaseInstanceId.this.zze.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.zzj();
            }
            this.zzf = Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final synchronized boolean a() {
            zzb();
            if (this.zzf != null) {
                return this.zzf.booleanValue();
            }
            return this.zzb && FirebaseInstanceId.this.zze.isDataCollectionDefaultEnabled();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo) {
        this(firebaseApp, new zzai(firebaseApp.getApplicationContext()), com.google.firebase.iid.zza.b(), com.google.firebase.iid.zza.b(), subscriber, userAgentPublisher, heartBeatInfo);
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzai zzaiVar, Executor executor, Executor executor2, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo) {
        this.zzj = false;
        if (zzai.zza(firebaseApp) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            if (zzb == null) {
                zzb = new zzat(firebaseApp.getApplicationContext());
            }
        }
        this.zze = firebaseApp;
        this.zzf = zzaiVar;
        this.zzg = new zzl(firebaseApp, zzaiVar, executor, userAgentPublisher, heartBeatInfo);
        this.zzd = executor2;
        this.zzi = new zzax(zzb);
        this.zzk = new zza(subscriber);
        this.zzh = new zzan(executor);
        executor2.execute(new Runnable(this) { // from class: com.google.firebase.iid.zzh
            private final FirebaseInstanceId zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (zzc == null) {
                zzc = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            zzc.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    @NonNull
    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    private final Task<InstanceIdResult> zza(final String str, String str2) {
        final String zzd = zzd(str2);
        return Tasks.forResult(null).continueWithTask(this.zzd, new Continuation(this, str, zzd) { // from class: com.google.firebase.iid.zzg
            private final FirebaseInstanceId zza;
            private final String zzb;
            private final String zzc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
                this.zzc = zzd;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.a(this.zzb, this.zzc, task);
            }
        });
    }

    private final <T> T zza(Task<T> task) {
        try {
            return (T) Tasks.await(task, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    d();
                }
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e);
        }
    }

    @Nullable
    @VisibleForTesting
    private static zzas zzb(String str, String str2) {
        return zzb.zza("", str, str2);
    }

    private static String zzd(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj() {
        if (a(b()) || this.zzi.a()) {
            zzk();
        }
    }

    private final synchronized void zzk() {
        if (!this.zzj) {
            a(0L);
        }
    }

    private static String zzl() {
        return zzb.zzb("").a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(final String str, final String str2, Task task) {
        final String zzl = zzl();
        zzas zzb2 = zzb(str, str2);
        return !a(zzb2) ? Tasks.forResult(new zzu(zzl, zzb2.a)) : this.zzh.a(str, str2, new zzap(this, zzl, str, str2) { // from class: com.google.firebase.iid.zzj
            private final FirebaseInstanceId zza;
            private final String zzb;
            private final String zzc;
            private final String zzd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = zzl;
                this.zzc = str;
                this.zzd = str2;
            }

            @Override // com.google.firebase.iid.zzap
            public final Task zza() {
                return this.zza.a(this.zzb, this.zzc, this.zzd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(final String str, final String str2, final String str3) {
        return this.zzg.zza(str, str2, str3).onSuccessTask(this.zzd, new SuccessContinuation(this, str2, str3, str) { // from class: com.google.firebase.iid.zzi
            private final FirebaseInstanceId zza;
            private final String zzb;
            private final String zzc;
            private final String zzd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str2;
                this.zzc = str3;
                this.zzd = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.zza.a(this.zzb, this.zzc, this.zzd, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(String str, String str2, String str3, String str4) {
        zzb.zza("", str, str2, str4, this.zzf.zzb());
        return Tasks.forResult(new zzu(str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final FirebaseApp a() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(long j) {
        a(new zzav(this, this.zzf, this.zzi, Math.min(Math.max(30L, j << 1), zza)), j);
        this.zzj = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        zzas b = b();
        if (a(b)) {
            throw new IOException("token not available");
        }
        zza(this.zzg.zzc(zzl(), b.a, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(boolean z) {
        this.zzj = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(@Nullable zzas zzasVar) {
        return zzasVar == null || zzasVar.a(this.zzf.zzb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzas b() {
        return zzb(zzai.zza(this.zze), "*");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) {
        zzas b = b();
        if (a(b)) {
            throw new IOException("token not available");
        }
        zza(this.zzg.zzd(zzl(), b.a, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return getToken(zzai.zza(this.zze), "*");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void d() {
        zzb.zzb();
        if (this.zzk.a()) {
            zzk();
        }
    }

    @WorkerThread
    public void deleteInstanceId() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zza(this.zzg.zza(zzl()));
        d();
    }

    @WorkerThread
    public void deleteToken(@NonNull String str, @NonNull String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String zzd = zzd(str2);
        zza(this.zzg.zzb(zzl(), str, zzd));
        zzb.zzb("", str, zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e() {
        return this.zzf.zza() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        zzb.zzc("");
        zzk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void g() {
        if (this.zzk.a()) {
            zzj();
        }
    }

    public long getCreationTime() {
        return zzb.zzb("").b();
    }

    @NonNull
    @WorkerThread
    public String getId() {
        zzj();
        return zzl();
    }

    @NonNull
    public Task<InstanceIdResult> getInstanceId() {
        return zza(zzai.zza(this.zze), "*");
    }

    @Nullable
    @Deprecated
    public String getToken() {
        zzas b = b();
        if (a(b)) {
            zzk();
        }
        return zzas.a(b);
    }

    @Nullable
    @WorkerThread
    public String getToken(@NonNull String str, @NonNull String str2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) zza(zza(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    public final synchronized Task<Void> zza(String str) {
        Task<Void> a;
        a = this.zzi.a(str);
        zzk();
        return a;
    }

    @VisibleForTesting
    public final void zzb(boolean z) {
        this.zzk.a(z);
    }

    @VisibleForTesting
    public final boolean zzh() {
        return this.zzk.a();
    }
}
