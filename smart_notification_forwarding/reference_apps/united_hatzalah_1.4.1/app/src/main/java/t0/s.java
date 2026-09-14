package t0;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.webkit.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import u0.AbstractC0729g;
import u0.J;

/* loaded from: classes.dex */
public final class s implements t {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f6382c = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6383a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6384b;

    public boolean a(Context context) {
        String b4 = J.b((File) this.f6384b);
        String b5 = J.b(context.getCacheDir());
        String b6 = J.b(AbstractC0729g.e(context));
        if ((!b4.startsWith(b5) && !b4.startsWith(b6)) || b4.equals(b5) || b4.equals(b6)) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (b4.startsWith(b6 + f6382c[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // t0.t
    public final WebResourceResponse handle(String str) {
        String str2;
        File file;
        switch (this.f6383a) {
            case 0:
                try {
                    J j2 = (J) this.f6384b;
                    j2.getClass();
                    if (str.length() > 1 && str.charAt(0) == '/') {
                        str2 = str.substring(1);
                    } else {
                        str2 = str;
                    }
                    InputStream open = ((Context) j2.f6552b).getAssets().open(str2, 2);
                    if (str2.endsWith(".svgz")) {
                        open = new GZIPInputStream(open);
                    }
                    return new WebResourceResponse(J.c(str), null, open);
                } catch (IOException e4) {
                    Log.e("WebViewAssetLoader", "Error opening asset path: " + str, e4);
                    return new WebResourceResponse(null, null, null);
                }
            case 1:
                try {
                    return new WebResourceResponse(J.c(str), null, ((J) this.f6384b).d(str));
                } catch (Resources.NotFoundException e5) {
                    Log.e("WebViewAssetLoader", "Resource not found from the path: " + str, e5);
                    return new WebResourceResponse(null, null, null);
                } catch (IOException e6) {
                    Log.e("WebViewAssetLoader", "Error opening resource from the path: " + str, e6);
                    return new WebResourceResponse(null, null, null);
                }
            default:
                File file2 = (File) this.f6384b;
                try {
                    String b4 = J.b(file2);
                    String canonicalPath = new File(file2, str).getCanonicalPath();
                    if (canonicalPath.startsWith(b4)) {
                        file = new File(canonicalPath);
                    } else {
                        file = null;
                    }
                } catch (IOException e7) {
                    Log.e("WebViewAssetLoader", "Error opening the requested path: " + str, e7);
                }
                if (file != null) {
                    InputStream fileInputStream = new FileInputStream(file);
                    if (file.getPath().endsWith(".svgz")) {
                        fileInputStream = new GZIPInputStream(fileInputStream);
                    }
                    return new WebResourceResponse(J.c(str), null, fileInputStream);
                }
                Log.e("WebViewAssetLoader", String.format("The requested file: %s is outside the mounted directory: %s", str, file2));
                return new WebResourceResponse(null, null, null);
        }
    }

    public s(Context context, File file) {
        this.f6383a = 2;
        try {
            this.f6384b = new File(J.b(file));
            if (a(context)) {
                return;
            }
            throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
        } catch (IOException e4) {
            throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e4);
        }
    }
}
