package com.google.firebase.remoteconfig.internal.rollouts;

import A1.i;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class RolloutsStateSubscriptionsHandler {
    private ConfigCacheClient activatedConfigsCache;
    private Executor executor;
    private RolloutsStateFactory rolloutsStateFactory;
    private Set<RolloutsStateSubscriber> subscribers = Collections.newSetFromMap(new ConcurrentHashMap());

    public RolloutsStateSubscriptionsHandler(ConfigCacheClient configCacheClient, RolloutsStateFactory rolloutsStateFactory, Executor executor) {
        this.activatedConfigsCache = configCacheClient;
        this.rolloutsStateFactory = rolloutsStateFactory;
        this.executor = executor;
    }

    public /* synthetic */ void lambda$registerRolloutsStateSubscriber$1(Task task, RolloutsStateSubscriber rolloutsStateSubscriber, ConfigContainer configContainer) {
        try {
            ConfigContainer configContainer2 = (ConfigContainer) task.getResult();
            if (configContainer2 != null) {
                this.executor.execute(new a(rolloutsStateSubscriber, this.rolloutsStateFactory.getActiveRolloutsState(configContainer2), 0));
            }
        } catch (FirebaseRemoteConfigException unused) {
        }
    }

    public void publishActiveRolloutsState(ConfigContainer configContainer) {
        try {
            RolloutsState activeRolloutsState = this.rolloutsStateFactory.getActiveRolloutsState(configContainer);
            Iterator<RolloutsStateSubscriber> it = this.subscribers.iterator();
            while (it.hasNext()) {
                this.executor.execute(new a(it.next(), activeRolloutsState, 1));
            }
        } catch (FirebaseRemoteConfigException unused) {
        }
    }

    public void registerRolloutsStateSubscriber(RolloutsStateSubscriber rolloutsStateSubscriber) {
        this.subscribers.add(rolloutsStateSubscriber);
        Task<ConfigContainer> task = this.activatedConfigsCache.get();
        task.addOnSuccessListener(this.executor, new i(this, task, rolloutsStateSubscriber, 6));
    }
}
