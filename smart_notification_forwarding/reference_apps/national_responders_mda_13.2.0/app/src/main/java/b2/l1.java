package b2;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l1 implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m1 f4033a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l1(m1 m1Var, k1 k1Var) {
        this.f4033a = m1Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i10 = message.what;
        if (i10 == 0) {
            hashMap = this.f4033a.f4034f;
            synchronized (hashMap) {
                i1 i1Var = (i1) message.obj;
                hashMap2 = this.f4033a.f4034f;
                j1 j1Var = (j1) hashMap2.get(i1Var);
                if (j1Var != null && j1Var.i()) {
                    if (j1Var.j()) {
                        j1Var.g("GmsClientSupervisor");
                    }
                    hashMap3 = this.f4033a.f4034f;
                    hashMap3.remove(i1Var);
                }
            }
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        hashMap4 = this.f4033a.f4034f;
        synchronized (hashMap4) {
            i1 i1Var2 = (i1) message.obj;
            hashMap5 = this.f4033a.f4034f;
            j1 j1Var2 = (j1) hashMap5.get(i1Var2);
            if (j1Var2 != null && j1Var2.a() == 3) {
                String valueOf = String.valueOf(i1Var2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Timeout waiting for ServiceConnection callback ");
                sb2.append(valueOf);
                new Exception();
                ComponentName b10 = j1Var2.b();
                if (b10 == null) {
                    b10 = i1Var2.b();
                }
                if (b10 == null) {
                    String d10 = i1Var2.d();
                    p.k(d10);
                    b10 = new ComponentName(d10, "unknown");
                }
                j1Var2.onServiceDisconnected(b10);
            }
        }
        return true;
    }
}
