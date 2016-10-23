package star.yx.test;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import java.util.logging.Logger;

/**
 * Created by Administrator on 2016/10/23 0023.
 */

public class DensityUtil {
    public DensityUtil() {
    }

    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5F);
    }

    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5F);
    }

//    public static int getScreenWidth(Context context) {
//        WindowManager manager = (WindowManager) context.getSystemService("window");
//        Display display = manager.getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        return size.x;
//    }
//
//    public static int getScreenHeight(Context context) {
//        WindowManager manager = (WindowManager) context.getSystemService("window");
//        Display display = manager.getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        return size.y;
//    }
//
//    public static int[] getScreenSize(Context context) {
//        WindowManager manager = (WindowManager) context.getSystemService("window");
//        Display display = manager.getDefaultDisplay();
//        int[] size = new int[]{display.getWidth(), display.getHeight()};
//        return size;
//    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }
}

