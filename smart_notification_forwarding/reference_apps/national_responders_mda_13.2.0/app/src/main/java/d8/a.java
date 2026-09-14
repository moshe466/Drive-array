package d8;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends RuntimeException {

    /* renamed from: f, reason: collision with root package name */
    private final List<Throwable> f8740f;

    /* renamed from: g, reason: collision with root package name */
    private final String f8741g;

    /* renamed from: h, reason: collision with root package name */
    private Throwable f8742h;

    /* renamed from: d8.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0144a extends RuntimeException {
        C0144a() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b {
        b() {
        }

        abstract void a(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final PrintStream f8743a;

        c(PrintStream printStream) {
            this.f8743a = printStream;
        }

        @Override // d8.a.b
        void a(Object obj) {
            this.f8743a.println(obj);
        }
    }

    /* loaded from: classes.dex */
    static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        private final PrintWriter f8744a;

        d(PrintWriter printWriter) {
            this.f8744a = printWriter;
        }

        @Override // d8.a.b
        void a(Object obj) {
            this.f8744a.println(obj);
        }
    }

    public a(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Object obj : iterable) {
                if (obj instanceof a) {
                    linkedHashSet.addAll(((a) obj).b());
                } else {
                    linkedHashSet.add(obj == null ? new NullPointerException("Throwable was null!") : obj);
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.f8740f = unmodifiableList;
        this.f8741g = unmodifiableList.size() + " exceptions occurred. ";
    }

    public a(Throwable... thArr) {
        this(thArr == null ? Arrays.asList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void a(StringBuilder sb2, Throwable th, String str) {
        sb2.append(str);
        sb2.append(th);
        sb2.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb2.append("\t\tat ");
            sb2.append(stackTraceElement);
            sb2.append('\n');
        }
        if (th.getCause() != null) {
            sb2.append("\tCaused by: ");
            a(sb2, th.getCause(), "");
        }
    }

    private List<Throwable> c(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }

    private Throwable d(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.f8742h == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }

    private void e(b bVar) {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(this);
        sb2.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb2.append("\tat ");
            sb2.append(stackTraceElement);
            sb2.append('\n');
        }
        int i10 = 1;
        for (Throwable th : this.f8740f) {
            sb2.append("  ComposedException ");
            sb2.append(i10);
            sb2.append(" :\n");
            a(sb2, th, "\t");
            i10++;
        }
        bVar.a(sb2.toString());
    }

    public List<Throwable> b() {
        return this.f8740f;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.f8742h == null) {
            C0144a c0144a = new C0144a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.f8740f.iterator();
            Throwable th = c0144a;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th2 : c(next)) {
                        if (hashSet.contains(th2)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th2);
                        }
                    }
                    try {
                        th.initCause(next);
                    } catch (Throwable unused) {
                    }
                    th = d(th);
                }
            }
            this.f8742h = c0144a;
        }
        return this.f8742h;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f8741g;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        e(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        e(new d(printWriter));
    }
}
