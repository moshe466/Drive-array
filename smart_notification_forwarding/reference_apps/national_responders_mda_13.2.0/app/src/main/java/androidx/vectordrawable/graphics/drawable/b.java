package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.res.k;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class b extends g implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    private C0062b f3751g;

    /* renamed from: h, reason: collision with root package name */
    private Context f3752h;

    /* renamed from: i, reason: collision with root package name */
    private ArgbEvaluator f3753i;

    /* renamed from: j, reason: collision with root package name */
    final Drawable.Callback f3754j;

    /* loaded from: classes.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            b.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.vectordrawable.graphics.drawable.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f3756a;

        /* renamed from: b, reason: collision with root package name */
        h f3757b;

        /* renamed from: c, reason: collision with root package name */
        AnimatorSet f3758c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<Animator> f3759d;

        /* renamed from: e, reason: collision with root package name */
        l.a<Animator, String> f3760e;

        public C0062b(Context context, C0062b c0062b, Drawable.Callback callback, Resources resources) {
            if (c0062b != null) {
                this.f3756a = c0062b.f3756a;
                h hVar = c0062b.f3757b;
                if (hVar != null) {
                    Drawable.ConstantState constantState = hVar.getConstantState();
                    this.f3757b = (h) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    h hVar2 = (h) this.f3757b.mutate();
                    this.f3757b = hVar2;
                    hVar2.setCallback(callback);
                    this.f3757b.setBounds(c0062b.f3757b.getBounds());
                    this.f3757b.h(false);
                }
                ArrayList<Animator> arrayList = c0062b.f3759d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f3759d = new ArrayList<>(size);
                    this.f3760e = new l.a<>(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = c0062b.f3759d.get(i10);
                        Animator clone = animator.clone();
                        String str = c0062b.f3760e.get(animator);
                        clone.setTarget(this.f3757b.d(str));
                        this.f3759d.add(clone);
                        this.f3760e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f3758c == null) {
                this.f3758c = new AnimatorSet();
            }
            this.f3758c.playTogether(this.f3759d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3756a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* loaded from: classes.dex */
    private static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f3761a;

        public c(Drawable.ConstantState constantState) {
            this.f3761a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f3761a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3761a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            Drawable newDrawable = this.f3761a.newDrawable();
            bVar.f3766f = newDrawable;
            newDrawable.setCallback(bVar.f3754j);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable newDrawable = this.f3761a.newDrawable(resources);
            bVar.f3766f = newDrawable;
            newDrawable.setCallback(bVar.f3754j);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable newDrawable = this.f3761a.newDrawable(resources, theme);
            bVar.f3766f = newDrawable;
            newDrawable.setCallback(bVar.f3754j);
            return bVar;
        }
    }

    b() {
        this(null, null, null);
    }

    private b(Context context) {
        this(context, null, null);
    }

    private b(Context context, C0062b c0062b, Resources resources) {
        this.f3753i = null;
        a aVar = new a();
        this.f3754j = aVar;
        this.f3752h = context;
        if (c0062b != null) {
            this.f3751g = c0062b;
        } else {
            this.f3751g = new C0062b(context, c0062b, aVar, resources);
        }
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f3751g.f3757b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        C0062b c0062b = this.f3751g;
        if (c0062b.f3759d == null) {
            c0062b.f3759d = new ArrayList<>();
            this.f3751g.f3760e = new l.a<>();
        }
        this.f3751g.f3759d.add(animator);
        this.f3751g.f3760e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i10 = 0; i10 < childAnimations.size(); i10++) {
                c(childAnimations.get(i10));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f3753i == null) {
                    this.f3753i = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f3753i);
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f3751g.f3757b.draw(canvas);
        if (this.f3751g.f3758c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f3766f;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f3751g.f3757b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f3751g.f3756a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f3766f;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.f3751g.f3757b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f3766f == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f3766f.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f3751g.f3757b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f3751g.f3757b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.getOpacity() : this.f3751g.f3757b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f3743e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        h b10 = h.b(resources, resourceId, theme);
                        b10.h(false);
                        b10.setCallback(this.f3754j);
                        h hVar = this.f3751g.f3757b;
                        if (hVar != null) {
                            hVar.setCallback(null);
                        }
                        this.f3751g.f3757b = b10;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f3744f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f3752h;
                        if (context == null) {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, d.i(context, resourceId2));
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f3751g.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f3766f;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.f3751g.f3757b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f3766f;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f3751g.f3758c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.isStateful() : this.f3751g.f3757b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f3751g.f3757b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.setLevel(i10) : this.f3751g.f3757b.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3766f;
        return drawable != null ? drawable.setState(iArr) : this.f3751g.f3757b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f3751g.f3757b.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z10);
        } else {
            this.f3751g.f3757b.setAutoMirrored(z10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3751g.f3757b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i10) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i10);
        } else {
            this.f3751g.f3757b.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        } else {
            this.f3751g.f3757b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        } else {
            this.f3751g.f3757b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f3751g.f3757b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f3751g.f3758c.isStarted()) {
                return;
            }
            this.f3751g.f3758c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f3766f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f3751g.f3758c.end();
        }
    }
}
