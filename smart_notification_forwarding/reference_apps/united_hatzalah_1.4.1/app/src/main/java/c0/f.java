package C0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class f extends kotlin.jvm.internal.k implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public static final f f88a = new kotlin.jvm.internal.k(1);

    @Override // F2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        boolean z3;
        kotlin.jvm.internal.j.e(require, "$this$require");
        if (require.getRect().left != 0 && require.getRect().top != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        return Boolean.valueOf(z3);
    }
}
