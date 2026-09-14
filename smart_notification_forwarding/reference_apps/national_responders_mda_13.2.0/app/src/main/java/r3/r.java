package r3;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class r extends s {

    /* renamed from: f, reason: collision with root package name */
    private final List<d<?>> f13768f;

    public r(List<d<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f13768f = list;
    }
}
