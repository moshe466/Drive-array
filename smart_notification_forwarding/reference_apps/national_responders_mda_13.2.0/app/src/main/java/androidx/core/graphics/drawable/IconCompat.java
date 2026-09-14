package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.util.h;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f2373k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f2374a;

    /* renamed from: b, reason: collision with root package name */
    Object f2375b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2376c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f2377d;

    /* renamed from: e, reason: collision with root package name */
    public int f2378e;

    /* renamed from: f, reason: collision with root package name */
    public int f2379f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f2380g;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f2381h;

    /* renamed from: i, reason: collision with root package name */
    public String f2382i;

    /* renamed from: j, reason: collision with root package name */
    public String f2383j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static IconCompat a(Object obj) {
            h.f(obj);
            int d10 = d(obj);
            if (d10 == 2) {
                return IconCompat.h(null, c(obj), b(obj));
            }
            if (d10 == 4) {
                return IconCompat.f(e(obj));
            }
            if (d10 == 6) {
                return IconCompat.c(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f2375b = obj;
            return iconCompat;
        }

        static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        }

        static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        static int d(Object obj) {
            StringBuilder sb2;
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException unused) {
                sb2 = new StringBuilder();
                sb2.append("Unable to get icon type ");
                sb2.append(obj);
                return -1;
            } catch (NoSuchMethodException unused2) {
                sb2 = new StringBuilder();
                sb2.append("Unable to get icon type ");
                sb2.append(obj);
                return -1;
            } catch (InvocationTargetException unused3) {
                sb2 = new StringBuilder();
                sb2.append("Unable to get icon type ");
                sb2.append(obj);
                return -1;
            }
        }

        static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
        
            if (r0 >= 26) goto L22;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static android.graphics.drawable.Icon g(androidx.core.graphics.drawable.IconCompat r4, android.content.Context r5) {
            /*
                int r0 = r4.f2374a
                r1 = 0
                r2 = 26
                switch(r0) {
                    case -1: goto Lb5;
                    case 0: goto L8;
                    case 1: goto L9c;
                    case 2: goto L91;
                    case 3: goto L84;
                    case 4: goto L7b;
                    case 5: goto L65;
                    case 6: goto L10;
                    default: goto L8;
                }
            L8:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.String r5 = "Unknown type"
                r4.<init>(r5)
                throw r4
            L10:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 30
                if (r0 < r3) goto L20
                android.net.Uri r5 = r4.m()
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.d.a(r5)
                goto La4
            L20:
                if (r5 == 0) goto L4a
                java.io.InputStream r5 = r4.n(r5)
                if (r5 == 0) goto L2f
                android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
                if (r0 < r2) goto L76
                goto L6d
            L2f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Cannot load adaptive icon from uri: "
                r0.append(r1)
                android.net.Uri r4 = r4.m()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L4a:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
                r0.append(r1)
                android.net.Uri r4 = r4.m()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L65:
                int r5 = android.os.Build.VERSION.SDK_INT
                if (r5 < r2) goto L72
                java.lang.Object r5 = r4.f2375b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L6d:
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.b.b(r5)
                goto La4
            L72:
                java.lang.Object r5 = r4.f2375b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L76:
                android.graphics.Bitmap r5 = androidx.core.graphics.drawable.IconCompat.b(r5, r1)
                goto La0
            L7b:
                java.lang.Object r5 = r4.f2375b
                java.lang.String r5 = (java.lang.String) r5
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithContentUri(r5)
                goto La4
            L84:
                java.lang.Object r5 = r4.f2375b
                byte[] r5 = (byte[]) r5
                int r0 = r4.f2378e
                int r1 = r4.f2379f
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithData(r5, r0, r1)
                goto La4
            L91:
                java.lang.String r5 = r4.k()
                int r0 = r4.f2378e
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithResource(r5, r0)
                goto La4
            L9c:
                java.lang.Object r5 = r4.f2375b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            La0:
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithBitmap(r5)
            La4:
                android.content.res.ColorStateList r0 = r4.f2380g
                if (r0 == 0) goto Lab
                r5.setTintList(r0)
            Lab:
                android.graphics.PorterDuff$Mode r4 = r4.f2381h
                android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.f2373k
                if (r4 == r0) goto Lb4
                r5.setTintMode(r4)
            Lb4:
                return r5
            Lb5:
                java.lang.Object r4 = r4.f2375b
                android.graphics.drawable.Icon r4 = (android.graphics.drawable.Icon) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a.g(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f2374a = -1;
        this.f2376c = null;
        this.f2377d = null;
        this.f2378e = 0;
        this.f2379f = 0;
        this.f2380g = null;
        this.f2381h = f2373k;
        this.f2382i = null;
    }

    IconCompat(int i10) {
        this.f2374a = -1;
        this.f2376c = null;
        this.f2377d = null;
        this.f2378e = 0;
        this.f2379f = 0;
        this.f2380g = null;
        this.f2381h = f2373k;
        this.f2382i = null;
        this.f2374a = i10;
    }

    public static IconCompat a(Icon icon) {
        return a.a(icon);
    }

    static Bitmap b(Bitmap bitmap, boolean z10) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f10 = min;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat c(Uri uri) {
        androidx.core.util.c.c(uri);
        return d(uri.toString());
    }

    public static IconCompat d(String str) {
        androidx.core.util.c.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f2375b = str;
        return iconCompat;
    }

    public static IconCompat e(Bitmap bitmap) {
        androidx.core.util.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f2375b = bitmap;
        return iconCompat;
    }

    public static IconCompat f(Uri uri) {
        androidx.core.util.c.c(uri);
        return g(uri.toString());
    }

    public static IconCompat g(String str) {
        androidx.core.util.c.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f2375b = str;
        return iconCompat;
    }

    public static IconCompat h(Resources resources, String str, int i10) {
        androidx.core.util.c.c(str);
        if (i10 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f2378e = i10;
        if (resources != null) {
            try {
                iconCompat.f2375b = resources.getResourceName(i10);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f2375b = str;
        }
        iconCompat.f2383j = str;
        return iconCompat;
    }

    private static String s(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap i() {
        int i10 = this.f2374a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f2375b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i10 == 1) {
            return (Bitmap) this.f2375b;
        }
        if (i10 == 5) {
            return b((Bitmap) this.f2375b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int j() {
        int i10 = this.f2374a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f2375b);
        }
        if (i10 == 2) {
            return this.f2378e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String k() {
        int i10 = this.f2374a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.f2375b);
        }
        if (i10 == 2) {
            String str = this.f2383j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f2375b).split(":", -1)[0] : this.f2383j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int l() {
        int i10 = this.f2374a;
        return (i10 != -1 || Build.VERSION.SDK_INT < 23) ? i10 : a.d(this.f2375b);
    }

    public Uri m() {
        int i10 = this.f2374a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.e(this.f2375b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f2375b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream n(Context context) {
        StringBuilder sb2;
        String str;
        Uri m10 = m();
        String scheme = m10.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(m10);
            } catch (Exception unused) {
                sb2 = new StringBuilder();
                str = "Unable to load image from URI: ";
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f2375b));
            } catch (FileNotFoundException unused2) {
                sb2 = new StringBuilder();
                str = "Unable to load image from path: ";
            }
        }
        sb2.append(str);
        sb2.append(m10);
        return null;
    }

    public void o() {
        Parcelable parcelable;
        this.f2381h = PorterDuff.Mode.valueOf(this.f2382i);
        switch (this.f2374a) {
            case -1:
                parcelable = this.f2377d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.f2377d;
                if (parcelable == null) {
                    byte[] bArr = this.f2376c;
                    this.f2375b = bArr;
                    this.f2374a = 3;
                    this.f2378e = 0;
                    this.f2379f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2376c, Charset.forName("UTF-16"));
                this.f2375b = str;
                if (this.f2374a == 2 && this.f2383j == null) {
                    this.f2383j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2375b = this.f2376c;
                return;
        }
        this.f2375b = parcelable;
    }

    public void p(boolean z10) {
        this.f2382i = this.f2381h.name();
        switch (this.f2374a) {
            case -1:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z10) {
                    Bitmap bitmap = (Bitmap) this.f2375b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2376c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f2376c = ((String) this.f2375b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2376c = (byte[]) this.f2375b;
                return;
            case 4:
            case 6:
                this.f2376c = this.f2375b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f2377d = (Parcelable) this.f2375b;
    }

    @Deprecated
    public Icon q() {
        return r(null);
    }

    public Icon r(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.g(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        int height;
        if (this.f2374a == -1) {
            return String.valueOf(this.f2375b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(s(this.f2374a));
        switch (this.f2374a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f2375b).getWidth());
                sb2.append("x");
                height = ((Bitmap) this.f2375b).getHeight();
                sb2.append(height);
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f2383j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(j())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f2378e);
                if (this.f2379f != 0) {
                    sb2.append(" off=");
                    height = this.f2379f;
                    sb2.append(height);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f2375b);
                break;
        }
        if (this.f2380g != null) {
            sb2.append(" tint=");
            sb2.append(this.f2380g);
        }
        if (this.f2381h != f2373k) {
            sb2.append(" mode=");
            sb2.append(this.f2381h);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
