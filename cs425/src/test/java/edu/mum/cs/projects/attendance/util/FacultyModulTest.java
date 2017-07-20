package edu.mum.cs.projects.attendance.util;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import edu.mum.cs.application.WebSecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebSecurityConfig.class)
public class FacultyModulTest {
	
	@Autowired
    private WebApplicationContext wac;
    
	private MockMvc mockMvc;
    
		
	@Test
	public void testHomeController() throws Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
        
	       ResultMatcher ok = MockMvcResultMatchers.status().isOk();
	       ResultMatcher msg = MockMvcResultMatchers.model()
	                           .attribute("msg", "Home page");

	       MockHttpServletRequestBuilder builder2 = MockMvcRequestBuilders.get("/");
	       this.mockMvc.perform(builder2)
	                   .andExpect(ok)
	                   .andExpect(msg);
	    }
}
