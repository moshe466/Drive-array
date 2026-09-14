package C0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class d extends kotlin.jvm.internal.k implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public static final d f86a = new kotlin.jvm.internal.k(1);

    @Override // F2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        boolean z3;
        kotlin.jvm.internal.j.e(require, "$this$require");
        if (require.getRect().width() == 0 && require.getRect().height() == 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        return Boolean.valueOf(z3);
    }
}
