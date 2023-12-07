package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Itt fogjuk eltárolni a beolvasás során keletkezett String line-okat egymás alá
        List<String> input = new ArrayList<>();
        //Feldolgozás után ebben lesznek az emberek
        List<Person> people = new ArrayList<>();
        //Feldolgozás után ebben lesznek a termékek
        List<Product> productList = new ArrayList<>();

        try {
            File myFile1 = new File("people.txt");
            File myFile2 = new File("products.txt");
            Scanner myScanner = new Scanner(myFile1);
            while(myScanner.hasNextLine()){
                String line = myScanner.nextLine();
                input.add(line);
            }
            Factory.generatePersonList(input,people);
            input = new ArrayList<>();
            myScanner = new Scanner(myFile2);
            while(myScanner.hasNextLine()){
                String line = myScanner.nextLine();
                input.add(line);
            }
            Factory.generateProductList(input,productList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Kiválasztjuk, hogy az egyes emberek mit szeretnének megvenni
        Factory.shoppingCart(people,productList);

        //Kiírjuk, hogy ki a legfiatalabb
        Person p = Logic.youngestShopaholic(people);
        System.out.println(p.getName() + " - " + p.getAge());
        //Kiírjuk, hogy ki a leggazdagabb
        p = Logic.richestPerson(people);
        System.out.println(p.getName() + " - " + p.getMoney());
        //Kiírjuk, hogy ki a leggazdagabb 30 év alatti
        p = Logic.richestUnderThirty(people);
        System.out.println(p.getName() + " - " + p.getAge() + " - " + p.getMoney());
        //Kiírjuk, hogy ki a legszegényebb 30 és 50 év közötti
        p = Logic.poorestBetweenThrityAndFifty(people);
        System.out.println(p.getName() + " - " + p.getAge() + " - " + p.getMoney());

        //Mindenki megvásárolja az általa kiválasztott termékek közül azt, amire van pénze
        for (Person onePerson:people) {
            onePerson.checkout();
        }
        //Kiírjuk, hogy az egyes emberek mit vettek
        Kiiras(people);
    }

    private static void Kiiras(List<Person> people){
        for (Person onePerson : people) {
            System.out.println(onePerson.getName() + " - " + onePerson.getMoney() + "$");
            for (Product oneProduct : onePerson.boughtProducts) {
                System.out.println(" - " + oneProduct.getProductName() + " - " + oneProduct.getProductPrice() +"$");
            }
        }
    }
}