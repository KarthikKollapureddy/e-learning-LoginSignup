package com.ELearning;

import com.ELearning.DAO.LoginDao;
import com.ELearning.DAO.RegisterDao;
import com.ELearning.Exceptions.UserAlredyExists;
import com.ELearning.Exceptions.UserNotFound;
import com.ELearning.Service.MainServiceImpl;
import com.ELearning.model.LoginUser;
import com.ELearning.model.RegisterUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private RegisterDao registerDao;

    @Mock
    private LoginDao loginDao;

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

        // when -  action or the behaviour that we are going test
        RegisterUser savedUser = mainService.signUpUser(user);

        System.out.println(savedUser);
        // then - verify the output
        assertThat(savedUser).isNotNull();

    }

    @Test
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
    }

    @DisplayName("JUnit test for updateEmployee method")
    @Test
    public void whenUpdateUserPassword_thenReturnUpdatedUserPassword() throws UserNotFound {
        // given - precondition or setup
//

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

    }
    @Test
    public void whenUpdateUserPassword_thenReturnUpdatedUserPassword_thenThrowsException() throws UserNotFound {
//        given(registerDao.findRegisterUserByUserName(user.getUserName()))
//                .willReturn(user);
//        given(loginDao.findLoginUserByUserName(userLogin.getUserName()))
//                .willReturn(userLogin);

        org.junit.jupiter.api.Assertions.assertThrows(UserNotFound.class, () -> {
            mainService.changePassword("any","any");
        });

    }




}
