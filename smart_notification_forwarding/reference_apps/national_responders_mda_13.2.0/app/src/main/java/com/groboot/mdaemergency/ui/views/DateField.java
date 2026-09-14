package com.groboot.mdaemergency.ui.views;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import il.org.mda.health.R;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class DateField extends EditText {

    /* renamed from: f, reason: collision with root package name */
    private d f8313f;

    /* renamed from: g, reason: collision with root package name */
    public String f8314g;

    /* renamed from: h, reason: collision with root package name */
    public String f8315h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8316i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8317j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8318k;

    /* renamed from: l, reason: collision with root package name */
    private int f8319l;

    /* renamed from: m, reason: collision with root package name */
    private int f8320m;

    /* renamed from: n, reason: collision with root package name */
    private int f8321n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8322o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8323p;

    /* renamed from: q, reason: collision with root package name */
    private Date f8324q;

    /* renamed from: r, reason: collision with root package name */
    private Date f8325r;

    /* renamed from: s, reason: collision with root package name */
    private Date f8326s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8327t;

    /* renamed from: u, reason: collision with root package name */
    private Date f8328u;

    /* renamed from: v, reason: collision with root package name */
    private Context f8329v;

    /* renamed from: w, reason: collision with root package name */
    private String f8330w;

    /* renamed from: x, reason: collision with root package name */
    public static SimpleDateFormat f8310x = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: y, reason: collision with root package name */
    public static SimpleDateFormat f8311y = new SimpleDateFormat("dd/MM/yyyy");

    /* renamed from: z, reason: collision with root package name */
    public static SimpleDateFormat f8312z = new SimpleDateFormat("yyyy");
    public static SimpleDateFormat A = new SimpleDateFormat("MM");
    public static SimpleDateFormat B = new SimpleDateFormat("dd");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DateField.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements DatePickerDialog.OnDateSetListener {
        b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i10, int i11, int i12) {
            DateField.this.o(i10, i11 + 1, i12);
            if (DateField.this.f8313f != null) {
                d dVar = DateField.this.f8313f;
                DateField dateField = DateField.this;
                dVar.a(dateField, dateField.f8328u);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            DateField.this.f8327t = false;
            DateField.this.setDate("");
            if (DateField.this.f8313f != null) {
                DateField.this.f8313f.a(DateField.this, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(View view, Date date);
    }

    public DateField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8314g = "dd/MM/yyyy";
        this.f8329v = context;
        i(attributeSet, 0);
    }

    private int f(Date date) {
        try {
            return Integer.parseInt(B.format(date));
        } catch (Exception unused) {
            return 0;
        }
    }

    private int g(Date date) {
        try {
            return Integer.parseInt(A.format(date));
        } catch (Exception unused) {
            return 0;
        }
    }

    private Date getDefaultDate() {
        Date date = this.f8324q;
        if (date != null) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        boolean z10 = false;
        int i10 = this.f8319l;
        boolean z11 = true;
        if (i10 != 0) {
            calendar.add(1, i10 * (-1));
            z10 = true;
        }
        int i11 = this.f8320m;
        if (i11 != 0) {
            calendar.add(2, i11 * (-1));
            z10 = true;
        }
        int i12 = this.f8321n;
        if (i12 != 0) {
            calendar.add(6, i12 * (-1));
        } else {
            z11 = z10;
        }
        if (z11) {
            return calendar.getTime();
        }
        if (this.f8322o) {
            return new Date();
        }
        return null;
    }

    private int h(Date date) {
        try {
            return Integer.parseInt(f8312z.format(date));
        } catch (Exception unused) {
            return 0;
        }
    }

    private void i(AttributeSet attributeSet, int i10) {
        super.getText().toString();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g5.i.f9845a, i10, 0);
        String string = obtainStyledAttributes.getString(0);
        this.f8315h = string;
        if (string == null) {
            string = "";
        }
        this.f8315h = string;
        this.f8319l = obtainStyledAttributes.getInteger(5, 0);
        this.f8320m = obtainStyledAttributes.getInteger(3, 0);
        this.f8321n = obtainStyledAttributes.getInteger(2, 0);
        this.f8322o = obtainStyledAttributes.getBoolean(4, true);
        this.f8323p = obtainStyledAttributes.getBoolean(1, false);
        p(obtainStyledAttributes.getBoolean(10, true), obtainStyledAttributes.getBoolean(9, true), obtainStyledAttributes.getBoolean(7, true));
        this.f8314g = "";
        if (this.f8318k) {
            this.f8314g = "dd";
        }
        if (this.f8317j) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f8314g);
            sb2.append(this.f8314g.length() > 0 ? "/MM" : "MM");
            this.f8314g = sb2.toString();
        }
        if (this.f8316i) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f8314g);
            sb3.append(this.f8314g.length() > 0 ? "/yyyy" : "yyyy");
            this.f8314g = sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("format to show:");
        sb4.append(this.f8314g);
        setDate(new Date());
        if (getText().length() == 0 && this.f8322o) {
            setDate(new Date());
        }
        setKeyListener(null);
        if (isInEditMode()) {
            return;
        }
        super.setOnClickListener(new a());
    }

    private void k(DatePickerDialog datePickerDialog) {
        l(datePickerDialog, "mDaySpinner");
    }

    private void l(DatePickerDialog datePickerDialog, String str) {
        try {
            for (Field field : datePickerDialog.getClass().getDeclaredFields()) {
                if (field.getName().equals("mDatePicker")) {
                    field.setAccessible(true);
                    DatePicker datePicker = (DatePicker) field.get(datePickerDialog);
                    for (Field field2 : field.getType().getDeclaredFields()) {
                        field2.getName();
                        if (str.equals(field2.getName())) {
                            field2.setAccessible(true);
                            ((View) field2.get(datePicker)).setVisibility(8);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void m(DatePickerDialog datePickerDialog) {
        l(datePickerDialog, "mMonthSpinner");
    }

    private void n(DatePickerDialog datePickerDialog) {
        l(datePickerDialog, "mYearSpinner");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i10, int i11, int i12) {
        setDate(String.format("%02d", Integer.valueOf(i12)) + "/" + String.format("%02d", Integer.valueOf(i11)) + "/" + String.format("%04d", Integer.valueOf(i10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(String str) {
        StringBuilder sb2;
        StringBuilder sb3;
        if (str == null || str.length() == 0) {
            setDate((Date) null);
            return;
        }
        if (str.length() > 10) {
            str = str.substring(0, 10);
        }
        Date date = new Date();
        if (str.length() < 10) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("");
            sb4.append(str);
            if (this.f8314g.indexOf("dd") == -1) {
                int f10 = f(date);
                StringBuilder sb5 = new StringBuilder();
                if (f10 < 10) {
                    sb3 = new StringBuilder();
                    sb3.append(" ");
                    sb3.append(f10);
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(f10);
                    sb3.append("");
                }
                sb5.append(sb3.toString());
                sb5.append("/");
                sb5.append(str);
                str = sb5.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(str);
            }
            if (this.f8314g.indexOf("yyyy") == -1) {
                str = str + "/" + h(date);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                sb7.append(str);
            }
            if (this.f8314g.indexOf("MM") == -1) {
                int g10 = g(date);
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str.substring(0, 3));
                if (g10 < 10) {
                    sb2 = new StringBuilder();
                    sb2.append(" ");
                    sb2.append(g10);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(g10);
                    sb2.append("");
                }
                sb8.append(sb2.toString());
                sb8.append(str.substring(4));
                str = sb8.toString();
                StringBuilder sb9 = new StringBuilder();
                sb9.append("");
                sb9.append(str);
            }
        }
        try {
            try {
                setDate(f8311y.parse(str));
            } catch (Exception unused) {
                setDate(f8310x.parse(str));
            }
        } catch (Exception unused2) {
            setDate((Date) null);
        }
    }

    public Date getDate() {
        return this.f8328u;
    }

    public void j() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("format to show:");
        sb2.append(this.f8314g);
        if (isInEditMode()) {
            return;
        }
        Date date = this.f8328u;
        if (date == null) {
            date = getDefaultDate();
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.f8329v, 3, new b(), h(date), g(date) - 1, f(date));
        if (this.f8325r != null) {
            datePickerDialog.getDatePicker().setMinDate(this.f8325r.getTime());
        }
        if (this.f8326s != null) {
            datePickerDialog.getDatePicker().setMaxDate(this.f8326s.getTime());
        }
        String str = this.f8330w;
        if (str != null && str.length() > 0) {
            datePickerDialog.setTitle(this.f8330w);
        }
        if (this.f8323p) {
            datePickerDialog.setButton(-2, "נקה נתונים", new c());
        }
        if (!this.f8316i) {
            n(datePickerDialog);
        }
        if (!this.f8317j) {
            m(datePickerDialog);
        }
        if (!this.f8318k) {
            k(datePickerDialog);
        }
        datePickerDialog.show();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            j();
        }
    }

    public void p(boolean z10, boolean z11, boolean z12) {
        this.f8316i = z10;
        this.f8317j = z11;
        this.f8318k = z12;
        this.f8314g = "";
        if (z12) {
            this.f8314g = "dd";
        }
        if (z11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f8314g);
            sb2.append(this.f8314g.length() > 0 ? "/MM" : "MM");
            this.f8314g = sb2.toString();
        }
        if (z10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f8314g);
            sb3.append(this.f8314g.length() > 0 ? "/yyyy" : "yyyy");
            this.f8314g = sb3.toString();
        }
    }

    public void setDate(Date date) {
        this.f8328u = date;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f8314g);
        sb2.append(":");
        sb2.append(date == null ? "" : f8310x.format(date));
        String format = date == null ? "" : new SimpleDateFormat(this.f8314g).format(date);
        String str = this.f8315h;
        if (str == null || str.length() <= 0) {
            setText(format);
        } else {
            setTextColor(getResources().getColor(format.length() > 0 ? R.color.grayDarkDark : R.color.gray_light));
            setText(format.length() > 0 ? format : "");
        }
    }

    public void setDefaultDate(Date date) {
        this.f8324q = date;
    }

    public void setDialogTitle(String str) {
        this.f8330w = str;
    }

    public void setFormat(String str) {
        if (str == null) {
            str = "";
        }
        p(str.indexOf("d") > -1, str.indexOf("M") > -1, str.indexOf("y") > -1);
        this.f8314g = str;
    }

    public void setMaxDate(Date date) {
        this.f8326s = date;
    }

    public void setMinDate(Date date) {
        this.f8325r = date;
    }

    public void setOnDateChange(d dVar) {
        this.f8313f = dVar;
    }
}
