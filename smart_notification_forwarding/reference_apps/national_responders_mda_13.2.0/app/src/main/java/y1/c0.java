package y1;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c0 extends n2.e {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ d f15840a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(d dVar, Looper looper) {
        super(looper);
        this.f15840a = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f15840a.g(message);
    }
}
