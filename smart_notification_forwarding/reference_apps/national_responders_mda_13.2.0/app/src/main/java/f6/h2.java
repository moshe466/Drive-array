package f6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import c6.o;
import com.google.android.gms.maps.model.LatLng;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.models.Address;
import com.groboot.mdaemergency.models.OnCallParameter;
import com.groboot.mdaemergency.models.OnCallParameterAnswer;
import com.groboot.mdaemergency.models.location.ReportLocationParams;
import com.groboot.mdaemergency.ui.views.ClearableAutoCompleteTextView;
import f6.h2;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s5.d;

/* loaded from: classes.dex */
public class h2 extends androidx.fragment.app.e {
    EditText A0;
    EditText B0;
    ImageView C0;
    List<Button> D0;
    LinearLayout E0;
    public c F0;
    private Context G0;
    View.OnClickListener H0;
    View.OnClickListener I0;
    View.OnClickListener J0;
    View.OnClickListener K0;

    /* renamed from: u0, reason: collision with root package name */
    OnCallParameter f9505u0;

    /* renamed from: v0, reason: collision with root package name */
    ClearableAutoCompleteTextView f9506v0;

    /* renamed from: w0, reason: collision with root package name */
    TextView f9507w0;

    /* renamed from: x0, reason: collision with root package name */
    TextView f9508x0;

    /* renamed from: y0, reason: collision with root package name */
    TextView f9509y0;

