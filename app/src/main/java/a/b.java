package a;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.root4arab.wipass.AboutActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20a;
    public final /* synthetic */ AboutActivity b;

    public /* synthetic */ b(AboutActivity aboutActivity, int i) {
        this.f20a = i;
        this.b = aboutActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f20a;
        AboutActivity aboutActivity = this.b;
        switch (i) {
            case 0:
                aboutActivity.c.dismiss();
                break;
            case 1:
                int i2 = AboutActivity.d;
                aboutActivity.getClass();
                try {
                    aboutActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://gitlab.com/root4arab/wipass")));
                } catch (Exception unused) {
                    Toast.makeText(aboutActivity, "لا يمكن فتح الرابط", 0).show();
                }
                aboutActivity.b.dismiss();
                break;
            case 2:
                int i3 = AboutActivity.d;
                aboutActivity.h("https://t.me/root4arab");
                break;
            case 3:
                int i4 = AboutActivity.d;
                aboutActivity.h("https://www.youtube.com/@root4arab");
                break;
            case 4:
                int i5 = AboutActivity.d;
                aboutActivity.getClass();
                try {
                    aboutActivity.startActivity(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:root4arab@proton.me?subject=" + Uri.encode("إستفسار حول تطبيق WiPass") + "&body=" + Uri.encode("السلام عليكم Root4arab\n أتواصل معك بخصوص تطبيق WiPass و لدي بعض إستفسارات حول ذلك"))), "اختر تطبيق البريد"));
                } catch (ActivityNotFoundException unused2) {
                    Toast.makeText(aboutActivity, "لا يوجد تطبيق بريد إلكتروني مثبت", 0).show();
                    return;
                }
                break;
            case 5:
                int i6 = AboutActivity.d;
                aboutActivity.h("https://gitlab.com/root4arab/wipass");
                break;
            case 6:
                int i7 = AboutActivity.d;
                Toast.makeText(aboutActivity, "جاري التحقق من التحديثات...", 0).show();
                aboutActivity.f431a.execute(new a(aboutActivity, 2));
                break;
            default:
                int i8 = AboutActivity.d;
                aboutActivity.getClass();
                try {
                    String packageName = aboutActivity.getPackageName();
                    PackageManager packageManager = aboutActivity.getPackageManager();
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
                    String str = applicationInfo.sourceDir;
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                    String str2 = "تطبيق " + packageManager.getApplicationLabel(applicationInfo).toString() + "\nالإصدار: " + packageInfo.versionName + "\nتم تطويره من طرف Root4arab\nرابط التنزيل: https://gitlab.com/root4arab/wipass";
                    File file = new File(str);
                    File externalCacheDir = aboutActivity.getExternalCacheDir();
                    if (externalCacheDir == null) {
                        externalCacheDir = aboutActivity.getCacheDir();
                    }
                    File file2 = new File(externalCacheDir, "WIPass.apk");
                    if (!file2.exists() || file.lastModified() > file2.lastModified()) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i9 = fileInputStream.read(bArr);
                            if (i9 > 0) {
                                fileOutputStream.write(bArr, 0, i9);
                            } else {
                                fileInputStream.close();
                                fileOutputStream.close();
                            }
                        }
                    }
                    Uri uriForFile = FileProvider.getUriForFile(aboutActivity, aboutActivity.getPackageName() + ".fileprovider", file2);
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("application/vnd.android.package-archive");
                    intent.setPackage("com.whatsapp");
                    intent.putExtra("android.intent.extra.STREAM", uriForFile);
                    intent.addFlags(1);
                    intent.putExtra("android.intent.extra.TEXT", str2);
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("application/vnd.android.package-archive");
                    intent2.setPackage("com.facebook.katana");
                    intent2.putExtra("android.intent.extra.STREAM", uriForFile);
                    intent2.addFlags(1);
                    intent2.putExtra("android.intent.extra.TEXT", str2);
                    Intent intent3 = new Intent("android.intent.action.SEND");
                    intent3.setType("application/vnd.android.package-archive");
                    intent3.putExtra("android.intent.extra.STREAM", uriForFile);
                    intent3.addFlags(1);
                    intent3.putExtra("android.intent.extra.TEXT", str2);
                    Intent intentCreateChooser = Intent.createChooser(intent3, "مشاركة التطبيق");
                    intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent, intent2});
                    aboutActivity.startActivity(intentCreateChooser);
                } catch (Exception e) {
                    Toast.makeText(aboutActivity, "حدث خطأ أثناء مشاركة التطبيق: " + e.getMessage(), 1).show();
                }
                break;
        }
    }
}
