package c6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import c6.q;
import com.groboot.mdaemergency.models.SampleMovementReport;
import il.org.mda.health.R;
import java.util.List;
import l8.w;

/* loaded from: classes.dex */
public final class q extends RecyclerView.g<a> {

    /* renamed from: c, reason: collision with root package name */
    private final List<SampleMovementReport> f4451c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f4452d;

    /* renamed from: e, reason: collision with root package name */
    private x8.l<? super SampleMovementReport, w> f4453e;

    /* loaded from: classes.dex */
    public final class a extends RecyclerView.d0 {

        /* renamed from: t, reason: collision with root package name */
        private final TextView f4454t;

        /* renamed from: u, reason: collision with root package name */
        private final TextView f4455u;

        /* renamed from: v, reason: collision with root package name */
        private final TextView f4456v;

        /* renamed from: w, reason: collision with root package name */
        private final ConstraintLayout f4457w;

        /* renamed from: x, reason: collision with root package name */
        final /* synthetic */ q f4458x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(final q qVar, View view) {
            super(view);
            y8.k.e(qVar, "this$0");
            y8.k.e(view, "view");
            this.f4458x = qVar;
            this.f4454t = (TextView) view.findViewById(g5.h.R);
            this.f4455u = (TextView) view.findViewById(g5.h.X);
            this.f4456v = (TextView) view.findViewById(g5.h.W);
            this.f4457w = (ConstraintLayout) view.findViewById(g5.h.f9840v);
            this.f3375a.setOnClickListener(new View.OnClickListener() { // from class: c6.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    q.a.M(q.this, this, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void M(q qVar, a aVar, View view) {
            y8.k.e(qVar, "this$0");
            y8.k.e(aVar, "this$1");
            x8.l<SampleMovementReport, w> t10 = qVar.t();
            if (t10 == null) {
                return;
            }
            t10.h(qVar.s().get(aVar.j()));
        }

        public final ConstraintLayout N() {
            return this.f4457w;
        }

        public final TextView O() {
            return this.f4454t;
        }

        public final TextView P() {
            return this.f4456v;
        }

        public final TextView Q() {
            return this.f4455u;
        }
    }

    public q(List<SampleMovementReport> list, Context context) {
        y8.k.e(list, "items");
        y8.k.e(context, "context");
        this.f4451c = list;
        this.f4452d = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f4451c.size();
    }

    public final List<SampleMovementReport> s() {
        return this.f4451c;
    }

    public final x8.l<SampleMovementReport, w> t() {
        return this.f4453e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void i(a aVar, int i10) {
        y8.k.e(aVar, "holder");
        SampleMovementReport sampleMovementReport = this.f4451c.get(i10);
        TextView O = aVar.O();
        if (O != null) {
            O.setText(sampleMovementReport.getField1());
        }
        aVar.Q().setText(String.valueOf(sampleMovementReport.getAmount()));
        aVar.P().setText(sampleMovementReport.getField2());
        aVar.N().setBackgroundResource(i10 % 2 == 0 ? R.color.ptt_background_default : R.color.white);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public a k(ViewGroup viewGroup, int i10) {
        y8.k.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f4452d).inflate(R.layout.sample_summary_item, viewGroup, false);
        y8.k.d(inflate, "from(context).inflate(R.…mary_item, parent, false)");
        return new a(this, inflate);
    }

    public final void w(x8.l<? super SampleMovementReport, w> lVar) {
        this.f4453e = lVar;
    }
}
