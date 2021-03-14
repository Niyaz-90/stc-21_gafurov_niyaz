public class Pet {
    private String id;
    private String nickname;
    private Person person;
    private double weight;

    public Pet(String id, String nickname, Person person, double weight) {
        this.id = id;
        this.nickname = nickname;
        this.person = person;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
