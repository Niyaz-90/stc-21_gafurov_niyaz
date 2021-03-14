import java.util.HashMap;
import java.util.Map;

public class ArchiveImpl implements Archive {
    private Map<K,V> archiveMap;//коллекция - мапа или arraylist

    public ArchiveImpl() {
        this.archiveMap = new HashMap<>();
    }

    @Override
    public boolean addPet(Pet pet) {
        archiveMap.

        return false;
    }
    // TODO: 14.03.2021
    //  1)переопределить toString()(нужен для findByNicname()  и printAll());
    //  2)также переопределить equals() , hashCode(), compareTo()(для сортировки)
    //  3) параметризовать ArchiveMap
    //  4) K - кличка

    @Override
    public Pet findByNickName(String nickName) {
        return null;
    }

    @Override
    public boolean modifyById(int id) {
        return false;
    }

    @Override
    public void printAllSorted() {

    }
}
