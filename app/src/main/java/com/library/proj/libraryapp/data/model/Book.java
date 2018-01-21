package com.library.proj.libraryapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karo2 on 2018-01-14.
 */

public class Book implements Parcelable {

    @SerializedName("syg_ms")
    @Expose
    private String facultySignature;
    @SerializedName("syg_bg")
    @Expose
    private String mainSignature;
    @SerializedName("ozn_opdow")
    @Expose
    private String responsibility;
    @SerializedName("tytul")
    @Expose
    private String title;
    @SerializedName("tom")
    @Expose
    private String volume;
    @SerializedName("rok")
    @Expose
    private Integer year;
    @SerializedName("isbn_issn")
    @Expose
    private String isbnWithIssn;
    @SerializedName("typ")
    @Expose
    private String type;
    @SerializedName("dostepnosc")
    @Expose
    private String availability;
    @SerializedName("kategoria")
    @Expose
    private List<Category> categories = new ArrayList<>();

    public Book() {
        //empty constructor
    }

    protected Book(Parcel in) {
        facultySignature = in.readString();
        mainSignature = in.readString();
        responsibility = in.readString();
        title = in.readString();
        volume = in.readString();
        if (in.readByte() == 0) {
            year = null;
        } else {
            year = in.readInt();
        }
        isbnWithIssn = in.readString();
        type = in.readString();
        availability = in.readString();
        in.readList(categories, null);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getFacultySignature() {
        return facultySignature;
    }

    public String getMainSignature() {
        return mainSignature;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public String getTitle() {
        return title;
    }

    public String getVolume() {
        return volume;
    }

    public Integer getYear() {
        return year;
    }

    public String getIsbnWithIssn() {
        return isbnWithIssn;
    }

    public String getType() {
        return type;
    }

    public String getAvailability() {
        return availability;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(facultySignature);
        parcel.writeString(mainSignature);
        parcel.writeString(responsibility);
        parcel.writeString(title);
        parcel.writeString(volume);
        if (year == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(year);
        }
        parcel.writeString(isbnWithIssn);
        parcel.writeString(type);
        parcel.writeString(availability);
        parcel.writeList(categories);
    }
}
