package Week2_JUnitBasicTesting_Exercises.Exercise4_AAA.Code;

public class UserService {
    public boolean isValidUser(String username) {
        return username != null && username.length() > 3;
    }
}
