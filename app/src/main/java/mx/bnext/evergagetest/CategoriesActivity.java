package mx.bnext.evergagetest;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import mx.bnext.evergagetest.databinding.ActivityCategoriesBinding;

public class CategoriesActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private final int CategoryId = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mx.bnext.evergagetest.databinding.ActivityCategoriesBinding binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

    }
}