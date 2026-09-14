package O2;

import F0.AbstractC0008a;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class a implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final long f1535b;

    /* renamed from: c, reason: collision with root package name */
    public static final long f1536c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f1537d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f1538a;

    static {
        int i = b.f1539a;
        f1535b = Long.MAX_VALUE;
        f1536c = -9223372036854775805L;
    }

    public static final void a(StringBuilder sb, int i, int i3, int i4, String str) {
        CharSequence charSequence;
        sb.append(i);
        if (i3 != 0) {
            sb.append('.');
            String valueOf = String.valueOf(i3);
            j.e(valueOf, "<this>");
            if (i4 >= 0) {
                if (i4 <= valueOf.length()) {
                    charSequence = valueOf.subSequence(0, valueOf.length());
                } else {
                    StringBuilder sb2 = new StringBuilder(i4);
                    int length = i4 - valueOf.length();
                    int i5 = 1;
                    if (1 <= length) {
                        while (true) {
                            sb2.append('0');
                            if (i5 == length) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                    sb2.append((CharSequence) valueOf);
                    charSequence = sb2;
                }
                String obj = charSequence.toString();
                int i6 = -1;
                int length2 = obj.length() - 1;
                if (length2 >= 0) {
                    while (true) {
                        int i7 = length2 - 1;
                        if (obj.charAt(length2) != '0') {
                            i6 = length2;
                            break;
                        } else if (i7 < 0) {
                            break;
                        } else {
                            length2 = i7;
                        }
                    }
                }
                int i8 = i6 + 1;
                if (i8 < 3) {
                    sb.append((CharSequence) obj, 0, i8);
                } else {
                    sb.append((CharSequence) obj, 0, ((i6 + 3) / 3) * 3);
                }
            } else {
                throw new IllegalArgumentException(AbstractC0008a.j(i4, "Desired length ", " is less than zero."));
            }
        }
        sb.append(str);
    }

    public static final boolean b(long j2) {
        if (j2 != f1535b && j2 != f1536c) {
            return false;
        }
        return true;
    }

    public static final long c(long j2, c unit) {
        c sourceUnit;
        j.e(unit, "unit");
        if (j2 == f1535b) {
            return Long.MAX_VALUE;
        }
        if (j2 == f1536c) {
            return Long.MIN_VALUE;
        }
        long j3 = j2 >> 1;
        if ((((int) j2) & 1) == 0) {
            sourceUnit = c.f1540b;
        } else {
            sourceUnit = c.f1541c;
        }
        j.e(sourceUnit, "sourceUnit");
        return unit.f1547a.convert(j3, sourceUnit.f1547a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j2 = ((a) obj).f1538a;
        long j3 = this.f1538a;
        long j4 = j3 ^ j2;
        if (j4 >= 0 && (((int) j4) & 1) != 0) {
            int i = (((int) j3) & 1) - (((int) j2) & 1);
            if (j3 < 0) {
                return -i;
            }
            return i;
        }
        if (j3 < j2) {
            return -1;
        }
        if (j3 != j2) {
            return 1;
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            if (this.f1538a != ((a) obj).f1538a) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f1538a);
    }

    public final String toString() {
        boolean z3;
        int c4;
        long j2;
        int c5;
        int c6;
        int i;
        long j3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j4 = this.f1538a;
        if (j4 == 0) {
            return "0s";
        }
        if (j4 == f1535b) {
            return "Infinity";
        }
        if (j4 == f1536c) {
            return "-Infinity";
        }
        if (j4 < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        StringBuilder sb = new StringBuilder();
        if (z3) {
            sb.append('-');
        }
        if (j4 < 0) {
            j4 = (((int) j4) & 1) + ((-(j4 >> 1)) << 1);
            int i9 = b.f1539a;
        }
        long c7 = c(j4, c.f1545j);
        if (b(j4)) {
            c4 = 0;
        } else {
            c4 = (int) (c(j4, c.f1544f) % 24);
        }
        if (b(j4)) {
            j2 = 0;
            c5 = 0;
        } else {
            j2 = 0;
            c5 = (int) (c(j4, c.f1543e) % 60);
        }
        if (b(j4)) {
            c6 = 0;
        } else {
            c6 = (int) (c(j4, c.f1542d) % 60);
        }
        if (b(j4)) {
            i = 1;
            i3 = 0;
        } else {
            if ((((int) j4) & 1) == 1) {
                i = 1;
                j3 = ((j4 >> 1) % 1000) * 1000000;
            } else {
                i = 1;
                j3 = (j4 >> 1) % 1000000000;
            }
            i3 = (int) j3;
        }
        if (c7 != j2) {
            i4 = i;
        } else {
            i4 = 0;
        }
        if (c4 != 0) {
            i5 = i;
        } else {
            i5 = 0;
        }
        if (c5 != 0) {
            i6 = i;
        } else {
            i6 = 0;
        }
        if (c6 == 0 && i3 == 0) {
            i7 = 0;
        } else {
            i7 = i;
        }
        if (i4 != 0) {
            sb.append(c7);
            sb.append('d');
            i8 = i;
        } else {
            i8 = 0;
        }
        if (i5 != 0 || (i4 != 0 && (i6 != 0 || i7 != 0))) {
            int i10 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            sb.append(c4);
            sb.append('h');
            i8 = i10;
        }
        if (i6 != 0 || (i7 != 0 && (i5 != 0 || i4 != 0))) {
            int i11 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            sb.append(c5);
            sb.append('m');
            i8 = i11;
        }
        if (i7 != 0) {
            int i12 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            if (c6 == 0 && i4 == 0 && i5 == 0 && i6 == 0) {
                if (i3 >= 1000000) {
                    a(sb, i3 / 1000000, i3 % 1000000, 6, "ms");
                } else if (i3 >= 1000) {
                    a(sb, i3 / 1000, i3 % 1000, 3, "us");
                } else {
                    sb.append(i3);
                    sb.append("ns");
                }
            } else {
                a(sb, c6, i3, 9, "s");
            }
            i8 = i12;
        }
        if (z3 && i8 > i) {
            sb.insert(i, '(').append(')');
        }
        return sb.toString();
    }
}
