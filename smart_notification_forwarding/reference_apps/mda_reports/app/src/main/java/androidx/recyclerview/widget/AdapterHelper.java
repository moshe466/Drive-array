package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    private static final String TAG = "AHT";
    final ArrayList<UpdateOp> a;
    final ArrayList<UpdateOp> b;
    final Callback c;
    Runnable d;
    final boolean e;
    final OpReorderer f;
    private int mExistingUpdateTypes;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i);

        void markViewHoldersUpdated(int i, int i2, Object obj);

        void offsetPositionsForAdd(int i, int i2);

        void offsetPositionsForMove(int i, int i2);

        void offsetPositionsForRemovingInvisible(int i, int i2);

        void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UpdateOp {
        int a;
        int b;
        Object c;
        int d;

        UpdateOp(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.b = i2;
            this.d = i3;
            this.c = obj;
        }

        String a() {
            int i = this.a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || UpdateOp.class != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i = this.a;
            if (i != updateOp.a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.b) == 1 && this.d == updateOp.b && this.b == updateOp.d) {
                return true;
            }
            if (this.d != updateOp.d || this.b != updateOp.b) {
                return false;
            }
            Object obj2 = this.c;
            Object obj3 = updateOp.c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdapterHelper(Callback callback) {
        this(callback, false);
    }

    AdapterHelper(Callback callback, boolean z) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.mExistingUpdateTypes = 0;
        this.c = callback;
        this.e = z;
        this.f = new OpReorderer(this);
    }

    private void applyAdd(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyMove(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyRemove(UpdateOp updateOp) {
        boolean z;
        char c;
        int i = updateOp.b;
        int i2 = updateOp.d + i;
        int i3 = 0;
        char c2 = 65535;
        int i4 = i;
        while (i4 < i2) {
            if (this.c.findViewHolder(i4) != null || canFindInPreLayout(i4)) {
                if (c2 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i4 -= i3;
                i2 -= i3;
                i3 = 1;
            } else {
                i3++;
            }
            i4++;
            c2 = c;
        }
        if (i3 != updateOp.d) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i, i3, null);
        }
        if (c2 == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        int i = updateOp.b;
        int i2 = updateOp.d + i;
        int i3 = i;
        int i4 = 0;
        char c = 65535;
        while (i < i2) {
            if (this.c.findViewHolder(i) != null || canFindInPreLayout(i)) {
                if (c == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(4, i3, i4, updateOp.c));
                    i3 = i;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(4, i3, i4, updateOp.c));
                    i3 = i;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
            i++;
        }
        if (i4 != updateOp.d) {
            Object obj = updateOp.c;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(4, i3, i4, obj);
        }
        if (c == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private boolean canFindInPreLayout(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.b.get(i2);
            int i3 = updateOp.a;
            if (i3 == 8) {
                if (a(updateOp.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = updateOp.b;
                int i5 = updateOp.d + i4;
                while (i4 < i5) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i;
        int i2 = updateOp.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.b, i2);
        int i3 = updateOp.b;
        int i4 = updateOp.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
            }
            i = 1;
        }
        int i5 = updatePositionWithPostponed;
        int i6 = i3;
        int i7 = 1;
        for (int i8 = 1; i8 < updateOp.d; i8++) {
            int updatePositionWithPostponed2 = updatePositionWithPostponed(updateOp.b + (i * i8), updateOp.a);
            int i9 = updateOp.a;
            if (i9 == 2 ? updatePositionWithPostponed2 == i5 : i9 == 4 && updatePositionWithPostponed2 == i5 + 1) {
                i7++;
            } else {
                UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.a, i5, i7, updateOp.c);
                a(obtainUpdateOp, i6);
                recycleUpdateOp(obtainUpdateOp);
                if (updateOp.a == 4) {
                    i6 += i7;
                }
                i5 = updatePositionWithPostponed2;
                i7 = 1;
            }
        }
        Object obj = updateOp.c;
        recycleUpdateOp(updateOp);
        if (i7 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.a, i5, i7, obj);
            a(obtainUpdateOp2, i6);
            recycleUpdateOp(obtainUpdateOp2);
        }
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.b.add(updateOp);
        int i = updateOp.a;
        if (i == 1) {
            this.c.offsetPositionsForAdd(updateOp.b, updateOp.d);
            return;
        }
        if (i == 2) {
            this.c.offsetPositionsForRemovingLaidOutOrNewView(updateOp.b, updateOp.d);
            return;
        }
        if (i == 4) {
            this.c.markViewHoldersUpdated(updateOp.b, updateOp.d, updateOp.c);
        } else {
            if (i == 8) {
                this.c.offsetPositionsForMove(updateOp.b, updateOp.d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    private int updatePositionWithPostponed(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.b.get(size);
            int i7 = updateOp.a;
            if (i7 == 8) {
                int i8 = updateOp.b;
                int i9 = updateOp.d;
                if (i8 >= i9) {
                    i9 = i8;
                    i8 = i9;
                }
                if (i < i8 || i > i9) {
                    int i10 = updateOp.b;
                    if (i < i10) {
                        if (i2 == 1) {
                            updateOp.b = i10 + 1;
                            i4 = updateOp.d + 1;
                        } else if (i2 == 2) {
                            updateOp.b = i10 - 1;
                            i4 = updateOp.d - 1;
                        }
                        updateOp.d = i4;
                    }
                } else {
                    int i11 = updateOp.b;
                    if (i8 == i11) {
                        if (i2 == 1) {
                            i6 = updateOp.d + 1;
                        } else {
                            if (i2 == 2) {
                                i6 = updateOp.d - 1;
                            }
                            i++;
                        }
                        updateOp.d = i6;
                        i++;
                    } else {
                        if (i2 == 1) {
                            i5 = i11 + 1;
                        } else {
                            if (i2 == 2) {
                                i5 = i11 - 1;
                            }
                            i--;
                        }
                        updateOp.b = i5;
                        i--;
                    }
                }
            } else {
                int i12 = updateOp.b;
                if (i12 > i) {
                    if (i2 == 1) {
                        i3 = i12 + 1;
                    } else if (i2 == 2) {
                        i3 = i12 - 1;
                    }
                    updateOp.b = i3;
                } else if (i7 == 1) {
                    i -= updateOp.d;
                } else if (i7 == 2) {
                    i += updateOp.d;
                }
            }
        }
        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.b.get(size2);
            if (updateOp2.a == 8) {
                int i13 = updateOp2.d;
                if (i13 != updateOp2.b && i13 >= 0) {
                }
                this.b.remove(size2);
                recycleUpdateOp(updateOp2);
            } else {
                if (updateOp2.d > 0) {
                }
                this.b.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return a(i, 0);
    }

    int a(int i, int i2) {
        int size = this.b.size();
        while (i2 < size) {
            UpdateOp updateOp = this.b.get(i2);
            int i3 = updateOp.a;
            if (i3 == 8) {
                int i4 = updateOp.b;
                if (i4 == i) {
                    i = updateOp.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (updateOp.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = updateOp.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = updateOp.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += updateOp.d;
                }
            }
            i2++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.c.onDispatchSecondPass(this.b.get(i));
        }
        a(this.b);
        this.mExistingUpdateTypes = 0;
    }

    void a(UpdateOp updateOp, int i) {
        this.c.onDispatchFirstPass(updateOp);
        int i2 = updateOp.a;
        if (i2 == 2) {
            this.c.offsetPositionsForRemovingInvisible(i, updateOp.d);
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.c.markViewHoldersUpdated(i, updateOp.d, updateOp.c);
        }
    }

    void a(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            recycleUpdateOp(list.get(i));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.a.add(obtainUpdateOp(8, i, i2, null));
        this.mExistingUpdateTypes |= 8;
        return this.a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.a.add(obtainUpdateOp(4, i, i2, obj));
        this.mExistingUpdateTypes |= 4;
        return this.a.size() == 1;
    }

    public int applyPendingUpdatesToPosition(int i) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.a.get(i2);
            int i3 = updateOp.a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = updateOp.b;
                    if (i4 <= i) {
                        int i5 = updateOp.d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = updateOp.b;
                    if (i6 == i) {
                        i = updateOp.d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (updateOp.d <= i) {
                            i++;
                        }
                    }
                }
            } else if (updateOp.b <= i) {
                i += updateOp.d;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.a.get(i);
            int i2 = updateOp.a;
            if (i2 == 1) {
                this.c.onDispatchSecondPass(updateOp);
                this.c.offsetPositionsForAdd(updateOp.b, updateOp.d);
            } else if (i2 == 2) {
                this.c.onDispatchSecondPass(updateOp);
                this.c.offsetPositionsForRemovingInvisible(updateOp.b, updateOp.d);
            } else if (i2 == 4) {
                this.c.onDispatchSecondPass(updateOp);
                this.c.markViewHoldersUpdated(updateOp.b, updateOp.d, updateOp.c);
            } else if (i2 == 8) {
                this.c.onDispatchSecondPass(updateOp);
                this.c.offsetPositionsForMove(updateOp.b, updateOp.d);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.a);
        this.mExistingUpdateTypes = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        return (i & this.mExistingUpdateTypes) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.a.add(obtainUpdateOp(1, i, i2, null));
        this.mExistingUpdateTypes |= 1;
        return this.a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.a.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.a.add(obtainUpdateOp(2, i, i2, null));
        this.mExistingUpdateTypes |= 2;
        return this.a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return (this.b.isEmpty() || this.a.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f.a(this.a);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.a.get(i);
            int i2 = updateOp.a;
            if (i2 == 1) {
                applyAdd(updateOp);
            } else if (i2 == 2) {
                applyRemove(updateOp);
            } else if (i2 == 4) {
                applyUpdate(updateOp);
            } else if (i2 == 8) {
                applyMove(updateOp);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        a(this.a);
        a(this.b);
        this.mExistingUpdateTypes = 0;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj) {
        UpdateOp acquire = this.mUpdateOpPool.acquire();
        if (acquire == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        acquire.a = i;
        acquire.b = i2;
        acquire.d = i3;
        acquire.c = obj;
        return acquire;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        if (this.e) {
            return;
        }
        updateOp.c = null;
        this.mUpdateOpPool.release(updateOp);
    }
}
