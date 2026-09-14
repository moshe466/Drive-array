package com.google.firebase.firestore.remote;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class AndroidConnectivityMonitor implements ConnectivityMonitor {
    private final List<Consumer<ConnectivityMonitor.NetworkStatus>> callbacks = new ArrayList();

    @Nullable
    private final ConnectivityManager connectivityManager;
    private final Context context;

    @Nullable
    private Runnable unregisterRunnable;

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes2.dex */
    public class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        private DefaultNetworkCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            synchronized (AndroidConnectivityMonitor.this.callbacks) {
                Iterator it = AndroidConnectivityMonitor.this.callbacks.iterator();
                while (it.hasNext()) {
                    ((Consumer) it.next()).accept(ConnectivityMonitor.NetworkStatus.REACHABLE);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            synchronized (AndroidConnectivityMonitor.this.callbacks) {
                Iterator it = AndroidConnectivityMonitor.this.callbacks.iterator();
                while (it.hasNext()) {
                    ((Consumer) it.next()).accept(ConnectivityMonitor.NetworkStatus.UNREACHABLE);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class NetworkReceiver extends BroadcastReceiver {
        private boolean isConnected;

        private NetworkReceiver() {
            this.isConnected = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = this.isConnected;
            this.isConnected = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            if (this.isConnected && !z) {
                synchronized (AndroidConnectivityMonitor.this.callbacks) {
                    Iterator it = AndroidConnectivityMonitor.this.callbacks.iterator();
                    while (it.hasNext()) {
                        ((Consumer) it.next()).accept(ConnectivityMonitor.NetworkStatus.REACHABLE);
                    }
                }
                return;
            }
            if (this.isConnected || !z) {
                return;
            }
            synchronized (AndroidConnectivityMonitor.this.callbacks) {
                Iterator it2 = AndroidConnectivityMonitor.this.callbacks.iterator();
                while (it2.hasNext()) {
                    ((Consumer) it2.next()).accept(ConnectivityMonitor.NetworkStatus.UNREACHABLE);
                }
            }
        }
    }

    public AndroidConnectivityMonitor(Context context) {
        Assert.hardAssert(context != null, "Context must be non-null", new Object[0]);
        this.context = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        configureNetworkMonitoring();
    }

    private void configureNetworkMonitoring() {
        Runnable runnable;
        if (Build.VERSION.SDK_INT < 24 || this.connectivityManager == null) {
            final NetworkReceiver networkReceiver = new NetworkReceiver();
            this.context.registerReceiver(networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            runnable = new Runnable() { // from class: com.google.firebase.firestore.remote.AndroidConnectivityMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    AndroidConnectivityMonitor.this.context.unregisterReceiver(networkReceiver);
                }
            };
        } else {
            final DefaultNetworkCallback defaultNetworkCallback = new DefaultNetworkCallback();
            this.connectivityManager.registerDefaultNetworkCallback(defaultNetworkCallback);
            runnable = new Runnable() { // from class: com.google.firebase.firestore.remote.AndroidConnectivityMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    AndroidConnectivityMonitor.this.connectivityManager.unregisterNetworkCallback(defaultNetworkCallback);
                }
            };
        }
        this.unregisterRunnable = runnable;
    }

    @Override // com.google.firebase.firestore.remote.ConnectivityMonitor
    public void addCallback(Consumer<ConnectivityMonitor.NetworkStatus> consumer) {
        synchronized (this.callbacks) {
            this.callbacks.add(consumer);
        }
    }

    @Override // com.google.firebase.firestore.remote.ConnectivityMonitor
    public void shutdown() {
        Runnable runnable = this.unregisterRunnable;
        if (runnable != null) {
            runnable.run();
            this.unregisterRunnable = null;
        }
    }
}
