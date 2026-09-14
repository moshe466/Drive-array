package b2;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final Account f3958a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f3959b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f3960c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f3961d;

    /* renamed from: e, reason: collision with root package name */
    private final View f3962e;

    /* renamed from: f, reason: collision with root package name */
    private final String f3963f;

    /* renamed from: g, reason: collision with root package name */
    private final String f3964g;

    /* renamed from: h, reason: collision with root package name */
    private final w2.a f3965h;

    /* renamed from: i, reason: collision with root package name */
    private Integer f3966i;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Account f3967a;

        /* renamed from: b, reason: collision with root package name */
        private l.b f3968b;

        /* renamed from: c, reason: collision with root package name */
        private String f3969c;

        /* renamed from: d, reason: collision with root package name */
        private String f3970d;

        /* renamed from: e, reason: collision with root package name */
        private w2.a f3971e = w2.a.f14891k;

        public e a() {
            return new e(this.f3967a, this.f3968b, null, 0, null, this.f3969c, this.f3970d, this.f3971e, false);
        }

        public a b(String str) {
            this.f3969c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f3968b == null) {
                this.f3968b = new l.b();
            }
            this.f3968b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f3967a = account;
            return this;
        }

        public final a e(String str) {
            this.f3970d = str;
            return this;
        }
    }

    public e(Account account, Set set, Map map, int i10, View view, String str, String str2, w2.a aVar, boolean z10) {
        this.f3958a = account;
        Set emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f3959b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f3961d = map;
        this.f3962e = view;
        this.f3963f = str;
        this.f3964g = str2;
        this.f3965h = aVar == null ? w2.a.f14891k : aVar;
        HashSet hashSet = new HashSet(emptySet);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(((a0) it.next()).f3914a);
        }
        this.f3960c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f3958a;
    }

    public Account b() {
        Account account = this.f3958a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> c() {
        return this.f3960c;
    }

    public String d() {
        return this.f3963f;
    }

    public Set<Scope> e() {
        return this.f3959b;
    }

    public final w2.a f() {
        return this.f3965h;
    }

    public final Integer g() {
        return this.f3966i;
    }

    public final String h() {
        return this.f3964g;
    }

    public final Map i() {
        return this.f3961d;
    }

    public final void j(Integer num) {
        this.f3966i = num;
    }
}
