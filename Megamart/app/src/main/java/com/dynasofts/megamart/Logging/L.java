package com.dynasofts.megamart.Logging;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Keshav K on 6/17/2015.
 */
public class L {
    public static void m(String message){
        Log.d("Material", "" + message);
    }

    public static void t(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
