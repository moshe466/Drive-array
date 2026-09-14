package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* loaded from: classes.dex */
public class AsyncListUtil<T> {
    final Class<T> a;
    final int b;
    final DataCallback<T> c;
    final ViewCallback d;
    final TileList<T> e;
    final ThreadUtil.MainThreadCallback<T> f;
    final ThreadUtil.BackgroundCallback<T> g;
    boolean k;
    final int[] h = new int[2];
    final int[] i = new int[2];
    final int[] j = new int[2];
    private int mScrollHint = 0;
    int l = 0;
    int m = 0;
    int n = this.m;
    final SparseIntArray o = new SparseIntArray();
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback = new ThreadUtil.MainThreadCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.1
        private boolean isRequestedGeneration(int i) {
            return i == AsyncListUtil.this.n;
        }

        private void recycleAllTiles() {
            for (int i = 0; i < AsyncListUtil.this.e.size(); i++) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.g.recycleTile(asyncListUtil.e.getAtIndex(i));
            }
            AsyncListUtil.this.e.clear();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            if (!isRequestedGeneration(i)) {
                AsyncListUtil.this.g.recycleTile(tile);
                return;
            }
            TileList.Tile<T> addOrReplace = AsyncListUtil.this.e.addOrReplace(tile);
            if (addOrReplace != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + addOrReplace.mStartPosition);
                AsyncListUtil.this.g.recycleTile(addOrReplace);
            }
            int i2 = tile.mStartPosition + tile.mItemCount;
            int i3 = 0;
            while (i3 < AsyncListUtil.this.o.size()) {
                int keyAt = AsyncListUtil.this.o.keyAt(i3);
                if (tile.mStartPosition > keyAt || keyAt >= i2) {
                    i3++;
                } else {
                    AsyncListUtil.this.o.removeAt(i3);
                    AsyncListUtil.this.d.onItemLoaded(keyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            if (isRequestedGeneration(i)) {
                TileList.Tile<T> removeAtPos = AsyncListUtil.this.e.removeAtPos(i2);
                if (removeAtPos != null) {
                    AsyncListUtil.this.g.recycleTile(removeAtPos);
                    return;
                }
                Log.e("AsyncListUtil", "tile not found @" + i2);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            if (isRequestedGeneration(i)) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.l = i2;
                asyncListUtil.d.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.m = asyncListUtil2.n;
                recycleAllTiles();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.k = false;
                asyncListUtil3.a();
            }
        }
    };
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback = new ThreadUtil.BackgroundCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.2
        final SparseBooleanArray a = new SparseBooleanArray();
        private int mFirstRequiredTileStart;
        private int mGeneration;
        private int mItemCount;
        private int mLastRequiredTileStart;
        private TileList.Tile<T> mRecycledRoot;

        private TileList.Tile<T> acquireTile() {
            TileList.Tile<T> tile = this.mRecycledRoot;
            if (tile != null) {
                this.mRecycledRoot = tile.a;
                return tile;
            }
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            return new TileList.Tile<>(asyncListUtil.a, asyncListUtil.b);
        }

        private void addTile(TileList.Tile<T> tile) {
            this.a.put(tile.mStartPosition, true);
            AsyncListUtil.this.f.addTile(this.mGeneration, tile);
        }

        private void flushTileCache(int i) {
            int maxCachedTiles = AsyncListUtil.this.c.getMaxCachedTiles();
            while (this.a.size() >= maxCachedTiles) {
                int keyAt = this.a.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.a;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i2 = this.mFirstRequiredTileStart - keyAt;
                int i3 = keyAt2 - this.mLastRequiredTileStart;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    removeTile(keyAt);
                } else {
                    if (i3 <= 0) {
                        return;
                    }
                    if (i2 >= i3 && i != 1) {
                        return;
                    } else {
                        removeTile(keyAt2);
                    }
                }
            }
        }

        private int getTileStart(int i) {
            return i - (i % AsyncListUtil.this.b);
        }

        private boolean isTileLoaded(int i) {
            return this.a.get(i);
        }

        private void log(String str, Object... objArr) {
            Log.d("AsyncListUtil", "[BKGR] " + String.format(str, objArr));
        }

        private void removeTile(int i) {
            this.a.delete(i);
            AsyncListUtil.this.f.removeTile(this.mGeneration, i);
        }

        private void requestTiles(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.g.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.b;
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            if (isTileLoaded(i)) {
                return;
            }
            TileList.Tile<T> acquireTile = acquireTile();
            acquireTile.mStartPosition = i;
            acquireTile.mItemCount = Math.min(AsyncListUtil.this.b, this.mItemCount - acquireTile.mStartPosition);
            AsyncListUtil.this.c.fillData(acquireTile.mItems, acquireTile.mStartPosition, acquireTile.mItemCount);
            flushTileCache(i2);
            addTile(acquireTile);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.c.recycleData(tile.mItems, tile.mItemCount);
            tile.a = this.mRecycledRoot;
            this.mRecycledRoot = tile;
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            this.mGeneration = i;
            this.a.clear();
            this.mItemCount = AsyncListUtil.this.c.refreshData();
            AsyncListUtil.this.f.updateItemCount(this.mGeneration, this.mItemCount);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i > i2) {
                return;
            }
            int tileStart = getTileStart(i);
            int tileStart2 = getTileStart(i2);
            this.mFirstRequiredTileStart = getTileStart(i3);
            this.mLastRequiredTileStart = getTileStart(i4);
            if (i5 == 1) {
                requestTiles(this.mFirstRequiredTileStart, tileStart2, i5, true);
                requestTiles(tileStart2 + AsyncListUtil.this.b, this.mLastRequiredTileStart, i5, false);
            } else {
                requestTiles(tileStart, this.mLastRequiredTileStart, i5, false);
                requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.b, i5, true);
            }
        }
    };

    /* loaded from: classes.dex */
    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i, int i2);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            int i4 = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = i4 + i2;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        this.a = cls;
        this.b = i;
        this.c = dataCallback;
        this.d = viewCallback;
        this.e = new TileList<>(this.b);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.f = messageThreadUtil.getMainThreadProxy(this.mMainThreadCallback);
        this.g = messageThreadUtil.getBackgroundProxy(this.mBackgroundCallback);
        refresh();
    }

    private boolean isRefreshPending() {
        return this.n != this.m;
    }

    void a() {
        this.d.getItemRangeInto(this.h);
        int[] iArr = this.h;
        if (iArr[0] > iArr[1] || iArr[0] < 0 || iArr[1] >= this.l) {
            return;
        }
        if (this.k) {
            int i = iArr[0];
            int[] iArr2 = this.i;
            if (i <= iArr2[1] && iArr2[0] <= iArr[1]) {
                if (iArr[0] < iArr2[0]) {
                    this.mScrollHint = 1;
                } else if (iArr[0] > iArr2[0]) {
                    this.mScrollHint = 2;
                }
                int[] iArr3 = this.i;
                int[] iArr4 = this.h;
                iArr3[0] = iArr4[0];
                iArr3[1] = iArr4[1];
                this.d.extendRangeInto(iArr4, this.j, this.mScrollHint);
                int[] iArr5 = this.j;
                iArr5[0] = Math.min(this.h[0], Math.max(iArr5[0], 0));
                int[] iArr6 = this.j;
                iArr6[1] = Math.max(this.h[1], Math.min(iArr6[1], this.l - 1));
                ThreadUtil.BackgroundCallback<T> backgroundCallback = this.g;
                int[] iArr7 = this.h;
                int i2 = iArr7[0];
                int i3 = iArr7[1];
                int[] iArr8 = this.j;
                backgroundCallback.updateRange(i2, i3, iArr8[0], iArr8[1], this.mScrollHint);
            }
        }
        this.mScrollHint = 0;
        int[] iArr32 = this.i;
        int[] iArr42 = this.h;
        iArr32[0] = iArr42[0];
        iArr32[1] = iArr42[1];
        this.d.extendRangeInto(iArr42, this.j, this.mScrollHint);
        int[] iArr52 = this.j;
        iArr52[0] = Math.min(this.h[0], Math.max(iArr52[0], 0));
        int[] iArr62 = this.j;
        iArr62[1] = Math.max(this.h[1], Math.min(iArr62[1], this.l - 1));
        ThreadUtil.BackgroundCallback<T> backgroundCallback2 = this.g;
        int[] iArr72 = this.h;
        int i22 = iArr72[0];
        int i32 = iArr72[1];
        int[] iArr82 = this.j;
        backgroundCallback2.updateRange(i22, i32, iArr82[0], iArr82[1], this.mScrollHint);
    }

    @Nullable
    public T getItem(int i) {
        if (i < 0 || i >= this.l) {
            throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.l);
        }
        T itemAt = this.e.getItemAt(i);
        if (itemAt == null && !isRefreshPending()) {
            this.o.put(i, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.l;
    }

    public void onRangeChanged() {
        if (isRefreshPending()) {
            return;
        }
        a();
        this.k = true;
    }

    public void refresh() {
        this.o.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.g;
        int i = this.n + 1;
        this.n = i;
        backgroundCallback.refresh(i);
    }
}
