package y8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Object> f15953a;

    public y(int i10) {
        this.f15953a = new ArrayList<>(i10);
    }

    public void a(Object obj) {
        this.f15953a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f15953a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f15953a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f15953a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f15953a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f15953a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f15953a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f15953a.toArray(objArr);
    }
}
