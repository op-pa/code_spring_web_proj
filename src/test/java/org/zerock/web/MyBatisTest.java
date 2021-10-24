package org.zerock.web;

import java.sql.Connection;

import javax.sql.DataSource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class MyBatisTest {
	
	//SqlSessionFactory ��ü�� �ڵ����� ����
	@Inject
	private SqlSessionFactory sqlFactory;
	
	//SqlSessionFactory ��ü�� ����� ����������� Test
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}
	
	//MyBatis�� Mysql ������ ����� ����Ǿ����� Test
	@Test
	public void testSession() throws Exception{
		try(SqlSession session = sqlFactory.openSession()){
			System.out.println(session);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}