package examples;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

	private Map<String, Contact> book;
	
	public PhoneBook() {
		book = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
	}
	
	public void addContact(String name, Contact contact) {
		if (contact != null) {
			contact.name = name;
		}
		book.put(name, contact);
	}
	
	public void printContact(String name) {
		if (!book.containsKey(name)) {
			System.out.println("Contact not found!");
		} else {
			System.out.println(book.get(name));
		}
	}
	
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBook();		
		pb.addContact("Hasib", new Contact(62500745, "hasib.salkic@bitcamp.ba", "Pitaj Hajru bb"));
		pb.addContact("Nijaz", new Contact(62500745, "nijaz.salkic@bitcamp.ba", "Pitaj Hasiba bb"));
		pb.addContact("Ekrem", new Contact(null, null, null));
		pb.addContact("Zaid", null);
		
		pb.printContact("Nijazz");
		
		Contact c1 = new Contact(62500745, "nijaz.salkic@bitcamp.ba", "Pitaj Hasiba bb");
		System.out.println(c1.equals(c1));
	}

	@Override
	public String toString() {
		return book.toString();
	}

	static class Contact {
		String name;
		Integer number;
		String email;
		String address;
		
		public Contact(Integer number, String email, String address) {
			super();
			this.number = number;
			this.email = email;
			this.address = address;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result
					+ ((number == null) ? 0 : number.hashCode());
			return result;
		}



		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (this.getClass() != obj.getClass())
				return false;
			Contact other = (Contact) obj;
			if (!address.equals(other.address))
				return false;
			if (!email.equals(other.email))
				return false;
			if (!name.equals(other.name))
				return false;
			if (!number.equals(other.number))
				return false;
			return true;
		}



		@Override
		public String toString() {
			return number + "(" + email + ")";
		}
	}
}
