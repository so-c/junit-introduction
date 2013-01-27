package chapter20.practice4;

public class Authentication {
    AccountDao accountDao;

    public Account authenticate(String userId, String password) {
        assert accountDao != null;
        
        Account account = accountDao.findOrNull(userId);
        
        if (account == null) {
            return null;
        }
        
        if (password.equals(account.getPassword())) {
            return account;
        } else {
            return null;
        }
    }
}
