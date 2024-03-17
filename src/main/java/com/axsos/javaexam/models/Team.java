package com.axsos.javaexam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name="teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message="Team Name is required!")
    private String teamName;


    @NotEmpty(message="Game Day is required!")
    private String gameDay;

    @NotNull(message="Skill Level is required!")
    @Min(value = 1, message="Skill Level  must be at least 1 characters.")
    @Max(value = 5 ,  message="Skill Level must be at max 5 characters.")
    private int skillLevel;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="teamCreator_id")
    private User teamCreator;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public  Team(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getGameDay() {
        return gameDay;
    }

    public void setGameDay(String gameDay) {
        this.gameDay = gameDay;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public User getTeamCreator() {
        return teamCreator;
    }

    public void setTeamCreator(User teamCreator) {
        this.teamCreator = teamCreator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
