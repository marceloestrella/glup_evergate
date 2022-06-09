package mx.heineken.glup.Activities;

import android.os.Bundle;

import com.evergage.android.ClientConfiguration;
import com.evergage.android.Evergage;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import mx.heineken.glup.Utils.Globals;
import mx.heineken.glup.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

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
    }
}