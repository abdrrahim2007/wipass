package a;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pn implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f238a;

    public /* synthetic */ pn(int i) {
        this.f238a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f238a) {
            case 0:
                return MaterialDynamicColors.lambda$secondaryFixed$118(dynamicScheme);
            case 1:
                return MaterialDynamicColors.lambda$onPrimaryFixedVariant$113(dynamicScheme);
            case 2:
                return MaterialDynamicColors.lambda$onPrimaryFixedVariant$114(dynamicScheme);
            case 3:
                return MaterialDynamicColors.lambda$tertiaryFixedDim$134(dynamicScheme);
            case 4:
                return MaterialDynamicColors.lambda$tertiaryFixedDim$135(dynamicScheme);
            case 5:
                return MaterialDynamicColors.lambda$onError$94(dynamicScheme);
            case 6:
                return MaterialDynamicColors.lambda$onError$95(dynamicScheme);
            case 7:
                return MaterialDynamicColors.lambda$textPrimaryInverseDisableOnly$156(dynamicScheme);
            case 8:
                return MaterialDynamicColors.lambda$textPrimaryInverseDisableOnly$157(dynamicScheme);
            case 9:
                return MaterialDynamicColors.lambda$onPrimaryContainer$61(dynamicScheme);
            case 10:
                return MaterialDynamicColors.lambda$secondaryFixedDim$120(dynamicScheme);
            case 11:
                return MaterialDynamicColors.lambda$secondaryFixedDim$121(dynamicScheme);
            case 12:
                return MaterialDynamicColors.lambda$onSurface$31(dynamicScheme);
            case 13:
                return MaterialDynamicColors.lambda$surfaceVariant$33(dynamicScheme);
            case 14:
                return MaterialDynamicColors.lambda$surfaceVariant$34(dynamicScheme);
            case 15:
                return MaterialDynamicColors.lambda$neutralVariantPaletteKeyColor$8(dynamicScheme);
            case 16:
                return MaterialDynamicColors.lambda$neutralVariantPaletteKeyColor$9(dynamicScheme);
            case 17:
                return MaterialDynamicColors.lambda$textHintInverse$160(dynamicScheme);
            case 18:
                return MaterialDynamicColors.lambda$textHintInverse$161(dynamicScheme);
            case 19:
                return MaterialDynamicColors.lambda$shadow$46(dynamicScheme);
            case 20:
                return MaterialDynamicColors.lambda$shadow$47(dynamicScheme);
            case 21:
                return MaterialDynamicColors.lambda$surfaceContainerHighest$29(dynamicScheme);
            case 22:
                return MaterialDynamicColors.lambda$onSurface$32(dynamicScheme);
            case 23:
                return MaterialDynamicColors.lambda$surfaceContainerHighest$30(dynamicScheme);
            case 24:
                return MaterialDynamicColors.lambda$primaryFixed$103(dynamicScheme);
            case 25:
                return MaterialDynamicColors.lambda$primaryFixed$104(dynamicScheme);
            case 26:
                return MaterialDynamicColors.lambda$primaryFixedDim$106(dynamicScheme);
            case 27:
                return MaterialDynamicColors.lambda$primaryFixedDim$107(dynamicScheme);
            default:
                return MaterialDynamicColors.lambda$tertiaryContainer$85(dynamicScheme);
        }
    }
}
