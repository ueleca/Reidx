package com.uele.reidx.android.data;

public class UserTest implements Comparable<UserTest> {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String profileImage;

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getLasttName() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public int compareTo(UserTest user) {
        return this.getUsername().compareTo(user.getUsername());
    }

    @Override
    public boolean equals(Object o) {
        return this.getUsername().equals(((UserTest) o).getUsername());
    }
}