##Runnable interface
code:
  
import java.util.*;
class WordThread implements Runnable {
    String text;
    WordThread(String text) { this.text = text; }
    public void run() {
        String[] words = text.split("\\s+");
        System.out.println("\nWords:");
        for (String w : words) {
            System.out.println(w);
            try { Thread.sleep(2000); } catch (InterruptedException e) { /* ignore */ }
        }
    }
}
class VowelThread implements Runnable {
    String text;
    VowelThread(String text) { this.text = text; }
    public void run() {
        System.out.println("\nVowels:");
        for (char c : text.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                System.out.println(c);
                try { Thread.sleep(2000); } catch (InterruptedException e) { /* ignore */ }
            }
        }
    }
}
public class RunnableExample{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("URK24CS6006 - PUJITHA");
        System.out.println("\nEnter a paragraph:");
        String text = sc.nextLine();
        Thread t1 = new Thread(new WordThread(text));
        Thread t2 = new Thread(new VowelThread(text));
        t1.start();
        try {
            t1.join(); 
        } catch (InterruptedException e) { }
        t2.start();
        try { t2.join(); } catch (InterruptedException e) { }
    }
}



###extending Thread class
code:

import java.util.*;
class EvenThread extends Thread {
    int[] arr;
    EvenThread(int[] arr) { this.arr = arr; }
    public void run() {
        System.out.println("\nEven numbers:");
        for (int n : arr) {
            if (n % 2 == 0) {
                System.out.println(n);
                try { Thread.sleep(2000); } catch (InterruptedException e) { }
            }
        }
    }
}
class OddThread extends Thread {
    int[] arr;
    OddThread(int[] arr) { this.arr = arr; }
    public void run() {
        System.out.println("\nOdd numbers:");
        for (int n : arr) {
            if (n % 2 != 0) {
                System.out.println(n);
                try { Thread.sleep(2000); } catch (InterruptedException e) { }
            }
        }
    }
}
public class ThreadExampleOrdered {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("URK24CS6006 - PUJITHA");
        int[] arr = new int[10];
        System.out.println("\nEnter 10 numbers (space separated):");
        for (int i = 0; i < 10; i++) arr[i] = sc.nextInt();
        EvenThread e = new EvenThread(arr);
        OddThread o  = new OddThread(arr);
        e.start();
        try { e.join(); } catch (InterruptedException ex) { }
        o.start();
        try { o.join(); } catch (InterruptedException ex) { }
    }
}



##extending Thread class 
code:
  
import java.util.*;
class TableThread extends Thread {
    int n;
    TableThread(int n) { this.n = n; }
    public void run() {
        System.out.println("\nMultiplication Table of " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
            try { Thread.sleep(2000); } catch (InterruptedException e) { }
        }
    }
}
class DivisorThread extends Thread {
    int n;
    DivisorThread(int n) { this.n = n; }
    public void run() {
        System.out.println("\nDivisors of " + n + ":");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                try { Thread.sleep(2000); } catch (InterruptedException e) { }
            }
        }
    }
}
public class NumberThreads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("URK24CS6006 - PUJITHA");
        System.out.print("\nEnter a number: ");
        int n = sc.nextInt();

        TableThread t1 = new TableThread(n);
        DivisorThread t2 = new DivisorThread(n);

        t1.start();
        try { t1.join(); } catch (InterruptedException e) { }

        t2.start();
        try { t2.join(); } catch (InterruptedException e) { }
    }
}

