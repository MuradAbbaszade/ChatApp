package com.company.ChatApp.dto;

public class FriendDTO {

    private int id;
    private int userId;
    private int friendId;

    public FriendDTO() {
        
    }

    public FriendDTO(int id, int userId, int friendId) {
        this.id = id;
        this.userId = userId;
        this.friendId = friendId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }
}
