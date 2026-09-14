package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    long a;
    boolean b;
    boolean c;
    boolean d;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.a = -1L;
        this.b = false;
        this.c = false;
        this.d = false;
        this.mDelayedHide = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.b = false;
                contentLoadingProgressBar.a = -1L;
                contentLoadingProgressBar.setVisibility(8);
            }
        };
        this.mDelayedShow = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar.2
            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                contentLoadingProgressBar.c = false;
                if (contentLoadingProgressBar.d) {
                    return;
                }
                contentLoadingProgressBar.a = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        };
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    public synchronized void hide() {
        this.d = true;
        removeCallbacks(this.mDelayedShow);
        this.c = false;
        long currentTimeMillis = System.currentTimeMillis() - this.a;
        if (currentTimeMillis < 500 && this.a != -1) {
            if (!this.b) {
                postDelayed(this.mDelayedHide, 500 - currentTimeMillis);
                this.b = true;
            }
        }
        setVisibility(8);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    public synchronized void show() {
        this.a = -1L;
        this.d = false;
        removeCallbacks(this.mDelayedHide);
        this.b = false;
        if (!this.c) {
            postDelayed(this.mDelayedShow, 500L);
            this.c = true;
        }
    }
}
