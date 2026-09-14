package androidx.core.graphics.drawable;

import B.a;
import B.b;
import B.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import org.apache.tika.metadata.TikaCoreProperties;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f3044k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f3045a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3046b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f3047c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f3048d;

    /* renamed from: e, reason: collision with root package name */
    public int f3049e;

    /* renamed from: f, reason: collision with root package name */
    public int f3050f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f3051g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f3052h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public String f3053j;

    public IconCompat() {
        this.f3045a = -1;
        this.f3047c = null;
        this.f3048d = null;
        this.f3049e = 0;
        this.f3050f = 0;
        this.f3051g = null;
        this.f3052h = f3044k;
        this.i = null;
    }

    public static Bitmap a(Bitmap bitmap, boolean z3) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f4 = min;
        float f5 = 0.5f * f4;
        float f6 = 0.9166667f * f5;
        if (z3) {
            float f7 = 0.010416667f * f4;
            paint.setColor(0);
            paint.setShadowLayer(f7, 0.0f, f4 * 0.020833334f, 1023410176);
            canvas.drawCircle(f5, f5, f6, paint);
            paint.setShadowLayer(f7, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f5, f5, f6, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f5, f5, f6, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat b(int i) {
        if (i != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f3049e = i;
            iconCompat.f3046b = "";
            iconCompat.f3053j = "";
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public final int c() {
        int i = this.f3045a;
        if (i == -1) {
            int i3 = Build.VERSION.SDK_INT;
            Object obj = this.f3046b;
            if (i3 >= 28) {
                return b.d(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e4) {
                Log.e("IconCompat", "Unable to get icon resource", e4);
                return 0;
            } catch (NoSuchMethodException e5) {
                Log.e("IconCompat", "Unable to get icon resource", e5);
                return 0;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon resource", e6);
                return 0;
            }
        }
        if (i == 2) {
            return this.f3049e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final int d() {
        int i = this.f3045a;
        if (i == -1) {
            int i3 = Build.VERSION.SDK_INT;
            Object obj = this.f3046b;
            if (i3 >= 28) {
                return b.l(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e4) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e4);
                return -1;
            } catch (NoSuchMethodException e5) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e5);
                return -1;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e6);
                return -1;
            }
        }
        return i;
    }

    public final Uri e() {
        int i = this.f3045a;
        if (i == -1) {
            int i3 = Build.VERSION.SDK_INT;
            Object obj = this.f3046b;
            if (i3 >= 28) {
                return b.m(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e4) {
                Log.e("IconCompat", "Unable to get icon uri", e4);
                return null;
            } catch (NoSuchMethodException e5) {
                Log.e("IconCompat", "Unable to get icon uri", e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.e("IconCompat", "Unable to get icon uri", e6);
                return null;
            }
        }
        if (i != 4 && i != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.f3046b);
    }

    public final Icon f(Context context) {
        Icon createWithBitmap;
        int i = Build.VERSION.SDK_INT;
        int i3 = this.f3045a;
        String str = null;
        r3 = null;
        InputStream openInputStream = null;
        str = null;
        str = null;
        switch (i3) {
            case -1:
                return (Icon) this.f3046b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.f3046b);
                break;
            case 2:
                if (i3 == -1) {
                    Object obj = this.f3046b;
                    if (i >= 28) {
                        str = b.e(obj);
                    } else {
                        try {
                            str = (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
                        } catch (IllegalAccessException e4) {
                            Log.e("IconCompat", "Unable to get icon package", e4);
                        } catch (NoSuchMethodException e5) {
                            Log.e("IconCompat", "Unable to get icon package", e5);
                        } catch (InvocationTargetException e6) {
                            Log.e("IconCompat", "Unable to get icon package", e6);
                        }
                    }
                } else if (i3 == 2) {
                    String str2 = this.f3053j;
                    str = (str2 == null || TextUtils.isEmpty(str2)) ? ((String) this.f3046b).split(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, -1)[0] : this.f3053j;
                } else {
                    throw new IllegalStateException("called getResPackage() on " + this);
                }
                createWithBitmap = Icon.createWithResource(str, this.f3049e);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.f3046b, this.f3049e, this.f3050f);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.f3046b);
                break;
            case 5:
                if (i >= 26) {
                    createWithBitmap = a.b((Bitmap) this.f3046b);
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(a((Bitmap) this.f3046b, false));
                    break;
                }
            case 6:
                if (i >= 30) {
                    createWithBitmap = c.a(e());
                    break;
                } else if (context != null) {
                    Uri e7 = e();
                    String scheme = e7.getScheme();
                    if (!"content".equals(scheme) && !Constants.FILE.equals(scheme)) {
                        try {
                            openInputStream = new FileInputStream(new File((String) this.f3046b));
                        } catch (FileNotFoundException unused) {
                            e7.toString();
                        }
                    } else {
                        try {
                            openInputStream = context.getContentResolver().openInputStream(e7);
                        } catch (Exception unused2) {
                            e7.toString();
                        }
                    }
                    if (openInputStream != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            createWithBitmap = a.b(BitmapFactory.decodeStream(openInputStream));
                            break;
                        } else {
                            createWithBitmap = Icon.createWithBitmap(a(BitmapFactory.decodeStream(openInputStream), false));
                            break;
                        }
                    } else {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + e());
                    }
                } else {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + e());
                }
                break;
        }
        ColorStateList colorStateList = this.f3051g;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f3052h;
        if (mode != f3044k) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    public final String toString() {
        String str;
        if (this.f3045a == -1) {
            return String.valueOf(this.f3046b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f3045a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f3045a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f3046b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f3046b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f3053j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f3049e);
                if (this.f3050f != 0) {
                    sb.append(" off=");
                    sb.append(this.f3050f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f3046b);
                break;
        }
        if (this.f3051g != null) {
            sb.append(" tint=");
            sb.append(this.f3051g);
        }
        if (this.f3052h != f3044k) {
            sb.append(" mode=");
            sb.append(this.f3052h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i) {
        this.f3047c = null;
        this.f3048d = null;
        this.f3049e = 0;
        this.f3050f = 0;
        this.f3051g = null;
        this.f3052h = f3044k;
        this.i = null;
        this.f3045a = i;
    }
}
