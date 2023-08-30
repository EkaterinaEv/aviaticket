package ru.netology.aviaticket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;


public class AviaSoulsTest {
    Ticket t1 = new Ticket("Екатеринбург", "Новосибирск", 6000, 12, 17);
    Ticket t2 = new Ticket("Москва", "Санкт - Петербург", 4500, 13, 16);
    Ticket t3 = new Ticket("Москва", "Санкт - Петербург", 7000, 14, 15);
    Ticket t4 = new Ticket("Волгоград", "Пермь", 8000, 9, 13);
    Ticket t5 = new Ticket("Москва", "Санкт - Петербург", 5500, 9, 13);

    @Test
    public void searchTest() {
        AviaSouls searchT = new AviaSouls();
        searchT.add(t1);
        searchT.add(t2);
        searchT.add(t3);
        searchT.add(t4);
        searchT.add(t5);


        Ticket[] expected = {t2, t5, t3};
        Ticket[] actual = searchT.search("Москва", "Санкт - Петербург");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchNoTicketTest() {
        AviaSouls searchT = new AviaSouls();
        searchT.add(t1);
        searchT.add(t2);
        searchT.add(t3);
        searchT.add(t4);
        searchT.add(t5);


        Ticket[] expected = {};
        Ticket[] actual = searchT.search("Москва", "Пермь");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchOneTicketTest() {
        AviaSouls searchT = new AviaSouls();
        searchT.add(t1);
        searchT.add(t2);
        searchT.add(t3);
        searchT.add(t4);
        searchT.add(t5);


        Ticket[] expected = {t4};
        Ticket[] actual = searchT.search("Волгоград", "Пермь");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByTicketTest() {
        AviaSouls searchAndSortByT = new AviaSouls();
        searchAndSortByT.add(t1);
        searchAndSortByT.add(t2);
        searchAndSortByT.add(t3);
        searchAndSortByT.add(t4);
        searchAndSortByT.add(t5);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = searchAndSortByT.searchAndSortBy("Москва",
                "Санкт - Петербург", comparator);

        Ticket[] expected = {t3, t2, t5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByOneTicketTest() {
        AviaSouls searchAndSortByT = new AviaSouls();
        searchAndSortByT.add(t1);
        searchAndSortByT.add(t2);
        searchAndSortByT.add(t3);
        searchAndSortByT.add(t4);
        searchAndSortByT.add(t5);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual =
                searchAndSortByT.searchAndSortBy("Волгоград", "Пермь", comparator);

        Ticket[] expected = {t4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByNoTicketTest() {
        AviaSouls searchAndSortByT = new AviaSouls();
        searchAndSortByT.add(t1);
        searchAndSortByT.add(t2);
        searchAndSortByT.add(t3);
        searchAndSortByT.add(t4);
        searchAndSortByT.add(t5);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = searchAndSortByT.searchAndSortBy("Москва",
                "Пермь", comparator);

        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

}