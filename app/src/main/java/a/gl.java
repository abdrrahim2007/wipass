package a;

import android.content.Context;
import android.graphics.Typeface;
import android.location.Location;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Consumer;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.DispatchQueue;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.root4arab.wipass.MainActivity;
import com.root4arab.wipass.WifiDetailsActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f101a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ gl(int i, Object obj, Object obj2) {
        this.f101a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f101a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1((DispatchQueue) obj2, (Runnable) obj);
                break;
            case 1:
                FragmentStrictMode.m37handlePolicyViolation$lambda0((FragmentStrictMode.Policy) obj2, (Violation) obj);
                break;
            case 2:
                FragmentStrictMode.m38handlePolicyViolation$lambda1((String) obj2, (Violation) obj);
                break;
            case 3:
                ((Consumer) obj2).accept((Location) obj);
                break;
            case 4:
                int i2 = MainActivity.u;
                ((View) obj2).animate().alpha(0.0f).scaleX(0.95f).scaleY(0.95f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new aa(7, (AlertDialog) obj)).start();
                break;
            case 5:
                ((ProfileInstallerInitializer) obj2).lambda$delayAfterFirstFrame$0((Context) obj);
                break;
            case 6:
                ((ResourcesCompat.FontCallback) obj2).lambda$callbackSuccessAsync$0((Typeface) obj);
                break;
            case 7:
                ((ViewTransition) obj2).lambda$applyTransition$0((View[]) obj);
                break;
            case 8:
                WifiDetailsActivity wifiDetailsActivity = ((xb) obj2).b;
                int i3 = WifiDetailsActivity.ag;
                wifiDetailsActivity.h((String) obj);
                break;
            default:
                WifiDetailsActivity wifiDetailsActivity2 = (WifiDetailsActivity) ((iz) obj2).c;
                int i4 = WifiDetailsActivity.ag;
                wifiDetailsActivity2.h((String) obj);
                break;
        }
    }
}
