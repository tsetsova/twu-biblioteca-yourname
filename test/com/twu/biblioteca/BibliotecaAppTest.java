package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BibliotecaAppTest {

    private TestConsole console = new TestConsole();
    private BibliotecaApp biblioteca = new BibliotecaApp(console);

    @Test
    public void DisplaysAGreetingMessage() {
        biblioteca.greet();
        assertEquals("Welcome to Biblioteca", console.printed());
    }

    @Test
    public void DisplaysAMenu() {
        biblioteca.menu();
        assertEquals("Menu:\n " +
                     "1: List books\n" +
                     "Write the number of the option you want displayed.", console.printed());
    }

    @Test
    public void DisplaysAListOfBooks() {
        biblioteca.list();
        assertEquals("The Well-Grounded Rubyist | David A. Black | 2009\n" +
                     "Clean Code | Robert Cecil Martin | 2008\n" +
                     "The Software Crafstman | Sandro Mancuso | 2014", console.printed());
    }


    private class TestConsole implements Console{
        private String printed = "";
        public void printToScreen(String message) {
            printed += message;
        }
        public String printed() {
            return printed;
        }
    }
}
