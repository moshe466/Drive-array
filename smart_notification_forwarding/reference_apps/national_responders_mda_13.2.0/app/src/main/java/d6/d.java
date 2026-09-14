package d6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import il.org.mda.health.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class d extends androidx.fragment.app.e {

    /* renamed from: u0, reason: collision with root package name */
    b f8686u0;

    /* renamed from: v0, reason: collision with root package name */
    Date f8687v0;

    /* renamed from: w0, reason: collision with root package name */
    String f8688w0;

    /* renamed from: x0, reason: collision with root package name */
    c f8689x0;

    /* renamed from: y0, reason: collision with root package name */
    int f8690y0;

    /* renamed from: z0, reason: collision with root package name */
    boolean f8691z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ArrayAdapter<String> {

        /* renamed from: f, reason: collision with root package name */
        Context f8692f;

        public a(d dVar, Context context, ArrayList<String> arrayList) {
            super(context, R.layout.date_item, arrayList);
            this.f8692f = context;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) this.f8692f.getSystemService("layout_inflater")).inflate(R.layout.date_item, (ViewGroup) null);
            }
            ((TextView) view.findViewById(R.id.tv_value)).setText(getItem(i10));
            return view;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(Date date);
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener, AdapterView.OnItemClickListener {

        /* renamed from: f, reason: collision with root package name */
        GridView f8693f;

        /* renamed from: g, reason: collision with root package name */
        GridView f8694g;

        /* renamed from: h, reason: collision with root package name */
        GridView f8695h;

        /* renamed from: i, reason: collision with root package name */
        TextView f8696i;

        /* renamed from: j, reason: collision with root package name */
        TextView f8697j;

        /* renamed from: k, reason: collision with root package name */
        TextView f8698k;

        /* renamed from: l, reason: collision with root package name */
        TextView f8699l;

        /* renamed from: m, reason: collision with root package name */
        TextView f8700m;

        /* renamed from: n, reason: collision with root package name */
        TextView f8701n;

        /* renamed from: o, reason: collision with root package name */
        TextView f8702o;

        /* renamed from: p, reason: collision with root package name */
        TextView f8703p;

        /* renamed from: q, reason: collision with root package name */
        TextView f8704q;

        public c(View view) {
            View findViewById;
            this.f8703p = (TextView) view.findViewById(R.id.tv_title);
            this.f8693f = (GridView) view.findViewById(R.id.gv_days);
            this.f8694g = (GridView) view.findViewById(R.id.gv_month);
            this.f8695h = (GridView) view.findViewById(R.id.gv_years);
            this.f8696i = (TextView) view.findViewById(R.id.btn_ok);
            if (d.this.f8691z0) {
                this.f8697j = (TextView) view.findViewById(R.id.tv_d1);
                findViewById = view.findViewById(R.id.tv_d2);
            } else {
                this.f8697j = (TextView) view.findViewById(R.id.tv_d2);
                findViewById = view.findViewById(R.id.tv_d1);
            }
            this.f8698k = (TextView) findViewById;
            this.f8699l = (TextView) view.findViewById(R.id.tv_year);
            this.f8702o = (TextView) view.findViewById(R.id.btn_back);
            this.f8700m = (TextView) view.findViewById(R.id.tv_sep_1);
            this.f8701n = (TextView) view.findViewById(R.id.tv_sep_2);
            this.f8704q = (TextView) view.findViewById(R.id.tv_explation);
            this.f8696i.setOnClickListener(this);
            this.f8697j.setOnClickListener(this);
            this.f8698k.setOnClickListener(this);
            this.f8699l.setOnClickListener(this);
            this.f8702o.setOnClickListener(this);
            this.f8693f.setOnItemClickListener(this);
            this.f8694g.setOnItemClickListener(this);
            this.f8695h.setOnItemClickListener(this);
            a();
            b();
            onClick(d.this.f8691z0 ? this.f8697j : this.f8698k);
        }

        private void a() {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 1; i10 < 32; i10++) {
                arrayList.add(i10 + "");
            }
            d dVar = d.this;
            this.f8693f.setAdapter((ListAdapter) new a(dVar, dVar.t(), arrayList));
            ArrayList arrayList2 = new ArrayList();
            for (String str : d.this.Y().getStringArray(R.array.months)) {
                arrayList2.add(str);
            }
            d dVar2 = d.this;
            this.f8694g.setAdapter((ListAdapter) new a(dVar2, dVar2.t(), arrayList2));
            ArrayList arrayList3 = new ArrayList();
            for (int i11 = d.this.f8690y0; i11 > 1899; i11 += -1) {
                arrayList3.add(i11 + "");
            }
            d dVar3 = d.this;
            this.f8695h.setAdapter((ListAdapter) new a(dVar3, dVar3.t(), arrayList3));
        }

        private void b() {
            TextView textView;
            String format;
            d dVar = d.this;
            Date date = dVar.f8687v0;
            if (date == null) {
                format = "";
                this.f8697j.setText("");
                this.f8698k.setText("");
                textView = this.f8699l;
            } else {
                this.f8697j.setText(String.format("%02d", Integer.valueOf(dVar.k2(date))));
                TextView textView2 = this.f8698k;
                d dVar2 = d.this;
                textView2.setText(String.format("%02d", Integer.valueOf(dVar2.l2(dVar2.f8687v0))));
                textView = this.f8699l;
                d dVar3 = d.this;
                format = String.format("%04d", Integer.valueOf(dVar3.m2(dVar3.f8687v0)));
            }
            textView.setText(format);
            c();
            this.f8703p.setText(d.this.f8688w0);
            TextView textView3 = this.f8703p;
            String str = d.this.f8688w0;
            textView3.setVisibility((str == null || str.length() == 0) ? 8 : 0);
        }

        private void c() {
            this.f8700m.setText((this.f8697j.length() > 0 || this.f8698k.length() > 0) ? "/" : "");
            this.f8701n.setText((this.f8698k.length() > 0 || this.f8699l.length() > 0) ? "/" : "");
        }

        private Date d() {
            SimpleDateFormat simpleDateFormat;
            StringBuilder sb2;
            if (d.this.f8689x0.f8697j.getText().length() == 0) {
                Toast.makeText(d.this.t(), "נא לבחור יום", 1).show();
                onClick(this.f8697j);
                return null;
            }
            if (d.this.f8689x0.f8698k.getText().length() == 0) {
                Toast.makeText(d.this.t(), "נא לבחור חודש", 1).show();
                onClick(this.f8698k);
                return null;
            }
            if (d.this.f8689x0.f8699l.getText().length() == 0) {
                Toast.makeText(d.this.t(), "נא לבחור שנה", 1).show();
                onClick(this.f8699l);
                return null;
            }
            try {
                if (d.this.f8691z0) {
                    simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    sb2 = new StringBuilder();
                    sb2.append((Object) this.f8697j.getText());
                    sb2.append("/");
                    sb2.append((Object) this.f8698k.getText());
                    sb2.append("/");
                    sb2.append((Object) this.f8699l.getText());
                } else {
                    simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    sb2 = new StringBuilder();
                    sb2.append((Object) this.f8698k.getText());
                    sb2.append("/");
                    sb2.append((Object) this.f8697j.getText());
                    sb2.append("/");
                    sb2.append((Object) this.f8699l.getText());
                }
                Date parse = simpleDateFormat.parse(sb2.toString());
                if (this.f8697j.getText().equals(String.format("%02d", Integer.valueOf(d.this.k2(parse))))) {
                    return parse;
                }
                Toast.makeText(d.this.t(), "תאריך לא תקין", 1).show();
                onClick(this.f8697j);
                return null;
            } catch (Exception unused) {
                Toast.makeText(d.this.t(), "בעייה בנתונים", 1).show();
                return null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        
            r4.f8693f.setVisibility(8);
            r4.f8694g.setVisibility(0);
            r4.f8695h.setVisibility(8);
            r5 = r4.f8704q;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        
            if (r4.f8705r.f8691z0 == false) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
        
            if (r4.f8705r.f8691z0 != false) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
        
            r4.f8693f.setVisibility(0);
            r4.f8694g.setVisibility(8);
            r4.f8695h.setVisibility(8);
            r4.f8704q.setText(il.org.mda.health.R.string.setDay);
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r5) {
            /*
                r4 = this;
                int r5 = r5.getId()
                r0 = 2131755503(0x7f1001ef, float:1.9141887E38)
                r1 = 2131755502(0x7f1001ee, float:1.9141885E38)
                r2 = 0
                r3 = 8
                switch(r5) {
                    case 2131296410: goto L76;
                    case 2131296441: goto L65;
                    case 2131297271: goto L38;
                    case 2131297272: goto L31;
                    case 2131297326: goto L12;
                    default: goto L10;
                }
            L10:
                goto L84
            L12:
                android.widget.GridView r5 = r4.f8693f
                r5.setVisibility(r3)
                android.widget.GridView r5 = r4.f8694g
                r5.setVisibility(r3)
                android.widget.GridView r5 = r4.f8695h
                r5.setVisibility(r2)
                android.widget.GridView r5 = r4.f8695h
                r0 = 19
                r5.setSelection(r0)
                android.widget.TextView r5 = r4.f8704q
                r0 = 2131755504(0x7f1001f0, float:1.914189E38)
            L2d:
                r5.setText(r0)
                goto L84
            L31:
                d6.d r5 = d6.d.this
                boolean r5 = r5.f8691z0
                if (r5 == 0) goto L50
                goto L3e
            L38:
                d6.d r5 = d6.d.this
                boolean r5 = r5.f8691z0
                if (r5 != 0) goto L50
            L3e:
                android.widget.GridView r5 = r4.f8693f
                r5.setVisibility(r3)
                android.widget.GridView r5 = r4.f8694g
                r5.setVisibility(r2)
                android.widget.GridView r5 = r4.f8695h
                r5.setVisibility(r3)
                android.widget.TextView r5 = r4.f8704q
                goto L2d
            L50:
                android.widget.GridView r5 = r4.f8693f
                r5.setVisibility(r2)
                android.widget.GridView r5 = r4.f8694g
                r5.setVisibility(r3)
                android.widget.GridView r5 = r4.f8695h
                r5.setVisibility(r3)
                android.widget.TextView r5 = r4.f8704q
                r5.setText(r1)
                goto L84
            L65:
                java.util.Date r5 = r4.d()
                if (r5 != 0) goto L6c
                return
            L6c:
                d6.d r0 = d6.d.this
                d6.d$b r0 = r0.f8686u0
                if (r0 == 0) goto L7f
                r0.b(r5)
                goto L7f
            L76:
                d6.d r5 = d6.d.this
                d6.d$b r5 = r5.f8686u0
                if (r5 == 0) goto L7f
                r5.a()
            L7f:
                d6.d r5 = d6.d.this
                r5.W1()
            L84:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d6.d.c.onClick(android.view.View):void");
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            TextView textView;
            switch (adapterView.getId()) {
                case R.id.gv_days /* 2131296685 */:
                    this.f8697j.setText(String.format("%02d", Integer.valueOf(i10 + 1)));
                    c();
                    if (d.this.f8691z0) {
                        textView = this.f8698k;
                        onClick(textView);
                    }
                    break;
                case R.id.gv_items /* 2131296686 */:
                default:
                    return;
                case R.id.gv_month /* 2131296687 */:
                    this.f8698k.setText(String.format("%02d", Integer.valueOf(i10 + 1)));
                    c();
                    if (!d.this.f8691z0) {
                        textView = this.f8697j;
                        onClick(textView);
                    }
                    break;
                case R.id.gv_years /* 2131296688 */:
                    this.f8699l.setText(String.format("%04d", Integer.valueOf(d.this.f8690y0 - i10)));
                    c();
                    textView = this.f8696i;
                    onClick(textView);
            }
            textView = this.f8699l;
            onClick(textView);
        }
    }

    public d() {
    }

    @SuppressLint({"ValidFragment"})
    public d(Date date, String str, b bVar) {
        this.f8686u0 = bVar;
        this.f8688w0 = str;
        this.f8687v0 = date;
    }

    public static void n2(androidx.fragment.app.j jVar, Date date, String str, b bVar) {
        new d(date, str, bVar).i2(jVar.d0(), "DateDialog");
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Z1().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.date_dialog, viewGroup, false);
        this.f8691z0 = w6.m.m() != com.groboot.mdaemergency.enums.a.PHILIPINE;
        this.f8690y0 = j2();
        this.f8689x0 = new c(inflate);
        return inflate;
    }

    public int j2() {
        return m2(new Date());
    }

    public int k2(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(5);
    }

    public int l2(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(2) + 1;
    }

    public int m2(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }
}
