package x;

import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* renamed from: x.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0775f implements InterfaceC0774e {

    /* renamed from: a, reason: collision with root package name */
    public final String f6735a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6736b = new HashMap();

    public C0775f(String str) {
        this.f6735a = str;
    }

    public final File a(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int indexOf = encodedPath.indexOf(47, 1);
        if (indexOf != -1) {
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = (File) this.f6736b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    String path = canonicalFile.getPath();
                    String path2 = file.getPath();
                    if (FileProvider.access$000(path).startsWith(FileProvider.access$000(path2) + '/')) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        throw new IllegalArgumentException("Unable to find path from root: " + uri);
    }
}
