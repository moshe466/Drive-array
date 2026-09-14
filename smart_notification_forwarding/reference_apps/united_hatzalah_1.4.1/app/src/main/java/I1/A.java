package I1;

import F0.C0021d0;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class A extends z {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f896j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ z f897k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d f898l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(d dVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, z zVar) {
        super(taskCompletionSource);
        this.f898l = dVar;
        this.f896j = taskCompletionSource2;
        this.f897k = zVar;
    }

    @Override // I1.z
    public final void b() {
        synchronized (this.f898l.f911f) {
            try {
                d dVar = this.f898l;
                TaskCompletionSource taskCompletionSource = this.f896j;
                dVar.f910e.add(taskCompletionSource);
                taskCompletionSource.getTask().addOnCompleteListener(new C0021d0(dVar, taskCompletionSource));
                if (this.f898l.f916l.getAndIncrement() > 0) {
                    this.f898l.f907b.b("Already connected to the service.", new Object[0]);
                }
                d.b(this.f898l, this.f897k);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
