package me.kostyaev;

import me.kostyaev.repository.ICommentDAO;
import me.kostyaev.repository.ICustomerDAO;
import me.kostyaev.repository.IOrderDAO;
import me.kostyaev.repository.ISellerDAO;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Main {

    private final int NUMBER_OF_TESTS = 100;

    @Inject
    private ICommentDAO commentDAO;

    @Inject
    private ICustomerDAO customerDAO;

    @Inject
    private ISellerDAO sellerDAO;

    @Inject
    private IOrderDAO orderDAO;


    @PostConstruct
    private void run() {
        long [] results = new long [NUMBER_OF_TESTS];
        for(int i = 0; i < NUMBER_OF_TESTS; i++ ) {
            results[i] = startTest();
        }

    }

    private long startTest() {
        long startTime = System.nanoTime();
        performDBOperations();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }


    private void performDBOperations() {

    }
}
