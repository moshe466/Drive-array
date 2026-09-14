package f6;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import c6.t;
import com.groboot.mdaemergency.a;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.ListRowAdapter;
import com.groboot.mdaemergency.models.PttSettings;
import com.groboot.mdaemergency.models.RowAdapter;
import com.groboot.mdaemergency.models.SettingItem;
import com.groboot.mdaemergency.models.SettingSound;
import com.groboot.mdaemergency.models.Settings;
import com.groboot.mdaemergency.models.SettingsList;
import com.groboot.mdaemergency.models.SettingsListGroup;
import com.groboot.mdaemergency.ptt.PTTService;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import com.groboot.mdaemergency.ui.main.MainActivity;
import f6.s2;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import w6.t;

/* loaded from: classes.dex */
public class s2 extends l2 {
    private String O0;
    private String P0;
    private String Q0;
    private String R0;
    private String S0;
    private String T0;
    private boolean U0;
    com.groboot.mdaemergency.enums.a V0;
    Boolean W0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements t.h {

        /* renamed from: f6.s2$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0164a implements b.InterfaceC0098b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ SettingItem f9584a;

            C0164a(SettingItem settingItem) {
                this.f9584a = settingItem;
            }

            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public void a(b.a aVar) {
                Intent intent = new Intent(w6.n.f(s2.this.A(), this.f9584a.Key), (Class<?>) MainActivity.class);
                intent.putExtra(MainActivity.f8235b0, s2.class.getName());
                intent.putExtra("recreateInApp", true);
                intent.setFlags(67108864);
                s2.this.P1(intent);
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void h(a.c cVar) {
            s5.d.j().t();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(b.a aVar) {
            s2 s2Var;
            int i10;
            s2.this.A2(false, "");
            if (aVar.f7614b) {
                s2Var = s2.this;
                i10 = R.string.logs_sent_success;
            } else {
                s2Var = s2.this;
                i10 = R.string.logs_sent_failed;
            }
            Toast.makeText(s2.this.A(), s2Var.e0(i10), 0);
            String str = s2.this.H0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(final b.a aVar) {
            if (aVar == null || s2.this.t() == null) {
                return;
            }
            s2.this.t().runOnUiThread(new Runnable() { // from class: f6.r2
                @Override // java.lang.Runnable
                public final void run() {
                    s2.a.this.i(aVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(DialogInterface dialogInterface, int i10) {
            String str = s2.this.H0;
            com.groboot.mdaemergency.ptt.p.c0().L0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void l(DialogInterface dialogInterface, int i10) {
        }

        @Override // c6.t.h
        public void a(SettingItem settingItem, boolean z10) {
            if (settingItem.Key.equals(s2.this.P0)) {
                w6.m.B0(z10);
                return;
            }
            if (settingItem.Key.equals(s2.this.R0)) {
                w6.m.i0(Boolean.valueOf(z10));
                return;
            }
            if (settingItem.Key.equals(s2.this.Q0)) {
                w6.m.v0(Boolean.valueOf(z10));
                return;
            }
            if (settingItem.Key.equals(s2.this.O0)) {
                w6.m.j0(Boolean.valueOf(z10));
            } else if (settingItem.Key.equals(s2.this.T0)) {
                w6.m.Y(z10);
                r5.a.a().f(s2.this.A());
            }
        }

        @Override // c6.t.h
        public void b(RowAdapter.eRowAdapterType erowadaptertype, Object obj, String str) {
            SettingsList settingsList;
            s2 s2Var;
            com.groboot.mdaemergency.enums.e byCode;
            switch (b.f9588c[erowadaptertype.ordinal()]) {
                case 1:
                    settingsList = (SettingsList) obj;
                    com.groboot.mdaemergency.enums.j jVar = settingsList.settingType;
                    if (jVar == com.groboot.mdaemergency.enums.j.MultiSelect || jVar == com.groboot.mdaemergency.enums.j.PTTStatus || jVar == com.groboot.mdaemergency.enums.j.PTTVolumeType || jVar == com.groboot.mdaemergency.enums.j.PTTVolume || jVar == com.groboot.mdaemergency.enums.j.PTTFloatView || jVar == com.groboot.mdaemergency.enums.j.PTTFloatViewDelay || jVar == com.groboot.mdaemergency.enums.j.AlertTeamVolume || jVar == com.groboot.mdaemergency.enums.j.AlertKonanVolume || jVar == com.groboot.mdaemergency.enums.j.NotificationViewDelay) {
                        s2.this.x2(settingsList, str);
                        return;
                    } else if (jVar == com.groboot.mdaemergency.enums.j.AlertSound) {
                        s2Var = s2.this;
                        break;
                    } else {
                        return;
                    }
                    break;
                case 2:
                    w6.t tVar = (w6.t) obj;
                    if (tVar.b(s2.this.t())) {
                        return;
                    }
                    LockPatternActivity.B();
                    s2 s2Var2 = s2.this;
                    s2Var2.L0 = true;
                    s2Var2.I0 = true;
                    switch (b.f9587b[tVar.f15261e.ordinal()]) {
                        case 1:
                            com.groboot.mdaemergency.a.C(s2.this.t(), s2.this);
                            return;
                        case 2:
                            com.groboot.mdaemergency.a.y(s2.this.t(), s2.this);
                            return;
                        case 3:
                            com.groboot.mdaemergency.a.D(s2.this.t(), s2.this);
                            return;
                        case 4:
                            com.groboot.mdaemergency.a.E(s2.this.t(), s2.this);
                            return;
                        case 5:
                            com.groboot.mdaemergency.a.A(s2.this.t(), s2.this, new a.InterfaceC0096a() { // from class: f6.p2
                                @Override // com.groboot.mdaemergency.a.InterfaceC0096a
                                public final void a(a.c cVar) {
                                    s2.a.h(cVar);
                                }
                            });
                            return;
                        case 6:
                            s2.this.w2();
                            return;
                        default:
                            return;
                    }
                case 3:
                    if (!(obj instanceof SettingItem)) {
                        w6.m.r0(((Boolean) obj).booleanValue());
                        return;
                    }
                    SettingItem settingItem = (SettingItem) obj;
                    if (settingItem.type != com.groboot.mdaemergency.enums.j.Language || (byCode = com.groboot.mdaemergency.enums.e.getByCode(settingItem.Key)) == null || w6.m.u() == byCode) {
                        return;
                    }
                    s2.this.z2(true);
                    com.groboot.mdaemergency.async.d.v().Z(byCode, new C0164a(settingItem));
                    return;
                case 4:
                    s2Var = s2.this;
                    settingsList = (SettingsList) obj;
                    break;
                case 5:
                    ((MainActivity) s2.this.t()).k1();
                    return;
                case 6:
                    s2.this.A2(true, "שולח לוגים...");
                    com.groboot.mdaemergency.async.d.v().x0(g5.e.c(), new b.InterfaceC0098b() { // from class: f6.q2
                        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                        public final void a(b.a aVar) {
                            s2.a.this.j(aVar);
                        }
                    });
                    return;
                case 7:
                    if (erowadaptertype.getKey().equals(s2.this.S0)) {
                        w6.l0.H0(s2.this.A(), R.string.reset_ptt, R.string.dialog_reset_ptt, new DialogInterface.OnClickListener() { // from class: f6.n2
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i10) {
                                s2.a.this.k(dialogInterface, i10);
                            }
                        }, new DialogInterface.OnClickListener() { // from class: f6.o2
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i10) {
                                s2.a.l(dialogInterface, i10);
                            }
                        });
                        return;
                    }
                    return;
                case 8:
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse((String) obj));
                    if (s2.this.t() != null) {
                        s2.this.t().startActivity(intent);
                        return;
                    } else {
                        Toast.makeText(s2.this.A(), "לא ניתן לפתוח את הקישור", 0).show();
                        return;
                    }
                default:
                    return;
            }
            s2Var.y2(settingsList);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9586a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f9587b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f9588c;

        static {
            int[] iArr = new int[RowAdapter.eRowAdapterType.values().length];
            f9588c = iArr;
            try {
                iArr[RowAdapter.eRowAdapterType.settingList.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9588c[RowAdapter.eRowAdapterType.permissions.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9588c[RowAdapter.eRowAdapterType.checkbox.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9588c[RowAdapter.eRowAdapterType.sound.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9588c[RowAdapter.eRowAdapterType.shortcut.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9588c[RowAdapter.eRowAdapterType.sendLogs.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9588c[RowAdapter.eRowAdapterType.dialog.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9588c[RowAdapter.eRowAdapterType.ExternalLinkItem.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[t.a.values().length];
            f9587b = iArr2;
            try {
                iArr2[t.a.Phone.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9587b[t.a.Camera.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9587b[t.a.Audio.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9587b[t.a.IO.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9587b[t.a.Location.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9587b[t.a.Overlay.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr3 = new int[com.groboot.mdaemergency.enums.j.values().length];
            f9586a = iArr3;
            try {
                iArr3[com.groboot.mdaemergency.enums.j.AlertSound.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public s2() {
        this.O0 = "PTTONCALL";
        this.P0 = "ShabbatMode";
        this.Q0 = "PTTVibrate";
        this.R0 = "IsPTTActive";
        this.S0 = "ResetPTT";
        this.T0 = "AdvancedGeoTracking";
        this.U0 = false;
        this.V0 = w6.m.m();
    }

    @SuppressLint({"ValidFragment"})
    public s2(boolean z10) {
        super(z10);
        this.O0 = "PTTONCALL";
        this.P0 = "ShabbatMode";
        this.Q0 = "PTTVibrate";
        this.R0 = "IsPTTActive";
        this.S0 = "ResetPTT";
        this.T0 = "AdvancedGeoTracking";
        this.U0 = false;
        this.V0 = w6.m.m();
    }

    private RowAdapter I2() {
        RowAdapter.eRowAdapterType erowadaptertype = RowAdapter.eRowAdapterType.shortcut;
        erowadaptertype.setSubType(RowAdapter.eRowAdapterSubType.shortcut);
        return new RowAdapter(e0(R.string.edit_shortcut), erowadaptertype);
    }

    private SettingsList J2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SettingItem("0", e0(R.string.none)));
        arrayList.add(new SettingItem(TimeUnit.SECONDS.toMillis(30L) + "", e0(R.string.seconds_30)));
        StringBuilder sb2 = new StringBuilder();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        sb2.append(timeUnit.toMillis(1L));
        sb2.append("");
        arrayList.add(new SettingItem(sb2.toString(), e0(R.string.minot)));
        arrayList.add(new SettingItem(timeUnit.toMillis(3L) + "", e0(R.string.minots_3)));
        arrayList.add(new SettingItem(timeUnit.toMillis(5L) + "", e0(R.string.minots_5)));
        arrayList.add(new SettingItem(timeUnit.toMillis(10L) + "", e0(R.string.minots_10)));
        return new SettingsList(com.groboot.mdaemergency.enums.j.NotificationViewDelay, e0(R.string.notification_view_delay), 9, arrayList, w6.m.z() + "");
    }

    private SettingsList K2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SettingItem("0", e0(R.string.none)));
        arrayList.add(new SettingItem("10", e0(R.string.ten_seconds)));
        arrayList.add(new SettingItem("60", e0(R.string.minot)));
        arrayList.add(new SettingItem("120", e0(R.string.minots_2)));
        arrayList.add(new SettingItem("600", e0(R.string.minots_10)));
        return new SettingsList(com.groboot.mdaemergency.enums.j.PTTFloatViewDelay, e0(R.string.float_view_delay), 9, arrayList, w6.m.B() + "");
    }

    private SettingsList L2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SettingItem("0", e0(R.string.none)));
        arrayList.add(new SettingItem("1", e0(R.string.button_only)));
        arrayList.add(new SettingItem("2", e0(R.string.ptt_view)));
        return new SettingsList(com.groboot.mdaemergency.enums.j.PTTFloatView, e0(R.string.float_view), 9, arrayList, w6.m.C());
    }

    private Collection<RowAdapter> M2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RowAdapter((Object) J2(), false));
        arrayList.add(I2());
        return arrayList;
    }

    private SettingsList N2() {
        return R2(com.groboot.mdaemergency.enums.j.AlertKonanVolume, e0(R.string.alert_konan), 9, w6.m.g());
    }

    private SettingsList O2() {
        return R2(com.groboot.mdaemergency.enums.j.PTTVolumeType, e0(R.string.volume), 9, w6.m.G());
    }

    private SettingsList P2() {
        return R2(com.groboot.mdaemergency.enums.j.AlertTeamVolume, e0(R.string.alert_team), 9, w6.m.h());
    }

    private SettingsList Q2(SettingSound settingSound) {
        ArrayList arrayList = new ArrayList();
        for (com.groboot.mdaemergency.enums.l lVar : com.groboot.mdaemergency.enums.l.values()) {
            arrayList.add(new SettingItem(lVar.getKey(), e0(lVar.getsoundNameResId())));
        }
        Settings.AlertSound alertSound = w6.m.J().alertSounds.get(Integer.valueOf(settingSound.Type));
        return new SettingsList(com.groboot.mdaemergency.enums.j.AlertSound, settingSound.Description, settingSound.Type, arrayList, (alertSound == null ? Settings.defaultSound : alertSound.sound).getKey());
    }

    private SettingsList R2(com.groboot.mdaemergency.enums.j jVar, String str, int i10, String str2) {
        SettingItem settingItem;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SettingItem("-1", e0(R.string.according_device_settings)));
        arrayList.add(new SettingItem("0", e0(R.string.silent_mode)));
        if (jVar != com.groboot.mdaemergency.enums.j.PTTVolumeType) {
            arrayList.add(new SettingItem("1", e0(R.string.low_audio_level)));
            arrayList.add(new SettingItem("2", e0(R.string.moderate_audio_level)));
            settingItem = new SettingItem("3", e0(R.string.high_audio_level));
        } else {
            settingItem = new SettingItem("3", e0(R.string.high_audio_level_up));
        }
        arrayList.add(settingItem);
        return new SettingsList(jVar, str, i10, arrayList, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S2(b.a aVar) {
    }

    private RowAdapter T2() {
        RowAdapter.eRowAdapterType erowadaptertype = RowAdapter.eRowAdapterType.dialog;
        erowadaptertype.setKey(this.S0);
        return new RowAdapter(e0(R.string.reset_ptt), erowadaptertype);
    }

    private RowAdapter U2() {
        RowAdapter.eRowAdapterType erowadaptertype = RowAdapter.eRowAdapterType.sendLogs;
        erowadaptertype.setSubType(RowAdapter.eRowAdapterSubType.sendLogs);
        return new RowAdapter(e0(R.string.send_logs), erowadaptertype);
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        k5.a.d(t());
        Boolean bool = this.W0;
        if (bool != null && bool.booleanValue() != w6.m.s()) {
            if (w6.m.s()) {
                PTTService.j(t());
            } else {
                com.groboot.mdaemergency.ptt.p.c0().y0();
                PTTService.k(A());
            }
            com.groboot.mdaemergency.async.d.v().p0(new PttSettings(w6.m.s()), new b.InterfaceC0098b() { // from class: f6.m2
                @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                public final void a(b.a aVar) {
                    s2.S2(aVar);
                }
            });
        }
        v5.a.b(t());
    }

    @Override // f6.l2, a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        this.W0 = Boolean.valueOf(w6.m.s());
    }

    @Override // f6.l2
    String q2() {
        return e0(R.string.settings);
    }

    @Override // f6.l2
    public t.h t2() {
        return new a();
    }

    @Override // f6.l2
    public void u2() {
    }

    @Override // f6.l2
    public List<RowAdapter> v2() {
        this.C0 = com.groboot.mdaemergency.async.d.v().i();
        ListRowAdapter listRowAdapter = new ListRowAdapter();
        if (com.groboot.mdaemergency.async.d.v().f7636f != null) {
            List<SettingSound> list = com.groboot.mdaemergency.async.d.v().f7636f.SettingsSound;
            SettingsListGroup settingsListGroup = new SettingsListGroup(e0(R.string.alert_tones), SettingsListGroup.eListGroupType.AlertTones);
            if (list != null) {
                Iterator<SettingSound> it = list.iterator();
                while (it.hasNext()) {
                    settingsListGroup.List.add(Q2(it.next()));
                }
                this.C0.add(settingsListGroup);
                if (w6.m.r()) {
                    SettingsListGroup settingsListGroup2 = new SettingsListGroup(e0(R.string.volume), SettingsListGroup.eListGroupType.PTT);
                    settingsListGroup2.List.add(P2());
                    settingsListGroup2.List.add(N2());
                    this.C0.add(settingsListGroup2);
                }
                if (!this.C0.isEmpty()) {
                    for (SettingsListGroup settingsListGroup3 : this.C0) {
                        listRowAdapter.add(new RowAdapter((Object) settingsListGroup3.Description, true));
                        Iterator<SettingsList> it2 = settingsListGroup3.List.iterator();
                        while (it2.hasNext()) {
                            SettingsList next = it2.next();
                            listRowAdapter.add(b.f9586a[next.settingType.ordinal()] != 1 ? new RowAdapter((Object) next, false) : new RowAdapter(next, RowAdapter.eRowAdapterType.sound));
                        }
                        if (this.V0 == com.groboot.mdaemergency.enums.a.MADA && !w6.l0.m0(t()) && settingsListGroup3.Description.equals(e0(R.string.settings))) {
                            listRowAdapter.addAll(M2());
                            this.U0 = true;
                        }
                    }
                    if (this.V0 == com.groboot.mdaemergency.enums.a.MADA && !w6.l0.m0(t()) && !this.U0) {
                        listRowAdapter.add(0, new RowAdapter((Object) e0(R.string.settings), true));
                        listRowAdapter.addAll(M2());
                    }
                }
            }
        }
        if ((this.V0 == com.groboot.mdaemergency.enums.a.MADA && w6.m.k().getType() == 1) || this.V0 == com.groboot.mdaemergency.enums.a.CREW) {
            listRowAdapter.add(new RowAdapter((Object) A().getString(R.string.advanced_geo_settings), true));
            listRowAdapter.add(new RowAdapter(new SettingItem(this.T0, e0(R.string.advanced_geolocation_service_option), com.groboot.mdaemergency.enums.j.AdvancedGeoLocationSetting, Boolean.valueOf(w6.m.f())), RowAdapter.eRowAdapterType.switchBox));
        }
        if (w6.m.r()) {
            listRowAdapter.add(new RowAdapter((Object) "PTT", true));
            listRowAdapter.add(T2());
            String str = this.R0;
            String e02 = e0(R.string.active);
            com.groboot.mdaemergency.enums.j jVar = com.groboot.mdaemergency.enums.j.VibrateSetting;
            SettingItem settingItem = new SettingItem(str, e02, jVar, Boolean.valueOf(w6.m.s()));
            RowAdapter.eRowAdapterType erowadaptertype = RowAdapter.eRowAdapterType.switchBox;
            listRowAdapter.add(new RowAdapter(settingItem, erowadaptertype));
            listRowAdapter.add(new RowAdapter(new SettingItem(this.Q0, e0(R.string.with_vibrate), jVar, Boolean.valueOf(w6.m.E())), erowadaptertype));
            listRowAdapter.add(new RowAdapter(new SettingItem(this.O0, e0(R.string.ptt_active_on_call), jVar, w6.m.R()), erowadaptertype));
            listRowAdapter.add(new RowAdapter((Object) O2(), false));
            listRowAdapter.add(new RowAdapter((Object) L2(), false));
            listRowAdapter.add(new RowAdapter((Object) K2(), false));
        }
        if (this.V0 != com.groboot.mdaemergency.enums.a.PHILIPINE) {
            listRowAdapter.add(new RowAdapter((Object) e0(R.string.language), true));
            com.groboot.mdaemergency.enums.e u10 = w6.m.u();
            com.groboot.mdaemergency.enums.e eVar = com.groboot.mdaemergency.enums.e.Hebrew;
            boolean z10 = u10 == eVar;
            String code = eVar.getCode();
            String e03 = e0(eVar.getNameResId());
            com.groboot.mdaemergency.enums.j jVar2 = com.groboot.mdaemergency.enums.j.Language;
            listRowAdapter.add(new RowAdapter(new SettingItem(code, e03, jVar2, Boolean.valueOf(z10))));
            com.groboot.mdaemergency.enums.e eVar2 = com.groboot.mdaemergency.enums.e.English;
            listRowAdapter.add(new RowAdapter(new SettingItem(eVar2.getCode(), e0(eVar2.getNameResId()), jVar2, Boolean.valueOf(!z10))));
        }
        listRowAdapter.add(new RowAdapter((Object) e0(R.string.permissions), true));
        Iterator<w6.t> it3 = w6.u.a(A()).iterator();
        while (it3.hasNext()) {
            listRowAdapter.add(new RowAdapter(it3.next()));
        }
        listRowAdapter.add(new RowAdapter((Object) A().getString(R.string.other), true));
        listRowAdapter.add(U2());
        if (this.V0.displaySettingsPrivacyPolicy()) {
            listRowAdapter.add(new RowAdapter((Object) e0(R.string.terms_of_service_privacy_policy), true));
            String c10 = g5.d.a().c();
            String e04 = e0(R.string.tos);
            com.groboot.mdaemergency.enums.j jVar3 = com.groboot.mdaemergency.enums.j.ExternalLink;
            SettingItem settingItem2 = new SettingItem(c10, e04, jVar3);
            RowAdapter.eRowAdapterType erowadaptertype2 = RowAdapter.eRowAdapterType.ExternalLinkItem;
            listRowAdapter.add(new RowAdapter(settingItem2, erowadaptertype2));
            listRowAdapter.add(new RowAdapter(new SettingItem(g5.d.a().b(), e0(R.string.privacy_policy), jVar3), erowadaptertype2));
        }
        return listRowAdapter;
    }
}
