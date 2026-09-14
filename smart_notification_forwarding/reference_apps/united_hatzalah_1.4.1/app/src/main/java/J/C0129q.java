package J;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: J.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0129q {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f1023a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f1024b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f1025c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1026d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f1027e;

    public C0129q(ViewGroup viewGroup) {
        this.f1025c = viewGroup;
    }

    public final boolean a(float f4, float f5, boolean z3) {
        ViewParent e4;
        if (this.f1026d && (e4 = e(0)) != null) {
            try {
                return e4.onNestedFling(this.f1025c, f4, f5, z3);
            } catch (AbstractMethodError e5) {
                Log.e("ViewParentCompat", "ViewParent " + e4 + " does not implement interface method onNestedFling", e5);
            }
        }
        return false;
    }

    public final boolean b(float f4, float f5) {
        ViewParent e4;
        if (this.f1026d && (e4 = e(0)) != null) {
            try {
                return e4.onNestedPreFling(this.f1025c, f4, f5);
            } catch (AbstractMethodError e5) {
                Log.e("ViewParentCompat", "ViewParent " + e4 + " does not implement interface method onNestedPreFling", e5);
            }
        }
        return false;
    }

    public final boolean c(int i, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent e4;
        int i5;
        int i6;
        if (!this.f1026d || (e4 = e(i4)) == null) {
            return false;
        }
        if (i == 0 && i3 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f1025c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (iArr == null) {
            if (this.f1027e == null) {
                this.f1027e = new int[2];
            }
            iArr = this.f1027e;
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (e4 instanceof r) {
            ((r) e4).onNestedPreScroll(viewGroup, i, i3, iArr3, i4);
        } else if (i4 == 0) {
            try {
                e4.onNestedPreScroll(viewGroup, i, i3, iArr3);
            } catch (AbstractMethodError e5) {
                Log.e("ViewParentCompat", "ViewParent " + e4 + " does not implement interface method onNestedPreScroll", e5);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i6;
        }
        if (iArr3[0] == 0 && iArr3[1] == 0) {
            return false;
        }
        return true;
    }

    public final boolean d(int i, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent e4;
        int i7;
        int i8;
        int[] iArr3;
        if (this.f1026d && (e4 = e(i6)) != null) {
            if (i == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                if (iArr != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    return false;
                }
            } else {
                ViewGroup viewGroup = this.f1025c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i7 = iArr[0];
                    i8 = iArr[1];
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                if (iArr2 == null) {
                    if (this.f1027e == null) {
                        this.f1027e = new int[2];
                    }
                    int[] iArr4 = this.f1027e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (e4 instanceof InterfaceC0130s) {
                    ((InterfaceC0130s) e4).onNestedScroll(viewGroup, i, i3, i4, i5, i6, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i4;
                    iArr3[1] = iArr3[1] + i5;
                    if (e4 instanceof r) {
                        ((r) e4).onNestedScroll(viewGroup, i, i3, i4, i5, i6);
                    } else if (i6 == 0) {
                        try {
                            e4.onNestedScroll(viewGroup, i, i3, i4, i5);
                        } catch (AbstractMethodError e5) {
                            Log.e("ViewParentCompat", "ViewParent " + e4 + " does not implement interface method onNestedScroll", e5);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i7;
                    iArr[1] = iArr[1] - i8;
                }
                return true;
            }
        }
        return false;
    }

    public final ViewParent e(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.f1024b;
        }
        return this.f1023a;
    }

    public final boolean f(int i) {
        if (e(i) != null) {
            return true;
        }
        return false;
    }

    public final boolean g(int i, int i3) {
        boolean onStartNestedScroll;
        if (!f(i3)) {
            if (this.f1026d) {
                View view = this.f1025c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z3 = parent instanceof r;
                    if (z3) {
                        onStartNestedScroll = ((r) parent).onStartNestedScroll(view2, view, i, i3);
                    } else {
                        if (i3 == 0) {
                            try {
                                onStartNestedScroll = parent.onStartNestedScroll(view2, view, i);
                            } catch (AbstractMethodError e4) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e4);
                            }
                        }
                        onStartNestedScroll = false;
                    }
                    if (onStartNestedScroll) {
                        if (i3 != 0) {
                            if (i3 == 1) {
                                this.f1024b = parent;
                            }
                        } else {
                            this.f1023a = parent;
                        }
                        if (z3) {
                            ((r) parent).onNestedScrollAccepted(view2, view, i, i3);
                        } else if (i3 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i);
                            } catch (AbstractMethodError e5) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e5);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void h(int i) {
        ViewParent e4 = e(i);
        if (e4 != null) {
            boolean z3 = e4 instanceof r;
            ViewGroup viewGroup = this.f1025c;
            if (z3) {
                ((r) e4).onStopNestedScroll(viewGroup, i);
            } else if (i == 0) {
                try {
                    e4.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError e5) {
                    Log.e("ViewParentCompat", "ViewParent " + e4 + " does not implement interface method onStopNestedScroll", e5);
                }
            }
            if (i != 0) {
                if (i == 1) {
                    this.f1024b = null;
                    return;
                }
                return;
            }
            this.f1023a = null;
        }
    }
}
