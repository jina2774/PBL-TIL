package package2;
import role.Role;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private List<Role> store = new ArrayList<>();
    @Override public void save(Role role) { store.add(role); }
    @Override public Role findByName(String name) {
        for (Role r : store) if (r.getName().equalsIgnoreCase(name)) return r;
        return null;
    }
    @Override public List<Role> findAll() { return new ArrayList<>(store); }
    @Override public boolean isDuplicate(String name) { return findByName(name) != null; }
}