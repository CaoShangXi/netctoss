package com.tarena.netctoss.test;

import org.junit.Test;

import com.tarena.netctoss.AccountDAO;
import com.tarena.netctoss.impl.AccountDAOImpl;

public class TestImpl {
	@Test
	public void testImplement(){
		AccountDAO ad=new AccountDAOImpl();
	    AccountDAOImpl adl=new AccountDAOImpl();
	    System.out.println(ad.getClass());
	    System.out.println(adl.getClass());
	}
}
