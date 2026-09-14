package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import il.org.mda.health.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class e extends RecyclerView.g<a> {

    /* renamed from: c, reason: collision with root package name */
    private p6.d[] f10484c;

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.d0 {

        /* renamed from: t, reason: collision with root package name */
        private final TextView f10485t;

        /* renamed from: u, reason: collision with root package name */
        private final TextView f10486u;

        /* renamed from: v, reason: collision with root package name */
        private final TextView f10487v;

        /* renamed from: w, reason: collision with root package name */
        private final TextView f10488w;

        public a(View view) {
            super(view);
            this.f10485t = (TextView) view.findViewById(R.id.txv_isolation_serial_number);
            this.f10486u = (TextView) view.findViewById(R.id.txv_exposure_date);
            this.f10487v = (TextView) view.findViewById(R.id.txv_isolation_start_date);
            this.f10488w = (TextView) view.findViewById(R.id.txv_isolation_end_date);
        }

        private String L(Date date) {
            return new SimpleDateFormat("dd/MM/yyyy", Locale.UK).format(date);
        }

        public void M(Date date) {
            this.f10486u.setText(L(date));
        }

        public void N(Date date) {
            if (date != null) {
                this.f10488w.setText(L(date));
            } else {
                this.f10488w.setText("");
            }
        }

        public void O(int i10) {
            this.f10485t.setText(String.valueOf(i10));
        }

        public void P(Date date) {
            if (date != null) {
                this.f10487v.setText(L(date));
            } else {
                this.f10487v.setText("");
            }
        }
    }

    public e(p6.d[] dVarArr) {
        this.f10484c = dVarArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f10484c.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void i(a aVar, int i10) {
        int length = this.f10484c.length - (i10 + 1);
        aVar.O(length + 1);
        if (this.f10484c[length].a() != null) {
            aVar.M(this.f10484c[length].a());
        }
        if (this.f10484c[length].f() == null || this.f10484c[length].f().b() == null || this.f10484c[length].f().a() == null) {
            return;
        }
        aVar.P(this.f10484c[length].f().b());
        aVar.N(this.f10484c[length].f().a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public a k(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.isolation_history_item, viewGroup, false));
    }
}
