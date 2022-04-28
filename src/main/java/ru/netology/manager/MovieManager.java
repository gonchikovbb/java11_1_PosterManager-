package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

import javax.swing.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MovieManager {

    private int limitManager = 10;
    private Movie[] items = new Movie[0];

    public void save(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] findAll() {
        int resultLength;
        if (limitManager == 10) {
            resultLength = 10;
        } else {
            resultLength = limitManager;
        }
        Movie[] result = new Movie[resultLength];
        System.arraycopy(items, 0, result, 0, resultLength);
        items = result;
        return items;
    }

    public Movie[] getAll() {
        int resultLength;
        if (limitManager == 10) {
            resultLength = 10;
        } else {
            resultLength = limitManager;
        }
        if ( items.length < limitManager ) {
            resultLength = items.length;
        }
        Movie[] result = new Movie[resultLength];

            for (int i = 0; i < result.length; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
                // заполняем result из массива что лежит в поле
                // в обратном порядке
            }
            return result;

    }
}
