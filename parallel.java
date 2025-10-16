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
