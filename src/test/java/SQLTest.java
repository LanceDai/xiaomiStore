import com.xiaomiStore.dao.OrderDao;
import com.xiaomiStore.dao.ShoppingCartDao;
import com.xiaomiStore.dao.UserDao;
import com.xiaomiStore.pojo.ShoppingCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SQLTest {

    @Autowired
    ShoppingCartDao shoppingCartDao;
    @Autowired
    UserDao userDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserDao userService;

    @Test
    public void test() {
        System.out.println(userService.selectByUserName("lh").toString());
    }

    @Test
    public void shoppingCartMapperTest() {
//        //controllerTest insert
//        for (int i = 0; i < 10; i++) {
//            ShoppingCart shoppingCart = new ShoppingCart(String.valueOf(i * 10 + 1), String.valueOf(i * 100 + 1),
//                    10000 * i + 1, specificationId);
//            shoppingCartDao.insert(shoppingCart);
//        }

        //controllerTest Select
        List<ShoppingCart> shoppingCartList = shoppingCartDao.selectAll();
        assert shoppingCartList.size() == 10;
        System.out.println(shoppingCartList.toString());

        //controllerTest update
        for (ShoppingCart s : shoppingCartList) {
            s.setNumber(999999);
            shoppingCartDao.update(s);
        }

        //controllerTest Select
        shoppingCartList = shoppingCartDao.selectAll();
        System.out.println(shoppingCartList.toString());

        //controllerTest Delete
        for (int i = 0; i < 10; i++) {
            shoppingCartDao.delete(String.valueOf(i * 10 + 1));
        }

        //controllerTest Select
        shoppingCartList = shoppingCartDao.selectAll();
        assert shoppingCartList.size() == 0;
        System.out.println(shoppingCartList.toString());
    }

    @Test
    public void selectUserStatusTest() {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Timestamp> timestampList = userDao.selectTime();
        for (Timestamp time : timestampList) {
            System.out.println(time.getMonth() + 1 + "月" + time.getDate() + "日");
            String date = time.getMonth() + 1 + "月" + time.getDate() + "日";
            map.put(date, map.containsKey(date) ? map.get(date) + 1 : 1);
        }
        System.out.println("map = " + map);
    }


    @Test
    public void selectTimeAndPriceTest() {
        Map<String, Integer> map = new LinkedHashMap<>();
        Map<Timestamp, Map<String, Object>> timestampMapMap = orderDao.selectTimeAndPrice();
        System.out.println(timestampMapMap);
        for (Timestamp time : timestampMapMap.keySet()) {
            System.out.println(time.getMonth() + 1 + "月" + time.getDate() + "日");
            String date = time.getMonth() + 1 + "月" + time.getDate() + "日";
            map.put(date, (Integer)timestampMapMap.get(time).get("sum"));
        }
        System.out.println("map = " + map);
        List<Map<String, String>> list = new ArrayList<>();
        for (String str : map.keySet()) {
            Map<String, String> stringStringMap  = new LinkedHashMap<>();
            stringStringMap.put("buyTime", str);
            stringStringMap.put("price", String.valueOf(map.get(str)));
            list.add(stringStringMap);
        }
        System.out.println("list = " + list);
    }
}
