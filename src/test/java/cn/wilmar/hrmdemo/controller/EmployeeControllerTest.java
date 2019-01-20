package cn.wilmar.hrmdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {
    @Autowired
    WebApplicationContext context;
    @Autowired
    EmployeeController employeeController;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void createEmployee() throws Exception {
        mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"employeeName\":\"test1\",\"salary\":5080,\"jobNum\":\"00011\"}")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getEmployeeBySearchKey() {
        assertEquals("00010", employeeController.getEmployeeBySearchKey("0001").get(1).getJobNum());
    }
}