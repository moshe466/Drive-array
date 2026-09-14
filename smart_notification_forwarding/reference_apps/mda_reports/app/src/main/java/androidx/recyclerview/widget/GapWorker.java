package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> d = new ThreadLocal<>();
    static Comparator<Task> e = new Comparator<Task>() { // from class: androidx.recyclerview.widget.GapWorker.1
        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            if ((task.view == null) != (task2.view == null)) {
                return task.view == null ? 1 : -1;
            }
            boolean z = task.immediate;
            if (z != task2.immediate) {
                return z ? -1 : 1;
            }
            int i = task2.viewVelocity - task.viewVelocity;
            if (i != 0) {
                return i;
            }
            int i2 = task.distanceToItem - task2.distanceToItem;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    long b;
    long c;
    ArrayList<RecyclerView> a = new ArrayList<>();
    private ArrayList<Task> mTasks = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int a;
        int b;
        int[] c;
        int d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }

        void a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.j;
            if (recyclerView.i == null || layoutManager == null || !layoutManager.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.b.c()) {
                    layoutManager.collectInitialPrefetchPositions(recyclerView.i.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                layoutManager.collectAdjacentPrefetchPositions(this.a, this.b, recyclerView.z, this);
            }
            int i = this.d;
            if (i > layoutManager.i) {
                layoutManager.i = i;
                layoutManager.j = z;
                recyclerView.a.h();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.d * 2;
            int[] iArr = this.c;
            if (iArr == null) {
                this.c = new int[4];
                Arrays.fill(this.c, -1);
            } else if (i3 >= iArr.length) {
                this.c = new int[i3 * 2];
                System.arraycopy(iArr, 0, this.c, 0, iArr.length);
            }
            int[] iArr2 = this.c;
            iArr2[i3] = i;
            iArr2[i3 + 1] = i2;
            this.d++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int b = recyclerView.c.b();
        for (int i2 = 0; i2 < b; i2++) {
            RecyclerView.ViewHolder f = RecyclerView.f(recyclerView.c.d(i2));
            if (f.b == i && !f.j()) {
                return true;
            }
        }
        return false;
    }

    private void buildTaskList() {
        Task task;
        int size = this.a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.a.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.y.a(recyclerView, false);
                i += recyclerView.y.d;
            }
        }
        this.mTasks.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.a.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.y;
                int abs = Math.abs(layoutPrefetchRegistryImpl.a) + Math.abs(layoutPrefetchRegistryImpl.b);
                int i5 = i3;
                for (int i6 = 0; i6 < layoutPrefetchRegistryImpl.d * 2; i6 += 2) {
                    if (i5 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = this.mTasks.get(i5);
                    }
                    int i7 = layoutPrefetchRegistryImpl.c[i6 + 1];
                    task.immediate = i7 <= abs;
                    task.viewVelocity = abs;
                    task.distanceToItem = i7;
                    task.view = recyclerView2;
                    task.position = layoutPrefetchRegistryImpl.c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.mTasks, e);
    }

    private void flushTaskWithDeadline(Task task, long j) {
        RecyclerView.ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task.view, task.position, task.immediate ? Long.MAX_VALUE : j);
        if (prefetchPositionWithDeadline == null || prefetchPositionWithDeadline.a == null || !prefetchPositionWithDeadline.i() || prefetchPositionWithDeadline.j()) {
            return;
        }
        prefetchInnerRecyclerViewWithDeadline(prefetchPositionWithDeadline.a.get(), j);
    }

    private void flushTasksWithDeadline(long j) {
        for (int i = 0; i < this.mTasks.size(); i++) {
            Task task = this.mTasks.get(i);
            if (task.view == null) {
                return;
            }
            flushTaskWithDeadline(task, j);
            task.clear();
        }
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.t && recyclerView.c.b() != 0) {
            recyclerView.r();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.y;
        layoutPrefetchRegistryImpl.a(recyclerView, true);
        if (layoutPrefetchRegistryImpl.d != 0) {
            try {
                TraceCompat.beginSection("RV Nested Prefetch");
                recyclerView.z.a(recyclerView.i);
                for (int i = 0; i < layoutPrefetchRegistryImpl.d * 2; i += 2) {
                    prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.c[i], j);
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.a;
        try {
            recyclerView.o();
            RecyclerView.ViewHolder a = recycler.a(i, false, j);
            if (a != null) {
                if (!a.i() || a.j()) {
                    recycler.a(a, false);
                } else {
                    recycler.recycleView(a.itemView);
                }
            }
            return a;
        } finally {
            recyclerView.a(false);
        }
    }

    void a(long j) {
        buildTaskList();
        flushTasksWithDeadline(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.b == 0) {
            this.b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.y.a(i, i2);
    }

    public void add(RecyclerView recyclerView) {
        this.a.add(recyclerView);
    }

    public void remove(RecyclerView recyclerView) {
        this.a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.a.isEmpty()) {
                int size = this.a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.a.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.c);
                }
            }
        } finally {
            this.b = 0L;
            TraceCompat.endSection();
        }
    }
}
