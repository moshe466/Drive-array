package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    Span[] k;

    @NonNull
    OrientationHelper l;

    @NonNull
    OrientationHelper m;
    private int mFullSizeSpec;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;

    @NonNull
    private final LayoutState mLayoutState;
    private int mOrientation;
    private SavedState mPendingSavedState;
    private int[] mPrefetchDistances;
    private BitSet mRemainingSpans;
    private int mSizePerSpan;
    private int mSpanCount = -1;
    boolean n = false;
    boolean o = false;
    int p = -1;
    int q = Integer.MIN_VALUE;
    LazySpanLookup r = new LazySpanLookup();
    private int mGapStrategy = 2;
    private final Rect mTmpRect = new Rect();
    private final AnchorInfo mAnchorInfo = new AnchorInfo();
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mSmoothScrollbarEnabled = true;
    private final Runnable mCheckForGapsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.f();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AnchorInfo {
        int a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        AnchorInfo() {
            b();
        }

        void a() {
            this.b = this.c ? StaggeredGridLayoutManager.this.l.getEndAfterPadding() : StaggeredGridLayoutManager.this.l.getStartAfterPadding();
        }

        void a(int i) {
            this.b = this.c ? StaggeredGridLayoutManager.this.l.getEndAfterPadding() - i : StaggeredGridLayoutManager.this.l.getStartAfterPadding() + i;
        }

        void a(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.k.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = spanArr[i].b(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        Span e;
        boolean f;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final int getSpanIndex() {
            Span span = this.e;
            if (span == null) {
                return -1;
            }
            return span.e;
        }

        public boolean isFullSpan() {
            return this.f;
        }

        public void setFullSpan(boolean z) {
            this.f = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] a;
        List<FullSpanItem> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            int a;
            int b;
            int[] c;
            boolean d;

            FullSpanItem() {
            }

            FullSpanItem(Parcel parcel) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                this.d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            int a(int i) {
                int[] iArr = this.c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                int[] iArr = this.c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.c);
                }
            }
        }

        LazySpanLookup() {
        }

        private int invalidateFullSpansAfter(int i) {
            if (this.b == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i);
            if (fullSpanItem != null) {
                this.b.remove(fullSpanItem);
            }
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.b.get(i2).a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem2 = this.b.get(i2);
            this.b.remove(i2);
            return fullSpanItem2.a;
        }

        private void offsetFullSpansForAddition(int i, int i2) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                int i3 = fullSpanItem.a;
                if (i3 >= i) {
                    fullSpanItem.a = i3 + i2;
                }
            }
        }

        private void offsetFullSpansForRemoval(int i, int i2) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                int i4 = fullSpanItem.a;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.b.remove(size);
                    } else {
                        fullSpanItem.a = i4 - i2;
                    }
                }
            }
        }

        void a() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        void a(int i) {
            int[] iArr = this.a;
            if (iArr == null) {
                this.a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.a, -1);
            } else if (i >= iArr.length) {
                this.a = new int[e(i)];
                System.arraycopy(iArr, 0, this.a, 0, iArr.length);
                int[] iArr2 = this.a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        void a(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            a(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.a, i, i3, -1);
            offsetFullSpansForAddition(i, i2);
        }

        void a(int i, Span span) {
            a(i);
            this.a[i] = span.e;
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.b.get(i);
                if (fullSpanItem2.a == fullSpanItem.a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.a >= fullSpanItem.a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }

        int b(int i) {
            List<FullSpanItem> list = this.b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.b.get(size).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return d(i);
        }

        void b(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            a(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            offsetFullSpansForRemoval(i, i2);
        }

        int c(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        int d(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int invalidateFullSpansAfter = invalidateFullSpansAfter(i);
            if (invalidateFullSpansAfter == -1) {
                int[] iArr2 = this.a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.a.length;
            }
            int i2 = invalidateFullSpansAfter + 1;
            Arrays.fill(this.a, i, i2, -1);
            return i2;
        }

        int e(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.b.get(i4);
                int i5 = fullSpanItem.a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.b == i3 || (z && fullSpanItem.d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                if (fullSpanItem.a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<LazySpanLookup.FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            int i = this.c;
            if (i > 0) {
                this.d = new int[i];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            int i2 = this.e;
            if (i2 > 0) {
                this.f = new int[i2];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.a = -1;
            this.b = -1;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Span {
        ArrayList<View> a = new ArrayList<>();
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        Span(int i) {
            this.e = i;
        }

        int a(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            a();
            return this.c;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int startAfterPadding = StaggeredGridLayoutManager.this.l.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.l.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.a.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.l.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.l.getDecoratedEnd(view);
                boolean z4 = false;
                boolean z5 = !z3 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding;
                if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (!z2 && decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        }
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        void a() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            ArrayList<View> arrayList = this.a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams b = b(view);
            this.c = StaggeredGridLayoutManager.this.l.getDecoratedEnd(view);
            if (b.f && (fullSpanItem = StaggeredGridLayoutManager.this.r.getFullSpanItem(b.getViewLayoutPosition())) != null && fullSpanItem.b == 1) {
                this.c += fullSpanItem.a(this.e);
            }
        }

        void a(View view) {
            LayoutParams b = b(view);
            b.e = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (b.isItemRemoved() || b.isItemChanged()) {
                this.d += StaggeredGridLayoutManager.this.l.getDecoratedMeasurement(view);
            }
        }

        void a(boolean z, int i) {
            int a = z ? a(Integer.MIN_VALUE) : b(Integer.MIN_VALUE);
            c();
            if (a == Integer.MIN_VALUE) {
                return;
            }
            if (!z || a >= StaggeredGridLayoutManager.this.l.getEndAfterPadding()) {
                if (z || a <= StaggeredGridLayoutManager.this.l.getStartAfterPadding()) {
                    if (i != Integer.MIN_VALUE) {
                        a += i;
                    }
                    this.c = a;
                    this.b = a;
                }
            }
        }

        int b(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            b();
            return this.b;
        }

        int b(int i, int i2, boolean z) {
            return a(i, i2, z, true, false);
        }

        LayoutParams b(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        void b() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.a.get(0);
            LayoutParams b = b(view);
            this.b = StaggeredGridLayoutManager.this.l.getDecoratedStart(view);
            if (b.f && (fullSpanItem = StaggeredGridLayoutManager.this.r.getFullSpanItem(b.getViewLayoutPosition())) != null && fullSpanItem.b == -1) {
                this.b -= fullSpanItem.a(this.e);
            }
        }

        void c() {
            this.a.clear();
            f();
            this.d = 0;
        }

        void c(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                this.b = i2 + i;
            }
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                this.c = i3 + i;
            }
        }

        void c(View view) {
            LayoutParams b = b(view);
            b.e = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (b.isItemRemoved() || b.isItemChanged()) {
                this.d += StaggeredGridLayoutManager.this.l.getDecoratedMeasurement(view);
            }
        }

        int d() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.c;
        }

        void d(int i) {
            this.b = i;
            this.c = i;
        }

        int e() {
            int i = this.b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            b();
            return this.b;
        }

        void f() {
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            int i;
            int size;
            if (StaggeredGridLayoutManager.this.n) {
                i = this.a.size() - 1;
                size = -1;
            } else {
                i = 0;
                size = this.a.size();
            }
            return b(i, size, true);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            int i;
            int size;
            if (StaggeredGridLayoutManager.this.n) {
                i = this.a.size() - 1;
                size = -1;
            } else {
                i = 0;
                size = this.a.size();
            }
            return a(i, size, true);
        }

        public int findFirstVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.n ? b(this.a.size() - 1, -1, false) : b(0, this.a.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            int size;
            int i;
            if (StaggeredGridLayoutManager.this.n) {
                size = 0;
                i = this.a.size();
            } else {
                size = this.a.size() - 1;
                i = -1;
            }
            return b(size, i, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            int size;
            int i;
            if (StaggeredGridLayoutManager.this.n) {
                size = 0;
                i = this.a.size();
            } else {
                size = this.a.size() - 1;
                i = -1;
            }
            return a(size, i, true);
        }

        public int findLastVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.n ? b(0, this.a.size(), false) : b(this.a.size() - 1, -1, false);
        }

        void g() {
            int size = this.a.size();
            View remove = this.a.remove(size - 1);
            LayoutParams b = b(remove);
            b.e = null;
            if (b.isItemRemoved() || b.isItemChanged()) {
                this.d -= StaggeredGridLayoutManager.this.l.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        public int getDeletedSize() {
            return this.d;
        }

        public View getFocusableViewAfter(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    View view2 = this.a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.n && staggeredGridLayoutManager.getPosition(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.n && staggeredGridLayoutManager2.getPosition(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.n && staggeredGridLayoutManager3.getPosition(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.n && staggeredGridLayoutManager4.getPosition(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        void h() {
            View remove = this.a.remove(0);
            LayoutParams b = b(remove);
            b.e = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (b.isItemRemoved() || b.isItemChanged()) {
                this.d -= StaggeredGridLayoutManager.this.l.getDecoratedMeasurement(remove);
            }
            this.b = Integer.MIN_VALUE;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.mOrientation = i2;
        setSpanCount(i);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void appendViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.k[i].a(view);
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        boolean z;
        SavedState savedState = this.mPendingSavedState;
        int i = savedState.c;
        if (i > 0) {
            if (i == this.mSpanCount) {
                for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                    this.k[i2].c();
                    SavedState savedState2 = this.mPendingSavedState;
                    int i3 = savedState2.d[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        i3 += savedState2.i ? this.l.getEndAfterPadding() : this.l.getStartAfterPadding();
                    }
                    this.k[i2].d(i3);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.mPendingSavedState;
                savedState3.a = savedState3.b;
            }
        }
        SavedState savedState4 = this.mPendingSavedState;
        this.mLastLayoutRTL = savedState4.j;
        setReverseLayout(savedState4.h);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.mPendingSavedState;
        int i4 = savedState5.a;
        if (i4 != -1) {
            this.p = i4;
            z = savedState5.i;
        } else {
            z = this.o;
        }
        anchorInfo.c = z;
        SavedState savedState6 = this.mPendingSavedState;
        if (savedState6.e > 1) {
            LazySpanLookup lazySpanLookup = this.r;
            lazySpanLookup.a = savedState6.f;
            lazySpanLookup.b = savedState6.g;
        }
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.e == 1) {
            if (layoutParams.f) {
                appendViewToAllSpans(view);
                return;
            } else {
                layoutParams.e.a(view);
                return;
            }
        }
        if (layoutParams.f) {
            prependViewToAllSpans(view);
        } else {
            layoutParams.e.c(view);
        }
    }

    private int calculateScrollDirectionForPosition(int i) {
        if (getChildCount() == 0) {
            return this.o ? 1 : -1;
        }
        return (i < h()) != this.o ? -1 : 1;
    }

    private boolean checkSpanForGap(Span span) {
        if (this.o) {
            if (span.d() < this.l.getEndAfterPadding()) {
                ArrayList<View> arrayList = span.a;
                return !span.b(arrayList.get(arrayList.size() - 1)).f;
            }
        } else if (span.e() > this.l.getStartAfterPadding()) {
            return !span.b(span.a.get(0)).f;
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.l, b(!this.mSmoothScrollbarEnabled), a(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.l, b(!this.mSmoothScrollbarEnabled), a(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.o);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.b(state, this.l, b(!this.mSmoothScrollbarEnabled), a(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && k()) ? -1 : 1 : (this.mOrientation != 1 && k()) ? 1 : -1;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.mSpanCount];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            fullSpanItem.c[i2] = i - this.k[i2].a(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.mSpanCount];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            fullSpanItem.c[i2] = this.k[i2].b(i) - i;
        }
        return fullSpanItem;
    }

    private void createOrientationHelpers() {
        this.l = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.m = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i;
        Span span;
        int decoratedMeasurement;
        int i2;
        int i3;
        int decoratedMeasurement2;
        RecyclerView.LayoutManager layoutManager;
        View view;
        int i4;
        int i5;
        ?? r9 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.i) {
            i = layoutState.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i = layoutState.e == 1 ? layoutState.g + layoutState.b : layoutState.f - layoutState.b;
        }
        updateAllRemainingSpans(layoutState.e, i);
        int endAfterPadding = this.o ? this.l.getEndAfterPadding() : this.l.getStartAfterPadding();
        boolean z = false;
        while (layoutState.a(state) && (this.mLayoutState.i || !this.mRemainingSpans.isEmpty())) {
            View a = layoutState.a(recycler);
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int c = this.r.c(viewLayoutPosition);
            boolean z2 = c == -1;
            if (z2) {
                span = layoutParams.f ? this.k[r9] : getNextSpan(layoutState);
                this.r.a(viewLayoutPosition, span);
            } else {
                span = this.k[c];
            }
            Span span2 = span;
            layoutParams.e = span2;
            if (layoutState.e == 1) {
                addView(a);
            } else {
                addView(a, r9);
            }
            measureChildWithDecorationsAndMargin(a, layoutParams, r9);
            if (layoutState.e == 1) {
                int maxEnd = layoutParams.f ? getMaxEnd(endAfterPadding) : span2.a(endAfterPadding);
                int decoratedMeasurement3 = this.l.getDecoratedMeasurement(a) + maxEnd;
                if (z2 && layoutParams.f) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromEnd = createFullSpanItemFromEnd(maxEnd);
                    createFullSpanItemFromEnd.b = -1;
                    createFullSpanItemFromEnd.a = viewLayoutPosition;
                    this.r.addFullSpanItem(createFullSpanItemFromEnd);
                }
                i2 = decoratedMeasurement3;
                decoratedMeasurement = maxEnd;
            } else {
                int minStart = layoutParams.f ? getMinStart(endAfterPadding) : span2.b(endAfterPadding);
                decoratedMeasurement = minStart - this.l.getDecoratedMeasurement(a);
                if (z2 && layoutParams.f) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromStart = createFullSpanItemFromStart(minStart);
                    createFullSpanItemFromStart.b = 1;
                    createFullSpanItemFromStart.a = viewLayoutPosition;
                    this.r.addFullSpanItem(createFullSpanItemFromStart);
                }
                i2 = minStart;
            }
            if (layoutParams.f && layoutState.d == -1) {
                if (!z2) {
                    if (!(layoutState.e == 1 ? d() : e())) {
                        LazySpanLookup.FullSpanItem fullSpanItem = this.r.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.d = true;
                        }
                    }
                }
                this.mLaidOutInvalidFullSpan = true;
            }
            attachViewToSpans(a, layoutParams, layoutState);
            if (k() && this.mOrientation == 1) {
                int endAfterPadding2 = layoutParams.f ? this.m.getEndAfterPadding() : this.m.getEndAfterPadding() - (((this.mSpanCount - 1) - span2.e) * this.mSizePerSpan);
                decoratedMeasurement2 = endAfterPadding2;
                i3 = endAfterPadding2 - this.m.getDecoratedMeasurement(a);
            } else {
                int startAfterPadding = layoutParams.f ? this.m.getStartAfterPadding() : (span2.e * this.mSizePerSpan) + this.m.getStartAfterPadding();
                i3 = startAfterPadding;
                decoratedMeasurement2 = this.m.getDecoratedMeasurement(a) + startAfterPadding;
            }
            if (this.mOrientation == 1) {
                layoutManager = this;
                view = a;
                i4 = i3;
                i3 = decoratedMeasurement;
                i5 = decoratedMeasurement2;
            } else {
                layoutManager = this;
                view = a;
                i4 = decoratedMeasurement;
                i5 = i2;
                i2 = decoratedMeasurement2;
            }
            layoutManager.layoutDecoratedWithMargins(view, i4, i3, i5, i2);
            if (layoutParams.f) {
                updateAllRemainingSpans(this.mLayoutState.e, i);
            } else {
                updateRemainingSpans(span2, this.mLayoutState.e, i);
            }
            recycle(recycler, this.mLayoutState);
            if (this.mLayoutState.h && a.hasFocusable()) {
                if (layoutParams.f) {
                    this.mRemainingSpans.clear();
                } else {
                    this.mRemainingSpans.set(span2.e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            recycle(recycler, this.mLayoutState);
        }
        int startAfterPadding2 = this.mLayoutState.e == -1 ? this.l.getStartAfterPadding() - getMinStart(this.l.getStartAfterPadding()) : getMaxEnd(this.l.getEndAfterPadding()) - this.l.getEndAfterPadding();
        if (startAfterPadding2 > 0) {
            return Math.min(layoutState.b, startAfterPadding2);
        }
        return 0;
    }

    private int findFirstReferenceChildPosition(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.l.getEndAfterPadding() - maxEnd) > 0) {
            int i = endAfterPadding - (-a(-endAfterPadding, recycler, state));
            if (!z || i <= 0) {
                return;
            }
            this.l.offsetChildren(i);
        }
    }

    private void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.l.getStartAfterPadding()) > 0) {
            int a = startAfterPadding - a(startAfterPadding, recycler, state);
            if (!z || a <= 0) {
                return;
            }
            this.l.offsetChildren(-a);
        }
    }

    private int getMaxEnd(int i) {
        int a = this.k[0].a(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int a2 = this.k[i2].a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int getMaxStart(int i) {
        int b = this.k[0].b(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int b2 = this.k[i2].b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private int getMinEnd(int i) {
        int a = this.k[0].a(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int a2 = this.k[i2].a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private int getMinStart(int i) {
        int b = this.k[0].b(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int b2 = this.k[i2].b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private Span getNextSpan(LayoutState layoutState) {
        int i;
        int i2;
        int i3 = -1;
        if (preferLastSpan(layoutState.e)) {
            i = this.mSpanCount - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.mSpanCount;
            i2 = 1;
        }
        Span span = null;
        if (layoutState.e == 1) {
            int i4 = Integer.MAX_VALUE;
            int startAfterPadding = this.l.getStartAfterPadding();
            while (i != i3) {
                Span span2 = this.k[i];
                int a = span2.a(startAfterPadding);
                if (a < i4) {
                    span = span2;
                    i4 = a;
                }
                i += i2;
            }
            return span;
        }
        int i5 = Integer.MIN_VALUE;
        int endAfterPadding = this.l.getEndAfterPadding();
        while (i != i3) {
            Span span3 = this.k[i];
            int b = span3.b(endAfterPadding);
            if (b > i5) {
                span = span3;
                i5 = b;
            }
            i += i2;
        }
        return span;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleUpdate(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.o
            if (r0 == 0) goto L9
            int r0 = r6.i()
            goto Ld
        L9:
            int r0 = r6.h()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1d
        L16:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L1f
        L1b:
            int r2 = r7 + r8
        L1d:
            r3 = r2
            r2 = r7
        L1f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.r
            r4.d(r2)
            r4 = 1
            if (r9 == r4) goto L3e
            r5 = 2
            if (r9 == r5) goto L38
            if (r9 == r1) goto L2d
            goto L43
        L2d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.r
            r9.b(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.r
            r7.a(r8, r4)
            goto L43
        L38:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.r
            r9.b(r7, r8)
            goto L43
        L3e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.r
            r9.a(r7, r8)
        L43:
            if (r3 > r0) goto L46
            return
        L46:
            boolean r7 = r6.o
            if (r7 == 0) goto L4f
            int r7 = r6.h()
            goto L53
        L4f:
            int r7 = r6.i()
        L53:
            if (r2 > r7) goto L58
            r6.requestLayout()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.handleUpdate(int, int, int):void");
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.mTmpRect;
        int updateSpecWithExtra = updateSpecWithExtra(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.mTmpRect;
        int updateSpecWithExtra2 = updateSpecWithExtra(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z ? b(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams) : a(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams)) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        if (layoutParams.f) {
            if (this.mOrientation != 1) {
                measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.mFullSizeSpec, z);
                return;
            }
            childMeasureSpec = this.mFullSizeSpec;
        } else {
            if (this.mOrientation != 1) {
                childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
                childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                measureChildWithDecorationsAndMargin(view, childMeasureSpec, childMeasureSpec2, z);
            }
            childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
        }
        childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        measureChildWithDecorationsAndMargin(view, childMeasureSpec, childMeasureSpec2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x014b, code lost:
    
        if (f() != false) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    private boolean preferLastSpan(int i) {
        if (this.mOrientation == 0) {
            return (i == -1) != this.o;
        }
        return ((i == -1) == this.o) == k();
    }

    private void prependViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.k[i].c(view);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
    
        if (r4.e == (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void recycle(androidx.recyclerview.widget.RecyclerView.Recycler r3, androidx.recyclerview.widget.LayoutState r4) {
        /*
            r2 = this;
            boolean r0 = r4.a
            if (r0 == 0) goto L4d
            boolean r0 = r4.i
            if (r0 == 0) goto L9
            goto L4d
        L9:
            int r0 = r4.b
            r1 = -1
            if (r0 != 0) goto L1e
            int r0 = r4.e
            if (r0 != r1) goto L18
        L12:
            int r4 = r4.g
        L14:
            r2.recycleFromEnd(r3, r4)
            goto L4d
        L18:
            int r4 = r4.f
        L1a:
            r2.recycleFromStart(r3, r4)
            goto L4d
        L1e:
            int r0 = r4.e
            if (r0 != r1) goto L37
            int r0 = r4.f
            int r1 = r2.getMaxStart(r0)
            int r0 = r0 - r1
            if (r0 >= 0) goto L2c
            goto L12
        L2c:
            int r1 = r4.g
            int r4 = r4.b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L14
        L37:
            int r0 = r4.g
            int r0 = r2.getMinEnd(r0)
            int r1 = r4.g
            int r0 = r0 - r1
            if (r0 >= 0) goto L43
            goto L18
        L43:
            int r1 = r4.f
            int r4 = r4.b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L1a
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.recycle(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.LayoutState):void");
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.l.getDecoratedStart(childAt) < i || this.l.getTransformedStartWithDecoration(childAt) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f) {
                for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                    if (this.k[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                    this.k[i3].g();
                }
            } else if (layoutParams.e.a.size() == 1) {
                return;
            } else {
                layoutParams.e.g();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.l.getDecoratedEnd(childAt) > i || this.l.getTransformedEndWithDecoration(childAt) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f) {
                for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                    if (this.k[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                    this.k[i3].h();
                }
            } else if (layoutParams.e.a.size() == 1) {
                return;
            } else {
                layoutParams.e.h();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.m.getMode() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            float decoratedMeasurement = this.m.getDecoratedMeasurement(childAt);
            if (decoratedMeasurement >= f) {
                if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                    decoratedMeasurement = (decoratedMeasurement * 1.0f) / this.mSpanCount;
                }
                f = Math.max(f, decoratedMeasurement);
            }
        }
        int i2 = this.mSizePerSpan;
        int round = Math.round(f * this.mSpanCount);
        if (this.m.getMode() == Integer.MIN_VALUE) {
            round = Math.min(round, this.m.getTotalSpace());
        }
        a(round);
        if (this.mSizePerSpan == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.f) {
                if (k() && this.mOrientation == 1) {
                    int i4 = this.mSpanCount;
                    int i5 = layoutParams.e.e;
                    childAt2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.mSizePerSpan) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = layoutParams.e.e;
                    int i7 = this.mOrientation;
                    int i8 = (this.mSizePerSpan * i6) - (i6 * i2);
                    if (i7 == 1) {
                        childAt2.offsetLeftAndRight(i8);
                    } else {
                        childAt2.offsetTopAndBottom(i8);
                    }
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        this.o = (this.mOrientation == 1 || !k()) ? this.n : !this.n;
    }

    private void setLayoutStateDirection(int i) {
        LayoutState layoutState = this.mLayoutState;
        layoutState.e = i;
        layoutState.d = this.o != (i == -1) ? -1 : 1;
    }

    private void updateAllRemainingSpans(int i, int i2) {
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            if (!this.k[i3].a.isEmpty()) {
                updateRemainingSpans(this.k[i3], i, i2);
            }
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        boolean z = this.mLastLayoutFromEnd;
        int itemCount = state.getItemCount();
        anchorInfo.a = z ? findLastReferenceChildPosition(itemCount) : findFirstReferenceChildPosition(itemCount);
        anchorInfo.b = Integer.MIN_VALUE;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateLayoutState(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.LayoutState r0 = r4.mLayoutState
            r1 = 0
            r0.b = r1
            r0.c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.getTargetScrollPosition()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.o
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            androidx.recyclerview.widget.OrientationHelper r5 = r4.l
            int r5 = r5.getTotalSpace()
            goto L2f
        L25:
            androidx.recyclerview.widget.OrientationHelper r5 = r4.l
            int r5 = r5.getTotalSpace()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L4d
            androidx.recyclerview.widget.LayoutState r0 = r4.mLayoutState
            androidx.recyclerview.widget.OrientationHelper r3 = r4.l
            int r3 = r3.getStartAfterPadding()
            int r3 = r3 - r6
            r0.f = r3
            androidx.recyclerview.widget.LayoutState r6 = r4.mLayoutState
            androidx.recyclerview.widget.OrientationHelper r0 = r4.l
            int r0 = r0.getEndAfterPadding()
            int r0 = r0 + r5
            r6.g = r0
            goto L5d
        L4d:
            androidx.recyclerview.widget.LayoutState r0 = r4.mLayoutState
            androidx.recyclerview.widget.OrientationHelper r3 = r4.l
            int r3 = r3.getEnd()
            int r3 = r3 + r5
            r0.g = r3
            androidx.recyclerview.widget.LayoutState r5 = r4.mLayoutState
            int r6 = -r6
            r5.f = r6
        L5d:
            androidx.recyclerview.widget.LayoutState r5 = r4.mLayoutState
            r5.h = r1
            r5.a = r2
            androidx.recyclerview.widget.OrientationHelper r6 = r4.l
            int r6 = r6.getMode()
            if (r6 != 0) goto L74
            androidx.recyclerview.widget.OrientationHelper r6 = r4.l
            int r6 = r6.getEnd()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.updateLayoutState(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private void updateRemainingSpans(Span span, int i, int i2) {
        int deletedSize = span.getDeletedSize();
        if (i == -1) {
            if (span.e() + deletedSize > i2) {
                return;
            }
        } else if (span.d() - deletedSize < i2) {
            return;
        }
        this.mRemainingSpans.set(span.e, false);
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        a(i, state);
        int fill = fill(recycler, this.mLayoutState, state);
        if (this.mLayoutState.b >= fill) {
            i = i < 0 ? -fill : fill;
        }
        this.l.offsetChildren(-i);
        this.mLastLayoutFromEnd = this.o;
        LayoutState layoutState = this.mLayoutState;
        layoutState.b = 0;
        recycle(recycler, layoutState);
        return i;
    }

    View a(boolean z) {
        int startAfterPadding = this.l.getStartAfterPadding();
        int endAfterPadding = this.l.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.l.getDecoratedStart(childAt);
            int decoratedEnd = this.l.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    void a(int i) {
        this.mSizePerSpan = i / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(i, this.m.getMode());
    }

    void a(int i, RecyclerView.State state) {
        int h;
        int i2;
        if (i > 0) {
            h = i();
            i2 = 1;
        } else {
            h = h();
            i2 = -1;
        }
        this.mLayoutState.a = true;
        updateLayoutState(h, state);
        setLayoutStateDirection(i2);
        LayoutState layoutState = this.mLayoutState;
        layoutState.c = h + layoutState.d;
        layoutState.b = Math.abs(i);
    }

    boolean a(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        int startAfterPadding;
        int decoratedStart;
        if (!state.isPreLayout() && (i = this.p) != -1) {
            if (i >= 0 && i < state.getItemCount()) {
                SavedState savedState = this.mPendingSavedState;
                if (savedState == null || savedState.a == -1 || savedState.c < 1) {
                    View findViewByPosition = findViewByPosition(this.p);
                    if (findViewByPosition != null) {
                        anchorInfo.a = this.o ? i() : h();
                        if (this.q != Integer.MIN_VALUE) {
                            if (anchorInfo.c) {
                                startAfterPadding = this.l.getEndAfterPadding() - this.q;
                                decoratedStart = this.l.getDecoratedEnd(findViewByPosition);
                            } else {
                                startAfterPadding = this.l.getStartAfterPadding() + this.q;
                                decoratedStart = this.l.getDecoratedStart(findViewByPosition);
                            }
                            anchorInfo.b = startAfterPadding - decoratedStart;
                            return true;
                        }
                        if (this.l.getDecoratedMeasurement(findViewByPosition) > this.l.getTotalSpace()) {
                            anchorInfo.b = anchorInfo.c ? this.l.getEndAfterPadding() : this.l.getStartAfterPadding();
                            return true;
                        }
                        int decoratedStart2 = this.l.getDecoratedStart(findViewByPosition) - this.l.getStartAfterPadding();
                        if (decoratedStart2 < 0) {
                            anchorInfo.b = -decoratedStart2;
                            return true;
                        }
                        int endAfterPadding = this.l.getEndAfterPadding() - this.l.getDecoratedEnd(findViewByPosition);
                        if (endAfterPadding < 0) {
                            anchorInfo.b = endAfterPadding;
                            return true;
                        }
                        anchorInfo.b = Integer.MIN_VALUE;
                    } else {
                        anchorInfo.a = this.p;
                        int i2 = this.q;
                        if (i2 == Integer.MIN_VALUE) {
                            anchorInfo.c = calculateScrollDirectionForPosition(anchorInfo.a) == 1;
                            anchorInfo.a();
                        } else {
                            anchorInfo.a(i2);
                        }
                        anchorInfo.d = true;
                    }
                } else {
                    anchorInfo.b = Integer.MIN_VALUE;
                    anchorInfo.a = this.p;
                }
                return true;
            }
            this.p = -1;
            this.q = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    View b(boolean z) {
        int startAfterPadding = this.l.getStartAfterPadding();
        int endAfterPadding = this.l.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.l.getDecoratedStart(childAt);
            if (this.l.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    void b(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (a(state, anchorInfo) || updateAnchorFromChildren(state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        anchorInfo.a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int a;
        int i3;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        a(i, state);
        int[] iArr = this.mPrefetchDistances;
        if (iArr == null || iArr.length < this.mSpanCount) {
            this.mPrefetchDistances = new int[this.mSpanCount];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.mSpanCount; i5++) {
            LayoutState layoutState = this.mLayoutState;
            if (layoutState.d == -1) {
                a = layoutState.f;
                i3 = this.k[i5].b(a);
            } else {
                a = this.k[i5].a(layoutState.g);
                i3 = this.mLayoutState.g;
            }
            int i6 = a - i3;
            if (i6 >= 0) {
                this.mPrefetchDistances[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.mPrefetchDistances, 0, i4);
        for (int i7 = 0; i7 < i4 && this.mLayoutState.a(state); i7++) {
            layoutPrefetchRegistry.addPosition(this.mLayoutState.c, this.mPrefetchDistances[i7]);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.c += layoutState2.d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = calculateScrollDirectionForPosition;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = calculateScrollDirectionForPosition;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    boolean d() {
        int a = this.k[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; i++) {
            if (this.k[i].a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    boolean e() {
        int b = this.k[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; i++) {
            if (this.k[i].b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    boolean f() {
        int h;
        int i;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.o) {
            h = i();
            i = h();
        } else {
            h = h();
            i = i();
        }
        if (h == 0 && j() != null) {
            this.r.a();
        } else {
            if (!this.mLaidOutInvalidFullSpan) {
                return false;
            }
            int i2 = this.o ? -1 : 1;
            int i3 = i + 1;
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.r.getFirstFullSpanItemInRange(h, i3, i2, true);
            if (firstFullSpanItemInRange == null) {
                this.mLaidOutInvalidFullSpan = false;
                this.r.b(i3);
                return false;
            }
            LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.r.getFirstFullSpanItemInRange(h, firstFullSpanItemInRange.a, i2 * (-1), true);
            if (firstFullSpanItemInRange2 == null) {
                this.r.b(firstFullSpanItemInRange.a);
            } else {
                this.r.b(firstFullSpanItemInRange2.a + 1);
            }
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.k[i].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.k[i].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.k[i].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.k[i].findLastVisibleItemPosition();
        }
        return iArr;
    }

    int g() {
        View a = this.o ? a(true) : b(true);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.mOrientation == 1 ? this.mSpanCount : super.getColumnCountForAccessibility(recycler, state);
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.n;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.mOrientation == 0 ? this.mSpanCount : super.getRowCountForAccessibility(recycler, state);
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    int h() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    int i() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public void invalidateSpanAssignments() {
        this.r.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.mGapStrategy != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r10 == r11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r10 == r11) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View j() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.mSpanCount
            r2.<init>(r3)
            int r3 = r12.mSpanCount
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.mOrientation
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.k()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.o
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.e
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.e
            boolean r9 = r12.checkSpanForGap(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.e
            int r9 = r9.e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.o
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.OrientationHelper r10 = r12.l
            int r10 = r10.getDecoratedEnd(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.l
            int r11 = r11.getDecoratedEnd(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.OrientationHelper r10 = r12.l
            int r10 = r10.getDecoratedStart(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.l
            int r11 = r11.getDecoratedStart(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r8 = r8.e
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r9.e
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.j():android.view.View");
    }

    boolean k() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            this.k[i2].c(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            this.k[i2].c(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i = 0; i < this.mSpanCount; i++) {
            this.k[i].c();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        View focusableViewAfter;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z = layoutParams.f;
        Span span = layoutParams.e;
        int i2 = convertFocusDirectionToLayoutDirection == 1 ? i() : h();
        updateLayoutState(i2, state);
        setLayoutStateDirection(convertFocusDirectionToLayoutDirection);
        LayoutState layoutState = this.mLayoutState;
        layoutState.c = layoutState.d + i2;
        layoutState.b = (int) (this.l.getTotalSpace() * MAX_SCROLL_FACTOR);
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.h = true;
        layoutState2.a = false;
        fill(recycler, layoutState2, state);
        this.mLastLayoutFromEnd = this.o;
        if (!z && (focusableViewAfter = span.getFocusableViewAfter(i2, convertFocusDirectionToLayoutDirection)) != null && focusableViewAfter != findContainingItemView) {
            return focusableViewAfter;
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i3 = this.mSpanCount - 1; i3 >= 0; i3--) {
                View focusableViewAfter2 = this.k[i3].getFocusableViewAfter(i2, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter2 != null && focusableViewAfter2 != findContainingItemView) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.mSpanCount; i4++) {
                View focusableViewAfter3 = this.k[i4].getFocusableViewAfter(i2, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter3 != null && focusableViewAfter3 != findContainingItemView) {
                    return focusableViewAfter3;
                }
            }
        }
        boolean z2 = (this.n ^ true) == (convertFocusDirectionToLayoutDirection == -1);
        if (!z) {
            View findViewByPosition = findViewByPosition(z2 ? span.findFirstPartiallyVisibleItemPosition() : span.findLastPartiallyVisibleItemPosition());
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i5 = this.mSpanCount - 1; i5 >= 0; i5--) {
                if (i5 != span.e) {
                    Span[] spanArr = this.k;
                    View findViewByPosition2 = findViewByPosition(z2 ? spanArr[i5].findFirstPartiallyVisibleItemPosition() : spanArr[i5].findLastPartiallyVisibleItemPosition());
                    if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.mSpanCount; i6++) {
                Span[] spanArr2 = this.k;
                View findViewByPosition3 = findViewByPosition(z2 ? spanArr2[i6].findFirstPartiallyVisibleItemPosition() : spanArr2[i6].findLastPartiallyVisibleItemPosition());
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View b = b(false);
            View a = a(false);
            if (b == null || a == null) {
                return;
            }
            int position = getPosition(b);
            int position2 = getPosition(a);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i;
        int i2;
        int spanIndex;
        int i3;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.mOrientation == 0) {
            i = layoutParams2.getSpanIndex();
            i2 = layoutParams2.f ? this.mSpanCount : 1;
            spanIndex = -1;
            i3 = -1;
        } else {
            i = -1;
            i2 = -1;
            spanIndex = layoutParams2.getSpanIndex();
            i3 = layoutParams2.f ? this.mSpanCount : 1;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, i2, spanIndex, i3, false, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.r.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        handleUpdate(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.p = -1;
        this.q = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int b;
        int startAfterPadding;
        int[] iArr;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.h = this.n;
        savedState2.i = this.mLastLayoutFromEnd;
        savedState2.j = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.r;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.a) == null) {
            savedState2.e = 0;
        } else {
            savedState2.f = iArr;
            savedState2.e = savedState2.f.length;
            savedState2.g = lazySpanLookup.b;
        }
        if (getChildCount() > 0) {
            savedState2.a = this.mLastLayoutFromEnd ? i() : h();
            savedState2.b = g();
            int i = this.mSpanCount;
            savedState2.c = i;
            savedState2.d = new int[i];
            for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                if (this.mLastLayoutFromEnd) {
                    b = this.k[i2].a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        startAfterPadding = this.l.getEndAfterPadding();
                        b -= startAfterPadding;
                        savedState2.d[i2] = b;
                    } else {
                        savedState2.d[i2] = b;
                    }
                } else {
                    b = this.k[i2].b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        startAfterPadding = this.l.getStartAfterPadding();
                        b -= startAfterPadding;
                        savedState2.d[i2] = b;
                    } else {
                        savedState2.d[i2] = b;
                    }
                }
            }
        } else {
            savedState2.a = -1;
            savedState2.b = -1;
            savedState2.c = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            f();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.a != i) {
            savedState.a();
        }
        this.p = i;
        this.q = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.a();
        }
        this.p = i;
        this.q = i2;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(i, recycler, state);
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i == this.mGapStrategy) {
            return;
        }
        if (i != 0 && i != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.mGapStrategy = i;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, (this.mSizePerSpan * this.mSpanCount) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, (this.mSizePerSpan * this.mSpanCount) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.mOrientation) {
            return;
        }
        this.mOrientation = i;
        OrientationHelper orientationHelper = this.l;
        this.l = this.m;
        this.m = orientationHelper;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.h != z) {
            savedState.h = z;
        }
        this.n = z;
        requestLayout();
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.k = new Span[this.mSpanCount];
            for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                this.k[i2] = new Span(i2);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }
}
