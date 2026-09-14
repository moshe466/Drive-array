package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f1794a;

    /* renamed from: b, reason: collision with root package name */
    e f1795b;

    /* renamed from: c, reason: collision with root package name */
    int f1796c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f1797d = -1;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray<a> f1798e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private SparseArray<e> f1799f = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f1800a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<b> f1801b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        int f1802c;

        /* renamed from: d, reason: collision with root package name */
        e f1803d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f1802c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j.S5);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == j.T5) {
                    this.f1800a = obtainStyledAttributes.getResourceId(index, this.f1800a);
                } else if (index == j.U5) {
                    this.f1802c = obtainStyledAttributes.getResourceId(index, this.f1802c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1802c);
                    context.getResources().getResourceName(this.f1802c);
                    if ("layout".equals(resourceTypeName)) {
                        e eVar = new e();
                        this.f1803d = eVar;
                        eVar.e(context, this.f1802c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f1801b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f1801b.size(); i10++) {
                if (this.f1801b.get(i10).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        float f1804a;

        /* renamed from: b, reason: collision with root package name */
        float f1805b;

        /* renamed from: c, reason: collision with root package name */
        float f1806c;

        /* renamed from: d, reason: collision with root package name */
        float f1807d;

        /* renamed from: e, reason: collision with root package name */
        int f1808e;

        /* renamed from: f, reason: collision with root package name */
        e f1809f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f1804a = Float.NaN;
            this.f1805b = Float.NaN;
            this.f1806c = Float.NaN;
            this.f1807d = Float.NaN;
            this.f1808e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j.f1996i6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == j.f2004j6) {
                    this.f1808e = obtainStyledAttributes.getResourceId(index, this.f1808e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1808e);
                    context.getResources().getResourceName(this.f1808e);
                    if ("layout".equals(resourceTypeName)) {
                        e eVar = new e();
                        this.f1809f = eVar;
                        eVar.e(context, this.f1808e);
                    }
                } else if (index == j.f2012k6) {
                    this.f1807d = obtainStyledAttributes.getDimension(index, this.f1807d);
                } else if (index == j.f2020l6) {
                    this.f1805b = obtainStyledAttributes.getDimension(index, this.f1805b);
                } else if (index == j.f2028m6) {
                    this.f1806c = obtainStyledAttributes.getDimension(index, this.f1806c);
                } else if (index == j.f2036n6) {
                    this.f1804a = obtainStyledAttributes.getDimension(index, this.f1804a);
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f1804a) && f10 < this.f1804a) {
                return false;
            }
            if (!Float.isNaN(this.f1805b) && f11 < this.f1805b) {
                return false;
            }
            if (Float.isNaN(this.f1806c) || f10 <= this.f1806c) {
                return Float.isNaN(this.f1807d) || f11 <= this.f1807d;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, ConstraintLayout constraintLayout, int i10) {
        this.f1794a = constraintLayout;
        a(context, i10);
    }

    private void a(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        a aVar = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c10 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c10 = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c10 = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c10 = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c10 = 3;
                                break;
                            }
                            break;
                    }
                    c10 = 65535;
                    if (c10 == 2) {
                        aVar = new a(context, xml);
                        this.f1798e.put(aVar.f1800a, aVar);
                    } else if (c10 == 3) {
                        b bVar = new b(context, xml);
                        if (aVar != null) {
                            aVar.a(bVar);
                        }
                    } else if (c10 == 4) {
                        b(context, xml);
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        e eVar = new e();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            String attributeValue = xmlPullParser.getAttributeValue(i10);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1 && attributeValue.length() > 1) {
                    identifier = Integer.parseInt(attributeValue.substring(1));
                }
                eVar.k(context, xmlPullParser);
                this.f1799f.put(identifier, eVar);
                return;
            }
        }
    }

    public void c(g gVar) {
    }

    public void d(int i10, float f10, float f11) {
        int b10;
        int i11 = this.f1796c;
        if (i11 == i10) {
            a valueAt = i10 == -1 ? this.f1798e.valueAt(0) : this.f1798e.get(i11);
            int i12 = this.f1797d;
            if ((i12 == -1 || !valueAt.f1801b.get(i12).a(f10, f11)) && this.f1797d != (b10 = valueAt.b(f10, f11))) {
                e eVar = b10 == -1 ? this.f1795b : valueAt.f1801b.get(b10).f1809f;
                if (b10 != -1) {
                    int i13 = valueAt.f1801b.get(b10).f1808e;
                }
                if (eVar == null) {
                    return;
                }
                this.f1797d = b10;
                eVar.c(this.f1794a);
                return;
            }
            return;
        }
        this.f1796c = i10;
        a aVar = this.f1798e.get(i10);
        int b11 = aVar.b(f10, f11);
        e eVar2 = b11 == -1 ? aVar.f1803d : aVar.f1801b.get(b11).f1809f;
        if (b11 != -1) {
            int i14 = aVar.f1801b.get(b11).f1808e;
        }
        if (eVar2 != null) {
            this.f1797d = b11;
            eVar2.c(this.f1794a);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NO Constraint set found ! id=");
        sb2.append(i10);
        sb2.append(", dim =");
        sb2.append(f10);
        sb2.append(", ");
        sb2.append(f11);
    }
}
