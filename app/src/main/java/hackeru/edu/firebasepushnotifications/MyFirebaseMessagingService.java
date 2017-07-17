package hackeru.edu.firebasepushnotifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * get the notification.
 */

//it's a specialized intent service
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    //This method is fired when we receive a message in the foreground When the app is visible
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("Hackeru", "onMessageReceived");
    }


    //this method is fired when a message is received both in foreground and in background.
    @Override
    public void handleIntent(Intent intent) {
        //super.handleIntent(intent); don't want the default push and behaviour
        Log.d("Hackeru", "handleIntent");
        //1) Build notification using NotificationCompat.Builder
        android.support.v7.app.NotificationCompat.Builder builder = new android.support.v7.app.NotificationCompat.Builder(this);

        builder.setContentTitle("Hello custom push");
        builder.setSmallIcon(R.drawable.ic_notification);
        builder.setContentText("The Content Text");
        builder.setAutoCancel(true);

        Intent contentIntent = new Intent(this, MainActivity.class);
        contentIntent.putExtra("name", "Tomer");

        PendingIntent pi = PendingIntent.getActivity(this, 1, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setDefaults(Notification.DEFAULT_ALL);
        //TODO: builder.setChannelId("channel1");
        //priority
        //vibrate, sound, lights
        //wake lock, vibrate
        Notification notification = builder.build();
        //2) notify using NotificationCompatManager
        NotificationManagerCompat mgr = NotificationManagerCompat.from(this);
        mgr.notify(1, notification);
        //update a notification: mgr.notify(1, notification);
        //cancel mgr.cancel(id)
    }
}
