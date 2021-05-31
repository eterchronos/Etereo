package test;

import model.DAO.FinancialDAO;
import model.bean.Financial;

public class FinancialTest {



    public static void main(String[] args){
        Financial financial = new Financial();
        FinancialDAO financialDAO = new FinancialDAO();

          financial.setCash(130.00);
          //financialDAO.insert(financial);
        //financialDAO.delete(financial);

        System.out.println(financialDAO.select());





    }


}
