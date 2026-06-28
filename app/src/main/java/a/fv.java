package a;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;

/* JADX INFO: loaded from: classes.dex */
public final class fv implements ImageDecoder$OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lm f89a = lm.a();
    public final int b;
    public final int c;
    public final fg d;
    public final gr e;
    public final boolean f;
    public final re g;

    public fv(int i, int i2, qu quVar) {
        this.b = i;
        this.c = i2;
        this.d = (fg) quVar.c(gt.f);
        this.e = (gr) quVar.c(gr.g);
        qt qtVar = gt.i;
        this.f = quVar.c(qtVar) != null && ((Boolean) quVar.c(qtVar)).booleanValue();
        this.g = (re) quVar.c(gt.g);
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.f89a.c(this.b, this.c, this.f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.d == fg.b) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new fu());
        Size size = imageInfo.getSize();
        int width = this.b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(fB * size.getHeight());
        if (Log.isLoggable("ImageDecoder", 2)) {
            size.getWidth();
            size.getHeight();
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        re reVar = this.g;
        if (reVar != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((reVar == re.f263a && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i >= 26) {
                ColorSpace.Named unused = ColorSpace.Named.SRGB;
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
