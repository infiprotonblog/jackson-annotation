package com.jackson.demo.jacksonannotations.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UserDetails.UserDetailsBuilder.class)
public class UserDetails {

    private long userId;

    private String firstName;

    @JsonView({UserViews.ExtendedView.class})
    private String lastName;

    @JsonView({UserViews.ExtendedView.class})
    private Integer age;

    @JsonView({UserViews.ExtendedView.class})
    private String phonenumber;

    private UserDetails(long userId, String firstName, String lastName, Integer age, String phonenumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phonenumber = phonenumber;
    }

    public long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserDetailsBuilder {

        private long userId;

        private String firstName;

        private String lastName;

        private int age;

        private String phonenumber;

        public UserDetailsBuilder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public UserDetailsBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDetailsBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDetailsBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserDetailsBuilder phonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        public UserDetails build() {
            return new UserDetails(userId, firstName, lastName, age, phonenumber);
        }
    }
}
