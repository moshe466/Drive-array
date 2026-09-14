package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Task;
import java.io.File;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class Kit<Result> implements Comparable<Kit> {
    Fabric a;
    Context c;
    InitializationCallback<Result> d;
    IdManager e;
    InitializationTask<Result> b = new InitializationTask<>(this);
    final DependsOn f = (DependsOn) getClass().getAnnotation(DependsOn.class);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Result a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, Fabric fabric, InitializationCallback<Result> initializationCallback, IdManager idManager) {
        this.a = fabric;
        this.c = new FabricContext(context, getIdentifier(), getPath());
        this.d = initializationCallback;
        this.e = idManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Result result) {
    }

    boolean a(Kit kit) {
        if (d()) {
            for (Class<?> cls : this.f.value()) {
                if (cls.isAssignableFrom(kit.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<Task> b() {
        return this.b.getDependencies();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Result result) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IdManager c() {
        return this.e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Kit kit) {
        if (a(kit)) {
            return 1;
        }
        if (kit.a((Kit) this)) {
            return -1;
        }
        if (!d() || kit.d()) {
            return (d() || !kit.d()) ? 0 : -1;
        }
        return 1;
    }

    boolean d() {
        return this.f != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.b.executeOnExecutor(this.a.getExecutorService(), (Object[]) new Void[]{null});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f() {
        return true;
    }

    public Context getContext() {
        return this.c;
    }

    public Fabric getFabric() {
        return this.a;
    }

    public abstract String getIdentifier();

    public String getPath() {
        return ".Fabric" + File.separator + getIdentifier();
    }

    public abstract String getVersion();
}
