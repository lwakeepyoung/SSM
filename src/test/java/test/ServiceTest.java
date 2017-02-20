package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

public class ServiceTest extends BaseJunit4Test{
	@Resource
	private UserService userService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testInsertUserAssign(){
		User user = new User();
		user.setNickname("lalala");
		user.setState(1);
		userService.insertUser(user);
	}
}
