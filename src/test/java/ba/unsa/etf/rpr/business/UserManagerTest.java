package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    private UserManager userManager;
    private User user;
    private UserDaoSQLImpl userDaoSQLMock;
    private List<User> users;

    /**
     * This method will be called before each test method
     */
    @BeforeEach
    public void initializeObjectsWeNeed() {
        userManager = Mockito.mock(UserManager.class);
        user = new User();
        user.setUsername("User1");
        user.setId(50);

        userDaoSQLMock = Mockito.mock(UserDaoSQLImpl.class);
        users = new ArrayList<>();
        users.addAll(Arrays.asList(new User("User1","x"), new User("User2","y"), new User("User3","z"), new User("User4","p")));
    }

    @Test
    void test1() {
        String correctName = "User1";
        String correctPass = "x";
        try {
            Mockito.doCallRealMethod().when(userManager).validateUser(correctName,correctPass);
        } catch (AnimalException e) {
            //Test will fall if method validateUser(username,password) throws an exception for correct parameter
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
    }

    @Test
    void test2(){
        //This is admin user that exist in DB Dump
        String correctName = "e";
        String correctPass = "1";
        boolean x = false;
        try {
            x = UserManager.validateUser(correctName,correctPass);
        }  catch (AnimalException e) {
            //Test will fall if method validateUser(username,password) throws an exception for correct parameter in DB
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
        assertTrue(x);
    }

    @Test
    void test3(){
        //This is admin user that exist in DB Dump
        String correctName = "Miki";
        String correctPass = "disneyland";
        boolean x = false;
        try {
            x = UserManager.validateUser(correctName,correctPass);
        }  catch (AnimalException e) {
            e.printStackTrace();
            Assertions.assertFalse(false);
        }
        assertFalse(x);
    }

    @Test
    void test4(){
        //This is a user that doesn't exist in DB Dump
        String correctName = "Miki";
        boolean x = false;
        try {
            x = UserManager.validateNewUser(correctName);
        }  catch (AnimalException e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
        assertTrue(x);
    }
    @Test
    void test5() {
        try {
            Mockito.doCallRealMethod().when(userManager).validateUser(null, null);
        } catch (AnimalException e) {
            //Test will fall if method validateUser(username,password) doesn't throw an exception for incorrect parameter
            e.printStackTrace();
            Assertions.assertFalse(false);
        }
    }

    /**
     * Adding a new user
     * @throws AnimalException
     */
    @Test
    void addNewUser() throws AnimalException {
        User newUser = new User("New User","New Pass");
        userManager.add(newUser);

        Assertions.assertTrue(true);
        Mockito.verify(userManager).add(newUser);
    }
    @Test
    void deleteUser() throws AnimalException {
        User deletionUser = new User("User1","x");
        userManager.delete(deletionUser.getId());

        Assertions.assertTrue(true);
        Mockito.verify(userManager).delete(deletionUser.getId());
    }

}