package a;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import androidx.activity.ComponentActivity;
import androidx.activity.ComponentDialog;
import androidx.activity.FullyDrawnReporter;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.core.app.ActivityCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.search.SearchBar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.root4arab.wipass.MainActivity;
import com.root4arab.wipass.SplashActivity;
import com.root4arab.wipass.WifiDetailsActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1a;
    public final /* synthetic */ Object b;

    public /* synthetic */ aa(int i, Object obj) {
        this.f1a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConnectivityManager connectivityManager;
        int i = this.f1a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ActivityCompat.lambda$recreate$0((Activity) obj);
                break;
            case 1:
                ((AnimationHandler) obj).lambda$new$0();
                break;
            case 2:
                ((Carousel) obj).lambda$updateItems$0();
                break;
            case 3:
                ((CarouselLayoutManager) obj).refreshKeylineState();
                break;
            case 4:
                ((ComponentActivity) obj).invalidateMenu();
                break;
            case 5:
                ComponentDialog.onBackPressedDispatcher$lambda$1((ComponentDialog) obj);
                break;
            case 6:
                FullyDrawnReporter.reportRunnable$lambda$2((FullyDrawnReporter) obj);
                break;
            case 7:
                int i2 = MainActivity.u;
                ((AlertDialog) obj).dismiss();
                break;
            case 8:
                ((MaterialButton) obj).lambda$setOpticalCenterEnabled$1();
                break;
            case 9:
                ((MaterialTimePicker) obj).lambda$onViewCreated$0();
                break;
            case 10:
                ((MaterialBackOrchestrator) obj).startListeningForBackCallbacksWithPriorityOverlay();
                break;
            case 11:
                ProcessLifecycleOwner.delayedPauseRunnable$lambda$0((ProcessLifecycleOwner) obj);
                break;
            case 12:
                ((SearchBar) obj).lambda$startOnLoadAnimation$0();
                break;
            case 13:
                SplashActivity splashActivity = (SplashActivity) obj;
                int i3 = SplashActivity.f433a;
                splashActivity.getClass();
                splashActivity.startActivity(new Intent(splashActivity, (Class<?>) MainActivity.class));
                splashActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                splashActivity.finish();
                break;
            case 14:
                ((TextInputLayout) obj).lambda$onGlobalLayout$1();
                break;
            case 15:
                ((jh) obj).invoke();
                break;
            case 16:
                WifiDetailsActivity wifiDetailsActivity = (WifiDetailsActivity) ((ow) obj).b;
                try {
                    Handler handler = wifiDetailsActivity.z;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    Handler handler2 = wifiDetailsActivity.aa;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                    }
                    xb xbVar = wifiDetailsActivity.ab;
                    if (xbVar != null && (connectivityManager = wifiDetailsActivity.t) != null) {
                        try {
                            connectivityManager.unregisterNetworkCallback(xbVar);
                            break;
                        } catch (Exception unused) {
                        }
                        wifiDetailsActivity.ab = null;
                    }
                    break;
                } catch (Exception unused2) {
                }
                wifiDetailsActivity.y++;
                wifiDetailsActivity.m();
                break;
            default:
                WifiDetailsActivity wifiDetailsActivity2 = ((xb) obj).b;
                int i4 = WifiDetailsActivity.ag;
                wifiDetailsActivity2.m();
                break;
        }
    }
}
