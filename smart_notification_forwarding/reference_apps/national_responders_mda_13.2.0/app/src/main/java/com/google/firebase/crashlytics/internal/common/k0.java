package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    private static final FilenameFilter f7193a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f7194b = v.c("awaitEvenIfOnMainThread task continuation executor");

    /* loaded from: classes.dex */
    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class b<T> implements z2.c<T, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z2.m f7195a;

        b(z2.m mVar) {
            this.f7195a = mVar;
        }

        @Override // z2.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(z2.l<T> lVar) {
            if (lVar.p()) {
                this.f7195a.e(lVar.l());
                return null;
            }
            this.f7195a.d(lVar.k());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Callable f7196f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ z2.m f7197g;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* loaded from: classes.dex */
        class a<T> implements z2.c<T, Void> {
            a() {
            }

            @Override // z2.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void a(z2.l<T> lVar) {
                if (lVar.p()) {
                    c.this.f7197g.c(lVar.l());
                    return null;
                }
                c.this.f7197g.b(lVar.k());
                return null;
            }
        }

        c(Callable callable, z2.m mVar) {
            this.f7196f = callable;
            this.f7197g = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ((z2.l) this.f7196f.call()).i(new a());
            } catch (Exception e10) {
                this.f7197g.b(e10);
            }
        }
    }

    public static <T> T a(z2.l<T> lVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        lVar.h(f7194b, j0.b(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4L, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (lVar.p()) {
            return lVar.l();
        }
        if (lVar.n()) {
            throw new CancellationException("Task is already canceled");
        }
        if (lVar.o()) {
            throw new IllegalStateException(lVar.k());
        }
        throw new TimeoutException();
    }

    public static <T> z2.l<T> b(Executor executor, Callable<z2.l<T>> callable) {
        z2.m mVar = new z2.m();
        executor.execute(new c(callable, mVar));
        return mVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(File file, int i10, Comparator<File> comparator) {
        return d(file, f7193a, i10, comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(File file, FilenameFilter filenameFilter, int i10, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        return e(Arrays.asList(listFiles), i10, comparator);
    }

    static int e(List<File> list, int i10, Comparator<File> comparator) {
        int size = list.size();
        Collections.sort(list, comparator);
        for (File file : list) {
            if (size <= i10) {
                return size;
            }
            i(file);
            size--;
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(File file, File file2, int i10, Comparator<File> comparator) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        File[] listFiles2 = file2.listFiles(f7193a);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        if (listFiles2 == null) {
            listFiles2 = new File[0];
        }
        arrayList.addAll(Arrays.asList(listFiles));
        arrayList.addAll(Arrays.asList(listFiles2));
        return e(arrayList, i10, comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object g(CountDownLatch countDownLatch, z2.l lVar) {
        countDownLatch.countDown();
        return null;
    }

    public static <T> z2.l<T> h(z2.l<T> lVar, z2.l<T> lVar2) {
        z2.m mVar = new z2.m();
        b bVar = new b(mVar);
        lVar.i(bVar);
        lVar2.i(bVar);
        return mVar.a();
    }

    private static void i(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                i(file2);
            }
        }
        file.delete();
    }
}
