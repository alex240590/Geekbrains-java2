package lesson3;

import java.util.*;

public class MainClass {

    //К заданию 1 создаю массив с набором повторяющихся слов

    public static  String[] words = {"animal", "dog", "cat", "snake", "bird", "rat", "fish", "horse", "mouse", "cow", "pig", "butterfly", "shark", "bear", "moose", "tiger", "lion", "giraffe", "sheep", "wolf", "cow", "cat", "dog", "shark", "tiger"};
    public static void main (String[] args) {

        //К заданию 1 вызываю метод для вывода списка уникальных слов и метод для подсчета уникальных слов

        printUniqueList();
        printCountOfUniqueWords();

        //К заданию 2 вызываю метод инициализации коллекции Phonebook значениями "фамилия", "телефон", "емэйл"
        //Вызываю методы, возвращающие список телефонов и список емэйлов по фамилии
        PhoneBook.initPhoneBook();
        PhoneBook.searchPhoneBySurname("Ivanov");
        PhoneBook.searchEmailBySurname("Ivanov");
        PhoneBook.searchPhoneBySurname("Drozdov");
        PhoneBook.searchEmailBySurname("Drozdov");
    }

    //К заданию 1. Следующий метод printUniqueList выводит список уникальных слов из массива

    public static void printUniqueList() {

        Set<String> setOfWords = new HashSet<>();
        setOfWords.addAll(Arrays.asList(words));
        System.out.println(setOfWords);
    }

    //К заданию 1. Следующий метод printCountOfUniqueWords выводит количество уникальных слов

    public static void printCountOfUniqueWords() {
        HashMap<Integer, String> setOfAllWords = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            setOfAllWords.put(i, words[i]);
        }
        System.out.println(setOfAllWords);

        //В циклах проверяю, есть ли повторяющиеся слова и сколько их

        for (Map.Entry<Integer, String> o2 : setOfAllWords.entrySet()) {
            int k = 0;
            for (Map.Entry<Integer, String> o1 : setOfAllWords.entrySet()) {

                if ((o2.getValue()).equals(o1.getValue())) {
                    k = k+1;
                }
            }
            System.out.println("Количество "+o2.getValue()+" = "+ k);
        }


    }

}
