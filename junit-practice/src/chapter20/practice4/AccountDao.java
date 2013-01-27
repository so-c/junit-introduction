package chapter20.practice4;

public interface AccountDao {
    
    /**
     * userIdを指定し、アカウント情報を取得する.
     * @param userId システムで一意であるユーザID
     * @return 指定されたユーザのアカウント上位法、存在しない場合はnull
     */
    Account findOrNull(String userId);
}
