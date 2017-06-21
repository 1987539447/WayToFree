package com.github.siemen.blog.service;

import com.github.siemen.blog.model.Blog;
import com.github.siemen.blog.model.MAV;

/**
 * Created by Zhan on 2017-06-12.
 */
public interface IBlogService {
    MAV showMenu();

    MAV getAdmin();

    MAV setAdmin(String admin);

    MAV post(Blog blog);

    MAV viewBlog(String postId);
}
