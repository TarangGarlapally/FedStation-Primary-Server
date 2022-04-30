package com.fedstation.FedStation;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fedstation.FedStation.entity.Project;
import com.fedstation.FedStation.entity.UserDetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;


@SpringBootTest(classes = FedStationPrimaryServerApplication.class, 
    webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebAppControllerIntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCorrectGetProject() 
    {
        assertTrue(
            this.restTemplate
            .getForObject("http://localhost:" + port + "/getProject/test-project", Project.class)
            .getProjectName().equals("Test Project"));
    }

    @Test
    public void testInCorrectGetProject() 
    {
        assertTrue(
            !this.restTemplate
            .getForObject("http://localhost:" + port + "/getProject/test-project", Project.class)
            .getProjectDescription().equals("Test Project"));
    }

    @Test
    public void testCorrectProjectIdExists() 
    {
        assertTrue(
            this.restTemplate
            .getForObject("http://localhost:" + port + "/projectIdExists?projectId=test-project", Boolean.class)
            == true);
    }

    @Test
    public void testInCorrectProjectIdExists() 
    {
        assertTrue(
            this.restTemplate
            .getForObject("http://localhost:" + port + "/projectIdExists?projectId=testproject", Boolean.class)
            == false);
    }

    @Test
    public void testCorrectUserDetails() 
    {
        assertTrue(
            this.restTemplate
            .getForObject("http://localhost:" + port + "/userDetails?userId=testuser2", UserDetail.class)
            .getFname().equals("Test"));
    }


    @Test
    public void testInCorrectUserDetails() 
    {
        assertTrue(
            !this.restTemplate
            .getForObject("http://localhost:" + port + "/userDetails?userId=testuser2", UserDetail.class)
            .getFname().equals("Hey"));
    }
    
}
