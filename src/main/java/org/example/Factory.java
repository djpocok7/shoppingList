package org.example;

import java.util.List;
import java.util.Random;

public class Factory {

    //Emberek létrehozása
    public static void generatePersonList(List<String> input, List<Person> people){
        for (int i = 0; i < input.size(); i++) {
            String[] splitted = input.get(i).split(" - ");
            //név
            String name = splitted[0];
            //életkor
            Integer age = Integer.parseInt(splitted[1]);
            //pénz
            Integer money = Integer.parseInt(splitted[2].replace("$", ""));
            Person onePerson = new Person(name, age, money);
            people.add(onePerson);
        }
    }

    //Termékek létrehozása
    //3.	Készítsen metódust az első feladathoz, amely feldolgozza a fájlok egyes sorait.

    public static void generateProductList(List<String> input, List<Product> productList){
        for (int i = 0; i < input.size(); i++) {
            String[] splitted = input.get(i).split(" - ");
            String productName = splitted[0];
            Integer productPrice = Integer.parseInt(splitted[1].replace("$", ""));
            Product oneProduct = new Product(productName, productPrice);
            productList.add(oneProduct);
        }
    }

    //METÓDUS
    //1. for ciklus -- people.size()
    //2. Random , ami 3-10 között generál egy számot
    //3. while ciklus - addig választunk random terméket, amíg a 2. pontban generált számunkat el nem érjük, vagy elfogy a pénzünk
    //3/2. for 2. pontban kapott random számig
    //4. For-cikluson belül újra generáltatunk egy random számot, ami majd a termék indexe lesz.

    public static void shoppingCart(List<Person> people, List<Product> products){
        for (int i = 0; i < people.size(); i++) {
            Random rnd = new Random();
            //3-10 között generáljon nekünk egy számot, hogy ki mennyi terméket rakjon a kosárba
            int productCount = rnd.nextInt(3,10);
            people.get(i).cart = new Product[productCount];
            for (int j = 0; j < productCount; j++) {
                Product randomProduct = products.get(rnd.nextInt(0, products.size()));
                people.get(i).cart[j] = randomProduct;
            }
        }
    }
}
