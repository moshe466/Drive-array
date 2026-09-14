package f6;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.SerologyQuestionnaire;
import com.groboot.mdaemergency.ui.QuestionView;
import com.groboot.mdaemergency.ui.views.DateField;
import f6.x1;
import il.org.mda.health.R;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class x1 extends a6.a {
    public Map<Integer, View> A0;
    private SerologyQuestionnaire B0;
    private final String C0;
    private a D0;

    /* loaded from: classes.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(View view, x1 x1Var, b.a aVar) {
            y8.k.e(x1Var, "this$0");
            Toast.makeText(view.getContext(), aVar.f7614b ? "נשמר בהצלחה" : "נסה שנית", 0).show();
            androidx.fragment.app.j t10 = x1Var.t();
            y8.k.b(t10);
            t10.d0().Z0();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final View view2 = ((a6.a) x1.this).f306w0;
            final x1 x1Var = x1.this;
            int i10 = g5.h.f9838t;
            if (((QuestionView) view2.findViewById(i10)).e()) {
                int i11 = g5.h.f9831m;
                if (((QuestionView) view2.findViewById(i11)).e()) {
                    int i12 = g5.h.f9829k;
                    if (((QuestionView) view2.findViewById(i12)).e()) {
                        int i13 = g5.h.f9828j;
                        if (((QuestionView) view2.findViewById(i13)).e()) {
                            int i14 = g5.h.f9839u;
                            if (((QuestionView) view2.findViewById(i14)).e()) {
                                int i15 = g5.h.f9835q;
                                if (((QuestionView) view2.findViewById(i15)).e()) {
                                    int i16 = g5.h.f9837s;
                                    if (((QuestionView) view2.findViewById(i16)).e()) {
                                        int i17 = g5.h.f9833o;
                                        if (((QuestionView) view2.findViewById(i17)).e()) {
                                            int i18 = g5.h.f9836r;
                                            if (((QuestionView) view2.findViewById(i18)).e()) {
                                                int i19 = g5.h.f9832n;
                                                if (((QuestionView) view2.findViewById(i19)).e()) {
                                                    int i20 = g5.h.f9830l;
                                                    if (((QuestionView) view2.findViewById(i20)).e()) {
                                                        int i21 = g5.h.f9827i;
                                                        if (((QuestionView) view2.findViewById(i21)).e()) {
                                                            int i22 = g5.h.f9834p;
                                                            if (((QuestionView) view2.findViewById(i22)).e()) {
                                                                SerologyQuestionnaire t22 = x1Var.t2();
                                                                String b02 = w6.l0.b0(((DateField) view2.findViewById(g5.h.f9843y)).getDate());
                                                                y8.k.d(b02, "getString(dt_date.date)");
                                                                t22.setFirstSymptomDate(b02);
                                                                t22.setSymptomsSince022020(((QuestionView) view2.findViewById(i10)).getValue());
                                                                t22.setFeverOver38(((QuestionView) view2.findViewById(i11)).getValue());
                                                                t22.setCough(((QuestionView) view2.findViewById(i12)).getValue());
                                                                t22.setBreathingDifficulties(((QuestionView) view2.findViewById(i13)).getValue());
                                                                t22.setTiredness(((QuestionView) view2.findViewById(i14)).getValue());
                                                                t22.setShivering(((QuestionView) view2.findViewById(i15)).getValue());
                                                                t22.setSoreThroat(((QuestionView) view2.findViewById(i16)).getValue());
                                                                t22.setMusclePain(((QuestionView) view2.findViewById(i17)).getValue());
                                                                t22.setSnot(((QuestionView) view2.findViewById(i18)).getValue());
                                                                t22.setLossOfTaste(((QuestionView) view2.findViewById(i19)).getValue());
                                                                t22.setDiarrhea(((QuestionView) view2.findViewById(i20)).getValue());
                                                                t22.setAbdominalPain(((QuestionView) view2.findViewById(i21)).getValue());
                                                                t22.setOtherSymptoms(((QuestionView) view2.findViewById(i22)).getValue());
                                                                com.groboot.mdaemergency.async.d.v().g0(x1Var.t2(), new b.InterfaceC0098b() { // from class: f6.w1
                                                                    @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                                                                    public final void a(b.a aVar) {
                                                                        x1.a.b(view2, x1Var, aVar);
                                                                    }
                                                                });
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Toast.makeText(view2.getContext(), R.string.fillAllFeilds, 0).show();
        }
    }

    public x1(SerologyQuestionnaire serologyQuestionnaire) {
        y8.k.e(serologyQuestionnaire, "serologyQuestionnaire");
        this.A0 = new LinkedHashMap();
        this.B0 = serologyQuestionnaire;
        this.C0 = "QuestionnaireSerologyFr";
        this.D0 = new a();
    }

    private final Date s2() {
        Calendar calendar = Calendar.getInstance();
        y8.k.d(calendar, "getInstance()");
        calendar.set(1, 2020);
        calendar.set(2, 1);
        calendar.set(5, 1);
        Date time = calendar.getTime();
        y8.k.d(time, "cal.time");
        return time;
    }

    private final void u2() {
        com.groboot.mdaemergency.async.d.v().J(this.B0.getPatientKey(), new b.InterfaceC0098b() { // from class: f6.v1
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                x1.v2(x1.this, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(x1 x1Var, b.a aVar) {
        y8.k.e(x1Var, "this$0");
        if (aVar.f7614b) {
            try {
                SerologyQuestionnaire serologyQuestionnaire = (SerologyQuestionnaire) new com.google.gson.e().i(aVar.e("Content"), SerologyQuestionnaire.class);
                View view = x1Var.f306w0;
                ((DateField) view.findViewById(g5.h.f9843y)).setDate(w6.l0.C(serologyQuestionnaire.getFirstSymptomDate(), w6.l0.f15198k));
                ((QuestionView) view.findViewById(g5.h.f9838t)).setValue(serologyQuestionnaire.getSymptomsSince022020());
                ((QuestionView) view.findViewById(g5.h.f9831m)).setValue(serologyQuestionnaire.getFeverOver38());
                ((QuestionView) view.findViewById(g5.h.f9829k)).setValue(serologyQuestionnaire.getCough());
                ((QuestionView) view.findViewById(g5.h.f9828j)).setValue(serologyQuestionnaire.getBreathingDifficulties());
                ((QuestionView) view.findViewById(g5.h.f9839u)).setValue(serologyQuestionnaire.getTiredness());
                ((QuestionView) view.findViewById(g5.h.f9835q)).setValue(serologyQuestionnaire.getShivering());
                ((QuestionView) view.findViewById(g5.h.f9837s)).setValue(serologyQuestionnaire.getSoreThroat());
                ((QuestionView) view.findViewById(g5.h.f9833o)).setValue(serologyQuestionnaire.getMusclePain());
                ((QuestionView) view.findViewById(g5.h.f9836r)).setValue(serologyQuestionnaire.getSnot());
                ((QuestionView) view.findViewById(g5.h.f9832n)).setValue(serologyQuestionnaire.getLossOfTaste());
                ((QuestionView) view.findViewById(g5.h.f9830l)).setValue(serologyQuestionnaire.getDiarrhea());
                ((QuestionView) view.findViewById(g5.h.f9827i)).setValue(serologyQuestionnaire.getAbdominalPain());
                ((QuestionView) view.findViewById(g5.h.f9834p)).setValue(serologyQuestionnaire.getOtherSymptoms());
            } catch (com.google.gson.t e10) {
                String str = x1Var.C0;
                e10.toString();
            }
        }
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public /* synthetic */ void I0() {
        super.I0();
        q2();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        u2();
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_questionnaire_serology);
        View view = this.f306w0;
        ((Button) view.findViewById(g5.h.f9825g)).setOnClickListener(this.D0);
        int i10 = g5.h.f9843y;
        ((DateField) view.findViewById(i10)).setMaxDate(new Date());
        ((DateField) view.findViewById(i10)).setMinDate(s2());
    }

    @Override // a6.a
    public void o2() {
    }

    public void q2() {
        this.A0.clear();
    }

    public final SerologyQuestionnaire t2() {
        return this.B0;
    }
}
