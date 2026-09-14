package x5;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c6.n;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import w6.t;

/* loaded from: classes.dex */
public class j extends androidx.fragment.app.e implements View.OnClickListener {

    /* renamed from: u0, reason: collision with root package name */
    ListView f15442u0;

    /* renamed from: v0, reason: collision with root package name */
    n f15443v0;

    /* renamed from: w0, reason: collision with root package name */
    Button f15444w0;

    /* renamed from: x0, reason: collision with root package name */
    Button f15445x0;

    /* renamed from: y0, reason: collision with root package name */
    TextView f15446y0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements n.b {
        a() {
        }

        @Override // c6.n.b
        public void a(t tVar) {
            j.this.q2(tVar);
        }
    }

    private void k2() {
        Iterator<t> it = l2().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (!it.next().b(t())) {
                z10 = true;
            }
        }
        if (z10) {
            return;
        }
        W1();
    }

    private ArrayList<t> l2() {
        t tVar;
        ArrayList<t> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT < 23) {
            tVar = new t();
            tVar.f15258b = e0(R.string.permission_irrelevant);
            tVar.f15257a = e0(R.string.permission_irrelevant_description);
        } else {
            t tVar2 = new t();
            tVar2.f15258b = e0(R.string.video_recording);
            tVar2.f15257a = e0(R.string.permission_video_recording_ptt_description);
            tVar2.f15259c.add("android.permission.RECORD_AUDIO");
            tVar2.f15261e = t.a.Audio;
            arrayList.add(tVar2);
            tVar = new t();
            tVar.f15258b = e0(R.string.permission_view_over_apps);
            tVar.f15257a = e0(R.string.alert_ptt_incoming_call);
            tVar.f15260d = true;
            tVar.f15261e = t.a.Overlay;
        }
        arrayList.add(tVar);
        return arrayList;
    }

    private void m2() {
        ArrayList<t> l22 = l2();
        k2();
        n nVar = new n(t(), l22, new a());
        this.f15443v0 = nVar;
        this.f15442u0.setAdapter((ListAdapter) nVar);
    }

    private void n2() {
        this.f15443v0.notifyDataSetChanged();
        this.f15443v0.notifyDataSetInvalidated();
        k2();
    }

    public static void o2(androidx.fragment.app.j jVar) {
        if (com.groboot.mdaemergency.a.t()) {
            if (com.groboot.mdaemergency.a.r(jVar) && t.a(jVar)) {
                return;
            }
            new j().i2(jVar.d0(), "PTTPermissionDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(t tVar) {
        if (tVar.b(t())) {
            return;
        }
        LockPatternActivity.B();
        if (tVar.f15260d) {
            p2();
        } else {
            androidx.core.app.b.n(t(), (String[]) tVar.f15259c.toArray(new String[tVar.f15259c.size()]), 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ptt_permission_dialog, viewGroup, false);
        f2(true);
        this.f15444w0 = (Button) inflate.findViewById(R.id.btn_get_all_permission);
        this.f15445x0 = (Button) inflate.findViewById(R.id.btn_close);
        this.f15446y0 = (TextView) inflate.findViewById(R.id.tv_data);
        this.f15442u0 = (ListView) inflate.findViewById(R.id.rv_list);
        this.f15444w0.setOnClickListener(this);
        this.f15445x0.setOnClickListener(this);
        m2();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void V0(int i10, String[] strArr, int[] iArr) {
        super.V0(i10, strArr, iArr);
        if (this.f15443v0 == null) {
            return;
        }
        n2();
    }

    @Override // androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        if (this.f15443v0 == null) {
            return;
        }
        LockPatternActivity.B();
        n2();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LockPatternActivity.B();
        int id = view.getId();
        if (id == R.id.btn_close) {
            W1();
            return;
        }
        if (id != R.id.btn_get_all_permission) {
            return;
        }
        t tVar = new t();
        Iterator<t> it = this.f15443v0.f4439f.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (!next.f15260d) {
                tVar.f15259c.addAll(next.f15259c);
            }
        }
        androidx.fragment.app.j t10 = t();
        ArrayList<String> arrayList = tVar.f15259c;
        androidx.core.app.b.n(t10, (String[]) arrayList.toArray(new String[arrayList.size()]), 0);
    }

    public boolean p2() {
        LockPatternActivity.B();
        startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + t().getPackageName())), 12344);
        return false;
    }
}
