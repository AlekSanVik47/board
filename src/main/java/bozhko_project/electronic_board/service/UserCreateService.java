package bozhko_project.electronic_board.service;

/*

@Service
@RequiredArgsConstructor
@Data
public class UserCreateService {

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final UserMapper userMapper;



	public void createUser(UserCreationDTO request){
		User user = userMapper.userCreationRequestToUser(request);
		User.Role role = User.Role.valueOf("USER");
		User.State state = User.State.valueOf("CONFIRMED");
		user.setLogin(request.getLogin());
		user.setPassword(request.getPassword());
		user.setName(request.getName());
		user.setSurname(request.getSurname());
		user.setEmail(request.getEmail());
		user.setPhone(request.getPhone());
		user.setRole(role);
		user.setState(state);
		userRepository.saveAndFlush(user);
	}

}
*/
