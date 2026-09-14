package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.c0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class g implements u.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    private final Context f924a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f925b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f926c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f927d;

    /* renamed from: e, reason: collision with root package name */
    private a f928e;

    /* renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f936m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f937n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f938o;

    /* renamed from: p, reason: collision with root package name */
    View f939p;

    /* renamed from: x, reason: collision with root package name */
    private i f947x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f949z;

    /* renamed from: l, reason: collision with root package name */
    private int f935l = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f940q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f941r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f942s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f943t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f944u = false;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<i> f945v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<m>> f946w = new CopyOnWriteArrayList<>();

    /* renamed from: y, reason: collision with root package name */
    private boolean f948y = false;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<i> f929f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<i> f930g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f931h = true;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<i> f932i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<i> f933j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private boolean f934k = true;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(g gVar, MenuItem menuItem);

        void b(g gVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(i iVar);
    }

    public g(Context context) {
        this.f924a = context;
        this.f925b = context.getResources();
        b0(true);
    }

    private static int B(int i10) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = A;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i10, boolean z10) {
        if (i10 < 0 || i10 >= this.f929f.size()) {
            return;
        }
        this.f929f.remove(i10);
        if (z10) {
            K(true);
        }
    }

    private void W(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources C = C();
        if (view != null) {
            this.f939p = view;
            this.f937n = null;
            this.f938o = null;
        } else {
            if (i10 > 0) {
                this.f937n = C.getText(i10);
            } else if (charSequence != null) {
                this.f937n = charSequence;
            }
            if (i11 > 0) {
                this.f938o = androidx.core.content.a.f(u(), i11);
            } else if (drawable != null) {
                this.f938o = drawable;
            }
            this.f939p = null;
        }
        K(false);
    }

    private void b0(boolean z10) {
        this.f927d = z10 && this.f925b.getConfiguration().keyboard != 1 && c0.e(ViewConfiguration.get(this.f924a), this.f924a);
    }

    private i g(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new i(this, i10, i11, i12, i13, charSequence, i14);
    }

    private void i(boolean z10) {
        if (this.f946w.isEmpty()) {
            return;
        }
        d0();
        Iterator<WeakReference<m>> it = this.f946w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.f946w.remove(next);
            } else {
                mVar.f(z10);
            }
        }
        c0();
    }

    private boolean j(r rVar, m mVar) {
        if (this.f946w.isEmpty()) {
            return false;
        }
        boolean e10 = mVar != null ? mVar.e(rVar) : false;
        Iterator<WeakReference<m>> it = this.f946w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null) {
                this.f946w.remove(next);
            } else if (!e10) {
                e10 = mVar2.e(rVar);
            }
        }
        return e10;
    }

    private static int n(ArrayList<i> arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f943t;
    }

    Resources C() {
        return this.f925b;
    }

    public g D() {
        return this;
    }

    public ArrayList<i> E() {
        if (!this.f931h) {
            return this.f930g;
        }
        this.f930g.clear();
        int size = this.f929f.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = this.f929f.get(i10);
            if (iVar.isVisible()) {
                this.f930g.add(iVar);
            }
        }
        this.f931h = false;
        this.f934k = true;
        return this.f930g;
    }

    public boolean F() {
        return this.f948y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        return this.f926c;
    }

    public boolean H() {
        return this.f927d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(i iVar) {
        this.f934k = true;
        K(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(i iVar) {
        this.f931h = true;
        K(true);
    }

    public void K(boolean z10) {
        if (this.f940q) {
            this.f941r = true;
            if (z10) {
                this.f942s = true;
                return;
            }
            return;
        }
        if (z10) {
            this.f931h = true;
            this.f934k = true;
        }
        i(z10);
    }

    public boolean L(MenuItem menuItem, int i10) {
        return M(menuItem, null, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r1 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        e(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if ((r9 & 1) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (r1 == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean M(android.view.MenuItem r7, androidx.appcompat.view.menu.m r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.i r7 = (androidx.appcompat.view.menu.i) r7
            r0 = 0
            if (r7 == 0) goto L6c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Lc
            goto L6c
        Lc:
            boolean r1 = r7.k()
            androidx.core.view.b r2 = r7.b()
            r3 = 1
            if (r2 == 0) goto L1f
            boolean r4 = r2.a()
            if (r4 == 0) goto L1f
            r4 = 1
            goto L20
        L1f:
            r4 = 0
        L20:
            boolean r5 = r7.j()
            if (r5 == 0) goto L31
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L6b
        L2d:
            r6.e(r3)
            goto L6b
        L31:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L3f
            if (r4 == 0) goto L3a
            goto L3f
        L3a:
            r7 = r9 & 1
            if (r7 != 0) goto L6b
            goto L2d
        L3f:
            r9 = r9 & 4
            if (r9 != 0) goto L46
            r6.e(r0)
        L46:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L58
            androidx.appcompat.view.menu.r r9 = new androidx.appcompat.view.menu.r
            android.content.Context r0 = r6.u()
            r9.<init>(r0, r6, r7)
            r7.x(r9)
        L58:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.r r7 = (androidx.appcompat.view.menu.r) r7
            if (r4 == 0) goto L63
            r2.f(r7)
        L63:
            boolean r7 = r6.j(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L6b
            goto L2d
        L6b:
            return r1
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.g.M(android.view.MenuItem, androidx.appcompat.view.menu.m, int):boolean");
    }

    public void O(m mVar) {
        Iterator<WeakReference<m>> it = this.f946w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.f946w.remove(next);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).P(bundle);
            }
        }
        int i11 = bundle.getInt("android:menu:expandedactionview");
        if (i11 <= 0 || (findItem = findItem(i11)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
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
                ((r) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f928e = aVar;
    }

    public g S(int i10) {
        this.f935l = i10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f929f.size();
        d0();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = this.f929f.get(i10);
            if (iVar.getGroupId() == groupId && iVar.m() && iVar.isCheckable()) {
                iVar.s(iVar == menuItem);
            }
        }
        c0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g U(int i10) {
        W(0, null, i10, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g X(int i10) {
        W(i10, null, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    protected MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int B = B(i12);
        i g10 = g(i10, i11, i12, B, charSequence, this.f935l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f936m;
        if (contextMenuInfo != null) {
            g10.v(contextMenuInfo);
        }
        ArrayList<i> arrayList = this.f929f;
        arrayList.add(n(arrayList, B), g10);
        K(true);
        return g10;
    }

    public void a0(boolean z10) {
        this.f949z = z10;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return a(0, 0, 0, this.f925b.getString(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f925b.getString(i13));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f924a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i15 = 0; i15 < size; i15++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i15);
            int i16 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i16 < 0 ? intent : intentArr[i16]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f925b.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f925b.getString(i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        i iVar = (i) a(i10, i11, i12, charSequence);
        r rVar = new r(this.f924a, this, iVar);
        iVar.x(rVar);
        return rVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(m mVar) {
        c(mVar, this.f924a);
    }

    public void c(m mVar, Context context) {
        this.f946w.add(new WeakReference<>(mVar));
        mVar.d(context, this);
        this.f934k = true;
    }

    public void c0() {
        this.f940q = false;
        if (this.f941r) {
            this.f941r = false;
            K(this.f942s);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        i iVar = this.f947x;
        if (iVar != null) {
            f(iVar);
        }
        this.f929f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f938o = null;
        this.f937n = null;
        this.f939p = null;
        K(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f928e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (this.f940q) {
            return;
        }
        this.f940q = true;
        this.f941r = false;
        this.f942s = false;
    }

    public final void e(boolean z10) {
        if (this.f944u) {
            return;
        }
        this.f944u = true;
        Iterator<WeakReference<m>> it = this.f946w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.f946w.remove(next);
            } else {
                mVar.b(this, z10);
            }
        }
        this.f944u = false;
    }

    public boolean f(i iVar) {
        boolean z10 = false;
        if (!this.f946w.isEmpty() && this.f947x == iVar) {
            d0();
            Iterator<WeakReference<m>> it = this.f946w.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.f946w.remove(next);
                } else {
                    z10 = mVar.i(this, iVar);
                    if (z10) {
                        break;
                    }
                }
            }
            c0();
            if (z10) {
                this.f947x = null;
            }
        }
        return z10;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        MenuItem findItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.f929f.get(i11);
            if (iVar.getItemId() == i10) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.getSubMenu().findItem(i10)) != null) {
                return findItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return this.f929f.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(g gVar, MenuItem menuItem) {
        a aVar = this.f928e;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f949z) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f929f.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return p(i10, keyEvent) != null;
    }

    public boolean k(i iVar) {
        boolean z10 = false;
        if (this.f946w.isEmpty()) {
            return false;
        }
        d0();
        Iterator<WeakReference<m>> it = this.f946w.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.f946w.remove(next);
            } else {
                z10 = mVar.j(this, iVar);
                if (z10) {
                    break;
                }
            }
        }
        c0();
        if (z10) {
            this.f947x = iVar;
        }
        return z10;
    }

    public int l(int i10) {
        return m(i10, 0);
    }

    public int m(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.f929f.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public int o(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f929f.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    i p(int i10, KeyEvent keyEvent) {
        ArrayList<i> arrayList = this.f945v;
        arrayList.clear();
        q(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean G = G();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = arrayList.get(i11);
            char alphabeticShortcut = G ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (G && alphabeticShortcut == '\b' && i10 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return L(findItem(i10), i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        i p10 = p(i10, keyEvent);
        boolean L = p10 != null ? L(p10, i11) : false;
        if ((i11 & 2) != 0) {
            e(true);
        }
        return L;
    }

    void q(List<i> list, int i10, KeyEvent keyEvent) {
        boolean G = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.f929f.size();
            for (int i11 = 0; i11 < size; i11++) {
                i iVar = this.f929f.get(i11);
                if (iVar.hasSubMenu()) {
                    ((g) iVar.getSubMenu()).q(list, i10, keyEvent);
                }
                char alphabeticShortcut = G ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
                if (((modifiers & 69647) == ((G ? iVar.getAlphabeticModifiers() : iVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (G && alphabeticShortcut == '\b' && i10 == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<i> E = E();
        if (this.f934k) {
            Iterator<WeakReference<m>> it = this.f946w.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.f946w.remove(next);
                } else {
                    z10 |= mVar.g();
                }
            }
            if (z10) {
                this.f932i.clear();
                this.f933j.clear();
                int size = E.size();
                for (int i10 = 0; i10 < size; i10++) {
                    i iVar = E.get(i10);
                    (iVar.l() ? this.f932i : this.f933j).add(iVar);
                }
            } else {
                this.f932i.clear();
                this.f933j.clear();
                this.f933j.addAll(E());
            }
            this.f934k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        int l10 = l(i10);
        if (l10 >= 0) {
            int size = this.f929f.size() - l10;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || this.f929f.get(l10).getGroupId() != i10) {
                    break;
                }
                N(l10, false);
                i11 = i12;
            }
            K(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        N(o(i10), true);
    }

    public ArrayList<i> s() {
        r();
        return this.f932i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f929f.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.f929f.get(i11);
            if (iVar.getGroupId() == i10) {
                iVar.t(z11);
                iVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f948y = z10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f929f.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.f929f.get(i11);
            if (iVar.getGroupId() == i10) {
                iVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f929f.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.f929f.get(i11);
            if (iVar.getGroupId() == i10 && iVar.y(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f926c = z10;
        K(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f929f.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f924a;
    }

    public i v() {
        return this.f947x;
    }

    public Drawable w() {
        return this.f938o;
    }

    public CharSequence x() {
        return this.f937n;
    }

    public View y() {
        return this.f939p;
    }

    public ArrayList<i> z() {
        r();
        return this.f933j;
    }
}
