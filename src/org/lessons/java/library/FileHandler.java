package org.lessons.java.library;

import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);

        System.out.println("Quanti libri vuoi inserire?");
        int numeriScelti = Integer.parseInt(userScanner.nextLine());
        Libro[] booklist = new Libro[numeriScelti];

        try {
            for (int i = 0; i <numeriScelti ; i++) {
                System.out.println("Titolo del libro: ");
                String titolo = userScanner.nextLine();
                System.out.println("Numero di pagine: ");
                int numeroPagine = Integer.parseInt(userScanner.nextLine());
                System.out.println("Nome dell'autore: ");
                String nomeAutore = userScanner.nextLine();
                System.out.println("Nome dell'editore: ");
                String nomeEditore = userScanner.nextLine();

                Libro book = new Libro(titolo,numeroPagine,nomeAutore,nomeEditore);
                booklist[i] = book;
                System.out.println(Arrays.toString(booklist));
            }
        } catch (Exception e){
            System.out.println("Errore durante la compilazione dei campi");
        } finally {
            userScanner.close();
        }


    }
}
