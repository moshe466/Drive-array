package com.groboot.mdaemergency.enums;

import com.groboot.mdaemergency.models.NetworkSettings;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import m8.o;

/* loaded from: classes.dex */
public enum a {
    MADA { // from class: com.groboot.mdaemergency.enums.a.g
        @Override // com.groboot.mdaemergency.enums.a
        public boolean checkIsSideLoaded() {
            return true;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public NetworkSettings defaultSocketSettings() {
            return new NetworkSettings("m.mda.org.il", 20999, 20000, (int) TimeUnit.MINUTES.toMillis(1L));
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displaySettingsPrivacyPolicy() {
            return true;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displayShortcut() {
            return true;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public List<String> getListPublicKeys() {
            String str = w6.d.f15138m;
            return o.g(str, str, str);
        }

        @Override // com.groboot.mdaemergency.enums.a
        public int icon() {
            return R.drawable.icon_notifications;
        }

        @Override // com.groboot.mdaemergency.enums.a, java.lang.Enum
        public int name() {
            return R.string.app_name;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public String serverUrl() {
            String str = w6.d.f15126a;
            y8.k.d(str, "SERVER_URL_DEFAULT");
            return str;
        }
    },
    POC { // from class: com.groboot.mdaemergency.enums.a.j
        @Override // com.groboot.mdaemergency.enums.a
        public boolean checkIsSideLoaded() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public NetworkSettings defaultSocketSettings() {
            return new NetworkSettings("", 0, 5000, (int) TimeUnit.MINUTES.toMillis(1L));
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displaySettingsPrivacyPolicy() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displayShortcut() {
            return true;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public List<String> getListPublicKeys() {
            return o.b(w6.d.f15138m);
        }

        @Override // com.groboot.mdaemergency.enums.a
        public int icon() {
            return R.drawable.icon_notifications;
        }

        @Override // com.groboot.mdaemergency.enums.a, java.lang.Enum
        public int name() {
            return R.string.app_name;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public String serverUrl() {
            String str = w6.d.f15126a;
            y8.k.d(str, "SERVER_URL_DEFAULT");
            return str;
        }
    },
    CREW { // from class: com.groboot.mdaemergency.enums.a.c
        @Override // com.groboot.mdaemergency.enums.a
        public boolean checkIsSideLoaded() {
            return true;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public NetworkSettings defaultSocketSettings() {
            return null;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displaySettingsPrivacyPolicy() {
            return true;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displayShortcut() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public List<String> getListPublicKeys() {
            return o.b(w6.d.f15138m);
        }

        @Override // com.groboot.mdaemergency.enums.a
        public int icon() {
            return R.drawable.run_blue;
        }

        @Override // com.groboot.mdaemergency.enums.a, java.lang.Enum
        public int name() {
            return R.string.app_name_ih;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public String serverUrl() {
            String str = w6.d.f15126a;
            y8.k.d(str, "SERVER_URL_DEFAULT");
            return str;
        }
    },
    PHILIPINE { // from class: com.groboot.mdaemergency.enums.a.i
        @Override // com.groboot.mdaemergency.enums.a
        public boolean checkIsSideLoaded() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public NetworkSettings defaultSocketSettings() {
            return null;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displaySettingsPrivacyPolicy() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displayShortcut() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public List<String> getListPublicKeys() {
            return null;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public int icon() {
            return R.drawable.run_red;
        }

        @Override // com.groboot.mdaemergency.enums.a, java.lang.Enum
        public int name() {
            return R.string.app_name_ph;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public String serverUrl() {
            String str = w6.d.f15130e;
            y8.k.d(str, "SERVER_URL_PHILIPINE");
            return str;
        }
    },
    CHABAD { // from class: com.groboot.mdaemergency.enums.a.a
        @Override // com.groboot.mdaemergency.enums.a
        public boolean checkIsSideLoaded() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public NetworkSettings defaultSocketSettings() {
            return null;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displaySettingsPrivacyPolicy() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displayShortcut() {
            return true;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public List<String> getListPublicKeys() {
            return o.b(w6.d.f15139n);
        }

        @Override // com.groboot.mdaemergency.enums.a
        public int icon() {
            return R.drawable.run_red;
        }

        @Override // com.groboot.mdaemergency.enums.a, java.lang.Enum
        public int name() {
            return R.string.app_name_cwa;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public String serverUrl() {
            String str = w6.d.f15131f;
            y8.k.d(str, "SERVER_URL_CHABAD");
            return str;
        }
    },
    COMMUNITY { // from class: com.groboot.mdaemergency.enums.a.b
        @Override // com.groboot.mdaemergency.enums.a
        public boolean checkIsSideLoaded() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public NetworkSettings defaultSocketSettings() {
            return new NetworkSettings("m.mda.org.il", 20999, 20000, (int) TimeUnit.MINUTES.toMillis(1L));
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displaySettingsPrivacyPolicy() {
            return false;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public boolean displayShortcut() {
            return true;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public List<String> getListPublicKeys() {
            return null;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public int icon() {
            return R.drawable.icon_notifications;
        }

        @Override // com.groboot.mdaemergency.enums.a, java.lang.Enum
        public int name() {
            return R.string.app_name_community;
        }

        @Override // com.groboot.mdaemergency.enums.a
        public String serverUrl() {
            String str = w6.d.f15126a;
            y8.k.d(str, "SERVER_URL_DEFAULT");
            return str;
        }
    };

    private d colors;
    private boolean internalApp;

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private int f7683a;

        /* renamed from: b, reason: collision with root package name */
        private int f7684b;

        /* renamed from: c, reason: collision with root package name */
        private int f7685c;

        /* renamed from: d, reason: collision with root package name */
        private int f7686d;

        public d(int i10, int i11, int i12) {
            this.f7683a = i10;
            this.f7684b = i10;
            this.f7685c = R.color.grayDark;
            this.f7686d = i12;
        }

        public /* synthetic */ d(int i10, int i11, int i12, int i13, y8.g gVar) {
            this(i10, (i13 & 2) != 0 ? R.color.red_buttons : i11, (i13 & 4) != 0 ? R.color.green_buttons : i12);
        }

        public final int a() {
            return this.f7684b;
        }

        public final int b() {
            return this.f7683a;
        }

        public final int c() {
            return this.f7685c;
        }

        public final int d() {
            return this.f7686d;
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends d {
        public e() {
            super(R.color.mada_red_dark, 0, 0, 6, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends d {
        public f() {
            super(R.color.mada_red_light, R.color.red_buttons, R.color.mada_red_light);
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends d {
        public h() {
            super(R.color.red_buttons, 0, 0, 6, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class k extends d {
        public k() {
            super(R.color.mada_red_light, 0, 0, 6, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class l extends d {
        public l() {
            super(R.color.mada_red_light, R.color.red_buttons, R.color.mada_red_light);
        }
    }

    a(d dVar, boolean z10) {
        this.colors = dVar;
        this.internalApp = z10;
    }

    /* synthetic */ a(d dVar, boolean z10, int i10, y8.g gVar) {
        this(dVar, (i10 & 2) != 0 ? false : z10);
    }

    /* synthetic */ a(d dVar, boolean z10, y8.g gVar) {
        this(dVar, z10);
    }

    public abstract boolean checkIsSideLoaded();

    public abstract NetworkSettings defaultSocketSettings();

    public abstract boolean displaySettingsPrivacyPolicy();

    public abstract boolean displayShortcut();

    public final d getColors() {
        return this.colors;
    }

    public final boolean getInternalApp() {
        return this.internalApp;
    }

    public abstract List<String> getListPublicKeys();

    public final List<String> getPublicKeysSHA256() {
        List<String> listPublicKeys = getListPublicKeys();
        if (listPublicKeys == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(o.n(listPublicKeys, 10));
        Iterator<T> it = listPublicKeys.iterator();
        while (it.hasNext()) {
            arrayList.add(y8.k.j("sha256/", (String) it.next()));
        }
        return arrayList;
    }

    public abstract int icon();

    @Override // java.lang.Enum
    public abstract int name();

    public abstract String serverUrl();
}
