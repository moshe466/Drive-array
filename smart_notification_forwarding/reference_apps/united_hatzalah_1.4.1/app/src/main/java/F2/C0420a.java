package f2;

import F0.C0062n1;
import F0.C0110z2;
import K1.m;
import L1.AbstractC0138a;
import P1.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.stats.CodePackage;
import g2.EnumC0428a;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyStore;
import java.security.ProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import m0.AbstractC0585c;
import m0.AbstractC0586d;
import m0.SharedPreferencesC0584b;
import m0.SharedPreferencesEditorC0583a;

/* renamed from: f2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0420a {

    /* renamed from: a, reason: collision with root package name */
    public String f4596a;

    /* renamed from: b, reason: collision with root package name */
    public Comparable f4597b;

    /* renamed from: c, reason: collision with root package name */
    public Object f4598c;

    /* renamed from: d, reason: collision with root package name */
    public Object f4599d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4600e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4601f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4602g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4603h;
    public Object i;

    public void a(SharedPreferences sharedPreferences, SharedPreferencesC0584b sharedPreferencesC0584b) {
        try {
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if ((value instanceof String) && key.contains(this.f4596a)) {
                    String b4 = b((String) value);
                    SharedPreferencesEditorC0583a sharedPreferencesEditorC0583a = (SharedPreferencesEditorC0583a) sharedPreferencesC0584b.edit();
                    sharedPreferencesEditorC0583a.putString(key, b4);
                    sharedPreferencesEditorC0583a.apply();
                    sharedPreferences.edit().remove(key).apply();
                }
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            ((m) this.f4603h).getClass();
            edit.remove("FlutterSecureSAlgorithmKey");
            edit.remove("FlutterSecureSAlgorithmStorage");
            edit.apply();
        } catch (Exception e4) {
            Log.e("SecureStorageAndroid", "Data migration failed", e4);
        }
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        C0110z2 c0110z2 = (C0110z2) this.f4602g;
        int o2 = c0110z2.o();
        byte[] bArr = new byte[o2];
        System.arraycopy(decode, 0, bArr, 0, o2);
        AlgorithmParameterSpec p = c0110z2.p(bArr);
        int length = decode.length - c0110z2.o();
        byte[] bArr2 = new byte[length];
        System.arraycopy(decode, o2, bArr2, 0, length);
        Cipher cipher = (Cipher) c0110z2.f729b;
        cipher.init(2, (Key) c0110z2.f731d, p);
        return new String(cipher.doFinal(bArr2), (Charset) this.f4597b);
    }

    public void c() {
        d();
        Context context = (Context) this.f4598c;
        SharedPreferences sharedPreferences = context.getSharedPreferences((String) this.f4599d, 0);
        if (((C0110z2) this.f4602g) == null) {
            try {
                f(sharedPreferences);
            } catch (Exception e4) {
                Log.e("SecureStorageAndroid", "StorageCipher initialization failed", e4);
            }
        }
        if (e()) {
            try {
                SharedPreferencesC0584b g3 = g(context);
                this.f4601f = g3;
                a(sharedPreferences, g3);
                return;
            } catch (Exception e5) {
                Log.e("SecureStorageAndroid", "EncryptedSharedPreferences initialization failed", e5);
                this.f4601f = sharedPreferences;
                this.i = Boolean.TRUE;
                return;
            }
        }
        this.f4601f = sharedPreferences;
    }

    public void d() {
        if (((Map) this.f4600e).containsKey("sharedPreferencesName") && !((String) ((Map) this.f4600e).get("sharedPreferencesName")).isEmpty()) {
            this.f4599d = (String) ((Map) this.f4600e).get("sharedPreferencesName");
        }
        if (((Map) this.f4600e).containsKey("preferencesKeyPrefix") && !((String) ((Map) this.f4600e).get("preferencesKeyPrefix")).isEmpty()) {
            this.f4596a = (String) ((Map) this.f4600e).get("preferencesKeyPrefix");
        }
    }

    public boolean e() {
        if (((Boolean) this.i).booleanValue() || !((Map) this.f4600e).containsKey("encryptedSharedPreferences") || !((Map) this.f4600e).get("encryptedSharedPreferences").equals("true")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [K1.m, java.lang.Object] */
    public void f(SharedPreferences sharedPreferences) {
        Context context = (Context) this.f4598c;
        Map map = (Map) this.f4600e;
        ?? obj = new Object();
        String str = "RSA_ECB_PKCS1Padding";
        obj.f1102a = EnumC0428a.valueOf(sharedPreferences.getString("FlutterSecureSAlgorithmKey", "RSA_ECB_PKCS1Padding"));
        String str2 = "AES_CBC_PKCS7Padding";
        obj.f1103b = g2.c.valueOf(sharedPreferences.getString("FlutterSecureSAlgorithmStorage", "AES_CBC_PKCS7Padding"));
        Object obj2 = map.get("keyCipherAlgorithm");
        if (obj2 != null) {
            str = obj2.toString();
        }
        EnumC0428a valueOf = EnumC0428a.valueOf(str);
        int i = valueOf.f4710b;
        int i3 = Build.VERSION.SDK_INT;
        if (i > i3) {
            valueOf = EnumC0428a.RSA_ECB_PKCS1Padding;
        }
        obj.f1104c = valueOf;
        Object obj3 = map.get("storageCipherAlgorithm");
        if (obj3 != null) {
            str2 = obj3.toString();
        }
        g2.c valueOf2 = g2.c.valueOf(str2);
        if (valueOf2.f4714b > i3) {
            valueOf2 = g2.c.AES_CBC_PKCS7Padding;
        }
        obj.f1105d = valueOf2;
        this.f4603h = obj;
        if (e()) {
            m mVar = (m) this.f4603h;
            this.f4602g = ((g2.c) mVar.f1103b).f4713a.d(context, ((EnumC0428a) mVar.f1102a).f4709a.c(context));
            return;
        }
        m mVar2 = (m) this.f4603h;
        EnumC0428a enumC0428a = (EnumC0428a) mVar2.f1102a;
        g2.c cVar = (g2.c) mVar2.f1103b;
        EnumC0428a enumC0428a2 = (EnumC0428a) mVar2.f1104c;
        g2.c cVar2 = (g2.c) mVar2.f1105d;
        if (enumC0428a == enumC0428a2 && cVar == cVar2) {
            this.f4602g = cVar2.f4713a.d(context, enumC0428a2.f4709a.c(context));
            return;
        }
        try {
            this.f4602g = cVar.f4713a.d(context, enumC0428a.f4709a.c(context));
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if ((value instanceof String) && key.contains(this.f4596a)) {
                    hashMap.put(key, b((String) value));
                }
            }
            this.f4602g = cVar2.f4713a.d(context, enumC0428a2.f4709a.c(context));
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (Map.Entry entry2 : hashMap.entrySet()) {
                edit.putString((String) entry2.getKey(), Base64.encodeToString(((C0110z2) this.f4602g).j(((String) entry2.getValue()).getBytes((Charset) this.f4597b)), 0));
            }
            edit.putString("FlutterSecureSAlgorithmKey", enumC0428a2.name());
            edit.putString("FlutterSecureSAlgorithmStorage", cVar2.name());
            edit.apply();
        } catch (Exception e4) {
            Log.e("SecureStorageAndroid", "re-encryption failed", e4);
            this.f4602g = cVar.f4713a.d(context, ((EnumC0428a) mVar2.f1102a).f4709a.c(context));
        }
    }

    public SharedPreferencesC0584b g(Context context) {
        C0110z2 c4;
        C0110z2 c5;
        context.getApplicationContext();
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder("_androidx_security_master_key_", 3).setEncryptionPaddings("NoPadding").setBlockModes(CodePackage.GCM).setKeySize(UserVerificationMethods.USER_VERIFY_HANDPRINT).build();
        if ("_androidx_security_master_key_".equals(AbstractC0585c.a(build))) {
            if (build != null) {
                Object obj = AbstractC0586d.f5864a;
                if (build.getKeySize() == 256) {
                    if (Arrays.equals(build.getBlockModes(), new String[]{CodePackage.GCM})) {
                        if (build.getPurposes() == 3) {
                            if (Arrays.equals(build.getEncryptionPaddings(), new String[]{"NoPadding"})) {
                                if (build.isUserAuthenticationRequired() && build.getUserAuthenticationValidityDurationSeconds() < 1) {
                                    throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
                                }
                                synchronized (AbstractC0586d.f5864a) {
                                    String keystoreAlias = build.getKeystoreAlias();
                                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                                    keyStore.load(null);
                                    if (!keyStore.containsAlias(keystoreAlias)) {
                                        try {
                                            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                                            keyGenerator.init(build);
                                            keyGenerator.generateKey();
                                        } catch (ProviderException e4) {
                                            throw new GeneralSecurityException(e4.getMessage(), e4);
                                        }
                                    }
                                }
                                String keystoreAlias2 = build.getKeystoreAlias();
                                String str = (String) this.f4599d;
                                e.a();
                                AbstractC0138a.a();
                                Context applicationContext = context.getApplicationContext();
                                C0062n1 c0062n1 = new C0062n1();
                                c0062n1.f591f = K1.b.a("AES256_SIV");
                                if (applicationContext != null) {
                                    c0062n1.f589d = applicationContext;
                                    c0062n1.f586a = "__androidx_security_crypto_encrypted_prefs_key_keyset__";
                                    c0062n1.f587b = str;
                                    String d2 = e0.a.d("android-keystore://", keystoreAlias2);
                                    if (d2.startsWith("android-keystore://")) {
                                        c0062n1.f588c = d2;
                                        Q1.a c6 = c0062n1.c();
                                        synchronized (c6) {
                                            c4 = c6.f1723a.c();
                                        }
                                        C0062n1 c0062n12 = new C0062n1();
                                        c0062n12.f591f = K1.b.a("AES256_GCM");
                                        c0062n12.f589d = applicationContext;
                                        c0062n12.f586a = "__androidx_security_crypto_encrypted_prefs_value_keyset__";
                                        c0062n12.f587b = str;
                                        String d4 = e0.a.d("android-keystore://", keystoreAlias2);
                                        if (d4.startsWith("android-keystore://")) {
                                            c0062n12.f588c = d4;
                                            Q1.a c7 = c0062n12.c();
                                            synchronized (c7) {
                                                c5 = c7.f1723a.c();
                                            }
                                            return new SharedPreferencesC0584b(str, applicationContext.getSharedPreferences(str, 0), (K1.a) c5.q(K1.a.class), (K1.c) c4.q(K1.c.class));
                                        }
                                        throw new IllegalArgumentException("key URI must start with android-keystore://");
                                    }
                                    throw new IllegalArgumentException("key URI must start with android-keystore://");
                                }
                                throw new IllegalArgumentException("need an Android context");
                            }
                            throw new IllegalArgumentException("invalid padding mode, want NoPadding got " + Arrays.toString(build.getEncryptionPaddings()));
                        }
                        throw new IllegalArgumentException("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got " + build.getPurposes());
                    }
                    throw new IllegalArgumentException("invalid block mode, want GCM got " + Arrays.toString(build.getBlockModes()));
                }
                throw new IllegalArgumentException("invalid key size, want 256 bits got " + build.getKeySize() + " bits");
            }
            throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
        }
        throw new IllegalArgumentException("KeyGenParamSpec's key alias does not match provided alias (_androidx_security_master_key_ vs " + AbstractC0585c.a(build));
    }

    public HashMap h() {
        c();
        Map<String, ?> all = ((SharedPreferences) this.f4601f).getAll();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getKey().contains(this.f4596a)) {
                String replaceFirst = entry.getKey().replaceFirst(this.f4596a + '_', "");
                if (e()) {
                    hashMap.put(replaceFirst, (String) entry.getValue());
                } else {
                    hashMap.put(replaceFirst, b((String) entry.getValue()));
                }
            }
        }
        return hashMap;
    }

    public void i(String str, String str2) {
        c();
        SharedPreferences.Editor edit = ((SharedPreferences) this.f4601f).edit();
        if (e()) {
            edit.putString(str, str2);
        } else {
            edit.putString(str, Base64.encodeToString(((C0110z2) this.f4602g).j(str2.getBytes((Charset) this.f4597b)), 0));
        }
        edit.apply();
    }
}
