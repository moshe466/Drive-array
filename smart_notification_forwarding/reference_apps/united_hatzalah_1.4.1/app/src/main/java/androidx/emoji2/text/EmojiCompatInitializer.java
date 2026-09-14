package androidx.emoji2.text;

import V.k;
import V.l;
import V.n;
import V.s;
import android.content.Context;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.InterfaceC0309t;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import n0.C0592a;
import n0.InterfaceC0593b;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements InterfaceC0593b {
    @Override // n0.InterfaceC0593b
    public final Object a(Context context) {
        Object obj;
        s sVar = new s(new n(context, 0));
        sVar.f2429b = 1;
        if (k.f2396j == null) {
            synchronized (k.i) {
                try {
                    if (k.f2396j == null) {
                        k.f2396j = new k(sVar);
                    }
                } finally {
                }
            }
        }
        C0592a c4 = C0592a.c(context);
        c4.getClass();
        synchronized (C0592a.f5880e) {
            try {
                obj = c4.f5881a.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = c4.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        AbstractC0305o lifecycle = ((InterfaceC0309t) obj).getLifecycle();
        lifecycle.a(new l(this, lifecycle));
        return Boolean.TRUE;
    }

    @Override // n0.InterfaceC0593b
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
