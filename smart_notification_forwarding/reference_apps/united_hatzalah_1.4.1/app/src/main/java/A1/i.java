package A1;

import a.AbstractC0228a;
import android.util.Log;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import com.lt.plugin.lt_plugin.utils.FirebaseHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import y1.C0784a;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements j, Continuation, OnSuccessListener, OnCompleteListener, B1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f47b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f49d;

    public /* synthetic */ i(Object obj, Object obj2, Object obj3, int i) {
        this.f46a = i;
        this.f47b = obj;
        this.f49d = obj2;
        this.f48c = obj3;
    }

    @Override // B1.a
    public Object a() {
        C0784a c0784a = (C0784a) this.f47b;
        t1.k kVar = (t1.k) this.f48c;
        t1.j jVar = (t1.j) this.f49d;
        l lVar = (l) c0784a.f6754d;
        lVar.getClass();
        q1.d dVar = kVar.f6433c;
        if (Log.isLoggable(AbstractC0228a.v("SQLiteEventStore"), 3)) {
            new StringBuilder("Storing event with priority=").append(dVar);
        }
        ((Long) lVar.c(new i(lVar, jVar, kVar, 1))).getClass();
        c0784a.f6751a.a(kVar, 1, false);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0079 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, t1.i] */
    @Override // A1.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 1074
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A1.i.apply(java.lang.Object):java.lang.Object");
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((FirebaseHelper) this.f47b).lambda$saveToFbUser$2((Runnable) this.f49d, (String) this.f48c, task);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((RolloutsStateSubscriptionsHandler) this.f47b).lambda$registerRolloutsStateSubscriber$1((Task) this.f49d, (RolloutsStateSubscriber) this.f48c, (ConfigContainer) obj);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        Task lambda$race$0;
        Task lambda$activate$2;
        switch (this.f46a) {
            case 3:
                lambda$race$0 = CrashlyticsTasks.lambda$race$0((TaskCompletionSource) this.f47b, (AtomicBoolean) this.f49d, (CancellationTokenSource) this.f48c, task);
                return lambda$race$0;
            case 4:
                lambda$activate$2 = ((FirebaseRemoteConfig) this.f47b).lambda$activate$2((Task) this.f49d, (Task) this.f48c, task);
                return lambda$activate$2;
            default:
                return ConfigRealtimeHttpClient.b((ConfigRealtimeHttpClient) this.f47b, (Task) this.f49d, (Task) this.f48c, task);
        }
    }

    public /* synthetic */ i(C0784a c0784a, t1.k kVar, t1.j jVar) {
        this.f46a = 8;
        this.f47b = c0784a;
        this.f48c = kVar;
        this.f49d = jVar;
    }
}
