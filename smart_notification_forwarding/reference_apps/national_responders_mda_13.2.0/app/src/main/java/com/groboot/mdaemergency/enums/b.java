package com.groboot.mdaemergency.enums;

import il.org.mda.health.R;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import w6.l0;
import w6.m;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'AVAILABLE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class b {
    private static final /* synthetic */ b[] $VALUES;
    public static final b ARAN_ONLY;
    public static final b AVAILABLE;
    public static final b DIFFERENT_ADDRESS;
    public static final b NATAN_ONLY;
    public static final b NOT_AVAILABLE;
    public static final b SATURDAY;
    private int distance;
    private int num;
    private int title;
    private a trackingType;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FULL' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        private static final /* synthetic */ a[] $VALUES;
        public static final a FULL;
        public static final a NONE;
        public static final a SLEEPY;
        int minTimeInterval;
        int timeIntervalGetLocation;
        int timeIntervalSendToServer;

        static {
            a aVar = new a("NONE", 0, 0L);
            NONE = aVar;
            TimeUnit timeUnit = TimeUnit.MINUTES;
            a aVar2 = new a("FULL", 1, timeUnit.toMillis(4L), timeUnit.toMillis(4L), TimeUnit.SECONDS.toMillis(40L));
            FULL = aVar2;
            a aVar3 = new a("SLEEPY", 2, timeUnit.toMillis(2L));
            SLEEPY = aVar3;
            $VALUES = new a[]{aVar, aVar2, aVar3};
        }

        private a(String str, int i10, long j10) {
            int i11 = (int) j10;
            this.timeIntervalSendToServer = i11;
            this.minTimeInterval = i11;
            this.timeIntervalGetLocation = i11;
        }

        private a(String str, int i10, long j10, long j11, long j12) {
            this.timeIntervalSendToServer = (int) j10;
            this.timeIntervalGetLocation = (int) j11;
            this.minTimeInterval = (int) j12;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) $VALUES.clone();
        }

        public int getMinTimeInterval() {
            return this.minTimeInterval;
        }

        public int getMinute() {
            return (int) TimeUnit.MILLISECONDS.toMinutes(getTimeIntervalSendToServer());
        }

        public int getTimeIntervalGetLocation() {
            return this.timeIntervalGetLocation;
        }

        public int getTimeIntervalSendToServer() {
            return this.timeIntervalSendToServer;
        }

        public void setTimeIntervalSendToServer(int i10) {
            this.timeIntervalSendToServer = (int) TimeUnit.MINUTES.toMillis(i10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("update to ");
            sb2.append(i10);
        }
    }

    static {
        a aVar = a.FULL;
        b bVar = new b("AVAILABLE", 0, 1, R.string.user_status_available, aVar);
        AVAILABLE = bVar;
        b bVar2 = new b("NATAN_ONLY", 1, 2, R.string.user_status_natan, aVar);
        NATAN_ONLY = bVar2;
        b bVar3 = new b("ARAN_ONLY", 2, 3, R.string.user_status_aran, aVar);
        ARAN_ONLY = bVar3;
        a aVar2 = a.NONE;
        b bVar4 = new b("DIFFERENT_ADDRESS", 3, 6, R.string.user_status_different_address, aVar2);
        DIFFERENT_ADDRESS = bVar4;
        b bVar5 = new b("SATURDAY", 4, 7, R.string.user_status_saturday, aVar2);
        SATURDAY = bVar5;
        b bVar6 = new b("NOT_AVAILABLE", 5, 8, R.string.user_status_not_available, aVar2);
        NOT_AVAILABLE = bVar6;
        $VALUES = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6};
    }

    private b(String str, int i10, int i11, int i12, a aVar) {
        this.num = i11;
        this.title = i12;
        this.trackingType = aVar;
        this.distance = aVar == a.SLEEPY ? 2000 : 300;
    }

    public static List<b> toList() {
        return m.m() == com.groboot.mdaemergency.enums.a.CREW ? Arrays.asList(AVAILABLE, DIFFERENT_ADDRESS, SATURDAY, NOT_AVAILABLE) : m.m() == com.groboot.mdaemergency.enums.a.CHABAD ? Arrays.asList(AVAILABLE, DIFFERENT_ADDRESS, NOT_AVAILABLE) : Arrays.asList(values());
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) $VALUES.clone();
    }

    public int getDistance() {
        return this.distance;
    }

    public int getMinTimeInterval() {
        return this.trackingType.getMinTimeInterval();
    }

    public int getNum() {
        return this.num;
    }

    public int getResTitle() {
        return this.title;
    }

    public int getTimeIntervalGetLocation() {
        return this.trackingType.getTimeIntervalGetLocation();
    }

    public int getTimeIntervalSendToServer() {
        return this.trackingType.getTimeIntervalSendToServer();
    }

    public String getTitle() {
        return l0.Z(this.title);
    }

    public a getTrackingType() {
        return this.trackingType;
    }
}
