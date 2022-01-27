package com.company.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nНа '.', символы\n");

        System.out.println("Дана строка 'ahb acb aeb aeeb adcb axeb'. Напишите регулярку, которая найдет строки ahb, acb, aeb по шаблону: буква 'a', любой символ, буква 'b'. ");

        Pattern p = Pattern.compile("a.b");
        Matcher m = p.matcher("ahb acb aeb aeeb adcb axeb");

        while (m.find()) {
            System.out.println(m.group(0));
        }

        System.out.println("Дана строка 'aba aca aea abba adca abea'. Напишите регулярку, которая найдет строки abba adca abea по шаблону: буква 'a', 2 любых символа, буква 'a'. ");

        Pattern p1 = Pattern.compile("a..a");
        Matcher m1 = p1.matcher("aba aca aea abba adca abea");

        while (m1.find()) {
            System.out.println(m1.group(0));
        }

        System.out.println(" Дана строка 'aba aca aea abba adca abea'. Напишите регулярку, которая найдет строки abba и abea, не захватив adca.  ");

        Pattern p2 = Pattern.compile("ab.a");
        Matcher m2 = p2.matcher("aba aca aea abba adca abea");

        while (m2.find()) {
            System.out.println(m2.group(0));
        }

        System.out.println("\nНа '+', '*', '?', ()\n");

        System.out.println(" Дана строка 'aa aba abba abbba abca abea'. Напишите регулярку, которая найдет строки aba, abba, abbba по шаблону: буква 'a', буква 'b' любое количество раз, буква 'a'. ");

        Pattern p3 = Pattern.compile("ab+a");
        Matcher m3 = p3.matcher("aa aba abba abbba abca abea");

        while (m3.find()) {
            System.out.println(m3.group(0));
        }

        System.out.println(" Дана строка 'aa aba abba abbba abca abea'. Напишите регулярку, которая найдет строки aa, aba, abba, abbba по шаблону: буква 'a', буква 'b' любое количество раз (в том числе ниодного раза), буква 'a'. ");

        Pattern p4 = Pattern.compile("ab*a");
        Matcher m4 = p4.matcher("aa aba abba abbba abca abea");

        while (m4.find()) {
            System.out.println(m4.group(0));
        }

        System.out.println("Дана строка 'aa aba abba abbba abca abea'. Напишите регулярку, которая найдет строки aa, aba по шаблону: буква 'a', буква 'b' один раз или ниодного, буква 'a'. ");

        Pattern p5 = Pattern.compile("ab?a");
        Matcher m5 = p5.matcher("aa aba abba abbba abca abea");

        while (m5.find()) {
            System.out.println(m5.group(0));
        }

        System.out.println("Дана строка 'aa aba abba abbba abca abea'. Напишите регулярку, которая найдет строки aa, aba, abba, abbba, не захватив abca abea.");

        Pattern p6 = Pattern.compile("ab*a");
        Matcher m6 = p6.matcher("aa aba abba abbba abca abea");

        while (m6.find()) {
            System.out.println(m6.group(0));
        }

        System.out.println("Дана строка 'ab abab abab abababab abea'. Напишите регулярку, которая найдет строки по шаблону: строка 'ab' повторяется 1 или более раз. ");

        Pattern p7 = Pattern.compile("(ab){1,}(\s|\\w+)");
        Matcher m7 = p7.matcher("ab abab abab abababab abea");

        while (m7.find()) {
            System.out.println(m7.group(0));
        }

        System.out.println("\nНа экранировку\n");

        System.out.println("Дана строка 'a.a aba aea'. Напишите регулярку, которая найдет строку a.a, не захватив остальные.");

        Pattern p8 = Pattern.compile("a[.]a");
        Matcher m8 = p8.matcher("a.a aba aea");

        while (m8.find()) {
            System.out.println(m8.group(0));
        }

        System.out.println("Дана строка '2+3 223 2223'. Напишите регулярку, которая найдет строку 2+3, не захватив остальные.");

        Pattern p9 = Pattern.compile("2[+]3");
        Matcher m9 = p9.matcher("2+3 223 2223");

        while (m9.find()) {
            System.out.println(m9.group(0));
        }

        System.out.println(" Дана строка '23 2+3 2++3 2+++3 345 567'. Напишите регулярку, которая найдет строки 2+3, 2++3, 2+++3, не захватив остальные (+ может быть любое количество). ");

        Pattern p10 = Pattern.compile("2([+]){1,}3");
        Matcher m10 = p10.matcher("23 2+3 2++3 2+++3 345 567");

        while (m10.find()) {
            System.out.println(m10.group(0));
        }

        System.out.println("Дана строка '23 2+3 2++3 2+++3 445 677'. Напишите регулярку, которая найдет строки 23, 2+3, 2++3, 2+++3, не захватив остальные. ");

        Pattern p11 = Pattern.compile("2([+]){0,}3");
        Matcher m11 = p11.matcher("23 2+3 2++3 2+++3 345 567");

        while (m11.find()) {
            System.out.println(m11.group(0));
        }

        System.out.println(" Дана строка '*+ *q+ *qq+ *qqq+ *qqq qqq+'. Напишите регулярку, которая найдет строки *q+, *qq+, *qqq+, не захватив остальные. ");

        Pattern p12 = Pattern.compile("[*]q+[+]");
        Matcher m12 = p12.matcher("*+ *q+ *qq+ *qqq+ *qqq qqq+");

        while (m12.find()) {
            System.out.println(m12.group(0));
        }

        System.out.println("Дана строка 'aba accca azzza wwwwa'. Напишите регулярку, которая найдет все строки по краям которых стоят буквы 'a', и заменит каждую из них на '!'. Между буквами a может быть любой символ (кроме a).");
        Pattern p13 = Pattern.compile("a\\w+a");
        Matcher m13 = p13.matcher("aba accca azzza wwwwa");

        while (m13.find()) {
            System.out.println(m13.group(0).replace("a", "!"));
        }
    }
}
