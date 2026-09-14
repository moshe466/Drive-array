package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f6924a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private b f6925b = null;

    /* renamed from: c, reason: collision with root package name */
    ValueAnimator f6926c = null;

    /* renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f6927d = new a();

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e eVar = e.this;
            if (eVar.f6926c == animator) {
                eVar.f6926c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final int[] f6929a;

        /* renamed from: b, reason: collision with root package name */
        final ValueAnimator f6930b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f6929a = iArr;
            this.f6930b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f6926c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f6926c = null;
        }
    }

    private void e(b bVar) {
        ValueAnimator valueAnimator = bVar.f6930b;
        this.f6926c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f6927d);
        this.f6924a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f6926c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f6926c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.f6924a.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                bVar = null;
                break;
            }
            bVar = this.f6924a.get(i10);
            if (StateSet.stateSetMatches(bVar.f6929a, iArr)) {
                break;
            } else {
                i10++;
            }
        }
        b bVar2 = this.f6925b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.f6925b = bVar;
        if (bVar != null) {
            e(bVar);
        }
    }
}
