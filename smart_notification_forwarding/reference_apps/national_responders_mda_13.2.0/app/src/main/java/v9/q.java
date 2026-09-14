package v9;

import java.util.Arrays;
import java.util.Set;

/* loaded from: classes.dex */
public interface q {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final la.a f14798a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f14799b;

        /* renamed from: c, reason: collision with root package name */
        private final ca.g f14800c;

        public a(la.a aVar, byte[] bArr, ca.g gVar) {
            y8.k.e(aVar, "classId");
            this.f14798a = aVar;
            this.f14799b = bArr;
            this.f14800c = gVar;
        }

        public /* synthetic */ a(la.a aVar, byte[] bArr, ca.g gVar, int i10, y8.g gVar2) {
            this(aVar, (i10 & 2) != 0 ? null : bArr, (i10 & 4) != 0 ? null : gVar);
        }

        public final la.a a() {
            return this.f14798a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return y8.k.a(this.f14798a, aVar.f14798a) && y8.k.a(this.f14799b, aVar.f14799b) && y8.k.a(this.f14800c, aVar.f14800c);
        }

        public int hashCode() {
            int hashCode = this.f14798a.hashCode() * 31;
            byte[] bArr = this.f14799b;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            ca.g gVar = this.f14800c;
            return hashCode2 + (gVar != null ? gVar.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.f14798a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f14799b) + ", outerClass=" + this.f14800c + ')';
        }
    }

    ca.u a(la.b bVar);

    ca.g b(a aVar);

    Set<String> c(la.b bVar);
}
