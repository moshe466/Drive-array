package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Fragment> f2989a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, d0> f2990b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, c0> f2991c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private z f2992d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(z zVar) {
        this.f2992d = zVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0 B(String str, c0 c0Var) {
        return c0Var != null ? this.f2991c.put(str, c0Var) : this.f2991c.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.f2989a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f2989a) {
            this.f2989a.add(fragment);
        }
        fragment.f2842q = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f2990b.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f2990b.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i10) {
        for (d0 d0Var : this.f2990b.values()) {
            if (d0Var != null) {
                d0Var.t(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f2990b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (d0 d0Var : this.f2990b.values()) {
                printWriter.print(str);
                if (d0Var != null) {
                    Fragment k10 = d0Var.k();
                    printWriter.println(k10);
                    k10.p(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f2989a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = this.f2989a.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment f(String str) {
        d0 d0Var = this.f2990b.get(str);
        if (d0Var != null) {
            return d0Var.k();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment g(int i10) {
        for (int size = this.f2989a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2989a.get(size);
            if (fragment != null && fragment.C == i10) {
                return fragment;
            }
        }
        for (d0 d0Var : this.f2990b.values()) {
            if (d0Var != null) {
                Fragment k10 = d0Var.k();
                if (k10.C == i10) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f2989a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f2989a.get(size);
                if (fragment != null && str.equals(fragment.E)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (d0 d0Var : this.f2990b.values()) {
            if (d0Var != null) {
                Fragment k10 = d0Var.k();
                if (str.equals(k10.E)) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment s10;
        for (d0 d0Var : this.f2990b.values()) {
            if (d0Var != null && (s10 = d0Var.k().s(str)) != null) {
                return s10;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.M;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f2989a.indexOf(fragment);
        for (int i10 = indexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = this.f2989a.get(i10);
            if (fragment2.M == viewGroup && (view2 = fragment2.N) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f2989a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f2989a.get(indexOf);
            if (fragment3.M == viewGroup && (view = fragment3.N) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<d0> k() {
        ArrayList arrayList = new ArrayList();
        for (d0 d0Var : this.f2990b.values()) {
            if (d0Var != null) {
                arrayList.add(d0Var);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        Iterator<d0> it = this.f2990b.values().iterator();
        while (it.hasNext()) {
            d0 next = it.next();
            arrayList.add(next != null ? next.k() : null);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<c0> m() {
        return new ArrayList<>(this.f2991c.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0 n(String str) {
        return this.f2990b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> o() {
        ArrayList arrayList;
        if (this.f2989a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2989a) {
            arrayList = new ArrayList(this.f2989a);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z p() {
        return this.f2992d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0 q(String str) {
        return this.f2991c.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(d0 d0Var) {
        Fragment k10 = d0Var.k();
        if (c(k10.f2836k)) {
            return;
        }
        this.f2990b.put(k10.f2836k, d0Var);
        if (k10.I) {
            if (k10.H) {
                this.f2992d.e(k10);
            } else {
                this.f2992d.o(k10);
            }
            k10.I = false;
        }
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Added fragment to active set ");
            sb2.append(k10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(d0 d0Var) {
        Fragment k10 = d0Var.k();
        if (k10.H) {
            this.f2992d.o(k10);
        }
        if (this.f2990b.put(k10.f2836k, null) != null && w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Removed fragment from active set ");
            sb2.append(k10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        Iterator<Fragment> it = this.f2989a.iterator();
        while (it.hasNext()) {
            d0 d0Var = this.f2990b.get(it.next().f2836k);
            if (d0Var != null) {
                d0Var.m();
            }
        }
        for (d0 d0Var2 : this.f2990b.values()) {
            if (d0Var2 != null) {
                d0Var2.m();
                Fragment k10 = d0Var2.k();
                if (k10.f2843r && !k10.o0()) {
                    if (k10.f2844s && !this.f2991c.containsKey(k10.f2836k)) {
                        d0Var2.r();
                    }
                    s(d0Var2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(Fragment fragment) {
        synchronized (this.f2989a) {
            this.f2989a.remove(fragment);
        }
        fragment.f2842q = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.f2990b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(List<String> list) {
        this.f2989a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment f10 = f(str);
                if (f10 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (w.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("restoreSaveState: added (");
                    sb2.append(str);
                    sb2.append("): ");
                    sb2.append(f10);
                }
                a(f10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(ArrayList<c0> arrayList) {
        this.f2991c.clear();
        Iterator<c0> it = arrayList.iterator();
        while (it.hasNext()) {
            c0 next = it.next();
            this.f2991c.put(next.f2910g, next);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f2990b.size());
        for (d0 d0Var : this.f2990b.values()) {
            if (d0Var != null) {
                Fragment k10 = d0Var.k();
                d0Var.r();
                arrayList.add(k10.f2836k);
                if (w.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Saved state of ");
                    sb2.append(k10);
                    sb2.append(": ");
                    sb2.append(k10.f2832g);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> z() {
        synchronized (this.f2989a) {
            if (this.f2989a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f2989a.size());
            Iterator<Fragment> it = this.f2989a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.f2836k);
                if (w.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("saveAllState: adding fragment (");
                    sb2.append(next.f2836k);
                    sb2.append("): ");
                    sb2.append(next);
                }
            }
            return arrayList;
        }
    }
}
