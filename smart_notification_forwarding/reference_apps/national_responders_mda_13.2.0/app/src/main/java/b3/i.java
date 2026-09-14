package b3;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private long f4103a;

    /* renamed from: b, reason: collision with root package name */
    private long f4104b;

    /* renamed from: c, reason: collision with root package name */
    private TimeInterpolator f4105c;

    /* renamed from: d, reason: collision with root package name */
    private int f4106d;

    /* renamed from: e, reason: collision with root package name */
    private int f4107e;

    public i(long j10, long j11) {
        this.f4103a = 0L;
        this.f4104b = 300L;
        this.f4105c = null;
        this.f4106d = 0;
        this.f4107e = 1;
        this.f4103a = j10;
        this.f4104b = j11;
    }

    public i(long j10, long j11, TimeInterpolator timeInterpolator) {
        this.f4103a = 0L;
        this.f4104b = 300L;
        this.f4105c = null;
        this.f4106d = 0;
        this.f4107e = 1;
        this.f4103a = j10;
        this.f4104b = j11;
        this.f4105c = timeInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f4106d = valueAnimator.getRepeatCount();
        iVar.f4107e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f4090b : interpolator instanceof AccelerateInterpolator ? a.f4091c : interpolator instanceof DecelerateInterpolator ? a.f4092d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f4103a;
    }

    public long d() {
        return this.f4104b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f4105c;
        return timeInterpolator != null ? timeInterpolator : a.f4090b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f4106d;
    }

    public int h() {
        return this.f4107e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
