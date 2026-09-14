package p1;

import android.content.Context;
import android.os.Build;
import q1.n;

/* loaded from: classes.dex */
public abstract class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a(Context context, r1.c cVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.e eVar, t1.a aVar) {
        return Build.VERSION.SDK_INT >= 21 ? new q1.b(context, cVar, eVar) : new q1.a(context, cVar, aVar, eVar);
    }
}
