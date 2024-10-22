package com.springtools.swaggerexample.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author ALLOUM on 06/11/2019
 */

@RestController
@RequestMapping("/rest/user")
@Api(value="User Resource REST Endpoint", description = "Shows the user info")
public class UserResource {

    @GetMapping
    public List<User> getUsers(){
        return Arrays.asList(new User("Abderr",2000L), new User("ALLOUM",1000L));
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") final String userName){
        return new User(userName, 1000L);
    }

    private class User{

        @ApiModelProperty(notes = "name of the User")
        private String userName;
        @ApiModelProperty(notes="salary of the user")
        private Long salary;

        public User(String userName, Long salary) {
            this.userName = userName;
            this.salary = salary;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getSalary() {
            return salary;
        }

        public void setSalary(Long salary) {
            this.salary = salary;
        }
    }
}
