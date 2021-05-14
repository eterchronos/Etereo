package test;

import Ui.ExpenseUi;
import model.DAO.ExpenseDAO;
import model.bean.Expense;

public class ExpenseTest {

	public static void main(String[] args) {
		Expense e = new Expense();
		ExpenseDAO eDAO = new ExpenseDAO();

		ExpenseUi eUi = new ExpenseUi();
		eUi.windowUi();
		//System.out.println(eDAO.select());
	}

}
