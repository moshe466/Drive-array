package androidx.loader.content;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class j extends Handler {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        CountDownLatch countDownLatch;
        i iVar = (i) message.obj;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            a aVar = iVar.f3647a;
            return;
        }
        a aVar2 = iVar.f3647a;
        Object obj = iVar.f3648b[0];
        if (aVar2.f3638d.get()) {
            countDownLatch = aVar2.f3640f;
            try {
                aVar2.f3642k.dispatchOnCancelled(aVar2, obj);
                countDownLatch.countDown();
            } finally {
            }
        } else {
            countDownLatch = aVar2.f3640f;
            try {
                aVar2.f3642k.dispatchOnLoadComplete(aVar2, obj);
            } finally {
            }
        }
        aVar2.f3637c = 3;
    }
}
