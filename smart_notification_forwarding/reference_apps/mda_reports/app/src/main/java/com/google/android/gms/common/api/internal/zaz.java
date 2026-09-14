package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zaz implements OnCompleteListener<Map<zai<?>, String>> {
    private final /* synthetic */ zax zafi;

    private zaz(zax zaxVar) {
        this.zafi = zaxVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(@NonNull Task<Map<zai<?>, String>> task) {
        Lock lock;
        Lock lock2;
        boolean z;
        zax zaxVar;
        ConnectionResult connectionResult;
        boolean z2;
        Map map;
        Map map2;
        boolean zaa;
        Map map3;
        Map map4;
        ConnectionResult connectionResult2;
        zaaw zaawVar;
        ConnectionResult connectionResult3;
        Condition condition;
        Map map5;
        Map map6;
        ConnectionResult zaaf;
        Map map7;
        Map map8;
        Map map9;
        lock = this.zafi.zaeo;
        lock.lock();
        try {
            z = this.zafi.zafd;
            if (z) {
                if (task.isSuccessful()) {
                    zax zaxVar2 = this.zafi;
                    map7 = this.zafi.zaeu;
                    zaxVar2.zafe = new ArrayMap(map7.size());
                    map8 = this.zafi.zaeu;
                    for (zaw zawVar : map8.values()) {
                        map9 = this.zafi.zafe;
                        map9.put(zawVar.zak(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else {
                    if (task.getException() instanceof AvailabilityException) {
                        AvailabilityException availabilityException = (AvailabilityException) task.getException();
                        z2 = this.zafi.zafb;
                        if (z2) {
                            zax zaxVar3 = this.zafi;
                            map = this.zafi.zaeu;
                            zaxVar3.zafe = new ArrayMap(map.size());
                            map2 = this.zafi.zaeu;
                            for (zaw zawVar2 : map2.values()) {
                                Object zak = zawVar2.zak();
                                ConnectionResult connectionResult4 = availabilityException.getConnectionResult(zawVar2);
                                zaa = this.zafi.zaa(zawVar2, connectionResult4);
                                if (zaa) {
                                    map3 = this.zafi.zafe;
                                    connectionResult4 = new ConnectionResult(16);
                                } else {
                                    map3 = this.zafi.zafe;
                                }
                                map3.put(zak, connectionResult4);
                            }
                        } else {
                            this.zafi.zafe = availabilityException.zaj();
                        }
                        zaxVar = this.zafi;
                        connectionResult = this.zafi.zaaf();
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                        this.zafi.zafe = Collections.emptyMap();
                        zaxVar = this.zafi;
                        connectionResult = new ConnectionResult(8);
                    }
                    zaxVar.zafh = connectionResult;
                }
                map4 = this.zafi.zaff;
                if (map4 != null) {
                    map5 = this.zafi.zafe;
                    map6 = this.zafi.zaff;
                    map5.putAll(map6);
                    zax zaxVar4 = this.zafi;
                    zaaf = this.zafi.zaaf();
                    zaxVar4.zafh = zaaf;
                }
                connectionResult2 = this.zafi.zafh;
                if (connectionResult2 == null) {
                    this.zafi.zaad();
                    this.zafi.zaae();
                } else {
                    zax.a(this.zafi, false);
                    zaawVar = this.zafi.zaex;
                    connectionResult3 = this.zafi.zafh;
                    zaawVar.zac(connectionResult3);
                }
                condition = this.zafi.zaez;
                condition.signalAll();
            }
        } finally {
            lock2 = this.zafi.zaeo;
            lock2.unlock();
        }
    }
}
