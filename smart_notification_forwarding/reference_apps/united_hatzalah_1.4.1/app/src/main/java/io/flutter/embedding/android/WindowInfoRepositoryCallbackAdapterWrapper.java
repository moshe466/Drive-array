package io.flutter.embedding.android;

import F0.C0018c1;
import P2.B;
import P2.C0143b0;
import P2.G;
import P2.InterfaceC0157i0;
import P2.O;
import S2.z;
import U2.n;
import W2.e;
import android.app.Activity;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.j;
import w2.C0769j;
import x0.C0778a;
import y0.C0783a;
import z0.i;

/* loaded from: classes.dex */
public class WindowInfoRepositoryCallbackAdapterWrapper {
    final C0783a adapter;

    public WindowInfoRepositoryCallbackAdapterWrapper(C0783a c0783a) {
        this.adapter = c0783a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v9, types: [S2.d] */
    public void addWindowLayoutInfoListener(Activity activity, Executor executor, I.a consumer) {
        C0783a c0783a = this.adapter;
        c0783a.getClass();
        j.e(activity, "activity");
        j.e(executor, "executor");
        j.e(consumer, "consumer");
        C0018c1 c0018c1 = c0783a.f6749c;
        z0.b bVar = c0783a.f6748b;
        bVar.getClass();
        S2.c b4 = z.b(new i(bVar, activity, null));
        e eVar = O.f1622a;
        Q2.e eVar2 = n.f2372a;
        if (eVar2.get(B.f1595b) == null) {
            S2.c flow = b4;
            if (!eVar2.equals(C0769j.f6733a)) {
                flow = T2.j.a(b4, eVar2, 0, null, 6);
            }
            LinkedHashMap linkedHashMap = (LinkedHashMap) c0018c1.f477b;
            j.e(flow, "flow");
            ReentrantLock reentrantLock = (ReentrantLock) c0018c1.f476a;
            reentrantLock.lock();
            try {
                if (linkedHashMap.get(consumer) == null) {
                    linkedHashMap.put(consumer, G.r(G.b(new C0143b0(executor)), null, new C0778a(flow, consumer, null), 3));
                }
                return;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + eVar2).toString());
    }

    public void removeWindowLayoutInfoListener(I.a consumer) {
        C0783a c0783a = this.adapter;
        c0783a.getClass();
        j.e(consumer, "consumer");
        C0018c1 c0018c1 = c0783a.f6749c;
        LinkedHashMap linkedHashMap = (LinkedHashMap) c0018c1.f477b;
        ReentrantLock reentrantLock = (ReentrantLock) c0018c1.f476a;
        reentrantLock.lock();
        try {
            InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) linkedHashMap.get(consumer);
            if (interfaceC0157i0 != null) {
                interfaceC0157i0.cancel(null);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
