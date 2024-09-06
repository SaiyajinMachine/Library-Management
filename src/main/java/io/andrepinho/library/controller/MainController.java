package io.andrepinho.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class MainController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/")
    public String home() {
        generateDatabaseSchema();
        return "redirect:/books";
    }

    private void generateDatabaseSchema() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db/test-data.sql"));

        try (Connection conn = dataSource.getConnection()) {
            populator.populate(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
