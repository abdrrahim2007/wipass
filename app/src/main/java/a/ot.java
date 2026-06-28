package a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.button.MaterialButton;
import com.root4arab.wipass.MainActivity;
import com.root4arab.wipass.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ot implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f218a;
    public final /* synthetic */ MainActivity b;

    public /* synthetic */ ot(MainActivity mainActivity, int i) {
        this.f218a = i;
        this.b = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f218a;
        MainActivity mainActivity = this.b;
        switch (i) {
            case 0:
                int i2 = MainActivity.u;
                mainActivity.j.removeCallbacksAndMessages(null);
                mainActivity.m();
                break;
            default:
                int i3 = MainActivity.u;
                try {
                    final View viewInflate = LayoutInflater.from(mainActivity).inflate(R.layout.popup_follow_us, (ViewGroup) null);
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.starIcon);
                    final MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.btnGotIt);
                    final AlertDialog alertDialogCreate = new AlertDialog.Builder(mainActivity).setView(viewInflate).setCancelable(true).create();
                    if (alertDialogCreate.getWindow() != null) {
                        alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                        alertDialogCreate.getWindow().setDimAmount(0.6f);
                    }
                    viewInflate.setAlpha(0.0f);
                    viewInflate.setScaleX(0.9f);
                    viewInflate.setScaleY(0.9f);
                    viewInflate.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(350L).setInterpolator(new DecelerateInterpolator()).start();
                    imageView.setAlpha(1.0f);
                    imageView.setScaleX(1.0f);
                    imageView.setScaleY(1.0f);
                    imageView.setRotation(0.0f);
                    imageView.setTranslationY(0.0f);
                    imageView.setTranslationZ(0.0f);
                    materialButton.setOnClickListener(new View.OnClickListener() { // from class: a.ov
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i4 = MainActivity.u;
                            materialButton.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100L).withEndAction(new gl(4, viewInflate, alertDialogCreate)).start();
                        }
                    });
                    alertDialogCreate.show();
                } catch (Exception unused) {
                    return;
                }
                break;
        }
    }
}
