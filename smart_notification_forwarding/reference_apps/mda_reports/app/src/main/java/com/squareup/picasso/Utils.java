package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Utils {
    private static final int KEY_PADDING = 50;
    private static final int MAX_DISK_CACHE_SIZE = 52428800;
    private static final int MIN_DISK_CACHE_SIZE = 5242880;
    private static final String PICASSO_CACHE = "picasso-cache";
    static final StringBuilder a = new StringBuilder();
    private static final ByteString WEBP_FILE_HEADER_RIFF = ByteString.encodeUtf8("RIFF");
    private static final ByteString WEBP_FILE_HEADER_WEBP = ByteString.encodeUtf8("WEBP");

    /* loaded from: classes2.dex */
    private static class PicassoThread extends Thread {
        PicassoThread(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* loaded from: classes2.dex */
    static class PicassoThreadFactory implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new PicassoThread(runnable);
        }
    }

    private Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context) {
        ActivityManager activityManager = (ActivityManager) a(context, "activity");
        return (int) ((((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass()) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) / 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Resources resources, Request request) {
        Uri uri;
        if (request.resourceId != 0 || (uri = request.uri) == null) {
            return request.resourceId;
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + request.uri);
        }
        List<String> pathSegments = request.uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + request.uri);
        }
        if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + request.uri);
            }
        }
        if (pathSegments.size() == 2) {
            return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        }
        throw new FileNotFoundException("More than two path segments: " + request.uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Bitmap bitmap) {
        int allocationByteCount = Build.VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(18)
    public static long a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = ((Build.VERSION.SDK_INT < 18 ? statFs.getBlockCount() : statFs.getBlockCountLong()) * (Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() : statFs.getBlockSizeLong())) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800L), 5242880L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources a(Context context, Request request) {
        Uri uri;
        if (request.resourceId != 0 || (uri = request.uri) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + request.uri);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + request.uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(BitmapHunter bitmapHunter) {
        return a(bitmapHunter, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(BitmapHunter bitmapHunter, String str) {
        StringBuilder sb = new StringBuilder(str);
        Action b = bitmapHunter.b();
        if (b != null) {
            sb.append(b.b.c());
        }
        List<Action> c = bitmapHunter.c();
        if (c != null) {
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || b != null) {
                    sb.append(", ");
                }
                sb.append(c.get(i).b.c());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Request request) {
        String a2 = a(request, a);
        a.setLength(0);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(com.squareup.picasso.Request r4, java.lang.StringBuilder r5) {
        /*
            java.lang.String r0 = r4.stableKey
            r1 = 50
            if (r0 == 0) goto L14
            int r0 = r0.length()
            int r0 = r0 + r1
            r5.ensureCapacity(r0)
            java.lang.String r0 = r4.stableKey
        L10:
            r5.append(r0)
            goto L2d
        L14:
            android.net.Uri r0 = r4.uri
            if (r0 == 0) goto L25
            java.lang.String r0 = r0.toString()
            int r2 = r0.length()
            int r2 = r2 + r1
            r5.ensureCapacity(r2)
            goto L10
        L25:
            r5.ensureCapacity(r1)
            int r0 = r4.resourceId
            r5.append(r0)
        L2d:
            r0 = 10
            r5.append(r0)
            float r1 = r4.rotationDegrees
            r2 = 0
            r3 = 120(0x78, float:1.68E-43)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L5e
            java.lang.String r1 = "rotation:"
            r5.append(r1)
            float r1 = r4.rotationDegrees
            r5.append(r1)
            boolean r1 = r4.hasRotationPivot
            if (r1 == 0) goto L5b
            r1 = 64
            r5.append(r1)
            float r1 = r4.rotationPivotX
            r5.append(r1)
            r5.append(r3)
            float r1 = r4.rotationPivotY
            r5.append(r1)
        L5b:
            r5.append(r0)
        L5e:
            boolean r1 = r4.hasSize()
            if (r1 == 0) goto L79
            java.lang.String r1 = "resize:"
            r5.append(r1)
            int r1 = r4.targetWidth
            r5.append(r1)
            r5.append(r3)
            int r1 = r4.targetHeight
            r5.append(r1)
            r5.append(r0)
        L79:
            boolean r1 = r4.centerCrop
            if (r1 == 0) goto L8b
            java.lang.String r1 = "centerCrop:"
            r5.append(r1)
            int r1 = r4.centerCropGravity
            r5.append(r1)
        L87:
            r5.append(r0)
            goto L95
        L8b:
            boolean r1 = r4.centerInside
            if (r1 == 0) goto L95
            java.lang.String r1 = "centerInside"
            r5.append(r1)
            goto L87
        L95:
            java.util.List<com.squareup.picasso.Transformation> r1 = r4.transformations
            if (r1 == 0) goto Lb5
            r2 = 0
            int r1 = r1.size()
        L9e:
            if (r2 >= r1) goto Lb5
            java.util.List<com.squareup.picasso.Transformation> r3 = r4.transformations
            java.lang.Object r3 = r3.get(r2)
            com.squareup.picasso.Transformation r3 = (com.squareup.picasso.Transformation) r3
            java.lang.String r3 = r3.key()
            r5.append(r3)
            r5.append(r0)
            int r2 = r2 + 1
            goto L9e
        Lb5:
            java.lang.String r4 = r5.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.Utils.a(com.squareup.picasso.Request, java.lang.StringBuilder):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        if (!c()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Looper looper) {
        Handler handler = new Handler(looper) { // from class: com.squareup.picasso.Utils.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000L);
            }
        };
        handler.sendMessageDelayed(handler.obtainMessage(), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, String str3) {
        a(str, str2, str3, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(0L, WEBP_FILE_HEADER_RIFF) && bufferedSource.rangeEquals(8L, WEBP_FILE_HEADER_WEBP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), PICASSO_CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        if (c()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            return Build.VERSION.SDK_INT < 17 ? Settings.System.getInt(contentResolver, "airplane_mode_on", 0) != 0 : Settings.Global.getInt(contentResolver, "airplane_mode_on", 0) != 0;
        } catch (NullPointerException | SecurityException unused) {
            return false;
        }
    }
}
