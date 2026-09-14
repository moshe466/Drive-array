package v3;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.h;
import java.io.File;
import java.util.Set;

/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final c f14633d = new c();

    /* renamed from: a, reason: collision with root package name */
    private final Context f14634a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0301b f14635b;

    /* renamed from: c, reason: collision with root package name */
    private v3.a f14636c;

    /* renamed from: v3.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0301b {
        File a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements v3.a {
        private c() {
        }

        @Override // v3.a
        public void a() {
        }

        @Override // v3.a
        public String b() {
            return null;
        }

        @Override // v3.a
        public byte[] c() {
            return null;
        }

        @Override // v3.a
        public void d() {
        }

        @Override // v3.a
        public void e(long j10, String str) {
        }
    }

    public b(Context context, InterfaceC0301b interfaceC0301b) {
        this(context, interfaceC0301b, null);
    }

    public b(Context context, InterfaceC0301b interfaceC0301b, String str) {
        this.f14634a = context;
        this.f14635b = interfaceC0301b;
        this.f14636c = f14633d;
        g(str);
    }

    private String e(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring(20, lastIndexOf);
    }

    private File f(String str) {
        return new File(this.f14635b.a(), "crashlytics-userlog-" + str + ".temp");
    }

    public void a() {
        this.f14636c.d();
    }

    public void b(Set<String> set) {
        File[] listFiles = this.f14635b.a().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(e(file))) {
                    file.delete();
                }
            }
        }
    }

    public byte[] c() {
        return this.f14636c.c();
    }

    public String d() {
        return this.f14636c.b();
    }

    public final void g(String str) {
        this.f14636c.a();
        this.f14636c = f14633d;
        if (str == null) {
            return;
        }
        if (h.l(this.f14634a, "com.crashlytics.CollectCustomLogs", true)) {
            h(f(str), 65536);
        } else {
            s3.b.f().b("Preferences requested no custom logs. Aborting log file creation.");
        }
    }

    void h(File file, int i10) {
        this.f14636c = new d(file, i10);
    }

    public void i(long j10, String str) {
        this.f14636c.e(j10, str);
    }
}
