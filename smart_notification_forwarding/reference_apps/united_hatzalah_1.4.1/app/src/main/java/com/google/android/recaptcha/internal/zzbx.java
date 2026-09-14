package com.google.android.recaptcha.internal;

import P2.C0169t;
import P2.G;
import P2.InterfaceC0168s;
import P2.J;
import P2.w0;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class zzbx {
    public static final J zza(Task task) {
        final C0169t a2 = G.a();
        task.addOnCompleteListener(zzbv.zza, new OnCompleteListener() { // from class: com.google.android.recaptcha.internal.zzbu
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                InterfaceC0768i interfaceC0768i = InterfaceC0168s.this;
                Exception exception = task2.getException();
                if (exception == null) {
                    if (task2.isCanceled()) {
                        ((w0) interfaceC0768i).cancel(null);
                        return;
                    } else {
                        ((C0169t) interfaceC0768i).D(task2.getResult());
                        return;
                    }
                }
                ((C0169t) interfaceC0768i).P(exception);
            }
        });
        return new zzbw(a2);
    }
}
