package f6;

import android.annotation.SuppressLint;
import c6.t;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.ListRowAdapter;
import com.groboot.mdaemergency.models.RowAdapter;
import com.groboot.mdaemergency.models.SettingItem;
import com.groboot.mdaemergency.models.SettingsList;
import com.groboot.mdaemergency.ptt.PTTService;
import f6.l2;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class t2 extends l2 {
    SettingsList O0;
    ArrayList<Boolean> P0;
    boolean Q0;

    /* loaded from: classes.dex */
    class a implements t.h {
        a(t2 t2Var) {
        }

        @Override // c6.t.h
        public void a(SettingItem settingItem, boolean z10) {
        }

        @Override // c6.t.h
        public void b(RowAdapter.eRowAdapterType erowadaptertype, Object obj, String str) {
        }
    }

    /* loaded from: classes.dex */
    class b implements b.InterfaceC0098b {
        b() {
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            t2.this.J0.a(aVar);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9595a;

        static {
            int[] iArr = new int[com.groboot.mdaemergency.enums.j.values().length];
            f9595a = iArr;
            try {
                iArr[com.groboot.mdaemergency.enums.j.PTTVolume.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9595a[com.groboot.mdaemergency.enums.j.PTTVolumeType.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9595a[com.groboot.mdaemergency.enums.j.PTTFloatView.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9595a[com.groboot.mdaemergency.enums.j.PTTFloatViewDelay.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9595a[com.groboot.mdaemergency.enums.j.AlertKonanVolume.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9595a[com.groboot.mdaemergency.enums.j.AlertTeamVolume.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9595a[com.groboot.mdaemergency.enums.j.PTTStatus.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9595a[com.groboot.mdaemergency.enums.j.NotificationViewDelay.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public t2() {
    }

    @SuppressLint({"ValidFragment"})
    public t2(SettingsList settingsList, String str, l2.f fVar) {
        this.O0 = settingsList;
        this.J0 = fVar;
        this.K0 = str;
        this.M0 = true;
    }

    @Override // f6.l2, a6.a
    public void o2() {
        super.o2();
        if (this.Q0) {
            return;
        }
        int i10 = 0;
        Iterator<SettingItem> it = this.O0.ItemList.iterator();
        while (it.hasNext()) {
            it.next().Value = this.P0.get(i10).booleanValue();
            i10++;
        }
    }

    @Override // f6.l2
    String q2() {
        return this.K0;
    }

    @Override // f6.l2
    public t.h t2() {
        return new a(this);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    @Override // f6.l2
    public void u2() {
        this.Q0 = true;
        switch (c.f9595a[this.O0.settingType.ordinal()]) {
            case 1:
                Iterator<SettingItem> it = this.O0.ItemList.iterator();
                while (it.hasNext()) {
                    SettingItem next = it.next();
                    if (next.Value) {
                        w6.m.w0(w6.l0.H(next.Key) / 100.0f);
                        return;
                    }
                }
                return;
            case 2:
                Iterator<SettingItem> it2 = this.O0.ItemList.iterator();
                while (it2.hasNext()) {
                    SettingItem next2 = it2.next();
                    if (next2.Value) {
                        w6.m.y0(next2.Key);
                        return;
                    }
                }
                return;
            case 3:
                Iterator<SettingItem> it3 = this.O0.ItemList.iterator();
                while (it3.hasNext()) {
                    SettingItem next3 = it3.next();
                    if (next3.Value) {
                        w6.m.t0(next3.Key);
                        return;
                    }
                }
                return;
            case 4:
                Iterator<SettingItem> it4 = this.O0.ItemList.iterator();
                while (it4.hasNext()) {
                    SettingItem next4 = it4.next();
                    if (next4.Value) {
                        w6.m.s0(w6.l0.U(next4.Key));
                        return;
                    }
                }
                return;
            case 5:
                Iterator<SettingItem> it5 = this.O0.ItemList.iterator();
                while (it5.hasNext()) {
                    SettingItem next5 = it5.next();
                    if (next5.Value) {
                        w6.m.Z(next5.Key);
                        return;
                    }
                }
                return;
            case 6:
                Iterator<SettingItem> it6 = this.O0.ItemList.iterator();
                while (it6.hasNext()) {
                    SettingItem next6 = it6.next();
                    if (next6.Value) {
                        w6.m.a0(next6.Key);
                        return;
                    }
                }
                return;
            case 7:
                Iterator<SettingItem> it7 = this.O0.ItemList.iterator();
                while (it7.hasNext()) {
                    SettingItem next7 = it7.next();
                    if (next7.Value) {
                        String D = w6.m.D();
                        w6.m.u0(next7.Key);
                        if (D.equals("0") && next7.Key.equals("1")) {
                            if (com.groboot.mdaemergency.ptt.p.c0() != null) {
                                com.groboot.mdaemergency.ptt.p.c0().z0(null);
                                return;
                            }
                            return;
                        } else {
                            if (D.equals("1") && next7.Key.equals("0")) {
                                PTTService.j(A());
                                return;
                            }
                            return;
                        }
                    }
                }
                return;
            case 8:
                Iterator<SettingItem> it8 = this.O0.ItemList.iterator();
                while (true) {
                    if (it8.hasNext()) {
                        SettingItem next8 = it8.next();
                        if (next8.Value) {
                            w6.m.q0(w6.l0.W(next8.Key));
                        }
                    }
                }
            default:
                k2(R.id.ll_wait).setVisibility(0);
                com.groboot.mdaemergency.async.d.v().f0(t(), this.O0, new b());
                return;
        }
    }

    @Override // f6.l2
    List<RowAdapter> v2() {
        this.P0 = new ArrayList<>();
        ListRowAdapter listRowAdapter = new ListRowAdapter();
        SettingsList settingsList = this.O0;
        if (settingsList == null) {
            return listRowAdapter;
        }
        listRowAdapter.add(new RowAdapter((Object) settingsList.Description, true));
        Iterator<SettingItem> it = this.O0.ItemList.iterator();
        while (it.hasNext()) {
            SettingItem next = it.next();
            listRowAdapter.add(new RowAdapter(next));
            this.P0.add(Boolean.valueOf(next.Value));
        }
        return listRowAdapter;
    }
}
