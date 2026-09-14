package g0;

import F0.C0018c1;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class HandlerC0425a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4650a = 1;

    /* renamed from: b, reason: collision with root package name */
    public Object f4651b;

    public /* synthetic */ HandlerC0425a() {
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int size;
        C0018c1[] c0018c1Arr;
        switch (this.f4650a) {
            case 0:
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                C0427c c0427c = (C0427c) this.f4651b;
                while (true) {
                    synchronized (c0427c.f4659b) {
                        try {
                            size = c0427c.f4661d.size();
                            if (size <= 0) {
                                return;
                            }
                            c0018c1Arr = new C0018c1[size];
                            c0427c.f4661d.toArray(c0018c1Arr);
                            c0427c.f4661d.clear();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    for (int i = 0; i < size; i++) {
                        C0018c1 c0018c1 = c0018c1Arr[i];
                        int size2 = ((ArrayList) c0018c1.f477b).size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            C0426b c0426b = (C0426b) ((ArrayList) c0018c1.f477b).get(i3);
                            if (!c0426b.f4655d) {
                                c0426b.f4653b.onReceive(c0427c.f4658a, (Intent) c0018c1.f476a);
                            }
                        }
                    }
                }
            default:
                int i4 = message.what;
                if (i4 != -3 && i4 != -2 && i4 != -1) {
                    if (i4 == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        return;
                    }
                    return;
                }
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.f4651b).get(), message.what);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0425a(C0427c c0427c, Looper looper) {
        super(looper);
        this.f4651b = c0427c;
    }
}
