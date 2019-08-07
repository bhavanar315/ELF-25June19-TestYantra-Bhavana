package com.tyss.HibernateMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.tyss.HibernateMapping.hibernateimpl.HibernateImpl;
import com.tyss.HibernateMapping.onetoone.dto.EmpolyeeInfoBean;

public class ManyToOneforManangerId {

	public static void main(String[] args) throws ParseException {
		HibernateImpl impl = new HibernateImpl();
		EmpolyeeInfoBean bean = impl.getEmpolyeeInfoBeanById(3);
		EmpolyeeInfoBean mngr = impl.getEmpolyeeInfoBeanById(1);
		bean.setManagerid(mngr);
		impl.creatEmployeeBean(bean);

	}

}
