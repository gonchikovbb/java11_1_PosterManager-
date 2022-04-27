package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.manager.MovieManager;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Movie {
    private int id;
    private String productName;

}