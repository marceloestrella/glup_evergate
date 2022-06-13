package mx.heineken.glup.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.evergage.android.Evergage;
import com.evergage.android.Screen;
import com.evergage.android.promote.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.heineken.glup.Models.CategoryModel;
import mx.heineken.glup.R;
import mx.heineken.glup.Utils.Globals;
import mx.heineken.glup.databinding.ActivityCategoriesBinding;

public class CategoriesActivity extends AppCompatActivity {
    Screen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mx.heineken.glup.databinding.ActivityCategoriesBinding binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        Button cervezas = findViewById(R.id.categories_btn_cerveza);//1
        Button botana = findViewById(R.id.categories_btn_Botana);//2
        Button licor = findViewById(R.id.categories_btn_Licor);//3
        Button refresco = findViewById(R.id.categories_btn_Refresco);//4
        ActionBar actionBar = getSupportActionBar();
        screen = Evergage.getInstance().getScreenForActivity(CategoriesActivity.this);

        if(actionBar != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cervezas.setOnClickListener(v -> {
            goToProducts(1);
        });

        botana.setOnClickListener(v ->{
            goToProducts(2);
        });

        licor.setOnClickListener(v ->{
            goToProducts(3);
        });

        refresco.setOnClickListener(v ->{
            goToProducts(4);
        });
    }

    private void goToProducts(int categoryId){
        CategoryModel categoryModel = Globals.categories.stream().filter(evt -> evt.getId() == categoryId).findFirst().orElse(null);
        if(categoryModel != null){
            Category category = new Category(String.valueOf(categoryModel.getId()));
            category.name = categoryModel.getName();
            screen.viewCategory(category);
            Log.d("example", categoryModel.getName());
            Intent intent = new Intent(CategoriesActivity.this, ProductsActivity.class);
            intent.putExtra("CategoryId", categoryId);
            startActivity(intent);
        }
    }
}