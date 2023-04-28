public class CatFight2 {

        public static class Cat {
            private String name;
            private int age;
            private int weight;
            private int strength;

            public Cat(String name1,int age1,int weight1, int strength1){
                name = name1;
                age = age1;
                weight = weight1;
                strength = strength1;
            }

            public boolean fight(Cat anotherCat) {
                int x = 0;
                int y = 0;

                if (this.age > anotherCat.age) {
                    x++;
                } else if (this.age < anotherCat.age){
                    y++;
                }
                if (this.weight > anotherCat.weight) {
                    x++;
                }else if (this.weight < anotherCat.weight){
                    y++;
                }
                if (this.strength > anotherCat.strength) {
                    x++;
                }else if (this.strength < anotherCat.strength){
                    y++;
                }
                return x > y;
            }


            public static void main(String[] args) {

                Cat vaska = new Cat("Vaska",10,1,5);
                Cat barsik = new Cat("Barsik",1,1,5);
                Cat tom = new Cat("Tom",4,6,34);

                boolean firstFight = vaska.fight(barsik);
                boolean secondFight = tom.fight(barsik);
                boolean thirdFight = vaska.fight(tom);

                System.out.println("Васька протоив барсика - "+ firstFight);
                System.out.println("Том против барсика - "+ secondFight);
                System.out.println("Васька против тома - "+ thirdFight);

            }

        }


}
