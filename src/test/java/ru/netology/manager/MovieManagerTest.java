package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager repo = new MovieManager();
    Movie first = new Movie(1, "Бладшот");
    Movie second = new Movie(2, "Вперед");
    Movie third = new Movie(3, "Отьель Белград");
    Movie fourth = new Movie(4, "Человек-Невидимка");
    Movie fifth = new Movie(5, "Тролли. Мировой тур");
    Movie sixth = new Movie(6, "Номер один");
    Movie seventh = new Movie(7, "Бэтмэн");
    Movie eighth = new Movie(8, "Супермэн");
    Movie ninth = new Movie(9, "Чудоженщина");
    Movie tenth = new Movie(10, "Флэш");
    Movie eleventh = new Movie(11, "Аквамэн");

    @BeforeEach
    public void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        repo.save(sixth);
        repo.save(seventh);
        repo.save(eighth);
        repo.save(ninth);
        repo.save(tenth);
        repo.save(eleventh);
    }

    @Test
    public void should10Movie() {
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReverseLast10Movie() {
        Movie[] expected = new Movie[]{eleventh,tenth, ninth, eighth, seventh, sixth, fifth, fourth, third,second};
        Movie[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReverseLast5Movie() {
        repo.setLimitManager(5);
        Movie[] expected = new Movie[]{eleventh,tenth, ninth, eighth, seventh};
        Movie[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReverseLast1Movie() {
        repo.setLimitManager(1);
        Movie[] expected = new Movie[]{eleventh};
        Movie[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReverseFirst1Movie() {
        repo.setLimitManager(1);
        Movie[] expected = new Movie[]{first};
        Movie[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReverse0Movie() {
        repo.setLimitManager(0);
        Movie[] expected = new Movie[]{};
        Movie[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void should0Movie() {
        repo.setLimitManager(0);
        Movie[] expected = new Movie[]{};
        Movie[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReverse11Movie() {
        repo.setLimitManager(11);
        Movie[] expected = new Movie[]{eleventh,tenth, ninth, eighth, seventh, sixth, fifth, fourth, third,second,first};
        Movie[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void should11Movie() {
        repo.setLimitManager(11);
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Movie[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
}