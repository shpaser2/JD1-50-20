package exceptions;

import oop.Man;

import java.util.ArrayList;
import java.util.List;

//shows that stack is printed partly.
public class ExceptionsMain2 {
    public static void main(String[] args) {
        selfCall();
    }

    public static void selfCall(){
        selfCall();
    }
}
