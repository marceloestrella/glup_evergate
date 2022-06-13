package mx.heineken.glup.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.heineken.glup.Models.CategoryModel;
import mx.heineken.glup.Models.ProductModel;

public class Globals {
    public static final String Account = "heinekenintlamer";
    public static final String Dataset = "mexico";
    public static final List<CategoryModel> categories = new ArrayList<>(Arrays.asList(
            new CategoryModel(1, "Cerveza", new ArrayList<>(Arrays.asList(
                    new ProductModel(1, "Tecate 355ml",15.0),
                    new ProductModel(2, "Tecate Light 355ml", 15.0),
                    new ProductModel(3, "Amstel Ultra 355ml", 20.0)
            ))),
            new CategoryModel(2, "Botana", new ArrayList<>(Arrays.asList(
                    new ProductModel(4, "Doritos Icognita 55g", 10),
                    new ProductModel(4, "Doritos Nacho 55g", 10),
                    new ProductModel(4, "Doritos Flaiming Hot 55g", 10),
                    new ProductModel(4, "Doritos Diablo 55g", 10)
            ))),
            new CategoryModel(3, "Licor", new ArrayList<>(Arrays.asList(
                    new ProductModel(1, "Johnnie Walker Black Label 750ml",737.0),
                    new ProductModel(2, "Tequila Maestro Dobel Diamante 700 ml", 765.0),
                    new ProductModel(3, "Mezcal 400 Conejos Jocen 750ml", 535.0)
            ))),
            new CategoryModel(4, "Refresco", new ArrayList<>(Arrays.asList(
                    new ProductModel(4, "Manzanita Lift Golden", 8),
                    new ProductModel(4, "Pepsi Blue", 5),
                    new ProductModel(4, "Kas de toronja", 8),
                    new ProductModel(4, "Delawere Punch", 15)
            )))
    ));
}
