package com.internshala.javaapp;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class table {
		JFrame f;
		// Table
		JTable j;
		table(String[][]ans)
		{
			// Frame initiallization
			f = new JFrame();

			// Frame Title
			f.setTitle("JTable Example");

			// Column Names
			String[] columnNames = { "Brand","Price" };

			// Initializing the JTable
			j = new JTable(ans, columnNames);
			j.setBounds(30, 40, 200, 300);

			// adding it to JScrollPane
			JScrollPane sp = new JScrollPane(j);
			f.add(sp);
			// Frame Size
			f.setSize(500, 200);
			// Frame Visible = true
			f.setVisible(true);
		}

		// Driver  method

}
