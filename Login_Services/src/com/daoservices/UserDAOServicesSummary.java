package com.daoservices;

import com.bean.User;

public interface UserDAOServicesSummary {
	int insertUserData(User U);
	User checkUsername(String username);
	boolean checkPassword(String pass);
	boolean checkSecurityQue(String username ,String securityQue);
	boolean checkSecurityAns(String username ,String securityAns);
	int changePassword(String username, String pass);
}
