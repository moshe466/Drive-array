package f6;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import c6.t;
import com.groboot.mdaemergency.models.ListRowAdapter;
import com.groboot.mdaemergency.models.RowAdapter;
import com.groboot.mdaemergency.models.SettingItem;
import com.groboot.mdaemergency.models.Settings;
import com.groboot.mdaemergency.models.SettingsList;
import f6.l2;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w6.l0;

/* loaded from: classes.dex */
public class k2 extends l2 {
    SettingsList O0;
    Settings P0;
    Settings.AlertSound Q0;
    int R0;
    int S0;
    com.groboot.mdaemergency.enums.l T0;
    boolean U0;

    /* loaded from: classes.dex */
    class a implements t.h {
        a() {
        }

        @Override // c6.t.h
        public void a(SettingItem settingItem, boolean z10) {
        }

        @Override // c6.t.h
        public void b(RowAdapter.eRowAdapterType erowadaptertype, Object obj, String str) {
            SettingItem settingItem = (SettingItem) obj;
            int i10 = b.f9528a[settingItem.type.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    k2.this.Q0.settingSound = settingItem.Key;
                    return;
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    Settings.AlertSound alertSound = k2.this.Q0;
                    String str2 = settingItem.Key;
                    alertSound.settingVibrate = str2;
                    if (com.groboot.mdaemergency.enums.k.getByKey(str2) == com.groboot.mdaemergency.enums.k.withVibrate) {
                        w6.l0.Z0(k2.this.A(), l0.h.SHORT);
                    }
                    k2 k2Var = k2.this;
                    k2Var.I0 = true;
                    k2Var.r2();
                    return;
                }
            }
            com.groboot.mdaemergency.enums.l byKey = com.groboot.mdaemergency.enums.l.getByKey(settingItem.Key);
            k2 k2Var2 = k2.this;
            Settings.AlertSound alertSound2 = k2Var2.Q0;
            if (byKey == null) {
                byKey = Settings.defaultSound;
            }
            alertSound2.sound = byKey;
            try {
                int identifier = k2Var2.A().getResources().getIdentifier("m" + settingItem.Key, "raw", k2.this.A().getPackageName());
                k2 k2Var3 = k2.this;
                k2Var3.G0 = MediaPlayer.create(k2Var3.A(), identifier);
                k2.this.G0.start();
            } catch (Exception e10) {
                String str3 = k2.this.H0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("error: ");
                sb2.append(e10);
            }
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9528a;

        static {
            int[] iArr = new int[com.groboot.mdaemergency.enums.j.values().length];
            f9528a = iArr;
            try {
                iArr[com.groboot.mdaemergency.enums.j.AlertSound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9528a[com.groboot.mdaemergency.enums.j.SoundSetting.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9528a[com.groboot.mdaemergency.enums.j.VibrateSetting.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public k2() {
    }

    @SuppressLint({"ValidFragment"})
    public k2(SettingsList settingsList, l2.f fVar) {
        this.O0 = settingsList;
        this.J0 = fVar;
        this.M0 = true;
        Settings J = w6.m.J();
        this.P0 = J;
        Settings.AlertSound alertSound = J.alertSounds.get(Integer.valueOf(settingsList.Type));
        this.Q0 = alertSound;
        if (alertSound == null) {
            this.Q0 = new Settings.AlertSound();
        }
        this.R0 = Integer.parseInt(this.Q0.settingSound);
        this.S0 = Integer.parseInt(this.Q0.settingVibrate);
        this.T0 = this.Q0.sound;
    }

    private ArrayList<SettingItem> B2() {
        ArrayList<SettingItem> arrayList = new ArrayList<>();
        com.groboot.mdaemergency.enums.i iVar = com.groboot.mdaemergency.enums.i.normal;
        String key = iVar.getKey();
        String e02 = e0(iVar.getResIdText());
        com.groboot.mdaemergency.enums.j jVar = com.groboot.mdaemergency.enums.j.SoundSetting;
        arrayList.add(new SettingItem(key, e02, jVar));
        com.groboot.mdaemergency.enums.i iVar2 = com.groboot.mdaemergency.enums.i.continual;
        arrayList.add(new SettingItem(iVar2.getKey(), e0(iVar2.getResIdText()), jVar));
        return arrayList;
    }

    private ArrayList<SettingItem> C2() {
        ArrayList<SettingItem> arrayList = new ArrayList<>();
        for (com.groboot.mdaemergency.enums.k kVar : com.groboot.mdaemergency.enums.k.getValues()) {
            arrayList.add(new SettingItem(kVar.getKey(), e0(kVar.getResIdText()), com.groboot.mdaemergency.enums.j.VibrateSetting));
        }
        return arrayList;
    }

    @Override // f6.l2, a6.a
    public void o2() {
        super.o2();
        if (this.U0) {
            return;
        }
        this.P0.alertSounds.put(Integer.valueOf(this.O0.Type), new Settings.AlertSound(this.T0, this.R0 + "", this.S0 + ""));
        w6.m.V(this.P0);
    }

    @Override // f6.l2
    String q2() {
        SettingsList settingsList = this.O0;
        return settingsList == null ? "" : settingsList.Description;
    }

    @Override // f6.l2
    public t.h t2() {
        return new a();
    }

    @Override // f6.l2
    public void u2() {
        this.U0 = true;
        this.P0.alertSounds.put(Integer.valueOf(this.O0.Type), this.Q0);
        w6.m.V(this.P0);
    }

    @Override // f6.l2
    public List<RowAdapter> v2() {
        if (this.Q0 == null) {
            this.Q0 = new Settings.AlertSound("0", "0");
        }
        ListRowAdapter listRowAdapter = new ListRowAdapter();
        if (!this.Q0.settingVibrate.equals(com.groboot.mdaemergency.enums.k.onlyVibrate.getKey())) {
            listRowAdapter.add(new RowAdapter((Object) e0(R.string.alert_tones), true));
            SettingsList settingsList = this.O0;
            if (settingsList != null) {
                Iterator<SettingItem> it = settingsList.ItemList.iterator();
                while (it.hasNext()) {
                    listRowAdapter.add(new RowAdapter(it.next()));
                }
            }
            listRowAdapter.add(new RowAdapter((Object) e0(R.string.setting_sound), true));
            Iterator<SettingItem> it2 = B2().iterator();
            while (it2.hasNext()) {
                SettingItem next = it2.next();
                if (this.Q0.settingSound.equals(next.Key)) {
                    next.Value = true;
                }
                listRowAdapter.add(new RowAdapter(next));
            }
        }
        listRowAdapter.add(new RowAdapter((Object) e0(R.string.setting_vibrate), true));
        Iterator<SettingItem> it3 = C2().iterator();
        while (it3.hasNext()) {
            SettingItem next2 = it3.next();
            if (this.Q0.settingVibrate.equals(next2.Key)) {
                next2.Value = true;
            }
            listRowAdapter.add(new RowAdapter(next2));
        }
        return listRowAdapter;
    }
}
