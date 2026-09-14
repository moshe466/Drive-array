package androidx.fragment.app;

import android.animation.AnimatorSet;

/* renamed from: androidx.fragment.app.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0275j {

    /* renamed from: a, reason: collision with root package name */
    public static final C0275j f3423a = new Object();

    public final void a(AnimatorSet animatorSet) {
        kotlin.jvm.internal.j.e(animatorSet, "animatorSet");
        animatorSet.reverse();
    }

    public final void b(AnimatorSet animatorSet, long j2) {
        kotlin.jvm.internal.j.e(animatorSet, "animatorSet");
        animatorSet.setCurrentPlayTime(j2);
    }
}
