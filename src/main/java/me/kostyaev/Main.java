package me.kostyaev;

import me.kostyaev.repository.ICommentDAO;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Main {

    @Inject
    private ICommentDAO commentDAO;


}