    /* renamed from: z0, reason: collision with root package name */
    TextView f9510z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f6.h2$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0163a implements d.e {
            C0163a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e(b.a aVar) {
                if (aVar == null || !aVar.f7614b) {
                    Toast.makeText(h2.this.t(), R.string.try_again, 0).show();
                    return;
                }
                ReportLocationParams reportLocationParams = (ReportLocationParams) new com.google.gson.e().i(aVar.e("Location"), ReportLocationParams.class);
                h2.this.f9506v0.setText(reportLocationParams.Street + ", " + reportLocationParams.City);
                if (h2.this.G0 != null) {
                    h2 h2Var = h2.this;
                    h2Var.C0.setColorFilter(androidx.core.content.a.d(h2Var.G0, R.color.mada_red), PorterDuff.Mode.MULTIPLY);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(Location location, String str, Location location2) {
                if (str == null) {
                    com.groboot.mdaemergency.async.d.v().A(new ReportLocationParams(location), new b.InterfaceC0098b() { // from class: f6.f2
                        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                        public final void a(b.a aVar) {
                            h2.a.C0163a.this.e(aVar);
                        }
                    });
                    return;
                }
                h2.this.f9506v0.setText(str);
                OnCallParameter onCallParameter = h2.this.f9505u0;
                onCallParameter.Address = str;
                onCallParameter.Lat = location.getLatitude();
                h2.this.f9505u0.Lon = location.getLongitude();
                if (h2.this.G0 != null) {
                    h2 h2Var = h2.this;
                    h2Var.C0.setColorFilter(androidx.core.content.a.d(h2Var.G0, R.color.mada_red), PorterDuff.Mode.SRC_IN);
                }
            }

            @Override // s5.d.e
            public void a(Location location) {
            }

            @Override // s5.d.e
            public void b(final Location location) {
                w6.o.a(h2.this.G0, location, new o5.e() { // from class: f6.g2
                    @Override // o5.e
                    public final void a(String str, Location location2) {
                        h2.a.C0163a.this.f(location, str, location2);
                    }
                });
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h2 h2Var = h2.this;
            h2Var.C0.setColorFilter(androidx.core.content.a.d(h2Var.A(), R.color.blue_text), PorterDuff.Mode.MULTIPLY);
            s5.d.j().g(h2.this.t(), new C0163a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(OnCallParameterAnswer onCallParameterAnswer, Address address) {
            if (onCallParameterAnswer.Message != null) {
                Toast.makeText(h2.this.A(), onCallParameterAnswer.Message, 0).show();
            }
            if (onCallParameterAnswer.Success) {
                if (address != null && address.isFullFields()) {
                    h2.this.s2(address);
                }
                c cVar = h2.this.F0;
                if (cVar != null) {
                    cVar.a();
                }
                h2.this.W1();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(final OnCallParameterAnswer onCallParameterAnswer) {
            final Address address;
            if (onCallParameterAnswer.Success) {
                com.groboot.mdaemergency.async.d.v().f7636f.HasOnCallDrive = true;
                OnCallParameter onCallParameter = h2.this.f9505u0;
                address = new Address(onCallParameter.Address, onCallParameter.Lat, onCallParameter.Lon);
                if (address.isFullFields()) {
                    h2.this.C2();
                }
            } else {
                address = null;
            }
            if (h2.this.m0()) {
                h2.this.t().runOnUiThread(new Runnable() { // from class: f6.j2
                    @Override // java.lang.Runnable
                    public final void run() {
                        h2.b.this.c(onCallParameterAnswer, address);
                    }
                });
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (w6.l0.l0(h2.this.A0.getText().toString()) || w6.l0.l0(h2.this.f9506v0.getText().toString())) {
                Toast.makeText(h2.this.A(), h2.this.e0(R.string.fillAllFeilds), 0).show();
                return;
            }
            h2.this.f9505u0.VehicleCode = w6.l0.U(r4.A0.getText().toString());
            h2 h2Var = h2.this;
            h2Var.f9505u0.Comment = h2Var.B0.getText().toString();
            com.groboot.mdaemergency.async.d.v().T(h2.this.f9505u0, new d.r() { // from class: f6.i2
                @Override // com.groboot.mdaemergency.async.d.r
                public final void a(OnCallParameterAnswer onCallParameterAnswer) {
                    h2.b.this.d(onCallParameterAnswer);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    public h2() {
        this.f9505u0 = new OnCallParameter();
        this.D0 = new ArrayList();
        this.H0 = new a();
        this.I0 = new View.OnClickListener() { // from class: f6.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h2.this.w2(view);
            }
        };
        this.J0 = new b();
        this.K0 = new View.OnClickListener() { // from class: f6.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h2.this.z2(view);
            }
        };
    }

    @SuppressLint({"ValidFragment"})
    public h2(OnCallParameter onCallParameter) {
        this.f9505u0 = new OnCallParameter();
        this.D0 = new ArrayList();
        this.H0 = new a();
        this.I0 = new View.OnClickListener() { // from class: f6.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h2.this.w2(view);
            }
        };
        this.J0 = new b();
        this.K0 = new View.OnClickListener() { // from class: f6.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h2.this.z2(view);
            }
        };
        this.f9505u0 = onCallParameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2(int i10) {
        if (i10 != 0 || this.f9506v0.length() <= 0) {
            return;
        }
        this.f9506v0.setText(this.f9506v0.getText().toString().substring(0, r4.length() - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B2(c6.o oVar, AdapterView adapterView, View view, int i10, long j10) {
        String item = oVar.getItem(i10);
        LatLng b10 = w6.o.b(A(), item);
        if (b10 != null) {
            OnCallParameter onCallParameter = this.f9505u0;
            onCallParameter.Address = item;
            onCallParameter.Lat = b10.f5781f;
            onCallParameter.Lon = b10.f5782g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C2() {
        ArrayList arrayList = new ArrayList();
        Iterator<Button> it = this.D0.iterator();
        while (it.hasNext()) {
            arrayList.add((Address) it.next().getTag());
        }
        w6.m.d0(arrayList);
    }

    public static void D2(androidx.fragment.app.j jVar, OnCallParameter onCallParameter, c cVar) {
        if (jVar == null) {
            return;
        }
        try {
            h2 h2Var = new h2(onCallParameter);
            h2Var.i2(jVar.d0(), "SettingBikeFragment");
            h2Var.F0 = cVar;
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(Button button, View view) {
        this.f9506v0.setText(button.getText());
        Address address = (Address) button.getTag();
        OnCallParameter onCallParameter = this.f9505u0;
        onCallParameter.Address = address.description;
        onCallParameter.Lat = address.lat;
        onCallParameter.Lon = address.lon;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(View view) {
        W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2(OnCallParameterAnswer onCallParameterAnswer) {
        String str = onCallParameterAnswer.Message;
        if (str != null) {
            Toast.makeText(A(), str, 0).show();
        }
        c cVar = this.F0;
        if (cVar != null) {
            cVar.a();
        }
        W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2(final OnCallParameterAnswer onCallParameterAnswer) {
        if (onCallParameterAnswer == null) {
            Toast.makeText(A(), R.string.try_again, 0).show();
        }
        if (!m0() || t() == null) {
            return;
        }
        t().runOnUiThread(new Runnable() { // from class: f6.e2
            @Override // java.lang.Runnable
            public final void run() {
                h2.this.x2(onCallParameterAnswer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2(View view) {
        com.groboot.mdaemergency.async.d.v().b(new d.r() { // from class: f6.d2
            @Override // com.groboot.mdaemergency.async.d.r
            public final void a(OnCallParameterAnswer onCallParameterAnswer) {
                h2.this.y2(onCallParameterAnswer);
            }
        });
    }

    public void E2() {
        TextView textView;
        OnCallParameter onCallParameter = this.f9505u0;
        int i10 = 8;
        if (onCallParameter != null) {
            EditText editText = this.A0;
            long j10 = onCallParameter.VehicleCode;
            String str = "";
            if (j10 > 0) {
                str = this.f9505u0.VehicleCode + "";
            }
            editText.setText(str);
            OnCallParameter onCallParameter2 = this.f9505u0;
            if (onCallParameter2.HasOnCallDrive) {
                this.f9506v0.setText(onCallParameter2.Address);
                this.B0.setText(this.f9505u0.Comment);
                this.f9509y0.setText(R.string.update_shift_data_);
                textView = this.f9510z0;
                i10 = 0;
                textView.setVisibility(i10);
            }
        }
        this.f9509y0.setText(R.string.start_shift);
        textView = this.f9510z0;
        textView.setVisibility(i10);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_setting_bike, viewGroup, false);
        if (Z1() != null && Z1().getWindow() != null) {
            Z1().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            Z1().getWindow().requestFeature(1);
        }
        this.f9506v0 = (ClearableAutoCompleteTextView) inflate.findViewById(R.id.autocomplete);
        this.f9507w0 = (TextView) inflate.findViewById(R.id.txt_description);
        this.A0 = (EditText) inflate.findViewById(R.id.et_operationalCode);
        this.B0 = (EditText) inflate.findViewById(R.id.et_comment);
        this.C0 = (ImageView) inflate.findViewById(R.id.img_currentLocation);
        this.E0 = (LinearLayout) inflate.findViewById(R.id.ll_btnAddresses);
        this.f9508x0 = (TextView) inflate.findViewById(R.id.tv_lastAddresses);
        this.f9509y0 = (TextView) inflate.findViewById(R.id.btn_startShift);
        this.f9510z0 = (TextView) inflate.findViewById(R.id.btn_stopShift);
        final c6.o oVar = new c6.o(A(), R.layout.autocomplete_list_item);
        oVar.f4447i = new o.b() { // from class: f6.c2
            @Override // c6.o.b
            public final void a(int i10) {
                h2.this.A2(i10);
            }
        };
        this.f9506v0.setAdapter(oVar);
        this.f9506v0.setThreshold(1);
        this.f9506v0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: f6.b2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                h2.this.B2(oVar, adapterView, view, i10, j10);
            }
        });
        OnCallParameter onCallParameter = this.f9505u0;
        String str = onCallParameter.UserName;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (onCallParameter.BeeperNumber > 0) {
            str2 = this.f9505u0.BeeperNumber + "";
        }
        String phone = w6.m.k().getPhone();
        this.f9507w0.setText(e0(R.string.heloooo) + " " + str + ",\n" + e0(R.string.biffer_code) + ": " + str2 + "\n" + e0(R.string.phone) + ": " + phone);
        this.f9509y0.setOnClickListener(this.J0);
        this.f9510z0.setOnClickListener(this.K0);
        inflate.findViewById(R.id.img_close).setOnClickListener(this.I0);
        this.C0.setOnClickListener(this.H0);
        this.E0.setLayoutDirection(1);
        u2();
        E2();
        return inflate;
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        this.G0 = null;
    }

    public void s2(Address address) {
        Iterator<Button> it = this.D0.iterator();
        while (it.hasNext()) {
            if (((Address) it.next().getTag()).equals(address)) {
                return;
            }
        }
        if (this.D0.size() < 3) {
            t2(address, this.D0.size());
            return;
        }
        t2(address, 0);
        Button button = this.D0.get(r3.size() - 1);
        this.E0.removeView(button);
        this.D0.remove(button);
    }

    public void t2(Address address, int i10) {
        final Button button = new Button(A());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, w6.l0.W0(A(), 40));
        layoutParams.setMarginEnd(w6.l0.W0(A(), 4));
        button.setLayoutParams(layoutParams);
        button.setMaxWidth(w6.l0.W0(A(), 70));
        button.setText(address.description);
        button.setSingleLine();
        button.setTag(address);
        button.setBackgroundResource(R.drawable.rounded_btn);
        button.setPadding(w6.l0.W0(A(), 4), 0, w6.l0.W0(A(), 4), 0);
        button.setOnClickListener(new View.OnClickListener() { // from class: f6.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h2.this.v2(button, view);
            }
        });
        this.D0.add(i10, button);
        this.E0.addView(button);
    }

    public void u2() {
        List<Address> n10 = w6.m.n();
        if (n10 == null || n10.size() == 0) {
            this.f9508x0.setVisibility(8);
            return;
        }
        this.f9508x0.setVisibility(0);
        for (int i10 = 0; i10 < w6.m.n().size(); i10++) {
            Address address = n10.get(i10);
            if (address.isFullFields()) {
                t2(address, i10);
            }
        }
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public void y0(Context context) {
        super.y0(context);
        this.G0 = context;
    }
}
