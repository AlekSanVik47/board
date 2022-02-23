package bozhko_project.electronic_board.for_board;

public class User {
	private Long id;
	private String nick;
	private String name;
	private String surname;
	private String email;
	private String phone;

	public User(Long id, String nick, String name, String surname, String email, String phone) {
		this.id = id;
		this.nick = nick;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", nick='" + nick + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
