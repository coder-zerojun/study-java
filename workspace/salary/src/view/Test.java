package view;

import java.io.IOException;

import dao.SalaryDAO;
import domain.SalaryVO;

public class Test {
   public static void main(String[] args) throws IOException {
      SalaryDAO salaryDAO = new SalaryDAO();

      SalaryVO salaryVO = new SalaryVO();
      SalaryVO test1 = new SalaryVO();

      test1.setSalary(15100);
//      test1.setIncomeTax(1000000);
//
//      salaryVO.setSalary(15100);
//      salaryVO.setIncomeTax(1000000);
//      salaryVO.setNetPay(9_000_000);
//      
//      salaryDAO.insert(test1);
//      salaryDAO.insert(test1);

//      salaryDAO.update(salaryVO);
//      salaryDAO.update(test1);

//      salaryDAO.delete(test1);
      salaryDAO.select(3200);
      
//      for (int i = 0; i < salaryDAO.selectAll().size(); i++) {
//         System.out.println(salaryDAO.selectAll().get(i));
//      }

//      System.out.println(salaryDAO.selectAll());
   }
}