package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("---------- Test 1: findById ----------");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println();
        System.out.println("---------- Test 2: findAll ----------");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println();
        System.out.println("---------- Test 3: insert ----------");
        Department newDepartment =  new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment .getId());

        System.out.println();
        System.out.println("---------- Test 4: update ----------");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");


        System.out.println();
        System.out.println("---------- Test 5: delete ----------");
        System.out.print("Quantos IDs você deseja deletar? ");
        int n = sc.nextInt();
        int sum = 0;
        int id = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter id for delete test: ");
            id = sc.nextInt();
            departmentDao.deleteById(id);
            sum += i;
        }
        System.out.println("Delete completed, quantity deleted: " + sum);


        sc.close();
    }
}
