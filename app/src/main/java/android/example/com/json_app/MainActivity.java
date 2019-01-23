package android.example.com.json_app;

import android.example.com.json_app.controller.AndroidAdapter;
import android.example.com.json_app.models.Android;
import android.example.com.json_app.models.AndroidList;
import android.example.com.json_app.network.RetrofitSingleton;
import android.example.com.json_app.network.androidService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        Retrofit retrofit = new RetrofitSingleton().getInstance();
        androidService androidService = retrofit.create(androidService.class);
        Call<AndroidList> androidCall = androidService.getAndroidList();
        androidCall.enqueue(new Callback<AndroidList>() {
                    @Override
                    public void onResponse(Call<AndroidList> call, Response<AndroidList> response) {
                        List<Android> newArrayList = response.body().getAndroids();
                        AndroidAdapter adapter = new AndroidAdapter(newArrayList);
                        recyclerView.setAdapter(adapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                    }

                    @Override
                    public void onFailure(Call<AndroidList> call, Throwable t) {
                        Log.d("JSON APP", "onResponse: " + t.toString());
                    }
                });
    }
}
