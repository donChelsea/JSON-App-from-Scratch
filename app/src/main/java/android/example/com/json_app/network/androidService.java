package android.example.com.json_app.network;

import android.example.com.json_app.models.Android;
import android.example.com.json_app.models.AndroidList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface androidService {
    @GET("android/jsonandroid/")
    Call<AndroidList> getAndroidList();
}
