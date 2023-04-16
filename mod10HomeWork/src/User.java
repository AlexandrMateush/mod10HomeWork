import java.io.Serializable;

public class User {
//    protected long serialVersionUID = 8273462937706058417L;
    private String name;
    private String age;

    @Override
    public String toString() {
        return "User{" +

                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
