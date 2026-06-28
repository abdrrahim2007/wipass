package a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;
import com.root4arab.wipass.AboutActivity;
import com.root4arab.wipass.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f0a;
    public final /* synthetic */ AboutActivity b;

    public /* synthetic */ a(AboutActivity aboutActivity, int i) {
        this.f0a = i;
        this.b = aboutActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        byte b;
        int i3;
        int i4 = this.f0a;
        int i5 = 3;
        int i6 = 1;
        AboutActivity aboutActivity = this.b;
        byte b2 = 0;
        z = false;
        boolean z = false;
        switch (i4) {
            case 0:
                int i7 = AboutActivity.d;
                aboutActivity.getClass();
                int[] iArr = {R.id.card_youtube, R.id.card_facebook, R.id.card_email, R.id.card_privacy, R.id.card_check_update, R.id.card_share};
                int i8 = 0;
                while (i8 < 6) {
                    View viewFindViewById = aboutActivity.findViewById(iArr[i8]);
                    if (viewFindViewById != null) {
                        viewFindViewById.setAlpha(0.0f);
                        viewFindViewById.setTranslationX(-150.0f);
                        viewFindViewById.setTranslationY(30.0f);
                        viewFindViewById.setScaleX(0.5f);
                        viewFindViewById.setScaleY(0.5f);
                        viewFindViewById.setRotationY(-45.0f);
                        AnimatorSet animatorSet = new AnimatorSet();
                        float[] fArr = new float[i5];
                        // fill-array-data instruction
                        fArr[0] = 0.0f;
                        fArr[1] = 0.7f;
                        fArr[2] = 1.0f;
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewById, "alpha", fArr);
                        objectAnimatorOfFloat.setDuration(600L);
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewFindViewById, "translationX", -150.0f, 10.0f, -5.0f, 0.0f);
                        objectAnimatorOfFloat2.setDuration(700L);
                        i2 = i6;
                        objectAnimatorOfFloat2.setInterpolator(new OvershootInterpolator(1.5f));
                        float[] fArr2 = new float[i5];
                        // fill-array-data instruction
                        fArr2[0] = 30.0f;
                        fArr2[1] = -5.0f;
                        fArr2[2] = 0.0f;
                        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewFindViewById, "translationY", fArr2);
                        i3 = i8;
                        objectAnimatorOfFloat3.setDuration(650L);
                        objectAnimatorOfFloat3.setInterpolator(new OvershootInterpolator(1.3f));
                        i = i5;
                        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewFindViewById, "scaleX", 0.5f, 1.15f, 0.95f, 1.05f, 1.0f);
                        objectAnimatorOfFloat4.setDuration(700L);
                        b = b2 == true ? 1 : 0;
                        objectAnimatorOfFloat4.setInterpolator(new OvershootInterpolator(1.8f));
                        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(viewFindViewById, "scaleY", 0.5f, 1.15f, 0.95f, 1.05f, 1.0f);
                        objectAnimatorOfFloat5.setDuration(700L);
                        objectAnimatorOfFloat5.setInterpolator(new OvershootInterpolator(1.8f));
                        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(viewFindViewById, "rotationY", -45.0f, 5.0f, -2.0f, 0.0f);
                        objectAnimatorOfFloat6.setDuration(750L);
                        objectAnimatorOfFloat6.setInterpolator(new DecelerateInterpolator());
                        Animator[] animatorArr = new Animator[6];
                        animatorArr[b == true ? 1 : 0] = objectAnimatorOfFloat;
                        animatorArr[i2] = objectAnimatorOfFloat2;
                        animatorArr[2] = objectAnimatorOfFloat3;
                        animatorArr[i] = objectAnimatorOfFloat4;
                        animatorArr[4] = objectAnimatorOfFloat5;
                        animatorArr[5] = objectAnimatorOfFloat6;
                        animatorSet.playTogether(animatorArr);
                        animatorSet.setStartDelay(i3 * 80);
                        animatorSet.start();
                    } else {
                        i = i5;
                        i2 = i6;
                        b = b2;
                        i3 = i8;
                    }
                    i8 = i3 + 1;
                    i6 = i2;
                    i5 = i;
                    b2 = b;
                }
                break;
            case 1:
                int i9 = AboutActivity.d;
                aboutActivity.getClass();
                Toast.makeText(aboutActivity, "حدث خطأ أثناء التحقق من التحديثات", 0).show();
                break;
            case 2:
                int i10 = AboutActivity.d;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://gitlab.com/root4arab/wipass/-/raw/main/version.txt").openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    if (httpURLConnection.getResponseCode() == 200) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                sb.append(line);
                            } else {
                                bufferedReader.close();
                                String strTrim = sb.toString().trim();
                                String str = aboutActivity.getPackageManager().getPackageInfo(aboutActivity.getPackageName(), 0).versionName;
                                String strTrim2 = strTrim.replaceAll("^v", "").trim();
                                String[] strArrSplit = str.trim().split("\\.");
                                String[] strArrSplit2 = strTrim2.split("\\.");
                                int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
                                int i11 = 0;
                                while (true) {
                                    if (i11 < iMax) {
                                        int i12 = i11 < strArrSplit.length ? Integer.parseInt(strArrSplit[i11]) : 0;
                                        int i13 = i11 < strArrSplit2.length ? Integer.parseInt(strArrSplit2[i11]) : 0;
                                        if (i12 < i13) {
                                            z = true;
                                        } else if (i12 <= i13) {
                                            i11++;
                                        }
                                    }
                                }
                                aboutActivity.runOnUiThread(new c(aboutActivity, z, strTrim2));
                            }
                        }
                    } else {
                        aboutActivity.runOnUiThread(new a(aboutActivity, i5));
                    }
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                    aboutActivity.runOnUiThread(new a(aboutActivity, i6));
                    return;
                }
                break;
            default:
                int i14 = AboutActivity.d;
                aboutActivity.getClass();
                Toast.makeText(aboutActivity, "فشل الاتصال بالخادم", 0).show();
                break;
        }
    }
}
