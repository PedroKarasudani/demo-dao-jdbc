package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDeparmentDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller findAll ===");
        List<Seller> list2 = sellerDao.findAll();
        list2.forEach(System.out::println);

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(3);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 6: department delete ===");
//      sellerDao.deleteById(2);
        System.out.println("Delete completed");

        System.out.println("=== TEST 7: department findById ===");
        department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TEST 8: department findAll ===");
        List<Department> listDepartment = departmentDao.findAll();
        for (Department dep : listDepartment) {
            System.out.println(dep);
        }

        System.out.println("\n=== TEST 9: department insert ===");
        Department newDepartment = new Department(null, "Limpeza");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! new id = " + newDepartment.getId());

        System.out.println("\n=== TEST 10: department update ===");
        department = departmentDao.findById(2);
        department.setName("Seguranca");
        departmentDao.update(department);
        System.out.println("Update completed");
    }
}