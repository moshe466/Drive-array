package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ConfigAutoFetch {
    private static final int MAXIMUM_FETCH_ATTEMPTS = 3;
    private static final String REALTIME_DISABLED_KEY = "featureDisabled";
    private static final String TEMPLATE_VERSION_KEY = "latestTemplateVersionNumber";
    private final ConfigCacheClient activatedCache;
    private final ConfigFetchHandler configFetchHandler;
    private final Set<ConfigUpdateListener> eventListeners;
    private final HttpURLConnection httpURLConnection;
    private final ConfigUpdateListener retryCallback;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Random random = new Random();
    private boolean isInBackground = false;

    public ConfigAutoFetch(HttpURLConnection httpURLConnection, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Set<ConfigUpdateListener> set, ConfigUpdateListener configUpdateListener, ScheduledExecutorService scheduledExecutorService) {
        this.httpURLConnection = httpURLConnection;
        this.configFetchHandler = configFetchHandler;
        this.activatedCache = configCacheClient;
        this.eventListeners = set;
        this.retryCallback = configUpdateListener;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    private void autoFetch(final int i, final long j2) {
        if (i == 0) {
            propagateErrors(new FirebaseRemoteConfigServerException("Unable to fetch the latest version of the template.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_NOT_FETCHED));
        } else {
            this.scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.1
                @Override // java.lang.Runnable
                public void run() {
                    ConfigAutoFetch.this.fetchLatestConfig(i, j2);
                }
            }, this.random.nextInt(4), TimeUnit.SECONDS);
        }
    }

    private synchronized void executeAllListenerCallbacks(ConfigUpdate configUpdate) {
        Iterator<ConfigUpdateListener> it = this.eventListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpdate(configUpdate);
        }
    }

    private static Boolean fetchResponseIsUpToDate(ConfigFetchHandler.FetchResponse fetchResponse, long j2) {
        boolean z3 = false;
        if (fetchResponse.getFetchedConfigs() != null) {
            if (fetchResponse.getFetchedConfigs().getTemplateVersionNumber() >= j2) {
                z3 = true;
            }
            return Boolean.valueOf(z3);
        }
        if (fetchResponse.getStatus() == 1) {
            z3 = true;
        }
        return Boolean.valueOf(z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r4 = new org.json.JSONObject(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        if (r4.has(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.REALTIME_DISABLED_KEY) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (r4.getBoolean(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.REALTIME_DISABLED_KEY) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        r8.retryCallback.onError(new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException("The server is temporarily unavailable. Try again in a few minutes.", com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (isEventListenersEmpty() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        if (r4.has(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.TEMPLATE_VERSION_KEY) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r5 = r8.configFetchHandler.getTemplateVersionNumber();
        r3 = r4.getLong(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.TEMPLATE_VERSION_KEY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
    
        if (r3 <= r5) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
    
        autoFetch(3, r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleNotifications(java.io.InputStream r9) {
        /*
            r8 = this;
            java.lang.String r0 = "latestTemplateVersionNumber"
            java.lang.String r1 = "featureDisabled"
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            java.lang.String r4 = "utf-8"
            r3.<init>(r9, r4)
            r2.<init>(r3)
            java.lang.String r9 = ""
        L12:
            r3 = r9
        L13:
            java.lang.String r4 = r2.readLine()
            if (r4 == 0) goto L8a
            java.lang.String r3 = F0.AbstractC0008a.n(r3, r4)
            java.lang.String r5 = "}"
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L13
            java.lang.String r3 = r8.parseAndValidateConfigUpdateMessage(r3)
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L30
            goto L13
        L30:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L50
            r4.<init>(r3)     // Catch: org.json.JSONException -> L50
            boolean r3 = r4.has(r1)     // Catch: org.json.JSONException -> L50
            if (r3 == 0) goto L52
            boolean r3 = r4.getBoolean(r1)     // Catch: org.json.JSONException -> L50
            if (r3 == 0) goto L52
            com.google.firebase.remoteconfig.ConfigUpdateListener r3 = r8.retryCallback     // Catch: org.json.JSONException -> L50
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r4 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException     // Catch: org.json.JSONException -> L50
            java.lang.String r5 = "The server is temporarily unavailable. Try again in a few minutes."
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r6 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE     // Catch: org.json.JSONException -> L50
            r4.<init>(r5, r6)     // Catch: org.json.JSONException -> L50
            r3.onError(r4)     // Catch: org.json.JSONException -> L50
            goto L8a
        L50:
            r3 = move-exception
            goto L72
        L52:
            boolean r3 = r8.isEventListenersEmpty()     // Catch: org.json.JSONException -> L50
            if (r3 == 0) goto L59
            goto L8a
        L59:
            boolean r3 = r4.has(r0)     // Catch: org.json.JSONException -> L50
            if (r3 == 0) goto L12
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler r3 = r8.configFetchHandler     // Catch: org.json.JSONException -> L50
            long r5 = r3.getTemplateVersionNumber()     // Catch: org.json.JSONException -> L50
            long r3 = r4.getLong(r0)     // Catch: org.json.JSONException -> L50
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 <= 0) goto L12
            r5 = 3
            r8.autoFetch(r5, r3)     // Catch: org.json.JSONException -> L50
            goto L12
        L72:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r4 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException
            java.lang.Throwable r5 = r3.getCause()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r6 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_MESSAGE_INVALID
            java.lang.String r7 = "Unable to parse config update message."
            r4.<init>(r7, r5, r6)
            r8.propagateErrors(r4)
            java.lang.String r4 = "FirebaseRemoteConfig"
            java.lang.String r5 = "Unable to parse latest config update message."
            android.util.Log.e(r4, r5, r3)
            goto L12
        L8a:
            r2.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.handleNotifications(java.io.InputStream):void");
    }

    private synchronized boolean isEventListenersEmpty() {
        return this.eventListeners.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchLatestConfig$0(Task task, Task task2, long j2, int i, Task task3) {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to auto-fetch config update.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to get activated config for auto-fetch", task2.getException()));
        }
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) task.getResult();
        ConfigContainer configContainer = (ConfigContainer) task2.getResult();
        if (!fetchResponseIsUpToDate(fetchResponse, j2).booleanValue()) {
            autoFetch(i, j2);
            return Tasks.forResult(null);
        }
        if (fetchResponse.getFetchedConfigs() == null) {
            return Tasks.forResult(null);
        }
        if (configContainer == null) {
            configContainer = ConfigContainer.newBuilder().build();
        }
        Set<String> changedParams = configContainer.getChangedParams(fetchResponse.getFetchedConfigs());
        if (changedParams.isEmpty()) {
            return Tasks.forResult(null);
        }
        executeAllListenerCallbacks(ConfigUpdate.create(changedParams));
        return Tasks.forResult(null);
    }

    private String parseAndValidateConfigUpdateMessage(String str) {
        int indexOf = str.indexOf(123);
        int lastIndexOf = str.lastIndexOf(125);
        if (indexOf < 0 || lastIndexOf < 0 || indexOf >= lastIndexOf) {
            return "";
        }
        return str.substring(indexOf, lastIndexOf + 1);
    }

    private synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        Iterator<ConfigUpdateListener> it = this.eventListeners.iterator();
        while (it.hasNext()) {
            it.next().onError(firebaseRemoteConfigException);
        }
    }

    public synchronized Task<Void> fetchLatestConfig(int i, final long j2) {
        final int i3 = i - 1;
        try {
            try {
                final Task<ConfigFetchHandler.FetchResponse> fetchNowWithTypeAndAttemptNumber = this.configFetchHandler.fetchNowWithTypeAndAttemptNumber(ConfigFetchHandler.FetchType.REALTIME, 3 - i3);
                final Task<ConfigContainer> task = this.activatedCache.get();
                return Tasks.whenAllComplete((Task<?>[]) new Task[]{fetchNowWithTypeAndAttemptNumber, task}).continueWithTask(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.a
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task2) {
                        Task lambda$fetchLatestConfig$0;
                        lambda$fetchLatestConfig$0 = ConfigAutoFetch.this.lambda$fetchLatestConfig$0(fetchNowWithTypeAndAttemptNumber, task, j2, i3, task2);
                        return lambda$fetchLatestConfig$0;
                    }
                });
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public void listenForNotifications() {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection != null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    handleNotifications(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException unused) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            }
        }
    }

    public void setIsInBackground(boolean z3) {
        this.isInBackground = z3;
    }
}
