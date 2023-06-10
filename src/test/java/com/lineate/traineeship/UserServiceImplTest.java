package com.lineate.traineeship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    private UserService userService;
    @BeforeEach
    void setUp() {
        when(ServiceFactory.createUserService()).thenReturn(new UserServiceImpl());
        userService = ServiceFactory.createUserService();
    }

    @Test
    void createUserWithName() {

        String name = "name";
        User user = userService.createUser(name);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getGroups().contains(new Group(name))).isTrue();

    }

    @Test
    void testCreateUserWithNameAndGroup() {
        Group group = new Group("test");
        String name = "name";
        User user = userService.createUser(name, group);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(group.getUsers().contains(user)).isTrue();
        assertThat(user.getGroups().contains(group)).isTrue();
    }

    @Test
    void createGroup() {
        String groupName = "groupName";
        Group group = userService.createGroup(groupName);
        assertThat(group.getName()).isEqualTo(groupName);
    }

    @Test
    void addUserToGroup() {
        Group group = new Group("group");
        User user = new User("user", group);
        userService.addUserToGroup(user, group);
        System.out.println(group.getUsers());
        assertThat(group.getUsers().contains(user)).isTrue();
    }
}