package b2;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import b2.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y0 extends o2.i {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4085a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(c cVar, Looper looper) {
        super(looper);
        this.f4085a = cVar;
    }

    private static final void a(Message message) {
        z0 z0Var = (z0) message.obj;
        z0Var.b();
        z0Var.e();
    }

    private static final boolean b(Message message) {
        int i10 = message.what;
        return i10 == 2 || i10 == 1 || i10 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        c.a aVar;
        c.a aVar2;
        com.google.android.gms.common.a aVar3;
        com.google.android.gms.common.a aVar4;
        boolean z10;
        if (this.f4085a.B.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i10 = message.what;
        if ((i10 == 1 || i10 == 7 || ((i10 == 4 && !this.f4085a.y()) || message.what == 5)) && !this.f4085a.i()) {
            a(message);
            return;
        }
        int i11 = message.what;
        if (i11 == 4) {
            this.f4085a.f3945y = new com.google.android.gms.common.a(message.arg2);
            if (c.m0(this.f4085a)) {
                c cVar = this.f4085a;
                z10 = cVar.f3946z;
                if (!z10) {
                    cVar.n0(3, null);
                    return;
                }
            }
            c cVar2 = this.f4085a;
            aVar4 = cVar2.f3945y;
            com.google.android.gms.common.a aVar5 = aVar4 != null ? cVar2.f3945y : new com.google.android.gms.common.a(8);
            this.f4085a.f3935o.a(aVar5);
            this.f4085a.Q(aVar5);
            return;
        }
        if (i11 == 5) {
            c cVar3 = this.f4085a;
            aVar3 = cVar3.f3945y;
            com.google.android.gms.common.a aVar6 = aVar3 != null ? cVar3.f3945y : new com.google.android.gms.common.a(8);
            this.f4085a.f3935o.a(aVar6);
            this.f4085a.Q(aVar6);
            return;
        }
        if (i11 == 3) {
            Object obj = message.obj;
            com.google.android.gms.common.a aVar7 = new com.google.android.gms.common.a(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f4085a.f3935o.a(aVar7);
            this.f4085a.Q(aVar7);
            return;
        }
        if (i11 == 6) {
            this.f4085a.n0(5, null);
            c cVar4 = this.f4085a;
            aVar = cVar4.f3940t;
            if (aVar != null) {
                aVar2 = cVar4.f3940t;
                aVar2.i(message.arg2);
            }
            this.f4085a.R(message.arg2);
            c.l0(this.f4085a, 5, 1, null);
            return;
        }
        if (i11 == 2 && !this.f4085a.a()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((z0) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
