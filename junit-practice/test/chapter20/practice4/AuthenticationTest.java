package chapter20.practice4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class AuthenticationTest {
    public static class アカウントが存在しない場合 {
        Authentication sut;

        @Before
        public void setUp() throws Exception {
            sut = new Authentication();
            sut.accountDao = mock(AccountDao.class);
            when(sut.accountDao.findOrNull("user001")).thenReturn(null);
        }

        @Test
        public void authenticateはnullを返す() throws Exception {
            assertThat(sut.authenticate("user001", "password1234"), is(nullValue()));
        }
    }

    public static class アカウントが存在しパスワードが一致する場合 {
        Authentication sut;
        Account account;

        @Before
        public void setUp() throws Exception {
            sut = new Authentication();
            sut.accountDao = mock(AccountDao.class);
            account = new Account("user001", "password1234");
            when(sut.accountDao.findOrNull("user001")).thenReturn(account);
        }

        @Test
        public void authenticateはaccountを返す() throws Exception {
            assertThat(sut.authenticate("user001", "password1234"), is(account));
        }
    }

    public static class アカウントが存在しパスワードが一致しない場合 {
        Authentication sut;
        Account account;

        @Before
        public void setUp() throws Exception {
            sut = new Authentication();
            sut.accountDao = mock(AccountDao.class);
            account = new Account("user001", "password1234");
            when(sut.accountDao.findOrNull("user001")).thenReturn(account);
        }

        @Test
        public void authenticateはaccountを返す() throws Exception {
            assertThat(sut.authenticate("user001", "password9999"), is(nullValue()));
        }
    }

}
