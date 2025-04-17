// SeatingViewGUI.java
// View seating arrangements

import java.sql.*;
import javax.swing.*;

public class SeatingViewGUI extends JFrame {
    public SeatingViewGUI() {
        setTitle("Seating Plan View");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setBounds(20, 20, 340, 200);
        add(area);

        JButton pdfBtn = new JButton("Export to PDF");
        pdfBtn.setBounds(120, 230, 150, 30);
        add(pdfBtn);

        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Seating");
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("Reg No: ").append(rs.getString("reg_no"))
                  .append(" | Room: ").append(rs.getString("classroom"))
                  .append(" | Seat: ").append(rs.getInt("seat_number")).append("\n");
            }
            area.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
