package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BibliotecaTest {

    private TestConsole console = new TestConsole();
    private Biblioteca biblioteca = new Biblioteca(console);

    @Test
    public void DisplaysAGreetingMessage() {
        biblioteca.greet();
        assertEquals("Welcome to Biblioteca\n", console.printed());
    }

    @Test
    public void DisplaysAMenu() {
        biblioteca.menu();
        assertEquals("Menu:\n" +
                     "1: List books\n" +
                     "2: Quit\n" +
                     "Write the number of the option you want displayed.\n", console.printed());
    }

    @Test
    public void CanChooseAnOptionFromAMenu() {
        biblioteca.chooseOption("1");

        assertEquals("The Well-Grounded Rubyist | David A. Black | 2009\n" +
                "Clean Code | Robert Cecil Martin | 2008\n" +
                "The Software Crafstman | Sandro Mancuso | 2014\n", console.printed());
    }

    @Test
    public void ReturnsAnErrorMessageIfMenuOptionIsInvalid() {
        biblioteca.chooseOption("Invalid");

        assertEquals("Please choose a valid menu option!\n" +
                     "Menu:\n" +
                     "1: List books\n" +
                     "2: Quit\n" +
                     "Write the number of the option you want displayed.\n", console.printed());
    }

    @Test
    public void DisplaysAnExitMessageWhenUserQuits() {
        biblioteca.chooseOption("2");

        assertEquals("Goodbye! Enjoy your books.\n", console.printed());
    }

}