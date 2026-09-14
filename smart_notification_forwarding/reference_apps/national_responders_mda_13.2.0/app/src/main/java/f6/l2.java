package f6;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c6.t;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.RowAdapter;
import com.groboot.mdaemergency.models.SettingsList;
import com.groboot.mdaemergency.models.SettingsListGroup;
import com.groboot.mdaemergency.ui.main.MainActivity;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class l2 extends a6.a {
    LinearLayout A0;
    Button B0;
    List<SettingsListGroup> C0;
    ArrayList<RowAdapter> D0;
    c6.t E0;
    ListView F0;
    MediaPlayer G0;
    String H0;
    boolean I0;
    f J0;
    String K0;
    protected boolean L0;
    boolean M0;
    private View.OnClickListener N0;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l2.this.u2();
            l2.this.t().onBackPressed();
        }
    }

    /* loaded from: classes.dex */
    class b implements f {
        b() {
        }

        @Override // f6.l2.f
        public void a(b.a aVar) {
            l2.this.p2(aVar);
        }
    }

    /* loaded from: classes.dex */
    class c implements f {
        c() {
        }

        @Override // f6.l2.f
        public void a(b.a aVar) {
            l2.this.p2(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                l2.this.r2();
                a6.h.o(l2.this.t(), l2.this.e0(R.string.update_setting_failed));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l2.this.r2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void a(b.a aVar);
    }

    public l2() {
        this.C0 = new ArrayList();
        this.D0 = new ArrayList<>();
        this.F0 = null;
        this.H0 = "SettingsFragment";
        this.I0 = false;
        this.L0 = false;
        this.N0 = new a();
    }

    public l2(boolean z10) {
        this.C0 = new ArrayList();
        this.D0 = new ArrayList<>();
        this.F0 = null;
        this.H0 = "SettingsFragment";
        this.I0 = false;
        this.L0 = false;
        this.N0 = new a();
        this.I0 = z10;
    }

    public static boolean s2(Context context) {
        for (int i10 = 0; i10 < w6.u.a(w6.l0.v()).size() - 1; i10++) {
            if (!w6.u.a(w6.l0.v()).get(i10).b(context)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A2(boolean z10, String str) {
        k2(R.id.rl_progress).setVisibility(z10 ? 0 : 8);
        ((TextView) k2(R.id.txt_wait)).setText(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void V0(int i10, String[] strArr, int[] iArr) {
        super.V0(i10, strArr, iArr);
        c6.t tVar = this.E0;
        if (tVar == null) {
            return;
        }
        tVar.notifyDataSetChanged();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        if (this.L0) {
            r2();
        }
        this.L0 = false;
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_settings);
        LinearLayout linearLayout = (LinearLayout) k2(R.id.fl_main);
        this.A0 = linearLayout;
        this.F0 = (ListView) linearLayout.findViewById(R.id.lv_setting);
        Button button = (Button) this.A0.findViewById(R.id.btn_save);
        this.B0 = button;
        if (this.M0) {
            button.setVisibility(0);
            this.B0.setOnClickListener(this.N0);
        }
        r2();
        g(false);
        q(false);
        J(true);
        l(false);
        a(q2());
    }

    @Override // a6.a
    public void o2() {
    }

    protected void p2(b.a aVar) {
        boolean z10;
        if (this.f309z0) {
            if (aVar == null || !(z10 = aVar.f7614b)) {
                t().runOnUiThread(new d());
            } else if (z10) {
                t().runOnUiThread(new e());
            }
        }
    }

    abstract String q2();

    /* JADX INFO: Access modifiers changed from: protected */
    public void r2() {
        k2(R.id.ll_wait).setVisibility(8);
        this.D0.clear();
        this.D0.addAll(v2());
        c6.t tVar = new c6.t(t().getBaseContext(), this.D0, t2());
        this.E0 = tVar;
        this.F0.setAdapter((ListAdapter) tVar);
        if (this.I0) {
            this.F0.setSelection(this.E0.getCount() - 1);
            this.I0 = false;
        }
    }

    public abstract t.h t2();

    public abstract void u2();

    abstract List<RowAdapter> v2();

    public boolean w2() {
        startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + t().getPackageName())), 12344);
        this.L0 = true;
        this.I0 = true;
        return false;
    }

    public void x2(SettingsList settingsList, String str) {
        ((MainActivity) t()).h1(new t2(settingsList, str, new c()), true);
    }

    public void y2(SettingsList settingsList) {
        ((MainActivity) t()).h1(new k2(settingsList, new b()), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z2(boolean z10) {
        k2(R.id.ll_wait).setVisibility(z10 ? 0 : 8);
    }
}
