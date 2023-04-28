public class CatFight {
    private String name;
    private int age;
    private int weight;
    private int strength;

    public CatFight (String name, int age, int weight, int strength) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public static void main(String[] args) {
        CatFight cat1 = new CatFight ("Барсик", 12, 9,10);
        CatFight cat2 = new CatFight("Мурзик", 5, 12, 10);
        CatFight cat3 = new CatFight ("Марк", 7, 10, 8);


        System.out.println(cat1.fight( cat2));
    }

    public boolean fight (CatFight anotherCat){

        int x = 0;
        int y = 0;
        if (this.age > anotherCat.age) x=x+1;
        else y = y+1;
        if (this.weight > anotherCat.weight) x=x+1;
        else y=y+1;
        if (this.strength > anotherCat.strength) x=x+1;
        else y=y+1;

        if (x>y) return true;
        else return false;
    }
}
