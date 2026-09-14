package com.groboot.mdaemergency.ui.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c6.n;
import com.groboot.mdaemergency.ui.activities.PermissionActivity;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import w6.l0;
import w6.t;

/* loaded from: classes.dex */
public class PermissionActivity extends Activity implements View.OnClickListener {

    /* renamed from: k, reason: collision with root package name */
    public static c f8102k;

    /* renamed from: f, reason: collision with root package name */
    ListView f8103f;

    /* renamed from: g, reason: collision with root package name */
    n f8104g;

    /* renamed from: h, reason: collision with root package name */
    Button f8105h;

    /* renamed from: i, reason: collision with root package name */
    Button f8106i;

    /* renamed from: j, reason: collision with root package name */
    TextView f8107j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements n.b {
        a() {
        }

        @Override // c6.n.b
        public void a(t tVar) {
            PermissionActivity.this.n(tVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8109a;

        static {
            int[] iArr = new int[c.values().length];
            f8109a = iArr;
            try {
                iArr[c.First.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8109a[c.Location.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8109a[c.Camera.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        First,
        Location,
        Camera
    }

    private void f() {
        t tVar = new t();
        Iterator<t> it = this.f8104g.f4439f.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (!next.f15260d) {
                tVar.f15259c.addAll(next.f15259c);
            }
        }
        ArrayList<String> arrayList = tVar.f15259c;
        androidx.core.app.b.n(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<w6.t> g() {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.groboot.mdaemergency.ui.activities.PermissionActivity.g():java.util.ArrayList");
    }

    private String h() {
        return "גילוי נאות על תכונת מיקום ברקע\n\nבאפליקציה זו קיימת יכולת לאיסוף נתוני מיקום ברקע. נתוני המיקום יתקבלו תמיד. גם כאשר האפליקציה סגורה או שאינה בשימוש\nהאפליקציה תשתמש בנתוני המיקום ברקע כדי לזהות בזמן אמת את מיקום הכונן או העובד ולהתריע על אירוע חירום בקרבת מקום\n" + ((CharSequence) Html.fromHtml("<hr />")) + "\nFull disclosure regarding background location permissions:\n\nThis app collects location data to enable the dispatch of emergency medical responders according to their proximity to the scene, even when the app is closed or not in use.";
    }

    private void i() {
        t.a aVar;
        this.f8103f = (ListView) findViewById(R.id.rv_list);
        this.f8104g = new n(this, g(), new a());
        ArrayList<t.a> arrayList = new ArrayList<>();
        int i10 = b.f8109a[f8102k.ordinal()];
        if (i10 == 1) {
            arrayList.add(t.a.Phone);
        } else if (i10 != 2) {
            if (i10 == 3) {
                aVar = t.a.Camera;
                arrayList.add(aVar);
            }
            this.f8104g.a(arrayList);
            this.f8103f.setAdapter((ListAdapter) this.f8104g);
        }
        aVar = t.a.Location;
        arrayList.add(aVar);
        this.f8104g.a(arrayList);
        this.f8103f.setAdapter((ListAdapter) this.f8104g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(DialogInterface dialogInterface, int i10) {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(t tVar, DialogInterface dialogInterface, int i10) {
        tVar.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final t tVar) {
        if (tVar.b(getApplicationContext())) {
            return;
        }
        if (tVar.f15261e != t.a.Location || com.groboot.mdaemergency.a.m(getApplicationContext())) {
            tVar.c(this);
        } else {
            l0.J0(this, "הרשאת מיקום", h(), getString(R.string.accept_perm), getString(R.string.deny), new DialogInterface.OnClickListener() { // from class: b6.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    PermissionActivity.this.l(tVar, dialogInterface, i10);
                }
            }, new DialogInterface.OnClickListener() { // from class: b6.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    PermissionActivity.m(dialogInterface, i10);
                }
            });
        }
    }

    public static void o(Activity activity, c cVar) {
        Intent intent = new Intent(activity, (Class<?>) PermissionActivity.class);
        f8102k = cVar;
        intent.addFlags(268435456);
        activity.startActivityForResult(intent, 12998);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i10, int i11, Intent intent) {
        n nVar = this.f8104g;
        if (nVar != null) {
            nVar.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_close) {
            finish();
        } else {
            if (id != R.id.btn_get_all_permission) {
                return;
            }
            if (com.groboot.mdaemergency.a.m(getApplicationContext())) {
                f();
            } else {
                l0.J0(this, "הרשאת מיקום", h(), getString(R.string.accept_perm), getString(R.string.deny), new DialogInterface.OnClickListener() { // from class: b6.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        PermissionActivity.this.j(dialogInterface, i10);
                    }
                }, new DialogInterface.OnClickListener() { // from class: b6.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        PermissionActivity.k(dialogInterface, i10);
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        TextView textView;
        int i10;
        super.onCreate(bundle);
        setContentView(R.layout.activity_permission);
        l0.E0(this);
        this.f8105h = (Button) findViewById(R.id.btn_get_all_permission);
        this.f8106i = (Button) findViewById(R.id.btn_close);
        this.f8107j = (TextView) findViewById(R.id.tv_data);
        this.f8105h.setOnClickListener(this);
        this.f8106i.setOnClickListener(this);
        if (f8102k == c.First) {
            textView = this.f8107j;
            i10 = 0;
        } else {
            textView = this.f8107j;
            i10 = 8;
        }
        textView.setVisibility(i10);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        n nVar = this.f8104g;
        if (nVar == null) {
            return;
        }
        nVar.notifyDataSetChanged();
        this.f8104g.notifyDataSetInvalidated();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        i();
    }
}
