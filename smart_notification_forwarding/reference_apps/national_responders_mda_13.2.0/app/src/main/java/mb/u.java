package mb;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends t {
    public static char k0(CharSequence charSequence) {
        int E;
        y8.k.e(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        E = s.E(charSequence);
        return charSequence.charAt(E);
    }

    public static Character l0(CharSequence charSequence) {
        y8.k.e(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }
}
