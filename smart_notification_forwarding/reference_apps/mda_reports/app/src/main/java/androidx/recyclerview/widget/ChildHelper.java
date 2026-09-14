package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Callback a;
    final Bucket b = new Bucket();
    final List<View> c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Bucket {
        long a = 0;
        Bucket b;

        Bucket() {
        }

        private void ensureNext() {
            if (this.b == null) {
                this.b = new Bucket();
            }
        }

        void a() {
            this.a = 0L;
            Bucket bucket = this.b;
            if (bucket != null) {
                bucket.a();
            }
        }

        void a(int i) {
            if (i < 64) {
                this.a &= (1 << i) ^ (-1);
                return;
            }
            Bucket bucket = this.b;
            if (bucket != null) {
                bucket.a(i - 64);
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                ensureNext();
                this.b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.a;
            this.a = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
            if (z) {
                e(i);
            } else {
                a(i);
            }
            if (z2 || this.b != null) {
                ensureNext();
                this.b.a(0, z2);
            }
        }

        int b(int i) {
            Bucket bucket = this.b;
            return bucket == null ? i >= 64 ? Long.bitCount(this.a) : Long.bitCount(this.a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.a & ((1 << i) - 1)) : bucket.b(i - 64) + Long.bitCount(this.a);
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            }
            ensureNext();
            return this.b.c(i - 64);
        }

        boolean d(int i) {
            if (i >= 64) {
                ensureNext();
                return this.b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.a & j) != 0;
            this.a &= j ^ (-1);
            long j2 = j - 1;
            long j3 = this.a;
            this.a = Long.rotateRight(j3 & (j2 ^ (-1)), 1) | (j3 & j2);
            Bucket bucket = this.b;
            if (bucket != null) {
                if (bucket.c(0)) {
                    e(63);
                }
                this.b.d(0);
            }
            return z;
        }

        void e(int i) {
            if (i < 64) {
                this.a |= 1 << i;
            } else {
                ensureNext();
                this.b.e(i - 64);
            }
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildHelper(Callback callback) {
        this.a = callback;
    }

    private int getOffset(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int b = i - (i2 - this.b.b(i2));
            if (b == 0) {
                while (this.b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.c.add(view);
        this.a.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.a.onLeftHiddenState(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.a.getChildCount() - this.c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        int offset = getOffset(i);
        this.b.d(offset);
        this.a.detachViewFromParent(offset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.b.e(indexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int childCount = i < 0 ? this.a.getChildCount() : getOffset(i);
        this.b.a(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        this.a.attachViewToParent(view, childCount, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int childCount = i < 0 ? this.a.getChildCount() : getOffset(i);
        this.b.a(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        this.a.addView(view, childCount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.a.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        if (indexOfChild == -1 || this.b.c(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.b.b(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.c.get(i2);
            RecyclerView.ViewHolder childViewHolder = this.a.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.j() && !childViewHolder.k()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View c(int i) {
        return this.a.getChildAt(getOffset(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.a.onLeftHiddenState(this.c.get(size));
            this.c.remove(size);
        }
        this.a.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d(int i) {
        return this.a.getChildAt(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (this.b.d(indexOfChild)) {
            unhideViewInternal(view);
        }
        this.a.removeViewAt(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        int offset = getOffset(i);
        View childAt = this.a.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.b.d(offset)) {
            unhideViewInternal(childAt);
        }
        this.a.removeViewAt(offset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        if (indexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        }
        if (!this.b.c(indexOfChild)) {
            return false;
        }
        this.b.d(indexOfChild);
        unhideViewInternal(view);
        this.a.removeViewAt(indexOfChild);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(View view) {
        int indexOfChild = this.a.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.b.c(indexOfChild)) {
            this.b.a(indexOfChild);
            unhideViewInternal(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
