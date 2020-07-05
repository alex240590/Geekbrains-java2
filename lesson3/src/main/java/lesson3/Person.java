package lesson3;

import java.util.ArrayList;
import java.util.Arrays;

//К заданию 2. В классе Person задаю списки фамилий, телефонов и емэйлов для последующего использования в классе Phonebook

public class Person {

      public static String[] surnames = {"Ivanov", "Petrov", "Sidorov", "Ivanov", "Drozdov", "Vorobiov", "Petrov"};
      public static ArrayList<String> phones = new ArrayList<>(Arrays.asList("12345678901", "23456789012", "34567890123", "45678901234", "56789012345", "67890123456", "78901234567"));
      public static ArrayList<String> emails = new ArrayList<>(Arrays.asList("Iv1@gb.ru", "Pe1@gb.ru", "Si@gb.ru", "Iv2@gb.ru", "Dr@gb.ru", "Vo@gb.ru", "Pe2@gb.ru"));
}
