package h6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.ui.isolation_report_system.views.covid_test.CovidTestResultView;
import com.groboot.mdaemergency.ui.isolation_report_system.views.covid_test.CovidTestTypeView;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.NativeDatePickerView;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.SaveCancelFormView;
import h6.c;
import il.org.mda.health.R;
import java.util.Calendar;
import java.util.Date;
import o6.i;
import p6.b;

/* loaded from: classes.dex */
public class c extends RecyclerView.g<a> {

    /* renamed from: c, reason: collision with root package name */
    private p6.b[] f10469c;

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.d0 {

        /* renamed from: t, reason: collision with root package name */
        private final TextView f10470t;

        /* renamed from: u, reason: collision with root package name */
        private final CovidTestTypeView f10471u;

        /* renamed from: v, reason: collision with root package name */
        private final NativeDatePickerView f10472v;

        /* renamed from: w, reason: collision with root package name */
        private final CovidTestResultView f10473w;

        /* renamed from: x, reason: collision with root package name */
        private final SaveCancelFormView f10474x;

        /* renamed from: y, reason: collision with root package name */
        private p6.b f10475y;

        /* renamed from: z, reason: collision with root package name */
        private int f10476z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h6.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0187a implements o6.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f10477a;

            C0187a(View view) {
                this.f10477a = view;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void d(View view, b.a aVar) {
                Context context;
                Context context2;
                int i10;
                String str = aVar.f7616d;
                if (aVar.f7614b) {
                    a aVar2 = a.this;
                    aVar2.R(aVar2.f10475y.b());
                    i6.b.f().k(a.this.f10475y, a.this.f10476z);
                    context = view.getContext();
                    context2 = view.getContext();
                    i10 = R.string.test_updated_text;
                } else {
                    a.this.f10474x.setLoading(false);
                    a.this.f10473w.setEnabled(true);
                    context = view.getContext();
                    context2 = view.getContext();
                    i10 = R.string.an_error_occurred;
                }
                Toast.makeText(context, context2.getText(i10), 0).show();
            }

            @Override // o6.f
            public void a() {
            }

            @Override // o6.f
            public void b() {
                a.this.f10474x.setLoading(true);
                a.this.f10473w.setEnabled(false);
                try {
                    i6.a aVar = new i6.a(j6.a.UPDATE_COVID_TEST, a.this.f10475y);
                    final View view = this.f10477a;
                    aVar.d(new b.InterfaceC0098b() { // from class: h6.b
                        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                        public final void a(b.a aVar2) {
                            c.a.C0187a.this.d(view, aVar2);
                        }
                    });
                } catch (Exception e10) {
                    e10.toString();
                    a.this.f10474x.setLoading(false);
                    a.this.f10473w.setEnabled(true);
                    Toast.makeText(this.f10477a.getContext(), this.f10477a.getContext().getText(R.string.an_error_occurred), 0).show();
                }
            }
        }

        public a(View view) {
            super(view);
            this.f10470t = (TextView) view.findViewById(R.id.txv_covid_test_serial_number);
            this.f10471u = (CovidTestTypeView) view.findViewById(R.id.ctt_select_test_type);
            this.f10472v = (NativeDatePickerView) view.findViewById(R.id.ndp_select_test_date);
            this.f10473w = (CovidTestResultView) view.findViewById(R.id.ctr_select_test_result);
            SaveCancelFormView saveCancelFormView = (SaveCancelFormView) view.findViewById(R.id.scf_save_test_form);
            this.f10474x = saveCancelFormView;
            saveCancelFormView.setMode(SaveCancelFormView.b.SAVE);
            saveCancelFormView.setOnSaveCancelListener(new C0187a(view));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Q(b.a aVar, b.a aVar2) {
            SaveCancelFormView saveCancelFormView;
            int i10;
            this.f10475y.f(aVar2);
            if (aVar2 != aVar) {
                saveCancelFormView = this.f10474x;
                i10 = 0;
            } else {
                saveCancelFormView = this.f10474x;
                i10 = 8;
            }
            saveCancelFormView.setVisibility(i10);
        }

        public void R(final b.a aVar) {
            this.f10471u.setEnabled(false);
            this.f10472v.setEnabled(false);
            this.f10474x.setVisibility(8);
            if (aVar == b.a.NONE) {
                this.f10473w.setOnTestResultSelectedListener(new i() { // from class: h6.a
                    @Override // o6.i
                    public final void a(b.a aVar2) {
                        c.a.this.Q(aVar, aVar2);
                    }
                });
            } else {
                this.f10473w.setEnabled(false);
            }
        }

        public void S(String str) {
            this.f10470t.setText(str);
        }

        public void T(p6.b bVar, int i10) {
            this.f10475y = bVar;
            this.f10476z = i10;
        }

        public void U(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            this.f10472v.h(calendar.get(1), calendar.get(2), calendar.get(5));
        }

        public void V(b.a aVar) {
            this.f10473w.setTestResult(aVar);
        }

        public void W(b.EnumC0271b enumC0271b) {
            this.f10471u.setTestType(enumC0271b);
        }
    }

    public c(p6.b[] bVarArr) {
        this.f10469c = bVarArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f10469c.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void i(a aVar, int i10) {
        p6.b[] bVarArr = this.f10469c;
        int length = bVarArr.length - (i10 + 1);
        p6.b bVar = bVarArr[length];
        aVar.T(bVar, i10);
        aVar.R(bVar.b());
        aVar.S(Integer.toString(length + 1));
        aVar.W(bVar.c());
        if (bVar.a() != null) {
            aVar.U(bVar.a());
        }
        aVar.V(bVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public a k(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item_covid_test, viewGroup, false));
    }
}
