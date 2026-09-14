package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.k0;
import androidx.core.view.a0;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a, reason: collision with root package name */
    private final Context f525a;

    /* renamed from: b, reason: collision with root package name */
    final androidx.appcompat.app.h f526b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f527c;

    /* renamed from: d, reason: collision with root package name */
    private final int f528d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f529e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f530f;

    /* renamed from: g, reason: collision with root package name */
    ListView f531g;

    /* renamed from: h, reason: collision with root package name */
    private View f532h;

    /* renamed from: i, reason: collision with root package name */
    private int f533i;

    /* renamed from: j, reason: collision with root package name */
    private int f534j;

    /* renamed from: k, reason: collision with root package name */
    private int f535k;

    /* renamed from: l, reason: collision with root package name */
    private int f536l;

    /* renamed from: m, reason: collision with root package name */
    private int f537m;

    /* renamed from: o, reason: collision with root package name */
    Button f539o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f540p;

    /* renamed from: q, reason: collision with root package name */
    Message f541q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f542r;

    /* renamed from: s, reason: collision with root package name */
    Button f543s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f544t;

    /* renamed from: u, reason: collision with root package name */
    Message f545u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f546v;

    /* renamed from: w, reason: collision with root package name */
    Button f547w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f548x;

    /* renamed from: y, reason: collision with root package name */
    Message f549y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f550z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f538n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: f, reason: collision with root package name */
        private final int f551f;

        /* renamed from: g, reason: collision with root package name */
        private final int f552g;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.W1);
            this.f552g = obtainStyledAttributes.getDimensionPixelOffset(e.j.X1, -1);
            this.f551f = obtainStyledAttributes.getDimensionPixelOffset(e.j.Y1, -1);
        }

        public void a(boolean z10, boolean z11) {
            if (z11 && z10) {
                return;
            }
            setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.f551f, getPaddingRight(), z11 ? getPaddingBottom() : this.f552g);
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            AlertController alertController = AlertController.this;
            Message obtain = ((view != alertController.f539o || (message2 = alertController.f541q) == null) && (view != alertController.f543s || (message2 = alertController.f545u) == null)) ? (view != alertController.f547w || (message = alertController.f549y) == null) ? null : Message.obtain(message) : Message.obtain(message2);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f526b).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements NestedScrollView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f554a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f555b;

        b(AlertController alertController, View view, View view2) {
            this.f554a = view;
            this.f555b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.c
        public void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
            AlertController.f(nestedScrollView, this.f554a, this.f555b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f556f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f557g;

        c(View view, View view2) {
            this.f556f = view;
            this.f557g = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.A, this.f556f, this.f557g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f559a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f560b;

        d(AlertController alertController, View view, View view2) {
            this.f559a = view;
            this.f560b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            AlertController.f(absListView, this.f559a, this.f560b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f561f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f562g;

        e(View view, View view2) {
            this.f561f = view;
            this.f562g = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f531g, this.f561f, this.f562g);
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;

        /* renamed from: a, reason: collision with root package name */
        public final Context f564a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f565b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f567d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f569f;

        /* renamed from: g, reason: collision with root package name */
        public View f570g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f571h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f572i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f573j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f574k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f575l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f576m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f577n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f578o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f579p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f580q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f582s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f583t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f584u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f585v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f586w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f587x;

        /* renamed from: y, reason: collision with root package name */
        public int f588y;

        /* renamed from: z, reason: collision with root package name */
        public View f589z;

        /* renamed from: c, reason: collision with root package name */
        public int f566c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f568e = 0;
        public boolean E = false;
        public int I = -1;

        /* renamed from: r, reason: collision with root package name */
        public boolean f581r = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ RecycleListView f590f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f590f = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i10]) {
                    this.f590f.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b extends CursorAdapter {

            /* renamed from: f, reason: collision with root package name */
            private final int f592f;

            /* renamed from: g, reason: collision with root package name */
            private final int f593g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ RecycleListView f594h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ AlertController f595i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f594h = recycleListView;
                this.f595i = alertController;
                Cursor cursor2 = getCursor();
                this.f592f = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f593g = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f592f));
                this.f594h.setItemChecked(cursor.getPosition(), cursor.getInt(this.f593g) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f565b.inflate(this.f595i.M, viewGroup, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ AlertController f597f;

            c(AlertController alertController) {
                this.f597f = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                f.this.f587x.onClick(this.f597f.f526b, i10);
                if (f.this.H) {
                    return;
                }
                this.f597f.f526b.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ RecycleListView f599f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ AlertController f600g;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f599f = recycleListView;
                this.f600g = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i10] = this.f599f.isItemChecked(i10);
                }
                f.this.J.onClick(this.f600g.f526b, i10, this.f599f.isItemChecked(i10));
            }
        }

        /* loaded from: classes.dex */
        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f564a = context;
            this.f565b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void b(androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f565b
                int r1 = r11.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.G
                r8 = 1
                if (r1 == 0) goto L35
                android.database.Cursor r1 = r10.K
                if (r1 != 0) goto L26
                androidx.appcompat.app.AlertController$f$a r9 = new androidx.appcompat.app.AlertController$f$a
                android.content.Context r3 = r10.f564a
                int r4 = r11.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f585v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L6b
            L26:
                androidx.appcompat.app.AlertController$f$b r9 = new androidx.appcompat.app.AlertController$f$b
                android.content.Context r3 = r10.f564a
                android.database.Cursor r4 = r10.K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L6b
            L35:
                boolean r1 = r10.H
                if (r1 == 0) goto L3c
                int r1 = r11.N
                goto L3e
            L3c:
                int r1 = r11.O
            L3e:
                r4 = r1
                android.database.Cursor r1 = r10.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L5d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f564a
                android.database.Cursor r5 = r10.K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.L
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L6b
            L5d:
                android.widget.ListAdapter r9 = r10.f586w
                if (r9 == 0) goto L62
                goto L6b
            L62:
                androidx.appcompat.app.AlertController$h r9 = new androidx.appcompat.app.AlertController$h
                android.content.Context r1 = r10.f564a
                java.lang.CharSequence[] r3 = r10.f585v
                r9.<init>(r1, r4, r2, r3)
            L6b:
                androidx.appcompat.app.AlertController$f$e r1 = r10.O
                if (r1 == 0) goto L72
                r1.a(r0)
            L72:
                r11.H = r9
                int r1 = r10.I
                r11.I = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f587x
                if (r1 == 0) goto L85
                androidx.appcompat.app.AlertController$f$c r1 = new androidx.appcompat.app.AlertController$f$c
                r1.<init>(r11)
            L81:
                r0.setOnItemClickListener(r1)
                goto L8f
            L85:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.J
                if (r1 == 0) goto L8f
                androidx.appcompat.app.AlertController$f$d r1 = new androidx.appcompat.app.AlertController$f$d
                r1.<init>(r0, r11)
                goto L81
            L8f:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.N
                if (r1 == 0) goto L96
                r0.setOnItemSelectedListener(r1)
            L96:
                boolean r1 = r10.H
                if (r1 == 0) goto L9e
                r0.setChoiceMode(r8)
                goto La6
            L9e:
                boolean r1 = r10.G
                if (r1 == 0) goto La6
                r1 = 2
                r0.setChoiceMode(r1)
            La6:
                r11.f531g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.f.b(androidx.appcompat.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            View view = this.f570g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f569f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f567d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i10 = this.f566c;
                if (i10 != 0) {
                    alertController.m(i10);
                }
                int i11 = this.f568e;
                if (i11 != 0) {
                    alertController.m(alertController.c(i11));
                }
            }
            CharSequence charSequence2 = this.f571h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f572i;
            if (charSequence3 != null || this.f573j != null) {
                alertController.k(-1, charSequence3, this.f574k, null, this.f573j);
            }
            CharSequence charSequence4 = this.f575l;
            if (charSequence4 != null || this.f576m != null) {
                alertController.k(-2, charSequence4, this.f577n, null, this.f576m);
            }
            CharSequence charSequence5 = this.f578o;
            if (charSequence5 != null || this.f579p != null) {
                alertController.k(-3, charSequence5, this.f580q, null, this.f579p);
            }
            if (this.f585v != null || this.K != null || this.f586w != null) {
                b(alertController);
            }
            View view2 = this.f589z;
            if (view2 != null) {
                if (this.E) {
                    alertController.t(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i12 = this.f588y;
            if (i12 != 0) {
                alertController.r(i12);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f602a;

        public g(DialogInterface dialogInterface) {
            this.f602a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f602a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, androidx.appcompat.app.h hVar, Window window) {
        this.f525a = context;
        this.f526b = hVar;
        this.f527c = window;
        this.R = new g(hVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, e.j.D, e.a.f8867n, 0);
        this.J = obtainStyledAttributes.getResourceId(e.j.E, 0);
        this.K = obtainStyledAttributes.getResourceId(e.j.G, 0);
        this.L = obtainStyledAttributes.getResourceId(e.j.I, 0);
        this.M = obtainStyledAttributes.getResourceId(e.j.J, 0);
        this.N = obtainStyledAttributes.getResourceId(e.j.L, 0);
        this.O = obtainStyledAttributes.getResourceId(e.j.H, 0);
        this.P = obtainStyledAttributes.getBoolean(e.j.K, true);
        this.f528d = obtainStyledAttributes.getDimensionPixelSize(e.j.F, 0);
        obtainStyledAttributes.recycle();
        hVar.k(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i10 = this.K;
        return (i10 != 0 && this.Q == 1) ? i10 : this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i10, int i11) {
        View findViewById = this.f527c.findViewById(e.f.f8951v);
        View findViewById2 = this.f527c.findViewById(e.f.f8950u);
        if (Build.VERSION.SDK_INT >= 23) {
            a0.z0(view, i10, i11);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 == null) {
                return;
            }
        } else {
            if (findViewById != null && (i10 & 1) == 0) {
                viewGroup.removeView(findViewById);
                findViewById = null;
            }
            if (findViewById2 != null && (i10 & 2) == 0) {
                viewGroup.removeView(findViewById2);
                findViewById2 = null;
            }
            if (findViewById == null && findViewById2 == null) {
                return;
            }
            if (this.f530f != null) {
                this.A.setOnScrollChangeListener(new b(this, findViewById, findViewById2));
                this.A.post(new c(findViewById, findViewById2));
                return;
            }
            ListView listView = this.f531g;
            if (listView != null) {
                listView.setOnScrollListener(new d(this, findViewById, findViewById2));
                this.f531g.post(new e(findViewById, findViewById2));
                return;
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (findViewById2 == null) {
                    return;
                }
            }
        }
        viewGroup.removeView(findViewById2);
    }

    private void u(ViewGroup viewGroup) {
        int i10;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(R.id.button1);
        this.f539o = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f540p) && this.f542r == null) {
            this.f539o.setVisibility(8);
            i10 = 0;
        } else {
            this.f539o.setText(this.f540p);
            Drawable drawable = this.f542r;
            if (drawable != null) {
                int i11 = this.f528d;
                drawable.setBounds(0, 0, i11, i11);
                this.f539o.setCompoundDrawables(this.f542r, null, null, null);
            }
            this.f539o.setVisibility(0);
            i10 = 1;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button2);
        this.f543s = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f544t) && this.f546v == null) {
            this.f543s.setVisibility(8);
        } else {
            this.f543s.setText(this.f544t);
            Drawable drawable2 = this.f546v;
            if (drawable2 != null) {
                int i12 = this.f528d;
                drawable2.setBounds(0, 0, i12, i12);
                this.f543s.setCompoundDrawables(this.f546v, null, null, null);
            }
            this.f543s.setVisibility(0);
            i10 |= 2;
        }
        Button button4 = (Button) viewGroup.findViewById(R.id.button3);
        this.f547w = button4;
        button4.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f548x) && this.f550z == null) {
            this.f547w.setVisibility(8);
        } else {
            this.f547w.setText(this.f548x);
            Drawable drawable3 = this.f550z;
            if (drawable3 != null) {
                int i13 = this.f528d;
                drawable3.setBounds(0, 0, i13, i13);
                this.f547w.setCompoundDrawables(this.f550z, null, null, null);
            }
            this.f547w.setVisibility(0);
            i10 |= 4;
        }
        if (z(this.f525a)) {
            if (i10 == 1) {
                button = this.f539o;
            } else if (i10 == 2) {
                button = this.f543s;
            } else if (i10 == 4) {
                button = this.f547w;
            }
            b(button);
        }
        if (i10 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f527c.findViewById(e.f.f8952w);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f530f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f531g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.f531g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f532h;
        if (view == null) {
            view = this.f533i != 0 ? LayoutInflater.from(this.f525a).inflate(this.f533i, viewGroup, false) : null;
        }
        boolean z10 = view != null;
        if (!z10 || !a(view)) {
            this.f527c.setFlags(131072, 131072);
        }
        if (!z10) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f527c.findViewById(e.f.f8943n);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.f538n) {
            frameLayout.setPadding(this.f534j, this.f535k, this.f536l, this.f537m);
        }
        if (this.f531g != null) {
            ((LinearLayout.LayoutParams) ((k0.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f527c.findViewById(e.f.O).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f527c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f529e)) || !this.P) {
            this.f527c.findViewById(e.f.O).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f527c.findViewById(e.f.f8939j);
        this.E = textView;
        textView.setText(this.f529e);
        int i10 = this.B;
        if (i10 != 0) {
            this.D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f527c.findViewById(e.f.f8949t);
        int i10 = e.f.P;
        View findViewById4 = findViewById3.findViewById(i10);
        int i11 = e.f.f8942m;
        View findViewById5 = findViewById3.findViewById(i11);
        int i12 = e.f.f8940k;
        View findViewById6 = findViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(e.f.f8944o);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(i10);
        View findViewById8 = viewGroup.findViewById(i11);
        View findViewById9 = viewGroup.findViewById(i12);
        ViewGroup i13 = i(findViewById7, findViewById4);
        ViewGroup i14 = i(findViewById8, findViewById5);
        ViewGroup i15 = i(findViewById9, findViewById6);
        v(i14);
        u(i15);
        x(i13);
        boolean z10 = viewGroup.getVisibility() != 8;
        boolean z11 = (i13 == null || i13.getVisibility() == 8) ? 0 : 1;
        boolean z12 = (i15 == null || i15.getVisibility() == 8) ? false : true;
        if (!z12 && i14 != null && (findViewById2 = i14.findViewById(e.f.K)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z11 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.f530f == null && this.f531g == null) ? null : i13.findViewById(e.f.N);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (i14 != null && (findViewById = i14.findViewById(e.f.L)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f531g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z11, z12);
        }
        if (!z10) {
            View view = this.f531g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                p(i14, view, z11 | (z12 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f531g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i16 = this.I;
        if (i16 > -1) {
            listView2.setItemChecked(i16, true);
            listView2.setSelection(i16);
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(e.a.f8866m, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f525a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f531g;
    }

    public void e() {
        this.f526b.setContentView(j());
        y();
    }

    public boolean g(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public void k(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f548x = charSequence;
            this.f549y = message;
            this.f550z = drawable;
        } else if (i10 == -2) {
            this.f544t = charSequence;
            this.f545u = message;
            this.f546v = drawable;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f540p = charSequence;
            this.f541q = message;
            this.f542r = drawable;
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i10) {
        this.C = null;
        this.B = i10;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i10 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f530f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f529e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i10) {
        this.f532h = null;
        this.f533i = i10;
        this.f538n = false;
    }

    public void s(View view) {
        this.f532h = view;
        this.f533i = 0;
        this.f538n = false;
    }

    public void t(View view, int i10, int i11, int i12, int i13) {
        this.f532h = view;
        this.f533i = 0;
        this.f538n = true;
        this.f534j = i10;
        this.f535k = i11;
        this.f536l = i12;
        this.f537m = i13;
    }
}
