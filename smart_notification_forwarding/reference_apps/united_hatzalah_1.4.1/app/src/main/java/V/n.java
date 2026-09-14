package V;

import android.content.Context;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class n implements j {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2408a;

    public n(Context context, int i) {
        switch (i) {
            case 1:
                this.f2408a = context.getApplicationContext();
                return;
            default:
                this.f2408a = context.getApplicationContext();
                return;
        }
    }

    @Override // V.j
    public void a(p3.h hVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new K0.b(this, hVar, threadPoolExecutor, 1));
    }
}
