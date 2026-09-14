package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.squareup.picasso.Picasso;
import okio.Source;

/* loaded from: classes2.dex */
public abstract class RequestHandler {

    /* loaded from: classes2.dex */
    public static final class Result {
        private final Bitmap bitmap;
        private final int exifOrientation;
        private final Picasso.LoadedFrom loadedFrom;
        private final Source source;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Result(@NonNull Bitmap bitmap, @NonNull Picasso.LoadedFrom loadedFrom) {
            this(bitmap, null, loadedFrom, 0);
            Utils.a(bitmap, "bitmap == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Result(@Nullable Bitmap bitmap, @Nullable Source source, @NonNull Picasso.LoadedFrom loadedFrom, int i) {
            if ((bitmap != null) == (source != null)) {
                throw new AssertionError();
            }
            this.bitmap = bitmap;
            this.source = source;
            Utils.a(loadedFrom, "loadedFrom == null");
            this.loadedFrom = loadedFrom;
            this.exifOrientation = i;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Result(@NonNull Source source, @NonNull Picasso.LoadedFrom loadedFrom) {
            this(null, source, loadedFrom, 0);
            Utils.a(source, "source == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.exifOrientation;
        }

        @Nullable
        public Bitmap getBitmap() {
            return this.bitmap;
        }

        @NonNull
        public Picasso.LoadedFrom getLoadedFrom() {
            return this.loadedFrom;
        }

        @Nullable
        public Source getSource() {
            return this.source;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BitmapFactory.Options a(Request request) {
        boolean hasSize = request.hasSize();
        boolean z = request.config != null;
        BitmapFactory.Options options = null;
        if (hasSize || z || request.purgeable) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = hasSize;
            boolean z2 = request.purgeable;
            options.inInputShareable = z2;
            options.inPurgeable = z2;
            if (z) {
                options.inPreferredConfig = request.config;
            }
        }
        return options;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, Request request) {
        int max;
        double d;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d = i3 / i;
            } else if (i == 0) {
                d = i4 / i2;
            } else {
                int floor = (int) Math.floor(i4 / i2);
                int floor2 = (int) Math.floor(i3 / i);
                max = request.centerInside ? Math.max(floor, floor2) : Math.min(floor, floor2);
            }
            max = (int) Math.floor(d);
        } else {
            max = 1;
        }
        options.inSampleSize = max;
        options.inJustDecodeBounds = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int i2, BitmapFactory.Options options, Request request) {
        a(i, i2, options.outWidth, options.outHeight, options, request);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return false;
    }

    public abstract boolean canHandleRequest(Request request);

    @Nullable
    public abstract Result load(Request request, int i);
}
