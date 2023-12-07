package org.example;

import java.util.List;

public class Logic {
    //Határozzuk meg a legfiatalabb személyt.
    public static Person youngestShopaholic(List<Person> people){
        int minAge = 99;
        int minIndex = -1;
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getAge() < minAge){
                minAge=people.get(i).getAge();
                minIndex = i;
            }
        }
        return people.get(minIndex);
    }

    //Határozzuk meg a leggazdagabb embert
    public static Person richestPerson(List<Person> people){
        int maxMoney = 0;
        int maxIndex = -1;
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getMoney() > maxMoney){
                maxMoney = people.get(i).getMoney();
                maxIndex = i;
            }
        }
        return people.get(maxIndex);
    }

    //Határozzuk meg a leggazdagabb 30 év alatti embert

    public static Person richestUnderThirty(List<Person> people){
        int maxMoney = 0;
        int maxIndex = -1;
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getMoney() > maxMoney && people.get(i).getAge() < 30){
                maxMoney = people.get(i).getMoney();
                maxIndex = i;
            }
        }
        return people.get(maxIndex);
    }
    //Határoozupublic static Person richestUnderThirty(List<Person> people){

    public static Person poorestBetweenThrityAndFifty(List<Person> people){
        int minMoney = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getAge() < 50 && people.get(i).getAge() >= 30 && people.get(i).getMoney() < minMoney){
                minMoney = people.get(i).getMoney();
                minIndex = i;
            }
        }
        return people.get(minIndex);
    }

    //Hány ember tudná megvenni a legdrágább terméket
    //Hányszor tudná megvásárolni a leggazdagabb ember a legolcsóbb terméket
}
