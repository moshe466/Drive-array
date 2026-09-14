package m0;

import F0.AbstractC0008a;
import T.k;
import X1.f;
import android.content.SharedPreferences;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import t.C0690f;

/* renamed from: m0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class SharedPreferencesC0584b implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f5859a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f5860b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final String f5861c;

    /* renamed from: d, reason: collision with root package name */
    public final K1.a f5862d;

    /* renamed from: e, reason: collision with root package name */
    public final K1.c f5863e;

    public SharedPreferencesC0584b(String str, SharedPreferences sharedPreferences, K1.a aVar, K1.c cVar) {
        this.f5861c = str;
        this.f5859a = sharedPreferences;
        this.f5862d = aVar;
        this.f5863e = cVar;
    }

    public static boolean c(String str) {
        if (!"__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) && !"__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str)) {
            return false;
        }
        return true;
    }

    public final String a(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            try {
                return new String(f.b(this.f5863e.a(str.getBytes(StandardCharsets.UTF_8), this.f5861c.getBytes())), "US-ASCII");
            } catch (UnsupportedEncodingException e4) {
                throw new AssertionError(e4);
            }
        } catch (GeneralSecurityException e5) {
            throw new SecurityException("Could not encrypt key. " + e5.getMessage(), e5);
        }
    }

    public final Object b(String str) {
        int i;
        String str2;
        if (!c(str)) {
            if (str == null) {
                str = "__NULL__";
            }
            try {
                String a2 = a(str);
                String string = this.f5859a.getString(a2, null);
                if (string != null) {
                    byte[] a4 = f.a(string);
                    K1.a aVar = this.f5862d;
                    Charset charset = StandardCharsets.UTF_8;
                    ByteBuffer wrap = ByteBuffer.wrap(aVar.b(a4, a2.getBytes(charset)));
                    boolean z3 = false;
                    wrap.position(0);
                    int i3 = wrap.getInt();
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                        if (i3 != 5) {
                                            i = 0;
                                        } else {
                                            i = 6;
                                        }
                                    } else {
                                        i = 5;
                                    }
                                } else {
                                    i = 4;
                                }
                            } else {
                                i = 3;
                            }
                        } else {
                            i = 2;
                        }
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        int b4 = k.b(i);
                        if (b4 != 0) {
                            if (b4 != 1) {
                                if (b4 != 2) {
                                    if (b4 != 3) {
                                        if (b4 != 4) {
                                            if (b4 == 5) {
                                                if (wrap.get() != 0) {
                                                    z3 = true;
                                                }
                                                return Boolean.valueOf(z3);
                                            }
                                            switch (i) {
                                                case 1:
                                                    str2 = "STRING";
                                                    break;
                                                case 2:
                                                    str2 = "STRING_SET";
                                                    break;
                                                case 3:
                                                    str2 = "INT";
                                                    break;
                                                case 4:
                                                    str2 = "LONG";
                                                    break;
                                                case 5:
                                                    str2 = "FLOAT";
                                                    break;
                                                case 6:
                                                    str2 = "BOOLEAN";
                                                    break;
                                                default:
                                                    str2 = "null";
                                                    break;
                                            }
                                            throw new SecurityException("Unhandled type for encrypted pref value: ".concat(str2));
                                        }
                                        return Float.valueOf(wrap.getFloat());
                                    }
                                    return Long.valueOf(wrap.getLong());
                                }
                                return Integer.valueOf(wrap.getInt());
                            }
                            C0690f c0690f = new C0690f(0);
                            while (wrap.hasRemaining()) {
                                int i4 = wrap.getInt();
                                ByteBuffer slice = wrap.slice();
                                slice.limit(i4);
                                wrap.position(wrap.position() + i4);
                                c0690f.add(StandardCharsets.UTF_8.decode(slice).toString());
                            }
                            if (c0690f.f6357c != 1 || !"__NULL__".equals(c0690f.f6356b[0])) {
                                return c0690f;
                            }
                        } else {
                            int i5 = wrap.getInt();
                            ByteBuffer slice2 = wrap.slice();
                            wrap.limit(i5);
                            String charBuffer = charset.decode(slice2).toString();
                            if (!charBuffer.equals("__NULL__")) {
                                return charBuffer;
                            }
                        }
                    } else {
                        throw new SecurityException("Unknown type ID for encrypted pref value: " + i3);
                    }
                }
                return null;
            } catch (GeneralSecurityException e4) {
                throw new SecurityException("Could not decrypt value. " + e4.getMessage(), e4);
            }
        }
        throw new SecurityException(AbstractC0008a.n(str, " is a reserved key for the encryption keyset."));
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        if (!c(str)) {
            return this.f5859a.contains(a(str));
        }
        throw new SecurityException(AbstractC0008a.n(str, " is a reserved key for the encryption keyset."));
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new SharedPreferencesEditorC0583a(this, this.f5859a.edit());
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : this.f5859a.getAll().entrySet()) {
            if (!c(entry.getKey())) {
                try {
                    String str = new String(this.f5863e.b(f.a(entry.getKey()), this.f5861c.getBytes()), StandardCharsets.UTF_8);
                    if (str.equals("__NULL__")) {
                        str = null;
                    }
                    hashMap.put(str, b(str));
                } catch (GeneralSecurityException e4) {
                    throw new SecurityException("Could not decrypt key. " + e4.getMessage(), e4);
                }
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z3) {
        Object b4 = b(str);
        if (b4 instanceof Boolean) {
            return ((Boolean) b4).booleanValue();
        }
        return z3;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f4) {
        Object b4 = b(str);
        if (b4 instanceof Float) {
            return ((Float) b4).floatValue();
        }
        return f4;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        Object b4 = b(str);
        if (b4 instanceof Integer) {
            return ((Integer) b4).intValue();
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j2) {
        Object b4 = b(str);
        if (b4 instanceof Long) {
            return ((Long) b4).longValue();
        }
        return j2;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Object b4 = b(str);
        if (b4 instanceof String) {
            return (String) b4;
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Set c0690f;
        Object b4 = b(str);
        if (b4 instanceof Set) {
            c0690f = (Set) b4;
        } else {
            c0690f = new C0690f(0);
        }
        if (c0690f.size() > 0) {
            return c0690f;
        }
        return set;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f5860b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f5860b.remove(onSharedPreferenceChangeListener);
    }
}
