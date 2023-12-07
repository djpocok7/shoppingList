package org.example;

public class Person {
    private String name;
    private Integer age;
    private Integer money;
    Product[] cart;
    Product[] boughtProducts;

    public Person(String name, Integer age, Integer money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getMoney() {
        return money;
    }
    public void pay(Integer money) {
        this.money -= money;
    }

    public void checkout() {
        //Ez fogja megszámolni, hogy hány elem fog bekerülni a megvásárolt termékekbe
        int cnt = 0;
        //Létrehozunk egy másolatot a pénzükről
        int currentMoney = this.money;
        //Létrehozunk egy tömböt, amely tartalmazni fogja a kosarunkban szereplő megvásárolandó termékek indexét
        Integer[] productIndexes = new Integer[cart.length];
        //For ciklussal végigmegyünk a kosarunk összes elemén
        //a
        for (int i = 0; i < this.cart.length; i++) {
            //Ha van elég pénzünk, akkor kiválasztjuk a terméket és elmentjük az indexét
            if(currentMoney - cart[i].getProductPrice() > 0){
                //Itt mentjük el a termék kosárban elfoglalt indexét
                productIndexes[cnt] = i;
                //Növeljük a termékek számát
                cnt++;
                //Levonjuk a pénzt
                currentMoney-=cart[i].getProductPrice();
            }
        }
        //Létrehozzuk a megfelelő méretű tömböt a megvásárolt termékeknek
        this.boughtProducts = new Product[cnt];
        //FOR ciklussal végigmegyünk a megvásárolt termékek méretén (ami ebben az esetben, a megvásárolható termékek száma)
        for (int i = 0; i < boughtProducts.length; i++) {
            //Hozzáadjuk a termékeket a megvásárolt termékek tömbünkhöz.
            //Úgy, hogy a kosarunk (cart) termékIndexelő tömb i. elemére hivatkozunk (ami szintén egy index szám lesz)
            boughtProducts[i] = cart[productIndexes[i]];
        }
        pay(this.money-currentMoney);
    }
}
