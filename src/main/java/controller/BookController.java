package controller;

import extra.MultiTenantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    @GetMapping("/{id}")
    public String connectToDb(@PathVariable String id) {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/books");
        dataSourceProperties.setUsername("nik_book");
        dataSourceProperties.setPassword("password");
        MultiTenantManager multiTenantManager = new MultiTenantManager(dataSourceProperties);
        try {
            multiTenantManager.addTenant("2", "jdbc:mysql://localhost:3306/books", "nik_book", "password");
            multiTenantManager.setCurrentTenant(id);


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
