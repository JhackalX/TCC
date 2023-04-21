/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabela;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.TableModel;
/**
 *
 * @author jacka
 */
public class Funcionalidades {

    public static TableModel createObjectDataModel() {
        return new ObjectTableModel<Employee>() {
            @Override
            public Object getValueAt(Employee employee, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return employee.getId();
                    case 1:
                        return employee.getName();
                    case 2:
                        return employee.getPhoneNumber();
                    case 3:
                        return employee.getAddress();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 5;//quantidade de coluna
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Data:";
                    case 1:
                        return "Hora:";
                    case 2:
                        return "Temperatura:";
                    case 3:
                        return "Pressão";
                    case 4:
                        return "altitude";
                }
                return null;
            }
        };
    }
    
    //aqui passa a lista com o objeto
    public static PaginationDataProvider<Employee> createDataProvider() {

        final List<Employee> list = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            Employee e = new Employee();
            e.setId(i);
            e.setName("" + i);
            e.setPhoneNumber(i + "ºC");
            e.setAddress(i + "PA");
            list.add(e);
        }

        return new PaginationDataProvider<Employee>() {
            @Override
            public int getTotalRowCount() {
                return list.size();
            }

            @Override
            public List<Employee> getRows(int startIndex, int endIndex) {
                return list.subList(startIndex, endIndex);
            }
        };
    }

    public static JFrame createFrame() {
        JFrame frame = new JFrame("JTable Pagination example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 200));
        return frame;
    }

}
