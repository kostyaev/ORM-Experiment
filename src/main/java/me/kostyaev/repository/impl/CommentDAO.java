package me.kostyaev.repository.impl;

import me.kostyaev.models.Comment;
import me.kostyaev.repository.ICommentDAO;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CommentDAO extends HibernateGenericDAO<Comment, Long>
        implements ICommentDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<Comment> getCommentByMessageLonger(String str) {
        return createCriteria()
               .add(Restrictions.ilike("message", "%" + str + "%" ))
               .list();

    }

}