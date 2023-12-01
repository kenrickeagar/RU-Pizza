package com.example.cs213_project_5;
/**
 * Define Topping Enum Class
 * @author Kenrick Eagar, Zachary Derish
 */
public enum Topping {
    SAUSAGE, PEPPERONI, GREEN_PEPPERS, ONION, MUSHROOM, BLACK_OLIVE,
    BEEF, HAM, SHRIMP, SQUID, CRAB_MEATS, PINEAPPLE, PICKLES, CHICKEN, FRIED_EGG, BACON, SPINACH, HAMBURGER;

    /**
     * Get list of all toppings in enum class
     * @return array of Topping enum objects
     */
    public Topping[] getList(){
        return new Topping[]{SAUSAGE, PEPPERONI, GREEN_PEPPERS, ONION, MUSHROOM, BLACK_OLIVE,
            BEEF, HAM, SHRIMP, SQUID, CRAB_MEATS, PINEAPPLE, PICKLES, CHICKEN, FRIED_EGG, BACON, SPINACH, HAMBURGER};
    }



}
