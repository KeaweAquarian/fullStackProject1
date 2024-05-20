package com.keaweaquarian.fullStackProject1.entities;

import com.keaweaquarian.fullStackProject1.entities.user.User;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Assignment {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String status;
 private String githubURL;
private String codeReviewURL;
private String branch;
@ManyToOne(optional = false)
private User user;
// private User assigedTo;
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}
public String getGithubURL() {
    return githubURL;
}
public void setGithubURL(String githubURL) {
    this.githubURL = githubURL;
}
public String getCodeReviewURL() {
    return codeReviewURL;
}
public void setCodeReviewURL(String codeReviewURL) {
    this.codeReviewURL = codeReviewURL;
}
public String getBranch() {
    return branch;
}
public void setBranch(String branch) {
    this.branch = branch;
}
public User getUser() {
    return user;
}
public void setUser(User user) {
    this.user = user;
}


}
