package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.CommentDao;
import com.xiaomiStore.pojo.Comment;
import com.xiaomiStore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public int insert(Comment record) {
        return commentDao.insert(record);
    }

    @Override
    public int delete(String commentId) {
        return commentDao.delete(commentId);
    }

    @Override
    public int update(Comment record) {
        return commentDao.update(record);
    }

    @Override
    public List<Comment> selectByUserId(String userId) {
        return commentDao.selectByUserId(userId );
    }
}
