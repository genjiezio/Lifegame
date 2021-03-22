package adrt;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADRTLogCatReader implements Runnable {
    private static Context context;

    public static void onContext(Context paramContext, String paramString) {
        boolean bool;
        if (context != null)
            return;
        context = paramContext.getApplicationContext();
        if (((paramContext.getApplicationInfo()).flags & 0x2) != 0) {
            bool = true;
        } else {
            bool = false;
        }
        if (!bool)
            return;
        try {
            paramContext.getPackageManager().getPackageInfo(paramString, 128);
            ADRTSender.onContext(context, paramString);
            (new Thread(new ADRTLogCatReader(), "LogCat")).start();
            return;
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            return;
        }
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v threadtime").getInputStream()), 20);
            while (true) {
                String str = bufferedReader.readLine();
                if (str != null) {
                    ADRTSender.sendLogcatLines(new String[] { str });
                    continue;
                }
                break;
            }
            return;
        } catch (IOException iOException) {
            return;
        }
    }
}
