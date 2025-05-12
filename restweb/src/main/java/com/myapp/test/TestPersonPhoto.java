package com.myapp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.myapp.model.PersonPhoto;
import com.myapp.util.HibernateUtil;

public class TestPersonPhoto {

	public TestPersonPhoto() {

	}

	public static void main(String[] args) throws FileNotFoundException {
      new TestPersonPhoto().test();
	}

	public void test() throws FileNotFoundException {
		
		Long id=91L;
		String nom="Photo 1";
        String blobPath ="/home/ub18/Downloads/table.pdf";
        //byte[] foto = readBytesFromFile(blobPath);

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	   /* File file = new File(blobPath);
        FileInputStream inputStream = new FileInputStream(file);
        Blob blob = Hibernate.getLobCreator(session).createBlob(inputStream, file.length());
*/      
	    Blob blob = null;
        PersonPhoto p = new PersonPhoto(id,nom,blob);
        //session.delete(p);
	    //session.save(p);
	    Criteria criteria = session.createCriteria(PersonPhoto.class);
		criteria.add(Restrictions.like("nom","%",MatchMode.ANYWHERE));
		List<PersonPhoto> pList = criteria.list();
		for (PersonPhoto var: pList)
		{
			System.out.println(var.toString());	
		}		
	    tx.commit();		
	}
	
    private static byte[] readBytesFromFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(inputFile);
         
        byte[] fileBytes = new byte[(int) inputFile.length()];
        inputStream.read(fileBytes);
        inputStream.close();
         
        return fileBytes;
    }		
	
}
