package io.flutter.plugins.imagepicker;

import Y.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ImageResizer {
    private final Context context;
    private final ExifDataCopier exifDataCopier;

    public ImageResizer(Context context, ExifDataCopier exifDataCopier) {
        this.context = context;
        this.exifDataCopier = exifDataCopier;
    }

    private int calculateSampleSize(BitmapFactory.Options options, int i, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 <= i3 && i5 <= i) {
            return 1;
        }
        int i7 = i4 / 2;
        int i8 = i5 / 2;
        while (i7 / i6 >= i3 && i8 / i6 >= i) {
            i6 *= 2;
        }
        return i6;
    }

    private I.c calculateTargetSize(double d2, double d4, Double d5, Double d6) {
        boolean z3;
        boolean z4;
        double d7;
        double d8;
        boolean z5;
        double d9 = d2 / d4;
        boolean z6 = false;
        if (d5 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (d6 != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3) {
            d7 = Math.min(d2, Math.round(d5.doubleValue()));
        } else {
            d7 = d2;
        }
        if (z4) {
            d8 = Math.min(d4, Math.round(d6.doubleValue()));
        } else {
            d8 = d4;
        }
        if (z3 && d5.doubleValue() < d2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4 && d6.doubleValue() < d4) {
            z6 = true;
        }
        if (z5 || z6) {
            double d10 = d8 * d9;
            double d11 = d7 / d9;
            if (d11 > d8) {
                d7 = Math.round(d10);
            } else {
                d8 = Math.round(d11);
            }
        }
        return new I.c((float) d7, (float) d8);
    }

    private void copyExif(String str, String str2) {
        try {
            this.exifDataCopier.copyExif(new h(str), new h(str2));
        } catch (Exception e4) {
            Log.e("ImageResizer", "Error preserving Exif data on selected image: " + e4);
        }
    }

    private File createFile(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File createImageOnExternalDirectory(String str, Bitmap bitmap, int i) {
        Bitmap.CompressFormat compressFormat;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.hasAlpha()) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        File createFile = createFile(this.context.getCacheDir(), str);
        FileOutputStream createOutputStream = createOutputStream(createFile);
        createOutputStream.write(byteArrayOutputStream.toByteArray());
        createOutputStream.close();
        return createFile;
    }

    private FileOutputStream createOutputStream(File file) {
        return new FileOutputStream(file);
    }

    private Bitmap createScaledBitmap(Bitmap bitmap, int i, int i3, boolean z3) {
        return Bitmap.createScaledBitmap(bitmap, i, i3, z3);
    }

    private Bitmap decodeFile(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    private File resizedImage(Bitmap bitmap, Double d2, Double d4, int i, String str) {
        return createImageOnExternalDirectory(e0.a.d("/scaled_", str), createScaledBitmap(bitmap, d2.intValue(), d4.intValue(), false), i);
    }

    public I.c readFileDimensions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFile(str, options);
        return new I.c(options.outWidth, options.outHeight);
    }

    public String resizeImageIfNeeded(String str, Double d2, Double d4, int i) {
        I.c readFileDimensions = readFileDimensions(str);
        float f4 = readFileDimensions.f884a;
        float f5 = readFileDimensions.f885b;
        if (f4 != -1.0f && f5 != -1.0f) {
            if (d2 == null && d4 == null && i >= 100) {
                return str;
            }
            try {
                String str2 = str.split(RemoteSettings.FORWARD_SLASH_STRING)[r2.length - 1];
                I.c calculateTargetSize = calculateTargetSize(readFileDimensions.f884a, f5, d2, d4);
                BitmapFactory.Options options = new BitmapFactory.Options();
                float f6 = calculateTargetSize.f884a;
                float f7 = calculateTargetSize.f885b;
                options.inSampleSize = calculateSampleSize(options, (int) f6, (int) f7);
                Bitmap decodeFile = decodeFile(str, options);
                if (decodeFile == null) {
                    return str;
                }
                File resizedImage = resizedImage(decodeFile, Double.valueOf(calculateTargetSize.f884a), Double.valueOf(f7), i, str2);
                copyExif(str, resizedImage.getPath());
                return resizedImage.getPath();
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }
        return str;
    }
}
