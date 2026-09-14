package q;

import F0.RunnableC0091v;
import com.uh.sf.R;
import java.util.concurrent.Executor;

/* renamed from: q.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0611h implements androidx.lifecycle.C {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6027a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f6028b;

    public /* synthetic */ C0611h(p pVar, int i) {
        this.f6027a = i;
        this.f6028b = pVar;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    @Override // androidx.lifecycle.C
    public final void g(Object obj) {
        switch (this.f6027a) {
            case 0:
                u uVar = (u) obj;
                if (uVar != null) {
                    p pVar = this.f6028b;
                    C0601A c0601a = pVar.f6036b;
                    if (c0601a.f5999l) {
                        c0601a.f5999l = false;
                        Executor executor = c0601a.f5990b;
                        if (executor == null) {
                            executor = new F.d(3);
                        }
                        executor.execute(new RunnableC0091v(pVar, uVar, 6, false));
                    }
                    pVar.dismiss();
                    C0601A c0601a2 = pVar.f6036b;
                    if (c0601a2.p == null) {
                        c0601a2.p = new androidx.lifecycle.A();
                    }
                    C0601A.h(c0601a2.p, null);
                    return;
                }
                return;
            default:
                if (((Boolean) obj).booleanValue()) {
                    p pVar2 = this.f6028b;
                    if (pVar2.i()) {
                        pVar2.m(pVar2.getString(R.string.fingerprint_not_recognized));
                    }
                    C0601A c0601a3 = pVar2.f6036b;
                    if (c0601a3.f5999l) {
                        Executor executor2 = c0601a3.f5990b;
                        if (executor2 == null) {
                            executor2 = new F.d(3);
                        }
                        executor2.execute(new RunnableC0610g(pVar2, 0));
                    }
                    C0601A c0601a4 = pVar2.f6036b;
                    if (c0601a4.f6005s == null) {
                        c0601a4.f6005s = new androidx.lifecycle.A();
                    }
                    C0601A.h(c0601a4.f6005s, Boolean.FALSE);
                    return;
                }
                return;
        }
    }
}
