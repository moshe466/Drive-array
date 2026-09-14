package g5;

import com.groboot.mdaemergency.MdaEmergencyApplication;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static d f9803b = new d();

    /* renamed from: a, reason: collision with root package name */
    private final Map<com.groboot.mdaemergency.enums.a, a> f9804a;

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f9805a;

        /* renamed from: b, reason: collision with root package name */
        private final String f9806b;

        public a(String str, String str2) {
            this.f9805a = str;
            this.f9806b = str2;
        }

        public String a() {
            return this.f9806b;
        }

        public String b() {
            return this.f9805a;
        }
    }

    private d() {
        HashMap hashMap = new HashMap();
        this.f9804a = hashMap;
        hashMap.put(com.groboot.mdaemergency.enums.a.CREW, new a("https://www.mdais.org/app/terms_of_use_national", "https://www.mdais.org/app/privacy_policy_national"));
        hashMap.put(com.groboot.mdaemergency.enums.a.MADA, new a("https://www.mdais.org/app/terms_of_use_group", "https://www.mdais.org/app/policy_policy_group"));
    }

    public static d a() {
        if (f9803b == null) {
            f9803b = new d();
        }
        return f9803b;
    }

    public String b() {
        a aVar = this.f9804a.get(MdaEmergencyApplication.a());
        return aVar != null ? aVar.a() : "https://www.mdais.org/app";
    }

    public String c() {
        a aVar = this.f9804a.get(MdaEmergencyApplication.a());
        return aVar != null ? aVar.b() : "https://www.mdais.org/app";
    }
}
