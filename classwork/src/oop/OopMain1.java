package oop;

public class OopMain1 {
    
    public static void main(String[] args) {
        Man man1 = new Man();
        Man man2 = new Man("Антон", 15);
//        var man2 = new Man();   //так тоже можно, но это не популярно
        
        //между следующими println разницы почти нет, кроме проверки man == null
//        System.out.println(man1);
//        System.out.println(man2.toString());
    
        System.out.println(man1.getName());
        System.out.println(man1.getHairLength());
        System.out.println(man1.getName() + ":" + man1.getHairLength());
        System.out.println(man1.getHairLength() + ":" + man1.getName());
        System.out.println(man2.toString());
    }
}
