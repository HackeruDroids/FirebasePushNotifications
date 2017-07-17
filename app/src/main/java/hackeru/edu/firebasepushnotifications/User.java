package hackeru.edu.firebasepushnotifications;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.auth.FirebaseUser;

/**
 * POJO:
 * Empty Constructor
 * //Getters and setters
 */

public class User implements Parcelable {
    //properties:
    private String uid;
    private String displayName;

    //empty ctor
    public User() {
    }

    public User(FirebaseUser user) {
        this.uid = user.getUid();
        this.displayName = user.getDisplayName();
    }

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    //tostring... parcelable


    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uid);
        dest.writeString(this.displayName);
    }

    protected User(Parcel in) {
        this.uid = in.readString();
        this.displayName = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
