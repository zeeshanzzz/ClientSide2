package com.softec.clientside.model.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @Inject
    public User() {
    }

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_first")
    @Expose
    private String userFirst;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("user_phone")
    @Expose
    private String userPhone;
    @SerializedName("user_uid")
    @Expose
    private String userUid;
    @SerializedName("user_gender")
    @Expose
    private String userGender;
    @SerializedName("Password")
    @Expose
    private String Password;
}