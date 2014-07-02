package me.kostyaev.repository.impl;

import me.kostyaev.models.Comment;
import me.kostyaev.repository.ICommentDAO;

public class CommentDAO extends HibernateGenericDAO<Comment, Long>
        implements ICommentDAO {


}