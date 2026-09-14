package z3;

import com.google.firebase.crashlytics.internal.common.p;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import w3.v;
import w3.w;

/* loaded from: classes.dex */
public class g {

    /* renamed from: g, reason: collision with root package name */
    private static final Charset f16147g = Charset.forName("UTF-8");

    /* renamed from: h, reason: collision with root package name */
    private static final int f16148h = 15;

    /* renamed from: i, reason: collision with root package name */
    private static final x3.h f16149i = new x3.h();

    /* renamed from: j, reason: collision with root package name */
    private static final Comparator<? super File> f16150j = e.a();

    /* renamed from: k, reason: collision with root package name */
    private static final FilenameFilter f16151k = f.a();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f16152a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private final File f16153b;

    /* renamed from: c, reason: collision with root package name */
    private final File f16154c;

    /* renamed from: d, reason: collision with root package name */
    private final File f16155d;

    /* renamed from: e, reason: collision with root package name */
    private final File f16156e;

    /* renamed from: f, reason: collision with root package name */
    private final f4.e f16157f;

    public g(File file, f4.e eVar) {
        File file2 = new File(file, "report-persistence");
        this.f16153b = new File(file2, "sessions");
        this.f16154c = new File(file2, "priority-reports");
        this.f16155d = new File(file2, "reports");
        this.f16156e = new File(file2, "native-reports");
        this.f16157f = eVar;
    }

    private static File D(File file) {
        if (y(file)) {
            return file;
        }
        throw new IOException("Could not create directory " + file);
    }

