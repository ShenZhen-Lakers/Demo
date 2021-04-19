import com.zql.bean.Emp;
import com.zql.config.DbConfig;
import com.zql.config.PropertiesConfig;
import com.zql.dao.EmpDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zql.config.MyAppConfig;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyAppConfig.class, DbConfig.class, PropertiesConfig.class})
public class SpringTest {
    @Autowired
    private EmpDao empDao;

    @Test
    public void test() {
        List<Emp> emps = empDao.selectAll();
        List<Emp> emp = empDao.selectOne(10);
        System.out.println(emp.toString());
        emps.forEach(e -> {
            System.out.println(e.toString());
        });
    }
}
