package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class n extends AbstractList<String> implements RandomAccess, o {

    /* renamed from: g, reason: collision with root package name */
    public static final o f11447g = new n().m();

    /* renamed from: f, reason: collision with root package name */
    private final List<Object> f11448f;

    public n() {
        this.f11448f = new ArrayList();
    }

    public n(o oVar) {
        this.f11448f = new ArrayList(oVar.size());
        addAll(oVar);
    }

    private static d f(Object obj) {
        return obj instanceof d ? (d) obj : obj instanceof String ? d.s((String) obj) : d.j((byte[]) obj);
    }

    private static String g(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof d ? ((d) obj).G() : j.b((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends String> collection) {
        if (collection instanceof o) {
            collection = ((o) collection).p();
        }
        boolean addAll = this.f11448f.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i10, String str) {
        this.f11448f.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f11448f.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        Object obj = this.f11448f.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String G = dVar.G();
            if (dVar.x()) {
                this.f11448f.set(i10, G);
            }
            return G;
        }
        byte[] bArr = (byte[]) obj;
        String b10 = j.b(bArr);
        if (j.a(bArr)) {
            this.f11448f.set(i10, b10);
        }
        return b10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public d k(int i10) {
        Object obj = this.f11448f.get(i10);
        d f10 = f(obj);
        if (f10 != obj) {
            this.f11448f.set(i10, f10);
        }
        return f10;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String remove(int i10) {
        Object remove = this.f11448f.remove(i10);
        ((AbstractList) this).modCount++;
        return g(remove);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public o m() {
        return new x(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public List<?> p() {
        return Collections.unmodifiableList(this.f11448f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void q(d dVar) {
        this.f11448f.add(dVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public String set(int i10, String str) {
        return g(this.f11448f.set(i10, str));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11448f.size();
    }
}
