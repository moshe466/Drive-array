package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzav implements Runnable {
    private final long zza;
    private final PowerManager.WakeLock zzb = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId zzc;
    private final zzax zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzav(FirebaseInstanceId firebaseInstanceId, zzai zzaiVar, zzax zzaxVar, long j) {
        this.zzc = firebaseInstanceId;
        this.zzd = zzaxVar;
        this.zza = j;
        this.zzb.setReferenceCounted(false);
    }

    @VisibleForTesting
    private final boolean zzc() {
        String str;
        zzas b = this.zzc.b();
        if (!this.zzc.a(b)) {
            return true;
        }
        try {
            String c = this.zzc.c();
            if (c == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if ((b == null || (b != null && !c.equals(b.a))) && FirebaseApp.DEFAULT_APP_NAME.equals(this.zzc.a().getName())) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(this.zzc.a().getName());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", c);
                Context a = a();
                Intent intent2 = new Intent(a, (Class<?>) FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                a.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException e) {
            if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                str = "Token retrieval failed without exception message. Will retry token retrieval";
            } else {
                if (e.getMessage() != null) {
                    throw e;
                }
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message);
                sb.append(". Will retry token retrieval");
                str = sb.toString();
            }
            Log.w("FirebaseInstanceId", str);
            return false;
        } catch (SecurityException unused) {
            str = "Token retrieval failed with SecurityException. Will retry token retrieval";
            Log.w("FirebaseInstanceId", str);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a() {
        return this.zzc.a().getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public final void run() {
        if (zzaq.zza().a(a())) {
            this.zzb.acquire();
        }
        try {
            try {
                this.zzc.a(true);
            } catch (IOException e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                this.zzc.a(false);
                if (!zzaq.zza().a(a())) {
                    return;
                }
            }
            if (!this.zzc.e()) {
                this.zzc.a(false);
                if (zzaq.zza().a(a())) {
                    this.zzb.release();
                    return;
                }
                return;
            }
            if (zzaq.zza().b(a()) && !b()) {
                new zzau(this).zza();
                if (zzaq.zza().a(a())) {
                    this.zzb.release();
                    return;
                }
                return;
            }
            if (zzc() && this.zzd.a(this.zzc)) {
                this.zzc.a(false);
            } else {
                this.zzc.a(this.zza);
            }
            if (!zzaq.zza().a(a())) {
                return;
            }
            this.zzb.release();
        } catch (Throwable th) {
            if (zzaq.zza().a(a())) {
                this.zzb.release();
            }
            throw th;
        }
    }
}
