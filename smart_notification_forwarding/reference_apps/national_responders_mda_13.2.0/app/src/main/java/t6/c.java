package t6;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public abstract class c<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f14304d = c.class.getName();

    /* renamed from: a, reason: collision with root package name */
    private final ProgressDialog f14305a;

    /* renamed from: b, reason: collision with root package name */
    private int f14306b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14307c;

    /* loaded from: classes.dex */
    class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            c.this.cancel(true);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f14307c) {
                return;
            }
            try {
                c.this.f14305a.show();
            } catch (Throwable th) {
                String unused = c.f14304d;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onPreExecute() - show dialog: ");
                sb2.append(th);
            }
        }
    }

    public c(Context context, boolean z10) {
        this(context, z10, R.string.pkey_display_captcha_wired_dots);
    }

    public c(Context context, boolean z10, int i10) {
        this(context, z10, context.getString(i10));
    }

    public c(Context context, boolean z10, CharSequence charSequence) {
        this.f14306b = 500;
        this.f14307c = false;
        ProgressDialog progressDialog = new ProgressDialog(context);
        this.f14305a = progressDialog;
        progressDialog.setCancelable(z10);
        progressDialog.setMessage(charSequence);
        progressDialog.setIndeterminate(true);
        if (z10) {
            progressDialog.setCanceledOnTouchOutside(true);
            progressDialog.setOnCancelListener(new a());
        }
    }

    private void d() {
        this.f14307c = true;
        try {
            this.f14305a.dismiss();
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("doFinish() - dismiss dialog: ");
            sb2.append(th);
        }
    }

    public int e() {
        return this.f14306b;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        d();
        super.onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Result result) {
        d();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        new Handler().postDelayed(new b(), e());
    }
}
