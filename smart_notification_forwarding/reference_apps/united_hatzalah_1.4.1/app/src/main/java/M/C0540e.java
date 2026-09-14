package m;

import F0.C0035g2;
import android.content.Context;
import android.view.View;
import com.uh.sf.R;
import l.SubMenuC0502F;

/* renamed from: m.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0540e extends l.x {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f5641l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0548i f5642m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0540e(C0548i c0548i, Context context, l.m mVar, View view) {
        super(context, mVar, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.f5642m = c0548i;
        this.f5467f = 8388613;
        C0035g2 c0035g2 = c0548i.f5688z;
        this.f5469h = c0035g2;
        l.u uVar = this.i;
        if (uVar != null) {
            uVar.f(c0035g2);
        }
    }

    @Override // l.x
    public final void c() {
        switch (this.f5641l) {
            case 0:
                C0548i c0548i = this.f5642m;
                c0548i.f5686w = null;
                c0548i.getClass();
                super.c();
                return;
            default:
                C0548i c0548i2 = this.f5642m;
                l.m mVar = c0548i2.f5670c;
                if (mVar != null) {
                    mVar.c(true);
                }
                c0548i2.f5685v = null;
                super.c();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0540e(C0548i c0548i, Context context, SubMenuC0502F subMenuC0502F, View view) {
        super(context, subMenuC0502F, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.f5642m = c0548i;
        if ((subMenuC0502F.f5338B.f5449x & 32) != 32) {
            View view2 = c0548i.f5676l;
            this.f5466e = view2 == null ? (View) c0548i.f5675k : view2;
        }
        C0035g2 c0035g2 = c0548i.f5688z;
        this.f5469h = c0035g2;
        l.u uVar = this.i;
        if (uVar != null) {
            uVar.f(c0035g2);
        }
    }
}
