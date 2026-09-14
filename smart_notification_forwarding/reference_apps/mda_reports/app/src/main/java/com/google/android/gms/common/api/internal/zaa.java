package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C0008zaa> zacl;

    @VisibleForTesting(otherwise = 2)
    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0008zaa extends LifecycleCallback {
        private List<Runnable> zacm;

        private C0008zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.zacm = new ArrayList();
            this.a.addCallback("LifecycleObserverOnStop", this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static C0008zaa zaa(Activity activity) {
            C0008zaa c0008zaa;
            synchronized (activity) {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                c0008zaa = (C0008zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0008zaa.class);
                if (c0008zaa == null) {
                    c0008zaa = new C0008zaa(fragment);
                }
            }
            return c0008zaa;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void zaa(Runnable runnable) {
            this.zacm.add(runnable);
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        @MainThread
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zacm;
                this.zacm = new ArrayList();
            }
            Iterator<Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public zaa(Activity activity) {
        this(C0008zaa.zaa(activity));
    }

    @VisibleForTesting(otherwise = 2)
    private zaa(C0008zaa c0008zaa) {
        this.zacl = new WeakReference<>(c0008zaa);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0008zaa c0008zaa = this.zacl.get();
        if (c0008zaa == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        c0008zaa.zaa(runnable);
        return this;
    }
}
