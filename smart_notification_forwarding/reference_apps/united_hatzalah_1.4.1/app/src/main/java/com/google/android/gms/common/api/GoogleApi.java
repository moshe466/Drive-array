package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.AttributionSource;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaab;
import com.google.android.gms.common.api.internal.zabk;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zacl;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.AttributionSourceWrapper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.Set;
import x.AbstractC0772c;

/* loaded from: classes.dex */
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    protected final GoogleApiManager zaa;
    private final Context zab;
    private final String zac;
    private final AttributionSourceWrapper zad;
    private final Api zae;
    private final Api.ApiOptions zaf;
    private final ApiKey zag;
    private final Looper zah;
    private final int zai;
    private final UserHandle zaj;
    private final GoogleApiClient zak;
    private final StatusExceptionMapper zal;

    /* loaded from: classes.dex */
    public static class Settings {
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zaa;
        public final Looper zab;
        final UserHandle zac;

        /* loaded from: classes.dex */
        public static class Builder {
            private StatusExceptionMapper zaa;
            private Looper zab;
            private UserHandle zac;

            public Settings build() {
                if (this.zaa == null) {
                    this.zaa = new ApiExceptionMapper();
                }
                if (this.zab == null) {
                    this.zab = Looper.getMainLooper();
                }
                return new Settings(this.zaa, null, this.zab, this.zac, null);
            }

            public Builder setLooper(Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zab = looper;
                return this;
            }

            public Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zaa = statusExceptionMapper;
                return this;
            }

            public Builder setUserHandle(UserHandle userHandle) {
                if (Build.VERSION.SDK_INT >= 33) {
                    this.zac = userHandle;
                }
                return this;
            }
        }

        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper, UserHandle userHandle) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
            this.zac = userHandle;
        }

        public /* synthetic */ Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper, UserHandle userHandle, byte[] bArr) {
            this(statusExceptionMapper, null, looper, userHandle);
        }
    }

    public GoogleApi(Activity activity, Api<O> api, O o2, Settings settings) {
        this(activity, activity, api, o2, settings);
    }

    private final BaseImplementation.ApiMethodImpl zad(int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.zaa.zak(this, i, apiMethodImpl);
        return apiMethodImpl;
    }

    private final Task zae(int i, TaskApiCall taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zal(this, i, taskApiCall, taskCompletionSource, this.zal);
        return taskCompletionSource.getTask();
    }

    public GoogleApiClient asGoogleApiClient() {
        return this.zak;
    }

    public ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount googleSignInAccount;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Api.ApiOptions apiOptions = this.zaf;
        boolean z3 = apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions;
        if (z3 && (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount()) != null) {
            account = googleSignInAccount.getAccount();
        } else if (apiOptions instanceof Api.ApiOptions.HasAccountOptions) {
            account = ((Api.ApiOptions.HasAccountOptions) apiOptions).getAccount();
        } else {
            account = null;
        }
        builder.zaa(account);
        if (z3) {
            GoogleSignInAccount googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount();
            if (googleSignInAccount2 == null) {
                set = Collections.EMPTY_SET;
            } else {
                set = googleSignInAccount2.getRequestedScopes();
            }
        } else {
            set = Collections.EMPTY_SET;
        }
        builder.zab(set);
        Context context = this.zab;
        builder.zac(context.getClass().getName());
        builder.setRealClientPackageName(context.getPackageName());
        return builder;
    }

    public Task<Boolean> disconnectService() {
        return this.zaa.zaj(this);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t3) {
        zad(2, t3);
        return t3;
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T t3) {
        zad(0, t3);
        return t3;
    }

    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T t3, U u3) {
        Preconditions.checkNotNull(t3);
        Preconditions.checkNotNull(u3);
        Preconditions.checkNotNull(t3.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(u3.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(Objects.equal(t3.getListenerKey(), u3.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.zan(this, t3, u3, zab.zaa);
    }

    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T t3) {
        zad(1, t3);
        return t3;
    }

    public String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    @Override // com.google.android.gms.common.api.HasApiKey
    public final ApiKey<O> getApiKey() {
        return this.zag;
    }

    public O getApiOptions() {
        return (O) this.zaf;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    public String getContextAttributionTag() {
        return this.zac;
    }

    @Deprecated
    public String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zah;
    }

    public <L> ListenerHolder<L> registerListener(L l3, String str) {
        return ListenerHolders.createListenerHolder(l3, this.zah, str);
    }

    public final int zab() {
        return this.zai;
    }

    public final zacl zac(Context context, Handler handler) {
        return new zacl(context, handler, createClientSettingsBuilder().build());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Api.Client zaf(Looper looper, zabk zabkVar) {
        ClientSettings build = createClientSettingsBuilder().build();
        Api.Client buildClient = ((Api.AbstractClientBuilder) Preconditions.checkNotNull(this.zae.zab())).buildClient(this.zab, looper, build, (ClientSettings) this.zaf, (GoogleApiClient.ConnectionCallbacks) zabkVar, (GoogleApiClient.OnConnectionFailedListener) zabkVar);
        UserHandle userHandle = this.zaj;
        if (userHandle != null && (buildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) buildClient).setUserHandle(userHandle);
        }
        AttributionSourceWrapper attributionSourceWrapper = this.zad;
        if (attributionSourceWrapper != null && (buildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) buildClient).setAttributionSourceWrapper(attributionSourceWrapper);
            return buildClient;
        }
        if (attributionSourceWrapper != null && (buildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) buildClient).zab(attributionSourceWrapper);
            return buildClient;
        }
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (buildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) buildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (buildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) buildClient).zaa(contextAttributionTag);
        }
        return buildClient;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public GoogleApi(android.app.Activity r2, com.google.android.gms.common.api.Api<O> r3, O r4, com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setMapper(r5)
            android.os.Looper r5 = r2.getMainLooper()
            r0.setLooper(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zae(2, taskApiCall);
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        return zae(0, taskApiCall);
    }

    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey, int i) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.zaa.zao(this, listenerKey, i);
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zae(1, taskApiCall);
    }

    private GoogleApi(Context context, Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        String apiFallbackAttributionTag;
        AttributionSource attributionSource;
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) Preconditions.checkNotNull(context.getApplicationContext(), "The provided context did not have an application context.");
        this.zab = context2;
        int i = Build.VERSION.SDK_INT;
        AttributionSourceWrapper attributionSourceWrapper = null;
        if (i >= 30) {
            apiFallbackAttributionTag = i >= 30 ? AbstractC0772c.a(context) : null;
        } else {
            apiFallbackAttributionTag = getApiFallbackAttributionTag(context);
        }
        this.zac = apiFallbackAttributionTag;
        if (i >= 31) {
            attributionSource = context.getAttributionSource();
            attributionSourceWrapper = new AttributionSourceWrapper(attributionSource);
        }
        this.zad = attributionSourceWrapper;
        this.zae = api;
        this.zaf = apiOptions;
        this.zah = settings.zab;
        UserHandle userHandle = settings.zac;
        this.zaj = userHandle;
        ApiKey sharedApiKey = ApiKey.getSharedApiKey(api, apiOptions, apiFallbackAttributionTag, userHandle);
        this.zag = sharedApiKey;
        this.zak = new zabp(this);
        GoogleApiManager zaa = GoogleApiManager.zaa(context2);
        this.zaa = zaa;
        this.zai = zaa.zac();
        this.zal = settings.zaa;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zaab.zaa(activity, zaa, sharedApiKey);
        }
        zaa.zad(this);
    }

    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.register.getListenerKey(), "Listener has already been released.");
        UnregisterListenerMethod unregisterListenerMethod = registrationMethods.zaa;
        Preconditions.checkNotNull(unregisterListenerMethod.getListenerKey(), "Listener has already been released.");
        return this.zaa.zan(this, registrationMethods.register, unregisterListenerMethod, registrationMethods.zab);
    }

    public GoogleApi(Context context, Api<O> api, O o2, Settings settings) {
        this(context, null, api, o2, settings);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public GoogleApi(android.content.Context r2, com.google.android.gms.common.api.Api<O> r3, O r4, com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setMapper(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }
}
