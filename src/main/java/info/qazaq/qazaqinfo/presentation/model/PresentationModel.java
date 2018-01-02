package info.qazaq.qazaqinfo.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

import info.qazaq.qazaqinfo.data.entity.Employment;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class PresentationModel implements Parcelable
{
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String ip_address;
    private String photo;
    private Employment employment;

    public PresentationModel() {}

    public PresentationModel(int id,
                     String first_name,
                     String last_name,
                     String email,
                     String photo,
                             String gender, String ip_address)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.photo = photo;
        this.gender = gender;
        this.ip_address = ip_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {

        parcel.writeInt(id);
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(email);
        parcel.writeString(gender);
        parcel.writeString(ip_address);
        parcel.writeString(photo);
    }

    protected PresentationModel(Parcel in)
    {
        id = in.readInt();
        first_name = in.readString();
        last_name = in.readString();
        email = in.readString();
        gender = in.readString();
        ip_address = in.readString();
        photo = in.readString();
    }

    public static final Creator<PresentationModel> CREATOR = new Creator<PresentationModel>() {
        @Override
        public PresentationModel createFromParcel(Parcel in) {
            return new PresentationModel(in);
        }

        @Override
        public PresentationModel[] newArray(int size) {
            return new PresentationModel[size];
        }
    };
}