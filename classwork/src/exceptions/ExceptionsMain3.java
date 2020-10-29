package exceptions;

public class ExceptionsMain3 {
    public static void main(String[] args) {
        System.out.println("Начинаем работать");
        try{
            method1();
        } catch (RuntimeException e){
            System.out.println("У нас ошибка");
        }
        System.out.println("Всё ок, завершаем");
    }


    public static void method1(){
        System.out.println("Начинает работать method1");
        if(1==1){
            try{
                throw new RuntimeException("У нас всё очень плохо");
            } catch (RuntimeException e){
                System.out.println("Обработали ошибку в method1");
            }
        }
        System.out.println("Заканчивает работать method1");
    }
}
