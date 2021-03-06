package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.UserAccount;

public interface UserAccountDAO {
	public String insertAccount(UserAccount account);
	public List<UserAccount> getAllAccounts();
	public Boolean updateAccountById(String id, UserAccount account);
	public UserAccount getAccountById(String id);
	public UserAccount getAccountByUsername(String username);
	public Boolean deleteAccountById(String id);
	public Boolean deleteAccountByUsername(String username);
}
