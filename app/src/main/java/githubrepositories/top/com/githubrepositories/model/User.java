package githubrepositories.top.com.githubrepositories.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class User implements Parcelable {
    public String login;
    public long id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public String name;
    public String blog;
    public String location;
    public String email;
    public int public_repos;
    public int public_gists;
    public int followers;
    public int following;
    public Date created_at;
    public Date updated_at;

    protected User(Parcel in) {
        login = in.readString();
        id = in.readLong();
        avatar_url = in.readString();
        gravatar_id = in.readString();
        url = in.readString();
        html_url = in.readString();
        followers_url = in.readString();
        following_url = in.readString();
        gists_url = in.readString();
        starred_url = in.readString();
        subscriptions_url = in.readString();
        organizations_url = in.readString();
        repos_url = in.readString();
        events_url = in.readString();
        received_events_url = in.readString();
        type = in.readString();
        name = in.readString();
        blog = in.readString();
        location = in.readString();
        email = in.readString();
        public_repos = in.readInt();
        public_gists = in.readInt();
        followers = in.readInt();
        following = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(login);
        parcel.writeLong(id);
        parcel.writeString(avatar_url);
        parcel.writeString(gravatar_id);
        parcel.writeString(url);
        parcel.writeString(html_url);
        parcel.writeString(followers_url);
        parcel.writeString(following_url);
        parcel.writeString(gists_url);
        parcel.writeString(starred_url);
        parcel.writeString(subscriptions_url);
        parcel.writeString(organizations_url);
        parcel.writeString(repos_url);
        parcel.writeString(events_url);
        parcel.writeString(received_events_url);
        parcel.writeString(type);
        parcel.writeString(name);
        parcel.writeString(blog);
        parcel.writeString(location);
        parcel.writeString(email);
        parcel.writeInt(public_repos);
        parcel.writeInt(public_gists);
        parcel.writeInt(followers);
        parcel.writeInt(following);
    }
}