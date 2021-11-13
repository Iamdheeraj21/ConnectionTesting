package com.example.connectiontesting;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.preference.DialogPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class NetworkListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!Connection.isNetwork(context)) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            View view = LayoutInflater.from(context).inflate(R.layout.network_view, null);
            dialog.setView(view);
            AlertDialog alertDialog=dialog.create();
            alertDialog.getWindow().setType(WindowManager.LayoutParams.
                    TYPE_SYSTEM_ALERT);
            alertDialog.show();
            dialog.setCancelable(false);
            Button button = view.findViewById(R.id.retry);
            button.setOnClickListener(view1 -> {
                alertDialog.dismiss();
                onReceive(context, intent);
            });
//            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
//            dialog.setMessage("network error");
//            dialog.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    onReceive(context, intent);
//                }
//            });
            //dialog.show();
        }
    }
}
