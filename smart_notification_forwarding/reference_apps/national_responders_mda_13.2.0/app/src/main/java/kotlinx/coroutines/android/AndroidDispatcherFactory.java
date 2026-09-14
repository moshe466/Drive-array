package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.internal.r;
import nb.i1;
import ob.a;
import ob.c;

/* loaded from: classes.dex */
public final class AndroidDispatcherFactory implements r {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.r
    public i1 createDispatcher(List<? extends r> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            throw new IllegalStateException("The main looper is not available");
        }
        return new a(c.a(mainLooper, true), null, 2, 0 == true ? 1 : 0);
    }

    @Override // kotlinx.coroutines.internal.r
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.r
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}
