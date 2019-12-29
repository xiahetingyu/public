package service;

import com.xiahe.controller.UserController;
import com.xiahe.entity.User;
import com.xiahe.service.UserService;
import com.xiahe.service.UserServiceImp;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class UserTest {

	@Test
	public void userInsertS() {
		UserService service = new UserServiceImp();
		User user = new User();
		user.setUsername("18838947335");
		user.setPassword("root");
		user.setPermission(2);
		service.insert(user);
	}

	@Test
	public void userDeleteS() {
		UserService service = new UserServiceImp();
		User user = new User();
		user.setUsername("18838947335");
		service.delete(user);
	}

	@Test
	public void userUpdate() {
		UserService service = new UserServiceImp();
		User user = new User();
		user.setUsername("18838947335");
		user.setPassword("997304");
		user.setPermission(2);
		service.update(user);
	}

	@Test
	public void userSelectS() {
		UserService service = new UserServiceImp();
		User user = new User();
		user.setUsername("18838947335");
		user = service.select(user);
		System.out.println(user);
	}

	@Test
	public void userSelectsS() {
		UserService service = new UserServiceImp();
		List<User> selects = service.selects();
		for (User user : selects) {
			System.out.println(user);
		}
	}

	@Test
	public void isOccupy() {
		UserService service = new UserServiceImp();
		User user = new User();
		user.setUsername("18838947333");

		Map<String, Object> occupy = service.isOccupy(user);
		System.out.println(occupy);

		UserController controller = new UserController();
		occupy = controller.isOccupy(user);
		System.out.println(occupy);
	}

}
