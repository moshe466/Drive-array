package androidx.fragment.app;

import F0.AbstractC0008a;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final /* synthetic */ class C0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3267a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0281p f3268b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ E0 f3269c;

    public /* synthetic */ C0(C0281p c0281p, E0 e02, int i) {
        this.f3267a = i;
        this.f3268b = c0281p;
        this.f3269c = e02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3267a) {
            case 0:
                C0281p c0281p = this.f3268b;
                ArrayList arrayList = c0281p.f3477b;
                E0 e02 = this.f3269c;
                if (arrayList.contains(e02)) {
                    int i = e02.f3289a;
                    View view = e02.f3291c.mView;
                    kotlin.jvm.internal.j.d(view, "operation.fragment.mView");
                    AbstractC0008a.a(i, view, c0281p.f3476a);
                    return;
                }
                return;
            case 1:
                C0281p this$0 = this.f3268b;
                kotlin.jvm.internal.j.e(this$0, "this$0");
                E0 operation = this.f3269c;
                kotlin.jvm.internal.j.e(operation, "$operation");
                this$0.a(operation);
                return;
            default:
                C0281p c0281p2 = this.f3268b;
                ArrayList arrayList2 = c0281p2.f3477b;
                E0 e03 = this.f3269c;
                arrayList2.remove(e03);
                c0281p2.f3478c.remove(e03);
                return;
        }
    }
}
