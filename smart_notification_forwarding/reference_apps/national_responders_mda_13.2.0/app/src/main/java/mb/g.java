package mb;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
public final class g {
    /* JADX INFO: Access modifiers changed from: private */
    public static final d c(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new e(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d9.c d(MatchResult matchResult, int i10) {
        d9.c f10;
        f10 = d9.f.f(matchResult.start(i10), matchResult.end(i10));
        return f10;
    }
}
