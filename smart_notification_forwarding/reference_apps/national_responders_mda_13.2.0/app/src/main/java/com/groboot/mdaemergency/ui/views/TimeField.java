package com.groboot.mdaemergency.ui.views;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import androidx.fragment.app.w;
import com.groboot.mdaemergency.ui.views.TimeField;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class TimeField extends EditText {

    /* renamed from: n, reason: collision with root package name */
    public static SimpleDateFormat f8393n = new SimpleDateFormat("HH:mm");

    /* renamed from: f, reason: collision with root package name */
    private String f8394f;

    /* renamed from: g, reason: collision with root package name */
    private d f8395g;

    /* renamed from: h, reason: collision with root package name */
    private String f8396h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8397i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8398j;

    /* renamed from: k, reason: collision with root package name */
    Integer f8399k;

    /* renamed from: l, reason: collision with root package name */
    Integer f8400l;

    /* renamed from: m, reason: collision with root package name */
    boolean f8401m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimeField.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            TimeField.this.f8397i = false;
            TimeField.this.setTime("");
            if (TimeField.this.f8395g != null) {
                Calendar calendar = Calendar.getInstance();
                TimeField.this.f8395g.b(TimeField.this, calendar.get(11), calendar.get(12));
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
            TimeField.this.f8397i = true;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void b(View view, int i10, int i11);
    }

    public TimeField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8396h = "";
        this.f8401m = true;
        d(attributeSet, 0);
    }

    private void d(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g5.i.f9846b, i10, 0);
        setTime(new Date());
        if (obtainStyledAttributes.hasValue(1)) {
            this.f8399k = Integer.valueOf(obtainStyledAttributes.getInteger(1, 0));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get hourOfDay from xml:");
            sb2.append(this.f8399k);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f8400l = Integer.valueOf(obtainStyledAttributes.getInteger(3, 0));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("get minute from xml:");
            sb3.append(this.f8400l);
        }
        this.f8401m = obtainStyledAttributes.getBoolean(2, true);
        if (obtainStyledAttributes.hasValue(4)) {
            this.f8396h = obtainStyledAttributes.getString(4);
        }
        this.f8398j = false;
        obtainStyledAttributes.recycle();
        g(this.f8399k, this.f8400l);
        setKeyListener(null);
        if (isInEditMode()) {
            return;
        }
        setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(TimePicker timePicker, int i10, int i11) {
        g(Integer.valueOf(i10), Integer.valueOf(i11));
        d dVar = this.f8395g;
        if (dVar != null) {
            dVar.b(this, i10, i11);
        }
    }

    public void f() {
        if (isInEditMode()) {
            return;
        }
        Integer num = this.f8399k;
        int intValue = num == null ? Calendar.getInstance().get(11) : num.intValue();
        Integer num2 = this.f8400l;
        int intValue2 = num2 == null ? Calendar.getInstance().get(12) : num2.intValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("openDialog defaultHourOfDay:");
        sb2.append(intValue);
        sb2.append(" defaultMinute:");
        sb2.append(intValue2);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), 3, new TimePickerDialog.OnTimeSetListener() { // from class: v6.n
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i10, int i11) {
                TimeField.this.e(timePicker, i10, i11);
            }
        }, intValue, intValue2, this.f8401m);
        String str = this.f8396h;
        if (str != null && str.length() > 0) {
            timePickerDialog.setTitle(this.f8396h);
        }
        if (this.f8398j) {
            timePickerDialog.setButton(-2, "נקה בחירה", new b());
        }
        timePickerDialog.setButton(-1, "בחר", new c());
        timePickerDialog.show();
    }

    public void g(Integer num, Integer num2) {
        String format;
        this.f8399k = num;
        this.f8400l = num2;
        if (num2 == null && num == null) {
            format = "";
        } else {
            Calendar calendar = Calendar.getInstance();
            if (this.f8399k != null) {
                calendar.set(11, num.intValue());
            }
            if (this.f8400l != null) {
                calendar.set(12, num2.intValue());
            }
            format = f8393n.format(calendar.getTime());
        }
        this.f8394f = format;
        super.setText(this.f8394f);
    }

    public Date getDate() {
        if (this.f8399k == null || this.f8400l == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        Integer num = this.f8399k;
        if (num != null) {
            calendar.set(11, num.intValue());
        }
        Integer num2 = this.f8400l;
        if (num2 != null) {
            calendar.set(12, num2.intValue());
        }
        return calendar.getTime();
    }

    public String getTime() {
        return this.f8394f;
    }

    public Integer h(String str, Integer num) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Exception unused) {
            return num;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            f();
        }
    }

    public void setFragmentManager(w wVar) {
    }

    public void setOnTimeChange(d dVar) {
        this.f8395g = dVar;
    }

    public void setTime(String str) {
        if (str != null) {
            String[] split = str.split(":");
            if (split.length >= 2) {
                g(h(split[0], 0), h(split[1], 0));
                return;
            }
        }
        g(null, null);
    }

    public void setTime(Date date) {
        if (date == null) {
            setTime("");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        g(Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)));
    }
}
