package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4236a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f4237b;

    public /* synthetic */ a(Callable callable, int i) {
        this.f4236a = i;
        this.f4237b = callable;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        Task lambda$submit$0;
        Task lambda$submitTask$2;
        Task lambda$submitTask$3;
        Task lambda$submitTaskOnSuccess$4;
        switch (this.f4236a) {
            case 0:
                lambda$submit$0 = CrashlyticsWorker.lambda$submit$0(this.f4237b, task);
                return lambda$submit$0;
            case 1:
                lambda$submitTask$2 = CrashlyticsWorker.lambda$submitTask$2(this.f4237b, task);
                return lambda$submitTask$2;
            case 2:
                lambda$submitTask$3 = CrashlyticsWorker.lambda$submitTask$3(this.f4237b, task);
                return lambda$submitTask$3;
            default:
                lambda$submitTaskOnSuccess$4 = CrashlyticsWorker.lambda$submitTaskOnSuccess$4(this.f4237b, task);
                return lambda$submitTaskOnSuccess$4;
        }
    }
}
