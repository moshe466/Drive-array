package A1;

import F0.Q2;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;
import com.lt.plugin.lt_plugin.utils.FirebaseHelper;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import w1.EnumC0755c;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements j, Continuation, OnCompleteListener, B1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f38a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f39b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f40c;

    public /* synthetic */ f(int i, Object obj, Object obj2) {
        this.f38a = i;
        this.f39b = obj;
        this.f40c = obj2;
    }

    @Override // B1.a
    public Object a() {
        switch (this.f38a) {
            case 6:
                z1.g gVar = (z1.g) this.f39b;
                Iterable iterable = (Iterable) this.f40c;
                l lVar = (l) gVar.f6859c;
                lVar.getClass();
                if (iterable.iterator().hasNext()) {
                    lVar.a().compileStatement("DELETE FROM events WHERE _id in " + l.g(iterable)).execute();
                    return null;
                }
                return null;
            default:
                z1.g gVar2 = (z1.g) this.f39b;
                for (Map.Entry entry : ((HashMap) this.f40c).entrySet()) {
                    ((l) gVar2.i).e(((Integer) entry.getValue()).intValue(), EnumC0755c.INVALID_PAYLOD, (String) entry.getKey());
                }
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091 A[Catch: all -> 0x0117, TryCatch #0 {all -> 0x0117, blocks: (B:25:0x008b, B:27:0x0091, B:29:0x00a1, B:31:0x00ad), top: B:24:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    @Override // A1.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A1.f.apply(java.lang.Object):java.lang.Object");
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((FirebaseHelper) this.f39b).lambda$logOut$4((Q2) this.f40c, task);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        Task lambda$fetchIfCacheExpiredAndNotThrottled$3;
        Task lambda$fetchNowWithTypeAndAttemptNumber$1;
        switch (this.f38a) {
            case 2:
                lambda$fetchIfCacheExpiredAndNotThrottled$3 = ((ConfigFetchHandler) this.f39b).lambda$fetchIfCacheExpiredAndNotThrottled$3((Date) this.f40c, task);
                return lambda$fetchIfCacheExpiredAndNotThrottled$3;
            case 3:
                lambda$fetchNowWithTypeAndAttemptNumber$1 = ((ConfigFetchHandler) this.f39b).lambda$fetchNowWithTypeAndAttemptNumber$1((HashMap) this.f40c, task);
                return lambda$fetchNowWithTypeAndAttemptNumber$1;
            default:
                return ConfigRealtimeHttpClient.a((ConfigRealtimeHttpClient) this.f39b, (Task) this.f40c, task);
        }
    }
}
