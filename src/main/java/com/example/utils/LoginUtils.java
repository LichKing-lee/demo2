package com.example.utils;

import com.example.model.User;

/**
 * Created by LichKing on 2016. 12. 1..
 */
public class LoginUtils {
    public static boolean isValidLoginUser(Object sessionUser, Long id){
        if(!hasLoginUser(sessionUser)){
            return false;
        }

        User dbUser = (User) sessionUser;
        if(!dbUser.isEqualsId(id)){
            return false;
        }

        return true;
    }

    public static boolean hasLoginUser(Object sessionUser){
        return sessionUser != null;
    }
}
