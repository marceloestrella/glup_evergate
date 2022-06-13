package mx.heineken.glup.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;

import com.evergage.android.Evergage;
import com.evergage.android.Screen;
import com.evergage.android.promote.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import mx.heineken.glup.Adapter.ProductAdapter;
import mx.heineken.glup.Models.CategoryModel;
import mx.heineken.glup.Models.ProductModel;
import mx.heineken.glup.R;
import mx.heineken.glup.Utils.Globals;

public class ProductsActivity extends AppCompatActivity {
    Screen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        RecyclerView productRv = findViewById(R.id.products_rv_products);
        screen = Evergage.getInstance().getScreenForActivity(ProductsActivity.this);

        int categoryId = getIntent().getIntExtra("CategoryId",0);
        CategoryModel categoryModel = Globals.categories.stream().filter(evt -> evt.getId() == categoryId).findFirst().orElse(null);
        List<ProductModel> productModels = new ArrayList<>();

        if(categoryModel != null && categoryModel.getProducts()!= null){
            productModels.addAll(categoryModel.getProducts());
        }

        ProductAdapter adapter = new ProductAdapter(productModels, model -> {
            if(model != null){
                Product product = new Product(String.valueOf(model.getId()));
                product.name = model.getName();
                product.price = model.getPrice();
                screen.viewItem(product);
                Log.d("example", model.getName());
            }
        });
        productRv.setLayoutManager(new LinearLayoutManager(ProductsActivity.this));
        productRv.setAdapter(adapter);
    }
}