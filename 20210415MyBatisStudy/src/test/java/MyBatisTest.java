import com.px.mybatis.bean.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    Logger logger = Logger.getLogger(MyBatisTest.class);

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testLog() throws IOException {
        SqlSessionFactory sqlSessionFactory = this.getSqlSessionFactory();
        List<Emp> empList = sqlSessionFactory.openSession().selectList("select * from emp");
        logger.info(empList);
    }
}
