package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private TypedValue f1101f;

    /* renamed from: g, reason: collision with root package name */
    private TypedValue f1102g;

    /* renamed from: h, reason: collision with root package name */
    private TypedValue f1103h;

    /* renamed from: i, reason: collision with root package name */
    private TypedValue f1104i;

    /* renamed from: j, reason: collision with root package name */
    private TypedValue f1105j;

    /* renamed from: k, reason: collision with root package name */
    private TypedValue f1106k;

    /* renamed from: l, reason: collision with root package name */
    private final Rect f1107l;

    /* renamed from: m, reason: collision with root package name */
    private a f1108m;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1107l = new Rect();
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void b(int i10, int i11, int i12, int i13) {
        this.f1107l.set(i10, i11, i12, i13);
        if (androidx.core.view.a0.S(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1105j == null) {
            this.f1105j = new TypedValue();
        }
        return this.f1105j;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1106k == null) {
            this.f1106k = new TypedValue();
        }
        return this.f1106k;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1103h == null) {
            this.f1103h = new TypedValue();
        }
        return this.f1103h;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1104i == null) {
            this.f1104i = new TypedValue();
        }
        return this.f1104i;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1101f == null) {
            this.f1101f = new TypedValue();
        }
        return this.f1101f;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1102g == null) {
            this.f1102g = new TypedValue();
        }
        return this.f1102g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f1108m;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f1108m;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f1108m = aVar;
    }
}
