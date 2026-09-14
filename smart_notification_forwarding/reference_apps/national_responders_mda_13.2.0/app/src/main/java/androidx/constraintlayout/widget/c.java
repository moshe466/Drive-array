package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class c extends View {

    /* renamed from: f, reason: collision with root package name */
    protected int[] f1785f;

    /* renamed from: g, reason: collision with root package name */
    protected int f1786g;

    /* renamed from: h, reason: collision with root package name */
    protected Context f1787h;

    /* renamed from: i, reason: collision with root package name */
    protected p.h f1788i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f1789j;

    /* renamed from: k, reason: collision with root package name */
    protected String f1790k;

    /* renamed from: l, reason: collision with root package name */
    protected String f1791l;

    /* renamed from: m, reason: collision with root package name */
    private View[] f1792m;

    /* renamed from: n, reason: collision with root package name */
    protected HashMap<Integer, String> f1793n;

    public c(Context context) {
        super(context);
        this.f1785f = new int[32];
        this.f1789j = false;
        this.f1792m = null;
        this.f1793n = new HashMap<>();
        this.f1787h = context;
        m(null);
    }

    private void d(String str) {
        if (str == null || str.length() == 0 || this.f1787h == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int k10 = k(trim);
        if (k10 != 0) {
            this.f1793n.put(Integer.valueOf(k10), trim);
            e(k10);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not find id of \"");
            sb2.append(trim);
            sb2.append("\"");
        }
    }

    private void e(int i10) {
        if (i10 == getId()) {
            return;
        }
        int i11 = this.f1786g + 1;
        int[] iArr = this.f1785f;
        if (i11 > iArr.length) {
            this.f1785f = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1785f;
        int i12 = this.f1786g;
        iArr2[i12] = i10;
        this.f1786g = i12 + 1;
    }

    private void f(String str) {
        if (str == null || str.length() == 0 || this.f1787h == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && trim.equals(((ConstraintLayout.b) layoutParams).Y)) {
                if (childAt.getId() == -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("to use ConstraintTag view ");
                    sb2.append(childAt.getClass().getSimpleName());
                    sb2.append(" must have an ID");
                } else {
                    e(childAt.getId());
                }
            }
        }
    }

    private int j(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f1787h.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int k(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i10 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object g10 = constraintLayout.g(0, str);
            if (g10 instanceof Integer) {
                i10 = ((Integer) g10).intValue();
            }
        }
        if (i10 == 0 && constraintLayout != null) {
            i10 = j(constraintLayout, str);
        }
        if (i10 == 0) {
            try {
                i10 = i.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i10 == 0 ? this.f1787h.getResources().getIdentifier(str, "id", this.f1787h.getPackageName()) : i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        h((ConstraintLayout) parent);
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1785f, this.f1786g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i10 = 0; i10 < this.f1786g; i10++) {
            View k10 = constraintLayout.k(this.f1785f[i10]);
            if (k10 != null) {
                k10.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    k10.setTranslationZ(k10.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(ConstraintLayout constraintLayout) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] l(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f1792m;
        if (viewArr == null || viewArr.length != this.f1786g) {
            this.f1792m = new View[this.f1786g];
        }
        for (int i10 = 0; i10 < this.f1786g; i10++) {
            this.f1792m[i10] = constraintLayout.k(this.f1785f[i10]);
        }
        return this.f1792m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.U0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == j.f1975g1) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1790k = string;
                    setIds(string);
                } else if (index == j.f1983h1) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f1791l = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void n(p.e eVar, boolean z10) {
    }

    public void o(ConstraintLayout constraintLayout) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1790k;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f1791l;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f1789j) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(ConstraintLayout constraintLayout) {
    }

    public void q(ConstraintLayout constraintLayout) {
    }

    public void r(ConstraintLayout constraintLayout) {
        String str;
        int j10;
        if (isInEditMode()) {
            setIds(this.f1790k);
        }
        p.h hVar = this.f1788i;
        if (hVar == null) {
            return;
        }
        hVar.b();
        for (int i10 = 0; i10 < this.f1786g; i10++) {
            int i11 = this.f1785f[i10];
            View k10 = constraintLayout.k(i11);
            if (k10 == null && (j10 = j(constraintLayout, (str = this.f1793n.get(Integer.valueOf(i11))))) != 0) {
                this.f1785f[i10] = j10;
                this.f1793n.put(Integer.valueOf(j10), str);
                k10 = constraintLayout.k(j10);
            }
            if (k10 != null) {
                this.f1788i.c(constraintLayout.l(k10));
            }
        }
        this.f1788i.a(constraintLayout.f1701h);
    }

    public void s() {
        if (this.f1788i == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f1754r0 = (p.e) this.f1788i;
        }
    }

    protected void setIds(String str) {
        this.f1790k = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f1786g = 0;
        while (true) {
            int indexOf = str.indexOf(44, i10);
            if (indexOf == -1) {
                d(str.substring(i10));
                return;
            } else {
                d(str.substring(i10, indexOf));
                i10 = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.f1791l = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f1786g = 0;
        while (true) {
            int indexOf = str.indexOf(44, i10);
            if (indexOf == -1) {
                f(str.substring(i10));
                return;
            } else {
                f(str.substring(i10, indexOf));
                i10 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1790k = null;
        this.f1786g = 0;
        for (int i10 : iArr) {
            e(i10);
        }
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f1790k == null) {
            e(i10);
        }
    }
}
