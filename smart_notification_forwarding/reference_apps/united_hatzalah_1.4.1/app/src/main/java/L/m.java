package l;

import J.T;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class m implements Menu {

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f5399z = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f5400a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f5401b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5402c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5403d;

    /* renamed from: e, reason: collision with root package name */
    public k f5404e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f5405f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f5406g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5407h;
    public final ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f5408j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5409k;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f5411m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f5412n;

    /* renamed from: o, reason: collision with root package name */
    public View f5413o;

    /* renamed from: w, reason: collision with root package name */
    public o f5420w;
    public boolean y;

    /* renamed from: l, reason: collision with root package name */
    public int f5410l = 0;
    public boolean p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5414q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5415r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5416s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5417t = false;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f5418u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArrayList f5419v = new CopyOnWriteArrayList();

    /* renamed from: x, reason: collision with root package name */
    public boolean f5421x = false;

    public m(Context context) {
        boolean z3;
        boolean z4 = false;
        this.f5400a = context;
        Resources resources = context.getResources();
        this.f5401b = resources;
        this.f5405f = new ArrayList();
        this.f5406g = new ArrayList();
        this.f5407h = true;
        this.i = new ArrayList();
        this.f5408j = new ArrayList();
        this.f5409k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = T.f959a;
            if (Build.VERSION.SDK_INT >= 28) {
                z3 = B.b.p(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                if (identifier != 0 && resources2.getBoolean(identifier)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                z4 = true;
            }
        }
        this.f5403d = z4;
    }

    public final o a(int i, int i3, int i4, CharSequence charSequence) {
        int i5;
        int i6 = ((-65536) & i4) >> 16;
        if (i6 >= 0 && i6 < 6) {
            int i7 = (f5399z[i6] << 16) | (65535 & i4);
            o oVar = new o(this, i, i3, i4, i7, charSequence, this.f5410l);
            ArrayList arrayList = this.f5405f;
            int size = arrayList.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (((o) arrayList.get(size)).f5431d <= i7) {
                        i5 = size + 1;
                        break;
                    }
                    size--;
                } else {
                    i5 = 0;
                    break;
                }
            }
            arrayList.add(i5, oVar);
            p(true);
            return oVar;
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        Intent intent2;
        int i7;
        PackageManager packageManager = this.f5400a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i6 = queryIntentActivityOptions.size();
        } else {
            i6 = 0;
        }
        if ((i5 & 1) == 0) {
            removeGroup(i);
        }
        for (int i8 = 0; i8 < i6; i8++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i8);
            int i9 = resolveInfo.specificIndex;
            if (i9 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i9];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            o a2 = a(i, i3, i4, resolveInfo.loadLabel(packageManager));
            a2.setIcon(resolveInfo.loadIcon(packageManager));
            a2.f5434g = intent3;
            if (menuItemArr != null && (i7 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i7] = a2;
            }
        }
        return i6;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(z zVar, Context context) {
        this.f5419v.add(new WeakReference(zVar));
        zVar.h(context, this);
        this.f5409k = true;
    }

    public final void c(boolean z3) {
        if (this.f5417t) {
            return;
        }
        this.f5417t = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5419v;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar = (z) weakReference.get();
            if (zVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zVar.b(this, z3);
            }
        }
        this.f5417t = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        o oVar = this.f5420w;
        if (oVar != null) {
            d(oVar);
        }
        this.f5405f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f5412n = null;
        this.f5411m = null;
        this.f5413o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(o oVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5419v;
        boolean z3 = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f5420w == oVar) {
            w();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                z zVar = (z) weakReference.get();
                if (zVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z3 = zVar.j(oVar);
                    if (z3) {
                        break;
                    }
                }
            }
            v();
            if (z3) {
                this.f5420w = null;
            }
        }
        return z3;
    }

    public boolean e(m mVar, MenuItem menuItem) {
        k kVar = this.f5404e;
        if (kVar != null && kVar.i(mVar, menuItem)) {
            return true;
        }
        return false;
    }

    public boolean f(o oVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5419v;
        boolean z3 = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar = (z) weakReference.get();
            if (zVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z3 = zVar.c(oVar);
                if (z3) {
                    break;
                }
            }
        }
        v();
        if (z3) {
            this.f5420w = oVar;
        }
        return z3;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem findItem;
        ArrayList arrayList = this.f5405f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = (o) arrayList.get(i3);
            if (oVar.f5428a == i) {
                return oVar;
            }
            if (oVar.hasSubMenu() && (findItem = oVar.f5441o.findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final o g(int i, KeyEvent keyEvent) {
        char c4;
        ArrayList arrayList = this.f5418u;
        arrayList.clear();
        h(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (o) arrayList.get(0);
        }
        boolean n4 = n();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = (o) arrayList.get(i3);
            if (n4) {
                c4 = oVar.f5436j;
            } else {
                c4 = oVar.f5435h;
            }
            char[] cArr = keyData.meta;
            if ((c4 == cArr[0] && (metaState & 2) == 0) || ((c4 == cArr[2] && (metaState & 2) != 0) || (n4 && c4 == '\b' && i == 67))) {
                return oVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.f5405f.get(i);
    }

    public final void h(List list, int i, KeyEvent keyEvent) {
        char c4;
        int i3;
        boolean n4 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList = this.f5405f;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                o oVar = (o) arrayList.get(i4);
                if (oVar.hasSubMenu()) {
                    oVar.f5441o.h(list, i, keyEvent);
                }
                if (n4) {
                    c4 = oVar.f5436j;
                } else {
                    c4 = oVar.f5435h;
                }
                if (n4) {
                    i3 = oVar.f5437k;
                } else {
                    i3 = oVar.i;
                }
                if ((modifiers & 69647) == (i3 & 69647) && c4 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c4 == cArr[0] || c4 == cArr[2] || (n4 && c4 == '\b' && i == 67)) && oVar.isEnabled()) {
                        list.add(oVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (!this.y) {
            ArrayList arrayList = this.f5405f;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((o) arrayList.get(i)).isVisible()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final void i() {
        ArrayList l3 = l();
        if (!this.f5409k) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5419v;
        Iterator it = copyOnWriteArrayList.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar = (z) weakReference.get();
            if (zVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z3 |= zVar.d();
            }
        }
        ArrayList arrayList = this.i;
        ArrayList arrayList2 = this.f5408j;
        if (z3) {
            arrayList.clear();
            arrayList2.clear();
            int size = l3.size();
            for (int i = 0; i < size; i++) {
                o oVar = (o) l3.get(i);
                if ((oVar.f5449x & 32) == 32) {
                    arrayList.add(oVar);
                } else {
                    arrayList2.add(oVar);
                }
            }
        } else {
            arrayList.clear();
            arrayList2.clear();
            arrayList2.addAll(l());
        }
        this.f5409k = false;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        if (g(i, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList l() {
        boolean z3 = this.f5407h;
        ArrayList arrayList = this.f5406g;
        if (!z3) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f5405f;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            o oVar = (o) arrayList2.get(i);
            if (oVar.isVisible()) {
                arrayList.add(oVar);
            }
        }
        this.f5407h = false;
        this.f5409k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f5421x;
    }

    public boolean n() {
        return this.f5402c;
    }

    public boolean o() {
        return this.f5403d;
    }

    public final void p(boolean z3) {
        if (!this.p) {
            if (z3) {
                this.f5407h = true;
                this.f5409k = true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = this.f5419v;
            if (!copyOnWriteArrayList.isEmpty()) {
                w();
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    z zVar = (z) weakReference.get();
                    if (zVar == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        zVar.e();
                    }
                }
                v();
                return;
            }
            return;
        }
        this.f5414q = true;
        if (z3) {
            this.f5415r = true;
        }
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i3) {
        return q(findItem(i), null, i3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i3) {
        boolean z3;
        o g3 = g(i, keyEvent);
        if (g3 != null) {
            z3 = q(g3, null, i3);
        } else {
            z3 = false;
        }
        if ((i3 & 2) != 0) {
            c(true);
        }
        return z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, l.z r8, int r9) {
        /*
            r6 = this;
            l.o r7 = (l.o) r7
            r0 = 0
            if (r7 == 0) goto Ld2
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Ld2
        Ld:
            l.m r1 = r7.f5440n
            android.view.MenuItem$OnMenuItemClickListener r2 = r7.p
            r3 = 1
            if (r2 == 0) goto L1c
            boolean r2 = r2.onMenuItemClick(r7)
            if (r2 == 0) goto L1c
        L1a:
            r1 = r3
            goto L43
        L1c:
            boolean r2 = r1.e(r1, r7)
            if (r2 == 0) goto L23
            goto L1a
        L23:
            android.content.Intent r2 = r7.f5434g
            if (r2 == 0) goto L35
            android.content.Context r1 = r1.f5400a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L1a
        L2d:
            r1 = move-exception
            java.lang.String r2 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r2, r4, r1)
        L35:
            l.p r1 = r7.f5425A
            if (r1 == 0) goto L42
            android.view.ActionProvider r1 = r1.f5451a
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L42
            goto L1a
        L42:
            r1 = r0
        L43:
            l.p r2 = r7.f5425A
            if (r2 == 0) goto L51
            android.view.ActionProvider r4 = r2.f5451a
            boolean r4 = r4.hasSubMenu()
            if (r4 == 0) goto L51
            r4 = r3
            goto L52
        L51:
            r4 = r0
        L52:
            boolean r5 = r7.e()
            if (r5 == 0) goto L64
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Ld1
            r6.c(r3)
            goto Ld1
        L64:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L75
            if (r4 == 0) goto L6d
            goto L75
        L6d:
            r7 = r9 & 1
            if (r7 != 0) goto Ld1
            r6.c(r3)
            goto Ld1
        L75:
            r9 = r9 & 4
            if (r9 != 0) goto L7c
            r6.c(r0)
        L7c:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L90
            l.F r9 = new l.F
            android.content.Context r5 = r6.f5400a
            r9.<init>(r5, r6, r7)
            r7.f5441o = r9
            java.lang.CharSequence r5 = r7.f5432e
            r9.setHeaderTitle(r5)
        L90:
            l.F r7 = r7.f5441o
            if (r4 == 0) goto L99
            android.view.ActionProvider r9 = r2.f5451a
            r9.onPrepareSubMenu(r7)
        L99:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.f5419v
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto La2
            goto Lcb
        La2:
            if (r8 == 0) goto La8
            boolean r0 = r8.i(r7)
        La8:
            java.util.Iterator r8 = r9.iterator()
        Lac:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lcb
            java.lang.Object r2 = r8.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r4 = r2.get()
            l.z r4 = (l.z) r4
            if (r4 != 0) goto Lc4
            r9.remove(r2)
            goto Lac
        Lc4:
            if (r0 != 0) goto Lac
            boolean r0 = r4.i(r7)
            goto Lac
        Lcb:
            r1 = r1 | r0
            if (r1 != 0) goto Ld1
            r6.c(r3)
        Ld1:
            return r1
        Ld2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.m.q(android.view.MenuItem, l.z, int):boolean");
    }

    public final void r(z zVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5419v;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar2 = (z) weakReference.get();
            if (zVar2 == null || zVar2 == zVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.f5405f;
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                if (((o) arrayList.get(i4)).f5429b == i) {
                    break;
                } else {
                    i4++;
                }
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 >= 0) {
            int size2 = arrayList.size() - i4;
            while (true) {
                int i5 = i3 + 1;
                if (i3 >= size2 || ((o) arrayList.get(i4)).f5429b != i) {
                    break;
                }
                if (i4 >= 0) {
                    ArrayList arrayList2 = this.f5405f;
                    if (i4 < arrayList2.size()) {
                        arrayList2.remove(i4);
                    }
                }
                i3 = i5;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.f5405f;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (((o) arrayList.get(i3)).f5428a == i) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            ArrayList arrayList2 = this.f5405f;
            if (i3 < arrayList2.size()) {
                arrayList2.remove(i3);
                p(true);
            }
        }
    }

    public final void s(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
            int size = this.f5405f.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (actionView != null && actionView.getId() != -1) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuC0502F) item.getSubMenu()).s(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z3, boolean z4) {
        int i3;
        ArrayList arrayList = this.f5405f;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            o oVar = (o) arrayList.get(i4);
            if (oVar.f5429b == i) {
                int i5 = oVar.f5449x & (-5);
                if (z4) {
                    i3 = 4;
                } else {
                    i3 = 0;
                }
                oVar.f5449x = i5 | i3;
                oVar.setCheckable(z3);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z3) {
        this.f5421x = z3;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z3) {
        ArrayList arrayList = this.f5405f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = (o) arrayList.get(i3);
            if (oVar.f5429b == i) {
                oVar.setEnabled(z3);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z3) {
        int i3;
        ArrayList arrayList = this.f5405f;
        int size = arrayList.size();
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            o oVar = (o) arrayList.get(i4);
            if (oVar.f5429b == i) {
                int i5 = oVar.f5449x;
                int i6 = i5 & (-9);
                if (z3) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                int i7 = i6 | i3;
                oVar.f5449x = i7;
                if (i5 != i7) {
                    z4 = true;
                }
            }
        }
        if (z4) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z3) {
        this.f5402c = z3;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f5405f.size();
    }

    public final void t(Bundle bundle) {
        int size = this.f5405f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuC0502F) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i, CharSequence charSequence, int i3, Drawable drawable, View view) {
        if (view != null) {
            this.f5413o = view;
            this.f5411m = null;
            this.f5412n = null;
        } else {
            if (i > 0) {
                this.f5411m = this.f5401b.getText(i);
            } else if (charSequence != null) {
                this.f5411m = charSequence;
            }
            if (i3 > 0) {
                this.f5412n = this.f5400a.getDrawable(i3);
            } else if (drawable != null) {
                this.f5412n = drawable;
            }
            this.f5413o = null;
        }
        p(false);
    }

    public final void v() {
        this.p = false;
        if (this.f5414q) {
            this.f5414q = false;
            p(this.f5415r);
        }
    }

    public final void w() {
        if (!this.p) {
            this.p = true;
            this.f5414q = false;
            this.f5415r = false;
        }
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return a(0, 0, 0, this.f5401b.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f5401b.getString(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i4, CharSequence charSequence) {
        return a(i, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i4, CharSequence charSequence) {
        o a2 = a(i, i3, i4, charSequence);
        SubMenuC0502F subMenuC0502F = new SubMenuC0502F(this.f5400a, this, a2);
        a2.f5441o = subMenuC0502F;
        subMenuC0502F.setHeaderTitle(a2.f5432e);
        return subMenuC0502F;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i4, int i5) {
        return a(i, i3, i4, this.f5401b.getString(i5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i4, int i5) {
        return addSubMenu(i, i3, i4, this.f5401b.getString(i5));
    }

    public m k() {
        return this;
    }
}
