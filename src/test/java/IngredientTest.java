import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.assertj.core.api.SoftAssertions;


import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    public IngredientType type;
    public String name;
    public float price;
    public Ingredient ingredient;

    SoftAssertions softAssertions;



    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100f},
                {FILLING, "cutlet", 100f}
        };
    }
    @Test
    public void testIngredient(){
        softAssertions = new SoftAssertions();
        ingredient =  new Ingredient(type, name, price);
        softAssertions.assertThat(price).isEqualTo(ingredient.getPrice());
        softAssertions.assertThat(name).isEqualTo(ingredient.getName());
        softAssertions.assertThat(type).isEqualTo(ingredient.getType());
        softAssertions.assertAll();

    }

}
