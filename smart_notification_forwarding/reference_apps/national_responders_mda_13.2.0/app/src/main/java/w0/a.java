package w0;

import com.andrognito.patternlockview.PatternLockView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {
    public static String a(PatternLockView patternLockView, List<PatternLockView.f> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < size; i10++) {
            PatternLockView.f fVar = list.get(i10);
            sb2.append((fVar.e() * patternLockView.getDotCount()) + fVar.d());
        }
        return sb2.toString();
    }

    public static List<PatternLockView.f> b(PatternLockView patternLockView, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < str.length(); i10++) {
            int numericValue = Character.getNumericValue(str.charAt(i10));
            arrayList.add(PatternLockView.f.f(numericValue / patternLockView.getDotCount(), numericValue % patternLockView.getDotCount()));
        }
        return arrayList;
    }
}
