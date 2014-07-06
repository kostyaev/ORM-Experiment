package me.kostyaev;

import me.kostyaev.models.Comment;
import me.kostyaev.models.Customer;
import me.kostyaev.models.Order;
import me.kostyaev.models.Seller;
import me.kostyaev.repository.ICommentDAO;
import me.kostyaev.repository.ICustomerDAO;
import me.kostyaev.repository.IOrderDAO;
import me.kostyaev.repository.ISellerDAO;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.List;

@Startup
@Singleton
public class Main {

    private final int NUMBER_OF_TESTS = 10;

    private static Logger logger = Logger.getLogger(Main.class);

    @Inject
    private ICommentDAO commentDAO;

    @Inject
    private ICustomerDAO customerDAO;

    @Inject
    private ISellerDAO sellerDAO;

    @Inject
    private IOrderDAO orderDAO;


    @PostConstruct
    private void run() throws InterruptedException {
        logger.info("STARTING TESTS");

        long time1 = startFindByIdTest();
        logger.info("AVERAGE find by id time IS: " + time1 + " ms");

        long time2 = startFindByField();
        logger.info("AVERAGE find by field time IS: " + time2 + " ms");
    }

    private long startFindByIdTest() {
        long sumTime = 0;
        long startTime;
        long endTime;
        for(int i = 0; i < NUMBER_OF_TESTS; i++ ) {
            startTime = System.nanoTime();
            findById(i);
            endTime = System.nanoTime();
            sumTime += endTime - startTime;
        }
        return sumTime / NUMBER_OF_TESTS / 1000000;
    }

    private long startFindByField() {
        long sumTime = 0;
        long startTime;
        long endTime;
        for(int i = 0; i < NUMBER_OF_TESTS; i++ ) {
            startTime = System.nanoTime();
            findByField("Black", true, "own");
            endTime = System.nanoTime();
            sumTime += endTime - startTime;
        }
        return sumTime / NUMBER_OF_TESTS / 1000000;
    }


    private void findById(long id) {
        Customer customer = customerDAO.findById((long)id, false);
        Order order = orderDAO.findById((long)id, false);
        Seller seller = sellerDAO.findById((long)id, false);
        Comment comment = commentDAO.findById((long)id, false);
    }

    private void findByField(String lastname, boolean payed, String str) {
        List<Customer> customers = customerDAO.getByLastName(lastname);
        List<Seller> sellers = sellerDAO.getByLastName(lastname);
        List<Order> orders = orderDAO.getOrderByPayed(payed);
        List<Comment> comments = commentDAO.getCommentByMessageLonger(str);
    }
}
