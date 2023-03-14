package org.lessons.java.library;

public class Libro {

//    ATTRIBUTI
    private String titolo;
    private int numeroPagine;
    private String autore;
    private String editore;


//    COSTRUTTORE


    public Libro(String titolo, int numeroPagine, String autore, String editore) {
        textValidator(titolo);
        this.titolo = titolo;
        numberValidator(numeroPagine);
        this.numeroPagine = numeroPagine;
        textValidator(autore);
        this.autore = autore;
        textValidator(editore);
        this.editore = editore;
    }

    //    GETTER SETTER
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        textValidator(titolo);
        this.titolo = titolo;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        numberValidator(numeroPagine);
        this.numeroPagine = numeroPagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        textValidator(autore);
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        textValidator(editore);
        this.editore = editore;
    }

//    METODI
    public void textValidator(String text) throws IllegalArgumentException{
        if(text.isEmpty()){
            throw new IllegalArgumentException("Il testo deve contenere almeno un carattere");
        }
    }
    public void numberValidator(int number) throws IllegalArgumentException{
        if (number <= 0 ){
            throw new IllegalArgumentException("Numero non valido");
        }
    }

    @Override
    public String toString() {
        return "Libro:" +
                "titolo: '" + titolo + '\'' +
                ", numeroPagine: " + numeroPagine +
                ", autore: '" + autore + '\'' +
                ", editore: '" + editore + '\'';
    }
}
