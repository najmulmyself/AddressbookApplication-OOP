import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddressGUI {

   public static Address [] records  = new Address[10];
   public static int recordCount = 0;




    public static void main(String[] args) {

        // set up the main frame
        JFrame frame = new JFrame("Address Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);

        //  labels
        JLabel nameLabel = new JLabel("Name:");
        JLabel houseNoLabel = new JLabel("House No:");
        JLabel cityLabel = new JLabel("City:");
        JLabel countryLabel = new JLabel("Country:");
        JButton submitRecord = new JButton("Submit Record");
        JButton seeRecord = new JButton("See Record");
        JButton updateRecord = new JButton("Update Record");
        JButton deleteRecord = new JButton("Delete Record");


        Dialog dialog = new Dialog(frame,"Dialouge");

        //  label positions and sizes
        nameLabel.setBounds(20, 20, 60, 25);
        houseNoLabel.setBounds(20, 50, 60, 25);
        cityLabel.setBounds(20, 80, 60, 25);
        countryLabel.setBounds(20, 110, 60, 25);
//        submitRecord.setBounds(20, 110, 60, 25);
//        seeRecord.setBounds(20, 180, 60, 25);

        //  text fields
        JTextField nameTextField = new JTextField();
        JTextField houseNoTextField = new JTextField();
        JTextField cityTextField = new JTextField();
        JTextField countryTextField = new JTextField();

        // text field positions and sizes
        nameTextField.setBounds(100, 20, 300, 25);
        houseNoTextField.setBounds(100, 50, 300, 25);
        cityTextField.setBounds(100, 80, 300, 25);
        countryTextField.setBounds(100, 110, 300, 25);
        submitRecord.setBounds(100, 150, 300, 25);
        seeRecord.setBounds(100, 200, 300, 25);
        updateRecord.setBounds(100, 250, 300, 25);
        deleteRecord.setBounds(100, 300, 300, 25);



        submitRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (recordCount < records.length) {
                    String name = nameTextField.getText();
                    String houseNo = houseNoTextField.getText();
                    String city = cityTextField.getText();
                    String country = countryTextField.getText();
if(name.isEmpty() || houseNo.isEmpty() || city.isEmpty() || country.isEmpty()){
    JOptionPane.showMessageDialog(frame, "All Field is required");
}else {

    Address address = new Address(name, houseNo, city, country);

    records[recordCount] = address;
    recordCount++;
    JOptionPane.showMessageDialog(frame, "Record Added Successfully");

}

//                    System.out.println("Name: " + address.getName());
//                    System.out.println("House No: " + address.getHouseNo());
//                    System.out.println("City: " + address.getCity());
//                    System.out.println("Country: " + address.getCountry());
                } else {
                    JOptionPane.showMessageDialog(frame, "Record Limit Reached (10 records)");
                }
            }
        });


        seeRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(recordCount == 0){
                    JOptionPane.showMessageDialog(frame, "No Data");

                }else {
                    for (int i = 0; i <= recordCount; i++) {
                        if (records[i] != null) {
                            System.out.println(records[i].getName());
                            System.out.println(records[i].getHouseNo());
                            System.out.println(records[i].getCity());
                            System.out.println(records[i].getCountry());
//                            JFrame frame = new JFrame("Simple Table Example");
//                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                            frame.setSize(400, 300);
//                            Object[][] data = {
//                                    {"John", 25, "New York"},
//                                    {"Emily", 30, "San Francisco"},
//                                    {"Mike", 22, "Chicago"},
//                                    {"Anna", 28, "Los Angeles"}
//                            };
//                            String[] columnNames = {"Name", "Age", "City"};
//                            JTable table = new JTable(data, columnNames);
//
//                            table.setPreferredScrollableViewportSize(new Dimension(400, 200));
//                            table.setFillsViewportHeight(true);
//
//                            JScrollPane scrollPane = new JScrollPane(table);
//
//                            frame.add(scrollPane);

                        }
                    }
                }

            }
        });


        updateRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String houseNo = houseNoTextField.getText();
                String city = cityTextField.getText();
                String country = countryTextField.getText();

                Address address = new Address(name, houseNo, city, country);

                int selectedIndex = -1;
                for (int i = 0; i < recordCount; i++) {
                    if (records[i].getName().equalsIgnoreCase(name)) {
                        selectedIndex = i;
                        break;
                    }
                }

                if (selectedIndex != -1) {
                    records[selectedIndex] = address;
                    JOptionPane.showMessageDialog(frame, "Record Updated Successfully");
                } else {
                    JOptionPane.showMessageDialog(frame, "Record not found");
                }
            }
        });

        deleteRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                int selectedIndex = -1;
                for (int i = 0; i < recordCount; i++) {
                    if (records[i].getName().equalsIgnoreCase(name)) {
                        selectedIndex = i;
                        break;
                    }
                }

                if (selectedIndex != -1) {
                    for (int i = selectedIndex; i < recordCount - 1; i++) {
                        records[i] = records[i + 1];
                    }
                    recordCount--;
                    JOptionPane.showMessageDialog(frame, "Record Deleted Successfully");
                } else {
                    JOptionPane.showMessageDialog(frame, "Record not found");
                }
            }
        });



        // Adding components to the frame
        frame.add(nameLabel);
        frame.add(houseNoLabel);
        frame.add(cityLabel);
        frame.add(countryLabel);

        frame.add(nameTextField);
        frame.add(houseNoTextField);
        frame.add(cityTextField);
        frame.add(countryTextField);
        frame.add(submitRecord);
        frame.add(seeRecord);
        frame.add(updateRecord);
        frame.add(deleteRecord);

//        frame.add(dialog);



        frame.setVisible(true);
    }
}


