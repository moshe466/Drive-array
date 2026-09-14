package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1776a;

    /* renamed from: b, reason: collision with root package name */
    String f1777b;

    /* renamed from: c, reason: collision with root package name */
    private EnumC0024b f1778c;

    /* renamed from: d, reason: collision with root package name */
    private int f1779d;

    /* renamed from: e, reason: collision with root package name */
    private float f1780e;

    /* renamed from: f, reason: collision with root package name */
    private String f1781f;

    /* renamed from: g, reason: collision with root package name */
    boolean f1782g;

    /* renamed from: h, reason: collision with root package name */
    private int f1783h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1784a;

        static {
            int[] iArr = new int[EnumC0024b.values().length];
            f1784a = iArr;
            try {
                iArr[EnumC0024b.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1784a[EnumC0024b.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1784a[EnumC0024b.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1784a[EnumC0024b.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1784a[EnumC0024b.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1784a[EnumC0024b.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1784a[EnumC0024b.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1784a[EnumC0024b.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0024b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public b(b bVar, Object obj) {
        this.f1776a = false;
        this.f1777b = bVar.f1777b;
        this.f1778c = bVar.f1778c;
        f(obj);
    }

    public b(String str, EnumC0024b enumC0024b, Object obj, boolean z10) {
        this.f1776a = false;
        this.f1777b = str;
        this.f1778c = enumC0024b;
        this.f1776a = z10;
        f(obj);
    }

    public static HashMap<String, b> a(HashMap<String, b> hashMap, View view) {
        HashMap<String, b> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            b bVar = hashMap.get(str);
            try {
                hashMap2.put(str, str.equals("BackgroundColor") ? new b(bVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())) : new b(bVar, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void d(Context context, XmlPullParser xmlPullParser, HashMap<String, b> hashMap) {
        EnumC0024b enumC0024b;
        int resourceId;
        Object string;
        float f10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j.f1954d4);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        EnumC0024b enumC0024b2 = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == j.f1962e4) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == j.f2042o4) {
                str = obtainStyledAttributes.getString(index);
                z10 = true;
            } else if (index == j.f1970f4) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                enumC0024b2 = EnumC0024b.BOOLEAN_TYPE;
            } else {
                if (index == j.f1986h4) {
                    enumC0024b = EnumC0024b.COLOR_TYPE;
                } else if (index == j.f1978g4) {
                    enumC0024b = EnumC0024b.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == j.f2018l4) {
                        enumC0024b = EnumC0024b.DIMENSION_TYPE;
                        f10 = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == j.f1994i4) {
                        enumC0024b = EnumC0024b.DIMENSION_TYPE;
                        f10 = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else if (index == j.f2002j4) {
                        enumC0024b = EnumC0024b.FLOAT_TYPE;
                        f10 = obtainStyledAttributes.getFloat(index, Float.NaN);
                    } else {
                        if (index == j.f2010k4) {
                            enumC0024b = EnumC0024b.INT_TYPE;
                            resourceId = obtainStyledAttributes.getInteger(index, -1);
                        } else if (index == j.f2034n4) {
                            enumC0024b = EnumC0024b.STRING_TYPE;
                            string = obtainStyledAttributes.getString(index);
                            Object obj2 = string;
                            enumC0024b2 = enumC0024b;
                            obj = obj2;
                        } else if (index == j.f2026m4) {
                            enumC0024b = EnumC0024b.REFERENCE_TYPE;
                            resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                        }
                        string = Integer.valueOf(resourceId);
                        Object obj22 = string;
                        enumC0024b2 = enumC0024b;
                        obj = obj22;
                    }
                    string = Float.valueOf(f10);
                    Object obj222 = string;
                    enumC0024b2 = enumC0024b;
                    obj = obj222;
                }
                resourceId = obtainStyledAttributes.getColor(index, 0);
                string = Integer.valueOf(resourceId);
                Object obj2222 = string;
                enumC0024b2 = enumC0024b;
                obj = obj2222;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new b(str, enumC0024b2, obj, z10));
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0045. Please report as an issue. */
    public static void e(View view, HashMap<String, b> hashMap) {
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            b bVar = hashMap.get(str);
            String str2 = bVar.f1776a ? str : "set" + str;
            try {
                switch (a.f1784a[bVar.f1778c.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(bVar.f1779d));
                        break;
                    case 2:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(bVar.f1782g));
                        break;
                    case 3:
                        cls.getMethod(str2, CharSequence.class).invoke(view, bVar.f1781f);
                        break;
                    case 4:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(bVar.f1783h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(bVar.f1783h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(bVar.f1779d));
                        break;
                    case 7:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(bVar.f1780e));
                        break;
                    case 8:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(bVar.f1780e));
                        break;
                }
            } catch (IllegalAccessException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" Custom Attribute \"");
                sb2.append(str);
                sb2.append("\" not found on ");
                sb2.append(cls.getName());
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.getMessage();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" Custom Attribute \"");
                sb3.append(str);
                sb3.append("\" not found on ");
                sb3.append(cls.getName());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(cls.getName());
                sb4.append(" must have a method ");
                sb4.append(str2);
            } catch (InvocationTargetException e12) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" Custom Attribute \"");
                sb5.append(str);
                sb5.append("\" not found on ");
                sb5.append(cls.getName());
                e12.printStackTrace();
            }
        }
    }

    public String b() {
        return this.f1777b;
    }

    public EnumC0024b c() {
        return this.f1778c;
    }

    public void f(Object obj) {
        switch (a.f1784a[this.f1778c.ordinal()]) {
            case 1:
            case 6:
                this.f1779d = ((Integer) obj).intValue();
                return;
            case 2:
                this.f1782g = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.f1781f = (String) obj;
                return;
            case 4:
            case 5:
                this.f1783h = ((Integer) obj).intValue();
                return;
            case 7:
            case 8:
                this.f1780e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }
}
