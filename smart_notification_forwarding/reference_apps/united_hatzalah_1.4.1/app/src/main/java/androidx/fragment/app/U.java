package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.Violation;
import io.flutter.plugins.firebase.crashlytics.Constants;

/* loaded from: classes.dex */
public final class U implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0272g0 f3326a;

    public U(AbstractC0272g0 abstractC0272g0) {
        this.f3326a = abstractC0272g0;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z3;
        o0 g3;
        boolean equals = P.class.getName().equals(str);
        AbstractC0272g0 abstractC0272g0 = this.f3326a;
        if (equals) {
            return new P(context, attributeSet, abstractC0272g0);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, Constants.CLASS);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z.a.f2728a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    z3 = G.class.isAssignableFrom(Z.a(attributeValue, context.getClassLoader()));
                } catch (ClassNotFoundException unused) {
                    z3 = false;
                }
                if (z3) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    G C3 = resourceId != -1 ? abstractC0272g0.C(resourceId) : null;
                    if (C3 == null && string != null) {
                        C3 = abstractC0272g0.D(string);
                    }
                    if (C3 == null && id != -1) {
                        C3 = abstractC0272g0.C(id);
                    }
                    if (C3 == null) {
                        Z H3 = abstractC0272g0.H();
                        context.getClassLoader();
                        C3 = G.instantiate(H3.f3334a.f3409w.f3321b, attributeValue, null);
                        C3.mFromLayout = true;
                        C3.mFragmentId = resourceId != 0 ? resourceId : id;
                        C3.mContainerId = id;
                        C3.mTag = string;
                        C3.mInLayout = true;
                        C3.mFragmentManager = abstractC0272g0;
                        S s3 = abstractC0272g0.f3409w;
                        C3.mHost = s3;
                        C3.onInflate((Context) s3.f3321b, attributeSet, C3.mSavedFragmentState);
                        g3 = abstractC0272g0.a(C3);
                        if (AbstractC0272g0.J(2)) {
                            C3.toString();
                            Integer.toHexString(resourceId);
                        }
                    } else if (!C3.mInLayout) {
                        C3.mInLayout = true;
                        C3.mFragmentManager = abstractC0272g0;
                        S s4 = abstractC0272g0.f3409w;
                        C3.mHost = s4;
                        C3.onInflate((Context) s4.f3321b, attributeSet, C3.mSavedFragmentState);
                        g3 = abstractC0272g0.g(C3);
                        if (AbstractC0272g0.J(2)) {
                            C3.toString();
                            Integer.toHexString(resourceId);
                        }
                    } else {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    a0.b bVar = a0.c.f2749a;
                    a0.c.b(new Violation(C3, "Attempting to use <fragment> tag to add fragment " + C3 + " to container " + viewGroup));
                    a0.c.a(C3).getClass();
                    C3.mContainer = viewGroup;
                    g3.i();
                    g3.h();
                    View view2 = C3.mView;
                    if (view2 != null) {
                        if (resourceId != 0) {
                            view2.setId(resourceId);
                        }
                        if (C3.mView.getTag() == null) {
                            C3.mView.setTag(string);
                        }
                        C3.mView.addOnAttachStateChangeListener(new T(this, g3));
                        return C3.mView;
                    }
                    throw new IllegalStateException(e0.a.e("Fragment ", attributeValue, " did not create a view."));
                }
            }
        }
        return null;
    }
}
