package mx.heineken.glup.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.evergage.android.ClientConfiguration;
import com.evergage.android.Evergage;
import com.evergage.android.Screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;

import mx.heineken.glup.R;
import mx.heineken.glup.Utils.Globals;
import mx.heineken.glup.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    Screen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mx.heineken.glup.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        Evergage.initialize(getApplication());
        Evergage evergage = Evergage.getInstance();

        // Recommended to set the authenticated user's ID as soon as known:
        evergage.setUserId("96b01faf-be94-4643-8355-559f0d5395da");

        // Start Evergage with your Evergage Configuration:
        evergage.start(new ClientConfiguration.Builder()
                .account(Globals.Account)
                .dataset(Globals.Dataset)
                .usePushNotifications(false)
                .build());
        screen = evergage.getScreenForActivity(MainActivity.this);
        Button goToCategory = findViewById(R.id.main_btn_goToCateogry);
        EditText searchEt = findViewById(R.id.main_et_search);
        Button searchBtn = findViewById(R.id.main_btn_search);

        goToCategory.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),CategoriesActivity.class));
        });
        searchBtn.setOnClickListener(v -> {
            String searchText = searchEt.getText().toString();
            Log.d("example", searchText);
        });
    }
}