package e0;

import androidx.fragment.app.Fragment;
import y8.k;

/* loaded from: classes.dex */
public abstract class h extends RuntimeException {

    /* renamed from: f, reason: collision with root package name */
    private final Fragment f9132f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Fragment fragment, String str) {
        super(str);
        k.e(fragment, "fragment");
        this.f9132f = fragment;
    }

    public final Fragment a() {
        return this.f9132f;
    }
}
