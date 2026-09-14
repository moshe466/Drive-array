package q0;

import J.S;
import a.AbstractC0228a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.WeakHashMap;
import m.g1;
import q.C0602B;

/* loaded from: classes.dex */
public final class f extends q {

    /* renamed from: A, reason: collision with root package name */
    public static final g1 f6079A;

    /* renamed from: B, reason: collision with root package name */
    public static final g1 f6080B;

    /* renamed from: C, reason: collision with root package name */
    public static final g1 f6081C;

    /* renamed from: D, reason: collision with root package name */
    public static final g1 f6082D;
    public static final String[] y = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: z, reason: collision with root package name */
    public static final g1 f6083z;

    /* JADX WARN: Type inference failed for: r0v2, types: [q0.b, android.util.Property] */
    static {
        new Property(PointF.class, "boundsOrigin").f6069a = new Rect();
        f6083z = new g1("topLeft", 1, PointF.class);
        f6079A = new g1("bottomRight", 2, PointF.class);
        f6080B = new g1("bottomRight", 3, PointF.class);
        f6081C = new g1("topLeft", 4, PointF.class);
        f6082D = new g1("position", 5, PointF.class);
    }

    public static void H(x xVar) {
        View view = xVar.f6137b;
        HashMap hashMap = xVar.f6136a;
        WeakHashMap weakHashMap = S.f954a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        hashMap.put("android:changeBounds:parent", xVar.f6137b.getParent());
    }

    @Override // q0.q
    public final void e(x xVar) {
        H(xVar);
    }

    @Override // q0.q
    public final void h(x xVar) {
        H(xVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [q0.e, java.lang.Object] */
    @Override // q0.q
    public final Animator l(ViewGroup viewGroup, x xVar, x xVar2) {
        int i;
        f fVar;
        ObjectAnimator ofObject;
        if (xVar != null) {
            HashMap hashMap = xVar.f6136a;
            if (xVar2 != null) {
                HashMap hashMap2 = xVar2.f6136a;
                ViewGroup viewGroup2 = (ViewGroup) hashMap.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) hashMap2.get("android:changeBounds:parent");
                if (viewGroup2 != null && viewGroup3 != null) {
                    View view = xVar2.f6137b;
                    Rect rect = (Rect) hashMap.get("android:changeBounds:bounds");
                    Rect rect2 = (Rect) hashMap2.get("android:changeBounds:bounds");
                    int i3 = rect.left;
                    int i4 = rect2.left;
                    int i5 = rect.top;
                    int i6 = rect2.top;
                    int i7 = rect.right;
                    int i8 = rect2.right;
                    int i9 = rect.bottom;
                    int i10 = rect2.bottom;
                    int i11 = i7 - i3;
                    int i12 = i9 - i5;
                    int i13 = i8 - i4;
                    int i14 = i10 - i6;
                    Rect rect3 = (Rect) hashMap.get("android:changeBounds:clip");
                    Rect rect4 = (Rect) hashMap2.get("android:changeBounds:clip");
                    if ((i11 != 0 && i12 != 0) || (i13 != 0 && i14 != 0)) {
                        if (i3 == i4 && i5 == i6) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (i7 != i8 || i9 != i10) {
                            i++;
                        }
                    } else {
                        i = 0;
                    }
                    if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                        i++;
                    }
                    int i15 = i;
                    if (i15 > 0) {
                        y.a(view, i3, i5, i7, i9);
                        if (i15 == 2) {
                            if (i11 == i13 && i12 == i14) {
                                fVar = this;
                                fVar.f6121u.getClass();
                                ofObject = ObjectAnimator.ofObject(view, f6082D, (TypeConverter) null, C0602B.a(i3, i5, i4, i6));
                            } else {
                                fVar = this;
                                ?? obj = new Object();
                                obj.f6076e = view;
                                fVar.f6121u.getClass();
                                ObjectAnimator ofObject2 = ObjectAnimator.ofObject(obj, f6083z, (TypeConverter) null, C0602B.a(i3, i5, i4, i6));
                                fVar.f6121u.getClass();
                                ObjectAnimator ofObject3 = ObjectAnimator.ofObject(obj, f6079A, (TypeConverter) null, C0602B.a(i7, i9, i8, i10));
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ofObject2, ofObject3);
                                animatorSet.addListener(new C0617c(obj));
                                ofObject = animatorSet;
                            }
                        } else {
                            fVar = this;
                            if (i3 == i4 && i5 == i6) {
                                fVar.f6121u.getClass();
                                ofObject = ObjectAnimator.ofObject(view, f6080B, (TypeConverter) null, C0602B.a(i7, i9, i8, i10));
                            } else {
                                fVar.f6121u.getClass();
                                ofObject = ObjectAnimator.ofObject(view, f6081C, (TypeConverter) null, C0602B.a(i3, i5, i4, i6));
                            }
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            AbstractC0228a.B(viewGroup4, true);
                            fVar.a(new C0618d(viewGroup4));
                        }
                        return ofObject;
                    }
                }
            }
        }
        return null;
    }

    @Override // q0.q
    public final String[] q() {
        return y;
    }
}
