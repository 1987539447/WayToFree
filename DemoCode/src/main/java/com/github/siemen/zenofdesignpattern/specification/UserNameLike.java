package com.github.siemen.zenofdesignpattern.specification;
/**
 * Created by Zhan on 2017-04-19.
 */

/**
 * 业务规格-名字like
 */
public class UserNameLike extends CompositeSpecification {

    private final static String LIKE_FLAG = "%";

    private String likeStr;

    public UserNameLike(String likeStr) {
        this.likeStr = likeStr;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        boolean result = false;
        String name = user.getName();
        String str = this.likeStr.replace(LIKE_FLAG,"");
        if(likeStr.endsWith(LIKE_FLAG) && !likeStr.startsWith(LIKE_FLAG)){//张%
            result = name.startsWith(str);
        }else if(!likeStr.endsWith(LIKE_FLAG) && likeStr.startsWith(LIKE_FLAG)){//%张
            result = name.endsWith(str);
        }else{
            result = name.contains(str);
        }
        return result;
    }
}
