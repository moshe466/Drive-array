package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f7404a;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f7408e;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayDeque<String> f7407d = new ArrayDeque<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f7409f = false;

    /* renamed from: b, reason: collision with root package name */
    private final String f7405b = "topic_operation_queue";

    /* renamed from: c, reason: collision with root package name */
    private final String f7406c = ",";

    private a0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f7404a = sharedPreferences;
        this.f7408e = executor;
    }

    private boolean b(boolean z10) {
        if (!z10 || this.f7409f) {
            return z10;
        }
        i();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a0 c(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        a0 a0Var = new a0(sharedPreferences, "topic_operation_queue", ",", executor);
        a0Var.d();
        return a0Var;
    }

    private void d() {
        synchronized (this.f7407d) {
            this.f7407d.clear();
            String string = this.f7404a.getString(this.f7405b, "");
            if (!TextUtils.isEmpty(string) && string.contains(this.f7406c)) {
                for (String str : string.split(this.f7406c, -1)) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f7407d.add(str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void a() {
        synchronized (this.f7407d) {
            this.f7404a.edit().putString(this.f7405b, g()).commit();
        }
    }

    private void i() {
        this.f7408e.execute(new Runnable(this) { // from class: com.google.firebase.messaging.z

            /* renamed from: f, reason: collision with root package name */
            private final a0 f7479f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7479f = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7479f.a();
            }
        });
    }

    public String e() {
        String peek;
        synchronized (this.f7407d) {
            peek = this.f7407d.peek();
        }
        return peek;
    }

    public boolean f(Object obj) {
        boolean remove;
        synchronized (this.f7407d) {
            remove = this.f7407d.remove(obj);
            b(remove);
        }
        return remove;
    }

    public String g() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.f7407d.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append(this.f7406c);
        }
        return sb2.toString();
    }
}
