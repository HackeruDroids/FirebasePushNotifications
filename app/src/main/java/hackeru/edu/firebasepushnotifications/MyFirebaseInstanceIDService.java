package hackeru.edu.firebasepushnotifications;

import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * This class registers the user to fcm and get's the token:
 *
 * The registration process happens immediately when the app is first ran.
 *
 * May happen before sign in.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        //get the token-> so we can send individual messages
        String token = FirebaseInstanceId.getInstance().getToken();

        //can't assign this token to a user(person) Yet, since we don't have the user yet.

        SharedPreferences prefs = getSharedPreferences("userid", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("token", token);

        editor.commit(); //sync we want to wait...
    }
}
