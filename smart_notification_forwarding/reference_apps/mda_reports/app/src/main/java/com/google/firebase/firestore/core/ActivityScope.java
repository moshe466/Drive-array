package com.google.firebase.firestore.core;

import android.app.Activity;
import android.app.Fragment;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityScope {
    private static final String FRAGMENT_TAG = "FirestoreOnStopObserverFragment";
    private static final String SUPPORT_FRAGMENT_TAG = "FirestoreOnStopObserverSupportFragment";

    /* loaded from: classes2.dex */
    public static class CallbackList {
        private final List<Runnable> callbacks;

        private CallbackList() {
            this.callbacks = new ArrayList();
        }

        /* synthetic */ CallbackList(AnonymousClass1 anonymousClass1) {
            this();
        }

        void a() {
            for (Runnable runnable : this.callbacks) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        synchronized void a(Runnable runnable) {
            this.callbacks.add(runnable);
        }
    }

    /* loaded from: classes2.dex */
    public static class StopListenerFragment extends Fragment {
        CallbackList a = new CallbackList();

        @Override // android.app.Fragment
        public void onStop() {
            CallbackList callbackList;
            super.onStop();
            synchronized (this.a) {
                callbackList = this.a;
                this.a = new CallbackList();
            }
            callbackList.a();
        }
    }

    /* loaded from: classes2.dex */
    public static class StopListenerSupportFragment extends androidx.fragment.app.Fragment {
        CallbackList X = new CallbackList();

        @Override // androidx.fragment.app.Fragment
        public void onStop() {
            CallbackList callbackList;
            super.onStop();
            synchronized (this.X) {
                callbackList = this.X;
                this.X = new CallbackList();
            }
            callbackList.a();
        }
    }

    public static /* synthetic */ void a(Activity activity, Runnable runnable) {
        StopListenerFragment stopListenerFragment = (StopListenerFragment) castFragment(StopListenerFragment.class, activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG), FRAGMENT_TAG);
        if (stopListenerFragment == null || stopListenerFragment.isRemoving()) {
            stopListenerFragment = new StopListenerFragment();
            activity.getFragmentManager().beginTransaction().add(stopListenerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
            activity.getFragmentManager().executePendingTransactions();
        }
        stopListenerFragment.a.a(runnable);
    }

    public static /* synthetic */ void a(FragmentActivity fragmentActivity, Runnable runnable) {
        StopListenerSupportFragment stopListenerSupportFragment = (StopListenerSupportFragment) castFragment(StopListenerSupportFragment.class, fragmentActivity.getSupportFragmentManager().findFragmentByTag(SUPPORT_FRAGMENT_TAG), SUPPORT_FRAGMENT_TAG);
        if (stopListenerSupportFragment == null || stopListenerSupportFragment.isRemoving()) {
            stopListenerSupportFragment = new StopListenerSupportFragment();
            fragmentActivity.getSupportFragmentManager().beginTransaction().add(stopListenerSupportFragment, SUPPORT_FRAGMENT_TAG).commitAllowingStateLoss();
            fragmentActivity.getSupportFragmentManager().executePendingTransactions();
        }
        stopListenerSupportFragment.X.a(runnable);
    }

    public static ListenerRegistration bind(@Nullable Activity activity, ListenerRegistration listenerRegistration) {
        if (activity != null) {
            if (activity instanceof FragmentActivity) {
                listenerRegistration.getClass();
                onFragmentActivityStopCallOnce((FragmentActivity) activity, ActivityScope$$Lambda$3.lambdaFactory$(listenerRegistration));
            } else {
                listenerRegistration.getClass();
                onActivityStopCallOnce(activity, ActivityScope$$Lambda$4.lambdaFactory$(listenerRegistration));
            }
        }
        return listenerRegistration;
    }

    @Nullable
    private static <T> T castFragment(Class<T> cls, @Nullable Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Fragment with tag '" + str + "' is a " + obj.getClass().getName() + " but should be a " + cls.getName());
        }
    }

    private static void onActivityStopCallOnce(Activity activity, Runnable runnable) {
        Assert.hardAssert(!(activity instanceof FragmentActivity), "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
        activity.runOnUiThread(ActivityScope$$Lambda$1.lambdaFactory$(activity, runnable));
    }

    private static void onFragmentActivityStopCallOnce(FragmentActivity fragmentActivity, Runnable runnable) {
        fragmentActivity.runOnUiThread(ActivityScope$$Lambda$2.lambdaFactory$(fragmentActivity, runnable));
    }
}
