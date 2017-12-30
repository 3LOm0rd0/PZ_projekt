package com.wat.pl;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {
    @Test
    public void testLogin() {
        String login = "test";
        String pass = "test";

        int expected = 82;
      //  int result = User.Loggin(login, pass);

      //  Assert.assertEquals(result, expected);
    }
    @Test
    public void testLoginFail(){
        String login = "test";
        String pass = "t";
        int expected = -1;
      //  int result = User.Loggin(login, pass);

     //   Assert.assertEquals(result, expected);
    }

}
