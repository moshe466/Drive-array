package g6;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_test.CovidTestItemFragment;
import g6.i;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class i extends a6.a {
    private RecyclerView A0;
    private h6.c B0;
    private TextView C0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements o6.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CovidTestItemFragment f9866a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Button f9867b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f9868c;

        a(CovidTestItemFragment covidTestItemFragment, Button button, View view) {
            this.f9866a = covidTestItemFragment;
            this.f9867b = button;
            this.f9868c = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(CovidTestItemFragment covidTestItemFragment, p6.b bVar, Button button, View view, b.a aVar) {
            Context A;
            i iVar;
            int i10;
            String str = aVar.f7616d;
            covidTestItemFragment.h2(true);
            if (aVar.f7614b) {
                bVar.e(Integer.parseInt(aVar.a().getResult()));
                i6.b.f().a(bVar);
                covidTestItemFragment.a2();
                button.setEnabled(true);
                view.setVisibility(8);
                i.this.C0.setVisibility(8);
                i.this.B0 = new h6.c((p6.b[]) i6.b.f().d().toArray(new p6.b[0]));
                i.this.A0.t1(i.this.B0, true);
                A = i.this.A();
                iVar = i.this;
                i10 = R.string.test_added_text;
            } else {
                A = i.this.A();
                iVar = i.this;
                i10 = R.string.an_error_occurred;
            }
            Toast.makeText(A, iVar.g0(i10), 0).show();
        }

        @Override // o6.f
        public void a() {
            this.f9867b.setEnabled(true);
            this.f9868c.setVisibility(8);
        }

        @Override // o6.f
        public void b() {
            this.f9866a.i2(true);
            this.f9866a.h2(false);
            final p6.b b22 = this.f9866a.b2();
            try {
                i6.a aVar = new i6.a(j6.a.ADD_COVID_TEST, b22);
                final CovidTestItemFragment covidTestItemFragment = this.f9866a;
                final Button button = this.f9867b;
                final View view = this.f9868c;
                aVar.d(new b.InterfaceC0098b() { // from class: g6.h
                    @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                    public final void a(b.a aVar2) {
                        i.a.this.d(covidTestItemFragment, b22, button, view, aVar2);
                    }
                });
            } catch (Exception e10) {
                e10.toString();
                this.f9866a.h2(true);
                Toast.makeText(i.this.A(), i.this.g0(R.string.an_error_occurred), 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u2(View view, Button button, View view2) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
            view.setVisibility(8);
        }
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        TextView textView;
        int i10;
        super.W0();
        final Button button = (Button) k2(R.id.btn_add_covid_test);
        final View k22 = k2(R.id.frg_add_new_covid_test);
        CovidTestItemFragment covidTestItemFragment = (CovidTestItemFragment) z().h0(R.id.frg_add_new_covid_test);
        if (i6.b.f().d().size() == 0) {
            textView = this.C0;
            i10 = 0;
        } else {
            textView = this.C0;
            i10 = 8;
        }
        textView.setVisibility(i10);
        button.setOnClickListener(new View.OnClickListener() { // from class: g6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.u2(k22, button, view);
            }
        });
        if (covidTestItemFragment != null) {
            covidTestItemFragment.g2(String.valueOf(i6.b.f().d().size() + 1));
            covidTestItemFragment.j2(new a(covidTestItemFragment, button, k22));
        }
    }

    @Override // a6.a
    public void n2() {
        super.B0(this.f307x0);
        l2(R.layout.fragment_report_covid_test);
        setTitle(R.string.report_covid_test_title);
        this.A0 = (RecyclerView) k2(R.id.rcv_covid_tests);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(A(), 1, false);
        this.B0 = new h6.c((p6.b[]) i6.b.f().d().toArray(new p6.b[0]));
        this.A0.setLayoutManager(linearLayoutManager);
        this.A0.m0();
        this.A0.setAdapter(this.B0);
        this.C0 = (TextView) k2(R.id.txv_no_covtest_history);
        if (i6.b.f().d().size() == 0) {
            this.C0.setVisibility(0);
        } else {
            this.C0.setVisibility(8);
        }
    }

    @Override // a6.a
    public void o2() {
    }
}
