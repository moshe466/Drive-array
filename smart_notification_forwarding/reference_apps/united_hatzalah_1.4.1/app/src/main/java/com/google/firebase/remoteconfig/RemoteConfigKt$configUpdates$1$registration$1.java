package com.google.firebase.remoteconfig;

import P2.G;
import R2.p;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class RemoteConfigKt$configUpdates$1$registration$1 implements ConfigUpdateListener {
    final /* synthetic */ p $$this$callbackFlow;
    final /* synthetic */ FirebaseRemoteConfig $this_configUpdates;

    public RemoteConfigKt$configUpdates$1$registration$1(FirebaseRemoteConfig firebaseRemoteConfig, p pVar) {
        this.$this_configUpdates = firebaseRemoteConfig;
        this.$$this$callbackFlow = pVar;
    }

    public static final void onUpdate$lambda$0(p $this$callbackFlow, ConfigUpdate configUpdate) {
        j.e($this$callbackFlow, "$$this$callbackFlow");
        j.e(configUpdate, "$configUpdate");
        T.b.P($this$callbackFlow, configUpdate);
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void onError(FirebaseRemoteConfigException error) {
        j.e(error, "error");
        G.e(this.$$this$callbackFlow, "Error listening for config updates.", error);
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void onUpdate(ConfigUpdate configUpdate) {
        j.e(configUpdate, "configUpdate");
        this.$this_configUpdates.schedule(new e(this.$$this$callbackFlow, configUpdate, 0));
    }
}
