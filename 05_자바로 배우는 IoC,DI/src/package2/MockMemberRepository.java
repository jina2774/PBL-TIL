package package2;
import role.*;
import java.util.*;

public class MockMemberRepository implements MemberRepository {
    private List<Role> mockData = Arrays.asList(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "202020202"));
    @Override public void save(Role role) { }
    @Override public Role findByName(String name) { return mockData.get(0); }
    @Override public List<Role> findAll() { return mockData; }
    @Override public boolean isDuplicate(String name) { return false; }
}