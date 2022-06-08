package mx.bnext.evergagetest;

import android.os.Bundle;

import com.evergage.android.ClientConfiguration;
import com.evergage.android.Evergage;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import mx.bnext.evergagetest.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mx.bnext.evergagetest.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
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