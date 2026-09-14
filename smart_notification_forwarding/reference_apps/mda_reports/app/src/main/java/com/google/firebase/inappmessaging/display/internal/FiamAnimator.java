package com.google.firebase.inappmessaging.display.internal;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.graphics.Point;
import android.view.View;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import javax.inject.Inject;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class FiamAnimator {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.inappmessaging.display.internal.FiamAnimator$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a = new int[Position.values().length];

        static {
            try {
                a[Position.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Position.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Position.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Position.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface AnimationCompleteListener {
        void onComplete();
    }

    /* loaded from: classes2.dex */
    public enum Position {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM;

        /* JADX INFO: Access modifiers changed from: private */
        public static Point getPoint(Position position, View view) {
            view.measure(-2, -2);
            int i = AnonymousClass3.a[position.ordinal()];
            if (i == 1) {
                return new Point(view.getMeasuredWidth() * (-1), 0);
            }
            if (i == 2) {
                return new Point(view.getMeasuredWidth() * 1, 0);
            }
            if (i != 3 && i == 4) {
                return new Point(0, view.getMeasuredHeight() * 1);
            }
            return new Point(0, view.getMeasuredHeight() * (-1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public FiamAnimator() {
    }

    public void slideIntoView(final Application application, final View view, Position position) {
        view.setAlpha(0.0f);
        Point point = Position.getPoint(position, view);
        view.animate().translationX(point.x).translationY(point.y).setDuration(1L).setListener(new AnimatorListenerAdapter(this) { // from class: com.google.firebase.inappmessaging.display.internal.FiamAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(application.getResources().getInteger(R.integer.config_longAnimTime)).setListener(null);
            }
        });
    }

    public void slideOutOfView(Application application, View view, Position position, final AnimationCompleteListener animationCompleteListener) {
        Point point = Position.getPoint(position, view);
        view.animate().translationX(point.x).translationY(point.y).setDuration(application.getResources().getInteger(R.integer.config_longAnimTime)).setListener(new AnimatorListenerAdapter(this) { // from class: com.google.firebase.inappmessaging.display.internal.FiamAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animationCompleteListener.onComplete();
            }
        });
    }
}
