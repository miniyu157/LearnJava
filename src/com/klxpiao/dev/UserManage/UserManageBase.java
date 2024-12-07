package com.klxpiao.dev.UserManage;

import java.util.*;

public abstract class UserManageBase<T extends Record> {
    protected final List<T> allUsers;

    public UserManageBase(List<T> allUsers) {
        this.allUsers = allUsers;
    }

    /**
     * Add user.
     */
    public abstract void add();

    /**
     * Query user.
     */
    public abstract void query();

    /**
     * Modify user.
     */
    public abstract void modify();

    /**
     * Delete user.
     */
    public abstract void delete();
}
