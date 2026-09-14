package w9;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import l8.w;
import n9.b;
import n9.d1;
import x8.l;
import xa.p;

/* loaded from: classes.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w9.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0325a extends na.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f15298a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f15299b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f15300c;

        /* renamed from: w9.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0326a implements l<n9.b, w> {
            C0326a() {
            }

            private static /* synthetic */ void a(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }

            @Override // x8.l
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public w h(n9.b bVar) {
                if (bVar == null) {
                    a(0);
                }
                C0325a.this.f15298a.a(bVar);
                return w.f11824a;
            }
        }

        C0325a(p pVar, Set set, boolean z10) {
            this.f15298a = pVar;
            this.f15299b = set;
            this.f15300c = z10;
        }

        private static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "fromSuper";
            } else if (i10 == 2) {
                objArr[0] = "fromCurrent";
            } else if (i10 == 3) {
                objArr[0] = "member";
            } else if (i10 != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "conflict";
            } else if (i10 == 3 || i10 == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // na.i
        public void a(n9.b bVar) {
            if (bVar == null) {
                f(0);
            }
            na.j.N(bVar, new C0326a());
            this.f15299b.add(bVar);
        }

        @Override // na.i
        public void d(n9.b bVar, Collection<? extends n9.b> collection) {
            if (bVar == null) {
                f(3);
            }
            if (collection == null) {
                f(4);
            }
            if (!this.f15300c || bVar.r() == b.a.FAKE_OVERRIDE) {
                super.d(bVar, collection);
            }
        }

        @Override // na.h
        public void e(n9.b bVar, n9.b bVar2) {
            if (bVar == null) {
                f(1);
            }
            if (bVar2 == null) {
                f(2);
            }
        }
    }

    private static /* synthetic */ void a(int i10) {
        String str = i10 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 18 ? 3 : 2];
        switch (i10) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i10 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i10) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        if (i10 == 18) {
            throw new IllegalStateException(format);
        }
    }

    public static d1 b(la.e eVar, n9.e eVar2) {
        if (eVar == null) {
            a(19);
        }
        if (eVar2 == null) {
            a(20);
        }
        Collection<n9.d> q10 = eVar2.q();
        if (q10.size() != 1) {
            return null;
        }
        for (d1 d1Var : q10.iterator().next().l()) {
            if (d1Var.c().equals(eVar)) {
                return d1Var;
            }
        }
        return null;
    }

    private static <D extends n9.b> Collection<D> c(la.e eVar, Collection<D> collection, Collection<D> collection2, n9.e eVar2, p pVar, na.j jVar, boolean z10) {
        if (eVar == null) {
            a(12);
        }
        if (collection == null) {
            a(13);
        }
        if (collection2 == null) {
            a(14);
        }
        if (eVar2 == null) {
            a(15);
        }
        if (pVar == null) {
            a(16);
        }
        if (jVar == null) {
            a(17);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        jVar.y(eVar, collection, collection2, eVar2, new C0325a(pVar, linkedHashSet, z10));
        return linkedHashSet;
    }

    public static <D extends n9.b> Collection<D> d(la.e eVar, Collection<D> collection, Collection<D> collection2, n9.e eVar2, p pVar, na.j jVar) {
        if (eVar == null) {
            a(0);
        }
        if (collection == null) {
            a(1);
        }
        if (collection2 == null) {
            a(2);
        }
        if (eVar2 == null) {
            a(3);
        }
        if (pVar == null) {
            a(4);
        }
        if (jVar == null) {
            a(5);
        }
        return c(eVar, collection, collection2, eVar2, pVar, jVar, false);
    }

    public static <D extends n9.b> Collection<D> e(la.e eVar, Collection<D> collection, Collection<D> collection2, n9.e eVar2, p pVar, na.j jVar) {
        if (eVar == null) {
            a(6);
        }
        if (collection == null) {
            a(7);
        }
        if (collection2 == null) {
            a(8);
        }
        if (eVar2 == null) {
            a(9);
        }
        if (pVar == null) {
            a(10);
        }
        if (jVar == null) {
            a(11);
        }
        return c(eVar, collection, collection2, eVar2, pVar, jVar, true);
    }
}
