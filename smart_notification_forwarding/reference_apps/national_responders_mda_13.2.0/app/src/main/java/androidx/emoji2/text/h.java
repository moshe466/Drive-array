package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.e;
import androidx.emoji2.text.m;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final e.i f2783a;

    /* renamed from: b, reason: collision with root package name */
    private final m f2784b;

    /* renamed from: c, reason: collision with root package name */
    private e.d f2785c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f2786d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f2787e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        static int a(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    i10--;
                    if (i10 < 0) {
                        return z10 ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i11--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i11--;
                    } else {
                        if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        z10 = true;
                    }
                }
                return i10;
            }
        }

        static int b(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    if (i10 >= length) {
                        if (z10) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i11--;
                        i10++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i11--;
                        i10++;
                    } else {
                        if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i10++;
                        z10 = true;
                    }
                }
                return i10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f2788a = 1;

        /* renamed from: b, reason: collision with root package name */
        private final m.a f2789b;

        /* renamed from: c, reason: collision with root package name */
        private m.a f2790c;

        /* renamed from: d, reason: collision with root package name */
        private m.a f2791d;

        /* renamed from: e, reason: collision with root package name */
        private int f2792e;

        /* renamed from: f, reason: collision with root package name */
        private int f2793f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f2794g;

        /* renamed from: h, reason: collision with root package name */
        private final int[] f2795h;

        b(m.a aVar, boolean z10, int[] iArr) {
            this.f2789b = aVar;
            this.f2790c = aVar;
            this.f2794g = z10;
            this.f2795h = iArr;
        }

        private static boolean d(int i10) {
            return i10 == 65039;
        }

        private static boolean f(int i10) {
            return i10 == 65038;
        }

        private int g() {
            this.f2788a = 1;
            this.f2790c = this.f2789b;
            this.f2793f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f2790c.b().j() || d(this.f2792e)) {
                return true;
            }
            if (this.f2794g) {
                if (this.f2795h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f2795h, this.f2790c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i10) {
            m.a a10 = this.f2790c.a(i10);
            int i11 = 3;
            if (this.f2788a != 2) {
                if (a10 != null) {
                    this.f2788a = 2;
                    this.f2790c = a10;
                    this.f2793f = 1;
                    i11 = 2;
                }
                i11 = g();
            } else {
                if (a10 != null) {
                    this.f2790c = a10;
                    this.f2793f++;
                } else {
                    if (!f(i10)) {
                        if (!d(i10)) {
                            if (this.f2790c.b() != null && (this.f2793f != 1 || h())) {
                                this.f2791d = this.f2790c;
                                g();
                            }
                        }
                    }
                    i11 = g();
                }
                i11 = 2;
            }
            this.f2792e = i10;
            return i11;
        }

        g b() {
            return this.f2790c.b();
        }

        g c() {
            return this.f2791d.b();
        }

        boolean e() {
            return this.f2788a == 2 && this.f2790c.b() != null && (this.f2793f > 1 || h());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(m mVar, e.i iVar, e.d dVar, boolean z10, int[] iArr) {
        this.f2783a = iVar;
        this.f2784b = mVar;
        this.f2785c = dVar;
        this.f2786d = z10;
        this.f2787e = iArr;
    }

    private void a(Spannable spannable, g gVar, int i10, int i11) {
        spannable.setSpan(this.f2783a.a(gVar), i10, i11, 33);
    }

    private static boolean b(Editable editable, KeyEvent keyEvent, boolean z10) {
        i[] iVarArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (iVarArr = (i[]) editable.getSpans(selectionStart, selectionEnd, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = editable.getSpanStart(iVar);
                int spanEnd = editable.getSpanEnd(iVar);
                if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i10 >= 0 && i11 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z10) {
                max = a.a(editable, selectionStart, Math.max(i10, 0));
                min = a.b(editable, selectionEnd, Math.max(i11, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i10, 0);
                min = Math.min(selectionEnd + i11, editable.length());
            }
            i[] iVarArr = (i[]) editable.getSpans(max, min, i.class);
            if (iVarArr != null && iVarArr.length > 0) {
                for (i iVar : iVarArr) {
                    int spanStart = editable.getSpanStart(iVar);
                    int spanEnd = editable.getSpanEnd(iVar);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Editable editable, int i10, KeyEvent keyEvent) {
        if (!(i10 != 67 ? i10 != 112 ? false : b(editable, keyEvent, true) : b(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean e(CharSequence charSequence, int i10, int i11, g gVar) {
        if (gVar.d() == 0) {
            gVar.k(this.f2785c.a(charSequence, i10, i11, gVar.h()));
        }
        return gVar.d() == 2;
    }

    private static boolean f(int i10, int i11) {
        return i10 == -1 || i11 == -1 || i10 != i11;
    }

    private static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0125, code lost:
    
        ((androidx.emoji2.text.n) r10).d();
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[Catch: all -> 0x012c, TryCatch #0 {all -> 0x012c, blocks: (B:99:0x000d, B:102:0x0012, B:104:0x0016, B:106:0x0025, B:9:0x0036, B:11:0x0040, B:13:0x0043, B:15:0x0047, B:17:0x0053, B:19:0x0056, B:23:0x0063, B:29:0x0072, B:30:0x0080, B:34:0x009b, B:60:0x00ab, B:64:0x00b7, B:65:0x00c1, B:47:0x00cb, B:50:0x00d2, B:37:0x00d7, B:39:0x00e2, B:71:0x00e9, B:75:0x00f3, B:78:0x00ff, B:79:0x0105, B:81:0x010e, B:6:0x002b), top: B:98:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ff A[Catch: all -> 0x012c, TryCatch #0 {all -> 0x012c, blocks: (B:99:0x000d, B:102:0x0012, B:104:0x0016, B:106:0x0025, B:9:0x0036, B:11:0x0040, B:13:0x0043, B:15:0x0047, B:17:0x0053, B:19:0x0056, B:23:0x0063, B:29:0x0072, B:30:0x0080, B:34:0x009b, B:60:0x00ab, B:64:0x00b7, B:65:0x00c1, B:47:0x00cb, B:50:0x00d2, B:37:0x00d7, B:39:0x00e2, B:71:0x00e9, B:75:0x00f3, B:78:0x00ff, B:79:0x0105, B:81:0x010e, B:6:0x002b), top: B:98:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010e A[Catch: all -> 0x012c, TRY_LEAVE, TryCatch #0 {all -> 0x012c, blocks: (B:99:0x000d, B:102:0x0012, B:104:0x0016, B:106:0x0025, B:9:0x0036, B:11:0x0040, B:13:0x0043, B:15:0x0047, B:17:0x0053, B:19:0x0056, B:23:0x0063, B:29:0x0072, B:30:0x0080, B:34:0x009b, B:60:0x00ab, B:64:0x00b7, B:65:0x00c1, B:47:0x00cb, B:50:0x00d2, B:37:0x00d7, B:39:0x00e2, B:71:0x00e9, B:75:0x00f3, B:78:0x00ff, B:79:0x0105, B:81:0x010e, B:6:0x002b), top: B:98:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.CharSequence h(java.lang.CharSequence r10, int r11, int r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.h.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
