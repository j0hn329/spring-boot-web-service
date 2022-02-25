package contacts;

import java.sql.*;


public class ContactsService extends ContactsServiceSkeleton  {
	String dbUrl = "jdbc:mysql://localhost:3306/contactsDB";
	String dbClass = "com.mysql.jdbc.Driver";
	String userName = "root", password = "password1&";
	String tableName = "contact";
	
 public contacts.ContactGroup getName(Name name) throws ErrorFault {
	 try {
			ContactDetail[] details = retrieve("firstName", name.getName());
			
			ContactDetails list = new ContactDetails();
			ContactGroup group = new ContactGroup();
			
			list.setContactlist(details);
			group.setContactGroup(list);
			return group;
			
		} catch (Exception exception) {
		String errorMessage = "Request model is malformed - " + exception.getMessage();
		throw (new ErrorFault(errorMessage, exception));
	  }

	}

	private  ContactDetail[] retrieve(String field, String value) throws ErrorFault {	
		try {
			Connection connection = DriverManager.getConnection(dbUrl, userName, password);
			
			String query = "SELECT telephoneNumber, lastName, firstName, address, city, postcode " + "FROM " + tableName + " " + "WHERE " + field
					+ " LIKE '%" + value + "%'";
			
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(query);
			
			result.last();
			int resultCount = result.getRow();
	
			ContactDetail[] trackDetails = new ContactDetail[resultCount];
			result.beforeFirst();
			int resultIndex = 0;

			while (result.next()) {
				
				ContactDetail details = new ContactDetail();
			
				details.setTelephoneNumber(result.getInt("telephoneNumber"));
				details.setLastname(result.getString("lastName"));
				details.setFirstname(result.getString("firstName"));
				details.setStreet(result.getString("address"));
				details.setCity(result.getString("city"));
				details.setPostcode(result.getString("postcode"));
				
				trackDetails[resultIndex++] = details;	
			}
			connection.close();
			return (trackDetails);
				
		} catch (Exception exception) {
			String errorMessage = "database access error - " + exception.getMessage();
			throw (new ErrorFault(errorMessage, exception));
		}	
	}	
	
	private void delete(String value) throws ErrorFault {	
	
		try {
			Connection connection = DriverManager.getConnection(dbUrl, userName, password);
			
			String query = "DELETE " + "FROM " + tableName + " " + "WHERE firstName= " + value;
			
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int result = statement.executeUpdate(query);
	
			connection.close();
				
		} catch (Exception exception) {
			String errorMessage = "database access error - " + exception.getMessage();
			throw (new ErrorFault(errorMessage, exception));
		}
		
	}
	

}
	
	