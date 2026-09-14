package E1;

import F0.C0035g2;
import F0.C0084t0;
import F1.q;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class g extends F1.l {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f136b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f137c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f138d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f139e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Object obj2, int i) {
        super(taskCompletionSource);
        this.f136b = i;
        this.f139e = obj;
        this.f137c = taskCompletionSource2;
        this.f138d = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [E1.h, E1.i] */
    @Override // F1.l
    public final void a() {
        switch (this.f136b) {
            case 0:
                TaskCompletionSource taskCompletionSource = this.f137c;
                k kVar = (k) this.f139e;
                String str = (String) this.f138d;
                try {
                    kVar.f147a.f763m.b(kVar.f148b, k.a(kVar, str), new j(kVar, taskCompletionSource, str));
                    return;
                } catch (RemoteException e4) {
                    k.f145e.x(e4, "requestUpdateInfo(%s)", str);
                    taskCompletionSource.trySetException(new RuntimeException(e4));
                    return;
                }
            case 1:
                TaskCompletionSource taskCompletionSource2 = this.f137c;
                k kVar2 = (k) this.f139e;
                try {
                    kVar2.f147a.f763m.a(kVar2.f148b, k.b(), new h(kVar2, new C0035g2("OnCompleteUpdateCallback"), taskCompletionSource2));
                    return;
                } catch (RemoteException e5) {
                    k.f145e.x(e5, "completeUpdate(%s)", (String) this.f138d);
                    taskCompletionSource2.trySetException(new RuntimeException(e5));
                    return;
                }
            default:
                synchronized (((q) this.f139e).f757f) {
                    try {
                        q qVar = (q) this.f139e;
                        TaskCompletionSource taskCompletionSource3 = this.f137c;
                        qVar.f756e.add(taskCompletionSource3);
                        taskCompletionSource3.getTask().addOnCompleteListener(new C0084t0(qVar, taskCompletionSource3));
                        if (((q) this.f139e).f761k.getAndIncrement() > 0) {
                            ((q) this.f139e).f753b.y("Already connected to the service.", new Object[0]);
                        }
                        q.b((q) this.f139e, (F1.l) this.f138d);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, TaskCompletionSource taskCompletionSource, String str, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f136b = 0;
        this.f139e = kVar;
        this.f138d = str;
        this.f137c = taskCompletionSource2;
    }
}
