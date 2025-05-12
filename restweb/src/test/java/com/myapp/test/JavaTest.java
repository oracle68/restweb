package com.myapp.test;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public final class JavaTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TestService testSubject;

    @SuppressWarnings("deprecation")
	@Test
    public void test() {
    	//String sql = "SELECT COUNT(*) FROM PRODUCTS";
        //given
        when(testSubject.check2()).thenReturn(16);

        //when
        long result = testSubject.check2();

        //then
        Assert.assertEquals(result, 17);
    }
}