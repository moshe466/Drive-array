package n5;

import com.groboot.mdaemergency.models.AppUser;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import w6.m;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f12227a;

    private d() {
    }

    private AppUser a() {
        AppUser k10 = m.k();
        return k10 != null ? k10 : new AppUser();
    }

    private String b() {
        return f.f12234a.a().b(a().getPhone(), a().getDateOfBirth().replace(String.valueOf('-'), ""), a().getID(), String.valueOf(a().getType()), a().getCode(), String.valueOf(a().getDeviceType()), a().getDeviceName(), a().getAppVersion());
    }

    private String c() {
        return f.f12234a.a().b(a().getPhone(), a().getTempToken(), a().getDateOfBirth().replace(String.valueOf('-'), ""), a().getID(), String.valueOf(a().getType()), a().getOSVersion(), String.valueOf(a().getDeviceType()), a().getDeviceName(), a().getAppVersion());
    }

    private String d() {
        return f.f12234a.a().b(String.valueOf(a().getDeviceType()), a().getDeviceName(), a().getPhone(), a().getID(), String.valueOf(a().getType()), a().getAppVersion());
    }

    private String e() {
        return f.f12234a.a().b(m.k().getPushID(), String.valueOf(a().getDeviceType()), a().getDeviceName(), a().getPhone(), a().getID(), a().getCode(), String.valueOf(a().getType()), a().getSMSCode(), a().getAppVersion(), String.valueOf(m.u().getId()));
    }

    public static d h() {
        if (f12227a == null) {
            f12227a = new d();
        }
        return f12227a;
    }

    private byte[] i(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            messageDigest = null;
        }
        return messageDigest == null ? new byte[32] : messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
    }

    public byte[] f(boolean z10) {
        return i(z10 ? c() : b());
    }

    public byte[] g(boolean z10) {
        return i(z10 ? e() : d());
    }
}