    private static String E(File file) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f16147g);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
    }

    private static void F(File file) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                F(file2);
            }
        }
        file.delete();
    }

    private static List<File> G(List<File>... listArr) {
        for (List<File> list : listArr) {
            Collections.sort(list, f16150j);
        }
        return f(listArr);
    }

    private static void H(File file, File file2, v.c cVar, String str) {
        try {
            x3.h hVar = f16149i;
            L(new File(D(file2), str), hVar.E(hVar.D(E(file)).n(cVar)));
        } catch (IOException e10) {
            s3.b.f().c("Could not synthesize final native report file for " + file, e10);
        }
    }

    private void I(File file, long j10) {
        boolean z10;
        List<File> p10 = p(file, f16151k);
        if (p10.isEmpty()) {
            s3.b.f().b("Session " + file.getName() + " has no events.");
            return;
        }
        Collections.sort(p10);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z10 = false;
            for (File file2 : p10) {
                try {
                    arrayList.add(f16149i.h(E(file2)));
                } catch (IOException e10) {
                    s3.b.f().c("Could not add event to report for " + file2, e10);
                }
                if (z10 || r(file2.getName())) {
                    z10 = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            s3.b.f().b("Could not parse event files for session " + file.getName());
            return;
        }
        String str = null;
        File file3 = new File(file, "user");
        if (file3.isFile()) {
            try {
                str = E(file3);
            } catch (IOException e11) {
                s3.b.f().c("Could not read user ID file in " + file.getName(), e11);
            }
        }
        J(new File(file, "report"), z10 ? this.f16154c : this.f16155d, arrayList, j10, z10, str);
    }

    private static void J(File file, File file2, List<v.d.AbstractC0312d> list, long j10, boolean z10, String str) {
        try {
            x3.h hVar = f16149i;
            v m10 = hVar.D(E(file)).o(j10, z10, str).m(w.c(list));
            v.d j11 = m10.j();
            if (j11 == null) {
                return;
            }
            L(new File(D(file2), j11.h()), hVar.E(m10));
        } catch (IOException e10) {
            s3.b.f().c("Could not synthesize final report file for " + file, e10);
        }
    }

    private static int K(File file, int i10) {
        List<File> p10 = p(file, c.a());
        Collections.sort(p10, d.a());
        return d(p10, i10);
    }

    private static void L(File file, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f16147g);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    private List<File> c(String str) {
        List<File> o10 = o(this.f16153b, b.a(str));
        Collections.sort(o10, f16150j);
        if (o10.size() <= 8) {
            return o10;
        }
        Iterator<File> it = o10.subList(8, o10.size()).iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        return o10.subList(0, 8);
    }

    private static int d(List<File> list, int i10) {
        int size = list.size();
        for (File file : list) {
            if (size <= i10) {
                return size;
            }
            F(file);
            size--;
        }
        return size;
    }

    private void e() {
        int i10 = this.f16157f.b().a().f9786b;
        List<File> m10 = m();
        int size = m10.size();
        if (size <= i10) {
            return;
        }
        Iterator<File> it = m10.subList(i10, size).iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    private static List<File> f(List<File>... listArr) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (List<File> list : listArr) {
            i10 += list.size();
        }
        arrayList.ensureCapacity(i10);
        for (List<File> list2 : listArr) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    private static String k(int i10, boolean z10) {
        return "event" + String.format(Locale.US, "%010d", Integer.valueOf(i10)) + (z10 ? "_" : "");
    }

    private static List<File> l(File file) {
        return o(file, null);
    }

    private List<File> m() {
        return G(f(l(this.f16154c), l(this.f16156e)), l(this.f16155d));
    }

    private static String n(String str) {
        return str.substring(0, f16148h);
    }

    private static List<File> o(File file, FileFilter fileFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    private static List<File> p(File file, FilenameFilter filenameFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = filenameFilter == null ? file.listFiles() : file.listFiles(filenameFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    private File q(String str) {
        return new File(this.f16153b, str);
    }

    private static boolean r(String str) {
        return str.startsWith("event") && str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(File file, String str) {
        return str.startsWith("event") && !str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean t(String str, File file) {
        return file.isDirectory() && !file.getName().equals(str);
    }

    private static boolean y(File file) {
        return file.exists() || file.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int z(File file, File file2) {
        return n(file.getName()).compareTo(n(file2.getName()));
    }

    public void A(v.d.AbstractC0312d abstractC0312d, String str, boolean z10) {
        int i10 = this.f16157f.b().a().f9785a;
        File q10 = q(str);
        try {
            L(new File(q10, k(this.f16152a.getAndIncrement(), z10)), f16149i.i(abstractC0312d));
        } catch (IOException e10) {
            s3.b.f().c("Could not persist event for session " + str, e10);
        }
        K(q10, i10);
    }

    public void B(v vVar) {
        v.d j10 = vVar.j();
        if (j10 == null) {
            s3.b.f().b("Could not get session for report");
            return;
        }
        String h10 = j10.h();
        try {
            L(new File(D(q(h10)), "report"), f16149i.E(vVar));
        } catch (IOException e10) {
            s3.b.f().c("Could not persist report for session " + h10, e10);
        }
    }

    public void C(String str, String str2) {
        try {
            L(new File(q(str2), "user"), str);
        } catch (IOException e10) {
            s3.b.f().c("Could not persist user ID for session " + str2, e10);
        }
    }

    public void g() {
        Iterator<File> it = m().iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    public void h(String str) {
        FilenameFilter a10 = a.a(str);
        Iterator<File> it = f(p(this.f16154c, a10), p(this.f16156e, a10), p(this.f16155d, a10)).iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    public void i(String str, long j10) {
        for (File file : c(str)) {
            s3.b.f().b("Finalizing report for session " + file.getName());
            I(file, j10);
            F(file);
        }
        e();
    }

    public void j(String str, v.c cVar) {
        H(new File(q(str), "report"), this.f16156e, cVar, str);
    }

    public List<p> x() {
        List<File> m10 = m();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(m10.size());
        for (File file : m()) {
            try {
                arrayList.add(p.a(f16149i.D(E(file)), file.getName()));
            } catch (IOException e10) {
                s3.b.f().c("Could not load report file " + file + "; deleting", e10);
                file.delete();
            }
        }
        return arrayList;
    }
}
