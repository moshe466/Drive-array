package kotlinx.coroutines.internal;

import java.util.List;
import nb.i1;

/* loaded from: classes.dex */
public interface r {
    i1 createDispatcher(List<? extends r> list);

    int getLoadPriority();

    String hintOnError();
}
