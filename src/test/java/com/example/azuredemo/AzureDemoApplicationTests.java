package com.example.azuredemo;

import org.junit.After;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.PropertySourcesPlaceholdersResolver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.utility.DockerImageName;

@Ignore
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT )
@Profile("test")
class AzureDemoApplicationTests {

    private MSSQLServerContainer database;

    @Test
    void contextLoads() {
        DockerImageName myImage = DockerImageName.parse("mcr.microsoft.com/mssql/server:2017-latest")
                .asCompatibleSubstituteFor("mcr.microsoft.com/mssql/server");
        database = new MSSQLServerContainer(myImage);
        database.start();

        System.out.println(database.getUsername());
        System.out.println(database.getPassword());
        System.out.println(database.getJdbcUrl());

        System.setProperty("spring.datasource.url", database.getJdbcUrl());

    }

    @After
    public void after() {
        database.close();
    }

}
