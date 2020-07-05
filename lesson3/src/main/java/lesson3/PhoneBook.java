package lesson3;

import java.util.*;

public class PhoneBook {

    //К заданию 2. Создаю HashMap с ключом по фамилии и значением пары телефон+емэйл

    public static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void initPhoneBook() {

        //В цикле прохожу по спискам из класса Person и копирую их значения в HashMap

        for (int i = 0; i < Person.phones.size(); i++) {

            //Использую коллекцию phoneEmails для создания пары телефон+емэйл

            ArrayList<String> phoneEmails = new ArrayList<>(Arrays.asList("0", "1"));

            phoneEmails.set(0, Person.phones.get(i));
            phoneEmails.set(1, Person.emails.get(i));
            phoneBook.put(Person.surnames[i], phoneEmails);

            //Для однофамильцев приписываю их пары телефон+емэйл к значению из первого ключа с такой фамилией

            for (int k=i-1; k>=0; k--) {
                    if ((Person.surnames[i]).equals(Person.surnames[k])){
                        phoneEmails.add(Person.phones.get(k));
                        phoneEmails.add(Person.emails.get(k));
                        phoneBook.put(Person.surnames[i], phoneEmails);
                    }
                }

        }
        System.out.println(phoneBook);
    }

    //Метод searchPhoneBySurname(String a) выводит список телефонов для однофамильцев по переданной в метод фамилии

    public static void searchPhoneBySurname(String a) {
        ArrayList<String> phoneList = new ArrayList<>();
        int sizePhoneList = (phoneBook.get(a)).size();
        for (int i=0; i<sizePhoneList; i=i+2) {
            phoneList.add((phoneBook.get(a)).get(i));
        }
        System.out.println(a+" phones: "+phoneList);
        }

        //Метод searchEmailBySurname (String b) выводит список емэйлов для однофамильцев по переданной в метод фамилии

        public static void searchEmailBySurname (String b){
            ArrayList<String> emailList = new ArrayList<>();
            int sizeEmailList = (phoneBook.get(b)).size();
            for (int i=1; i<sizeEmailList; i=i+2) {
                emailList.add((phoneBook.get(b)).get(i));
            }
            System.out.println(b+" emails: "+emailList);
        }

    }
