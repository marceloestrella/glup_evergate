package mx.heineken.glup.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mx.heineken.glup.databinding.ActivityCategoriesBinding;

public class CategoriesActivity extends AppCompatActivity {

    private final int CategoryId = 6;
    //private List<>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mx.heineken.glup.databinding.ActivityCategoriesBinding binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

    }
}