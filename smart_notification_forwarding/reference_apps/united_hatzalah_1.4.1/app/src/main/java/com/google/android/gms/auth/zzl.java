package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzbw;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zzdc;
import com.google.android.gms.internal.auth.zzhs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import e0.a;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class zzl {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";
    public static final String[] zza = {"com.google", "com.google.work", "cn.google"};
    public static final String zzb = "androidPackageName";
    private static final ComponentName zzc = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final Logger zzd = zzd.zza("GoogleAuthUtil");

    public static void clearToken(Context context, String str) {
        zze(context, str, 0L);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzk(context, 8400000);
        AccountChangeEventsRequest accountChangeEventsRequest = new AccountChangeEventsRequest();
        accountChangeEventsRequest.setAccountName(str);
        accountChangeEventsRequest.setEventIndex(i);
        zzdc.zze(context);
        if (zzhs.zzd() && zzo(context)) {
            try {
                AccountChangeEventsResponse accountChangeEventsResponse = (AccountChangeEventsResponse) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zzb(accountChangeEventsRequest), "account change events retrieval");
                zzj(accountChangeEventsResponse);
                return accountChangeEventsResponse.getEvents();
            } catch (ApiException e4) {
                zzl(e4, "account change events retrieval");
            }
        }
        return (List) zzh(context, zzc, new zzi(accountChangeEventsRequest), 0L);
    }

    public static String getAccountId(Context context, String str) {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzk(context, 8400000);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) {
        return getToken(context, account, str, new Bundle());
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    public static Bundle removeAccount(Context context, final Account account) {
        Preconditions.checkNotNull(context);
        zzn(account);
        zzk(context, 8400000);
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            try {
                Bundle bundle = (Bundle) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zzd(account), "account removal");
                zzj(bundle);
                return bundle;
            } catch (ApiException e4) {
                zzl(e4, "account removal");
            }
        }
        return (Bundle) zzh(context, zzc, new zzk() { // from class: com.google.android.gms.auth.zzg
            @Override // com.google.android.gms.auth.zzk
            public final Object zza(IBinder iBinder) {
                Bundle zzf = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzf(account);
                if (zzf != null) {
                    return zzf;
                }
                throw new IOException("Service call returned null.");
            }
        }, 0L);
    }

    public static Boolean requestGoogleAccountsAccess(Context context) {
        Preconditions.checkNotNull(context);
        zzk(context, 11400000);
        String str = context.getApplicationInfo().packageName;
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            try {
                Bundle bundle = (Bundle) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zze(str), "google accounts access request");
                String string = bundle.getString("Error");
                Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
                zzby zza2 = zzby.zza(string);
                if (zzby.SUCCESS.equals(zza2)) {
                    return Boolean.TRUE;
                }
                if (zzby.zzb(zza2)) {
                    zzd.w("isUserRecoverableError status: ".concat(String.valueOf(zza2)), new Object[0]);
                    throw new UserRecoverableAuthException(string, intent);
                }
                throw new GoogleAuthException(string);
            } catch (ApiException e4) {
                zzl(e4, "google accounts access request");
            }
        }
        return (Boolean) zzh(context, zzc, new zzj(str), 0L);
    }

    public static TokenData zza(Context context, final Account account, final String str, Bundle bundle) {
        final Bundle bundle2;
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        Preconditions.checkNotEmpty(str, "Scope cannot be empty or null.");
        zzn(account);
        zzk(context, 8400000);
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzm(context, bundle2);
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            try {
                Bundle bundle3 = (Bundle) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zzc(account, str, bundle2), "token retrieval");
                zzj(bundle3);
                return zzg(bundle3);
            } catch (ApiException e4) {
                zzl(e4, "token retrieval");
            }
        }
        return (TokenData) zzh(context, zzc, new zzk() { // from class: com.google.android.gms.auth.zzf
            @Override // com.google.android.gms.auth.zzk
            public final Object zza(IBinder iBinder) {
                return zzl.zzb(account, str, bundle2, iBinder);
            }
        }, 0L);
    }

    public static /* synthetic */ TokenData zzb(Account account, String str, Bundle bundle, IBinder iBinder) {
        Bundle zze = com.google.android.gms.internal.auth.zze.zzb(iBinder).zze(account, str, bundle);
        if (zze != null) {
            return zzg(zze);
        }
        throw new IOException("Service call returned null");
    }

    public static /* bridge */ /* synthetic */ Object zzd(Object obj) {
        zzj(obj);
        return obj;
    }

    public static void zze(Context context, String str, long j2) {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzk(context, 8400000);
        Bundle bundle = new Bundle();
        zzm(context, bundle);
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            com.google.android.gms.internal.auth.zzg zza2 = com.google.android.gms.internal.auth.zzh.zza(context);
            zzbw zzbwVar = new zzbw();
            zzbwVar.zza(str);
            try {
                zzi(zza2.zza(zzbwVar), "clear token");
                return;
            } catch (ApiException e4) {
                zzl(e4, "clear token");
            }
        }
        zzh(context, zzc, new zzh(str, bundle), 0L);
    }

    public static void zzf(Intent intent) {
        if (intent != null) {
            try {
                Intent.parseUri(intent.toUri(1), 1);
                return;
            } catch (URISyntaxException unused) {
                throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
            }
        }
        throw new IllegalArgumentException("Callback cannot be null.");
    }

    private static TokenData zzg(Bundle bundle) {
        TokenData tokenData;
        Parcelable.Creator<TokenData> creator = TokenData.CREATOR;
        ClassLoader classLoader = TokenData.class.getClassLoader();
        if (classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        Bundle bundle2 = bundle.getBundle("tokenDetails");
        if (bundle2 == null) {
            tokenData = null;
        } else {
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
            }
            tokenData = (TokenData) bundle2.getParcelable("TokenData");
        }
        if (tokenData != null) {
            return tokenData;
        }
        String string = bundle.getString("Error");
        Preconditions.checkNotNull(string);
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzby zza2 = zzby.zza(string);
        if (!zzby.zzb(zza2)) {
            if (!zzby.NETWORK_ERROR.equals(zza2) && !zzby.SERVICE_UNAVAILABLE.equals(zza2) && !zzby.INTNERNAL_ERROR.equals(zza2) && !zzby.AUTH_SECURITY_ERROR.equals(zza2) && !zzby.ACCOUNT_NOT_PRESENT.equals(zza2)) {
                throw new GoogleAuthException(string);
            }
            throw new IOException(string);
        }
        zzd.w("isUserRecoverableError status: ".concat(String.valueOf(zza2)), new Object[0]);
        throw new UserRecoverableAuthException(string, intent);
    }

    private static Object zzh(Context context, ComponentName componentName, zzk zzkVar, long j2) {
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        try {
            try {
                if (gmsClientSupervisor.bindService(componentName, blockingServiceConnection, "GoogleAuthUtil")) {
                    try {
                        return zzkVar.zza(blockingServiceConnection.getService());
                    } catch (RemoteException | InterruptedException | TimeoutException e4) {
                        throw new IOException("Error on service connection.", e4);
                    }
                }
                throw new IOException("Could not bind to service.");
            } finally {
                gmsClientSupervisor.unbindService(componentName, blockingServiceConnection, "GoogleAuthUtil");
            }
        } catch (SecurityException e5) {
            new StringBuilder("SecurityException while bind to auth service: ").append(e5.getMessage());
            throw new IOException("SecurityException while binding to Auth service.", e5);
        }
    }

    private static Object zzi(Task task, String str) {
        try {
            return Tasks.await(task);
        } catch (InterruptedException e4) {
            String e5 = a.e("Interrupted while waiting for the task of ", str, " to finish.");
            zzd.w(e5, new Object[0]);
            throw new IOException(e5, e4);
        } catch (CancellationException e6) {
            String e7 = a.e("Canceled while waiting for the task of ", str, " to finish.");
            zzd.w(e7, new Object[0]);
            throw new IOException(e7, e6);
        } catch (ExecutionException e8) {
            Throwable cause = e8.getCause();
            if (cause instanceof ApiException) {
                throw ((ApiException) cause);
            }
            String e9 = a.e("Unable to get a result for ", str, " due to ExecutionException.");
            zzd.w(e9, new Object[0]);
            throw new IOException(e9, e8);
        }
    }

    private static Object zzj(Object obj) {
        if (obj != null) {
            return obj;
        }
        zzd.w("Service call returned null.", new Object[0]);
        throw new IOException("Service unavailable.");
    }

    private static void zzk(Context context, int i) {
        try {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context.getApplicationContext(), i);
        } catch (GooglePlayServicesIncorrectManifestValueException | GooglePlayServicesNotAvailableException e4) {
            throw new GoogleAuthException(e4.getMessage(), e4);
        } catch (GooglePlayServicesRepairableException e5) {
            throw new GooglePlayServicesAvailabilityException(e5.getConnectionStatusCode(), e5.getMessage(), e5.getIntent());
        }
    }

    private static void zzl(ApiException apiException, String str) {
        zzd.w("%s failed via GoogleAuthServiceClient, falling back to previous approach:\n%s", str, Log.getStackTraceString(apiException));
    }

    private static void zzm(Context context, Bundle bundle) {
        String str = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str);
        String str2 = zzb;
        if (TextUtils.isEmpty(bundle.getString(str2))) {
            bundle.putString(str2, str);
        }
        bundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
    }

    private static void zzn(Account account) {
        if (account != null) {
            if (!TextUtils.isEmpty(account.name)) {
                String[] strArr = zza;
                for (int i = 0; i < 3; i++) {
                    if (strArr[i].equals(account.type)) {
                        return;
                    }
                }
                throw new IllegalArgumentException("Account type not supported");
            }
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
        throw new IllegalArgumentException("Account cannot be null");
    }

    private static boolean zzo(Context context) {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context, 17895000) != 0) {
            return false;
        }
        List zzl = zzhs.zzb().zzl();
        String str = context.getApplicationInfo().packageName;
        Iterator it = zzl.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) {
        zzn(account);
        return zza(context, account, str, bundle).zza();
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }
}
