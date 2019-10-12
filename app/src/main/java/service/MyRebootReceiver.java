package service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

public class MyRebootReceiver extends BroadcastReceiver{

	public MyRebootReceiver() {
		super();
	}

	@Override
	public void onReceive(Context context, Intent intent) {

		intent.getFlags();

		String broadcastName = intent.getAction().substring(0);

		if(broadcastName.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")){
			ConnectivityManager cm = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
			boolean isConnected = activeNetwork != null
					&& activeNetwork.isConnectedOrConnecting();

			if (isConnected) {
			}

		} else if(broadcastName.equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")||broadcastName.equalsIgnoreCase("android.intent.action.QUICKBOOT_POWERON")){
            // todo ghqp fix service

			Intent serviceIntentMyServiceNative = new Intent(context, MyServiceNative.class);
            //context.startService(serviceIntentMyServiceNative);

			Intent serviceIntentMyTrackingLocationService = new Intent(context, MyTrackingLocationService.class);
            //context.startService(serviceIntentMyTrackingLocationService);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntentMyTrackingLocationService);
            } else {
                context.startService(serviceIntentMyTrackingLocationService);
            }

			/*
			Intent serviceIntentMyNotificationService = new Intent(context, MyNotificationService.class);
			context.startService(serviceIntentMyNotificationService);
			*/
		}
	}
}
