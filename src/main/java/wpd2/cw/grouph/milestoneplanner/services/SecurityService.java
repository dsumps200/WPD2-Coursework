package wpd2.cw.grouph.milestoneplanner.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
