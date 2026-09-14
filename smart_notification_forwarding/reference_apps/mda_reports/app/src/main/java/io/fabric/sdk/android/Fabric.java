package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.services.common.DataCollectionArbiter;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.PriorityThreadPoolExecutor;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class Fabric {
    public static final String TAG = "Fabric";
    static volatile Fabric c;
    static final Logger d = new DefaultLogger();
    final Logger a;
    private WeakReference<Activity> activity;
    private ActivityLifecycleManager activityLifecycleManager;
    final boolean b;
    private final Context context;
    private final ExecutorService executorService;
    private final IdManager idManager;
    private final InitializationCallback<Fabric> initializationCallback;
    private AtomicBoolean initialized = new AtomicBoolean(false);
    private final InitializationCallback<?> kitInitializationCallback;
    private final Map<Class<? extends Kit>, Kit> kits;
    private final Handler mainHandler;

    /* loaded from: classes2.dex */
    public static class Builder {
        private String appIdentifier;
        private String appInstallIdentifier;
        private final Context context;
        private boolean debuggable;
        private Handler handler;
        private InitializationCallback<Fabric> initializationCallback;
        private Kit[] kits;
        private Logger logger;
        private PriorityThreadPoolExecutor threadPoolExecutor;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context;
        }

        public Builder appIdentifier(String str) {
            if (str == null) {
                throw new IllegalArgumentException("appIdentifier must not be null.");
            }
            if (this.appIdentifier != null) {
                throw new IllegalStateException("appIdentifier already set.");
            }
            this.appIdentifier = str;
            return this;
        }

        public Builder appInstallIdentifier(String str) {
            if (str == null) {
                throw new IllegalArgumentException("appInstallIdentifier must not be null.");
            }
            if (this.appInstallIdentifier != null) {
                throw new IllegalStateException("appInstallIdentifier already set.");
            }
            this.appInstallIdentifier = str;
            return this;
        }

        public Fabric build() {
            if (this.threadPoolExecutor == null) {
                this.threadPoolExecutor = PriorityThreadPoolExecutor.create();
            }
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            if (this.logger == null) {
                this.logger = this.debuggable ? new DefaultLogger(3) : new DefaultLogger();
            }
            if (this.appIdentifier == null) {
                this.appIdentifier = this.context.getPackageName();
            }
            if (this.initializationCallback == null) {
                this.initializationCallback = InitializationCallback.EMPTY;
            }
            Kit[] kitArr = this.kits;
            Map hashMap = kitArr == null ? new HashMap() : Fabric.getKitMap(Arrays.asList(kitArr));
            Context applicationContext = this.context.getApplicationContext();
            return new Fabric(applicationContext, hashMap, this.threadPoolExecutor, this.handler, this.logger, this.debuggable, this.initializationCallback, new IdManager(applicationContext, this.appIdentifier, this.appInstallIdentifier, hashMap.values()), Fabric.extractActivity(this.context));
        }

        public Builder debuggable(boolean z) {
            this.debuggable = z;
            return this;
        }

        @Deprecated
        public Builder executorService(ExecutorService executorService) {
            return this;
        }

        @Deprecated
        public Builder handler(Handler handler) {
            return this;
        }

        public Builder initializationCallback(InitializationCallback<Fabric> initializationCallback) {
            if (initializationCallback == null) {
                throw new IllegalArgumentException("initializationCallback must not be null.");
            }
            if (this.initializationCallback != null) {
                throw new IllegalStateException("initializationCallback already set.");
            }
            this.initializationCallback = initializationCallback;
            return this;
        }

        public Builder kits(Kit... kitArr) {
            if (this.kits != null) {
                throw new IllegalStateException("Kits already set.");
            }
            if (!DataCollectionArbiter.getInstance(this.context).isDataCollectionEnabled()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (Kit kit : kitArr) {
                    String identifier = kit.getIdentifier();
                    char c = 65535;
                    int hashCode = identifier.hashCode();
                    if (hashCode != 607220212) {
                        if (hashCode == 1830452504 && identifier.equals("com.crashlytics.sdk.android:crashlytics")) {
                            c = 0;
                        }
                    } else if (identifier.equals("com.crashlytics.sdk.android:answers")) {
                        c = 1;
                    }
                    if (c == 0 || c == 1) {
                        arrayList.add(kit);
                    } else if (!z) {
                        Fabric.getLogger().w(Fabric.TAG, "Fabric will not initialize any kits when Firebase automatic data collection is disabled; to use Third-party kits with automatic data collection disabled, initialize these kits via non-Fabric means.");
                        z = true;
                    }
                }
                kitArr = (Kit[]) arrayList.toArray(new Kit[0]);
            }
            this.kits = kitArr;
            return this;
        }

        public Builder logger(Logger logger) {
            if (logger == null) {
                throw new IllegalArgumentException("Logger must not be null.");
            }
            if (this.logger != null) {
                throw new IllegalStateException("Logger already set.");
            }
            this.logger = logger;
            return this;
        }

        public Builder threadPoolExecutor(PriorityThreadPoolExecutor priorityThreadPoolExecutor) {
            if (priorityThreadPoolExecutor == null) {
                throw new IllegalArgumentException("PriorityThreadPoolExecutor must not be null.");
            }
            if (this.threadPoolExecutor != null) {
                throw new IllegalStateException("PriorityThreadPoolExecutor already set.");
            }
            this.threadPoolExecutor = priorityThreadPoolExecutor;
            return this;
        }
    }

    Fabric(Context context, Map<Class<? extends Kit>, Kit> map, PriorityThreadPoolExecutor priorityThreadPoolExecutor, Handler handler, Logger logger, boolean z, InitializationCallback initializationCallback, IdManager idManager, Activity activity) {
        this.context = context;
        this.kits = map;
        this.executorService = priorityThreadPoolExecutor;
        this.mainHandler = handler;
        this.a = logger;
        this.b = z;
        this.initializationCallback = initializationCallback;
        this.kitInitializationCallback = a(map.size());
        this.idManager = idManager;
        setCurrentActivity(activity);
    }

    static Fabric a() {
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void addToKitMap(Map<Class<? extends Kit>, Kit> map, Collection<? extends Kit> collection) {
        for (Object obj : collection) {
            map.put(obj.getClass(), obj);
            if (obj instanceof KitGroup) {
                addToKitMap(map, ((KitGroup) obj).getKits());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Activity extractActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public static <T extends Kit> T getKit(Class<T> cls) {
        return (T) a().kits.get(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Class<? extends Kit>, Kit> getKitMap(Collection<? extends Kit> collection) {
        HashMap hashMap = new HashMap(collection.size());
        addToKitMap(hashMap, collection);
        return hashMap;
    }

    public static Logger getLogger() {
        return c == null ? d : c.a;
    }

    private void init() {
        this.activityLifecycleManager = new ActivityLifecycleManager(this.context);
        this.activityLifecycleManager.registerCallbacks(new ActivityLifecycleManager.Callbacks() { // from class: io.fabric.sdk.android.Fabric.1
            @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Fabric.this.setCurrentActivity(activity);
            }

            @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
            public void onActivityResumed(Activity activity) {
                Fabric.this.setCurrentActivity(activity);
            }

            @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
            public void onActivityStarted(Activity activity) {
                Fabric.this.setCurrentActivity(activity);
            }
        });
        b(this.context);
    }

    public static boolean isDebuggable() {
        if (c == null) {
            return false;
        }
        return c.b;
    }

    public static boolean isInitialized() {
        return c != null && c.initialized.get();
    }

    private static void setFabric(Fabric fabric) {
        c = fabric;
        fabric.init();
    }

    public static Fabric with(Context context, Kit... kitArr) {
        if (c == null) {
            synchronized (Fabric.class) {
                if (c == null) {
                    setFabric(new Builder(context).kits(kitArr).build());
                }
            }
        }
        return c;
    }

    public static Fabric with(Fabric fabric) {
        if (c == null) {
            synchronized (Fabric.class) {
                if (c == null) {
                    setFabric(fabric);
                }
            }
        }
        return c;
    }

    InitializationCallback<?> a(final int i) {
        return new InitializationCallback() { // from class: io.fabric.sdk.android.Fabric.2
            final CountDownLatch a;

            {
                this.a = new CountDownLatch(i);
            }

            @Override // io.fabric.sdk.android.InitializationCallback
            public void failure(Exception exc) {
                Fabric.this.initializationCallback.failure(exc);
            }

            @Override // io.fabric.sdk.android.InitializationCallback
            public void success(Object obj) {
                this.a.countDown();
                if (this.a.getCount() == 0) {
                    Fabric.this.initialized.set(true);
                    Fabric.this.initializationCallback.success(Fabric.this);
                }
            }
        };
    }

    Future<Map<String, KitInfo>> a(Context context) {
        return getExecutorService().submit(new FabricKitsFinder(context.getPackageCodePath()));
    }

    void a(Map<Class<? extends Kit>, Kit> map, Kit kit) {
        DependsOn dependsOn = kit.f;
        if (dependsOn != null) {
            for (Class<?> cls : dependsOn.value()) {
                if (cls.isInterface()) {
                    for (Kit kit2 : map.values()) {
                        if (cls.isAssignableFrom(kit2.getClass())) {
                            kit.b.addDependency(kit2.b);
                        }
                    }
                } else {
                    if (map.get(cls) == null) {
                        throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                    }
                    kit.b.addDependency(map.get(cls).b);
                }
            }
        }
    }

    void b(Context context) {
        StringBuilder sb;
        Future<Map<String, KitInfo>> a = a(context);
        Collection<Kit> kits = getKits();
        Onboarding onboarding = new Onboarding(a, kits);
        ArrayList<Kit> arrayList = new ArrayList(kits);
        Collections.sort(arrayList);
        onboarding.a(context, this, InitializationCallback.EMPTY, this.idManager);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Kit) it.next()).a(context, this, this.kitInitializationCallback, this.idManager);
        }
        onboarding.e();
        if (getLogger().isLoggable(TAG, 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(getIdentifier());
            sb.append(" [Version: ");
            sb.append(getVersion());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (Kit kit : arrayList) {
            kit.b.addDependency(onboarding.b);
            a(this.kits, kit);
            kit.e();
            if (sb != null) {
                sb.append(kit.getIdentifier());
                sb.append(" [Version: ");
                sb.append(kit.getVersion());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            getLogger().d(TAG, sb.toString());
        }
    }

    public ActivityLifecycleManager getActivityLifecycleManager() {
        return this.activityLifecycleManager;
    }

    public String getAppIdentifier() {
        return this.idManager.getAppIdentifier();
    }

    public String getAppInstallIdentifier() {
        return this.idManager.getAppInstallIdentifier();
    }

    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    public Collection<Kit> getKits() {
        return this.kits.values();
    }

    public Handler getMainHandler() {
        return this.mainHandler;
    }

    public String getVersion() {
        return "1.4.8.32";
    }

    public Fabric setCurrentActivity(Activity activity) {
        this.activity = new WeakReference<>(activity);
        return this;
    }
}
