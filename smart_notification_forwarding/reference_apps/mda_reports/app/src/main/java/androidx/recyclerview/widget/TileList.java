package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
class TileList<T> {
    final int a;
    Tile<T> b;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    /* loaded from: classes.dex */
    public static class Tile<T> {
        Tile<T> a;
        public int mItemCount;
        public final T[] mItems;
        public int mStartPosition;

        public Tile(Class<T> cls, int i) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        }

        boolean a(int i) {
            int i2 = this.mStartPosition;
            return i2 <= i && i < i2 + this.mItemCount;
        }

        T b(int i) {
            return this.mItems[i - this.mStartPosition];
        }
    }

    public TileList(int i) {
        this.a = i;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.mTiles.valueAt(indexOfKey);
        this.mTiles.setValueAt(indexOfKey, tile);
        if (this.b == valueAt) {
            this.b = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i) {
        return this.mTiles.valueAt(i);
    }

    public T getItemAt(int i) {
        Tile<T> tile = this.b;
        if (tile == null || !tile.a(i)) {
            int indexOfKey = this.mTiles.indexOfKey(i - (i % this.a));
            if (indexOfKey < 0) {
                return null;
            }
            this.b = this.mTiles.valueAt(indexOfKey);
        }
        return this.b.b(i);
    }

    public Tile<T> removeAtPos(int i) {
        Tile<T> tile = this.mTiles.get(i);
        if (this.b == tile) {
            this.b = null;
        }
        this.mTiles.delete(i);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}
