package package1;
import role.Role;
import java.util.List;

public class MemberService {
    private MemberRepository repository = new MemberRepository();
    public MemberService() { repository.loadFromFile(); }
    public boolean registerMember(Role role) {
        if (repository.isDuplicate(role.getName())) return false;
        repository.save(role); return true;
    }
    public Role searchMember(String name) { return repository.findByName(name); }
    public List<Role> getAllMembers() { return repository.findAll(); }
    public void exit() { repository.saveToFile(); }
}