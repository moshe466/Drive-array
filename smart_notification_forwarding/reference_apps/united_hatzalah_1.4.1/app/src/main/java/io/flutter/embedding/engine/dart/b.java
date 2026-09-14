package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5022a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DartMessenger.SerialTaskQueue f5023b;

    public /* synthetic */ b(DartMessenger.SerialTaskQueue serialTaskQueue, int i) {
        this.f5022a = i;
        this.f5023b = serialTaskQueue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5022a) {
            case 0:
                DartMessenger.SerialTaskQueue.a(this.f5023b);
                return;
            default:
                DartMessenger.SerialTaskQueue.b(this.f5023b);
                return;
        }
    }
}
