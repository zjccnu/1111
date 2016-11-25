package com.example.administrator.demo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/7/17.
 */
public class UserBean implements Parcelable{
    String name;
    int age;
public UserBean(){

}
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int describeContents() {
                return 0;
           }
                public void writeToParcel(Parcel out, int flags) {
                    out.writeString(name);
                out.writeInt(age);
           }

    public static final Parcelable.Creator<UserBean> CREATOR
                = new Parcelable.Creator<UserBean>() {
                public UserBean createFromParcel(Parcel in) {
                        return new UserBean(in);
                    }
                 public UserBean[] newArray(int size) {
                        return new UserBean[size];
                   }
             };

    private  UserBean(Parcel in) {
                    name=in.readString();
                   age = in.readInt();
            }
}
