package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.uh.sf.R;

/* renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0269f extends AbstractC0276k {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3364b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3365c;

    /* renamed from: d, reason: collision with root package name */
    public M f3366d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0269f(E0 operation, boolean z3) {
        super(operation);
        kotlin.jvm.internal.j.e(operation, "operation");
        this.f3364b = z3;
    }

    public final M b(Context context) {
        boolean z3;
        int exitAnim;
        Animation loadAnimation;
        M m4;
        int i;
        if (this.f3365c) {
            return this.f3366d;
        }
        E0 e02 = this.f3425a;
        G g3 = e02.f3291c;
        if (e02.f3289a == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        int nextTransition = g3.getNextTransition();
        if (this.f3364b) {
            if (z3) {
                exitAnim = g3.getPopEnterAnim();
            } else {
                exitAnim = g3.getPopExitAnim();
            }
        } else if (z3) {
            exitAnim = g3.getEnterAnim();
        } else {
            exitAnim = g3.getExitAnim();
        }
        g3.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = g3.mContainer;
        M m5 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            g3.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = g3.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation onCreateAnimation = g3.onCreateAnimation(nextTransition, z3, exitAnim);
            if (onCreateAnimation != null) {
                m5 = new M(onCreateAnimation);
            } else {
                Animator onCreateAnimator = g3.onCreateAnimator(nextTransition, z3, exitAnim);
                if (onCreateAnimator != null) {
                    m5 = new M(onCreateAnimator);
                } else {
                    if (exitAnim == 0 && nextTransition != 0) {
                        if (nextTransition != 4097) {
                            if (nextTransition != 8194) {
                                if (nextTransition != 8197) {
                                    if (nextTransition != 4099) {
                                        if (nextTransition != 4100) {
                                            i = -1;
                                        } else if (z3) {
                                            i = T.b.L(context, android.R.attr.activityOpenEnterAnimation);
                                        } else {
                                            i = T.b.L(context, android.R.attr.activityOpenExitAnimation);
                                        }
                                    } else if (z3) {
                                        i = R.animator.fragment_fade_enter;
                                    } else {
                                        i = R.animator.fragment_fade_exit;
                                    }
                                } else if (z3) {
                                    i = T.b.L(context, android.R.attr.activityCloseEnterAnimation);
                                } else {
                                    i = T.b.L(context, android.R.attr.activityCloseExitAnimation);
                                }
                            } else if (z3) {
                                i = R.animator.fragment_close_enter;
                            } else {
                                i = R.animator.fragment_close_exit;
                            }
                        } else if (z3) {
                            i = R.animator.fragment_open_enter;
                        } else {
                            i = R.animator.fragment_open_exit;
                        }
                        exitAnim = i;
                    }
                    if (exitAnim != 0) {
                        boolean equals = "anim".equals(context.getResources().getResourceTypeName(exitAnim));
                        try {
                            if (equals) {
                                try {
                                    loadAnimation = AnimationUtils.loadAnimation(context, exitAnim);
                                } catch (Resources.NotFoundException e4) {
                                    throw e4;
                                } catch (RuntimeException unused) {
                                }
                                if (loadAnimation != null) {
                                    m4 = new M(loadAnimation);
                                    m5 = m4;
                                }
                            }
                            Animator loadAnimator = AnimatorInflater.loadAnimator(context, exitAnim);
                            if (loadAnimator != null) {
                                m4 = new M(loadAnimator);
                                m5 = m4;
                            }
                        } catch (RuntimeException e5) {
                            if (!equals) {
                                Animation loadAnimation2 = AnimationUtils.loadAnimation(context, exitAnim);
                                if (loadAnimation2 != null) {
                                    m5 = new M(loadAnimation2);
                                }
                            } else {
                                throw e5;
                            }
                        }
                    }
                }
            }
        }
        this.f3366d = m5;
        this.f3365c = true;
        return m5;
    }
}
