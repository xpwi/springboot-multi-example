package com.xiaopengwei.springboot.hellocontroller;import com.xiaopengwei.springboot.hello.controller.HelloController;import org.junit.Before;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.http.MediaType;import org.springframework.test.context.junit4.SpringRunner;import org.springframework.test.web.servlet.MockMvc;import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;import org.springframework.test.web.servlet.setup.MockMvcBuilders;import static org.hamcrest.Matchers.equalTo;import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;/** * <p> * 测试 HelloController * </p> * * @author github.com/xpwi * @since 2019-04-17 */@RunWith(SpringRunner.class)@SpringBootTestpublic class HelloTest {    //MockMvc对我们的系统的Controller进行单元测试。    private MockMvc mvc;    @Before    public void setUp() throws Exception {        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();    }    @Test    public void getHello() throws Exception {        //测试 /hello 请求是否返回 Hello World        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))                .andExpect(status().isOk())                .andExpect(content().string(equalTo("Hello World")));        System.out.println("\n========== ok! ===========\n");    }}