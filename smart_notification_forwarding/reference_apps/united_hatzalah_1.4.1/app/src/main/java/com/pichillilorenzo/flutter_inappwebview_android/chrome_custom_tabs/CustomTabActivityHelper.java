package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import b.C0317b;
import b.InterfaceC0319d;
import java.util.List;
import java.util.Map;
import r.AbstractC0626a;
import r.AbstractC0633h;
import r.AbstractServiceConnectionC0637l;
import r.BinderC0632g;
import r.C0635j;
import r.C0640o;
import s.c;

/* loaded from: classes.dex */
public class CustomTabActivityHelper implements ServiceConnectionCallback {
    private AbstractC0633h mClient;
    private AbstractServiceConnectionC0637l mConnection;
    private ConnectionCallback mConnectionCallback;
    private AbstractC0626a mCustomTabsCallback;
    private C0640o mCustomTabsSession;

    /* loaded from: classes.dex */
    public interface ConnectionCallback {
        void onCustomTabsConnected();

        void onCustomTabsDisconnected();
    }

    public static boolean isAvailable(Activity activity) {
        if (CustomTabsHelper.getPackageNameToUse(activity) != null) {
            return true;
        }
        return false;
    }

    public static void openCustomTab(Activity activity, Intent intent, Uri uri, Map<String, String> map, Uri uri2, int i) {
        intent.setData(uri);
        if (map != null) {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            intent.putExtra("com.android.browser.headers", bundle);
        }
        if (uri2 != null) {
            intent.putExtra("android.intent.extra.REFERRER", uri2);
        }
        activity.startActivityForResult(intent, i);
    }

    public static void openTrustedWebActivity(Activity activity, c cVar, Uri uri, Map<String, String> map, Uri uri2, int i) {
        openCustomTab(activity, cVar.f6219a, uri, map, uri2, i);
    }

    public boolean bindCustomTabsService(Activity activity) {
        if (this.mClient != null) {
            return true;
        }
        String packageNameToUse = CustomTabsHelper.getPackageNameToUse(activity);
        if (packageNameToUse == null) {
            return false;
        }
        ServiceConnection serviceConnection = new ServiceConnection(this);
        this.mConnection = serviceConnection;
        serviceConnection.setApplicationContext(activity.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!packageNameToUse.isEmpty()) {
            intent.setPackage(packageNameToUse);
            return activity.bindService(intent, serviceConnection, 33);
        }
        throw new IllegalArgumentException("Service Intents must be explicit");
    }

    public C0640o getSession() {
        AbstractC0633h abstractC0633h = this.mClient;
        C0640o c0640o = null;
        if (abstractC0633h == null) {
            this.mCustomTabsSession = null;
        } else if (this.mCustomTabsSession == null) {
            AbstractC0626a abstractC0626a = this.mCustomTabsCallback;
            InterfaceC0319d interfaceC0319d = abstractC0633h.f6183a;
            BinderC0632g binderC0632g = new BinderC0632g(abstractC0626a);
            try {
                if (((C0317b) interfaceC0319d).e(binderC0632g)) {
                    c0640o = new C0640o(interfaceC0319d, binderC0632g, abstractC0633h.f6184b);
                }
            } catch (RemoteException unused) {
            }
            this.mCustomTabsSession = c0640o;
        }
        return this.mCustomTabsSession;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        C0640o session;
        if (this.mClient != null && (session = getSession()) != null) {
            try {
                return ((C0317b) session.f6201b).d(session.f6202c, uri, session.a(bundle), list);
            } catch (RemoteException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ServiceConnectionCallback
    public void onServiceConnected(AbstractC0633h abstractC0633h) {
        this.mClient = abstractC0633h;
        abstractC0633h.getClass();
        try {
            ((C0317b) abstractC0633h.f6183a).n();
        } catch (RemoteException unused) {
        }
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsConnected();
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ServiceConnectionCallback
    public void onServiceDisconnected() {
        this.mClient = null;
        this.mCustomTabsSession = null;
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsDisconnected();
        }
    }

    public void setConnectionCallback(ConnectionCallback connectionCallback) {
        this.mConnectionCallback = connectionCallback;
    }

    public void setCustomTabsCallback(AbstractC0626a abstractC0626a) {
        this.mCustomTabsCallback = abstractC0626a;
    }

    public void unbindCustomTabsService(Activity activity) {
        AbstractServiceConnectionC0637l abstractServiceConnectionC0637l = this.mConnection;
        if (abstractServiceConnectionC0637l == null) {
            return;
        }
        activity.unbindService(abstractServiceConnectionC0637l);
        this.mClient = null;
        this.mCustomTabsSession = null;
        this.mConnection = null;
    }

    public static void openCustomTab(Activity activity, C0635j c0635j, Uri uri, Map<String, String> map, Uri uri2, int i) {
        openCustomTab(activity, c0635j.f6192a, uri, map, uri2, i);
    }
}
