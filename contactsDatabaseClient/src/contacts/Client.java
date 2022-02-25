package contacts;

import contacts.ContactsServiceStub.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

import javax.swing.*;

import org.apache.axis2.AxisFault;

public class Client extends JFrame implements ActionListener {
	
	private static JButton findButton = new JButton("Search");
	private static JButton editButton = new JButton("Edit");
	private JButton addButton = new JButton("Add");
	private JButton deleteButton = new JButton("Delete");
	
	private static JLabel findLabel = new JLabel("Find:");
	private static JLabel editLabel = new JLabel("Edit Contact:");
	private JLabel addLabel = new JLabel("Add New Contact:");
	private JLabel deleteLabel = new JLabel("Delete Contact:");
	private JLabel contactLabel = new JLabel("Contacts:");
	
	private static JTextField findText = new JTextField(15);
	private static JTextField editText = new JTextField(15);
	private JTextField addText = new JTextField(15);
	
    private JTextArea outputArea = new JTextArea(20, 100);
 		
	public Client() throws Exception  {
		setLayout(new FlowLayout()); 
		
		add(findText);	
		findText.setEditable(true);
		add(findButton);	
		findButton.addActionListener(this);
		
		add(deleteButton);
		deleteButton.addActionListener(this);
		
		add(contactLabel);
		add(outputArea);
		outputArea.setEditable(false);						
	}
	
	public static void main(String[] args) throws Exception {
		Client gui = new Client();
		
		gui.setTitle("Contacts Database");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	    gui.setSize(1000,500);
	    gui.setLocation(300,200);
	
	}
	
	
	public void actionPerformed(ActionEvent event) {
		String trackRows = "";
		ContactDetail[] tracks = null;
		try {
			if (event.getSource() == findButton) {
				tracks = retrieve("firstName", findText.getText());
				
				for (int i = 0; i < tracks.length; i++) {
					ContactDetail trackDetail = tracks[i];
			
					
					trackRows += String.format("%4s %5s %-32s %-10s %-10s %-10s\n",trackDetail.getTelephoneNumber(), 
							trackDetail.getLastname(), trackDetail.getFirstname(),
							trackDetail.getStreet(), trackDetail.getCity(), trackDetail.getPostcode());
					
				}
			}
			else if (event.getSource() == deleteButton) {
					delete(findText.getText());
			}
			else {
				return;
			}
							
			
		} catch (Exception exception) {
			String error = exception.getMessage();
			if (error == null) error = exception.toString();
			error = "could not get tracks - " + error;
			trackRows += error;
		}
		outputArea.setText(trackRows);
	}
	
	
	
	private ContactDetail[] retrieve(String field, String value) throws Exception {
		
		try
		{
			ContactDetail[] tracklist;
			ContactsServiceStub stub = new ContactsServiceStub();
			
			if(field.equals("firstName"))
			{
				ContactsServiceStub.Name requestedArtist = new ContactsServiceStub.Name();
				requestedArtist.setName(value);
				ContactsServiceStub.ContactGroup response = stub.getName(requestedArtist);
				tracklist = extractTracks(response);
				return tracklist;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return null;
	}
	
	private ContactDetail[] extractTracks(ContactGroup tracks)
	{
		ContactDetails track = tracks.getContactGroup();
		ContactDetail[] tracklist = track.getContactlist();
		
		return tracklist;
	}
	
	private void delete(String value) throws Exception {
	
	}
	
	
	
	



}
