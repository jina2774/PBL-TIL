package package1;
import role.*;
import java.io.*;
import java.util.*;

public class MemberRepository {
    private List<Role> members = new ArrayList<>();
    private final String FILE_NAME = "member.txt";

    public void save(Role role) { members.add(role); }
    public Role findByName(String name) {
        for (Role r : members) if (r.getName().equalsIgnoreCase(name)) return r;
        return null;
    }
    public List<Role> findAll() { return new ArrayList<>(members); }
    public boolean isDuplicate(String name) { return findByName(name) != null; }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            members.clear();
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length < 6) continue;
                if (d[1].equals("아기사자")) members.add(new Lion(d[0], d[2], Integer.parseInt(d[3]), d[4], d[5]));
                else members.add(new Staff(d[0], d[2], Integer.parseInt(d[3]), d[4], d[5]));
            }
        } catch (Exception e) { }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Role r : members) {
                bw.write(String.format("%s,%s,%s,%d,%s,%s", r.getName(), r.getRoleName(), r.getMajor(), r.getGeneration(), r.getPart(), r.getStudentId()));
                bw.newLine();
            }
            System.out.println("💾 모든 데이터가 '" + FILE_NAME + "'에 안전하게 저장되었습니다.");
        } catch (IOException e) { }
    }
}