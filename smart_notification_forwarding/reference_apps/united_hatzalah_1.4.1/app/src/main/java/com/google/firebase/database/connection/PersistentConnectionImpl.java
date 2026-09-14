package com.google.firebase.database.connection;

import A1.g;
import F0.AbstractC0008a;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.connection.Connection;
import com.google.firebase.database.connection.ConnectionTokenProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.util.GAuthToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class PersistentConnectionImpl implements Connection.Delegate, PersistentConnection {
    private static final String IDLE_INTERRUPT_REASON = "connection_idle";
    private static final long IDLE_TIMEOUT = 60000;
    private static final String INVALID_APP_CHECK_TOKEN = "Invalid appcheck token";
    private static final long INVALID_TOKEN_THRESHOLD = 3;
    private static final String REQUEST_ACTION = "a";
    private static final String REQUEST_ACTION_APPCHECK = "appcheck";
    private static final String REQUEST_ACTION_AUTH = "auth";
    private static final String REQUEST_ACTION_GAUTH = "gauth";
    private static final String REQUEST_ACTION_GET = "g";
    private static final String REQUEST_ACTION_MERGE = "m";
    private static final String REQUEST_ACTION_ONDISCONNECT_CANCEL = "oc";
    private static final String REQUEST_ACTION_ONDISCONNECT_MERGE = "om";
    private static final String REQUEST_ACTION_ONDISCONNECT_PUT = "o";
    private static final String REQUEST_ACTION_PUT = "p";
    private static final String REQUEST_ACTION_QUERY = "q";
    private static final String REQUEST_ACTION_QUERY_UNLISTEN = "n";
    private static final String REQUEST_ACTION_STATS = "s";
    private static final String REQUEST_ACTION_UNAPPCHECK = "unappcheck";
    private static final String REQUEST_ACTION_UNAUTH = "unauth";
    private static final String REQUEST_APPCHECK_TOKEN = "token";
    private static final String REQUEST_AUTHVAR = "authvar";
    private static final String REQUEST_COMPOUND_HASH = "ch";
    private static final String REQUEST_COMPOUND_HASH_HASHES = "hs";
    private static final String REQUEST_COMPOUND_HASH_PATHS = "ps";
    private static final String REQUEST_COUNTERS = "c";
    private static final String REQUEST_CREDENTIAL = "cred";
    private static final String REQUEST_DATA_HASH = "h";
    private static final String REQUEST_DATA_PAYLOAD = "d";
    private static final String REQUEST_ERROR = "error";
    private static final String REQUEST_NUMBER = "r";
    private static final String REQUEST_PATH = "p";
    private static final String REQUEST_PAYLOAD = "b";
    private static final String REQUEST_QUERIES = "q";
    private static final String REQUEST_STATUS = "s";
    private static final String REQUEST_TAG = "t";
    private static final String RESPONSE_FOR_REQUEST = "b";
    private static final String SERVER_ASYNC_ACTION = "a";
    private static final String SERVER_ASYNC_APP_CHECK_REVOKED = "apc";
    private static final String SERVER_ASYNC_AUTH_REVOKED = "ac";
    private static final String SERVER_ASYNC_DATA_MERGE = "m";
    private static final String SERVER_ASYNC_DATA_RANGE_MERGE = "rm";
    private static final String SERVER_ASYNC_DATA_UPDATE = "d";
    private static final String SERVER_ASYNC_LISTEN_CANCELLED = "c";
    private static final String SERVER_ASYNC_PAYLOAD = "b";
    private static final String SERVER_ASYNC_SECURITY_DEBUG = "sd";
    private static final String SERVER_DATA_END_PATH = "e";
    private static final String SERVER_DATA_RANGE_MERGE = "m";
    private static final String SERVER_DATA_START_PATH = "s";
    private static final String SERVER_DATA_TAG = "t";
    private static final String SERVER_DATA_UPDATE_BODY = "d";
    private static final String SERVER_DATA_UPDATE_PATH = "p";
    private static final String SERVER_DATA_WARNINGS = "w";
    private static final String SERVER_KILL_INTERRUPT_REASON = "server_kill";
    private static final String SERVER_RESPONSE_DATA = "d";
    private static final long SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY = 30000;
    private static final String TOKEN_REFRESH_INTERRUPT_REASON = "token_refresh";
    private static long connectionIds;
    private String appCheckToken;
    private final ConnectionTokenProvider appCheckTokenProvider;
    private String authToken;
    private final ConnectionTokenProvider authTokenProvider;
    private String cachedHost;
    private final ConnectionContext context;
    private final PersistentConnection.Delegate delegate;
    private final ScheduledExecutorService executorService;
    private boolean forceAppCheckTokenRefresh;
    private boolean forceAuthTokenRefresh;
    private boolean hasOnDisconnects;
    private final HostInfo hostInfo;
    private long lastConnectionEstablishedTime;
    private String lastSessionId;
    private long lastWriteTimestamp;
    private Map<QuerySpec, OutstandingListen> listens;
    private final LogWrapper logger;
    private List<OutstandingDisconnect> onDisconnectRequestQueue;
    private Map<Long, OutstandingGet> outstandingGets;
    private Map<Long, OutstandingPut> outstandingPuts;
    private Connection realtime;
    private Map<Long, ConnectionRequestCallback> requestCBHash;
    private final RetryHelper retryHelper;
    private HashSet<String> interruptReasons = new HashSet<>();
    private boolean firstConnection = true;
    private ConnectionState connectionState = ConnectionState.Disconnected;
    private long writeCounter = 0;
    private long readCounter = 0;
    private long requestCounter = 0;
    private long currentGetTokenAttempt = 0;
    private int invalidAuthTokenCount = 0;
    private int invalidAppCheckTokenCount = 0;
    private ScheduledFuture<?> inactivityTimer = null;

    /* renamed from: com.google.firebase.database.connection.PersistentConnectionImpl$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ConnectionTokenProvider.GetTokenCallback {
        final /* synthetic */ TaskCompletionSource val$taskCompletionSource;

        public AnonymousClass1(TaskCompletionSource taskCompletionSource) {
            r2 = taskCompletionSource;
        }

        @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
        public void onError(String str) {
            r2.setException(new Exception(str));
        }

        @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
        public void onSuccess(String str) {
            r2.setResult(str);
        }
    }

    /* renamed from: com.google.firebase.database.connection.PersistentConnectionImpl$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements ConnectionTokenProvider.GetTokenCallback {
        final /* synthetic */ TaskCompletionSource val$taskCompletionSource;

        public AnonymousClass2(TaskCompletionSource taskCompletionSource) {
            r2 = taskCompletionSource;
        }

        @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
        public void onError(String str) {
            r2.setException(new Exception(str));
        }

        @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
        public void onSuccess(String str) {
            r2.setResult(str);
        }
    }

    /* renamed from: com.google.firebase.database.connection.PersistentConnectionImpl$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements ConnectionRequestCallback {
        final /* synthetic */ RequestResultCallback val$onComplete;

        public AnonymousClass3(RequestResultCallback requestResultCallback) {
            r2 = requestResultCallback;
        }

        @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
        public void onResponse(Map<String, Object> map) {
            String str;
            String str2 = (String) map.get("s");
            if (!str2.equals("ok")) {
                str = (String) map.get("d");
            } else {
                str2 = null;
                str = null;
            }
            RequestResultCallback requestResultCallback = r2;
            if (requestResultCallback != null) {
                requestResultCallback.onRequestResult(str2, str);
            }
        }
    }

    /* renamed from: com.google.firebase.database.connection.PersistentConnectionImpl$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 implements ConnectionRequestCallback {
        final /* synthetic */ boolean val$restoreStateAfterComplete;

        public AnonymousClass4(boolean z3) {
            r2 = z3;
        }

        @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
        public void onResponse(Map<String, Object> map) {
            String str = (String) map.get("s");
            if (!str.equals("ok")) {
                PersistentConnectionImpl.this.authToken = null;
                PersistentConnectionImpl.this.forceAuthTokenRefresh = true;
                PersistentConnectionImpl.this.delegate.onConnectionStatus(false);
                PersistentConnectionImpl.this.logger.debug(AbstractC0008a.p("Authentication failed: ", str, " (", (String) map.get("d"), ")"), new Object[0]);
                PersistentConnectionImpl.this.realtime.close();
                if (str.equals("invalid_token")) {
                    PersistentConnectionImpl.access$1008(PersistentConnectionImpl.this);
                    if (PersistentConnectionImpl.this.invalidAuthTokenCount >= PersistentConnectionImpl.INVALID_TOKEN_THRESHOLD) {
                        PersistentConnectionImpl.this.retryHelper.setMaxDelay();
                        PersistentConnectionImpl.this.logger.warn("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                        return;
                    }
                    return;
                }
                return;
            }
            PersistentConnectionImpl.this.connectionState = ConnectionState.Connected;
            PersistentConnectionImpl.this.invalidAuthTokenCount = 0;
            PersistentConnectionImpl.this.sendAppCheckTokenHelper(r2);
        }
    }

    /* renamed from: com.google.firebase.database.connection.PersistentConnectionImpl$5 */
    /* loaded from: classes.dex */
    public class AnonymousClass5 implements ConnectionRequestCallback {
        final /* synthetic */ String val$action;
        final /* synthetic */ RequestResultCallback val$onComplete;
        final /* synthetic */ OutstandingPut val$put;
        final /* synthetic */ long val$putId;

        public AnonymousClass5(String str, long j2, OutstandingPut outstandingPut, RequestResultCallback requestResultCallback) {
            r2 = str;
            r3 = j2;
            r5 = outstandingPut;
            r6 = requestResultCallback;
        }

        @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
        public void onResponse(Map<String, Object> map) {
            if (PersistentConnectionImpl.this.logger.logsDebug()) {
                PersistentConnectionImpl.this.logger.debug(r2 + " response: " + map, new Object[0]);
            }
            if (((OutstandingPut) PersistentConnectionImpl.this.outstandingPuts.get(Long.valueOf(r3))) == r5) {
                PersistentConnectionImpl.this.outstandingPuts.remove(Long.valueOf(r3));
                if (r6 != null) {
                    String str = (String) map.get("s");
                    if (str.equals("ok")) {
                        r6.onRequestResult(null, null);
                    } else {
                        r6.onRequestResult(str, (String) map.get("d"));
                    }
                }
            } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                PersistentConnectionImpl.this.logger.debug(e0.a.g(new StringBuilder("Ignoring on complete for put "), r3, " because it was removed already."), new Object[0]);
            }
            PersistentConnectionImpl.this.doIdleCheck();
        }
    }

    /* renamed from: com.google.firebase.database.connection.PersistentConnectionImpl$6 */
    /* loaded from: classes.dex */
    public class AnonymousClass6 implements ConnectionRequestCallback {
        final /* synthetic */ OutstandingGet val$get;
        final /* synthetic */ Long val$readId;

        public AnonymousClass6(Long l3, OutstandingGet outstandingGet) {
            r2 = l3;
            r3 = outstandingGet;
        }

        @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
        public void onResponse(Map<String, Object> map) {
            if (((OutstandingGet) PersistentConnectionImpl.this.outstandingGets.get(r2)) == r3) {
                PersistentConnectionImpl.this.outstandingGets.remove(r2);
                r3.getOnComplete().onResponse(map);
            } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                PersistentConnectionImpl.this.logger.debug("Ignoring on complete for get " + r2 + " because it was removed already.", new Object[0]);
            }
        }
    }

    /* renamed from: com.google.firebase.database.connection.PersistentConnectionImpl$7 */
    /* loaded from: classes.dex */
    public class AnonymousClass7 implements ConnectionRequestCallback {
        final /* synthetic */ OutstandingListen val$listen;

        public AnonymousClass7(OutstandingListen outstandingListen) {
            r2 = outstandingListen;
        }

        @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
        public void onResponse(Map<String, Object> map) {
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                Map map2 = (Map) map.get("d");
                if (map2.containsKey("w")) {
                    PersistentConnectionImpl.this.warnOnListenerWarnings((List) map2.get("w"), r2.query);
                }
            }
            if (((OutstandingListen) PersistentConnectionImpl.this.listens.get(r2.getQuery())) == r2) {
                if (!str.equals("ok")) {
                    PersistentConnectionImpl.this.removeListen(r2.getQuery());
                    r2.resultCallback.onRequestResult(str, (String) map.get("d"));
                    return;
                }
                r2.resultCallback.onRequestResult(null, null);
            }
        }
    }

    /* renamed from: com.google.firebase.database.connection.PersistentConnectionImpl$8 */
    /* loaded from: classes.dex */
    public class AnonymousClass8 implements ConnectionRequestCallback {
        public AnonymousClass8() {
        }

        @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
        public void onResponse(Map<String, Object> map) {
            String str = (String) map.get("s");
            if (!str.equals("ok")) {
                String str2 = (String) map.get("d");
                if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    PersistentConnectionImpl.this.logger.debug(AbstractC0008a.p("Failed to send stats: ", str, " (message: ", str2, ")"), new Object[0]);
                }
            }
        }
    }

    /* renamed from: com.google.firebase.database.connection.PersistentConnectionImpl$9 */
    /* loaded from: classes.dex */
    public class AnonymousClass9 implements Runnable {
        public AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersistentConnectionImpl.this.inactivityTimer = null;
            if (!PersistentConnectionImpl.this.idleHasTimedOut()) {
                PersistentConnectionImpl.this.doIdleCheck();
            } else {
                PersistentConnectionImpl.this.interrupt(PersistentConnectionImpl.IDLE_INTERRUPT_REASON);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ConnectionRequestCallback {
        void onResponse(Map<String, Object> map);
    }

    /* loaded from: classes.dex */
    public enum ConnectionState {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    /* loaded from: classes.dex */
    public static class OutstandingDisconnect {
        private final String action;
        private final Object data;
        private final RequestResultCallback onComplete;
        private final List<String> path;

        public /* synthetic */ OutstandingDisconnect(String str, List list, Object obj, RequestResultCallback requestResultCallback, AnonymousClass1 anonymousClass1) {
            this(str, list, obj, requestResultCallback);
        }

        public String getAction() {
            return this.action;
        }

        public Object getData() {
            return this.data;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public List<String> getPath() {
            return this.path;
        }

        private OutstandingDisconnect(String str, List<String> list, Object obj, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.path = list;
            this.data = obj;
            this.onComplete = requestResultCallback;
        }
    }

    /* loaded from: classes.dex */
    public static class OutstandingGet {
        private final ConnectionRequestCallback onComplete;
        private final Map<String, Object> request;
        private boolean sent;

        public /* synthetic */ OutstandingGet(String str, Map map, ConnectionRequestCallback connectionRequestCallback, AnonymousClass1 anonymousClass1) {
            this(str, map, connectionRequestCallback);
        }

        public ConnectionRequestCallback getOnComplete() {
            return this.onComplete;
        }

        public Map<String, Object> getRequest() {
            return this.request;
        }

        public boolean markSent() {
            if (this.sent) {
                return false;
            }
            this.sent = true;
            return true;
        }

        private OutstandingGet(String str, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
            this.request = map;
            this.onComplete = connectionRequestCallback;
            this.sent = false;
        }
    }

    /* loaded from: classes.dex */
    public static class OutstandingListen {
        private final ListenHashProvider hashFunction;
        private final QuerySpec query;
        private final RequestResultCallback resultCallback;
        private final Long tag;

        public /* synthetic */ OutstandingListen(RequestResultCallback requestResultCallback, QuerySpec querySpec, Long l3, ListenHashProvider listenHashProvider, AnonymousClass1 anonymousClass1) {
            this(requestResultCallback, querySpec, l3, listenHashProvider);
        }

        public ListenHashProvider getHashFunction() {
            return this.hashFunction;
        }

        public QuerySpec getQuery() {
            return this.query;
        }

        public Long getTag() {
            return this.tag;
        }

        public String toString() {
            return this.query.toString() + " (Tag: " + this.tag + ")";
        }

        private OutstandingListen(RequestResultCallback requestResultCallback, QuerySpec querySpec, Long l3, ListenHashProvider listenHashProvider) {
            this.resultCallback = requestResultCallback;
            this.query = querySpec;
            this.hashFunction = listenHashProvider;
            this.tag = l3;
        }
    }

    /* loaded from: classes.dex */
    public static class OutstandingPut {
        private String action;
        private RequestResultCallback onComplete;
        private Map<String, Object> request;
        private boolean sent;

        public /* synthetic */ OutstandingPut(String str, Map map, RequestResultCallback requestResultCallback, AnonymousClass1 anonymousClass1) {
            this(str, map, requestResultCallback);
        }

        public String getAction() {
            return this.action;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public Map<String, Object> getRequest() {
            return this.request;
        }

        public void markSent() {
            this.sent = true;
        }

        public boolean wasSent() {
            return this.sent;
        }

        private OutstandingPut(String str, Map<String, Object> map, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.request = map;
            this.onComplete = requestResultCallback;
        }
    }

    /* loaded from: classes.dex */
    public static class QuerySpec {
        private final List<String> path;
        private final Map<String, Object> queryParams;

        public QuerySpec(List<String> list, Map<String, Object> map) {
            this.path = list;
            this.queryParams = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuerySpec)) {
                return false;
            }
            QuerySpec querySpec = (QuerySpec) obj;
            if (!this.path.equals(querySpec.path)) {
                return false;
            }
            return this.queryParams.equals(querySpec.queryParams);
        }

        public int hashCode() {
            return this.queryParams.hashCode() + (this.path.hashCode() * 31);
        }

        public String toString() {
            return ConnectionUtils.pathToString(this.path) + " (params: " + this.queryParams + ")";
        }
    }

    public PersistentConnectionImpl(ConnectionContext connectionContext, HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        this.delegate = delegate;
        this.context = connectionContext;
        ScheduledExecutorService executorService = connectionContext.getExecutorService();
        this.executorService = executorService;
        this.authTokenProvider = connectionContext.getAuthTokenProvider();
        this.appCheckTokenProvider = connectionContext.getAppCheckTokenProvider();
        this.hostInfo = hostInfo;
        this.listens = new HashMap();
        this.requestCBHash = new HashMap();
        this.outstandingPuts = new HashMap();
        this.outstandingGets = new ConcurrentHashMap();
        this.onDisconnectRequestQueue = new ArrayList();
        this.retryHelper = new RetryHelper.Builder(executorService, connectionContext.getLogger(), "ConnectionRetryHelper").withMinDelayAfterFailure(1000L).withRetryExponent(1.3d).withMaxDelay(SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY).withJitterFactor(0.7d).build();
        long j2 = connectionIds;
        connectionIds = 1 + j2;
        this.logger = new LogWrapper(connectionContext.getLogger(), "PersistentConnection", AbstractC0008a.l("pc_", j2));
        this.lastSessionId = null;
        doIdleCheck();
    }

    public static /* synthetic */ int access$1008(PersistentConnectionImpl persistentConnectionImpl) {
        int i = persistentConnectionImpl.invalidAuthTokenCount;
        persistentConnectionImpl.invalidAuthTokenCount = i + 1;
        return i;
    }

    private boolean canSendReads() {
        if (this.connectionState == ConnectionState.Connected) {
            return true;
        }
        return false;
    }

    private boolean canSendWrites() {
        if (this.connectionState == ConnectionState.Connected) {
            return true;
        }
        return false;
    }

    private void cancelSentTransactions() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, OutstandingPut>> it = this.outstandingPuts.entrySet().iterator();
        while (it.hasNext()) {
            OutstandingPut value = it.next().getValue();
            if (value.getRequest().containsKey(REQUEST_DATA_HASH) && value.wasSent()) {
                arrayList.add(value);
                it.remove();
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((OutstandingPut) obj).getOnComplete().onRequestResult("disconnected", null);
        }
    }

    private boolean connected() {
        ConnectionState connectionState = this.connectionState;
        if (connectionState != ConnectionState.Authenticating && connectionState != ConnectionState.Connected) {
            return false;
        }
        return true;
    }

    public void doIdleCheck() {
        if (isIdle()) {
            ScheduledFuture<?> scheduledFuture = this.inactivityTimer;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.inactivityTimer = this.executorService.schedule(new Runnable() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.9
                public AnonymousClass9() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PersistentConnectionImpl.this.inactivityTimer = null;
                    if (!PersistentConnectionImpl.this.idleHasTimedOut()) {
                        PersistentConnectionImpl.this.doIdleCheck();
                    } else {
                        PersistentConnectionImpl.this.interrupt(PersistentConnectionImpl.IDLE_INTERRUPT_REASON);
                    }
                }
            }, 60000L, TimeUnit.MILLISECONDS);
            return;
        }
        if (isInterrupted(IDLE_INTERRUPT_REASON)) {
            ConnectionUtils.hardAssert(!isIdle());
            resume(IDLE_INTERRUPT_REASON);
        }
    }

    private Task<String> fetchAppCheckToken(boolean z3) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.logger.debug("Trying to fetch app check token", new Object[0]);
        this.appCheckTokenProvider.getToken(z3, new ConnectionTokenProvider.GetTokenCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.2
            final /* synthetic */ TaskCompletionSource val$taskCompletionSource;

            public AnonymousClass2(TaskCompletionSource taskCompletionSource2) {
                r2 = taskCompletionSource2;
            }

            @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
            public void onError(String str) {
                r2.setException(new Exception(str));
            }

            @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
            public void onSuccess(String str) {
                r2.setResult(str);
            }
        });
        return taskCompletionSource2.getTask();
    }

    private Task<String> fetchAuthToken(boolean z3) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.logger.debug("Trying to fetch auth token", new Object[0]);
        this.authTokenProvider.getToken(z3, new ConnectionTokenProvider.GetTokenCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.1
            final /* synthetic */ TaskCompletionSource val$taskCompletionSource;

            public AnonymousClass1(TaskCompletionSource taskCompletionSource2) {
                r2 = taskCompletionSource2;
            }

            @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
            public void onError(String str) {
                r2.setException(new Exception(str));
            }

            @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
            public void onSuccess(String str) {
                r2.setResult(str);
            }
        });
        return taskCompletionSource2.getTask();
    }

    private Map<String, Object> getPutObject(List<String> list, Object obj, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(list));
        hashMap.put("d", obj);
        if (str != null) {
            hashMap.put(REQUEST_DATA_HASH, str);
        }
        return hashMap;
    }

    private void handleTimestamp(long j2) {
        if (this.logger.logsDebug()) {
            this.logger.debug("handling timestamp", new Object[0]);
        }
        long currentTimeMillis = j2 - System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.DOT_INFO_SERVERTIME_OFFSET, Long.valueOf(currentTimeMillis));
        this.delegate.onServerInfoUpdate(hashMap);
    }

    public boolean idleHasTimedOut() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isIdle() && currentTimeMillis > this.lastWriteTimestamp + 60000) {
            return true;
        }
        return false;
    }

    private boolean isIdle() {
        if (this.listens.isEmpty() && this.outstandingGets.isEmpty() && this.requestCBHash.isEmpty() && !this.hasOnDisconnects && this.outstandingPuts.isEmpty()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void lambda$get$0(TaskCompletionSource taskCompletionSource, Map map) {
        if (((String) map.get("s")).equals("ok")) {
            taskCompletionSource.setResult(map.get("d"));
        } else {
            taskCompletionSource.setException(new Exception((String) map.get("d")));
        }
    }

    public /* synthetic */ void lambda$sendAppCheckTokenHelper$4(boolean z3, Map map) {
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            this.invalidAppCheckTokenCount = 0;
        } else {
            this.appCheckToken = null;
            this.forceAppCheckTokenRefresh = true;
            this.logger.debug(AbstractC0008a.p("App check failed: ", str, " (", (String) map.get("d"), ")"), new Object[0]);
        }
        if (z3) {
            restoreState();
        }
    }

    public /* synthetic */ void lambda$tryScheduleReconnect$1(long j2, Task task, Task task2, Void r7) {
        if (j2 == this.currentGetTokenAttempt) {
            ConnectionState connectionState = this.connectionState;
            if (connectionState == ConnectionState.GettingToken) {
                this.logger.debug("Successfully fetched token, opening connection", new Object[0]);
                openNetworkConnection((String) task.getResult(), (String) task2.getResult());
                return;
            } else {
                if (connectionState == ConnectionState.Disconnected) {
                    this.logger.debug("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
                    return;
                }
                return;
            }
        }
        this.logger.debug("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
    }

    public /* synthetic */ void lambda$tryScheduleReconnect$2(long j2, Exception exc) {
        if (j2 == this.currentGetTokenAttempt) {
            this.connectionState = ConnectionState.Disconnected;
            this.logger.debug("Error fetching token: " + exc, new Object[0]);
            tryScheduleReconnect();
            return;
        }
        this.logger.debug("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
    }

    public /* synthetic */ void lambda$tryScheduleReconnect$3(boolean z3, boolean z4) {
        boolean z5;
        ConnectionState connectionState = this.connectionState;
        if (connectionState == ConnectionState.Disconnected) {
            z5 = true;
        } else {
            z5 = false;
        }
        ConnectionUtils.hardAssert(z5, "Not in disconnected state: %s", connectionState);
        this.connectionState = ConnectionState.GettingToken;
        long j2 = this.currentGetTokenAttempt + 1;
        this.currentGetTokenAttempt = j2;
        Task<String> fetchAuthToken = fetchAuthToken(z3);
        Task<String> fetchAppCheckToken = fetchAppCheckToken(z4);
        Tasks.whenAll((Task<?>[]) new Task[]{fetchAuthToken, fetchAppCheckToken}).addOnSuccessListener(this.executorService, new com.google.firebase.crashlytics.internal.a(this, j2, fetchAuthToken, fetchAppCheckToken)).addOnFailureListener(this.executorService, new g(this, j2));
    }

    private long nextRequestNumber() {
        long j2 = this.requestCounter;
        this.requestCounter = 1 + j2;
        return j2;
    }

    private void onAppCheckRevoked(String str, String str2) {
        this.logger.debug(AbstractC0008a.p("App check token revoked: ", str, " (", str2, ")"), new Object[0]);
        this.appCheckToken = null;
        this.forceAppCheckTokenRefresh = true;
    }

    private void onAuthRevoked(String str, String str2) {
        this.logger.debug(AbstractC0008a.p("Auth token revoked: ", str, " (", str2, ")"), new Object[0]);
        this.authToken = null;
        this.forceAuthTokenRefresh = true;
        this.delegate.onConnectionStatus(false);
        this.realtime.close();
    }

    private void onDataPush(String str, Map<String, Object> map) {
        List<String> list;
        if (this.logger.logsDebug()) {
            this.logger.debug("handleServerMessage: " + str + StringUtils.SPACE + map, new Object[0]);
        }
        if (!str.equals("d") && !str.equals("m")) {
            if (str.equals(SERVER_ASYNC_DATA_RANGE_MERGE)) {
                String str2 = (String) map.get("p");
                List<String> stringToPath = ConnectionUtils.stringToPath(str2);
                Object obj = map.get("d");
                Long longFromObject = ConnectionUtils.longFromObject(map.get("t"));
                ArrayList arrayList = new ArrayList();
                for (Map map2 : (List) obj) {
                    String str3 = (String) map2.get("s");
                    String str4 = (String) map2.get(SERVER_DATA_END_PATH);
                    List<String> list2 = null;
                    if (str3 != null) {
                        list = ConnectionUtils.stringToPath(str3);
                    } else {
                        list = null;
                    }
                    if (str4 != null) {
                        list2 = ConnectionUtils.stringToPath(str4);
                    }
                    arrayList.add(new RangeMerge(list, list2, map2.get("m")));
                }
                if (arrayList.isEmpty()) {
                    if (this.logger.logsDebug()) {
                        this.logger.debug(e0.a.d("Ignoring empty range merge for path ", str2), new Object[0]);
                        return;
                    }
                    return;
                }
                this.delegate.onRangeMergeUpdate(stringToPath, arrayList, longFromObject);
                return;
            }
            if (str.equals("c")) {
                onListenRevoked(ConnectionUtils.stringToPath((String) map.get("p")));
                return;
            }
            if (str.equals(SERVER_ASYNC_AUTH_REVOKED)) {
                onAuthRevoked((String) map.get("s"), (String) map.get("d"));
                return;
            }
            if (str.equals(SERVER_ASYNC_APP_CHECK_REVOKED)) {
                onAppCheckRevoked((String) map.get("s"), (String) map.get("d"));
                return;
            } else if (str.equals(SERVER_ASYNC_SECURITY_DEBUG)) {
                onSecurityDebugPacket(map);
                return;
            } else {
                if (this.logger.logsDebug()) {
                    this.logger.debug("Unrecognized action from server: ".concat(str), new Object[0]);
                    return;
                }
                return;
            }
        }
        boolean equals = str.equals("m");
        String str5 = (String) map.get("p");
        Object obj2 = map.get("d");
        Long longFromObject2 = ConnectionUtils.longFromObject(map.get("t"));
        if (equals && (obj2 instanceof Map) && ((Map) obj2).size() == 0) {
            if (this.logger.logsDebug()) {
                this.logger.debug(e0.a.d("ignoring empty merge for path ", str5), new Object[0]);
            }
        } else {
            this.delegate.onDataUpdate(ConnectionUtils.stringToPath(str5), obj2, equals, longFromObject2);
        }
    }

    private void onListenRevoked(List<String> list) {
        Collection<OutstandingListen> removeListens = removeListens(list);
        if (removeListens != null) {
            Iterator<OutstandingListen> it = removeListens.iterator();
            while (it.hasNext()) {
                it.next().resultCallback.onRequestResult("permission_denied", null);
            }
        }
    }

    private void onSecurityDebugPacket(Map<String, Object> map) {
        this.logger.info((String) map.get("msg"));
    }

    private void putInternal(String str, List<String> list, Object obj, String str2, RequestResultCallback requestResultCallback) {
        Map<String, Object> putObject = getPutObject(list, obj, str2);
        long j2 = this.writeCounter;
        this.writeCounter = 1 + j2;
        this.outstandingPuts.put(Long.valueOf(j2), new OutstandingPut(str, putObject, requestResultCallback));
        if (canSendWrites()) {
            sendPut(j2);
        }
        this.lastWriteTimestamp = System.currentTimeMillis();
        doIdleCheck();
    }

    public OutstandingListen removeListen(QuerySpec querySpec) {
        if (this.logger.logsDebug()) {
            this.logger.debug("removing query " + querySpec, new Object[0]);
        }
        if (!this.listens.containsKey(querySpec)) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Trying to remove listener for QuerySpec " + querySpec + " but no listener exists.", new Object[0]);
                return null;
            }
            return null;
        }
        OutstandingListen outstandingListen = this.listens.get(querySpec);
        this.listens.remove(querySpec);
        doIdleCheck();
        return outstandingListen;
    }

    private Collection<OutstandingListen> removeListens(List<String> list) {
        int i = 0;
        if (this.logger.logsDebug()) {
            this.logger.debug("removing all listens at path " + list, new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<QuerySpec, OutstandingListen> entry : this.listens.entrySet()) {
            QuerySpec key = entry.getKey();
            OutstandingListen value = entry.getValue();
            if (key.path.equals(list)) {
                arrayList.add(value);
            }
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            this.listens.remove(((OutstandingListen) obj).getQuery());
        }
        doIdleCheck();
        return arrayList;
    }

    private void restoreState() {
        boolean z3;
        ConnectionState connectionState = this.connectionState;
        int i = 0;
        if (connectionState == ConnectionState.Connected) {
            z3 = true;
        } else {
            z3 = false;
        }
        ConnectionUtils.hardAssert(z3, "Should be connected if we're restoring state, but we are: %s", connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring outstanding listens", new Object[0]);
        }
        for (OutstandingListen outstandingListen : this.listens.values()) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Restoring listen " + outstandingListen.getQuery(), new Object[0]);
            }
            sendListen(outstandingListen);
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.outstandingPuts.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            sendPut(((Long) obj).longValue());
        }
        for (OutstandingDisconnect outstandingDisconnect : this.onDisconnectRequestQueue) {
            sendOnDisconnect(outstandingDisconnect.getAction(), outstandingDisconnect.getPath(), outstandingDisconnect.getData(), outstandingDisconnect.getOnComplete());
        }
        this.onDisconnectRequestQueue.clear();
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring reads.", new Object[0]);
        }
        ArrayList arrayList2 = new ArrayList(this.outstandingGets.keySet());
        Collections.sort(arrayList2);
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            sendGet((Long) obj2);
        }
    }

    private void restoreTokens() {
        boolean z3;
        if (this.logger.logsDebug()) {
            this.logger.debug("calling restore tokens", new Object[0]);
        }
        ConnectionState connectionState = this.connectionState;
        if (connectionState == ConnectionState.Connecting) {
            z3 = true;
        } else {
            z3 = false;
        }
        ConnectionUtils.hardAssert(z3, "Wanted to restore tokens, but was in wrong state: %s", connectionState);
        if (this.authToken != null) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Restoring auth.", new Object[0]);
            }
            this.connectionState = ConnectionState.Authenticating;
            sendAuthAndRestoreState();
            return;
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Not restoring auth because auth token is null.", new Object[0]);
        }
        this.connectionState = ConnectionState.Connected;
        sendAppCheckTokenHelper(true);
    }

    private void sendAction(String str, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        sendSensitive(str, false, map, connectionRequestCallback);
    }

    public void sendAppCheckTokenHelper(final boolean z3) {
        boolean z4;
        if (this.appCheckToken == null) {
            restoreState();
            return;
        }
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", this.connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending app check.", new Object[0]);
        }
        ConnectionRequestCallback connectionRequestCallback = new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.a
            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public final void onResponse(Map map) {
                PersistentConnectionImpl.this.lambda$sendAppCheckTokenHelper$4(z3, map);
            }
        };
        HashMap hashMap = new HashMap();
        if (this.appCheckToken != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        ConnectionUtils.hardAssert(z4, "App check token must be set!", new Object[0]);
        hashMap.put(REQUEST_APPCHECK_TOKEN, this.appCheckToken);
        sendSensitive(REQUEST_ACTION_APPCHECK, true, hashMap, connectionRequestCallback);
    }

    private void sendAuthAndRestoreState() {
        sendAuthHelper(true);
    }

    private void sendAuthHelper(boolean z3) {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", this.connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending auth.", new Object[0]);
        }
        ConnectionRequestCallback anonymousClass4 = new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.4
            final /* synthetic */ boolean val$restoreStateAfterComplete;

            public AnonymousClass4(boolean z32) {
                r2 = z32;
            }

            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (!str.equals("ok")) {
                    PersistentConnectionImpl.this.authToken = null;
                    PersistentConnectionImpl.this.forceAuthTokenRefresh = true;
                    PersistentConnectionImpl.this.delegate.onConnectionStatus(false);
                    PersistentConnectionImpl.this.logger.debug(AbstractC0008a.p("Authentication failed: ", str, " (", (String) map.get("d"), ")"), new Object[0]);
                    PersistentConnectionImpl.this.realtime.close();
                    if (str.equals("invalid_token")) {
                        PersistentConnectionImpl.access$1008(PersistentConnectionImpl.this);
                        if (PersistentConnectionImpl.this.invalidAuthTokenCount >= PersistentConnectionImpl.INVALID_TOKEN_THRESHOLD) {
                            PersistentConnectionImpl.this.retryHelper.setMaxDelay();
                            PersistentConnectionImpl.this.logger.warn("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                            return;
                        }
                        return;
                    }
                    return;
                }
                PersistentConnectionImpl.this.connectionState = ConnectionState.Connected;
                PersistentConnectionImpl.this.invalidAuthTokenCount = 0;
                PersistentConnectionImpl.this.sendAppCheckTokenHelper(r2);
            }
        };
        HashMap hashMap = new HashMap();
        GAuthToken tryParseFromString = GAuthToken.tryParseFromString(this.authToken);
        if (tryParseFromString != null) {
            hashMap.put(REQUEST_CREDENTIAL, tryParseFromString.getToken());
            if (tryParseFromString.getAuth() != null) {
                hashMap.put(REQUEST_AUTHVAR, tryParseFromString.getAuth());
            }
            sendSensitive(REQUEST_ACTION_GAUTH, true, hashMap, anonymousClass4);
            return;
        }
        hashMap.put(REQUEST_CREDENTIAL, this.authToken);
        sendSensitive(REQUEST_ACTION_AUTH, true, hashMap, anonymousClass4);
    }

    private void sendConnectStats() {
        HashMap hashMap = new HashMap();
        if (this.context.isPersistenceEnabled()) {
            hashMap.put("persistence.android.enabled", 1);
        }
        hashMap.put("sdk.android." + this.context.getClientSdkVersion().replace('.', '-'), 1);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending first connection stats", new Object[0]);
        }
        sendStats(hashMap);
    }

    private void sendGet(Long l3) {
        ConnectionUtils.hardAssert(canSendReads(), "sendGet called when we can't send gets", new Object[0]);
        OutstandingGet outstandingGet = this.outstandingGets.get(l3);
        if (!outstandingGet.markSent() && this.logger.logsDebug()) {
            this.logger.debug("get" + l3 + " cancelled, ignoring.", new Object[0]);
            return;
        }
        sendAction(REQUEST_ACTION_GET, outstandingGet.getRequest(), new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.6
            final /* synthetic */ OutstandingGet val$get;
            final /* synthetic */ Long val$readId;

            public AnonymousClass6(Long l32, OutstandingGet outstandingGet2) {
                r2 = l32;
                r3 = outstandingGet2;
            }

            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                if (((OutstandingGet) PersistentConnectionImpl.this.outstandingGets.get(r2)) == r3) {
                    PersistentConnectionImpl.this.outstandingGets.remove(r2);
                    r3.getOnComplete().onResponse(map);
                } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    PersistentConnectionImpl.this.logger.debug("Ignoring on complete for get " + r2 + " because it was removed already.", new Object[0]);
                }
            }
        });
    }

    private void sendListen(OutstandingListen outstandingListen) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(outstandingListen.getQuery().path));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            hashMap.put("q", outstandingListen.query.queryParams);
            hashMap.put("t", tag);
        }
        ListenHashProvider hashFunction = outstandingListen.getHashFunction();
        hashMap.put(REQUEST_DATA_HASH, hashFunction.getSimpleHash());
        if (hashFunction.shouldIncludeCompoundHash()) {
            CompoundHash compoundHash = hashFunction.getCompoundHash();
            ArrayList arrayList = new ArrayList();
            Iterator<List<String>> it = compoundHash.getPosts().iterator();
            while (it.hasNext()) {
                arrayList.add(ConnectionUtils.pathToString(it.next()));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(REQUEST_COMPOUND_HASH_HASHES, compoundHash.getHashes());
            hashMap2.put(REQUEST_COMPOUND_HASH_PATHS, arrayList);
            hashMap.put(REQUEST_COMPOUND_HASH, hashMap2);
        }
        sendAction("q", hashMap, new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.7
            final /* synthetic */ OutstandingListen val$listen;

            public AnonymousClass7(OutstandingListen outstandingListen2) {
                r2 = outstandingListen2;
            }

            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    Map map2 = (Map) map.get("d");
                    if (map2.containsKey("w")) {
                        PersistentConnectionImpl.this.warnOnListenerWarnings((List) map2.get("w"), r2.query);
                    }
                }
                if (((OutstandingListen) PersistentConnectionImpl.this.listens.get(r2.getQuery())) == r2) {
                    if (!str.equals("ok")) {
                        PersistentConnectionImpl.this.removeListen(r2.getQuery());
                        r2.resultCallback.onRequestResult(str, (String) map.get("d"));
                        return;
                    }
                    r2.resultCallback.onRequestResult(null, null);
                }
            }
        });
    }

    private void sendOnDisconnect(String str, List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(list));
        hashMap.put("d", obj);
        sendAction(str, hashMap, new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.3
            final /* synthetic */ RequestResultCallback val$onComplete;

            public AnonymousClass3(RequestResultCallback requestResultCallback2) {
                r2 = requestResultCallback2;
            }

            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                String str2;
                String str22 = (String) map.get("s");
                if (!str22.equals("ok")) {
                    str2 = (String) map.get("d");
                } else {
                    str22 = null;
                    str2 = null;
                }
                RequestResultCallback requestResultCallback2 = r2;
                if (requestResultCallback2 != null) {
                    requestResultCallback2.onRequestResult(str22, str2);
                }
            }
        });
    }

    private void sendPut(long j2) {
        ConnectionUtils.hardAssert(canSendWrites(), "sendPut called when we can't send writes (we're disconnected or writes are paused).", new Object[0]);
        OutstandingPut outstandingPut = this.outstandingPuts.get(Long.valueOf(j2));
        RequestResultCallback onComplete = outstandingPut.getOnComplete();
        String action = outstandingPut.getAction();
        outstandingPut.markSent();
        sendAction(action, outstandingPut.getRequest(), new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.5
            final /* synthetic */ String val$action;
            final /* synthetic */ RequestResultCallback val$onComplete;
            final /* synthetic */ OutstandingPut val$put;
            final /* synthetic */ long val$putId;

            public AnonymousClass5(String action2, long j22, OutstandingPut outstandingPut2, RequestResultCallback onComplete2) {
                r2 = action2;
                r3 = j22;
                r5 = outstandingPut2;
                r6 = onComplete2;
            }

            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    PersistentConnectionImpl.this.logger.debug(r2 + " response: " + map, new Object[0]);
                }
                if (((OutstandingPut) PersistentConnectionImpl.this.outstandingPuts.get(Long.valueOf(r3))) == r5) {
                    PersistentConnectionImpl.this.outstandingPuts.remove(Long.valueOf(r3));
                    if (r6 != null) {
                        String str = (String) map.get("s");
                        if (str.equals("ok")) {
                            r6.onRequestResult(null, null);
                        } else {
                            r6.onRequestResult(str, (String) map.get("d"));
                        }
                    }
                } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    PersistentConnectionImpl.this.logger.debug(e0.a.g(new StringBuilder("Ignoring on complete for put "), r3, " because it was removed already."), new Object[0]);
                }
                PersistentConnectionImpl.this.doIdleCheck();
            }
        });
    }

    private void sendSensitive(String str, boolean z3, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        long nextRequestNumber = nextRequestNumber();
        HashMap hashMap = new HashMap();
        hashMap.put(REQUEST_NUMBER, Long.valueOf(nextRequestNumber));
        hashMap.put("a", str);
        hashMap.put("b", map);
        this.realtime.sendRequest(hashMap, z3);
        this.requestCBHash.put(Long.valueOf(nextRequestNumber), connectionRequestCallback);
    }

    private void sendStats(Map<String, Integer> map) {
        if (!map.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("c", map);
            sendAction("s", hashMap, new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.8
                public AnonymousClass8() {
                }

                @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
                public void onResponse(Map<String, Object> map2) {
                    String str = (String) map2.get("s");
                    if (!str.equals("ok")) {
                        String str2 = (String) map2.get("d");
                        if (PersistentConnectionImpl.this.logger.logsDebug()) {
                            PersistentConnectionImpl.this.logger.debug(AbstractC0008a.p("Failed to send stats: ", str, " (message: ", str2, ")"), new Object[0]);
                        }
                    }
                }
            });
        } else if (this.logger.logsDebug()) {
            this.logger.debug("Not sending stats because stats are empty", new Object[0]);
        }
    }

    private void sendUnAppCheck() {
        boolean z3;
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[0]);
        if (this.appCheckToken == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        ConnectionUtils.hardAssert(z3, "App check token must not be set.", new Object[0]);
        sendAction(REQUEST_ACTION_UNAPPCHECK, Collections.EMPTY_MAP, null);
    }

    private void sendUnauth() {
        boolean z3;
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[0]);
        if (this.authToken == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        ConnectionUtils.hardAssert(z3, "Auth token must not be set.", new Object[0]);
        sendAction(REQUEST_ACTION_UNAUTH, Collections.EMPTY_MAP, null);
    }

    private void sendUnlisten(OutstandingListen outstandingListen) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(outstandingListen.query.path));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            hashMap.put("q", outstandingListen.getQuery().queryParams);
            hashMap.put("t", tag);
        }
        sendAction(REQUEST_ACTION_QUERY_UNLISTEN, hashMap, null);
    }

    private void tryScheduleReconnect() {
        boolean z3;
        if (shouldReconnect()) {
            ConnectionState connectionState = this.connectionState;
            if (connectionState == ConnectionState.Disconnected) {
                z3 = true;
            } else {
                z3 = false;
            }
            ConnectionUtils.hardAssert(z3, "Not in disconnected state: %s", connectionState);
            final boolean z4 = this.forceAuthTokenRefresh;
            final boolean z5 = this.forceAppCheckTokenRefresh;
            this.logger.debug("Scheduling connection attempt", new Object[0]);
            this.forceAuthTokenRefresh = false;
            this.forceAppCheckTokenRefresh = false;
            this.retryHelper.retry(new Runnable() { // from class: com.google.firebase.database.connection.c
                @Override // java.lang.Runnable
                public final void run() {
                    PersistentConnectionImpl.this.lambda$tryScheduleReconnect$3(z4, z5);
                }
            });
        }
    }

    private void upgradeAppCheck() {
        sendAppCheckTokenHelper(false);
    }

    private void upgradeAuth() {
        sendAuthHelper(false);
    }

    public void warnOnListenerWarnings(List<String> list, QuerySpec querySpec) {
        if (list.contains("no_index")) {
            String str = "\".indexOn\": \"" + querySpec.queryParams.get("i") + '\"';
            this.logger.warn("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '" + str + "' at " + ConnectionUtils.pathToString(querySpec.path) + " to your security and Firebase Database rules for better performance");
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void compareAndPut(List<String> list, Object obj, String str, RequestResultCallback requestResultCallback) {
        putInternal("p", list, obj, str, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public Task<Object> get(List<String> list, Map<String, Object> map) {
        QuerySpec querySpec = new QuerySpec(list, map);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        long j2 = this.readCounter;
        this.readCounter = 1 + j2;
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(querySpec.path));
        hashMap.put("q", querySpec.queryParams);
        this.outstandingGets.put(Long.valueOf(j2), new OutstandingGet(REQUEST_ACTION_GET, hashMap, new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.b
            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public final void onResponse(Map map2) {
                PersistentConnectionImpl.lambda$get$0(TaskCompletionSource.this, map2);
            }
        }));
        if (canSendReads()) {
            sendGet(Long.valueOf(j2));
        }
        doIdleCheck();
        return taskCompletionSource.getTask();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void initialize() {
        tryScheduleReconnect();
    }

    public void injectConnectionFailure() {
        Connection connection = this.realtime;
        if (connection != null) {
            connection.injectConnectionFailure();
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void interrupt(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug(e0.a.d("Connection interrupted for: ", str), new Object[0]);
        }
        this.interruptReasons.add(str);
        Connection connection = this.realtime;
        if (connection != null) {
            connection.close();
            this.realtime = null;
        } else {
            this.retryHelper.cancel();
            this.connectionState = ConnectionState.Disconnected;
        }
        this.retryHelper.signalSuccess();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public boolean isInterrupted(String str) {
        return this.interruptReasons.contains(str);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void listen(List<String> list, Map<String, Object> map, ListenHashProvider listenHashProvider, Long l3, RequestResultCallback requestResultCallback) {
        QuerySpec querySpec = new QuerySpec(list, map);
        if (this.logger.logsDebug()) {
            this.logger.debug("Listening on " + querySpec, new Object[0]);
        }
        ConnectionUtils.hardAssert(!this.listens.containsKey(querySpec), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.logger.logsDebug()) {
            this.logger.debug("Adding listen query: " + querySpec, new Object[0]);
        }
        OutstandingListen outstandingListen = new OutstandingListen(requestResultCallback, querySpec, l3, listenHashProvider);
        this.listens.put(querySpec, outstandingListen);
        if (connected()) {
            sendListen(outstandingListen);
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void merge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        putInternal("m", list, map, null, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onCacheHost(String str) {
        this.cachedHost = str;
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onDataMessage(Map<String, Object> map) {
        if (map.containsKey(REQUEST_NUMBER)) {
            ConnectionRequestCallback remove = this.requestCBHash.remove(Long.valueOf(((Integer) map.get(REQUEST_NUMBER)).intValue()));
            if (remove != null) {
                remove.onResponse((Map) map.get("b"));
                return;
            }
            return;
        }
        if (!map.containsKey("error")) {
            if (map.containsKey("a")) {
                onDataPush((String) map.get("a"), (Map) map.get("b"));
            } else if (this.logger.logsDebug()) {
                this.logger.debug("Ignoring unknown message: " + map, new Object[0]);
            }
        }
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onDisconnect(Connection.DisconnectReason disconnectReason) {
        boolean z3 = false;
        if (this.logger.logsDebug()) {
            this.logger.debug("Got on disconnect due to " + disconnectReason.name(), new Object[0]);
        }
        this.connectionState = ConnectionState.Disconnected;
        this.realtime = null;
        this.hasOnDisconnects = false;
        this.requestCBHash.clear();
        cancelSentTransactions();
        if (shouldReconnect()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.lastConnectionEstablishedTime;
            long j3 = currentTimeMillis - j2;
            if (j2 > 0 && j3 > SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY) {
                z3 = true;
            }
            if (disconnectReason == Connection.DisconnectReason.SERVER_RESET || z3) {
                this.retryHelper.signalSuccess();
            }
            tryScheduleReconnect();
        }
        this.lastConnectionEstablishedTime = 0L;
        this.delegate.onDisconnect();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void onDisconnectCancel(List<String> list, RequestResultCallback requestResultCallback) {
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, null, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, null, requestResultCallback));
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void onDisconnectMerge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback));
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void onDisconnectPut(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_PUT, list, obj, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_PUT, list, obj, requestResultCallback));
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onKill(String str) {
        if (str.equals(INVALID_APP_CHECK_TOKEN)) {
            int i = this.invalidAppCheckTokenCount;
            if (i < INVALID_TOKEN_THRESHOLD) {
                this.invalidAppCheckTokenCount = i + 1;
                this.logger.warn("Detected invalid AppCheck token. Reconnecting (" + (INVALID_TOKEN_THRESHOLD - this.invalidAppCheckTokenCount) + " attempts remaining)");
                return;
            }
        }
        this.logger.warn("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: ".concat(str));
        interrupt(SERVER_KILL_INTERRUPT_REASON);
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onReady(long j2, String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("onReady", new Object[0]);
        }
        this.lastConnectionEstablishedTime = System.currentTimeMillis();
        handleTimestamp(j2);
        if (this.firstConnection) {
            sendConnectStats();
        }
        restoreTokens();
        this.firstConnection = false;
        this.lastSessionId = str;
        this.delegate.onConnect();
    }

    public void openNetworkConnection(String str, String str2) {
        boolean z3;
        ConnectionState connectionState = this.connectionState;
        if (connectionState == ConnectionState.GettingToken) {
            z3 = true;
        } else {
            z3 = false;
        }
        ConnectionUtils.hardAssert(z3, "Trying to open network connection while in the wrong state: %s", connectionState);
        if (str == null) {
            this.delegate.onConnectionStatus(false);
        }
        this.authToken = str;
        this.appCheckToken = str2;
        this.connectionState = ConnectionState.Connecting;
        Connection connection = new Connection(this.context, this.hostInfo, this.cachedHost, this, this.lastSessionId, str2);
        this.realtime = connection;
        connection.open();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void purgeOutstandingWrites() {
        for (OutstandingPut outstandingPut : this.outstandingPuts.values()) {
            if (outstandingPut.onComplete != null) {
                outstandingPut.onComplete.onRequestResult("write_canceled", null);
            }
        }
        for (OutstandingDisconnect outstandingDisconnect : this.onDisconnectRequestQueue) {
            if (outstandingDisconnect.onComplete != null) {
                outstandingDisconnect.onComplete.onRequestResult("write_canceled", null);
            }
        }
        this.outstandingPuts.clear();
        this.onDisconnectRequestQueue.clear();
        if (!connected()) {
            this.hasOnDisconnects = false;
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void put(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        putInternal("p", list, obj, null, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAppCheckToken() {
        this.logger.debug("App check token refresh requested", new Object[0]);
        interrupt(TOKEN_REFRESH_INTERRUPT_REASON);
        resume(TOKEN_REFRESH_INTERRUPT_REASON);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAuthToken() {
        this.logger.debug("Auth token refresh requested", new Object[0]);
        interrupt(TOKEN_REFRESH_INTERRUPT_REASON);
        resume(TOKEN_REFRESH_INTERRUPT_REASON);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void resume(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug(e0.a.d("Connection no longer interrupted for: ", str), new Object[0]);
        }
        this.interruptReasons.remove(str);
        if (shouldReconnect() && this.connectionState == ConnectionState.Disconnected) {
            tryScheduleReconnect();
        }
    }

    public boolean shouldReconnect() {
        if (this.interruptReasons.size() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void shutdown() {
        interrupt("shutdown");
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void unlisten(List<String> list, Map<String, Object> map) {
        QuerySpec querySpec = new QuerySpec(list, map);
        if (this.logger.logsDebug()) {
            this.logger.debug("unlistening on " + querySpec, new Object[0]);
        }
        OutstandingListen removeListen = removeListen(querySpec);
        if (removeListen != null && connected()) {
            sendUnlisten(removeListen);
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAppCheckToken(String str) {
        this.logger.debug("App check token refreshed.", new Object[0]);
        this.appCheckToken = str;
        if (connected()) {
            if (str != null) {
                upgradeAppCheck();
            } else {
                sendUnAppCheck();
            }
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAuthToken(String str) {
        this.logger.debug("Auth token refreshed.", new Object[0]);
        this.authToken = str;
        if (connected()) {
            if (str != null) {
                upgradeAuth();
            } else {
                sendUnauth();
            }
        }
    }
}
