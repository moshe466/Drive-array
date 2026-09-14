package k;

import a.AbstractC0228a;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import g.AbstractC0424a;
import java.io.IOException;
import l.p;
import m.AbstractC0565q0;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: k.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0466j extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f5147e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f5148f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f5149a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f5150b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f5151c;

    /* renamed from: d, reason: collision with root package name */
    public Object f5152d;

    static {
        Class[] clsArr = {Context.class};
        f5147e = clsArr;
        f5148f = clsArr;
    }

    public C0466j(Context context) {
        super(context);
        this.f5151c = context;
        Object[] objArr = {context};
        this.f5149a = objArr;
        this.f5150b = objArr;
    }

    public static Object a(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            return a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        int i;
        XmlPullParser xmlPullParser2;
        char charAt;
        char charAt2;
        ColorStateList colorStateList;
        int resourceId;
        C0465i c0465i = new C0465i(this, menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z3 = false;
        boolean z4 = false;
        String str = null;
        while (!z3) {
            if (eventType != 1) {
                if (eventType != i) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z4 && name2.equals(str)) {
                            xmlPullParser2 = xmlPullParser;
                            z4 = false;
                            str = null;
                            eventType = xmlPullParser2.next();
                            i = 2;
                            z3 = z3;
                            z4 = z4;
                        } else if (name2.equals("group")) {
                            c0465i.f5125b = 0;
                            c0465i.f5126c = 0;
                            c0465i.f5127d = 0;
                            c0465i.f5128e = 0;
                            c0465i.f5129f = true;
                            c0465i.f5130g = true;
                        } else if (name2.equals("item")) {
                            if (!c0465i.f5131h) {
                                p pVar = c0465i.f5146z;
                                if (pVar != null && pVar.f5451a.hasSubMenu()) {
                                    c0465i.f5131h = true;
                                    c0465i.b(c0465i.f5124a.addSubMenu(c0465i.f5125b, c0465i.i, c0465i.f5132j, c0465i.f5133k).getItem());
                                } else {
                                    c0465i.f5131h = true;
                                    c0465i.b(c0465i.f5124a.add(c0465i.f5125b, c0465i.i, c0465i.f5132j, c0465i.f5133k));
                                }
                            }
                        } else if (name2.equals("menu")) {
                            xmlPullParser2 = xmlPullParser;
                            z3 = true;
                        }
                    }
                    xmlPullParser2 = xmlPullParser;
                    z3 = z3;
                } else {
                    if (!z4) {
                        String name3 = xmlPullParser.getName();
                        if (name3.equals("group")) {
                            TypedArray obtainStyledAttributes = this.f5151c.obtainStyledAttributes(attributeSet, AbstractC0424a.p);
                            c0465i.f5125b = obtainStyledAttributes.getResourceId(1, 0);
                            c0465i.f5126c = obtainStyledAttributes.getInt(3, 0);
                            c0465i.f5127d = obtainStyledAttributes.getInt(4, 0);
                            c0465i.f5128e = obtainStyledAttributes.getInt(5, 0);
                            c0465i.f5129f = obtainStyledAttributes.getBoolean(i, true);
                            c0465i.f5130g = obtainStyledAttributes.getBoolean(0, true);
                            obtainStyledAttributes.recycle();
                        } else {
                            if (name3.equals("item")) {
                                int[] iArr = AbstractC0424a.f4641q;
                                Context context = this.f5151c;
                                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr);
                                c0465i.i = obtainStyledAttributes2.getResourceId(i, 0);
                                c0465i.f5132j = (obtainStyledAttributes2.getInt(6, c0465i.f5127d) & 65535) | (obtainStyledAttributes2.getInt(5, c0465i.f5126c) & (-65536));
                                c0465i.f5133k = obtainStyledAttributes2.getText(7);
                                c0465i.f5134l = obtainStyledAttributes2.getText(8);
                                c0465i.f5135m = obtainStyledAttributes2.getResourceId(0, 0);
                                String string = obtainStyledAttributes2.getString(9);
                                if (string == null) {
                                    charAt = 0;
                                } else {
                                    charAt = string.charAt(0);
                                }
                                c0465i.f5136n = charAt;
                                c0465i.f5137o = obtainStyledAttributes2.getInt(16, 4096);
                                String string2 = obtainStyledAttributes2.getString(10);
                                if (string2 == null) {
                                    charAt2 = 0;
                                } else {
                                    charAt2 = string2.charAt(0);
                                }
                                c0465i.p = charAt2;
                                c0465i.f5138q = obtainStyledAttributes2.getInt(20, 4096);
                                if (obtainStyledAttributes2.hasValue(11)) {
                                    c0465i.f5139r = obtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                                } else {
                                    c0465i.f5139r = c0465i.f5128e;
                                }
                                c0465i.f5140s = obtainStyledAttributes2.getBoolean(3, false);
                                c0465i.f5141t = obtainStyledAttributes2.getBoolean(4, c0465i.f5129f);
                                c0465i.f5142u = obtainStyledAttributes2.getBoolean(1, c0465i.f5130g);
                                c0465i.f5143v = obtainStyledAttributes2.getInt(21, -1);
                                c0465i.y = obtainStyledAttributes2.getString(12);
                                c0465i.f5144w = obtainStyledAttributes2.getResourceId(13, 0);
                                c0465i.f5145x = obtainStyledAttributes2.getString(15);
                                String string3 = obtainStyledAttributes2.getString(14);
                                if (string3 != null && c0465i.f5144w == 0 && c0465i.f5145x == null) {
                                    c0465i.f5146z = (p) c0465i.a(string3, f5148f, this.f5150b);
                                } else {
                                    c0465i.f5146z = null;
                                }
                                c0465i.f5119A = obtainStyledAttributes2.getText(17);
                                c0465i.f5120B = obtainStyledAttributes2.getText(22);
                                if (obtainStyledAttributes2.hasValue(19)) {
                                    c0465i.f5122D = AbstractC0565q0.c(obtainStyledAttributes2.getInt(19, -1), c0465i.f5122D);
                                } else {
                                    c0465i.f5122D = null;
                                }
                                if (obtainStyledAttributes2.hasValue(18)) {
                                    if (!obtainStyledAttributes2.hasValue(18) || (resourceId = obtainStyledAttributes2.getResourceId(18, 0)) == 0 || (colorStateList = AbstractC0228a.o(context, resourceId)) == null) {
                                        colorStateList = obtainStyledAttributes2.getColorStateList(18);
                                    }
                                    c0465i.f5121C = colorStateList;
                                } else {
                                    c0465i.f5121C = null;
                                }
                                obtainStyledAttributes2.recycle();
                                c0465i.f5131h = false;
                                xmlPullParser2 = xmlPullParser;
                            } else if (name3.equals("menu")) {
                                c0465i.f5131h = true;
                                SubMenu addSubMenu = c0465i.f5124a.addSubMenu(c0465i.f5125b, c0465i.i, c0465i.f5132j, c0465i.f5133k);
                                c0465i.b(addSubMenu.getItem());
                                xmlPullParser2 = xmlPullParser;
                                b(xmlPullParser2, attributeSet, addSubMenu);
                            } else {
                                xmlPullParser2 = xmlPullParser;
                                str = name3;
                                z4 = true;
                            }
                            eventType = xmlPullParser2.next();
                            i = 2;
                            z3 = z3;
                            z4 = z4;
                        }
                    }
                    xmlPullParser2 = xmlPullParser;
                    z3 = z3;
                }
                eventType = xmlPullParser2.next();
                i = 2;
                z3 = z3;
                z4 = z4;
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof l.m)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f5151c.getResources().getLayout(i);
                    b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (IOException e4) {
                    throw new InflateException("Error inflating menu XML", e4);
                }
            } catch (XmlPullParserException e5) {
                throw new InflateException("Error inflating menu XML", e5);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
