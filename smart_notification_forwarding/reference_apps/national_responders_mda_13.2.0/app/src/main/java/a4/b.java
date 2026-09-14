package a4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* loaded from: classes.dex */
public class b extends FileOutputStream {

    /* renamed from: i, reason: collision with root package name */
    public static final FilenameFilter f181i = new a();

    /* renamed from: f, reason: collision with root package name */
    private final String f182f;

    /* renamed from: g, reason: collision with root package name */
    private File f183g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f184h;

    /* loaded from: classes.dex */
    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public b(File file, String str) {
        super(new File(file, str + ".cls_temp"));
        this.f184h = false;
        String str2 = file + File.separator + str;
        this.f182f = str2;
        this.f183g = new File(str2 + ".cls_temp");
    }

    public void c() {
        if (this.f184h) {
            return;
        }
        this.f184h = true;
        super.flush();
        super.close();
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f184h) {
            return;
        }
        this.f184h = true;
        super.flush();
        super.close();
        File file = new File(this.f182f + ".cls");
        if (this.f183g.renameTo(file)) {
            this.f183g = null;
            return;
        }
        String str = "";
        if (file.exists()) {
            str = " (target already exists)";
        } else if (!this.f183g.exists()) {
            str = " (source does not exist)";
        }
        throw new IOException("Could not rename temp file: " + this.f183g + " -> " + file + str);
    }
}
