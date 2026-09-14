package m0;

import F0.AbstractC0008a;
import X1.f;
import android.content.SharedPreferences;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import t.C0690f;

/* renamed from: m0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class SharedPreferencesEditorC0583a implements SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferencesC0584b f5855a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences.Editor f5856b;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f5858d = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f5857c = new CopyOnWriteArrayList();

    public SharedPreferencesEditorC0583a(SharedPreferencesC0584b sharedPreferencesC0584b, SharedPreferences.Editor editor) {
        this.f5855a = sharedPreferencesC0584b;
        this.f5856b = editor;
    }

    public final void a() {
        if (this.f5858d.getAndSet(false)) {
            SharedPreferencesC0584b sharedPreferencesC0584b = this.f5855a;
            for (String str : ((HashMap) sharedPreferencesC0584b.getAll()).keySet()) {
                if (!this.f5857c.contains(str) && !SharedPreferencesC0584b.c(str)) {
                    this.f5856b.remove(sharedPreferencesC0584b.a(str));
                }
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        a();
        this.f5856b.apply();
        b();
        this.f5857c.clear();
    }

    public final void b() {
        SharedPreferencesC0584b sharedPreferencesC0584b = this.f5855a;
        Iterator it = sharedPreferencesC0584b.f5860b.iterator();
        while (it.hasNext()) {
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
            Iterator it2 = this.f5857c.iterator();
            while (it2.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(sharedPreferencesC0584b, (String) it2.next());
            }
        }
    }

    public final void c(String str, byte[] bArr) {
        SharedPreferencesC0584b sharedPreferencesC0584b = this.f5855a;
        sharedPreferencesC0584b.getClass();
        if (!SharedPreferencesC0584b.c(str)) {
            this.f5857c.add(str);
            if (str == null) {
                str = "__NULL__";
            }
            try {
                String a2 = sharedPreferencesC0584b.a(str);
                try {
                    Pair pair = new Pair(a2, new String(f.b(sharedPreferencesC0584b.f5862d.a(bArr, a2.getBytes(StandardCharsets.UTF_8))), "US-ASCII"));
                    this.f5856b.putString((String) pair.first, (String) pair.second);
                    return;
                } catch (UnsupportedEncodingException e4) {
                    throw new AssertionError(e4);
                }
            } catch (GeneralSecurityException e5) {
                throw new SecurityException("Could not encrypt data: " + e5.getMessage(), e5);
            }
        }
        throw new SecurityException(AbstractC0008a.n(str, " is a reserved key for the encryption keyset."));
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.f5858d.set(true);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5857c;
        a();
        try {
            return this.f5856b.commit();
        } finally {
            b();
            copyOnWriteArrayList.clear();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.putInt(5);
        allocate.put(z3 ? (byte) 1 : (byte) 0);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f4) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(4);
        allocate.putFloat(f4);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(2);
        allocate.putInt(i);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j2) {
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.putInt(3);
        allocate.putLong(j2);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        if (str2 == null) {
            str2 = "__NULL__";
        }
        byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 8);
        allocate.putInt(0);
        allocate.putInt(length);
        allocate.put(bytes);
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        int i = 0;
        if (set == null) {
            set = new C0690f(0);
            set.add("__NULL__");
        }
        ArrayList arrayList = new ArrayList(set.size());
        int size = set.size() * 4;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            byte[] bytes = ((String) it.next()).getBytes(StandardCharsets.UTF_8);
            arrayList.add(bytes);
            size += bytes.length;
        }
        ByteBuffer allocate = ByteBuffer.allocate(size + 4);
        allocate.putInt(1);
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            byte[] bArr = (byte[]) obj;
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        c(str, allocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        SharedPreferencesC0584b sharedPreferencesC0584b = this.f5855a;
        sharedPreferencesC0584b.getClass();
        if (!SharedPreferencesC0584b.c(str)) {
            this.f5856b.remove(sharedPreferencesC0584b.a(str));
            this.f5857c.add(str);
            return this;
        }
        throw new SecurityException(AbstractC0008a.n(str, " is a reserved key for the encryption keyset."));
    }
}
