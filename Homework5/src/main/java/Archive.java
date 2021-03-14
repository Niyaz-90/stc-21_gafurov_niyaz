public interface Archive {
    boolean addPet(Pet pet);
    Pet findByNickName(String nickName);
    boolean modifyById(int id);
    void printAllSorted();
}
