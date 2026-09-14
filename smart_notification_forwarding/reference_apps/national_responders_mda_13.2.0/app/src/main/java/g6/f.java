package g6;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.Answer;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class f extends a6.a {
    private RecyclerView A0;
    private LinearLayoutManager B0;
    private h6.e C0;
    private ProgressBar D0;
    private TextView E0;
    private Button F0;
    private Button G0;
    private Button H0;

    private void A2(boolean z10, boolean z11) {
        this.H0.setEnabled((z10 || z11) ? false : true);
        this.F0.setEnabled((z10 || z11) ? false : true);
        this.G0.setEnabled((z10 || z11) ? false : true);
        if (z10) {
            this.D0.setVisibility(0);
            this.E0.setVisibility(8);
            this.A0.setVisibility(8);
            return;
        }
        this.D0.setVisibility(8);
        if ((i6.b.f().e() == null || i6.b.f().e().size() == 0) && !z11) {
            this.E0.setText(g0(R.string.no_expo_history));
            this.E0.setVisibility(0);
            return;
        }
        TextView textView = this.E0;
        if (z11) {
            textView.setVisibility(0);
            this.E0.setText(g0(R.string.try_again_error_message));
        } else {
            textView.setVisibility(8);
            this.A0.setVisibility(0);
        }
    }

    private void B2() {
        h6.e eVar = new h6.e((p6.d[]) i6.b.f().e().toArray(new p6.d[0]));
        this.C0 = eVar;
        this.A0.t1(eVar, true);
    }

    private void u2() {
        A2(true, false);
        new i6.a(j6.a.GET_USER_REPORTS).d(new b.InterfaceC0098b() { // from class: g6.e
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                f.this.v2(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(b.a aVar) {
        if (aVar.f7614b) {
            p6.g gVar = (p6.g) w6.j.a(((Answer) w6.j.a(aVar.f7616d, Answer.class)).getResult(), p6.g.class);
            if (gVar != null) {
                i6.b f10 = i6.b.f();
                f10.i(gVar.a());
                f10.h(gVar.c());
                f10.j(gVar.b());
            }
            B2();
        }
        A2(false, !aVar.f7614b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(View view) {
        o(new q(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2(View view) {
        o(new w(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2(View view) {
        o(new i(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2(View view) {
        u2();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        B2();
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_main_isolation_system);
        setTitle(R.string.main_report_isolation_title);
        this.D0 = (ProgressBar) k2(R.id.prg_load_user_data);
        this.E0 = (TextView) k2(R.id.txv_no_expo_history);
        Button button = (Button) k2(R.id.btn_report_exposure);
        this.F0 = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: g6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.w2(view);
            }
        });
        Button button2 = (Button) k2(R.id.btn_report_positive_result);
        this.G0 = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: g6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.x2(view);
            }
        });
        Button button3 = (Button) k2(R.id.btn_report_test);
        this.H0 = button3;
        button3.setOnClickListener(new View.OnClickListener() { // from class: g6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.y2(view);
            }
        });
        this.E0.setOnClickListener(new View.OnClickListener() { // from class: g6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.z2(view);
            }
        });
        this.A0 = (RecyclerView) k2(R.id.rcv_isolation_history);
        this.B0 = new LinearLayoutManager(A(), 0, false);
        this.C0 = new h6.e((p6.d[]) i6.b.f().e().toArray(new p6.d[0]));
        if (A() != null) {
            int dimensionPixelSize = Y().getDimensionPixelSize(R.dimen.dot_indicator_radius);
            int dimensionPixelSize2 = Y().getDimensionPixelSize(R.dimen.dot_indicator_height);
            int d10 = androidx.core.content.a.d(A(), R.color.dot_indicator_color);
            this.A0.i(new h6.d(dimensionPixelSize, dimensionPixelSize * 4, dimensionPixelSize2, d10, d10));
        }
        new androidx.recyclerview.widget.h().b(this.A0);
        this.A0.setLayoutManager(this.B0);
        this.A0.m0();
        this.A0.setAdapter(this.C0);
        u2();
    }

    @Override // a6.a
    public void o2() {
    }
}
