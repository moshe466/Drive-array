package com.google.firebase.functions;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.functions.FirebaseFunctionsException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FirebaseFunctions {
    private final ContextProvider contextProvider;
    private final String projectId;
    private final String region;
    private static final TaskCompletionSource<Void> providerInstalled = new TaskCompletionSource<>();
    private static boolean providerInstallStarted = false;
    private String urlFormat = "https://%1$s-%2$s.cloudfunctions.net/%3$s";
    private final OkHttpClient client = new OkHttpClient();
    private final Serializer serializer = new Serializer();

    /* renamed from: com.google.firebase.functions.FirebaseFunctions$1 */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements ProviderInstaller.ProviderInstallListener {
        @Override // com.google.android.gms.security.ProviderInstaller.ProviderInstallListener
        public void onProviderInstallFailed(int i, Intent intent) {
            Log.d("FirebaseFunctions", "Failed to update ssl context");
            FirebaseFunctions.providerInstalled.setResult(null);
        }

        @Override // com.google.android.gms.security.ProviderInstaller.ProviderInstallListener
        public void onProviderInstalled() {
            FirebaseFunctions.providerInstalled.setResult(null);
        }
    }

    /* renamed from: com.google.firebase.functions.FirebaseFunctions$2 */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements Callback {
        final /* synthetic */ TaskCompletionSource a;

        AnonymousClass2(TaskCompletionSource taskCompletionSource) {
            r2 = taskCompletionSource;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            r2.setException(iOException instanceof InterruptedIOException ? new FirebaseFunctionsException(FirebaseFunctionsException.Code.DEADLINE_EXCEEDED.name(), FirebaseFunctionsException.Code.DEADLINE_EXCEEDED, null, iOException) : new FirebaseFunctionsException(FirebaseFunctionsException.Code.INTERNAL.name(), FirebaseFunctionsException.Code.INTERNAL, null, iOException));
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FirebaseFunctionsException.Code a = FirebaseFunctionsException.Code.a(response.code());
            String string = response.body().string();
            FirebaseFunctionsException a2 = FirebaseFunctionsException.a(a, string, FirebaseFunctions.this.serializer);
            if (a2 != null) {
                r2.setException(a2);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                Object opt = jSONObject.opt("data");
                if (opt == null) {
                    opt = jSONObject.opt("result");
                }
                if (opt == null) {
                    r2.setException(new FirebaseFunctionsException("Response is missing data field.", FirebaseFunctionsException.Code.INTERNAL, null));
                } else {
                    r2.setResult(new HttpsCallableResult(FirebaseFunctions.this.serializer.decode(opt)));
                }
            } catch (JSONException e) {
                r2.setException(new FirebaseFunctionsException("Response is not valid JSON object.", FirebaseFunctionsException.Code.INTERNAL, null, e));
            }
        }
    }

    public FirebaseFunctions(Context context, String str, String str2, ContextProvider contextProvider) {
        this.contextProvider = (ContextProvider) Preconditions.checkNotNull(contextProvider);
        this.projectId = (String) Preconditions.checkNotNull(str);
        this.region = (String) Preconditions.checkNotNull(str2);
        maybeInstallProviders(context);
    }

    public static /* synthetic */ Task a(FirebaseFunctions firebaseFunctions, String str, Object obj, HttpsCallOptions httpsCallOptions, Task task) {
        return !task.isSuccessful() ? Tasks.forException(task.getException()) : firebaseFunctions.call(str, obj, (HttpsCallableContext) task.getResult(), httpsCallOptions);
    }

    private Task<HttpsCallableResult> call(@NonNull String str, @Nullable Object obj, HttpsCallableContext httpsCallableContext, HttpsCallOptions httpsCallOptions) {
        Preconditions.checkNotNull(str, "name cannot be null");
        URL a = a(str);
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.serializer.encode(obj));
        Request.Builder post = new Request.Builder().url(a).post(RequestBody.create(MediaType.parse("application/json"), new JSONObject(hashMap).toString()));
        if (httpsCallableContext.getAuthToken() != null) {
            post = post.header("Authorization", "Bearer " + httpsCallableContext.getAuthToken());
        }
        if (httpsCallableContext.getInstanceIdToken() != null) {
            post = post.header("Firebase-Instance-ID-Token", httpsCallableContext.getInstanceIdToken());
        }
        Call newCall = httpsCallOptions.a(this.client).newCall(post.build());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        newCall.enqueue(new Callback() { // from class: com.google.firebase.functions.FirebaseFunctions.2
            final /* synthetic */ TaskCompletionSource a;

            AnonymousClass2(TaskCompletionSource taskCompletionSource2) {
                r2 = taskCompletionSource2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                r2.setException(iOException instanceof InterruptedIOException ? new FirebaseFunctionsException(FirebaseFunctionsException.Code.DEADLINE_EXCEEDED.name(), FirebaseFunctionsException.Code.DEADLINE_EXCEEDED, null, iOException) : new FirebaseFunctionsException(FirebaseFunctionsException.Code.INTERNAL.name(), FirebaseFunctionsException.Code.INTERNAL, null, iOException));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                FirebaseFunctionsException.Code a2 = FirebaseFunctionsException.Code.a(response.code());
                String string = response.body().string();
                FirebaseFunctionsException a22 = FirebaseFunctionsException.a(a2, string, FirebaseFunctions.this.serializer);
                if (a22 != null) {
                    r2.setException(a22);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Object opt = jSONObject.opt("data");
                    if (opt == null) {
                        opt = jSONObject.opt("result");
                    }
                    if (opt == null) {
                        r2.setException(new FirebaseFunctionsException("Response is missing data field.", FirebaseFunctionsException.Code.INTERNAL, null));
                    } else {
                        r2.setResult(new HttpsCallableResult(FirebaseFunctions.this.serializer.decode(opt)));
                    }
                } catch (JSONException e) {
                    r2.setException(new FirebaseFunctionsException("Response is not valid JSON object.", FirebaseFunctionsException.Code.INTERNAL, null, e));
                }
            }
        });
        return taskCompletionSource2.getTask();
    }

    @NonNull
    public static FirebaseFunctions getInstance() {
        return getInstance(FirebaseApp.getInstance(), "us-central1");
    }

    @NonNull
    public static FirebaseFunctions getInstance(@NonNull FirebaseApp firebaseApp) {
        return getInstance(firebaseApp, "us-central1");
    }

    @NonNull
    public static FirebaseFunctions getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        Preconditions.checkNotNull(firebaseApp, "You must call FirebaseApp.initializeApp first.");
        Preconditions.checkNotNull(str);
        FunctionsMultiResourceComponent functionsMultiResourceComponent = (FunctionsMultiResourceComponent) firebaseApp.get(FunctionsMultiResourceComponent.class);
        Preconditions.checkNotNull(functionsMultiResourceComponent, "Functions component does not exist.");
        return functionsMultiResourceComponent.a(str);
    }

    @NonNull
    public static FirebaseFunctions getInstance(@NonNull String str) {
        return getInstance(FirebaseApp.getInstance(), str);
    }

    private static void maybeInstallProviders(Context context) {
        synchronized (providerInstalled) {
            if (providerInstallStarted) {
                return;
            }
            providerInstallStarted = true;
            new Handler(context.getMainLooper()).post(FirebaseFunctions$$Lambda$1.lambdaFactory$(context));
        }
    }

    public Task<HttpsCallableResult> a(String str, @Nullable Object obj, HttpsCallOptions httpsCallOptions) {
        return providerInstalled.getTask().continueWithTask(FirebaseFunctions$$Lambda$2.lambdaFactory$(this)).continueWithTask(FirebaseFunctions$$Lambda$3.lambdaFactory$(this, str, obj, httpsCallOptions));
    }

    @VisibleForTesting
    URL a(String str) {
        try {
            return new URL(String.format(this.urlFormat, this.region, this.projectId, str));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    @NonNull
    public HttpsCallableReference getHttpsCallable(@NonNull String str) {
        return new HttpsCallableReference(this, str);
    }

    public void useFunctionsEmulator(@NonNull String str) {
        Preconditions.checkNotNull(str, "origin cannot be null");
        this.urlFormat = str + "/%2$s/%1$s/%3$s";
    }
}
