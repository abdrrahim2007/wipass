package a;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.root4arab.wipass.AboutActivity;
import com.root4arab.wipass.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f38a = 1;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ KeyEvent.Callback c;

    public /* synthetic */ c(View view, boolean z) {
        this.c = view;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f38a) {
            case 0:
                AboutActivity aboutActivity = (AboutActivity) this.c;
                try {
                    if (!this.b) {
                        AlertDialog alertDialog = aboutActivity.c;
                        if (alertDialog == null || !alertDialog.isShowing()) {
                            View viewInflate = LayoutInflater.from(aboutActivity).inflate(R.layout.popup_success_update, (ViewGroup) null);
                            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.btn_close);
                            AlertDialog alertDialogCreate = new AlertDialog.Builder(aboutActivity).setView(viewInflate).setCancelable(true).create();
                            aboutActivity.c = alertDialogCreate;
                            if (alertDialogCreate.getWindow() != null) {
                                aboutActivity.c.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                            }
                            materialButton.setOnClickListener(new b(aboutActivity, 0));
                            aboutActivity.c.show();
                        }
                    } else {
                        AlertDialog alertDialog2 = aboutActivity.b;
                        if (alertDialog2 == null || !alertDialog2.isShowing()) {
                            View viewInflate2 = LayoutInflater.from(aboutActivity).inflate(R.layout.popup_update, (ViewGroup) null);
                            MaterialButton materialButton2 = (MaterialButton) viewInflate2.findViewById(R.id.btn_download_update);
                            AlertDialog alertDialogCreate2 = new AlertDialog.Builder(aboutActivity).setView(viewInflate2).setCancelable(true).create();
                            aboutActivity.b = alertDialogCreate2;
                            if (alertDialogCreate2.getWindow() != null) {
                                aboutActivity.b.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                            }
                            materialButton2.setOnClickListener(new b(aboutActivity, 1));
                            aboutActivity.b.show();
                        }
                    }
                } catch (Exception unused) {
                    return;
                }
                break;
            default:
                ViewUtils.showKeyboard((View) this.c, this.b);
                break;
        }
    }

    public /* synthetic */ c(AboutActivity aboutActivity, boolean z, String str) {
        this.c = aboutActivity;
        this.b = z;
    }
}
