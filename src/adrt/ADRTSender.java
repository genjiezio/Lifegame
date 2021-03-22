package adrt;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

public class ADRTSender {
    private static Context context;

    private static String debuggerPackageName;

    public static void onContext(Context paramContext, String paramString) {
        context = paramContext;
        debuggerPackageName = paramString;
    }

    public static void sendBreakpointHit(String paramString, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4, ArrayList<String> paramArrayList5, ArrayList<String> paramArrayList6) {
        Intent intent = new Intent();
        intent.setPackage(debuggerPackageName);
        intent.setAction("com.adrt.BREAKPOINT_HIT");
        intent.putExtra("package", paramString);
        intent.putExtra("variables", paramArrayList1);
        intent.putExtra("variableValues", paramArrayList2);
        intent.putExtra("variableKinds", paramArrayList3);
        intent.putExtra("stackMethods", paramArrayList4);
        intent.putExtra("stackLocations", paramArrayList5);
        intent.putExtra("stackLocationKinds", paramArrayList6);
        context.sendBroadcast(intent);
    }

    public static void sendConnect(String paramString) {
        Intent intent = new Intent();
        intent.setPackage(debuggerPackageName);
        intent.setAction("com.adrt.CONNECT");
        intent.putExtra("package", paramString);
        context.sendBroadcast(intent);
    }

    public static void sendFields(String paramString1, String paramString2, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3) {
        Intent intent = new Intent();
        intent.setPackage(debuggerPackageName);
        intent.setAction("com.adrt.FIELDS");
        intent.putExtra("package", paramString1);
        intent.putExtra("path", paramString2);
        intent.putExtra("fields", paramArrayList1);
        intent.putExtra("fieldValues", paramArrayList2);
        intent.putExtra("fieldKinds", paramArrayList3);
        context.sendBroadcast(intent);
    }

    public static void sendLogcatLines(String[] paramArrayOfString) {
        Intent intent = new Intent();
        intent.setPackage(debuggerPackageName);
        intent.setAction("com.adrt.LOGCAT_ENTRIES");
        intent.putExtra("lines", paramArrayOfString);
        context.sendBroadcast(intent);
    }

    public static void sendStop(String paramString) {
        Intent intent = new Intent();
        intent.setPackage(debuggerPackageName);
        intent.setAction("com.adrt.STOP");
        intent.putExtra("package", paramString);
        context.sendBroadcast(intent);
    }
}
