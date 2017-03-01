/**
 * 
 */
package com.github.siemen.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

import com.github.siemen.model.Address;
import com.github.siemen.model.Students;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ����
 *
 */
public class StudentsTest {

	private SessionFactory sessionFactory;
	private Session session;
	private StandardServiceRegistry registry;
	private Transaction transaction;

	@Before
	public void init(){
		Configuration config = new Configuration().configure();
		registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	@Test
	public void saveStudents() throws Exception{
		Students student = new Students(1, "张三", "男", new Date(), "北京");
		session.save(student);
	}
	
	@Test
	public void writeBlob() throws Exception{
		Students student = new Students(1, "张三", "男", new Date(), "北京");
		File f = new File("d:"+File.separator+"AA.jpg");
		FileInputStream fin = new FileInputStream(f);
		Blob img = Hibernate.getLobCreator(session).createBlob(fin, fin.available());
		student.setPicture(img);
		session.save(student);
	}
	
	@Test
	public void readBlob() throws Exception{
		Students student = session.get(Students.class, 1);
		Blob img = student.getPicture();

		InputStream in = img.getBinaryStream();
		File f = new File("d:"+File.separator+"BB.jpg");
		FileOutputStream fout = new FileOutputStream(f);
		byte[] buff = new byte[in.available()];
		in.read(buff);
		fout.write(buff);
		in.close();
		fout.close();
	}
	
	@Test
	public void componet() throws Exception{
		Students student = new Students(1, "张三", "男", new Date(), "北京");
		Address contact = new Address("1231", "南京路", "123124");
		student.setContact(contact);
		session.save(student);
	}
	
	@Test
	public void getStudent(){
		Students stu = session.get(Students.class, 1);
		System.out.println(stu.toString());
	}
	
	@Test
	public void loadStudent(){
		Students stu = session.load(Students.class, 1);
		System.out.println(stu.toString());
	}
	
	@Test
	public void updateStudent(){
		Students stu = session.get(Students.class, 1);
		stu.setGender("Ů");
		session.update(stu);
		
	}
	
	@Test
	public void deleteStudent(){
		Students stu = session.load(Students.class, 1);
		session.delete(stu);
	}
	
	@After
	public void destory(){
		transaction.commit();
		session.close();
		sessionFactory.close();
		StandardServiceRegistryBuilder.destroy(registry);
		
	}
	
	
}
