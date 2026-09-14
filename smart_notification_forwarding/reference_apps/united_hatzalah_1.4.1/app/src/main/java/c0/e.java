package C0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class e extends kotlin.jvm.internal.k implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public static final e f87a = new kotlin.jvm.internal.k(1);

    @Override // F2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        kotlin.jvm.internal.j.e(require, "$this$require");
        boolean z3 = true;
        if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
            z3 = false;
        }
        return Boolean.valueOf(z3);
    }
}
