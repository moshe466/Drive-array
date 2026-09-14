package com.squareup.picasso;

import android.app.Notification;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RemoteViewsAction;
import com.squareup.picasso.Request;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class RequestCreator {
    private static final AtomicInteger nextId = new AtomicInteger();
    private final Request.Builder data;
    private boolean deferred;
    private Drawable errorDrawable;
    private int errorResId;
    private int memoryPolicy;
    private int networkPolicy;
    private boolean noFade;
    private final Picasso picasso;
    private Drawable placeholderDrawable;
    private int placeholderResId;
    private boolean setPlaceholder;
    private Object tag;

    @VisibleForTesting
    RequestCreator() {
        this.setPlaceholder = true;
        this.picasso = null;
        this.data = new Request.Builder(null, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestCreator(Picasso picasso, Uri uri, int i) {
        this.setPlaceholder = true;
        if (picasso.k) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.picasso = picasso;
        this.data = new Request.Builder(uri, i, picasso.h);
    }

    private Request createRequest(long j) {
        int andIncrement = nextId.getAndIncrement();
        Request build = this.data.build();
        build.a = andIncrement;
        build.b = j;
        boolean z = this.picasso.j;
        if (z) {
            Utils.a("Main", "created", build.f(), build.toString());
        }
        Request a = this.picasso.a(build);
        if (a != build) {
            a.a = andIncrement;
            a.b = j;
            if (z) {
                Utils.a("Main", "changed", a.c(), "into " + a);
            }
        }
        return a;
    }

    private Drawable getPlaceholderDrawable() {
        int i = this.placeholderResId;
        if (i == 0) {
            return this.placeholderDrawable;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            return this.picasso.a.getDrawable(i);
        }
        if (i2 >= 16) {
            return this.picasso.a.getResources().getDrawable(this.placeholderResId);
        }
        TypedValue typedValue = new TypedValue();
        this.picasso.a.getResources().getValue(this.placeholderResId, typedValue, true);
        return this.picasso.a.getResources().getDrawable(typedValue.resourceId);
    }

    private void performRemoteViewInto(RemoteViewsAction remoteViewsAction) {
        Bitmap a;
        if (MemoryPolicy.a(this.memoryPolicy) && (a = this.picasso.a(remoteViewsAction.b())) != null) {
            remoteViewsAction.complete(a, Picasso.LoadedFrom.MEMORY);
            return;
        }
        int i = this.placeholderResId;
        if (i != 0) {
            remoteViewsAction.a(i);
        }
        this.picasso.a((Action) remoteViewsAction);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestCreator a() {
        this.tag = null;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object b() {
        return this.tag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestCreator c() {
        this.deferred = false;
        return this;
    }

    public RequestCreator centerCrop() {
        this.data.centerCrop(17);
        return this;
    }

    public RequestCreator centerCrop(int i) {
        this.data.centerCrop(i);
        return this;
    }

    public RequestCreator centerInside() {
        this.data.centerInside();
        return this;
    }

    public RequestCreator config(@NonNull Bitmap.Config config) {
        this.data.config(config);
        return this;
    }

    public RequestCreator error(@DrawableRes int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        }
        if (this.errorDrawable != null) {
            throw new IllegalStateException("Error image already set.");
        }
        this.errorResId = i;
        return this;
    }

    public RequestCreator error(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Error image may not be null.");
        }
        if (this.errorResId != 0) {
            throw new IllegalStateException("Error image already set.");
        }
        this.errorDrawable = drawable;
        return this;
    }

    public void fetch() {
        fetch(null);
    }

    public void fetch(@Nullable Callback callback) {
        long nanoTime = System.nanoTime();
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        }
        if (this.data.a()) {
            if (!this.data.b()) {
                this.data.priority(Picasso.Priority.LOW);
            }
            Request createRequest = createRequest(nanoTime);
            String a = Utils.a(createRequest, new StringBuilder());
            if (!MemoryPolicy.a(this.memoryPolicy) || this.picasso.a(a) == null) {
                this.picasso.c(new FetchAction(this.picasso, createRequest, this.memoryPolicy, this.networkPolicy, this.tag, a, callback));
                return;
            }
            if (this.picasso.j) {
                Utils.a("Main", "completed", createRequest.f(), "from " + Picasso.LoadedFrom.MEMORY);
            }
            if (callback != null) {
                callback.onSuccess();
            }
        }
    }

    public RequestCreator fit() {
        this.deferred = true;
        return this;
    }

    public Bitmap get() {
        long nanoTime = System.nanoTime();
        Utils.b();
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with get.");
        }
        if (!this.data.a()) {
            return null;
        }
        Request createRequest = createRequest(nanoTime);
        GetAction getAction = new GetAction(this.picasso, createRequest, this.memoryPolicy, this.networkPolicy, this.tag, Utils.a(createRequest, new StringBuilder()));
        Picasso picasso = this.picasso;
        return BitmapHunter.a(picasso, picasso.b, picasso.c, picasso.d, getAction).l();
    }

    public void into(ImageView imageView) {
        into(imageView, null);
    }

    public void into(ImageView imageView, Callback callback) {
        Bitmap a;
        long nanoTime = System.nanoTime();
        Utils.a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (!this.data.a()) {
            this.picasso.cancelRequest(imageView);
            if (this.setPlaceholder) {
                PicassoDrawable.a(imageView, getPlaceholderDrawable());
                return;
            }
            return;
        }
        if (this.deferred) {
            if (this.data.c()) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                if (this.setPlaceholder) {
                    PicassoDrawable.a(imageView, getPlaceholderDrawable());
                }
                this.picasso.a(imageView, new DeferredRequestCreator(this, imageView, callback));
                return;
            }
            this.data.resize(width, height);
        }
        Request createRequest = createRequest(nanoTime);
        String a2 = Utils.a(createRequest);
        if (!MemoryPolicy.a(this.memoryPolicy) || (a = this.picasso.a(a2)) == null) {
            if (this.setPlaceholder) {
                PicassoDrawable.a(imageView, getPlaceholderDrawable());
            }
            this.picasso.a((Action) new ImageViewAction(this.picasso, imageView, createRequest, this.memoryPolicy, this.networkPolicy, this.errorResId, this.errorDrawable, a2, this.tag, callback, this.noFade));
            return;
        }
        this.picasso.cancelRequest(imageView);
        Picasso picasso = this.picasso;
        PicassoDrawable.a(imageView, picasso.a, a, Picasso.LoadedFrom.MEMORY, this.noFade, picasso.i);
        if (this.picasso.j) {
            Utils.a("Main", "completed", createRequest.f(), "from " + Picasso.LoadedFrom.MEMORY);
        }
        if (callback != null) {
            callback.onSuccess();
        }
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, int i2, @NonNull Notification notification) {
        into(remoteViews, i, i2, notification, null);
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, int i2, @NonNull Notification notification, @Nullable String str) {
        into(remoteViews, i, i2, notification, str, null);
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, int i2, @NonNull Notification notification, @Nullable String str, Callback callback) {
        long nanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("RemoteViews must not be null.");
        }
        if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null.");
        }
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with RemoteViews.");
        }
        if (this.placeholderDrawable != null || this.placeholderResId != 0 || this.errorDrawable != null) {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        }
        Request createRequest = createRequest(nanoTime);
        performRemoteViewInto(new RemoteViewsAction.NotificationAction(this.picasso, createRequest, remoteViews, i, i2, notification, str, this.memoryPolicy, this.networkPolicy, Utils.a(createRequest, new StringBuilder()), this.tag, this.errorResId, callback));
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, @NonNull int[] iArr) {
        into(remoteViews, i, iArr, (Callback) null);
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i, @NonNull int[] iArr, Callback callback) {
        long nanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("remoteViews must not be null.");
        }
        if (iArr == null) {
            throw new IllegalArgumentException("appWidgetIds must not be null.");
        }
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with remote views.");
        }
        if (this.placeholderDrawable != null || this.placeholderResId != 0 || this.errorDrawable != null) {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        }
        Request createRequest = createRequest(nanoTime);
        performRemoteViewInto(new RemoteViewsAction.AppWidgetAction(this.picasso, createRequest, remoteViews, i, iArr, this.memoryPolicy, this.networkPolicy, Utils.a(createRequest, new StringBuilder()), this.tag, this.errorResId, callback));
    }

    public void into(@NonNull Target target) {
        Bitmap a;
        long nanoTime = System.nanoTime();
        Utils.a();
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        if (!this.data.a()) {
            this.picasso.cancelRequest(target);
            target.onPrepareLoad(this.setPlaceholder ? getPlaceholderDrawable() : null);
            return;
        }
        Request createRequest = createRequest(nanoTime);
        String a2 = Utils.a(createRequest);
        if (!MemoryPolicy.a(this.memoryPolicy) || (a = this.picasso.a(a2)) == null) {
            target.onPrepareLoad(this.setPlaceholder ? getPlaceholderDrawable() : null);
            this.picasso.a((Action) new TargetAction(this.picasso, target, createRequest, this.memoryPolicy, this.networkPolicy, this.errorDrawable, a2, this.tag, this.errorResId));
        } else {
            this.picasso.cancelRequest(target);
            target.onBitmapLoaded(a, Picasso.LoadedFrom.MEMORY);
        }
    }

    public RequestCreator memoryPolicy(@NonNull MemoryPolicy memoryPolicy, @NonNull MemoryPolicy... memoryPolicyArr) {
        if (memoryPolicy == null) {
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        this.memoryPolicy = memoryPolicy.a | this.memoryPolicy;
        if (memoryPolicyArr == null) {
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        if (memoryPolicyArr.length > 0) {
            for (MemoryPolicy memoryPolicy2 : memoryPolicyArr) {
                if (memoryPolicy2 == null) {
                    throw new IllegalArgumentException("Memory policy cannot be null.");
                }
                this.memoryPolicy = memoryPolicy2.a | this.memoryPolicy;
            }
        }
        return this;
    }

    public RequestCreator networkPolicy(@NonNull NetworkPolicy networkPolicy, @NonNull NetworkPolicy... networkPolicyArr) {
        if (networkPolicy == null) {
            throw new IllegalArgumentException("Network policy cannot be null.");
        }
        this.networkPolicy = networkPolicy.a | this.networkPolicy;
        if (networkPolicyArr == null) {
            throw new IllegalArgumentException("Network policy cannot be null.");
        }
        if (networkPolicyArr.length > 0) {
            for (NetworkPolicy networkPolicy2 : networkPolicyArr) {
                if (networkPolicy2 == null) {
                    throw new IllegalArgumentException("Network policy cannot be null.");
                }
                this.networkPolicy = networkPolicy2.a | this.networkPolicy;
            }
        }
        return this;
    }

    public RequestCreator noFade() {
        this.noFade = true;
        return this;
    }

    public RequestCreator noPlaceholder() {
        if (this.placeholderResId != 0) {
            throw new IllegalStateException("Placeholder resource already set.");
        }
        if (this.placeholderDrawable != null) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.setPlaceholder = false;
        return this;
    }

    public RequestCreator onlyScaleDown() {
        this.data.onlyScaleDown();
        return this;
    }

    public RequestCreator placeholder(@DrawableRes int i) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        }
        if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        }
        if (this.placeholderDrawable != null) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.placeholderResId = i;
        return this;
    }

    public RequestCreator placeholder(@NonNull Drawable drawable) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        }
        if (this.placeholderResId != 0) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.placeholderDrawable = drawable;
        return this;
    }

    public RequestCreator priority(@NonNull Picasso.Priority priority) {
        this.data.priority(priority);
        return this;
    }

    public RequestCreator purgeable() {
        this.data.purgeable();
        return this;
    }

    public RequestCreator resize(int i, int i2) {
        this.data.resize(i, i2);
        return this;
    }

    public RequestCreator resizeDimen(int i, int i2) {
        Resources resources = this.picasso.a.getResources();
        return resize(resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(i2));
    }

    public RequestCreator rotate(float f) {
        this.data.rotate(f);
        return this;
    }

    public RequestCreator rotate(float f, float f2, float f3) {
        this.data.rotate(f, f2, f3);
        return this;
    }

    public RequestCreator stableKey(@NonNull String str) {
        this.data.stableKey(str);
        return this;
    }

    public RequestCreator tag(@NonNull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Tag invalid.");
        }
        if (this.tag != null) {
            throw new IllegalStateException("Tag already set.");
        }
        this.tag = obj;
        return this;
    }

    public RequestCreator transform(@NonNull Transformation transformation) {
        this.data.transform(transformation);
        return this;
    }

    public RequestCreator transform(@NonNull List<? extends Transformation> list) {
        this.data.transform(list);
        return this;
    }
}
