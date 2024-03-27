/*
Задача 2.
*Дополнительная задача: Переработать метод балансировки корзины товаров
cardBalancing() с использованием Stream API
 */

package homework2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    //endregion

    /**
     * БАЛАНСИРОВКА КОРЗИНЫ С ПОМОЩЬЮ STREAM API
     */
    public void cardBalancing()
    {
        List<T> proteins = foodstuffs // фильтрация корзины по протеинам
                .stream()
                .filter(Food::getProteins)
                .toList();
        List<T> fats = foodstuffs // фильтрация корзины по жирам
                .stream()
                .filter(Food::getFats)
                .toList();
        List<T> carbohydrates = foodstuffs // фильтрация корзины по углеводам
                .stream()
                .filter(Food::getCarbohydrates)
                .toList();

        if (!proteins.isEmpty() && !fats.isEmpty() && !carbohydrates.isEmpty())
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        Collection<T> addStuffs = market.getThings(clazz);
        if (proteins.isEmpty()){ // добавляем продукты с белками
            foodstuffs.add((addStuffs.stream().filter(Food::getProteins).toList()).get(0));
        }
        if (fats.isEmpty()){ // добавляем продукты с жирами
            foodstuffs.add((addStuffs.stream().filter(Food::getFats).toList()).get(0));
        }
        if (carbohydrates.isEmpty()){ // добавляем продукты с углеводами
            foodstuffs.add((addStuffs.stream().filter(Food::getCarbohydrates).toList()).get(0));
        }

        System.out.println("Корзина сбалансирована по БЖУ.");
    }

    /**
     * Балансировка корзины
     */
/*    public void cardBalancing()
    {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        for (var food : foodstuffs)
        {
            if (!proteins && food.getProteins())
                proteins = true;
            else
            if (!fats && food.getFats())
                fats = true;
            else
            if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        for (var thing : market.getThings(clazz))
        {
            if (!proteins && thing.getProteins())
            {
                proteins = true;
                foodstuffs.add(thing);
            }
            else if (!fats && thing.getFats())
            {
                fats = true;
                foodstuffs.add(thing);
            }
            else if (!carbohydrates && thing.getCarbohydrates())
            {
                carbohydrates = true;
                foodstuffs.add(thing);
            }
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }*/



    /**
     * Получить список продуктов в корзине
     * @return
     */
    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs(){
        /*int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");
         */
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));

    }

}
