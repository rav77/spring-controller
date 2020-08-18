package home.rav.service;

import home.rav.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Map<Integer, User> usersMap = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger();
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<User> getUsers() {
        logger.info("get all users");
        return usersMap.values().stream().sorted(Comparator.comparingInt(User::getId)).collect(Collectors.toList());

//        List<User> users = new ArrayList<>(usersMap.values());
//        users.sort(Comparator.comparingInt(User::getId));
//        System.out.println(users.stream().max(Comparator.comparingInt(User::getId)));
//        return users;
    }

    public User getUser(int id) {
        logger.info("get user: " + usersMap.get(id));
        return usersMap.getOrDefault(id, null);
    }

    public void addUser(User user) {
        int id = counter.incrementAndGet();
        user.setId(id);
        usersMap.put(id, user);
        logger.info("add user: " + user);
    }

    public void delAllUsers() {
        logger.info("del all users");
        usersMap.clear();
    }

    public User delUser(int id) {
        logger.info("del user: " + usersMap.get(id));
        return usersMap.remove(id);
    }
}
