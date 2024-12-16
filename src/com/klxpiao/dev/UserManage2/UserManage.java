package com.klxpiao.dev.UserManage2;

import java.util.*;
/**
 * 用户管理器模版，提供基础的添加、删除以及修改操作。
 */
public class UserManage {
    protected final Map<String, User> allUsers;

    public UserManage(Map<String, User> allUsers) {
        this.allUsers = allUsers;
    }

    /**
     * 添加数个 User 对象到 allUsers。
     *
     * @param users User 对象。
     */
    public void addUsers(User... users) {
        for (User user : users) {
            add(user);
        }
    }

    /**
     * 将记录 User 添加到 allUsers。
     *
     * @param user User 对象。
     * @throws RuntimeException 用户ID已存在时抛出。
     */
    public void add(User user) throws RuntimeException {
        if (allUsers.containsKey(user.id()))
            throw new RuntimeException("用户ID已存在。");

        allUsers.put(user.id(), user);
    }

    /**
     * 将用户从 allUsers 中删除。
     *
     * @param id 用户ID。
     * @throws RuntimeException 用户ID不存在时抛出。
     */
    public void delete(String id) throws RuntimeException {
        if (!allUsers.containsKey(id))
            throw new RuntimeException("用户ID不存在。");

        allUsers.remove(id);
    }

    /**
     * 将记录 User 修改到 allUsers。
     *
     * @param user User 对象。
     * @throws RuntimeException 用户ID不存在时抛出。
     */
    public void modify(User user) throws RuntimeException {
        if (!allUsers.containsKey(user.id()))
            throw new RuntimeException("用户ID不存在。");

        allUsers.put(user.id(), user);
    }
}
