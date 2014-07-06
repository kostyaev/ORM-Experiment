package me.kostyaev.repository;

import me.kostyaev.models.Comment;

import java.util.List;

public interface ICommentDAO extends GenericDAO<Comment, Long> {

    List<Comment> getCommentByMessageLonger(String str);


}
