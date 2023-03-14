package org.lessons.java.library;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {
    private final static String FILEPATH = "./books.txt";
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        int numeriScelti = 0;
        boolean validInput = false;

        while (!validInput || numeriScelti <= 0){
            System.out.println("Quanti libri vuoi inserire?");
            try{
                numeriScelti = Integer.parseInt(userScanner.nextLine());
                validInput = true;
            } catch (Exception e){
                System.out.println("Input non valido");
            }
        }

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
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        } finally {
            userScanner.close();
        }

//        SCRITTURA SU FILE

        FileWriter myWriter = null;
        try{
            myWriter = new FileWriter(FILEPATH, true);
            for (Libro book:booklist) {
                if (book != null){
                    myWriter.write(book + "\n");
                }
            }
        }  catch (IOException e) {
            System.out.println("Errore durante la creazione");
        } finally {
            if (myWriter != null){
                try {
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("Impossibile chiudere");
                }
            }
        }

//        LEGGO DAL FILE

        Scanner textFileReader = null;
        try {
            textFileReader = new Scanner(new FileReader(FILEPATH));
            System.out.println("\n" + "Elenco libri inseriti: ");
            while(textFileReader.hasNext()){
                String data = textFileReader.nextLine();
                System.out.println(data);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Errore di lettura");
        } finally {
            if (textFileReader != null) {
                textFileReader.close();
            }
        }

    }
}
