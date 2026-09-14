package com.google.android.gms.common.internal;

import F0.AbstractC0008a;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class zap implements Handler.Callback {
    private final zao zab;
    private final Handler zah;
    private final ArrayList zac = new ArrayList();
    final ArrayList zaa = new ArrayList();
    private final ArrayList zad = new ArrayList();
    private volatile boolean zae = false;
    private final AtomicInteger zaf = new AtomicInteger(0);
    private boolean zag = false;
    private final Object zai = new Object();

    public zap(Looper looper, zao zaoVar) {
        this.zab = zaoVar;
        this.zah = new com.google.android.gms.internal.base.zar(looper, this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.zai) {
                try {
                    if (this.zae && this.zab.isConnected() && this.zac.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", AbstractC0008a.t(new StringBuilder(String.valueOf(i).length() + 34), "Don't know how to handle message: ", i), new Exception());
        return false;
    }

    public final void zaa() {
        this.zae = false;
        this.zaf.incrementAndGet();
    }

    public final void zab() {
        this.zae = true;
    }

    public final void zac(Bundle bundle) {
        Handler handler = this.zah;
        Preconditions.checkHandlerThread(handler, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zai) {
            try {
                Preconditions.checkState(!this.zag);
                handler.removeMessages(1);
                this.zag = true;
                ArrayList arrayList = this.zaa;
                Preconditions.checkState(arrayList.isEmpty());
                ArrayList arrayList2 = new ArrayList(this.zac);
                AtomicInteger atomicInteger = this.zaf;
                int i = atomicInteger.get();
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                    if (!this.zae || !this.zab.isConnected() || atomicInteger.get() != i) {
                        break;
                    } else if (!arrayList.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle);
                    }
                }
                arrayList.clear();
                this.zag = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zad(int i) {
        Handler handler = this.zah;
        Preconditions.checkHandlerThread(handler, "onUnintentionalDisconnection must only be called on the Handler thread");
        handler.removeMessages(1);
        synchronized (this.zai) {
            try {
                this.zag = true;
                ArrayList arrayList = this.zac;
                ArrayList arrayList2 = new ArrayList(arrayList);
                AtomicInteger atomicInteger = this.zaf;
                int i3 = atomicInteger.get();
                int size = arrayList2.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList2.get(i4);
                    i4++;
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                    if (!this.zae || atomicInteger.get() != i3) {
                        break;
                    } else if (arrayList.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnectionSuspended(i);
                    }
                }
                this.zaa.clear();
                this.zag = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zae(ConnectionResult connectionResult) {
        Handler handler = this.zah;
        Preconditions.checkHandlerThread(handler, "onConnectionFailure must only be called on the Handler thread");
        handler.removeMessages(1);
        synchronized (this.zai) {
            try {
                ArrayList arrayList = this.zad;
                ArrayList arrayList2 = new ArrayList(arrayList);
                AtomicInteger atomicInteger = this.zaf;
                int i = atomicInteger.get();
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) obj;
                    if (this.zae && atomicInteger.get() == i) {
                        if (arrayList.contains(onConnectionFailedListener)) {
                            onConnectionFailedListener.onConnectionFailed(connectionResult);
                        }
                    }
                    return;
                }
            } finally {
            }
        }
    }

    public final void zaf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            try {
                ArrayList arrayList = this.zac;
                if (arrayList.contains(connectionCallbacks)) {
                    new StringBuilder(String.valueOf(connectionCallbacks).length() + 62);
                } else {
                    arrayList.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.zab.isConnected()) {
            Handler handler = this.zah;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final boolean zag(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            contains = this.zac.contains(connectionCallbacks);
        }
        return contains;
    }

    public final void zah(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            try {
                if (!this.zac.remove(connectionCallbacks)) {
                    new StringBuilder(String.valueOf(connectionCallbacks).length() + 52);
                } else if (this.zag) {
                    this.zaa.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zai(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            try {
                ArrayList arrayList = this.zad;
                if (arrayList.contains(onConnectionFailedListener)) {
                    new StringBuilder(String.valueOf(onConnectionFailedListener).length() + 67);
                } else {
                    arrayList.add(onConnectionFailedListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zaj(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            contains = this.zad.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public final void zak(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            try {
                if (!this.zad.remove(onConnectionFailedListener)) {
                    new StringBuilder(String.valueOf(onConnectionFailedListener).length() + 57);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
