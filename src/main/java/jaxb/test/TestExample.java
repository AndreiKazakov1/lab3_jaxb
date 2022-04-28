package jaxb.test;


import jaxb.model.Department;
import jaxb.model.Employee;
import jaxb.model.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//Задание: Добавить Корневой элемент Организации и создать перечень
// департаментов со своими уникальными сотрудниками.
public class TestExample {
    private static final String XML_FILE = "org-info.xml";

    public static void main(String[] args) {

        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "M01");
        Employee emp3 = new Employee("E03", "John", null);

        Employee emp4 = new Employee("E04", "Jack", "M04");
        Employee emp5 = new Employee("E05", "Bob", null);
        Employee emp6 = new Employee("E06", "Allan", "M05");


        List<Employee> list_1e = new ArrayList<Employee>();
        list_1e.add(emp1);
        list_1e.add(emp2);
        list_1e.add(emp3);

        List<Employee> list_2e = new ArrayList<>();
        list_2e.add(emp4);
        list_2e.add(emp5);
        list_2e.add(emp6);

        Department dept_1 = new Department("D01", "ACCOUNTING", "NEW YORK");
        Department dept_2 = new Department("D02","TRANSPORT","BOSTON");
        List<Department> list_1d = new ArrayList<Department>();
        list_1d.add(dept_1);
        list_1d.add(dept_2);

        dept_1.setEmployees(list_1e);
        dept_2.setEmployees(list_2e);

        Organization org_1 = new Organization("ORG1","FAR AWAY","USA");
        List<Organization> list_1o = new ArrayList<Organization>();
        list_1o.add(org_1);

        org_1.setDepartments(list_1d);



        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Organization.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(org_1, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(org_1, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());

// (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.


            Organization orgFromFile = (Organization) um.unmarshal(new FileReader(XML_FILE));

            List<Department> dept = orgFromFile.getDepartments();

            System.out.println("OrgName: "+orgFromFile.getOrgName());
            for (Department d: dept){
                System.out.println("deptNo: "+d.getDeptNo()+" "+"deptName: "+d.getDeptName()+" "+"deptLocation: "+d.getLocation());
                for (Employee e: d.getEmployees()){
                        System.out.println("empNO: " + e.getEmpNo()+ " " + "empName: " + e.getEmpName());
                    }
                }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}



