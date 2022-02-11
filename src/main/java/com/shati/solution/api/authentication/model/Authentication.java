package com.shati.solution.api.authentication.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auth_sequence_id")
    @SequenceGenerator(name = "auth_sequence_id", sequenceName = "auth_sequence_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn
    private User userId;
    @Column
    private String authToken;
    @Column
    private String channelInitials;
    @Column
    private String status;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime updateDate;

    public Authentication() {
    }

    public Authentication(Long id, User userId, String authToken, String channelInitials, String status, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.userId = userId;
        this.authToken = authToken;
        this.channelInitials = channelInitials;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getChannelInitials() {
        return channelInitials;
    }

    public void setChannelInitials(String channelInitials) {
        this.channelInitials = channelInitials;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
