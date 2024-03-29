package com.ELearning;

import com.ELearning.DAO.LoginDao;
import com.ELearning.DAO.RegisterDao;
<<<<<<< HEAD
import com.ELearning.Exceptions.GlobalExceptionHandler;
import com.ELearning.Exceptions.InvalidLogin;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.Service.MainServiceImpl;
import com.ELearning.Service.SecurityServiceImp;
import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

=======
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.Service.MainServiceImpl;
import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;
>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
<<<<<<< HEAD
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.BDDMockito.BDDMyOngoingStubbing;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
=======
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


<<<<<<< HEAD

=======
>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private RegisterDao registerDao;

    @Mock
    private LoginDao loginDao;
<<<<<<< HEAD
    
    @InjectMocks
    private GlobalExceptionHandler exp;
    

    @InjectMocks
    private MainServiceImpl mainService;
    
    
    @Mock
    private SecurityServiceImp securityService;

    private RegisterUser user,user1;

    private LoginUser userLogin,userLogin1;

    @BeforeEach
    public void setup(){
    	user = new RegisterUser("abc.xyz12@gmail.com","ABC","XYZ","Abc@Xyz12",3);
    	user1 = new RegisterUser("john.paul12@gmail.com","john","paul","john@paul12",2);

    	userLogin = new LoginUser("abc.xyz12@gmail.com","Abc@Xyz12");
    	userLogin1 = new LoginUser("abc.xyz1@gmail.com","AbcXyz12");
    }
    @Test
    public void givenExistingEmail_whenSaveUser() throws UserAlredyExists {

//        System.out.println(registerDao);
//        System.out.println(user);

        given(registerDao.save(user)).willReturn(user);

//        System.out.println(registerDao);
//        System.out.println(mainService);
=======

    @InjectMocks
    private MainServiceImpl mainService;

    private RegisterUser user;

    private LoginUser userLogin;

    @BeforeEach
    public void setup(){
        user = RegisterUser.builder()
                .userId(1)
                .userName("anci@qwer.in")
                .firstName("abcd")
                .lastName("qwert")
                .pass("Qwert@123")
                .role(2)
                .build();

        userLogin = LoginUser.builder()
                .loginId(1)
                .userName("anci@qwer.in")
                .pass("Qwert@123")
                .build();
    }
    @Test
    public void givenExistingEmail_whenSaveEmployee() throws UserAlredyExists {

        System.out.println(registerDao);
        System.out.println(user);

        given(registerDao.save(user)).willReturn(user);

        System.out.println(registerDao);
        System.out.println(mainService);
>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486

        // when -  action or the behaviour that we are going test
        RegisterUser savedUser = mainService.signUpUser(user);

<<<<<<< HEAD
//        System.out.println(savedUser);
=======
        System.out.println(savedUser);
>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486
        // then - verify the output
        assertThat(savedUser).isNotNull();

    }

    @Test
<<<<<<< HEAD
    public void givenExistingEmail_whenSaveUser_thenThrowsException(){
        // given - precondition or setup
//        given(registerDao.findByUserName(user.getUserName()))
//                .willReturn(user);

//        System.out.println(registerDao);
//        System.out.println(mainService);
        	
        // when -  action or the behaviour that we are going test
      org.junit.jupiter.api.Assertions.assertEquals(exp.userAlredyExists().getBody(),"User already exists");
//        org.junit.jupiter.api.Assertions.assertThrows(UserAlredyExists.class, () -> {
//            mainService.signUpUser(user);
//        });

        // then
//        verify(registerDao, never()).save(any(RegisterUser.class));
=======
    public void givenExistingEmail_whenSaveEmployee_thenThrowsException(){
        // given - precondition or setup
        given(registerDao.findRegisterUserByUserName(user.getUserName()))
                .willReturn(user);

        System.out.println(registerDao);
        System.out.println(mainService);

        // when -  action or the behaviour that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(UserAlredyExists.class, () -> {
            mainService.signUpUser(user);
        });

        // then
        verify(registerDao, never()).save(any(RegisterUser.class));
>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486
    }

    @DisplayName("JUnit test for updateEmployee method")
    @Test
    public void whenUpdateUserPassword_thenReturnUpdatedUserPassword() throws UserNotFound {
        // given - precondition or setup
//

<<<<<<< HEAD
        given(registerDao.findByUserName(user.getUserName()))
                .willReturn(user);
        given(registerDao.findByUserName(user.getUserName()))
        .willReturn(user1);
        given(loginDao.findByUserName(userLogin.getUserName()))
                .willReturn(userLogin);
//        System.out.println(user);
//        System.out.println(userLogin);

        // when -  action or the behaviour that we are going test

        
        LoginUser updatedUser = mainService.changePassword(user.getUserName(),user.getPass());
        // then - verify the output
        assertThat(updatedUser.getPass()).isEqualTo(user.getPass());
=======
        given(registerDao.findRegisterUserByUserName(user.getUserName()))
                .willReturn(user);
        given(loginDao.findLoginUserByUserName(userLogin.getUserName()))
                .willReturn(userLogin);
        System.out.println(user);
        System.out.println(userLogin);

        // when -  action or the behaviour that we are going test

        System.out.println(userLogin.getPass());
        LoginUser updatedUser = mainService.changePassword(user.getUserName(),"Qwert@!2344");
        // then - verify the output
        assertThat(updatedUser.getPass()).isEqualTo("Qwert@!2344");
>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486

    }
    @Test
    public void whenUpdateUserPassword_thenReturnUpdatedUserPassword_thenThrowsException() throws UserNotFound {
//        given(registerDao.findRegisterUserByUserName(user.getUserName()))
//                .willReturn(user);
<<<<<<< HEAD
//        given(loginDao.findByUserName(userLogin1.getUserName()))
//                .willReturn(userLogin1);

        org.junit.jupiter.api.Assertions.assertEquals(exp.userNotFound().getBody(), "User not found");
       

    }
    @Test
    public void whenLoginUser_thenjwtTokenAndLoginDetils_thenThrowsException() {
//    	given(loginDao.findLoginUserByUserNameAndPass(userLogin.getUserName(), user.getPass()))
//      .willReturn(null);
//    	System.out.println(userLogin);
    	
    	
    	 org.junit.jupiter.api.Assertions.assertEquals(exp.invalidLogin().getBody(),"invalid login details");
         
    	
    }
    @Test
    public void whenLoginUser_thenjwtTokenAndLoginDetils() throws InvalidLogin {
    	given(loginDao.findByUserNameAndPass(userLogin.getUserName(), userLogin.getPass()))
        .willReturn(userLogin);
       	
//    	Map<String,String> token = mainService.loginUser(userLogin.getUserName(),userLogin.getPass());
    	
    	given(securityService.getAuthToken(userLogin)).willReturn(new HashMap<String,String>());
    	assertNotNull(mainService.loginUser(userLogin.getUserName(), userLogin.getPass()));
    	    	
=======
//        given(loginDao.findLoginUserByUserName(userLogin.getUserName()))
//                .willReturn(userLogin);

        org.junit.jupiter.api.Assertions.assertThrows(UserNotFound.class, () -> {
            mainService.changePassword("any","any");
        });
>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486

    }




<<<<<<< HEAD

=======
>>>>>>> a017b54f5eb589be4a67b1d476c13f6659180486
}
