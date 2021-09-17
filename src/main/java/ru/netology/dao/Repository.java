package ru.netology.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String searchByName = read();

    private static String read() {
        try (InputStream is = new ClassPathResource("searchByName.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("name", "%" + name + "%");
        SqlRowSet sqlRowSet = namedParameterJdbcTemplate.queryForRowSet(searchByName, sqlParameterSource);

        while (sqlRowSet.next()) {
            stringBuilder.append("The product's name: ");
            stringBuilder.append(sqlRowSet.getString("product_name"));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
