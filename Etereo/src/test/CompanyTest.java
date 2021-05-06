package test;

import model.DAO.CompanyDAO;
import model.bean.Company;

public class CompanyTest {

	public static void main(String[] args) {
		Company c = new Company();
		CompanyDAO cDAO = new CompanyDAO();
		c.setRazaoSocial("Le Cirque Amar");
		c.setCidade("Bahia");
		c.setUf("BA");
		c.setId(4);
		
		cDAO.update(c);
		System.out.println(cDAO.select());
		
		
		
	}

}
