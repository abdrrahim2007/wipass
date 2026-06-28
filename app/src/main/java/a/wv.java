package a;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.root4arab.wipass.WifiDetailsActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wv implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f356a;
    public final /* synthetic */ AlertDialog b;

    public /* synthetic */ wv(AlertDialog alertDialog, int i) {
        this.f356a = i;
        this.b = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f356a;
        AlertDialog alertDialog = this.b;
        switch (i) {
            case 0:
                int i2 = WifiDetailsActivity.ag;
                alertDialog.dismiss();
                break;
            default:
                int i3 = WifiDetailsActivity.ag;
                alertDialog.dismiss();
                break;
        }
    }
}
