package net.ddns.axlrock.bands.Stage.Jack_Studio;

import android.os.Parcel;
import android.os.Parcelable;

public class Content implements Parcelable {

    public final String name;

    public Content(String name) {
        this.name = name;
    }

    protected Content(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Content> CREATOR = new Creator<Content>() {

        @Override
        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        @Override
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
