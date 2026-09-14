package s9;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class g {
    public static final c a(Annotation[] annotationArr, la.b bVar) {
        Annotation annotation;
        y8.k.e(annotationArr, "<this>");
        y8.k.e(bVar, "fqName");
        int length = annotationArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i10];
            if (y8.k.a(b.b(w8.a.b(w8.a.a(annotation))).b(), bVar)) {
                break;
            }
            i10++;
        }
        if (annotation == null) {
            return null;
        }
        return new c(annotation);
    }

    public static final List<c> b(Annotation[] annotationArr) {
        y8.k.e(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new c(annotation));
        }
        return arrayList;
    }
}
