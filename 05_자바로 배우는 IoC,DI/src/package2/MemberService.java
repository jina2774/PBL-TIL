package package2;
import role.Role;
import java.util.List;

public class MemberService {
    private final MemberRepository repository;
    public MemberService(MemberRepository repository) { this.repository = repository; }
    public boolean registerMember(Role role) {
        if (repository.isDuplicate(role.getName())) return false;
        repository.save(role); return true;
    }
    public Role searchMember(String name) { return repository.findByName(name); }
    public List<Role> getAllMembers() { return repository.findAll(); }
}