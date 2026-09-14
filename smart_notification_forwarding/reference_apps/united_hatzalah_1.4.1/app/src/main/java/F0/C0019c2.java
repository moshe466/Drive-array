package F0;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.util.Comparator;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.language.translate.Translator;
import org.apache.tika.utils.CompareUtils;

/* renamed from: F0.c2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0019c2 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f478a;

    public /* synthetic */ C0019c2(int i) {
        this.f478a = i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:38:0x0091. Please report as an issue. */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int lambda$static$0;
        int oldestEventFileFirst;
        switch (this.f478a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                char c4 = 10305;
                int i = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    switch (c4) {
                        case 24498:
                            return 0;
                        case 30728:
                            if (i < i3) {
                                c4 = 18524;
                            } else {
                                c4 = 24498;
                            }
                        case '4':
                            return i4;
                        case 32099:
                            i3 = bArr.length;
                            i = 0;
                            c4 = 30728;
                        case 10305:
                            i4 = kotlin.jvm.internal.j.f(bArr.length, bArr2.length);
                            if (i4 != 0) {
                                c4 = '4';
                            } else {
                                c4 = 32099;
                            }
                        case 18524:
                            i5 = kotlin.jvm.internal.j.f(bArr[i], bArr2[i]);
                            if (i5 != 0) {
                                c4 = 10841;
                            } else {
                                c4 = 20955;
                            }
                        case 10841:
                            return i5;
                        case 20955:
                            i++;
                            c4 = 30728;
                        default:
                            c4 = 32099;
                    }
                }
            case 1:
                byte[] bArr3 = (byte[]) obj;
                byte[] bArr4 = (byte[]) obj2;
                if (bArr3.length != bArr4.length) {
                    return bArr3.length - bArr4.length;
                }
                for (int i6 = 0; i6 < bArr3.length; i6++) {
                    byte b4 = bArr3[i6];
                    byte b5 = bArr4[i6];
                    if (b4 != b5) {
                        return b4 - b5;
                    }
                }
                return 0;
            case 2:
                return Integer.compare(((N0.r) obj).f1483a.f1494a, ((N0.r) obj2).f1483a.f1494a);
            case 3:
                return ((S0.a) obj).f2073b.index() - ((S0.a) obj2).f2073b.index();
            case 4:
                return ((S0.d) obj).f2082c.index() - ((S0.d) obj2).f2082c.index();
            case 5:
                lambda$static$0 = CrashlyticsReportPersistence.lambda$static$0((File) obj, (File) obj2);
                return lambda$static$0;
            case 6:
                oldestEventFileFirst = CrashlyticsReportPersistence.oldestEventFileFirst((File) obj, (File) obj2);
                return oldestEventFileFirst;
            case 7:
                return CompareUtils.compareClassName((Translator) obj, (Translator) obj2);
            case 8:
                return CompareUtils.compareClassName((LanguageDetector) obj, (LanguageDetector) obj2);
            default:
                return CompareUtils.compareClassName(obj, obj2);
        }
    }
}
