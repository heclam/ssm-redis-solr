import cn.heclam.entity.User;
import cn.heclam.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
@TransactionConfiguration(defaultRollback = false)
public class TestShiro {

    @Autowired
    protected UserService userService;

    //测试创建用户
    @Test
    public void createUserTest() {
        User user2 = new User("heclam", "123");
        User user3 = new User("abc", "123");
        userService.create(user2);
        userService.create(user3);
    }

    //删除用户信息
    @Test
    public void deleteTest() {
        userService.delete(3L);
    }

    //测试更新用户信息
    @Test
    public void updateUserTest() {
        User user = new User();
        user.setId(2L);
        user.setUsername("abc");
        user.setPassword("123");
        userService.update(user);
    }

    //测试修改密码
    @Test
    public void changePasswordTest() {
        userService.changePassword(2L, "456");
    }
}
