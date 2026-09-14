package h6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import il.org.mda.health.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p6.d;

/* loaded from: classes.dex */
public class f extends RecyclerView.g<a> {

    /* renamed from: c, reason: collision with root package name */
    private p6.f[] f10489c;

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.d0 {

        /* renamed from: t, reason: collision with root package name */
        private final TextView f10490t;

        /* renamed from: u, reason: collision with root package name */
        private final TextView f10491u;

        /* renamed from: v, reason: collision with root package name */
        private final TextView f10492v;

        /* renamed from: w, reason: collision with root package name */
        private final TextView f10493w;

        /* renamed from: x, reason: collision with root package name */
        private final TextView f10494x;

        /* renamed from: y, reason: collision with root package name */
        private final TextView f10495y;

        /* renamed from: z, reason: collision with root package name */
        private final TextView f10496z;

        public a(View view) {
            super(view);
            this.f10490t = (TextView) view.findViewById(R.id.txv_pos_res_serial_number);
            this.f10491u = (TextView) view.findViewById(R.id.txv_positive_test_date);
            this.f10492v = (TextView) view.findViewById(R.id.txv_pos_expo_description);
            this.f10493w = (TextView) view.findViewById(R.id.txv_pos_expo_location);
            this.f10494x = (TextView) view.findViewById(R.id.txv_pos_expo_location_description);
            this.f10495y = (TextView) view.findViewById(R.id.txv_iso_start_date);
            this.f10496z = (TextView) view.findViewById(R.id.txv_iso_end_date);
        }

        private String L(Date date) {
            return new SimpleDateFormat("dd/MM/yyyy", Locale.UK).format(date);
        }

        public void M(String str) {
            this.f10492v.setText(str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.CharSequence] */
        public void N(d.a aVar, String str) {
            Context context;
            int i10;
            String str2;
            TextView textView;
            TextView textView2;
            this.f10494x.setVisibility(8);
            if (aVar == d.a.HOME) {
                TextView textView3 = this.f10493w;
                context = textView3.getContext();
                i10 = R.string.home;
                textView2 = textView3;
            } else {
                if (aVar != d.a.WORK) {
                    TextView textView4 = this.f10493w;
                    textView4.setText(textView4.getContext().getText(R.string.other_option));
                    this.f10494x.setVisibility(0);
                    textView = this.f10494x;
                    str2 = str;
                    textView.setText(str2);
                }
                TextView textView5 = this.f10493w;
                context = textView5.getContext();
                i10 = R.string.work;
                textView2 = textView5;
            }
            textView = textView2;
            str2 = context.getText(i10);
            textView.setText(str2);
        }

        public void O(Date date) {
            this.f10496z.setText(L(date));
        }

        public void P(Date date) {
            this.f10495y.setText(L(date));
        }

        public void Q(String str) {
            this.f10490t.setText(str);
        }

        public void R(Date date) {
            this.f10491u.setText(L(date));
        }
    }

    public f(p6.f[] fVarArr) {
        this.f10489c = fVarArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f10489c.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void i(a aVar, int i10) {
        p6.f[] fVarArr = this.f10489c;
        int length = fVarArr.length - (i10 + 1);
        p6.f fVar = fVarArr[length];
        aVar.Q(String.valueOf(length + 1));
        if (fVar.e() != null) {
            aVar.R(fVar.e());
        }
        aVar.M(fVar.a());
        aVar.N(fVar.c(), fVar.b());
        if (fVar.d() == null || fVar.d().b() == null || fVar.d().a() == null) {
            return;
        }
        aVar.P(fVar.d().b());
        aVar.O(fVar.d().a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public a k(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_positive_result_history, viewGroup, false));
    }
}
