package k0;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* renamed from: k0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0485i implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f5247e = new ThreadLocal();

    /* renamed from: f, reason: collision with root package name */
    public static final M0.a f5248f = new M0.a(6);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f5249a;

    /* renamed from: b, reason: collision with root package name */
    public long f5250b;

    /* renamed from: c, reason: collision with root package name */
    public long f5251c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f5252d;

    public final void a(RecyclerView recyclerView, int i, int i3) {
        if (recyclerView.p && this.f5250b == 0) {
            this.f5250b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        C0483g c0483g = recyclerView.f3697W;
        c0483g.f5239a = i;
        c0483g.f5240b = i3;
    }

    public final void b(long j2) {
        C0484h c0484h;
        RecyclerView recyclerView;
        ArrayList arrayList = this.f5252d;
        ArrayList arrayList2 = this.f5249a;
        int size = arrayList2.size();
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView2 = (RecyclerView) arrayList2.get(i3);
            int windowVisibility = recyclerView2.getWindowVisibility();
            C0483g c0483g = recyclerView2.f3697W;
            if (windowVisibility == 0) {
                c0483g.f5241c = 0;
                i += c0483g.f5241c;
            }
        }
        arrayList.ensureCapacity(i);
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList2.get(i4);
            if (recyclerView3.getWindowVisibility() == 0) {
                C0483g c0483g2 = recyclerView3.f3697W;
                Math.abs(c0483g2.f5239a);
                Math.abs(c0483g2.f5240b);
                if (c0483g2.f5241c * 2 > 0) {
                    if (arrayList.size() <= 0) {
                        arrayList.add(new Object());
                    }
                    throw null;
                }
            }
        }
        Collections.sort(arrayList, f5248f);
        if (arrayList.size() > 0 && (recyclerView = (c0484h = (C0484h) arrayList.get(0)).f5245d) != null) {
            int i5 = c0484h.f5246e;
            if (recyclerView.f3704d.s() <= 0) {
                z zVar = recyclerView.f3698a;
                try {
                    recyclerView.f3728z++;
                    zVar.a(i5);
                    throw null;
                } catch (Throwable th) {
                    int i6 = recyclerView.f3728z - 1;
                    recyclerView.f3728z = i6;
                    if (i6 < 1) {
                        recyclerView.f3728z = 0;
                    }
                    throw th;
                }
            }
            RecyclerView.j(recyclerView.f3704d.r(0));
            throw null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f5249a;
        try {
            int i = F.h.f164a;
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long j2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i3);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(j2) + this.f5251c);
                }
            }
            this.f5250b = 0L;
            Trace.endSection();
        } catch (Throwable th) {
            this.f5250b = 0L;
            int i4 = F.h.f164a;
            Trace.endSection();
            throw th;
        }
    }
}
